package controller;
import view.View;
import model.Model;

import java.io.IOException;
import java.util.Arrays;

public class Controller {  // Класс - контроллер - тут все и происходит
    View viewer = new View();  // вьювер
    Model model = new Model(); // Класс для работы

    public Controller() {
    }

    public void run() {
        this.viewer.printInfo("Начало работы!");

        this.test1_1();
        this.test1_2();
        this.test1_3();     // Реализация задач из задания

        this.test3();
        this.test4();
        this.test5();

        this.test6();

        this.viewer.printInfo("Работа завершена.");
    }

    private void test1_1() { // Пробуем получить IOException - откроем несуществующий файл
        this.viewer.printInfo("1.1. Обрабатываем IOException");
        String filename = "not_existing_file.txt";

        try {
            this.model.callIoException(filename);
            this.viewer.printInfo(String.format("Если файл %s существует, то мы увидим это сообщение",filename));
        } catch (IOException e) {
            this.viewer.printWarning(String.format("Файл %s НЕ существует, поэтому мы видим это сообщение",filename));
        }
    }

    private void test1_2() {  // Пробуем получить ArithmeticException - разделим что нибудь на ноль
        this.viewer.printInfo("1.2. Обрабатываем ArithmeticException");
        try {
            this.model.callArithmeticException(2,0);
            this.viewer.printInfo("Если исключения ArithmeticException (делили на 0) не возникло, то мы увидим это сообщение");
        } catch (ArithmeticException e) {
            this.viewer.printWarning("Возникло ArithmeticException - тут можно его обработать, или выдать сообщение об ошибке.");
        }
    }
    private void test1_3() {  // Пробуем получить OutOfBoundsException - читаем за пределами массива
        this.viewer.printInfo("1.3. Обрабатываем OutOfBoundsException");
        int[] arr = new int[5];
        for(int i = 0; i < 5; i++) {
            arr[i] = i;
        }
        try {
            this.model.callArrayIndexOutOfBoundsException(arr,6);  // Обращаемся к 6-му эелементу, в масииве из 5 элементов
            this.viewer.printInfo("Если ArrayIndexOutOfBoundsException не возникло, то мы увидим это сообщение");

        } catch (ArrayIndexOutOfBoundsException e) {
            this.viewer.printWarning("Возникло ArrayIndexOutOfBoundsException - тут можно его обработать, или выдать сообщение об ошибке.");
        } finally {
            this.viewer.printInfo("В любом случае выводим массив на печать: " + Arrays.toString(arr));
        }
    }

    private void test3() {  // Вычисляем разность соответствующих элементов входных массивов
                            // На выходе - новый массив - или null - если размеры массивов разные
        this.viewer.printInfo("3. Обрабатываем вычитание массивов. Пробуем обойтись без вызова исключений.");
        int[] a = new int[5];
        int[] b = new int[6];

        for(int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        for(int i = 0; i < b.length; i++) {
            b[i] = b.length - i - 1;
        }

        int[] c = this.model.subArreay(a,b);  // считаем массив
        if (c == null) {
            this.viewer.printWarning("Массивы разной длины - невозможно выполнить операцию");
        } else {
            this.viewer.printInfo("Массив A : " + Arrays.toString(a));
            this.viewer.printInfo("Массив B: " + Arrays.toString(b));
            this.viewer.printInfo("Результат операции: " + Arrays.toString(c));
        }
    }

    private void test4() {  // Вычисляем частное соответствующих элементов 2-х массивов.
                            // Бросаем исключение выхода за пределы массива - ArrayIndexOutOfBoundsException
                            // и исключение деления на ноль - ArithmeticException
        this.viewer.printInfo("4. Обрабатываем деление элементов массивов. Используем исключения.");
        int[] a = new int[5];
        int[] b = new int[5];

        for(int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        for(int i = 0; i < b.length; i++) {
            b[i] = b.length - i - 1;
        }
        try {
            float[] c = this.model.divArreay(a, b);
            this.viewer.printInfo("Массив A : " + Arrays.toString(a));
            this.viewer.printInfo("Массив B: " + Arrays.toString(b));
            this.viewer.printInfo("Результат операции: " + Arrays.toString(c));
        } catch (ArrayIndexOutOfBoundsException e) {
            this.viewer.printWarning("Возникло ArrayIndexOutOfBoundsException (размеры массивов не совпадают) - тут можно его обработать, или выдать сообщение об ошибке.");
        } catch (ArithmeticException e) {
            this.viewer.printWarning("Возникло ArithmeticException - На ноль делить нельзя!");
        }
    }

    private void test5() {  // Вычисляем сумму соответствующих элементов 2-х массивов.
                            // Бросаем исключение выхода за пределы массива - ArrayIndexOutOfBoundsException
        this.viewer.printInfo("5*. Обрабатываем сложение элементов массивов. Используем исключения.");
        int[] a = new int[5];
        int[] b = new int[6];

        for(int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        for(int i = 0; i < b.length; i++) {
            b[i] = b.length - i - 1;
        }

        try {
            int[] c = this.model.addArreay(a, b);
            this.viewer.printInfo("Массив A : " + Arrays.toString(a));
            this.viewer.printInfo("Массив B: " + Arrays.toString(b));
            this.viewer.printInfo("Результат операции: " + Arrays.toString(c));
        } catch (ArrayIndexOutOfBoundsException e) {
            this.viewer.printWarning("Возникло ArrayIndexOutOfBoundsException (размеры массивов не совпадают) - тут можно его обработать, или выдать сообщение об ошибке.");
        }
    }

    private void test6() {  // Обрабатываем 2D массив.
        this.viewer.printInfo("6*. Обрабатываем двумерный массив.");
        int[][] a = new int[5][5];
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                a[i][j] = i * a[i].length + j;
            }
        }
//        int[][] a = {
//                {  0,  1,  2,  3,  4 },
//                {  5,  6,  7,  8,  9, 10 },
//                { 11, 12, 13, 14, 15, 16 },
//                { 17, 18, 19, 20 },
//                { 21, 22, 23, 24, 25 },
//                { 26, 27, 28, 29, 30 }
//        };
        // Выводим исходный массив
        viewer.printInfo("Массив:");
        for (int[] i : a) {
            viewer.printInfo("Массив: " + Arrays.toString(i));
        }
        // Считаю, что если можно обойтись без исключений - то надо так и делать.
        // Реализуем простой метод проверки массива на "правильность"
        viewer.printInfo(String.format("Массив a[][] - %sкорректный",this.model.isCorrectArray(a) ? "" : "не"));
    }
}
