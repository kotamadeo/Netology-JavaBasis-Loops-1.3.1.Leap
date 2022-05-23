# **Задача №1 Високосный год**

## **Цель**:

1. Написать программу, которая будет рассчитывать количество дней в году и определять его високосность.

### *Пример*:

``` Пример 1
Введите год в формате 'yyyy'
2022
Год: 2022 не високосный. Количество дней в году: 365
```

### **Моя реализация**:

1. Реализация осуществлена в парадигме ООП.
2. Создал структуру классов:
* **Program** - отвечающий за запуск программы, путем инициирования метода *start()* (с инициированием внутри себя
  вспомогательного метода *printMenu()*);

#### Класс **Program**:
``` java
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
```

* **LeapYear** - задающий логику расчета количества дней через ```boolean``` метод *isLeapYear()*.

#### Метод *isLeapYear()* в классе **LeapYear**:
``` java
 public boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            this.year = year;
            days = 366;
            return true;
        } else if (year % 100 == 0) {
            this.year = year;
            days = 365;
        } else if (year % 4 == 0) {
            this.year = year;
            days = 366;
            return true;
        } else {
            this.year = year;
            days = 365;
        }
        return false;
    }
```

2. Использовал кодирование цвета текста (ANSI).

#### Класс **Utils**:
``` java
public class Utils {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void printDelim() {
        System.out.println(ANSI_GREEN + "*********************************************" + ANSI_RESET);
    }
}
```

3. Использовал ```try-catch```, чтобы избежать падение программы в исключения.

#### Метод *main()* в классе **Main**:
``` java
public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        program.start();
    }
}
```

## *Вывод в консоль*:

* меню:
``` 
Эта программа способна определить високосный год или нет.
Возможные команды программы:
0: чтобы выйти в главное меню.
1: ввести год.
>>>>>>>
```