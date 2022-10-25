public class Dog {
    public int weightInPounds;
    public static String binomen = "canis familiaris";

    public Dog(int weightInPounds) {
        this.weightInPounds = weightInPounds;
    }
    public void makeNoise() {
        if (weightInPounds < 10) {
            System.out.println("yipyipyip!");
        } else if (weightInPounds < 30) {
            System.out.println("bark! bark!!");
        } else {
            System.out.println("woooooof!");
        }
    }

    public static Dog maxDog(Dog dog1, Dog dog2) {
        if (dog1.weightInPounds > dog2.weightInPounds) return dog1;
        return dog2;
    }
    public Dog biggerDog(Dog dog) {
        if (this.weightInPounds > dog.weightInPounds) return this;
        return dog;
    }

    /*
    Returns a new array that contains every Dog that is larger than
    its 4 closest neighbors. i.e. the two on the left and the two on the right.
    if there are not enough neighbors, i.e you're at the end of the array, then consider just
    the neighbors that exist.
    input: [10, 20, 30, 25, 20, 40, 10]
    returns [30, 40]
     */
    public static Dog[] largerThanFourNeighbors(Dog[] dogs) {
        Dog[] returnDogs = new Dog[dogs.length];
        int count = 0;
        for (int i = 0; i < dogs.length; i++) {
            if (isGreatestOfNeighbors(dogs, i)) {
                returnDogs[count] = dogs[i];
                count++;
            }
        }
        returnDogs = clearArrayOfNulls(returnDogs, count);
        return returnDogs;
    }

    /*checks if it is greater than its 4 neighbors*/
    public static boolean isGreatestOfNeighbors(Dog[] dogs, int i) {
        if (!isValidIndex(dogs, i)) return false;
        for (int j = -2; j <= 2; j++) {
            int k = i + j;
            if (k <= 0 || k >= dogs.length) continue;
            if (dogs[i].weightInPounds < dogs[k].weightInPounds) {
                return false;
            }
        }
        return true;
    }

    /*checks if the index out of bounds*/
    public static boolean isValidIndex(Dog[] dogs, int i) {
        return (i >= 0) || (i < dogs.length);
    }

    public static Dog[] clearArrayOfNulls(Dog[] dogs, int newSize) {
        Dog[] newDogs = new Dog[newSize];
        for (int i = 0; i < newSize; i++) {
            newDogs[i] = dogs[i];
        }
        return newDogs;
    }
}