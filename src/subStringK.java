import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class subStringK {

    public static Set<String> unique(String str, int k){
        Set<String> result = new HashSet<>();
        HashMap<Character,Integer> map = new HashMap<>();
       //awaglknagawunagwkwagl
        for(int hi=0,lo=0;hi<str.length();hi++){
            System.out.println(" "+lo+" "+hi);
            char ch = str.charAt(hi);
            if(map.containsKey(ch)){
               System.out.println(ch+"--->"+lo+" "+map.get(ch));
                lo= Math.max(map.get(ch),lo);
            }

            if(hi-lo+1==k){
                result.add(str.substring(lo,hi+1));
                lo++;
            }

            map.put(ch,hi+1);

        }




        return result;
     /*   int[] charArray = new int[25];
        int len = str.length();
        int hi=0,lo=0;
        while(lo<=hi && hi<len){
            char c = str.charAt(hi);
            charArray[c-'a']++;
            while(charArray[str.charAt(hi)-'a']!=1){
                charArray[str.charAt(lo)-'c']--;
                lo++;
            }



            if(hi-lo+1==k){
                result.add(str.substring(lo,hi+1));
                char rc = str.charAt(lo);
                charArray[rc-'a']--;
                lo++;
            }



            hi++;
        }
*/




    }



    public static void main(String[] args) {
        String str ="abcabc";
        int k=3;
        System.out.println(unique(str,k));
        str ="awaglknagawunagwkwagl";
        k=4;
        System.out.println(unique(str,k));

    }
}
