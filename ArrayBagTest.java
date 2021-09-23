public class ArrayBagTest
{
   public static void main(String[] args)
   {
      BagInterface<String> bag1 = new ResizableArrayBag<>();
      BagInterface<String> bag2 = new ResizableArrayBag<>();
      String[] items1 = {"a", "b", "c"};
      String[] items2 = {"b", "b", "d", "e"};
      testAdd(bag1, items1);
      testAdd(bag2, items2);

      BagInterface<String> newBag = bag1.intersection(bag2);
      displayBag(newBag);

   }
   // Tests the method add.
	private static void testAdd(BagInterface<String> aBag, String[] content)
	{
		System.out.print("Adding to the bag: ");
		for (int index = 0; index < content.length; index++)
		{
			aBag.add(content[index]);
         System.out.print(content[index] + " ");
		} // end for
      System.out.println();
	} // end testAdd
   // Tests the method toArray while displaying the bag.
	private static void displayBag(BagInterface<String> aBag)
	{
		System.out.println("The bag contains " + aBag.getCurrentSize() +
		                   " string(s), as follows:");		
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print(bagArray[index] + " ");
		} // end for
		
		System.out.println();
	} // end displayBag
}
