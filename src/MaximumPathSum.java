public class MaximumPathSum {

    int maxPathSum;

    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        calculateMaxPathSum(root);
        return maxPathSum;
    }

    private int calculateMaxPathSum(TreeNode root){
        if(root == null)
            return 0;

        int left = Math.max(0, calculateMaxPathSum(root.left));
        int right  = Math.max(0, calculateMaxPathSum(root.right));

        maxPathSum = Math.max(maxPathSum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.val = data;
            this.left = this.right = null;
        }
    }
}
