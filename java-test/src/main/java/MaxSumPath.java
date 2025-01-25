
public class MaxSumPath {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode node = new TreeNode(-10);
        node.left=new TreeNode(9);
        node.right=new TreeNode(20);
        node.right.left= new TreeNode(15);
        node.right.right= new TreeNode(7);

        findMaxPath(node);
        System.out.println(max);

    }


    static int findMaxPath(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = Math.max(0, findMaxPath(root.left));
        int right = Math.max(0, findMaxPath(root.right));

        int cmax = root.val+left+right;
        max = Math.max(max, cmax);
        return root.val+Math.max(left,right);
    }
}

class TreeNode1 {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode1(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

