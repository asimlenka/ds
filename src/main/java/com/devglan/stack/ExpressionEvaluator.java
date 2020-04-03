package com.devglan.stack;

import java.util.Stack;

public class ExpressionEvaluator {
    //a + b + (-c -d) -e  a+b-c-d-e
    //100 * ( 2 * 12 + 2 ) / 14
    public static Integer evaluate(String expression) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operands = new Stack<>();
        char[] chars = expression.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            //ignore spaces
            if (chars[i] == ' ') {
                continue;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                //100 will be splitted as 1, 0, 0 in the char array
                StringBuilder sb = new StringBuilder();
                while (i < length && chars[i] >= '0' && chars[i] <= '9') {
                    sb.append(chars[i]);
                    i = i + 1;
                }
                //push the integer in the values stack
                values.push(Integer.valueOf(sb.toString()));
            } else if (chars[i] == '*' || chars[i] == '+' || chars[i] == '-' || chars[i] == '/') {
                //perform the operation and keep in the values stack
                //but at a time one operation can be performed
                //for 2* 12 + 2 we get + operator first and hence need to check if the value present
                //in the stack has highest precedence. In this case it's * that is already there in
                //the stack and hence perform * operation first and put the + to operands
                //at the end this would be (26)
                while (!operands.isEmpty() && hasPrecedenceCharInStack(chars[i], operands.peek())) {
                    values.push(performOperation(values.pop(), values.pop(), operands.pop()));
                }
                operands.push(chars[i]);
            } else if (chars[i] == '(') {
                operands.push('(');
            } else if (chars[i] == ')') {
                while (operands.peek() != '(') {
                    values.push(performOperation(values.pop(), values.pop(), operands.pop()));
                }
                operands.pop();
            }
        }
        while (!operands.isEmpty()){
            values.push(performOperation(values.pop(), values.pop(), operands.pop()));
        }
        return values.pop();
    }

    private static Integer performOperation(Integer pop, Integer pop1, Character peek) {
        int value = 0;
            switch (peek){
                case '+':
                    value = pop + pop1;
                    break;
                case '-':
                    value =  pop - pop1;
                    break;
                case '*':
                    value =  pop * pop1;
                    break;
                case '/':
                    value =  pop1 /pop;
            }
            return value;

    }

    private static boolean hasPrecedenceCharInStack(char aChar, Character peek) {
        if(peek == '(' || peek == ')'){
            return false;
        }if ((aChar == '*' || aChar == '/') && (peek == '+' || peek == '-')){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args){
        System.out.println(ExpressionEvaluator.evaluate("100 * ( 2 * 12 + 2 ) / 14"));
    }
}
