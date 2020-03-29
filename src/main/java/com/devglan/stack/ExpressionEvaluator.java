package com.devglan.stack;

import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluate(String expression) {
        char[] chars = expression.toCharArray();
        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == ' '){
                continue;
            }else if(chars[i] >= '0' && chars[i] <= 9){
                StringBuilder builder = new StringBuilder("");
                while (chars[i] >= '0' && chars[i] <= 9){
                    builder.append(chars[i++]);
                }
                values.push(Integer.valueOf(builder.toString()));
            }else if(chars[i] == '('){
                //if () then calculate and push to stack
                ops.push(chars[i]);
            }else if(chars[i] == ')'){
                while (ops.peek() != '(')
                    values.push(performOperation(values.pop(), values.pop(), ops.pop()));
                ops.pop();
            }else if(chars[i] == '+' || chars[i] == '-' || chars[i] == '+' || chars[i] == '/'){
                while (!ops.isEmpty() && hasPrecedence(chars[i], ops.peek())){
                    //if highest precedence in the stack then only peform operation from the stack
                    values.push(performOperation(values.pop(), values.pop(), ops.pop()));
                }
                ops.push(chars[i]);
            }
        }
        while (!ops.empty())
            values.push(performOperation(values.pop(), values.pop(), ops.pop()));

        // Top of 'values' contains result, return it
        return values.pop();
    }

    private static boolean hasPrecedence(char aChar, Character peek) {
        if(peek == '(' || peek == ')'){
            return false;//as ( or ) this operation is already peformed
        }if((aChar == '*' || aChar == '/') && (peek == '+' || peek == '-')){
            return false;
        }else
            return true;
    }

    private static Integer performOperation(Integer pop, Integer pop1, Character pop2) {
        return 0;
    }

    public static void main(String[] args){

        System.out.println(ExpressionEvaluator.evaluate("100 * ( 2 + 12 ) / 14"));

    }
}
