import java.util.Scanner;

public class SegmentedTrees {

    public class Node {
        private Node left;
        private Node right;
        private int value;
        private int start_Index;
        private int End_Index;

        // No Need of this as We will be focusing on indexes only
//        public Node(int value) {
//            this.value = value;
//        }

        public Node(int start_Index, int End_Index) {
            this.start_Index = start_Index;
            this.End_Index = End_Index;
        }
    }

    private Node root;

    public void add(int[] numbers) {
        root = new Node(0, numbers.length - 1);
//            root.value = add(numbers, Given_Start_index, Given_End_index, 0, numbers.length-1);
        root = add(numbers, 0, numbers.length - 1);
        System.out.println("Root: " + root.value);
    }

    private Node add(int[] numbers, int StartIndex, int EndIndex) {
        if (StartIndex == EndIndex) {
            Node node = new Node(StartIndex, EndIndex);
            node.value = numbers[EndIndex];
            return node;
        }

        Node node = new Node(StartIndex, EndIndex);

        int mid = (StartIndex + EndIndex) / 2;

        node.left = add(numbers, StartIndex, mid);
        node.right = add(numbers, mid + 1, EndIndex);

        node.value = node.left.value + node.right.value;

        // System.out.println("Sum: "+ (node.value) + " StartIndex "+ StartIndex+ " EndIndex "+ EndIndex);
//            Node node_left = add(numbers,givenStartIndex,givenEndIndex,StartIndex,mid);
//            Node node_right = add(numbers,givenStartIndex,givenEndIndex,mid+1,EndIndex);
//            System.out.println("Sum: "+ (node_left.value + node_right.value) + " StartIndex "+ StartIndex+ " EndIndex "+ EndIndex);
//            return node_left;

        return node;
    }

    public void display() {
        display(root);
    }

    public void display(Node node) {
        String str = " ";

        if (node.left != null) {
            str = str + " Interval [ " + node.left.start_Index + "," + node.left.End_Index + " ] " + "Value: " + node.left.value;
        }//else{
//            System.out.println("No left Child!");
//        }
        // Current Node
        str = str + " Interval [ " + node.start_Index + "," + node.End_Index + " ] " + "Value: " + node.value;

        if (node.right != null) {
            str = str + " Interval [ " + node.right.start_Index + "," + node.right.End_Index + " ] " + "Value: " + node.right.value;
        }//else{
//            System.out.println("No right Child!");
//        }
        System.out.println(str);
        if (node.left != null)
            display(node.left);
        if (node.right != null)
            display(node.right);
    }

    public void findSum(int[] numbers, int givenStartIndex, int givenEndIndex) {
        int sum = findSum(root, givenStartIndex, givenEndIndex);
        System.out.println("The Sum of the values between [ " + givenStartIndex + "," + givenEndIndex + " ] is: " + sum);
    }

    public int findSum(Node node, int givenStartIndex, int givenEndIndex) {
        if (node.start_Index >= givenStartIndex && node.End_Index <= givenEndIndex)
            return node.value;
        if (givenStartIndex > node.End_Index || givenEndIndex < node.start_Index)
            return 0;
        else {
            return findSum(node.left, givenStartIndex, givenEndIndex) + findSum(node.right, givenStartIndex, givenEndIndex);
        }
    }

    public void update(int index, int value) {
        if (root.start_Index > index && root.End_Index < index) {
            System.out.println("Not possible index out of range: ");
            return;
        }
        update(root, index, value);
    }

    public int update(Node node, int index, int value) {

        if (node.start_Index == node.End_Index & node.start_Index!=index)
            return node.value;

        if(node.start_Index == index && node.End_Index == index){
            node.value = value;
            return node.value;
        }

        node.value = update(node.left, index, value) + update(node.right, index, value);
        return node.value;
    }

    public static void main(String[] args) {
        int[] numbers = {3,8,7,6,-2,-8,4,9};

        SegmentedTrees segmentedTrees = new SegmentedTrees();
        segmentedTrees.add(numbers);

        segmentedTrees.display();

        System.out.println("Enter the range for which you want to find the sum: ");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Starting the Index: ");
        int Given_Start_index = scan.nextInt();
        System.out.println("Enter the Ending the Index: ");
        int Given_End_index = scan.nextInt();

        segmentedTrees.findSum(numbers,Given_Start_index,Given_End_index);

        System.out.println("Enter the index and value where you want to make an update");
        System.out.println("Enter the Index: ");
        int index = scan.nextInt();
        System.out.println("Enter the Value: ");
        int value = scan.nextInt();

        segmentedTrees.update(index,value);
        segmentedTrees.display();

        System.out.println("Enter the range for which you want to find the sum: ");
        System.out.println("Enter the Starting the Index: ");
        Given_Start_index = scan.nextInt();
        System.out.println("Enter the Ending the Index: ");
        Given_End_index = scan.nextInt();

        segmentedTrees.findSum(numbers,Given_Start_index,Given_End_index);

    }
}
