import java.util.Scanner;

public class BinaryTrees {

    public class Node{

        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

    }

    private Node root;

    public void add(int value) {
        if(root == null) {
            Node node = new Node(value);
            root = node;
        }
        add(root);
    }
    public void add(Node node) {

        Scanner scan = new Scanner(System.in);
            System.out.println("Do you want to enter left of " + node.value);
            System.out.println("press yes/no");
            String check = scan.next();
            if (check.equalsIgnoreCase("yes")) {
                System.out.println("Enter the value of the left of " + node.value);
                int element = scan.nextInt();
                node.left = new Node(element);
                add(node.left);
            }
            System.out.println("Do you want to enter right of " + node.value);
            System.out.println("press yes/no");
            check = scan.next();
            if(check.equalsIgnoreCase("yes")) {
                System.out.println("Enter the value of the right of " + node.value);
                int element = scan.nextInt();
                node.right = new Node(element);
                add(node.right);
            }
    }

    public void display() {
        display(root, 1);
       //display(root,0);
    }

    public void display(Node node , String indent){
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void display(Node node,int count){
        if(node == null)
            return;

       display(node.left, ++count);

           for(int i =0 ; i<count;i++){
               System.out.print("    ");
           }
//        System.out.println("---->"+node.value);
        System.out.println(node.value);
//        for(int i =0 ; i<count;i++){
//            System.out.print("    ");
//        }
//        System.out.print("|"+"\n");
      display(node.right,count);

    }

}
