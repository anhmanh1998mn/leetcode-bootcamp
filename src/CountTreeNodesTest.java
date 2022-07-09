import org.w3c.dom.Node;

import java.util.LinkedList;

public class CountTreeNodesTest {

//     Definition for a binary tree node.
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode() {

         }
         TreeNode(int val) { this.val = val; }

         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 4;
        insertLeft(treeNode, 2);
        insertRight(treeNode, 3);

        addNode(treeNode.left);
        addNode(treeNode.right);

        System.out.printf("Nodes = " + countNodes(treeNode));
    }

    public static void addNode(TreeNode node) {
        node.val = 4;
        insertLeft(node, 2);
        insertRight(node, 3);
    }

    public static void insertLeft(TreeNode treeNode, int value){
        if((treeNode == null)||(treeNode.left != null)) {
            return;
        }
        TreeNode newNode = new TreeNode(value);
        treeNode.left = newNode;
    }

    public static void insertRight(TreeNode treeNode, int value){
        if((treeNode == null)||(treeNode.right != null)) {
            return;
        }
        TreeNode newNode = new TreeNode(value);
        treeNode.right = newNode;
    }

    public static int countNodes(TreeNode root) {
         if (root == null) {
             return  0;
         }
         int count = countNodes(root.left) + countNodes(root.right) + 1;
         return count;
    }
}
