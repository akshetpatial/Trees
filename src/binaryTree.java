public class binaryTree {

    class Node {
        public int data;
        public Node left;
        public Node right;

        Node()
        {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(int data, Node left, Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }


    public void left(Node node, int ele){
        if(node == null)
            return;

        left(node.left,ele);
        node.left = new Node(ele);
    }

    public void right(Node node, int ele){
        if(node == null)
            return;
        right(node.right,ele);
        node.right = new Node(ele);
    }

    public Node createTree(int[] arr){
        // Write your code here.

        Node root = new Node(arr[0]);

        int i =1;
        while( i < arr.length){
            left(root,arr[i]);
            i++;
            right(root,arr[i]);
            i++;
        }
        return root;
    }

    public void display(Node node , String indent){
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};
        binaryTree bt = new binaryTree();
        Node node = bt.createTree(arr);
        bt.display(node," ");
    }
 }

//public class Solution {
//
//
//
//}
