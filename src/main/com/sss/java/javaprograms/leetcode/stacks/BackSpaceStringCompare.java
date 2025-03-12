package src.main.com.sss.java.javaprograms.leetcode.stacks;

import java.util.Stack;

public class BackSpaceStringCompare {
    public static void main(String[] args) {
   System.out.print(backspaceCompare("ad#c","ab#c"));
    }
    public static   boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
       for(char ch :  s.toCharArray())
        if(ch != '#'){
            stack1.push(ch);
        }else if (!stack1.isEmpty()) {
            stack1.pop();
        }
        for(char ch :  t.toCharArray())
            if(ch != '#'){
                stack2.push(ch);
            }else if (!stack2.isEmpty()) {
                stack2.pop();
            }
       if(stack1.equals(stack2)){
           return true;
       }
        return false;
    }
}
