package com.company;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        int integerNum1 = 0;
        int integerNum2 = 0;
        System.out.println("Enter num");
        String num1 = scanner1.nextLine();
        char action = getChar();
        System.out.println("Enter next Num");
        String num2 = scanner1.nextLine();


        if (num1.contains("X") || num1.contains("IX")|| num1.contains("V") || num1.contains("IV") || num1.contains("I")){
            while (isNumeric(num2)){
                if (num2 != null && !num2.equals("")) {
                    System.out.println("Enter correct Num");
                    num2 = scanner1.nextLine();
                }
            }
            integerNum1 = getConvert(num1);
            integerNum2 = getConvert(num2);
        }else {
            while (!isNumeric(num2)){
                if (num2 != null && !num2.equals("")) {
                    System.out.println("Enter correct Num");
                    num2 = scanner1.nextLine();
                }
            }
            integerNum1 = Integer.parseInt(num1);
            integerNum2 = Integer.parseInt(num2);
        }
        int result = getOperation(integerNum1, integerNum2, action );
        System.out.println(num1 + action + num2 + " = " + result);

    }

    public static boolean isNumeric (String number){
        boolean isNumber = false;
        if (number != null && !number.equals("")){
            isNumber = true;

            char [] chars = number.toCharArray();
            for (int d = 0;d<chars.length;d++){
                isNumber = Character.isDigit(chars[d]);

                if (!isNumber){
                    break;
                }
            }
        }
        return isNumber;
    }
    private static char getChar(){
        char action = 0;
        System.out.println("Enter operation {'/', '*', '+', '-'}");
        if (scanner.hasNext()){
            action = scanner.next().charAt(0);
        }else {
            System.out.println("Enter the operation again");
            scanner.next();
            action = getChar();
        }
        return action;
    }
    private static int getOperation(int num1, int num2, char action) {
        int result = 0;
        switch (action){
            case '/':
                result = num1 / num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 + num2;
                break;
            default:
                System.out.println("Command is not correct. Tray again");
                result = getOperation(num1, num2, getChar());
        }
        return result;
    }
    private static int getConvert(String num){
        if (num.isEmpty() || num==null  ){
            return 0;
        }
        if(num.startsWith("X")){
            return 10 + getConvert(num.substring(1));
        }
        if (num.startsWith("IX")){
            return 9 + getConvert(num.substring(2));
        }
        if (num.startsWith("V")){
            return 5 + getConvert(num.substring(1));
        }
        if (num.startsWith("IV")){
            return 4 + getConvert(num.substring(2));
        }
        if (num.startsWith("I")){
            return 1 + getConvert(num.substring(1));
        }
        return 0;
    }
}
