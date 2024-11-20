package Week3;

import java.util.Scanner;

public class StrNum {
    private String strData;
    private int val;
    private int base;  

    public StrNum(String strData) {
        this.strData = strData;
        if (strData.startsWith("0x")) {
            this.base = 16;
            this.val = Integer.parseInt(strData.substring(2), 16);
        } else if (strData.startsWith("0b")) {
            this.base = 2;
            this.val = Integer.parseInt(strData.substring(2), 2);
        } else if (strData.startsWith("0") && strData.length() > 1) {
            this.base = 8;
            this.val = Integer.parseInt(strData.substring(1), 8);
        } else {
            this.base = 10;
            this.val = Integer.parseInt(strData);
        }
    }

    public String getStrData() { return strData; }
    public int getVal() { return val; }
    public int getBase() { return base; }

    public StrNum add(StrNum other) {
        int resultVal = this.val + other.getVal();
        return new StrNum(formatResult(resultVal));
    }

    public StrNum subtract(StrNum other) {
        int resultVal = this.val - other.getVal();
        return new StrNum(formatResult(resultVal));
    }

    public StrNum multiply(StrNum other) {
        int resultVal = this.val * other.getVal();
        return new StrNum(formatResult(resultVal));
    }

    public StrNum divide(StrNum other) {
        int resultVal = this.val / other.getVal();
        return new StrNum(formatResult(resultVal));
    }

    private String formatResult(int resultVal) {
        switch (this.base) {
            case 16: return "0x" + Integer.toHexString(resultVal);
            case 8: return "0" + Integer.toOctalString(resultVal);
            case 2: return "0b" + Integer.toBinaryString(resultVal);
            default: return Integer.toString(resultVal);
        }
    }

    @Override
    public String toString() {
        return strData;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자: ");
            String input1 = scanner.nextLine();
            if (input1.equalsIgnoreCase("quit")) break;

            System.out.print("두 번째 숫자: ");
            String input2 = scanner.nextLine();

            StrNum num1 = new StrNum(input1);
            StrNum num2 = new StrNum(input2);

            System.out.print("연산자: ");
            String operator = scanner.nextLine();

            StrNum result = null;
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
