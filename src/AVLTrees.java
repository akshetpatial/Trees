public class AVLTrees {

    public class Node{
        private Node left;
        private Node right;
        private int value;
        private int height;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public int getHeight(Node node){
        if(node == null)
            return -1;

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public boolean isBalanced(Node node){
        if(node == null)
            return true;
        return Math.abs((getHeight(node.left)) - getHeight(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);

    }

    public void add(int[] numbers) {

        // We need root hence we have to get rid of this line as we want that it should return node to us after adding all the elements.
//        if (root == null) {
//            root = new Node(numbers[0]);
//        }
//        for (int i = 1; i < numbers.length; i++) {
//            if (numbers[i] < root.value) {
//                root = add(numbers[i], root.left, root);
//            } else {
//                root = add(numbers[i], root.right, root);
//            }

//        for (int i = 0; i < numbers.length; i++) {
//                root = add(numbers[i], root);
//        }

        for (int i = 0; i < 1000; i++) {
            root = add(i, root);
        }

        //System.out.println("Root: "+root.value);
    }

    public Node add(int number, Node node) {
        if(node == null){
            node = new Node(number);
//            if(number < prev.value){
//                prev.left = node;
//            }else {
//                prev.right = node;
//            }
            return node;
        }

            if(number < node.value){
                node.left = add(number,node.left);
            }else {
               node.right =  add(number, node.right);
            }
        //System.out.println("Node: "+ node.value);
        return rotate(node);
    }

    public Node rotate(Node node){
        if(getHeight(node.left) - getHeight(node.right) >= 2){
            // LEFT IS HEAVY
            if(getHeight(node.left.left) > getHeight(node.left.right)){
                // LEFT-LEFT CASE
                return rotateRight(node);
            }
            if(getHeight(node.left.left) < getHeight(node.left.right)){
                // LEFT-RIGHT CASE
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }
         if(getHeight(node.right) - getHeight(node.left) >= 2){
             // RIGHT IS HEAVY
             if(getHeight(node.right.right) > getHeight(node.right.left)){
                 // RIGHT-RIGHT CASE
                 return rotateLeft(node);
             }
             if(getHeight(node.right.right) < getHeight(node.right.left)){
                 // RIGHT-LEFT CASE
                 node.left = rotateRight(node.left);
                 return rotateLeft(node);
             }
        }
         return node;
    }

    public Node rotateRight(Node parent){
        Node child = parent.left;
        Node t = child.right;

        child.right = parent;
        parent.left = t;

//
//
//        child.height = Math.max(getHeight(child.left), getHeight(child.right))+ 1;
//        parent.height = Math.max(getHeight(parent.left), getHeight(parent.right)) + 1;

        return child;
    }

    public Node rotateLeft(Node parent){
        Node child = parent.right;
        Node t = child.left;

        child.left = parent;
        parent.right = t;

//        parent.height = Math.max(getHeight(parent.left), getHeight(parent.right)) + 1;
//        child.height = Math.max(getHeight(child.left), getHeight(child.right))+ 1;

        return child;
    }


    public void display(){
        display(root,1);
    }

    public void display(Node node, int count){
        if(node == null)
            return;
        display(node.left, ++count);
        for(int i =0 ;i<count;i++){
            System.out.print("  ");
        }
        System.out.println(node.value);
        display(node.right, count);
    }
    public static void main(String[] args) {
//        int[] numbers = {5,4,7,3,2}; {5,3,8,9,10};
        int[] numbers = {1,2,3,4,5,6};

        AVLTrees aVLTrees = new AVLTrees();

        aVLTrees.add(numbers);

        aVLTrees.display();

       int height =  aVLTrees.getHeight(aVLTrees.root);
        System.out.println("Height: "+ height);
    }

}


