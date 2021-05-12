public class RearrangeLinkedList {
    Node originalHead, secondHead;

    public static void main(String[] args) {
        RearrangeLinkedList ll = new RearrangeLinkedList();
        ll.originalHead = new Node(1);
        /*ll.originalHead.next = new Node(2);
        ll.originalHead.next.next = new Node(3);
        ll.originalHead.next.next.next = new Node(4);
        ll.originalHead.next.next.next.next = new Node(5);
        ll.originalHead.next.next.next.next.next = new Node(6);*/

        ll.rearrangeNodes(ll.originalHead);
        ll.printList(ll.originalHead);

    }

    public void printList(Node head){
        Node curr = head;
        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public Node rearrangeNodes(Node head){

        if(head == null || head.next == null){
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        Node rEvenHead = reverseList(evenHead);
        odd.next = rEvenHead;
        return head;
    }

    public Node reverseList(Node secondHead){
        Node prev = null;
        Node next = null;
        Node curr = secondHead;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    private static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}
