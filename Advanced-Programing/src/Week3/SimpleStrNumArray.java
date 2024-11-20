package Week3;

import java.util.Arrays;
import java.util.Random;

class SimpleStrNum {
    private String strData;
    private int val;

    public SimpleStrNum(String strData) {
        this.strData = strData;
        this.val = Integer.parseInt(strData);
    }

    public String getStrData() { return strData; }

    @Override
    public String toString() {
        return strData;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SimpleStrNum other = (SimpleStrNum) obj;
        return this.val == other.val;
    }
}

public class SimpleStrNumArray implements Cloneable {
    private SimpleStrNum[] array;

    public SimpleStrNumArray(int n) {
        array = new SimpleStrNum[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomNum = random.nextInt(100); 
            array[i] = new SimpleStrNum(Integer.toString(randomNum));
        }
    }

    public boolean equals(SimpleStrNumArray other) {
        if (this.array.length != other.array.length) return false;
        for (int i = 0; i < array.length; i++) {
            if (!this.array[i].equals(other.array[i])) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    @Override
    public SimpleStrNumArray clone() {
        try {
            SimpleStrNumArray copy = (SimpleStrNumArray) super.clone();
            copy.array = array.clone(); 
            for (int i = 0; i < array.length; i++) {
                copy.array[i] = new SimpleStrNum(this.array[i].getStrData());
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();  
        }
    }

    public static void main(String[] args) {
        SimpleStrNumArray arr1 = new SimpleStrNumArray(5);
        System.out.println("배열 1: " + arr1);

        SimpleStrNumArray arr2 = arr1.clone();
        System.out.println("배열 2 (복제): " + arr2);

        if (arr1.equals(arr2)) {
            System.out.println("배열 1과 배열 2는 동일한 데이터를 포함합니다.");
        } else {
            System.out.println("배열 1과 배열 2는 다른 데이터를 포함합니다.");
        }

        arr2.array[0] = new SimpleStrNum("999");
        System.out.println("배열 2 수정 후: " + arr2);
        if (arr1.equals(arr2)) {
            System.out.println("배열 1과 배열 2는 동일한 데이터를 포함합니다.");
        } else {
            System.out.println("배열 1과 배열 2는 다른 데이터를 포함합니다.");
        }
    }
}
