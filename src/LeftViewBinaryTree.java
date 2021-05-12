import apple.laf.JRSUIUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeftViewBinaryTree {


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


        leftViewUtil(root);
    }

    public static List<Integer> leftViewUtil(TreeNode root){
        HashSet<Integer> levelPrinted = new HashSet();
        ArrayList<Integer> leftViewNodes = new ArrayList();
        printLeftView(root, 0, levelPrinted, leftViewNodes);
        return leftViewNodes;
    }

    public static void printLeftView(TreeNode root, int level, HashSet levelPrinted, ArrayList<Integer> leftViewNodes){
        if(root == null){
            return;
        }

        if(!levelPrinted.contains(level)){
            leftViewNodes.add(root.data);
            levelPrinted.add(level);
        }

        printLeftView(root.right, level+1, levelPrinted, leftViewNodes);
        printLeftView(root.left, level+1, levelPrinted, leftViewNodes);

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
