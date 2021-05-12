public class MiddleElementLL {

    public static void main(String[] args) {
       SingleLinkedList singleLL = new SingleLinkedList();
       singleLL.add(2);
       singleLL.add(3);
       singleLL.add(5);
       singleLL.add(0);
       singleLL.add(9);

       //singleLL.display();
       SingleLinkedList.Node middleNode = getMiddleElement(singleLL);
       System.out.print(middleNode.data);
    }

    static SingleLinkedList.Node getMiddleElement(SingleLinkedList linkedList){
        SingleLinkedList.Node slow = linkedList.head;
        SingleLinkedList.Node fast = linkedList.head;

        if(linkedList.head != null) {
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return slow;
    }
}