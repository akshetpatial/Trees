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

        public void add(int[] numbers, int Given_Start_index,int Given_End_index){
            root = new Node(0,numbers.length-1);
            root.value = add(numbers, Given_Start_index, Given_End_index, 0, numbers.length-1);
            System.out.println("Root: "+ root.value );
        }

    private int add(int[] numbers, int givenStartIndex, int givenEndIndex, int StartIndex, int EndIndex) {
            if(StartIndex>=EndIndex)
                return numbers[EndIndex];

            int mid = (StartIndex + EndIndex)/2;


            int sum = add(numbers,givenStartIndex,givenEndIndex,StartIndex,mid) + add(numbers,givenStartIndex,givenEndIndex,mid+1,EndIndex);
            System.out.println("Sum: "+ sum+ " StartIndex "+ StartIndex+ " EndIndex "+ EndIndex);
            return  sum;
    }

    public void display(){

    }
    public static void main(String[] args) {
        int[] numbers = {3,8,7,6,-2,-8,4,9};

        System.out.println("Enter the range for which you want to find the sum: ");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Starting the Index: ");
        int Given_Start_index = scan.nextInt();
        System.out.println("Enter the Ending the Index: ");
        int Given_End_index = scan.nextInt();

        SegmentedTrees segmentedTrees = new SegmentedTrees();
        segmentedTrees.add(numbers,Given_Start_index,Given_End_index);

        segmentedTrees.display();

    }
}
