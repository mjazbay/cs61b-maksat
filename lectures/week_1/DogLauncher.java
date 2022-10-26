public class DogLauncher {
    public static void main(String[] args) {
        Dog dog1 = new Dog(10);
        Dog dog2 = new Dog(15);
        Dog dog3 = new Dog(20);
        Dog dog4 = new Dog(15);
        Dog dog5 = new Dog(10);
        Dog dog6 = new Dog(5);
        Dog dog7 = new Dog(10);
        Dog dog8 = new Dog(15);
        Dog dog9 = new Dog(22);
        Dog dog10 = new Dog(15);

        Dog[] dogs = new Dog[10];
        dogs[0] = dog1;
        dogs[1] = dog2;
        dogs[2] = dog3;
        dogs[3] = dog4;
        dogs[4] = dog5;
        dogs[5] = dog6;
        dogs[6] = dog7;
        dogs[7] = dog8;
        dogs[8] = dog9;
        dogs[9] = dog10;


        //[10, 20, 30, 25, 20, 40, 10]
        Dog[] newDogs = Dog.largerThanFourNeighbors(dogs);
        System.out.println(newDogs);
    }
}
