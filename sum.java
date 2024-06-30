import java.util.*;

public class sum {
    public static void main(String args[]){
       Scanner sc=new Scanner(System.in);
int a=sc.nextInt();
int b=sc.nextInt();
float radius=sc.nextFloat();
int c=15;
long d=c; //type conversion
float marks=99.999f;
int f=1;
float g=29.353f;
long h=29;
double i=14;
double ans=f+g+h+i;
System.out.println(ans); //type promotion
int marks2=(int)marks; //type casting
System.out.println(marks2);
float area=3.14f*radius*radius;
int sum=a+b;
int product=a*b;
System.out.println(sum);
System.out.println(product);
System.out.println(area);
System.out.println(d);
    }
}