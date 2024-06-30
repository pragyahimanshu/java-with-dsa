import java.util.*;
import java.util.LinkedList; 

public class ueueB {
    static class Stack{
        static Queue<Integer> q1=new LinkedList<>();
        static Queue<Integer> q2=new LinkedList<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }

        public static int pop(){
            if(isEmpty()){
                System.out.println("empty stack");
                return -1;
            }
            int top=-1;

            //case 1
            if(!q1.isEmpty()){  //q1 empty jub tak nahi hai
                while (!q1.isEmpty()) {  //tab tak q1 empty nahi hai
                    top=q1.remove(); //top ko q1 ka value assign karo
                    if(q1.isEmpty()){  //agar q1 last aa gaya toh break kar do
                        break;
                    }
                    q2.add(top); //nahi toh q1 jub tak last element nahi aa gata tub tak q2 me q1 ka value dalte raho
                }
            }else{  //case 2
                while (!q2.isEmpty()) {
                    top=q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                    }
                }
                return top;
            }

            public static int peek(){
                if(isEmpty()){
                    System.out.println("empty stack");
                    return -1;
                }
                int top=-1;
    
                //case 1
                if(!q1.isEmpty()){  //q1 empty jub tak nahi hai
                    while (!q1.isEmpty()) {  //tab tak q1 empty nahi hai
                        top=q1.remove(); //top ko q1 ka value assign karo
                        q2.add(top); //nahi toh q1 jub tak last element nahi aa gata tub tak q2 me q1 ka value dalte raho
                    }
                }else{  //case 2
                    while (!q2.isEmpty()) {
                        top=q2.remove();
                        q1.add(top);
                        }
                    }
                    return top;
            }
        }
            public static void main(String args[]){
                Stack s=new Stack();
                s.push(1);
                s.push(2);
                s.push(3);

                while (!s.isEmpty()) {
                    System.out.println(s.peek());
                    s.pop();
                }
            }
        }  

    

