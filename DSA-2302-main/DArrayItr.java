/* 
 * @author - Albert Coughlin
 * Data Structures and Algorithms CSCI 2302
 */
import java.util.*;
interface Itr<E> {
   public boolean hasNext() throws Exception;
   
   public E next() throws Exception;
}
/**
 A specific iterator for dynamic array class 
*/
class DArrayItr<E> extends DArray implements Itr{
  private DArray<E> storage; //points at the data structure
  private int curLoc; //points at the current location
 
 //contructor
  public DArrayItr(DArray<E> a){
    //deal with invalid object and range errors here
    if(a == null) {
      // error handling code
    }

    this.storage = a; //point at the same source
    this.curLoc = 0; //point at the first index
  }

  /**
    @return true if and only if the curent location is in a valid 
     indexing range 
  */
  public boolean hasNext() throws Exception{
    return this.curLoc < this.storage.length();
  }

  /**
    @return the element at the current index location and 
     advance the currenet location to the next index slot
  */
  public E next() throws Exception{
    return this.storage.elementAt(curLoc++);
  }
}
