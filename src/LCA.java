
public class LCA{
   public static void main(String[] args) {
       TreeNode root1 = new TreeNode(10);
       root1.left = new TreeNode(2);
       root1.right = new TreeNode(14);
       root1.left.left = new TreeNode(1);
       root1.left.right = new TreeNode(3);
       root1.right.left = new TreeNode(11);
       root1.right.right = new TreeNode(15);



       TreeNode root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.right = new TreeNode(3);
       root.left.left = new TreeNode(4);
       root.left.right = new TreeNode(5);
       root.right.right = new TreeNode(6);
       //root.right.right.left = new LeftViewBinaryTree.TreeNode(8);
       //root.right.right.left.right = new LeftViewBinaryTree.TreeNode(9);

       TreeNode node = findLCABST(root1, 14,20);
       System.out.println(node.data);
    }

    public static TreeNode findLCABST(TreeNode root, int x, int y){
        if (root == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (root.data > x && root.data > y)
            return findLCABST(root.left, x, y);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (root.data < x && root.data < y)
            return findLCABST(root.right, x, y);

        return root;
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
