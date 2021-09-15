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
      return numberOfEntries;
   }
   @Override
   public boolean isEmpty()
   {
      return firstNode == null;
   }
   @Override
   public boolean add(T newEntry)
   {
      Node<T> newNode = new Node<T>(newEntry);
      newNode.setNext(firstNode);
      firstNode = newNode;
      numberOfEntries++;
      return true;
   }
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
      Node<T> currentNode = firstNode;
      while(currentNode != null)
      {
         if(entry.equals(currentNode.getData()))
            frequency++;
         currentNode = currentNode.getNext();
      }
      return frequency;
   }
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