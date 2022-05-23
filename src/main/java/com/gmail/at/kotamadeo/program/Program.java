package com.gmail.at.kotamadeo.program;

import com.gmail.at.kotamadeo.utils.Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    private final Scanner scanner = new Scanner(System.in);
    private final LeapYear leapYear = new LeapYear();


    public void start() {
        int input;
        while (true) {
            try {
                printMenu();
                input = scanner.nextInt();
                if (input == 0) {
                    scanner.close();
                    break;
                } else {
                    if (input < 0 || input > 1) {
                        System.out.println(Utils.ANSI_RED + "Вы ввели неверный номер операции!" + Utils.ANSI_RESET);
                    } else {
                        System.out.printf("%sВведите год в формате \"yyyy\"%s%n", Utils.ANSI_BLUE, Utils.ANSI_RESET);
                        input = scanner.nextInt();
                        System.out.println(leapYear.isLeapYear(input) ? "Год: " + leapYear.getYear() + " високосный. " +
                                "Количество дней в году: " + leapYear.getDays() : "Год: " + leapYear.getYear() +
                                " не високосный. Количество дней в году: " + leapYear.getDays());
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println(Utils.ANSI_RED + "Неверный ввод!" + Utils.ANSI_RESET);
                break;
            }
        }
    }

    private void printMenu() {
        System.out.println(Utils.ANSI_YELLOW + "Эта программа способна определить високосный год или нет." +
                Utils.ANSI_RESET);
        System.out.println(Utils.ANSI_PURPLE + "Возможные команды программы:" + Utils.ANSI_RESET);
        System.out.println("0: чтобы выйти из программы.");
        System.out.println("1: ввести год.");
        System.out.print(">>>>>>>");
    }
}
