import java.util.*;

public class activitysorted {
    
    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};

        //end time basis sorted
        int maxAct=0;
        ArrayList<Integer> ans=new ArrayList<>();

        //1st activity
        maxAct=1;
        ans.add(0); //ans arraylist me 1st index ke activity ko add karenge
        int lastEnd=end[0];  //lastend hoga end of activity 1
        for(int i=1;i<end.length;i++){
            if(start[i]>=lastEnd){ //start of next activity must be start from the end of first activity
                //activity select
                maxAct++;
                ans.add(i);
                lastEnd=end[i];
            }
        }

        System.out.println("max activities="+maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
        }
}
