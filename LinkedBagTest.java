public class LinkedBagTest
{
   public static void main(String[] args)
   {
      LinkedBag<Integer> LB = new LinkedBag<Integer>();
      LB.add(1);
      LB.add(2);
      LB.add(1);
      System.out.print(LB.getFrequencyOf(1));
   }
}