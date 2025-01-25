package org.example.dsa;

 // Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class MergeKLIst {

      public static void main(String[] args){
          ListNode[] lists = new ListNode[3];
          ListNode list1= new ListNode(1);
          list1.next=new ListNode(4);
          list1.next.next=new ListNode(5);
          lists[0] = list1;
          ListNode list2= new ListNode(1);
          list2.next=new ListNode(3);
          list2.next.next=new ListNode(4);
          lists[1] = list2;
          ListNode list3= new ListNode(2);
          list3.next=new ListNode(6);
         // list1.next.next=new ListNode(5);
          lists[2] = list3;
          ListNode res = mergeKLists(lists);
          while(res.next!=null){
              System.out.print(res.val+",");
              res=res.next;
          }
          System.out.print(res.val);

      }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        for(int i=0;i<lists.length-1;i++){
            lists[i+1]=merge(lists[i],lists[i+1]);
        }
        return lists[lists.length-1];

    }

    //[[1,4,5],[1,3,4],[2,6]]

    public static ListNode merge(ListNode list1, ListNode list2){
        ListNode l = new ListNode(0);
        ListNode p3=l;
        ListNode p1=list1;
        ListNode p2=list2;

        while(p1!=null && p2!=null){
            if(p1.val<=p2.val){
                p3.next=p1;
                p1=p1.next;
            }
            else{
                p3.next=p2;
                p2=p2.next;
            }
            p3=p3.next;
        }
        p3.next=(p1!=null)?p1:p2;
        return l.next;

    }
}
