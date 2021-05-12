import com.sun.tools.internal.xjc.model.CElement;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class BoundaryofBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(8);
        root.right.right.left.right = new TreeNode(9);


        LinkedHashSet<Integer> resultSet  = findBoundaryOfTree(root);
        System.out.print(resultSet);
    }

    public static LinkedHashSet<Integer> findBoundaryOfTree(TreeNode root){
        LinkedHashSet<Integer> boundaryNodes = new LinkedHashSet<>();

        addLeftNodesToSet(root, boundaryNodes);
        findLeafNodes(root, boundaryNodes);
        addRightNodesToSet(root, boundaryNodes);

        return boundaryNodes;
    }

    public static void addLeftNodesToSet(TreeNode root,  LinkedHashSet<Integer> boundaryNodes){
        HashSet<Integer> levelPrinted = new HashSet<>();
        findSideNodes(root, boundaryNodes, 0, levelPrinted, "left");
    }

    public static void addRightNodesToSet(TreeNode root,  LinkedHashSet<Integer> boundaryNodes){
        HashSet<Integer> rightlevelPrinted = new HashSet<>();
        findSideNodes(root, boundaryNodes, 0, rightlevelPrinted, "right");
    }

    public static void findLeafNodes(TreeNode root,  LinkedHashSet<Integer> boundaryNodes){
        if(root==null){
            return;
        }

        if(root.left == null && root.right == null){
            boundaryNodes.add(root.data);
        }

        findLeafNodes(root.left, boundaryNodes);
        findLeafNodes(root.right, boundaryNodes);
    }

    public static void findSideNodes(TreeNode root,  LinkedHashSet<Integer> boundaryNodes, int level, HashSet<Integer> levelPrinted, String side){
        if(root==null){
            return;
        }

        if(side.equalsIgnoreCase("left")){
            if(!levelPrinted.contains(level)) {
                boundaryNodes.add(root.data);
                levelPrinted.add(level);
            }
        }


        if(side.equalsIgnoreCase("left")) {
            findSideNodes(root.left, boundaryNodes, level + 1, levelPrinted, side);
            findSideNodes(root.right, boundaryNodes, level + 1, levelPrinted, side);
        }else{
            findSideNodes(root.right, boundaryNodes, level + 1, levelPrinted, side);
            findSideNodes(root.left, boundaryNodes, level + 1, levelPrinted, side);
        }

        if(side.equalsIgnoreCase("right")){
            if(!levelPrinted.contains(level)) {
                boundaryNodes.add(root.data);
                levelPrinted.add(level);
            }
        }
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
