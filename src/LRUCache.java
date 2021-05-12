import java.util.HashMap;
import java.util.LinkedList;

class Node{
    String key;
    String value;
    Node prev;
    Node next;

    public Node(String key, String value){
        this.key = key;
        this.value = value;
        this.prev = this.next = null;
    }
}


class DoublyLinkedList{
    Node head;
    Node tail;

    public DoublyLinkedList(){
        this.head = this.tail = null ;
    }
}

public class LRUCache {
    private DoublyLinkedList list;
    private HashMap<String, Node>  hashMap;

    int capacity = 3;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.list = new DoublyLinkedList();
        this.hashMap = new HashMap<>(capacity);
    }

    public boolean put(String key, String value){
        Node newNode  = new Node(key, value);
        if(hashMap.size() < capacity){
            addToHead(newNode);
            return true;
        }else if(hashMap.size() == capacity){
            removeFromTail();
            addToHead(newNode);
            return true;
        }
        return false;
    }


    public String get(String key){
        if(hashMap.containsKey(key)){
            Node resultNode =  hashMap.get(key);
            if(resultNode != list.head) {
                deleteNode(resultNode);
                addToHead(resultNode);
            }
            return resultNode.value;
        }
        return null;
    }

    public void addToHead(Node entryNode){
        if(!hashMap.containsKey(entryNode.key)){
            hashMap.put(entryNode.key, entryNode);
        }
        if(list.head == null){
            list.head = list.tail = entryNode;
        }else {
            Node currentHead = list.head;
            list.head = entryNode;
            entryNode.next = currentHead;
            currentHead.prev = entryNode;
        }
    }

    public void removeFromTail(){
        list.tail = list.tail.prev;
        list.tail.next = null;
    }

    public void deleteNode(Node deletionNode){
        if(deletionNode == list.tail){
            removeFromTail();
        }
        else{
            deletionNode.prev.next = deletionNode.next;
            deletionNode.next.prev = deletionNode.prev;
            deletionNode.next = deletionNode.prev = null;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put("C", "chinmoy");
        cache.put("A", "atulya");
        cache.put("B", "binod");
        cache.put("D", "binod");
        printNodes(cache.list.head);
        String value = cache.get("A");
        System.out.println("After cGET : value"+ value);
        printNodes(cache.list.head);
    }

    public static void printNodes(Node head){
        System.out.println("Print Cache");
        Node node = head;
        while(node != null){
            System.out.println("key: " + node.key + ", value: "+ node.value);
            node = node.next;
        }
    }
}
