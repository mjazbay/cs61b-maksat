public class Library {
    public Book[] books;
    public int index;
    public static int totalBooks = 0;

    public Library(int size) {
        books = new Book[size];
        index = 0;
    }

    public void addBook(Book book) {
        books[index] = book;
        index++;
        totalBooks++;
        book.library = this;
    }

    public static void main(String[] args) {
        Book book1 = new Book("flowers for algernon");
        Library library1 = new Library(10);
        library1.addBook(book1);
        System.out.println(book1.lastBookTitle());
    }
}
