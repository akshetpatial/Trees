public class BinarySearchTrees {

    public class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;


        public Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

//    public int getHeight(Node node) {
//        if(node == null)
//            return -1;
//
//        return node.height;
//    }
    public int getHeight(Node node) {
        if(node == null)
            return -1;
        int height = Math.max(getHeight(node.left),getHeight(node.right)) + 1;
        return height;
    }

    public boolean Balanced(Node node){
        if(node == null)
            return true;
        boolean check;
        // First Part checks the current node and other part checks below nodes
        if(Math.abs(getHeight(node.right) - getHeight(node.left)) <= 1 && Balanced(node.left) && Balanced(node.right))
           check = true;
        else
            check = false;

        return check;
    }
    public void add(int[] numbers){
        if(root == null){
            root = new Node(numbers[0]);
        }

        for( int i =1 ; i < numbers.length;i++){
            if(numbers[i] < root.value){
                add(numbers[i],root.left,root);
            }else{
                add(numbers[i],root.right,root);
            }
        }
    }

    public void add(int number, Node node, Node prev){
        if(node == null){
            node = new Node(number);
            if(number < prev.value){
               prev.left = node;
            }else {
               prev.right = node;
            }
            return;
        }else{
            if(number < node.value){
                add(number,node.left,node);
            }else {
                add(number, node.right,node);
            }
        }
}


    public void display(){
       // System.out.println(root.value);
        display(root,1);
    }

    public void display(Node node, int count){
        if(node == null)
            return;

        display(node.left,++count);
        for(int i =0 ; i<count;i++){
            System.out.print("  ");
        }
        System.out.println(node.value);
        display(node.right,count);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }



    public static void main(String[] args) {
//        int[] numbers = {15,10,20,30,4,5,6,18,14,12}; int[] numbers = {15,10,20,5,12,8}; {15,10,20,5,12};
        int[] numbers = {5,4,7,3};

        BinarySearchTrees binarySearchTrees = new BinarySearchTrees();
        binarySearchTrees.add(numbers);

        binarySearchTrees.display();

        System.out.println("root Value "+binarySearchTrees.root.value);
        System.out.println("Height of the Binary Search tree: "+ binarySearchTrees.getHeight(binarySearchTrees.root));

        System.out.println("Is the Tree Balanced: ");
        if(binarySearchTrees.Balanced(binarySearchTrees.root))
            System.out.println("yes");
        else
            System.out.println("no");


        System.out.println("Pre-Order traversal:");
        binarySearchTrees.preOrder();

        System.out.println("\nPost-Order traversal:");
        binarySearchTrees.postOrder();

        System.out.println("\nIn-Order traversal:");
        binarySearchTrees.inOrder();
    }

}
