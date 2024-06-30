import java.util.concurrent.Flow.Subscriber;

public class RecursionBasics {
    public static void printDec(int n) {
        if (n == 1) { // base class
            System.out.println(n + " ");
            return;
        }
        System.out.println(n + " "); // print the number
        printDec(n - 1); // function recursive call
    }

    public static void printInc(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");

    }

    public static int fact(int n) {
        if (n == 0) { // base class
            return 1;
        }
        int fnm1 = fact(n - 1); // function recursive call for n-1
        int fn = n * fact(n - 1); // factorial find using fact(n-1)
        return fn; // final value
    }

    public static int calcSum(int n) {
        if (n == 1) { // base case
            return 1;
        }
        int Snm1 = calcSum(n - 1);
        int Sn = n + Snm1;
        return Sn;
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int fnm1 = fib(n - 1);
        int fnm2 = fib(n - 2);
        int fn = fnm1 + fnm2;
        return fn;
    }

    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int firstOccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, key, i + 1);
    }

    public static int lastOccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurence(arr, key, i + 1); // first check forward
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    public static int power(int x, int n) {
        if (n == 0) { // 0(n)
            return 1;
        }
        int xnm1 = power(x, n - 1);
        int xn = x * xnm1;
        return xn;
    }

    public static int optimizedPower(int x, int n) { // 0(logn)
        if (n == 0) {
            return 1;
        }
        int halfPower = optimizedPower(x, n / 2);
        int halfPowerSq = halfPower * halfPower;

        // n is odd
        if (n % 2 != 0) {
            halfPowerSq = x * halfPowerSq;
        }
        return halfPowerSq;
    }

    // tiling problem
    public static int tilingProblem(int n) { // 2*n (floor size) //kitna tarika ka tiles bechane ka
        // base case
        if (n == 0 || n == 1) {
            return 1; // ek tarika
        }
        // kaam
        // vertical choice
        int fnm1 = tilingProblem(n - 1); // ek tiles ko vertically arrange karne ke badd

        // horizontal choice
        int fnm2 = tilingProblem(n - 2); // ek tiles ko horizontally arrange karne ke badd
        int totWays = fnm1 + fnm2;
        return totWays;

    }

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        if (idx == str.length()) { // base class
            System.out.println(newStr);
            return;
        }

        // kaam
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) { // check karenge ke jo current character hai wo map me to nahi hai
            // duplicate
            removeDuplicates(str, idx + 1, newStr, map); // agar map me current character hai to hum agle index pe chale
                                                         // gayenge aur fir se function call dekhenge,duplicate nahi ho
                                                         // shakta hai age badhe

        } else {
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx + 1, newStr.append(currChar), map); //agar duplicate nahi hai to current character ko dall denge apne newstr me
        }
    }
    public static int friendsPairing(int n){  //n is total friend
        if(n==1||n==2){  //base case
            return n;   //n is no.of ways
        }
        //choice
        //single
        int fnm1=friendsPairing(n-1);
         
        //pair
        int fnm2=friendsPairing(n-2);
        int pairWays=(n-1)*fnm2;

        //totalways
        int totWays=fnm1+pairWays;
        return totWays;
    }
    public static void printBinStrings(int n,int lastPlace,String str){
        //base case
        if(n==0){
            System.out.println(str);
            return;
        }
        //kaam
        printBinStrings(n-1, 0, str+"0");
        if(lastPlace==0){
            printBinStrings(n-1, 1, str+"1");
        }
    }

    public static void main(String args[]) {
        int n = 5;
        printDec(n);
        printInc(n);
        System.out.println(fact(n));
        System.out.println(calcSum(n));
        System.out.println(fib(n));
        int arr[] = { 1, 2, 3, 4, 8, 9, 3 };
        System.out.println(isSorted(arr, 0));
        System.out.println(firstOccurence(arr, 2, 0));
        System.out.println(lastOccurence(arr, 3, 0));
        System.out.println(power(2, 10));
        System.out.println(optimizedPower(2, 5));
        System.out.println("total ways to tile in floor : " + tilingProblem(3));
        String str="appnnacollege";
        removeDuplicates(str, 0, new StringBuilder(""),new boolean[26]);
        System.out.println("total ways of friends  :"+friendsPairing(3));
        printBinStrings(3, 0, "");

    }
}
