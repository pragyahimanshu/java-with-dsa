import java.util.*;
public class liarray {
    // public static int storeWater(ArrayList<Integer> height){
    // int maxWater=0;
    // //brute force-0(n^2)
    // for(int i=0;i<height.size();i++){        //line1
    //     for(int j=i+1;j<height.size();j++){  //line2

    //         int ht=Math.min(height.get(i), height.get(j)); //heightline1,heightline2
    //         int width=j-i; //(index)line1-(index)line2

    //         int currWater=ht*width;
    //         maxWater=Math.max(maxWater, currWater);

    //     }
    // }
    // return maxWater;
    // }

    //2 pointer approach-0(n)
    public static int storeWater(ArrayList<Integer>height){
        int maxWater=0;
        int lp=0;
        int rp=height.size()-1;
        while (lp<rp) {
            //calculate water area
            int ht=Math.min(height.get(lp), height.get(rp));
            int width=rp-lp;
            int currWater=ht*width;
            maxWater=Math.max(maxWater, currWater);
            //update ptr
            if(height.get(lp)<height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxWater;
        }

        public static boolean pairSum1(ArrayList<Integer>  height,int target){
            int lp=0;
            int rp=height.size()-1;
            while(lp!=rp){
                //case1
                if(height.get(lp)+height.get(rp)==target){
                    return true;
                }
                //case2
                if(height.get(lp)+height.get(rp)<target){
                    lp++;
                }else{
                    //case3
                    rp--;
                }
            }
            return false;
                }
                //0(n)
         public static boolean pairSum2(ArrayList<Integer> height,int target){  //height=list
            int bp=-1; //bp-breaking point
            int n=height.size();
            for(int i=0;i<height.size();i++){
                if(height.get(i)>height.get(i+1)){  //breaking point
                    bp=i;
                    break;
                }
            }
            int lp=bp+1; //smallest
            int rp=bp; //largest
            while (lp!=rp) {
                //case1
                if(height.get(lp)+height.get(rp)==target){
                    return true;
                }
                //case2
                if(height.get(lp)+height.get(rp)<target){
                    lp=(lp+1)%n;  //list size
                }else{
                    //case3
                    rp=(n+rp-1)%n;
                }
            }
            return false;
         }
    public static void main(String args[]){
        ArrayList<Integer> height=new ArrayList<>();
        // //1,8,6,2,5,4,8,3,7
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);   

        // System.out.println(storeWater(height));
        //1,2,3,4,5-sorted 
        // height.add(1);
        // height.add(2);
        // height.add(3);
        // height.add(4);
        // height.add(5);
        // int target=5;
        // System.out.println(pairSum1(height, target));

        //11,15,6,8,9,10-sorted & rotated
        height.add(11);
        height.add(15);
        height.add(6);
        height.add(8);
        height.add(9);
        height.add(10);
        int target=16;
        System.out.println(pairSum2(height, target));
     }
}
