package com.kryvapust.stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Would you like to input own expression (option 1) or see example of converting infix to prefix and postfix (option 2). Chose 1/2 ");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        String[] expressions =
                {" 1 + 2 - 3 ",
                        " 1 * 2 + 3 ",
                        " 1 + 2 * 3 ",
                        " ( 1 + 2 ) * 3 ",
                        " ( 1 + 2 ) * 3 - ( 4 - 5 ) * ( 6 + 7 ) ",
                        " 78 ^ 6 - 3 + 9 ^ ( 2 - 1 ) "};
        if (answer.equals("1")) {
            System.out.print(" Please, input expression with space before and after each symbol (like: ( 1 + 2 ) / 3 ) : ");
            if (sc.hasNextLine()) {
                expressions[0] = sc.nextLine();
            }
            System.out.println("Prefix: " + PrefixConverter.convert(expressions[0]));
            System.out.println("Postfix: " + PostfixConverter.convert(expressions[0]));
        } else {
            for (String exp : expressions) {
                System.out.println("Example: \nInfix: " + exp);
                System.out.println("Prefix: " + PrefixConverter.convert(exp));
                System.out.println("Postfix: " + PostfixConverter.convert(exp));
            }
        }
    }
}

