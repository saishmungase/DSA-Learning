
class LinkList{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public Node head;
    public Node tail;
    public int size = 0;

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }
}


public class LLQuestions{

    static void removeNAfterM(int n, int m, LinkList.Node head){
        LinkList.Node node = head;
        LinkList.Node prev = null;
        
        while (node != null) {
            for (int i = 1; i < m && node != null; i++) {
                node = node.next;
            }
            
            if (node == null) return; 
            
            prev = node;
            node = node.next; 
            
            for (int i = 0; i < n && node != null; i++) {
                node = node.next;
            }
            
            prev.next = node;
        }
    }

    static void swapData(int a, int b, LinkList.Node head){
        LinkList.Node node = head;
        LinkList.Node first = null;
        LinkList.Node second = null;
        int count = 1;
        while (node != null) {
            if(count == a){
                first = node;
            }else if(count == b){
                second = node;
                break;
            }
            count ++;
            node = node.next;
        }
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }

    static void oddAfterEven(LinkList.Node head){
        LinkList.Node node = head;
        LinkList.Node evenHead = null; 
        LinkList.Node evenTail = null;

        while (node != null) {
            if((node.data)%2==0){
                if(evenHead == null){
                    evenHead = node;
                    evenTail = evenHead;
                }
                else{
                    evenTail = evenTail.next;
                    evenTail = node;
                }
            }
            else{
                if(evenTail == null){
                    evenTail.next = node;
                    evenTail = evenTail.next;
                }
            }
            node = node.next;
        }
        if(evenTail != null){
            evenTail.next = null;
        }
    }

    public static void main(String[] args) {
        LinkList ll = new LinkList();
        ll.addLast(8);
        ll.addLast(12);
        ll.addLast(10);
        ll.addLast(5);
        ll.addLast(4);
        ll.addLast(1);
        ll.addLast(6);
        // removeNAfterM(2, 3, ll.head);
        // swapData(3, 5, ll.head);
        oddAfterEven(ll.head);
        ll.printList();
    }
}
