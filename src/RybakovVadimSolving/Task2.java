package RybakovVadimSolving;

import java.util.Stack;

public class Task2 {

    public static boolean checkBracket(String exp) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    System.out.println("Ошибка в " + i + " позиции");
                    return false;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(' || ch == ']' && top != '[' || ch == '}' && top != '{') {
                    System.out.println("Ошибка в " + i + " позиции: несовпадение скобок");
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Ошибка: скобки не совпадают");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String exp1 = "dhs(fjds{[lkdfskjdf{lSDFj}]}lkjsdj)fldsfj";
        String exp2 = "jkhads(((jkjhjkdsf{jkfd[HK]lhjjkdfs))kjljhsfd}[";
        String exp3 = "jkdas(kk";

        System.out.println(checkBracket(exp1));
        System.out.println(checkBracket(exp2));
        System.out.println(checkBracket(exp3));

    }
}
