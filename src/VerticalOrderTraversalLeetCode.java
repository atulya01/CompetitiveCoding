import java.util.*;

public class VerticalOrderTraversalLeetCode {

    public static void main(String[] args) {
        VerticalOrderTraversalBT.TreeNode root = new VerticalOrderTraversalBT.TreeNode(3);
        root.left = new VerticalOrderTraversalBT.TreeNode(1);
        root.right = new VerticalOrderTraversalBT.TreeNode(4);
        root.left.left = new VerticalOrderTraversalBT.TreeNode(0);
        root.left.right = new VerticalOrderTraversalBT.TreeNode(2);
        root.right.left = new VerticalOrderTraversalBT.TreeNode(2);
        /*root.right.right = new BoundaryofBinaryTree.TreeNode(6);
        root.right.right.left = new BoundaryofBinaryTree.TreeNode(8);
        root.right.right.left.right = new BoundaryofBinaryTree.TreeNode(9);*/

        verticalTraversal(root);

    }

    public static List<List<Integer>> verticalTraversal(VerticalOrderTraversalBT.TreeNode root) {
        List<List<Integer>> verticalOrderList = new ArrayList<List<Integer>>();
        TreeMap<Integer, ArrayList<Integer>> resultMap = new TreeMap<Integer, ArrayList<Integer>>();
        traverseVertically(root, 0, 0, resultMap);

        for(Map.Entry<Integer, ArrayList<Integer>> entry: resultMap.entrySet()){
            ArrayList<Integer> list = entry.getValue();
            Collections.sort(list);
            verticalOrderList.add(list);
        }
        return verticalOrderList;
    }

    public static void traverseVertically(VerticalOrderTraversalBT.TreeNode root, int row, int column, TreeMap<Integer, ArrayList<Integer>> resultMap){
        if(root == null){
            return;
        }

        //add to list
        if(resultMap.containsKey(column)){
            resultMap.get(column).add(root.data);
        }else{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            resultMap.put(column, list);
        }

        traverseVertically(root.left, row + 1, column - 1, resultMap);
        traverseVertically(root.right, row + 1, column + 1, resultMap);
    }
}
