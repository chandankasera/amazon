import java.io.*;
import java.util.*;

class FillingJugs {

    // Write your solution here
    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);
        System.out.println(" get the number of test");
        int numTest = (obj.nextInt());
        List<Long> result = new ArrayList<>();


         for(int i=0;i<numTest;i++){
             System.out.println(" get the number of jugs");
             int numJug =(obj.nextInt());
             List<Integer> list = new ArrayList<>();
             for(int j=0;j<numJug;j++){
                 list.add(obj.nextInt());
             }
            result.add(getMaxAmount(list));
            // obj.nextLine();



         }

   for(long res : result){
       System.out.println(res);
   }



    }

    public static long getMaxAmount(List<Integer> list){
        int min = Integer.MAX_VALUE;
        long res = 0;

        //10 4 7 3
        for(int val : list){
            min=Math.min(min,val);
            res+=min;
        }

        return res;

    }

}

