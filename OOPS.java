import java.util.function.Supplier;

public class OOPS {
    public static void main(String args[]){
    //    Dog dobby=new Dog();
    //    dobby.legs=4;
    //    dobby.eat();
    //    System.out.println(dobby.legs);
    Bird Battak=new Bird(); //object Battak class Bird Bird() constructor
    Battak.breathe();
    Battak.color="white";
    System.out.println(Battak.color);
    Battak.eat();
    Battak.walk();
Calculator calc=new Calculator();
System.out.println(calc.sum(1, 2));
System.out.println(calc.sum((float)1.5, (float)2.5));
System.out.println(calc.sum(1,2,3));
Queen q=new Queen();
q.moves();

Student s1=new Student();
s1.schoolName="BDPS";

Student s2=new Student();
System.out.println(s2.schoolName);
        // Student s1=new Student();
        // s1.name="pragya";
        // s1.roll=456;
        // s1.password="abcd";
        // s1.marks[0]=100;
        // s1.marks[1]=90;
        // s1.marks[2]=80;
        // Student s2=new Student(s1);
        // s2.password="xyz";
        // s1.marks[2]=90;
        // for(int i=0;i<3;i++){
        //     System.out.println(s2.marks[i]);
        // }
    }
}

// class Student{
//     String name;
//     int roll;
//     String password;
//     int marks[];


    // shallow copy constructor-refer to the same array,reflect changes in second obj when changes in first array
    // Student(Student s1){
    //     marks =new int[3];
    //     this.name=s1.name;
    //     this.roll=s1.roll;
    //     this.marks=s1.marks;
    // }
    //deep copy constructor-different array created for the second obj changes in first does not changes in other array,only copy goes into the second
//     Student(Student s1){
//         marks =new int[3];
//         this.name=s1.name;
//         this.roll=s1.roll;
//         for(int i=0;i<marks.length;i++){
//         this.marks[i]=s1.marks[i];
//         }
//     }
// Student(){
//     marks=new int[3];
//     System.out.println("constructor is called...");
// }
// Student(String name){
//     marks =new int[3];
//     this.name=name;
// }
// Student(int roll){
//     marks=new int[3];
//     this.roll=roll;
// }
//Base class
 abstract class Animal{ //abstract class-does not create object,but constructor create
    String color;
    Animal(){ //constructor called in hierrachy-first call base then to the child
         color="red";
    }
    
    void eat(){
        System.out.println("eats anything");
    }

    void breathe(){
        System.out.println("breathes");
    }
    abstract void walk(); //abstract function-only gives idea to child class to implement function
}

//Derived class /subclass
// class Fish extends Animal {
//     int fins;

//     void swim(){
//         System.out.println("swim in water");
//     }
// }

class Mammal extends Animal{
   // super(); //super is used to extract properties,function of their immediate parent class,by default present in java
    void walk(){
        System.out.println("walks on 4 legs");
    }
}

class Fish extends Animal{
    void swim(){
        System.out.println("swim");
    }
    void walk(){
        System.out.println("walks not");
    }
}

class Bird extends Animal{
    void fly(){
        System.out.println("fly");
    }
    void eat(){  //method overriding-same function name with same parameter but different work,run time polymorphism-they don't know what to do before
        System.out.println("eats fruits");
    }
    void walk(){
        System.out.println("walks on fly");
    }
}
class Calculator{   //method overloading-same function name with different parameter,compile type polymorphism-because function knows what to do
    int sum(int a,int b){
        return a+b;
    }

    float sum(float a,float b){
        return a+b;
    }

    int sum(int a,int b,int c){
        return a+b+c;
    }
}

interface ChessPlayer{ //total abstraction,blueprint of class,multiple inheritance
    void moves();
}

class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up,down,left,right,diagonal(in all 4 dirns)");
    }
}

class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up,down,left,right");
    }
}

class King implements ChessPlayer{
    public void moves(){
        System.out.println("up,down,left,right,diagonal(by 1 step)");
    }
}

class Student{
    String name;
    int roll;

    static String schoolName; //does not change,reference to a single memory location

    void setName(String name){
        this.name=name;
    }
    String getName(){
        return this.name;
    }
}
// class Dog extends Mammal{
//     String breed;
// }