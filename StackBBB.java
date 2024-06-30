import java.util.*;
public class StackBBB {
    public static void pushAtBottom(Stack<Integer> s,int data){
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top=s.pop(); //upar jate samay stack ko khali kar denge
        pushAtBottom(s, data);  //stack khali ho gaye to push kar denge 
        s.push(top);  //uske badd top ko push karenge 
    }

    public static String reverseString(String str){
        Stack<Character> s=new Stack<>();
        int idx=0;
        while (idx<str.length()) {
            s.push(str.charAt(idx)); //stack me push kiye str ka char
            idx++;
        }

        StringBuilder result=new StringBuilder("");
        while (!s.isEmpty()) {
            char curr=s.pop();
            result.append(curr);  //result me pop char ko dalte chale jayi
        }
        
        return result.toString();
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }

        int top=s.pop(); //uper jate samay stack ko pop karenge
        reverseStack(s); //uske badd reverse karenge
        pushAtBottom(s, top); //uske badd push karenge
    }

    public static void printStack(Stack<Integer> s){
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void main(String args[]){
        Stack<Integer> s=new Stack<>(); //stack implementation using java collection framework
        s.push(1);
        s.push(2);
        s.push(3);
        //3,2,1
        reverseStack(s);
        printStack(s);
        //1,2,3

        pushAtBottom(s,4);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
        String str="abc";
        String result=reverseString(str);
        System.out.println(result);
    }
}
