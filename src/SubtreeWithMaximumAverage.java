import java.util.Arrays;
import java.util.List;

public class SubtreeWithMaximumAverage {
    static double max = Double.MIN_VALUE;
    static Node maxNode = new Node();
    public static class Node

    {
        int val;
        List<Node> children;
        Node(){ };
        Node(int _val){
            val=_val;
        }
        Node(int _val, List<Node> _children){
            val=_val;
            children =_children;
        }
    }

    public static Node getMaxSum(Node root){
        if(root==null)
            return  null;
        helper(root);
        return maxNode;
    }

    public static double[] helper(Node root){
       if(root==null)
           return new double[]{0,0};
       double currTotal=root.val;
       double count =1;

       if(root.children!=null){
           for(Node child : root.children){
               double[] cur = helper(child);
               currTotal+=cur[0];
               count+=cur[1];
           }
       }

       double avg = currTotal/count;
       if(count>1 && avg>max){
           maxNode=root;
           max=avg;
       }
       return new double[]{currTotal,count};
    }


    public static void main(String[] args) {

        Node left = new Node(12);
        left.children = Arrays.asList(new Node(11),new Node(2),new Node(3));
        Node right = new Node(18);
        right.children = Arrays.asList(new Node(15),new Node(8));
        Node root = new Node(20);
        root.children = Arrays.asList(left,right);

        System.out.println(getMaxSum(root).val);
    }




}
