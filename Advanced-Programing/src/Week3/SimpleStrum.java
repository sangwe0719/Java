package Week3;

import java.util.Scanner;

public class SimpleStrum {
    private String strData;
    private int val;

    public SimpleStrum(String strData) {
        this.strData = strData;
        this.val = Integer.parseInt(strData);
    }

    public String getStrData() { return strData; }
    public void setStrData(String strData) {
        this.strData = strData;
        this.val = Integer.parseInt(strData);
    }

    public int getVal() { return val; }
    public void setVal(int val) {
        this.val = val;
        this.strData = Integer.toString(val);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SimpleStrum other = (SimpleStrum) obj;
        return this.val == other.val;
    }

    @Override
    public String toString() {
        return "SimpleStrNum{strData='" + strData + "', val=" + val + "}";
    }

    public SimpleStrum add(SimpleStrum other) {
        return new SimpleStrum(Integer.toString(this.val + other.getVal()));
    }

    public SimpleStrum subtract(SimpleStrum other) {
        return new SimpleStrum(Integer.toString(this.val - other.getVal()));
    }

    public SimpleStrum multiply(SimpleStrum other) {
        return new SimpleStrum(Integer.toString(this.val * other.getVal()));
    }

    public SimpleStrum divide(SimpleStrum other) {
        return new SimpleStrum(Integer.toString(this.val / other.getVal()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자: ");
            String input1 = scanner.nextLine();
            if (input1.equalsIgnoreCase("quit")) break;
      
            System.out.print("두 번째 숫자: ");
            String input2 = scanner.nextLine();

            SimpleStrum num1 = new SimpleStrum(input1);
            SimpleStrum num2 = new SimpleStrum(input2);

            System.out.print("연산자: ");
            String operator = scanner.nextLine();

            SimpleStrum result = null;
            switch (operator) {
                case "+":
                    result = num1.add(num2);
                    break;
                case "-":
                    result = num1.subtract(num2);
                    break;
                case "*":
                    result = num1.multiply(num2);
                    break;
                case "/":
                    result = num1.divide(num2);
                    break;
                default:
                    System.out.println("다시입력하시오.");
                    continue;
            }

            if (result != null) {
                System.out.println("답: " + result);
            }
        }

        scanner.close();
    }
}