package com.kryvapust.stack;

import java.util.Stack;

public class PostfixConverter {

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    private static int getPriority(char operator) {
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
        char[] chars = infix.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++)  {
            char ch = chars[i];

            if (Character.isDigit(ch)) {
                while (Character.isDigit(chars[i])) {
                    sb.append(chars[i++]);
                }
                sb.append(' ');
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.empty() && stack.peek() != '(') {
                    sb.append(stack.pop()).append(' ');
                }
                stack.pop();
            } else if (isOperator(ch)) {
                while (!stack.empty() && getPriority(stack.peek()) >= getPriority(ch)) {
                    sb.append(stack.pop()).append(' ');
                }
                stack.push(ch);
            }
        }

        while (!stack.empty()) {
            sb.append(stack.pop()).append(' ');
        }
        return sb.toString();
    }
}
