package animals;

import validators.DataValidator;

import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Animal {
    private int age = -1;
    private String name= "";
    private int weight = -1;
    private String color = "";
    private DataValidator dataValidator = new DataValidator();



    public void say() {
        System.out.println("Я говорю");
    }
    public void go() {
        System.out.println("Я иду");
    }
    public void drink() {
        System.out.println("Я пью");
    }
    public void eat() {
        System.out.println("Я ем");
    }

    public void setName(String name) {

        this.name = name;
    }

//    private int getAgeWeightValidData(Scanner scanner) {
//        int data = -1;
//        while (true) {
//            String ageStr = scanner.next();
//            if(dataValidator.isDataByRegExp(ageStr, Pattern.compile("^\\d+$"))) {
//                data = Integer.parseInt(ageStr);
//                if(data > 50 || data <=0) {
//                    System.out.println("Возраст животного должен быть в пределах от 0 до 50");
//                    continue;
//                }
//                break;
//            }
//            System.out.println("Возраст животного введён неверно");
//        }
//        return data;
//    }
    public void setAge(Scanner scanner) {
        int data = -1;
        boolean isValidAge = false;
        while (!isValidAge) {
            try {
                System.out.println("Введите возраст животного");
                String ageStr = scanner.next();
                if (dataValidator.isDataByRegExp(ageStr, Pattern.compile("^\\d+$"))) {
                    data = Integer.parseInt(ageStr);
                    if (data > 50 || data <= 0) {
                        System.out.println("Возраст животного должен быть в пределах от 0 до 50 лет");
                        continue;
                    }

                break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введено некорректное число. Возраст животного должен быть в пределах от 0 до 50 лет");
            }
        }
        this.age = data;
    }

    public void setWeight(Scanner scanner) {
        int data = -1;
        boolean isValidWeight = false;
        while (!isValidWeight) {
            try {
                System.out.println("Введите вес животного");
                String weightStr = scanner.next();
                if (dataValidator.isDataByRegExp(weightStr, Pattern.compile("^\\d+$"))) {
                    data = Integer.parseInt(weightStr);
                    if (data > 50 || data <= 0) {
                        System.out.println("Вес животного должен быть в пределах от 0 до 50 кг");
                        continue;
                    }
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введено некорректное число. Вес животного должен быть в пределах от 0 до 50 кг");
            }
        }
        this.weight = data;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public String getName() {

        return name;
    }

    public int getAge() {

        return age;
    }

    public int getWeight() {

        return weight;
    }

    public String getColor() {

        return color;
    }

    @Override
    public String toString() {

        String yearPadej = getYearPadej();
        if(yearPadej == null) {
            return "Возраст введён неверно";
        }
        return String.format("Привет! Меня зовут %s, мне %d %s, я вешу %d кг, мой цвет %s",
                this.name,
                this.age,
                yearPadej,
                this.weight,
                this.color);
    }

    private String getYearPadej() {
        if(this.age <= 0 || this.age > 50) {
            return null;
        }
        if(this.age >=11 && this.age <= 19) {
            return "лет";
        }
        int ostatok = this.age % 10;

        if(ostatok == 0 || ostatok >= 5) {
            return "лет";
        }
        if(ostatok == 1) {
            return "год";
        }

        return "года";

    }
}
