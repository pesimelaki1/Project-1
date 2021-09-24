package project1;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class JavaTest extends TestCase
{
   BagInterface<String> resizableBag1 = new ResizableArrayBag<>();
   BagInterface<String> resizableBag2 = new ResizableArrayBag<>();
   BagInterface<String> linkedBag1 = new LinkedBag<>();
   BagInterface<String> linkedBag2 = new LinkedBag<>();
   String[] items1 = {"a", "b", "c"};
   String[] items2 = {"b", "b", "d", "e"};

   @Override
   protected void setUp() throws Exception
   {
      for(String item : items1)
         resizableBag1.add(item);
      for(String item : items2)
         resizableBag2.add(item);
      for(String item : items1)
         linkedBag1.add(item);
      for(String item : items2)
         linkedBag2.add(item);
   }
   
   @Test
   public void testResizableUnion()
   {
      BagInterface<String> result = resizableBag1.union(resizableBag2);
      String[] expected = {"a", "b", "c", "b", "b", "d", "e"};
      assertArrayEquals(result.toArray(), expected);
   }
   
   @Test
   public void testResizableIntersection()
   {
      BagInterface<String> result = resizableBag1.intersection(resizableBag2);
      String[] expected = {"b"};
      assertArrayEquals(result.toArray(), expected);
   }

   @Test
   public void testLinkedUnion()
   {
      BagInterface<String> result = resizableBag1.difference(resizableBag2);
      String[] expected1 = {"a", "c"};
      assertArrayEquals(result.toArray(), expected1);
      result = resizableBag2.difference(resizableBag1);
      String[] expected2 = {"e", "b", "d"};
      assertArrayEquals(result.toArray(), expected2);
   }
   
   @Test
   public void testLinkedIntersection()
   {
      BagInterface<String> result = resizableBag1.intersection(resizableBag2);
      String[] expected = {"b"};
      assertArrayEquals(result.toArray(), expected);
   }

   @Test
   public void testLinkedDifference()
   {
      BagInterface<String> result = resizableBag1.difference(resizableBag2);
      String[] expected1 = {"a", "c"};
      assertArrayEquals(result.toArray(), expected1);
      result = resizableBag2.difference(resizableBag1);
      String[] expected2 = {"e", "b", "d"};
      assertArrayEquals(result.toArray(), expected2);
   }
}