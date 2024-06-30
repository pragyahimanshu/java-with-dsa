import java.util.*;
import java.util.LinkedList;

public class QueueBBB {
    public static void main(String args[]){
        QueueS<Integer> q=new LinkedList<>(); //java collection framework
        //Queue<Integer> q=new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }
}
