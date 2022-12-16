package model;

import java.io.FileReader;
import java.io.IOException;

public class Model {  // Рабочий класс
    public Model() {
    }

    public void callIoException(String filename) throws IOException {  // Может возникнуть IOException
        FileReader reader = new FileReader(filename);
    }
    public void callArithmeticException(int a, int b) throws ArithmeticException {
                                                      // Может возникнуть ArithmeticException
        float c = (float) a / b;
    }

    public void callArrayIndexOutOfBoundsException(int[] array, int index) throws ArrayIndexOutOfBoundsException{
                                                        // Может возникнуть ArrayIndexOutOfBoundsException
        Integer Element = array[index];
    }

    public int[] subArreay(int[] arrayA, int[] arrayB) {  // Вычитание соответствующих элементов 2-х масивов
                                                          // друг на друга
                                                          // Может быть выход ха пределы массива - тогда возвращаем null
        int[] arrayC = null;
        if (arrayA.length == arrayB.length) {
            arrayC = new int[arrayA.length];
            for(int i=0; i < arrayA.length; i++) {
                arrayC[i] = arrayA[i] - arrayB[i];
            }
        }
        return arrayC;
    }

    public float[] divArreay(int[] arrayA, int[] arrayB) throws ArrayIndexOutOfBoundsException, ArithmeticException {
                                            // Деление соответствующих элементов 2-х масивов
                                            // друг на друга
                                            // Обрабатываем ArrayIndexOutOfBoundsException и ArithmeticException
        if (arrayA.length != arrayB.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        float[] arrayC = new float[arrayA.length];
        for(int i=0; i < arrayA.length; i++) {
            if (arrayB[i] == 0) {
                throw new ArithmeticException("Dividing by zero");
            }
            arrayC[i] = (float) arrayA[i] / arrayB[i];
        }
        return arrayC;
    }

    public int[] addArreay(int[] arrayA, int[] arrayB) throws ArrayIndexOutOfBoundsException {
                                                // Сложение соответствующих элементов 2-х масивов
                                                // друг с другом
                                                // Обрабатываем ArrayIndexOutOfBoundsException

        if (arrayA.length != arrayB.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int[] arrayC = new int[arrayA.length];
        for(int i=0; i < arrayA.length; i++) {
            arrayC[i] = arrayA[i] + arrayB[i];
        }
        return arrayC;
    }

    public boolean isCorrectArray (int[][] array) {
                                // Проверка на корректность 2D массива
                                // Оборйдемся без обработки исключений
        for(int i = 0; i < array.length; i++) {
            if (array.length != array[i].length) {
                return false;
            }
        }
        return true;
    }
}
