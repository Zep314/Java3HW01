package controller;
import view.View;
import model.Model;

import java.io.IOException;
import java.util.Arrays;

public class Controller {
    View viewer = new View();
    Model model = new Model();

    public Controller() {

    }

    public void run() {
        this.viewer.printInfo("Начало работы!");
        this.test1_1();
        this.test1_2();
        this.test1_3();

        this.test3();
        this.viewer.printInfo("Работа завершена.");
    }

    private void test1_1() {
        this.viewer.printInfo("1.1. Обрабатываем IOException");
        String filename = "not_existing_file.txt";

        try {
            this.model.callIoException(filename);
            this.viewer.printInfo(String.format("Если файл %s существует, то мы увидим это сообщение",filename));
        } catch (IOException e) {
            this.viewer.printWarning(String.format("Файл %s НЕ существует, поэтому мы видим это сообщение",filename));
        }
    }

    private void test1_2() {
        this.viewer.printInfo("1.2. Обрабатываем ArithmeticException");
        try {
            this.model.callArithmeticException(2,0);
            this.viewer.printInfo("Если ArithmeticException (делили на 0) не возникло, то мы увидим это сообщение");
        } catch (ArithmeticException e) {
            this.viewer.printWarning("Возникло ArithmeticException - тут можно его обработать, или выдать сообщение об ошибке.");
        }
    }
    private void test1_3() {
        this.viewer.printInfo("1.3. Обрабатываем OutOfBoundsException");
        int[] arr = new int[5];
        for(int i = 0; i < 5; i++) {
            arr[i] = i;
        }
        try {
            this.model.callArrayIndexOutOfBoundsException(arr,6);
            this.viewer.printInfo("Если ArrayIndexOutOfBoundsException не возникло, то мы увидим это сообщение");

        } catch (ArrayIndexOutOfBoundsException e) {
            this.viewer.printWarning("Возникло ArrayIndexOutOfBoundsException - тут можно его обработать, или выдать сообщение об ошибке.");
        } finally {
            this.viewer.printInfo("В любом случае выводим массив на печать: " + Arrays.toString(arr));
        }
    }

    private void test3() {
        this.viewer.printInfo("3. Обрабатываем неравенство массивов. Пробуем обойтись без вызова исключений.");
        int[] a = new int[5];
        int[] b = new int[6];

        for(int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        for(int i = 0; i < b.length; i++) {
            b[i] = b.length - i - 1;
        }

        int[] c = this.model.subArreay(a,b);
        if (c == null) {
            this.viewer.printWarning("Массивы разной длины - невозможно выполнить операцию");
        } else {
            this.viewer.printInfo("Массив A : " + Arrays.toString(a));
            this.viewer.printInfo("Массив B: " + Arrays.toString(b));
            this.viewer.printInfo("Результат операции: " + Arrays.toString(c));
        }
    }

}
