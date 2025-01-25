/**
 * DLL'
 * 1. insert' at index,data
 * 2. remove at(index)
 * 3. reverse LL
 * 4. Display entire LL
 */

/**
 * 1->2->3->4->null
 * 1->2->4
 */

public class FicoTest {

    static  int i=0;
    static TNode head=null;
    static TNode tail=null;
    public static void main(String[] args) {

        insert(2,0);
        display();

        insert(1,0);
        display();

        insert(3,3);
        display();

        insert(4,3);
        display();

        remove(3);
        display();

        TNode  n = reverse(head);
        System.out.println("After reverseing..");
        while (n!=null){
            System.out.println(n.data+",");
            n=n.next;
        }

    }

    static void insert(int data, int idx){

        if(head==null){
            head=new TNode(data);
            tail=head;
        }
        else if(idx==0){
            TNode n = new TNode(data);
            n.next=head;
            head=n;

        }
        else if(idx>i) {
            TNode n = new TNode(data);
            tail.next=n;
            tail=tail.next;
        }
        else {
            TNode ptr = head;
            for (int k = 1; k < idx-1; k++) {
                ptr = ptr.next;
            }
            TNode ptr1 = ptr.next;
            TNode n = new TNode(data);
            ptr.next = n;
            n.next = ptr1;
        }

        i++;
        }


    static void remove(int idx){
        if(idx>i) return;
        if(idx==1){
            head=head.next;
        }
        else {
            TNode ptr = head;
            for (int k = 1; k < idx - 1; k++) {
                ptr = ptr.next;
            }
            if (ptr != null && ptr.next != null)
                ptr.next = ptr.next.next;
        }
        i--;

        }



    static void display(){
        TNode ptr=head;
        while (ptr!=null){
            System.out.print(ptr.data + ",");
            ptr=ptr.next;
        }
        System.out.println();

    }

    static TNode reverse(TNode head){

        TNode prev=null;
        TNode curr = head;
        while (curr!=null){
            TNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;


        }
        return prev;


    }


}

class TNode{

    int data;
    TNode next;

    TNode(int data){
        this.data=data;
    }


}
