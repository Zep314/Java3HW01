package model;

import java.io.FileReader;
import java.io.IOException;

public class Model {
    public Model() {

    }

    public void callIoException(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
    }
    public void callArithmeticException(int a, int b) throws ArithmeticException {
        float c = a / b;
    }

    public void callArrayIndexOutOfBoundsException(int[] array, int index) throws ArrayIndexOutOfBoundsException{
        Integer Element = array[index];
    }

    public int[] subArreay(int[] arrayA, int[] arrayB) {
        int[] arrayC = null;
        if (arrayA.length == arrayB.length) {
            arrayC = new int[arrayA.length];
            for(int i=0; i < arrayA.length; i++) {
                arrayC[i] = arrayA[i] - arrayB[i];
            }
        }
        return arrayC;
    }
}
