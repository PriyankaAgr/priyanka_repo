import java.util.Stack;

/**
 * E = "a + {[(b*c) + (d*c) ]/(e%f)}" evaluate whether the expression is valid based on brackets,
 * we can check if all the brackets ((), {}, []) are properly opened and closed in the correct order.
 */

//T=o(n)
// Space = O(n)

public class FicoR2Test {

    public static void main(String[] args) {
        String str = "a + {[(b*c] + (d*c) ]/(e%f)}";

        Stack<Character> st = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                st.push(ch);
            } else if (ch == '}' && st.peek() == '{') st.pop();
            else if (ch == ')' && st.peek() == '(') st.pop();
            else if (ch == ']' && st.peek() == '[') st.pop();

        }

        if (st.isEmpty()) System.out.println("Expression is valid");
        else System.out.println("Expression is not valid");
    }


}
