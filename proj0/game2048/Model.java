package game2048;

import java.util.Arrays;
import java.util.Formatter;
import java.util.Observable;
import java.util.Stack;


/** The state of a game of 2048.
 *  @author TODO: Maksat Jazbay
 */
public class Model extends Observable {
    /** Current contents of the board. */
    private final Board _board;
    /** Current score. */
    private int _score;
    /** Maximum score so far.  Updated when game ends. */
    private int _maxScore;
    /** True iff game is ended. */
    private boolean _gameOver;

    /* Coordinate System: column C, row R of the board (where row 0,
     * column 0 is the lower-left corner of the board) will correspond
     * to board.tile(c, r).  Be careful! It works like (x, y) coordinates.
     */

    /** Largest piece value. */
    public static final int MAX_PIECE = 2048;
    private static int dRow[] = {0, 1, 0, -1};
    private static int dCol[] = {-1, 0, 1, 0};
    static class Pair {
        public int row;
        public int column;
        public Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    /** A new 2048 game on a board of size SIZE with no pieces
     *  and score 0. */
    public Model(int size) {
        _board = new Board(size);
        _score = _maxScore = 0;
        _gameOver = false;
    }

    /** A new 2048 game where RAWVALUES contain the values of the tiles
     * (0 if null). VALUES is indexed by (row, col) with (0, 0) corresponding
     * to the bottom-left corner. Used for testing purposes. */
    public Model(int[][] rawValues, int score, int maxScore, boolean gameOver) {
        _board = new Board(rawValues);
        this._score = score;
        this._maxScore = maxScore;
        this._gameOver = gameOver;
    }

    /** Same as above, but gameOver is false. Used for testing purposes. */
    public Model(int[][] rawValues, int score, int maxScore) {
        this(rawValues, score, maxScore, false);
    }

    /** Return the current Tile at (COL, ROW), where 0 <= ROW < size(),
     *  0 <= COL < size(). Returns null if there is no tile there.
     *  Used for testing. Should be deprecated and removed.
     * */
    public Tile tile(int col, int row) {
        return _board.tile(col, row);
    }

    /** Return the number of squares on one side of the board.
     *  Used for testing. Should be deprecated and removed. */
    public int size() {
        return _board.size();
    }

    /** Return true iff the game is over (there are no moves, or
     *  there is a tile with value 2048 on the board). */
    public boolean gameOver() {
        checkGameOver();
        if (_gameOver) {
            _maxScore = Math.max(_score, _maxScore);
        }
        return _gameOver;
    }

    /** Return the current score. */
    public int score() {
        return _score;
    }

    /** Return the current maximum game score (updated at end of game). */
    public int maxScore() {
        return _maxScore;
    }

    /** Clear the board to empty and reset the score. */
    public void clear() {
        _score = 0;
        _gameOver = false;
        _board.clear();
        setChanged();
    }

    /** Allow initial game board to announce a hot start to the GUI. */
    public void hotStartAnnounce() {
        setChanged();
    }

    /** Add TILE to the board. There must be no Tile currently at the
     *  same position. */
    public void addTile(Tile tile) {
        _board.addTile(tile);
        checkGameOver();
        setChanged();
    }

    /** Tilt the board toward SIDE.
     *
     * 1. If two Tile objects are adjacent in the direction of motion and have
     *    the same value, they are merged into one Tile of twice the original
     *    value and that new value is added to the score instance variable
     * 2. A tile that is the result of a merge will not merge again on that
     *    tilt. So each move, every tile will only ever be part of at most one
     *    merge (perhaps zero).
     * 3. When three adjacent tiles in the direction of motion have the same
     *    value, then the leading two tiles in the direction of motion merge,
     *    and the trailing tile does not.
     */
    public void tilt(Side side) {
        // TODO: Fill in this function.
        _board.setViewingPerspective(side);

        for (int c = 0; c < _board.size(); c++) {
            Boolean hasScored = false;
            for (int r = 2; r >= 0; r--) {
                Tile t = _board.tile(c, r); //start at [0,2]
                if (t == null) continue;
                if (!isOutOfBounds(c,r-1, _board.size())) {
                    if (_board.tile(c, r-1) != null) hasScored = false;
                }
                int m = r;
                for (int i = r + 1; i < _board.size(); i++) {
                    if (_board.tile(c, i) == null) {
                        m = i;
                        continue;
                    }
                    if (_board.tile(c, i).value() == t.value()) {
                        if (hasScored) continue;
                        m = i;
                        continue;
                    }
                    if (_board.tile(c, i).value() != t.value()) break;
                }
                Tile neigh = _board.tile(c, m);
                if (_board.move(c, m, t)) {
                    _score += t.value() + neigh.value();
                    hasScored = true;
                }
            }
        }
        _board.setViewingPerspective(Side.NORTH);
        checkGameOver();
    }

