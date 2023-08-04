import java.util.Scanner;

class Node
{
    int value;
    Node next;
    Node(int value)
    {
        this.value=value;
    }
}
class LinkedList {
    Node head;
    Node tail;
    int length;
    LinkedList(int value)
    {
        Node newNode=new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }
    LinkedList (){

    }
    void print()
    {
        Node temp=head;
        System.out.println(temp.value);
        temp=temp.next;
        while (temp!=head)
        {
            System.out.println(temp.value);
            temp=temp.next;
        }
    }
    void getHead()
    {
        System.out.println(head.value);
    }
    void getTail()
    {
        System.out.println(tail.value);
    }
    void getLength()
    {
        System.out.println(length);
    }
    void prepend(int value)
    {
        Node newNode=new Node(value);
        newNode.next=head;
        head=newNode;
        tail.next=head;
        length++;
    }
    void append(int value)
    {
        Node newNode=new Node(value);
        if(length==0)
        {
            head=newNode;
            tail=newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
            newNode.next=head;
        }
        length++;
    }
    Node removefirst()
    {
        Node temp=head;
        head=head.next;
        temp.next=null;
        tail.next=head;
        return temp;
    }
    Node getNode(int index)
    {
        if(index<0 || index>length)
        {
            return null;
        }
        Node temp=head;
        for(int i=0;i<index;i++)
        {
            temp=temp.next;
        }
        System.out.println(temp.value);
        return temp;
    }
    void reverse()
    {
        Node temp=head;
        head=tail;
        tail=temp;
        Node before=null;
        while (temp!=null)
        {
            Node after=temp.next;
            temp.next=before;
            before=temp;
            temp=after;
        }
    }

    Node remove()
    {
        if(length==0)
        {
            return null;
        }
        else
        {
            Node temp=head;
            temp=temp.next;
            Node prev=head;
            while(temp!=tail)
            {
                prev=temp;
                temp=temp.next;
            }
            prev.next=head;
            tail=prev;
            length--;
            if(length==0)
            {
                head=null;
                tail=null;
            }
            return temp;
        }

    }
    public static void main(String[] args) {

        LinkedList ml=new LinkedList();
        Scanner scanner =new Scanner(System.in);
        int v=0;

        do {

            System.out.println("Enter -1 for exit:");
            int e= scanner.nextInt();

            int in=scanner.nextInt();
            ml.append(in);
            v=in;
        }while (v!=-1);
        System.out.println("Enter 100 for prepend:");
        System.out.println("Enter 101 for remove:");
        System.out.println("Enter 102 for removeFirst:");
        System.out.println("Enter 103 for append:");
        System.out.println("Enter 104 for print:");
        int ch=scanner.nextInt();
        switch (ch){
            case 100:
                int k=scanner.nextInt();
                ml.prepend(k);
                break;
            case 101:
                ml.remove();
                break;
            case 102:
                ml.removefirst();
                break;
            case 103:
                int v1=scanner.nextInt();
                ml.append(v1);
                break;
            case 104:
                ml.print();
                break;

        }
        //ml.getTail();
        //ml.getHead();
        System.out.println("________");
        ml.print();
    }
}