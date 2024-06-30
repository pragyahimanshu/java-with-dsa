import java.util.ArrayList;


public class List {
    public static void main(String args[]){
        //ArrayList-variable size datastore ,java collection framework,inbuilt
        ArrayList<Integer> list=new ArrayList<>();
        //add element
        list.add(1); //objectname.add(value); //0(1)
        list.add(2);
        list.add(3);
        list.add(1,11); //objectname.add(index,value);
        System.out.println(list);
        System.out.println(list.size()); 
        
        // //maximum element
        // int max=Integer.MIN_VALUE;
        // for(int i=0;i<list.size();i++){
        //     // if(max<list.get(i)){
        //     //     max=list.get(i);
        //     max=Math.max(max, list.get(i)); //compare max with list element and return maximum
        //     }
        // }
        

        //print the arraylist
        for(int i=0;i<list.size();i++){
            System.out.println("element of the list "+ list.get(i)+ " ");
        }
     System.out.println();
     //Reverse print
     for(int i=list.size()-1;i>=0;i--){
        System.out.print(list.get(i)+" ");
     }
     System.out.println();
        //get element
        int element=list.get(2); //objectname.get(index); //0(1)
        System.out.println(element);
       
        //delete element
        list.remove(2);  //objectname.remove(index); //0(n)
        System.out.println(list);

        //set element
        list.set(2,10); //objectname.set(index,value); //0(n)
        System.out.println(list);

        //contains element
        System.out.println(list.contains(1)); //objectname.contains(value); //0(n)
    

    }
}
