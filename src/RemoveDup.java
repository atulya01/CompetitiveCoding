public class RemoveDup {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);

        removeDuplicate(head);
        printList(head);
    }

    public static void removeDuplicate(Node head){
        if(head == null || head.next == null){
            return;
        }

        Node curr = head;
        while(curr != null && curr.next != null){
            if(curr.data == curr.next.data){
                curr.next = curr.next.next;
            }
            else{
                curr = curr.next;
            }
        }
    }

    public static void printList(Node head){
        Node curr = head;
        while(curr !=null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
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


