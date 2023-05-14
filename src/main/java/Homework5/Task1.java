package Homework5;

import java.net.Socket;
import java.util.*;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> employeesStart = Map.ofEntries(
                Map.entry("Иван Иванов", new ArrayList<String>()),
                Map.entry("Светлана Петрова", new ArrayList<String>()),
                Map.entry("Кристина Белова", new ArrayList<String>()),
                Map.entry("Анна Мусина", new ArrayList<String>()),
                Map.entry("Анна Крутова", new ArrayList<String>()),
                Map.entry("Иван Юрин", new ArrayList<String>()),
                Map.entry("Петр Лыков", new ArrayList<String>()),
                Map.entry("Павел Чернов", new ArrayList<String>()),
                Map.entry("Петр Чернышов", new ArrayList<String>()),
                Map.entry("Мария Федорова", new ArrayList<String>()),
                Map.entry("Марина Светлова", new ArrayList<String>()),
                Map.entry("Мария Савина", new ArrayList<String>()),
                Map.entry("Мария Рыкова", new ArrayList<String>()),
                Map.entry("Марина Лугова", new ArrayList<String>()),
                Map.entry("Анна Владимирова", new ArrayList<String>()),
                Map.entry("Иван Мечников", new ArrayList<String>()),
                Map.entry("Петр Петин", new ArrayList<String>()),
                Map.entry("Иван Ежов", new ArrayList<String>())
        );

        Map<String, ArrayList<String>> employees = new HashMap<>();
        employees.putAll(employeesStart);
        String regex = "\\d{10}";
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Вы хотите изменить таблицу(0) или вывести всю таблицу(1)\n" +
                    "(Чтобы закончить выполнение программы и вывести итоговую таблицу с номерами введите 2):\n ");
            int whatToDo = iScanner.nextInt();
            if (whatToDo == 0) {
                System.out.println("Можно добавить только русский номер, вводить нужно цифры после +7");
                System.out.print("Введите имя работника: ");
                String nameOfEmployee = iScanner.next();
                System.out.print("Введите фамилию работника: ");
                String sernameOfEmployee = iScanner.next();
                String fullNameOfEmploee = nameOfEmployee + " " + sernameOfEmployee;
                if (employees.containsKey(fullNameOfEmploee)) {
                    for (int i = 0; i < 1; i++) {
                        System.out.print("Добавить номер(0), узнать имеющиеся(1), удалить последний(2), выйти(3): ");
                        int command = iScanner.nextInt();
                        if (command == 0) {
                            System.out.print("Введите, сколько номеров нужно добавить: ");
                            int countContacts = iScanner.nextInt();
                            try {
                                if (countContacts <= 5) {
                                    for (int j = 0; j < countContacts; j++) {
                                        System.out.print("Введите номер: ");
                                        String contact = iScanner.next();
                                        if (Pattern.matches(regex, contact)) {
                                            employees.get(fullNameOfEmploee).add("+7" + contact);
                                        } else {
                                            System.out.println("Неверный формат, пробуйте еще раз(1) или отмените действие(0)");
                                            int newCommand = iScanner.nextInt();
                                            if (newCommand == 0) {
                                                break;
                                            }
                                            j--;
                                        }
                                    }
                                    i--;
                                } else {
                                    System.out.println("Число слишком большое, нельзя добавить больше 5 номеров подряд");
                                    i--;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Число слишком большое, нельзя добавить больше 5 номеров подряд");
                            }
                        }
                        if (command == 1) {
                            System.out.printf("%s\t -> \t%s%n", fullNameOfEmploee, employees.get(fullNameOfEmploee));
                            i--;
                        }
                        if (command == 2) {
                            try {
                                employees.get(nameOfEmployee).remove(employees.get(nameOfEmployee).size() - 1);
                            } catch (NullPointerException e) {
                                System.out.println("Удалять нечего, номеров пока нет, добавьте номер");
                                i--;
                            }
                        }
                        if (command == 3) {

                        }
                        if (command != 0 && command != 1 && command != 2 && command != 3) {
                            System.out.println("Введена неправильная команда, попробуй снова(0, 1, 2, 3)");
                            i--;
                        }
                    }
                } else {
                    System.out.println("Нет такого работника");
                }
                }
            if (whatToDo == 1) {
                for (String key : employees.keySet()) {
                    System.out.printf("%s\t -> \t%s%n", key, employees.get(key));
                }
            }
            if (whatToDo == 2) {
                for (String key : employees.keySet()) {
                    System.out.printf("%s\t -> \t%s%n", key, employees.get(key));
                }
                break;
            }
            if (whatToDo != 0 && whatToDo != 1 && whatToDo != 2) {
                System.out.println("Вы ввели команду неправильно, введите 0 или 1");
            }

        }
    }


}
