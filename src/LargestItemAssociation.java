import java.util.*;

public class LargestItemAssociation {
    public static List<String> largestItemAssociation(List<PairString> itemAssociation) {
        // write your code here
        Map<String,HashSet<String>> map = new HashMap<>();
        List<String> result = new LinkedList<>();
        for(PairString p : itemAssociation)
        {
            if(!map.containsKey(p.first))
                map.put(p.first, new HashSet<String>());
            if(!map.containsKey(p.second))
                map.put(p.second, new HashSet<String>());
            map.get(p.first).add(p.first);
            map.get(p.first).add(p.second);
            map.get(p.second).add(p.second);
            map.get(p.second).add(p.first);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->map.get(b).size()-map.get(a).size());
        for(String item : map.keySet()){
           // System.out.println(" "+item);
         //   System.out.println(" "+map.get(item));
            pq.offer(item);
        }
      //  System.out.println(pq.toString());
        TreeSet<String> set = new TreeSet<>(map.get(pq.poll()));

        for(String str : set){
            result.add(str);
        }
       // TreeSet<String> set = map.get(pq.poll());

        return result;

    }

    public static void test(List<PairString> itemAssociation) {
        System.out.println(largestItemAssociation(itemAssociation));
    }
    public static class PairString {
        String first;
        String second;

        public PairString(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {
        // test cases
        List<PairString> input = Arrays.asList(
                new PairString[]{
                        new PairString("item1", "item2"),
                        new PairString("item3", "item4"),
                        new PairString("item4", "item5")
                }
        );

        List<PairString> input2 =  Arrays.asList(
                new PairString[] {
                        new PairString("item1","item2"),
                        new PairString("item2","item3"),
                        new PairString("item4","item5"),
                        new PairString("item6","item7"),
                        new PairString("item5","item6"),
                        new PairString("item3","item7")
                }
        );

        // test
        test(input);
        test(input2);

    }
}
