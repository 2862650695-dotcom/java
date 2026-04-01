import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class BracketBalanceChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入括号字符串：");
        String bracketStr = scanner.nextLine();
        scanner.close();

        if (isBracketBalanced(bracketStr)) {
            System.out.println("括号字符串匹配且平衡！");
        } else {
            System.out.println("括号字符串不匹配/不平衡！");
        }
    }

 
    public static boolean isBracketBalanced(String str) {
      
        Deque<Character> stack = new ArrayDeque<>();

    
        for (char c : str.toCharArray()) {
    
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if (c == ')' || c == ']' || c == '}') {
               
                if (stack.isEmpty()) {
                    return false;
                }
              
                char top = stack.pop();
                if (!isPair(top, c)) {
                    return false;
                }
            }
            
            else {
                continue;
            }
        }

       
        return stack.isEmpty();
    }

    
    private static boolean isPair(char left, char right) {
        return (left == '(' && right == ')')
                || (left == '[' && right == ']')
                || (left == '{' && right == '}');
    }
}