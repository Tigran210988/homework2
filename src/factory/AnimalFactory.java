package factory;

import animals.Animal;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalData;


public class AnimalFactory {

    public Animal create(AnimalData animalData) {
        switch (animalData) {
            case CAT:
                return new Cat();
            case DOG:
                return new Dog();
            default:
                return new Duck();
        }
    }
}
