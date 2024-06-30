import java.util.*;
//linear search
public class ArraysCC {
public static int linearSearch(int numbers[],int key){
    for(int i=0;i<numbers.length;i++){
        if (numbers[i]==key) {
            return i;
        }
    }
    return -1;
}
public static int getLargest(int numbers[]){
    int largest=Integer.MIN_VALUE; //-INfinity
    int smallest=Integer.MAX_VALUE; //+INfinity
    for(int i=0;i<numbers.length;i++){
        if(largest<numbers[i]){
            largest=numbers[i];
        }
        if(smallest>numbers[i]){
            smallest=numbers[i];
        }
    }
    System.out.println("smallest value is :"+smallest);
    return largest;
}  
public static int binarySearch(int numbers[],int key){
    int start=0,end=numbers.length-1;
    while (start<=end) {
        int mid=(start+end)/2;
        //comparisons
        if(numbers[mid]==key){
            return mid;
        }
        if(numbers[mid]<key){
            start=mid+1;
        }else{
            end=mid-1;
        }
    }
    return -1;
}  
public static void printPairs(int numbers[]){
    int tp=0;
    for(int i=0;i<numbers.length;i++){
        int curr=numbers[i];
        for(int j=i+1;j<numbers.length;j++){
            System.out.print("("+curr+","+numbers[j]+")");
            tp++;
        }
        System.out.println();
    }
    System.out.println("total pairs="+tp);
}
public static void printSubarrays(int numbers[]){
    int ts=0;
    for(int i=0;i<numbers.length;i++){
        int start=i;
        for(int j=i;j<numbers.length;j++){
            int end=j;
            for(int k=start;k<=end;k++){
                System.out.print(numbers[k]+" "); //subarray
            }
            ts++;
            System.out.println();
        }
        System.out.println();

    }
System.out.println("total subarrays= "+ts);
}
public static void kadanes(int numbers[]){
    int ms=Integer.MIN_VALUE;
    int cs=0;
    for(int i=0;i<numbers.length;i++){
        cs=cs+numbers[i];
        if(cs<0){
            cs=0;
        }
        ms=Math.max(cs, ms);
    }
    System.out.println("our max subarray sum is :" +ms);
}
public static int trappedRainwater(int height[]){
    int n=height.length;
    //calculate left max boundary-array
    int leftMax[]=new int[n];
    leftMax[0]=height[0];
    for(int i=1;i<n;i++){
        leftMax[i]=Math.max(height[i], leftMax[i-1]);
    }
    //calculate right max bound-array
    int rightMax[]=new int[n];
    rightMax[n-1]=height[n-1];
    for(int i=n-2;i>=0;i--){
        rightMax[i]=Math.max(height[i], rightMax[i+1]);
    }
    int trappedWater=0;
    //loop
    for(int i=0;i<n;i++){
        //waterLevel=min(leftmax bound,rightmax bound)
        int waterLevel=Math.min(leftMax[i],rightMax[i]);
        //trapped water=waterLevel-height[i]
        trappedWater+=waterLevel-height[i];
    }
    return trappedWater;
}
public static int buyAndSellStocks(int prices[]){
    int buyPrice=Integer.MAX_VALUE;
    int maxProfit=0;
    for(int i=0;i<prices.length;i++){
        if(buyPrice<prices[i]){
            int Profit=prices[i]-buyPrice;
            maxProfit=Math.max(maxProfit, Profit);
        }else{
            buyPrice=prices[i];
        }
    }
    return maxProfit;
}
public static void main(String args[]){
    int numbers[]={2,4,5,8,10};
    int height[]={4,2,0,6,3,2,5};
int prices[]={7,1,5,3,6,4};

    int key=10;
    
    int index=linearSearch(numbers, key);
    if (index==-1) {
        System.out.println("NOT found");
    }else{
        System.out.println("key is at index :"+index);
    }
    System.out.println("largest value is :"+ getLargest(numbers));
    System.out.println("index for key is :"+binarySearch(numbers, key));
    printPairs(numbers);
    printSubarrays(numbers);
kadanes(numbers);
System.out.println(trappedRainwater(height));
System.out.println(buyAndSellStocks(prices));
}
}
