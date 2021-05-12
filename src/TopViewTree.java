import java.util.*;

public class TopViewTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        /*root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new BoundaryofBinaryTree.TreeNode(7);
        root.right.right = new BoundaryofBinaryTree.TreeNode(6);
        root.right.right.left = new BoundaryofBinaryTree.TreeNode(8);
        root.right.right.left.right = new BoundaryofBinaryTree.TreeNode(9);*/
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);
        root.left.right.right.right.right = new TreeNode(8);


        getTopViewOfTree(root);
        getTopViewOfTreeBFS(root);
    }

    public static List<Integer>  getTopViewOfTreeBFS(TreeNode  root){
        ArrayList<Integer> resultList = new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> topViewNodesMap = new TreeMap<>();

        findTopNodesDataBFS(root, topViewNodesMap);
        return resultList;
    }

    public static void addToMap(int data, int hd, TreeMap<Integer, ArrayList<Integer>> topViewNodesMap){
        if(topViewNodesMap.containsKey(hd)){
            topViewNodesMap.get(hd).add(data);
        }else{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(data);
            topViewNodesMap.put(hd,list);
        }

    }

    public static void findTopNodesDataBFS(TreeNode root, TreeMap<Integer, ArrayList<Integer>> topViewNodesMap){
         Queue<TreeNode> queue = new LinkedList<>();
         int hd = 0;

         if(root != null){
             queue.add(root);
             queue.add(null);
             addToMap(root.data, hd, topViewNodesMap);
         }

         while(!queue.isEmpty()){
            TreeNode currNode = queue.poll();

            if(currNode == null){
                hd = hd++;
            }



         }
    }

    public static List<Integer> getTopViewOfTree(TreeNode root){
        ArrayList<Integer> resultList = new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> topViewNodesMap = new TreeMap<>();

        findTopNodesData(root, 0, topViewNodesMap);
        for(Map.Entry<Integer, ArrayList<Integer>> entry: topViewNodesMap.entrySet()){
            resultList.add(entry.getValue().get(0));
        }

        return resultList;
    }

    public static void findTopNodesData(TreeNode root, int hd, TreeMap<Integer, ArrayList<Integer>> topViewNodesMap){
        if(root == null){
            return;
        }

        if(!topViewNodesMap.containsKey(hd)){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            topViewNodesMap.put(hd, list);
        }else{
            ArrayList<Integer> list = topViewNodesMap.get(hd);
            list.add(root.data);
        }

        findTopNodesData(root.left, hd - 1, topViewNodesMap);
        findTopNodesData(root.right, hd + 1, topViewNodesMap);
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
