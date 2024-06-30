import java.util.*;

public class Strings {
    public static void printLetters(String str){
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+" ");
        }
        System.out.println();
    }
    public static boolean isPalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            int n=str.length();
            if(str.charAt(i)!=str.charAt(n-1-i)){
                //not a palindrome
                return false;
        }
    }
    return true;
    }
    public static float getShortestPath(String path){
        int x=0,y=0;
        for(int i=0;i<path.length();i++){
            char dir=path.charAt(i);
            //South
            if(dir=='S'){
                y--;
            }
            //North
            else if(dir=='N'){
                y++;
            }
            //West
            else if(dir=='W'){
                x--;
            }
            //East
            else{
                x++;
            }

        }
        int x2=x*x;
        int y2=y*y;
        return (float)Math.sqrt(x2+y2);
    }
    public static String toUpperCase(String str){
        StringBuilder sb=new StringBuilder("");
        char ch=Character.toUpperCase(str.charAt(0)); //ch me store kar denge index 0 ka character uppercase me
        sb.append(ch); //sb me append kar denge ch ko 
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' '&& i<str.length()-1){
                sb.append(str.charAt(i)); //sb me space ko append karenge
                i++;
                sb.append(Character.toUpperCase(str.charAt(i))); //sb me append karenge upper case ka character jo space ke badd ayega
            }else{
                sb.append(str.charAt(i)); //uske badd same character append karenge
            }
        }
        return sb.toString();
    }
    public static String compress(String str){
        String newStr="";
        for(int i=0;i<str.length();i++){
            Integer count=1;
            while (i<str.length()-1 && str.charAt(i)==str.charAt(i+1)) {
                count++;
                i++;
            }
            newStr+=str.charAt(i); //newstr me char dalleng
            if(count>1){
            newStr+=count.toString();
            } 
        }
        return newStr;
    }
    public static void main(String args[]){
        // char arr[]={'a','b','c','d'};
        // String str="abcd";
        // String str2=new String("xyz");

        // //strings are IMMUTABLE-not changable in original string
        // Scanner sc=new Scanner(System.in);
        // String name;
        // name=sc.nextLine(); //sc.next()-only print first word of sentence and sc.nextLine()-print all the words of the sentence
        // System.out.println(name);
        // String fullName="sharavani sundar";
        // System.out.println(fullName.length());
        //concatenation
        // String firstName="pragya";
        // String lastName="himanshu";
        // String fullName=firstName+" "+lastName;
        // System.out.println(fullName.charAt(0));
        // printLetters(fullName);
        // String str="racecar";
        // System.out.println(isPalindrome(str));
        String path="WNEENESENNN";
        System.out.println(getShortestPath(path));
        String s1="aditi";
        String s2="aditi";
        String s3=new String("aditi");
        if(s1.equals(s3)){
            System.out.println("Strings are equal");
        }else{
            System.out.println("Strings are not equal");
        }
        System.out.println(s3.substring(0,3));
        String fruits[]={"apple","mango","banana"};
        String largest=fruits[0];
        for(int i=0;i<fruits.length;i++){
            if(largest.compareTo(fruits[i])<0){
                largest=fruits[i];

            }
        }
        System.out.println(largest);
        StringBuilder sb=new StringBuilder("");
        for(char ch='a';ch<='z';ch++){
            sb.append(ch);
        } //o(26)
     System.out.println(sb);
     System.out.println(sb.length());
      //String str="hi, i am akhansha";

     //System.out.printStringln(toUpperCase(str));
     String str="aaabbbbcccdd";
     System.out.println(compress(str));
    }
    }
