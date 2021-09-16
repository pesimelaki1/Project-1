import java.util.Arrays;

public class ResizableArrayBag<T> implements BagInterface<T>
{
   private T[] bag;
   private int maxSize;
   private int currentSize;
   private boolean integrityOK;
   private final int MAX_CAPACITY = 10000;
   public ResizableArrayBag(int initialCapacity)
   {
      if(initialCapacity <= MAX_CAPACITY)
      {
         integrityOK = true;
      }
      else
      {
         throw new IllegalStateException("Attempted to create a bag larger than "
                                         + "maximum allowed capacity.");
      }
   }
   @Override
   public void union()
   {
      
   }
   @Override
   public void intersection()
   {
      
   }
   @Override
   public void difference()
   {
      
   }
   private void doubleCapacity()
   {
      int newLength = 2*bag.length;
      resize(newLength);
   } 
   private void resize(int newSize)
   {
      T[] newBag = Arrays.copyOf(bag, newSize);
      bag = newBag;
      checkCapacity(bag.length);
   }
   private void checkCapacity(int capacity)
   {
      if(currentSize >= maxSize)
         throw new IllegalStateException();
   }
   /**
   * @return the current number of items in the bag.
   */
   @Override
   public int getCurrentSize()
   {
      return currentSize;
   }
   /**
   * @return true if the bag is empty. False otherwise.
   */
   @Override
   public boolean isEmpty()
   {
      return currentSize == 0;
   }
   /**
   * Adds a new item to the bag.
   * @param newEntry item of generic type to be added.
   * @return true if addition was successful. False otherwise.
   */
   @Override
   public boolean add(T newEntry)
   {
      checkIntegrity();
      if(currentSize >= maxSize)
         doubleCapacity();
      bag[currentSize] = newEntry;
      currentSize++;
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
      checkIntegrity();
      T result = removeEntry(currentSize - 1);
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
      checkIntegrity();
      int index = getIndexOf(entry);
      T result = removeEntry(index);
      return entry.equals(result);
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
      checkIntegrity();
      int frequency = 0;
      for(T item:bag)
      {
         if(entry.equals(item))
            frequency++;
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
      checkIntegrity();
      return getIndexOf(entry) >= 0;
   }
   /**
   * Puts the contents of the bag into a new array and returns it.
   * @return array containing the contents of the bag.
   */
   @Override
   public T[] toArray()
   {
      @SuppressWarnings("unchecked")
      T[] result = (T[]) new Object[currentSize];
      for(int i = 0; i < currentSize; i++)
         result[i] = bag[i];
      return result;
   }
   /**
   * Finds the index of an item in the bag.
   * @param entry item to look for.
   * @return the index of the item. -1 if the item was not found.
   */
   private int getIndexOf(T entry)
   {
      int location = -1;
      boolean found = false;
      int index = 0;
      while(!found && index < currentSize)
      {
         if(entry.equals(bag[index]))
         {
            found = true;
            location = index;
         }
         index++;
      }
      return location;
   }
   /**
   * Removes an item at a certain index from the bag.
   * @param index index of the item to be removed.
   * @return object that was removed. Null if removal was unsuccessful.
   */
   private T removeEntry(int index)
   {
      T objToBeRemoved = null;
      if(!isEmpty() && index >= 0)
      {
         objToBeRemoved = bag[index];
         bag[index] = bag[currentSize - 1];
         bag[currentSize - 1] = null;
         currentSize--;
      }
      return objToBeRemoved;
   }
   private void checkIntegrity()
   {
      if(!integrityOK)
      {
         throw new SecurityException("ArrayBag object is corrupt.");
      }
   }
}
