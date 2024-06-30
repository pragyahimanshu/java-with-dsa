import java.util.*;

public class arraylist {
    public static void swap(ArrayList<Integer> list,int idx1,int idx2){
        int temp=list.get(idx1);
        list.set(idx1,list.get(idx2));  //idx1 me idx2 ka value
        list.set(idx2, temp);
    }
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);
        
        int idx1=1,idx2=3;
        System.out.println(list);
        swap(list, idx1, idx2);
        System.out.println(list);
        
        System.out.println(list);
        Collections.sort(list);  //arrange the list in ascending order
        System.out.println(list);

        //descending
        Collections.sort(list,Collections.reverseOrder());
        //Collections.reverseOrder()->comparator-it is used to build logic of function to sort in descending order
        System.out.println(list);

     
        ArrayList<ArrayList<Integer>> mainList=new ArrayList<>();
        ArrayList<Integer>listA=new ArrayList<>();
        ArrayList<Integer>listB=new ArrayList<>();
        ArrayList<Integer>listC=new ArrayList<>();
        
        for(int i=1;i<=5;i++){
            listA.add(i*1); //1 2 3 4 5
            listB.add(i*2); //2 4 6 8 10
            listC.add(i*3); //3 6 9 12 15
        }

        mainList.add(listA);
        mainList.add(listB);
        mainList.add(listC);

        System.out.println(mainList);

        //nested loops
        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer> currList=mainList.get(i); //current list me value 
            for( int j=0;j<currList.size();j++){
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }


    }
}
