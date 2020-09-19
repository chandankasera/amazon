import sun.lwawt.macosx.CSystemTray;

import java.util.Deque;
import java.util.LinkedList;

public class DiskSpace {

    public static int calculateMaxMinima(int[] diskspace, int segmentLen){
        int maxMinima =Integer.MIN_VALUE;

        if(diskspace==null || diskspace.length==0)
            return -1;
        int len = diskspace.length;
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<diskspace.length;i++)
        {    //8, 2,4,3,7,6
            //remove the first element if Queue is more than k element
         //   System.out.println(" peek "+deque.peekFirst()+" ---> "+i);
            if(!deque.isEmpty() && i-segmentLen+1>deque.peekFirst()){
                deque.pollFirst();
           //     System.out.println("removing peek first ");
            }

            //remove the largest element as we need to track min
            while(!deque.isEmpty() && diskspace[i]<diskspace[deque.peekLast()] )
                  deque.pollLast();

            deque.offerLast(i);
            if(i-segmentLen+1>0){
                //0,1,2
              //  System.out.println("value when new window comes up "+i+" taking out "+deque.peekFirst());
                maxMinima=Math.max(maxMinima,diskspace[deque.peekFirst()]);
            }
        }



        return maxMinima;
    }

    public static void test(int value, int expect){
       System.out.println("case 1 " +(value==expect));
    }

    public static void main(String[] args) {

        int[] diskspace = new int[]{8, 2,4,3,7,6};
        System.out.println("---> "+calculateMaxMinima(diskspace,2)); //6
        System.out.println("---> "+calculateMaxMinima(diskspace,3)); //3
        test(calculateMaxMinima(diskspace,2),6);
        test(calculateMaxMinima(diskspace,3),3);
        test(calculateMaxMinima(new int[]{1,2},3),1);
    }
}
