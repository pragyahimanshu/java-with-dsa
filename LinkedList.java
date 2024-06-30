public class LinkedList {
    //creation of single node class
    public static class Node {
    int data;
    Node next;

    public Node(int data){
        this.data=data;
        this.next=null;
    }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){  //0(1)
        //step1=create new node
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        //step2-newNode next=head
        newNode.next=head; //link
        //step3-head=newNode
        head=newNode;
    }
    public void addLast(int data){  //0(1)
        //step1=create new node
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        //step2- tail next=newNode
        tail.next=newNode;
        //step3-newNode=tail
        tail=newNode;
    }
    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void add(int idx,int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newnNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while (i<idx-1) {
            temp=temp.next;
            i++;
        }
       //i=idx-1;temp->prev
       newnNode.next=temp.next;
       temp.next=newnNode;

    }
    public int removeFirst(){
        if(size==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }
    public int removeLast(){
        if(size==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        //prev: i=size-2
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data; //temp.data
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }
    public int itrSearch(int key){
        Node temp=head;
        int i=0;
        while (temp!=null) {
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        //key not found
        return -1;
    }
    public static int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next, key); //recursion
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key){
        return helper(head, key);
    }
    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while (curr!=null) {
            next=curr.next;
            curr.next=prev; 
            prev=curr; //curr ko prev bna denge
            curr=next; //next ko curr bna denge
        }
        head=prev; //prev ko head bna denge
    }

    public void deleteNthfromEnd(int n){
        //calculate size
        int sz=0; //sz=size
        Node temp=head;
        while (temp!=null) {
            temp=temp.next;
            sz++;
        }
        if(n==sz){  //deleting index=head
            head=head.next; //removeFirst
            return;
        }
        //sz-n
        int i=1;
        int iToFind=sz-n;  //temp ko prev pe node se pehle jise delete karna hai
        Node prev=head;
        while (i<iToFind) { //jub tak node jisko delete karna hai uske pehle bale node tak karenge
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;

    }
    //Slow-Fast Approach
    public Node findMid(Node head){  //Helper
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next; //+1
            fast=fast.next.next; //+2
        }
        return slow; //slow is my midNode
    }
    public boolean checkPalindrome(){
        if(head==null || head.next==null){
            return true; 
        }
        //find middle
        Node mid=findMid(head);

        //Reverse 2nd half
        Node curr=mid;
        Node prev=null;
    
        while (curr!=null) {
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;
        Node left=head;
        //check if equal
        while (right!=null) {
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;

    }

    public  static boolean isCycle(){
        Node slow=head;
        Node fast=head;

        while (fast!=null && fast.next!=null) {
            slow=slow.next; //+1
            fast=fast.next.next; //+2
            if(slow==fast){
                return true; //cycle exists
            }
        }
        return false; //cycle does not exist
    }

    public static void removeCycle(){
        //detect cycle
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                cycle=true;
                break;
            }
        }
        if(cycle==false){
            return;
        }

        //find meeting point
        slow=head;
        Node prev=null; //last node
        while (slow!=fast) {
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }

        //remove cycle-> last.next=null
        prev.next=null;
    }

    private Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;

        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow; //mid node
    }
    
    private Node merge(Node head1,Node head2){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;

        while (head1!=null && head2!=null) {
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
            while (head1!=null) {
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }

            while (head2!=null) {
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
            return mergedLL.next;
        }
    

    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }

        //find mid
        Node mid=getMid(head);
        //left & right MS
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);
    }

    public void zigZag(){
        //find mid
        Node slow=head;
        Node fast=head.next;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;

        //reverse 2nd half
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;

        while (curr !=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node left=head;
        Node right=prev;
        Node nextL,nextR;


        //alt merge-zig-zag merge
        while (left!=null && right!=null) {
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            left=nextL;
            right=nextR;
        }
    }

  

    public static void main(String args[]){

        LinkedList ll=new LinkedList();
        //ll.print();
        ll.addLast(1);
        //ll.print();
        ll.addLast(2);
        //ll.print();
        ll.addLast(3);
        //ll.print();
        ll.addLast(4);
        //ll.print();
        ll.addLast(5);
        //1->2->3->4->5
        
        ll.print();
        ll.zigZag();
       // ll.head=ll.mergeSort(ll.head);
        ll.print();
        
    }
}
