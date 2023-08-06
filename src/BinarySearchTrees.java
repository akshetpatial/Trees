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

    public int getHeight(Node node) {
        if(node == null)
            return -1;

        return node.height;
    }

}
