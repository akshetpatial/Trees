package Questions;

import java.util.LinkedList;
import java.util.Scanner;

import static Questions.BFS.*;

public class Main {

    public static void main(String[] args) {

        BinaryTrees binaryTrees = new BinaryTrees();

        Scanner scan = new Scanner(System.in);
//        System.out.println("Press yes to add in left");
//        System.out.println("Press no to add in right");

//        for( int i = 0 ; i < count; i++) {
//           System.out.println("Enter your choice: ");
//            String check = scan.next();
//            if(check == "yes") {
//                System.out.println("Enter the element: ");
//               int element = scan.nextInt();
////                binaryTrees.add(element,true, count);
//            }
//            else{
//                System.out.println("Enter the element: ");
//                int element = scan.nextInt();

//        System.out.println("Enter the Root Element: ");
//        int element = scan.nextInt();
//        binaryTrees.add(element);

//        int[] array = { 3,1,2,-1,-1,-1,-1};
//        int array[] = {3,-1, 1 ,2, -1, -1, -1};

//        int array[] = {1,2, 3, -1, -1, -1,4,5,-1,-1,6,7,-1};
        int array[] = {1,2, 3, 4,5, 6,7,8,9,10,-1,-1,-1,-1,-1};

        BinaryTrees.Node node =  binaryTrees.add(array);
//            }
//
//        }

        System.out.println("Display Tree: ");
        binaryTrees.display();

        System.out.println("Enter 1 to find the height of the Tree: ");
        System.out.println("Enter 2 Level Wise List of the Binary Tree: ");

        int cases=  scan.nextInt();

        switch(cases){
            case 1:
                int ans = heightTree(node);
                System.out.println("height of the Binary Tree: "+ans);
                break;
            case 2:
                LinkedList<LinkedList<Integer>> list = getLevelWiseList(node);
                System.out.println("Level Wise List of the Binary Tree: ");
                System.out.print("[ ");
                for( LinkedList<Integer> lt : list){
                    System.out.print(lt+" ");
                }System.out.print("]");
                break;
            default:
                System.out.println("Please Enter from the given option: ");
        }
    }
}
