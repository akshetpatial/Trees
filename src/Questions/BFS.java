package Questions;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static int heightTree(BinaryTrees.Node node){
        int maxHeight = 1;
        int height = 1;

        Queue<BinaryTrees.Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            if(q.peek().left != null && q.peek().right != null){
                q.add(q.peek().left);
                q.add(q.peek().right);
                height ++;
            }else{
                //height++;
                if(q.peek().left != null){
                    q.add(q.peek().left);
                    height++;
                }
                if(q.peek().right != null){
                    q.add(q.peek().right);
                    height++;
                }
            }
//            if(q.peek().right != null){
//                q.add(q.peek().right);
//            }else{
//                //height--;
//            }
            q.poll();
//            if(!q.isEmpty())
//                height++;
            if(height > maxHeight)
                maxHeight = height;
        }
        return maxHeight;
    }

    public static LinkedList<LinkedList<Integer>> getLevelWiseList(BinaryTrees.Node node){
        Queue<BinaryTrees.Node> q = new LinkedList<>();
        q.add(node);
        LinkedList<LinkedList<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> one = new LinkedList<>();
        one.add(node.value);
        ans.add(one);

        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> others = new LinkedList<>();
            while(size!=0){
                if(q.peek().left!=null) {
                    q.add(q.peek().left);
                    others.add(q.peek().left.value);
                }

                if(q.peek().right!=null) {
                    q.add(q.peek().right);
                    others.add(q.peek().right.value);
                }
                q.poll();
//                others.add(q.peek().value);
                size--;
//            while(size!=0){
//                others.add(q.peek().value);
//                size--;
//            }
            }
            ans.add(others);

//            LinkedList<Integer> others = new LinkedList<>();
//            if(q.peek().left!=null)
//                q.add(q.peek().left);
//            if(q.peek().right!=null)
//                q.add(q.peek().right);
//            q.poll();
//            int size = q.size();
//            while(size!=0){
//                others.add(q.peek().value);
//                size--;
//            }
//            ans.add(others);


        }

        return ans;
    }
}
