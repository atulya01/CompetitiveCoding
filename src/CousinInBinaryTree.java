import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CousinInBinaryTree {
    private int height;

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        HashMap<Integer, int[]> map = new HashMap<>();
        int[] xData = new int[2];
        int[] yData = new int[2];

        System.out.println(findIfCousin(head, 1, 6, 0, map, xData, yData));
    }

    public static void dfs(Node parent, Node curr, int x, int y, int height, HashMap<Integer, int[]> map, int[] xData, int[] yData){
        if(curr == null){
            return;
        }

        dfs(curr, curr.left, x, y, height+1, map, xData, yData);
        dfs(curr, curr.right, x, y, height+1, map, xData, yData);

        if(parent != null){
            if(curr.data == x) {
                xData[0] = parent.data;
                xData[1] = height;
                map.put(x, xData);
            }
            if(curr.data == y){
                yData[0] = parent.data;
                yData[1] = height;
                map.put(y, yData);
            }
        }

    }

    public static boolean findIfCousin(Node head, int x, int y, int height, HashMap<Integer, int[]> map, int[] xData, int[] yData){
        if(head == null){
            return false;
        }

        dfs(null, head, x, y, height, map, xData, yData);
        //check parent and height after dfs
        if(xData[0] != yData[0] && xData[1] == yData[1])
            return true;
        return false;
    }

    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
}
