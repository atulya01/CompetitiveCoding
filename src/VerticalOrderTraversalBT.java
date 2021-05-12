import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class VerticalOrderTraversalBT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        /*root.left.right.left = new BoundaryofBinaryTree.TreeNode(7);
        root.right.right = new BoundaryofBinaryTree.TreeNode(6);
        root.right.right.left = new BoundaryofBinaryTree.TreeNode(8);
        root.right.right.left.right = new BoundaryofBinaryTree.TreeNode(9);*/

        traverseVertically(root);

    }

    public static TreeMap<Integer, List<Integer>> traverseVertically(TreeNode root){
        TreeMap<Integer, List<Integer>> results = new TreeMap<Integer, List<Integer>>();
        traverse(root, 0, results);
        System.out.println(results);
        return results;
    }

    public static void traverse(TreeNode root, int column, TreeMap<Integer, List<Integer>> results){
        if(root == null){
            return;
        }

        if(results.containsKey(column)){
            results.get(column).add(root.data);
        }else{
            ArrayList list = new ArrayList();
            list.add(root.data);
            results.put(column, list);
        }

        traverse(root.left, column -1, results);
        traverse(root.right, column + 1, results);
    }

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
}
