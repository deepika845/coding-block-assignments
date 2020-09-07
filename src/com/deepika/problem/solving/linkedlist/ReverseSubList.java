package com.deepika.problem.solving.linkedlist;

public class ReverseSubList {
    Node head;
    Node tail;
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
            next = null;
        }
    }
    public void reverseSubList(int x,int y){
        Node curr =head;
        int count =1;
        Node prevX= null;
        while (count<x){
            prevX=curr;
            curr=curr.next;
            count+=1;
        }
        Node nodeX = curr;
        while (count<y){
            curr=curr.next;
            int hn =curr.value;
            count+=1;
        }
        Node nodeY =curr;
        Node afterY =curr.next;
        Node iterator = nodeX;
        Node previous =prevX;
        Node next = iterator;
        while (next!=nodeY){
             next =iterator.next;
             int d = next.value;
            iterator.next= next.next;
            if(previous==null){
                next.next=head;
                head=next;

            }
            else {
            next.next=previous.next;
            previous.next=next;
            }
        }


    }
    public void printList(){
        Node curr =head;
        while (curr!=null){
            System.out.println(curr.value);
            curr=curr.next;
        }
    }
    public static void main(String[] args) {
        ReverseSubList rs = new ReverseSubList();
        rs.head = rs.new Node(3);
        rs.head.next = rs.new Node(2);
        rs.head.next.next = rs.new Node(5);
        rs.head.next.next.next = rs.new Node(4);
        rs.head.next.next.next.next = rs.new Node(-1);
        rs.head.next.next.next.next.next= rs.new Node(-9);
        //rs.reverseSubList(1,5);
        rs.reverseKthTime(3);
        rs.printList();

    }
    private void reverseKthTime(int k){
        reverseKthTime(k,null,head,0,2);
    }

    private void reverseKthTime(int k,Node prev, Node curr,int m,int n) {
        if(m==n){
            return;
        }
        int count =1;
        int prevtt=0;
        if(prev!=null){
         prevtt=prev.value;
        }
        int currtt=curr.value;
        //Node curr = head;
        Node ahead =null;
        //Node prev = null;

           while (count<k){
            ahead = curr.next;
            int x = ahead.value;
            curr.next=ahead.next;
            if(prev==null) {
                ahead.next = head;
                head =ahead;
            }
            else{
                int vv=prev.next.value;
                ahead.next=prev.next;
                prev.next=ahead;
            }
            count++;
            //prev=curr;
        }
            reverseKthTime(k,curr,curr.next,m+1,n);


    }
}
