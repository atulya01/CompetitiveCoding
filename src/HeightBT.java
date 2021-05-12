public class HeightBT {

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
        System.out.println(findTreeHeight(root));
    }

    public static int findTreeHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSubTreeHeight = findTreeHeight(root.left);
        int rightSubTreeHeight = findTreeHeight(root.right);

        if(leftSubTreeHeight > rightSubTreeHeight){
            return leftSubTreeHeight + 1;
        }else{
            return rightSubTreeHeight + 1;
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
