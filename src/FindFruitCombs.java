public class FindFruitCombs {

    public static int winPrize(String[][] codeList , String[] shoppingCart){
        if(codeList==null || codeList.length==0)
            return 1;
        if(shoppingCart==null || shoppingCart.length==0)
            return 0;
      int cartIndex=0 , listIndex=0;

      while(cartIndex<shoppingCart.length && listIndex<codeList.length){
         int i= cartIndex;
         if(codeList[listIndex][0].equals("anything") ||
            codeList[listIndex][0].equals(shoppingCart[i]))
         {   //possible group match, check for all other item
             i++;   //check for next elemnt in cart
             int j;
             for(j=1;j<codeList[listIndex].length;j++)
             {    String code = codeList[listIndex][j];
                  String list = shoppingCart[i];
                 if(code.equals("anything")  || code.equals(list))
                 {  //matches
                     i++;  //increment index of shopping cart
                 }
                 else{
                     break;
                 }
             }

             //if everything matches , possible end of group codelist
             if(j==codeList[listIndex].length){
                 listIndex++;
                 cartIndex =i;
             }
             else{
                 //move to next item in cart
                 cartIndex++;
             }


         }
          else  //if shopping cart doesnt matches with first of codeList check for next item in shopping list
              {
              cartIndex++;
         }

      }



        return  listIndex == codeList.length ? 1:0;


    }

    public static void test(String[][] codeList, String[] shoppingCart, int expect) {
        System.out.println(winPrize(codeList, shoppingCart) == expect);
    }

    public static void main(String[] args) {
        // test cases
        String[][] codeList1 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList2 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
        String[][] codeList3 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
        String[][] codeList4 = {{"apple", "apple"}, {"apple", "apple", "banana"}};
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
        String[][] codeList5 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList6 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList7 = {{"anything", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList8 = {{"apple", "orange"}, {"orange", "banana", "orange"}};
        String[] shoppingCart8 = {"apple", "orange", "banana", "orange", "orange", "banana", "orange", "grape"};
        String[][] codeList9 = {{"anything", "anything", "anything", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart9 = {"orange", "apple", "banana", "orange", "apple", "orange", "orange", "banana", "apple", "banana"};

        // test
        test(codeList1, shoppingCart1, 1);
        test(codeList2, shoppingCart2, 0);
        test(codeList3, shoppingCart3, 0);
        test(codeList4, shoppingCart4, 0);
        test(codeList5, shoppingCart5, 1);
        test(codeList6, shoppingCart6, 1);
        test(codeList7, shoppingCart7, 1);
        test(codeList8, shoppingCart8, 1);
        test(codeList9, shoppingCart9, 1);
    }
}