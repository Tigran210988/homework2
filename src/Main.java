import animals.Animal;
import animals.birds.IFly;
import data.AnimalData;
import data.CommandsData;
import factory.AnimalFactory;
import validators.DataValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animalList = new ArrayList<>();
        AnimalFactory animalFactory = new AnimalFactory();
        DataValidator commandValidator = new DataValidator();
        
        while (true) {
            System.out.println("Введите команду add/list/exit");
            String commandStr = scanner.next().toUpperCase(Locale.ROOT).trim();

            if (!commandValidator.isvalidate(commandStr, CommandsData.values())) {
                System.out.println("Вы ввели неверную команду");
                continue;
            }

            CommandsData commandsData = CommandsData.valueOf(commandStr);

            switch (commandsData) {
                case ADD:

                    String animalTypeStr = "";
                    while (true) {
                        System.out.println("Введите тип животного: cat/dog/duck");
                        animalTypeStr = scanner.next().toUpperCase().trim();

                        if (commandValidator.isvalidate(animalTypeStr, AnimalData.values())) {
                            break;
                        }
                        System.out.println("Вы ввели неверный тип животного");
                    }
                    Animal animal = animalFactory.create(AnimalData.valueOf(animalTypeStr));

                    System.out.println("Введите имя животного");
                    animal.setName(scanner.next());

                    animal.setAge(scanner);
                    animal.setWeight(scanner);


                    while (true) {
                        System.out.println("Введите цвет животного");
                        String colorStr = scanner.next();
                        if (commandValidator.isDataByRegExp(colorStr, Pattern.compile("^[а-яА-ЯёЁa-zA-Z]+$"))) {
                            animal.setColor(colorStr);
                            break;
                        }
                        System.out.println("Вы ввели неверный цвет животного");
                    }
                    animalList.add(animal);
                    animal.say();
                    animal.go();
                    animal.drink();
                    if(animal instanceof IFly) {
                        ((IFly)animal).fly();
                    }
                    break;

                case LIST:
                    if(animalList.isEmpty()) {
                        System.out.println("Введите данные для добавления животного в List");
                        continue;
                    }
                    for(Animal animalObject: animalList) {
                        System.out.println(animalObject.toString());
                    }
                    break;

                case EXIT:
                    System.exit(0);
            }
        }
    }
}