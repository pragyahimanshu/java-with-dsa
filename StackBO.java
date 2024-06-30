import java.util.*;
public class StackBO {
    public static void stockSpan(int stocks[],int span[]){
        Stack<Integer> s=new Stack<>();
        span[0]=1; //oth index ke span ko 1 mann lenge hmesha
        s.push(0); //uske badd stack me push kar denge oth index ka value ke sath index

        for(int i=1;i<stocks.length;i++){
            int currPrice=stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]){  //stack ke peek price se current price jub tak greater hai
                s.pop();  //stack ke chote element ko pop kar denge
            }
            if(s.isEmpty()){
                span[i]=i+1; //stack empty ho gaye to span ko ek badha denge index se
        }else{
            int prevHigh=s.peek();
            span[i]=i-prevHigh; //nahi toh span me value us index me se prevHigh ke index ka ghatav hoga
        }

        s.push(i);
    }
}

public static void main(String args[]){
    int stocks[]={100,80,60,70,60,85,100};
    int span[]=new int[stocks.length];
    stockSpan(stocks,span);

    for(int i=0;i<span.length;i++){
        System.out.println(span[i]+" ");
    }
}
}