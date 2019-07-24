package cn.list;

/**
 * @ClassName MyLinkList
 * @Description 无头单向非循环单链表
 * @Auther danni
 * @Date 2019/7/24 10:03]
 * @Version 1.0
 **/

public class MyLinkList {
    //头插法
    public Node pushFront(Node head,int data){
        Node node=new Node(data);
        if(head==null){
            return node;
        }
        else {
            node.next = head;
            return node;
        }
    }
    //尾插法
    public Node pushBack(Node head,int data){
        Node node=new Node(data);
        if(head==null){
            return node;
        }
        Node curr=new Node();
        curr=head;
       while(curr.next!=null){
         curr=curr.next;
      }
     curr.next=node;
     return head;
    }
    //头删法
    public Node popFront(Node head){
        if(this.isEmpty(head)){
            System.err.println("链表为空");
            return null;
        }
        return head.next;
    }
    //尾删法
    public Node popBack(Node head){
        if(this.isEmpty(head)){
            System.err.println("链表为空");
            return null;
        }
        Node n=head;
        while(n.next.next!=null){
            n=n.next;
        }
        n.next=null;
        return head;
    }
    //删除指定位置
    public Node popLocation(Node head,int location){
        if(this.isEmpty(head)){
            System.err.println("链表为空");
            return null;
        }
        if(location>this.length(head)){
            System.err.println("指定位置不存在数,无法删除！返回原链表");
            return head;
        }
        Node n=head;
        for (int i = 1; i <location-1 ; i++) {
            n=n.next;
        }
        n.next=n.next.next;
        return head;
    }
    //删除指定元素
    public Node remove(Node head,int datas){
        if(this.isEmpty(head)){
            System.err.println("链表为空");
            return null;
        }
        Node n=head;
        while((n.next.data)!=datas && n!=null){
            n=n.next;
        }
        if(n==null){
            System.err.println("不存在该数，删除失败，返回原链表");
            return head;
        }
        n.next=n.next.next;
        return head;
    }
    //修改指定位置的数
    public Node alter(Node head,int location,int element){
        if(location>this.length(head)){
            System.err.println("指定位置无效，无法修改，返回原链表");
            return head;
        }
        Node n=head;
        for (int i = 1; i <location ; i++) {
            n=n.next;
        }
        n.data=element;
        return head;
    }
    //插入元素在指定位置
    public Node insertLocation(Node head,int location,int element){
        if(location>this.length(head)){
            System.err.println("指定位置无效，无法插入，返回原链表");
            return head;
        }
        Node n=head;
        Node node=new Node(element);
        if(location==1){
            head=this.pushFront(head,element);
        }
        else if(location==(this.length(head)+1)){
           head=this.pushBack(head,element);
        }else{
            for (int i = 1; i <location-1 ; i++) {
                 n=n.next;
             }
            node.next=n.next;
             n.next=node;
        }
        return head;
    }
    //查询指定位置的元素
    public int search(Node head ,int location){
        Node n=head;
        for (int i = 1; i <location ; i++) {
            n=n.next;
        }
        return n.data;
    }
    //判空
    public boolean isEmpty(Node head){
        if(head==null){
            return true;
        }
        return false;
    }
    //返回链表长度
    public int length(Node head){
        int num=0;
        Node n=head;
        while(n!=null){
            num++;
            n=n.next;
        }
        return num;
    }
    //打印链表
    public void printLinkList(Node head){
        if(head==null) {
            System.err.println("单链表为空");
            return ;
        }
        Node curr=new Node();
        curr=head;
        while(curr!=null){
            System.out.print(curr+"-> ");
            curr=curr.next;
        }
        System.out.println("null");
    }
    //就地逆转单链表（设置三个引用）
    public Node ReverseList02(Node head){
        Node p1=null;
        Node p2=head;

        while(p2!=null){
            Node next=p2.next;
            p2.next=p1;
            p1=p2;
            p2=next;
        }
       return p1;
    }
    //就地逆转单链表（设置两个引用）
    public Node ReverseList01(Node head){
        Node p=head;
        Node q=p.next;
        p.next=null;
        while (p != null&&q != null){
            p = q;
            q = q.next;
            p.next = head;
            head = p;
        }
        return p;
    }
    public static void main(String[] args) {
        Node head=new Node();
        head=null;
        MyLinkList l=new MyLinkList();
        head=l.pushBack(head,1);
        head=l.pushBack(head,2);
        head=l.pushBack(head,3);
        head=l.pushFront(head,4);
        head=l.pushFront(head,5);
        head=l.pushFront(head,6);
        l.printLinkList(head);
        head=l.insertLocation(head,2,11);
        l.printLinkList(head);
        head=l.alter(head,3,8);
        l.printLinkList(head);
        System.out.println("该位置元素的值为："+l.search(head,3));
       /* head=l.ReverseList01(head);
        l.printLinkList(head);
        head=l.popBack(head);
        l.printLinkList(head);
        head=l.popFront(head);
        l.printLinkList(head);
        head=l.popLocation(head,5);
        l.printLinkList(head);*/
        /*head=l.remove(head,7);
        l.printLinkList(head);*/
      //  head=l.popLocation(head,4);
        //l.printLinkList(head);
    }
}
class Node{
    int data;
    Node next=null;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }
    //重写toString方法
    public String toString(){
        return String.format("Node(%d)",data);
    }
}

