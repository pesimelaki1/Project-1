public class LinkedBag<T> implements BagInterface<T>
{
   private Node<T> firstNode;
   private int numberOfEntries;
   public LinkedBag()
   {
      firstNode = null;
      numberOfEntries = 0;
   }
   @Override
   public BagInterface<T> union(BagInterface<T> otherBag)
   {
      T[] thisArray = this.toArray();
      T[] otherArray = otherBag.toArray();
      LinkedBag<T> result = new LinkedBag<T>();
      for(int i = 0; i < thisArray.length; i++)
      {
         result.add(thisArray[i]);
      }
      for(int i = 0; i < otherArray.length; i++)
      {
         result.add(otherArray[i]);
      }
      return result;
   }
   @Override
   public BagInterface<T> intersection(BagInterface<T> otherBag)
   {
      return null;
   }
   @Override
   public BagInterface<T> difference(BagInterface<T> otherBag)
   {
      return null;
   }
   /**
   * @return the current number of items in the bag.
   */
   @Override
   public int getCurrentSize()
   {
      return numberOfEntries;
   }
   /**
   * @return true if the bag is empty. False otherwise.
   */
   @Override
   public boolean isEmpty()
   {
      return firstNode == null;
   }
   /**
   * Adds a new item to the bag.
   * @param newEntry item of generic type to be added.
   * @return true if addition was successful. False otherwise.
   */
   @Override
   public boolean add(T newEntry)
   {
      Node<T> newNode = new Node<T>(newEntry);
      newNode.setNext(firstNode);
      firstNode = newNode;
      numberOfEntries++;
      return true;
   }
   /**
   * Removes an item from the bag.
   * @return the item that was removed.
   *         Null if removal was unsuccessful.
   */
   @Override
   public T remove()
   {
      T result = null;
      if (firstNode != null)
      {
         result = firstNode.getData();
         firstNode = firstNode.getNext();
         numberOfEntries--;
      }
      return result;
   }
   /**
   * Removes a specific item from the bag.
   * @param entry item to be removed.
   * @return true if removal was successful. False otherwise.
   */
   @Override
   public boolean remove(T entry)
   {
      boolean result = false;
      Node<T> foundNode = getReferenceTo(entry);
      if(foundNode != null)
      {
         foundNode.setData(firstNode.getData());
         firstNode = firstNode.getNext();
         numberOfEntries--;
         result = true;
      }
      return result;
   }
   /**
   * Removes all items from the bag.
   */
   @Override
   public void clear()
   {
      while(!isEmpty())
         remove();
   }
   /**
   * Indicates the frequency of an item.
   * @param entry item to look for.
   * @return number of times the item appears in the bag.
   */
   @Override
   public int getFrequencyOf(T entry)
   {
      int frequency = 0;
      Node<T> currentNode = firstNode;
      while(currentNode != null)
      {
         if(entry.equals(currentNode.getData()))
            frequency++;
         currentNode = currentNode.getNext();
      }
      return frequency;
   }
   /**
   * Determines if the bag contains a certain item.
   * @param entry item to look for.
   * @return true if the bag contains the item. False otherwise.
   */
   @Override
   public boolean contains(T entry)
   {
      boolean found = false;
      Node<T> currentNode = firstNode;
      while(!found & currentNode != null)
      {
         if(entry.equals(currentNode.getData()))
            found = true;
         else
            currentNode = currentNode.getNext();
      }
      return found;
   }
   /**
   * Puts the contents of the bag into a new array and returns it.
   * @return array containing the contents of the bag.
   */
   @Override
   public T[] toArray()
   {
      Node<T> currentNode = firstNode;
      int counter = 0;
      @SuppressWarnings("unchecked")
      T[] result = (T[]) new Object[numberOfEntries];
      while(currentNode != null)
      {
         result[counter] = currentNode.getData();
         currentNode = currentNode.getNext();
         counter++;
      }
      return result;
   }
   /**
   * 
   */
   private Node<T> getReferenceTo(T entry)
   {
      boolean found = false;
      Node<T> currentNode = firstNode;
      while(!found & currentNode != null)
      {
         if(entry.equals(currentNode.getData()))
            found = true;
         else
            currentNode = currentNode.getNext();
      }
      return currentNode;
   }
}
class Node<T>
{
   private T data;
   private Node<T> next;
   public Node(T newData)
   {
      data = newData;
   }
   public T getData()
   {
      return data;
   }
   public void setData(T newData)
   {
      data = newData;
   }
   public Node<T> getNext()
   {
      return next;
   }
   public void setNext(Node<T> newNext)
   {
      next = newNext;
   }
}