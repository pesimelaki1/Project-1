public class LinkedBag<T> implements BagInterface<T>
{
   private T[] bag;
   private int maxSize;
   private int currentSize;
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
   @Override
   public int getCurrentSize()
   {
      return currentSize;
   }
   @Override
   public boolean isEmpty()
   {
      return currentSize == 0;
   }
   @Override
   public boolean add(T newEntry)
   {
      if(currentSize >= maxSize)
         return false;
      bag[currentSize] = newEntry;
      currentSize++;
      return true;
   }
   @Override
   public T remove()
   {
      T result = removeEntry(currentSize - 1);
      return result;
   }
   @Override
   public boolean remove(T entry)
   {
      int index = getIndexOf(entry);
      T result = removeEntry(index);
      return entry.equals(result);
   }
   @Override
   public void clear()
   {
      while(!isEmpty())
         remove();
   }
   @Override
   public int getFrequencyOf(T entry)
   {
      int frequency = 0;
      for(T item:bag)
      {
         if(entry.equals(item))
            frequency++;
      }
      return frequency;
   }
   @Override
   public boolean contains(T entry)
   {
      return getIndexOf(entry) >= 0;
   }
   @Override
   public T[] toArray()
   {
      @SuppressWarnings("unchecked")
      T[] result = (T[]) new Object[currentSize];
      for(int i = 0; i < currentSize; i++)
         result[i] = bag[i];
      return result;
   }
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
}
