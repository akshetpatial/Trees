import java.util.Scanner;

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

        System.out.println("Enter the Root Element: ");
        int element = scan.nextInt();
            binaryTrees.add(element);
//            }
//
//        }

        System.out.println("Display Tree: ");
        binaryTrees.display();
    }
}