    /** Checks if the game is over and sets the gameOver variable
     *  appropriately.
     */
    private void checkGameOver() {
        _gameOver = checkGameOver(_board);
    }

    /** Determine whether game is over. */
    private static boolean checkGameOver(Board b) {
        return maxTileExists(b) || !atLeastOneMoveExists(b);
    }

    /** Returns true if at least one space on the Board is empty.
     *  Empty spaces are stored as null.
     */
    public static boolean emptySpaceExists(Board b) {
        // TODO: Fill in this function.
        for (int i = 0; i < b.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                if (b.tile(j, i) == null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if any tile is equal to the maximum valid value.
     * Maximum valid value is given by this.MAX_PIECE. Note that
     * given a Tile object t, we get its value with t.value().
     */
    public static boolean maxTileExists(Board b) {
        // TODO: Fill in this function.
        for (int i = 0; i < b.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                Tile curTile = b.tile(j, i);
                if (curTile != null && curTile.value() == MAX_PIECE) {
                    return true;
                }
            }
        }
        return false;
    }
    /*
    * Returns true if the tile is
    * 1.NOT out of bounds
    * 2.NOT visited
    * */
    static Boolean isValid(Boolean vis[][], int row, int col, int boardSize) {
        return (!isOutOfBounds(row, col, boardSize) && !vis[row][col]);
    }
    static Boolean isOutOfBounds(int row, int col, int boardSize) {
        return row < 0 || col < 0 || row >= boardSize || col >= boardSize;
    }

    /**
     * Returns true if there are any valid moves on the board.
     * There are two ways that there can be valid moves:
     * 1. There is at least one empty space on the board.
     * 2. There are two adjacent tiles with the same value.
     */
    public static boolean atLeastOneMoveExists(Board b) {
        // TODO: Fill in this function.
        if (emptySpaceExists(b)) return true;
        Boolean vis[][] = new Boolean[b.size()][b.size()];
        for (Boolean[] row: vis)
            Arrays.fill(row, false);

        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(0,0));
        while (!st.empty()) {
            Pair curr = st.pop();
            Integer row  = curr.row;
            Integer col = curr.column;

            if (!isValid(vis, row, col, b.size())) continue;
            vis[row][col] = true;
            for (int i = 0; i < 4; i++) {
                int adjx = row + dRow[i];
                int adjy = col + dCol[i];
                if (!isOutOfBounds(adjx, adjy, b.size())) {
                    if ( b.tile(row, col).value() == b.tile(adjx, adjy).value()) return true;
                }
                st.push(new Pair(adjx, adjy));
            }
        }
        return false;
    }

    /** Returns the model as a string, used for debugging. */
    @Override
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int row = size() - 1; row >= 0; row -= 1) {
            for (int col = 0; col < size(); col += 1) {
                if (tile(col, row) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(col, row).value());
                }
            }
            out.format("|%n");
        }
        String over = gameOver() ? "over" : "not over";
        out.format("] %d (max: %d) (game is %s) %n", score(), maxScore(), over);
        return out.toString();
    }

    /** Returns whether two models are equal. */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (getClass() != o.getClass()) {
            return false;
        } else {
            return toString().equals(o.toString());
        }
    }

    /** Returns hash code of Model’s string. */
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
