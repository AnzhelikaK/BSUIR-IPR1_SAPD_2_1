package com.kryvapust.stack;

import java.util.Stack;

import static java.lang.Character.isDigit;

public class PrefixConverter {

    private static boolean isOperator(char symbol) {
        return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/' || symbol == '^';
    }

    private static int priority(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
        }
        return 0;
    }

    public static String convert(String infix) {
        infix = ' ' + infix + ' ';
        Stack<Character> stack = new Stack<>();
        StringBuilder infixStringBuilder = new StringBuilder(infix);
        infixStringBuilder.reverse();

        char[] chars = infixStringBuilder.toString().toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            if (isDigit(ch)) {
                while (isDigit(chars[i])) {
                    sb.append(chars[i++]);
                }
                sb.append(' ');
            } else if (ch == ')') {
                stack.push(ch);
            } else if (ch == '(') {
                while (!stack.empty() && stack.peek() != ')') {
                    sb.append(stack.pop()).append(' ');
                }
                stack.pop();
            } else if (isOperator(ch)) {
                while (!stack.empty() && priority(stack.peek()) >= priority(ch)) {
                    sb.append(stack.pop()).append(' ');
                }
                stack.push(ch);
            }
        }

        while (!stack.empty()) {
            sb.append(stack.pop()).append(' ');
        }
        return sb.reverse().toString();
    }
}
