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
        if (root == null) {
            root = new Node(numbers[0]);
        }
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < root.value) {
                add(numbers[i], root.left, root);
            } else {
                add(numbers[i], root.right, root);
            }
        }
    }

    public Node add(int number, Node node, Node prev) {
        if(node == null){
            node = new Node(number);
            if(number < prev.value){
                prev.left = node;
            }else {
                prev.right = node;
            }
            return node;
        }else{
            if(number < node.value){
                add(number,node.left,node);
            }else {
                add(number, node.right,node);
            }
        }

        return rotate(node);
    }

    public Node rotate(Node node){
        if(getHeight(node.left) - getHeight(node.right) >= 2){

        }
         if(getHeight(node.right) - getHeight(node.left) >= 2){

        }
         return node;
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
        int[] numbers = {5,4,7,3};

        AVLTrees aVLTrees = new AVLTrees();

        aVLTrees.add(numbers);

        aVLTrees.display();

    }

}


