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
        return null;
    }
}
