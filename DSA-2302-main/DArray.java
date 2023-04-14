/**
 * =====================================
 * Please complete the remaining operations:
  0. add a default constructor with initial size of 10 - make this default size
     into a constant
  1. add/insert: an element to a given index (reset as necessary), and a method
     to add an element to the back of the array
  2. resize: reset the size of the array as the user insert data pass the 
     maxSize/capacity or they explicitly invoke the operation 
  3. add getFirst/getLast methods to retrieve the corresponding element
  4. Modify the class so it can handle any kind of data type (generic data type
     class)
  5. Make sure the code is fully documented and the file is fully described 
     with appropriate information and algorithms
 * ==================================
 * @author Albert Coughlin
 * Data Structures and Algorithms CSCI 2302
 * @purpose: simple illustration of a dynamic array/vector 
 */
import java.util.*;
public class DArray<E> {
	private final double GROW_FACTOR = 2;// array size growing rate
	
	//attributes
	private int size;
	private E buffer[]; //the actual array
	
   //constructors
   public DArray(int size) throws Exception{
	   if(size < 0){
		   throw new Exception("Not a valid range");
	   }
	   this.size = size;//the actual array size
	   int bufferSize = (int) Math.ceil(this.size + this.size * GROW_FACTOR);
	   this.buffer = (E[]) new Object[bufferSize]; //create the buffer
   }
   /** DEFAULT CONSTRUCTOR
    * 0. add a default constructor with initial size of 10 - make this default 
    *    size into a constant
    */
   public DArray() {
      this.size = 10;
      int bufferSize = (int) Math.ceil(this.size + this.size * GROW_FACTOR);
	   this.buffer = (E[]) new Object[bufferSize]; //create the buffer
   }
   
   //methods
   
   //  1. add/insert: an element to a given index (reset as necessary), 
   //     and a method to add an element to the back of the array
   
   
   /* 
    *
    * @return: the element that was replaced
    */
   public E set(int index, E e) throws IndexOutOfBoundsException {
      if(index < 0)
         throw new IndexOutOfBoundsException("Illegal Index"); 
      else if(index >= maxLength())
         resize(index);
      E temp = buffer[index];
      buffer[index] = e;
      return temp; 
   }
   /* 
    *
    * @param: what is being added to the end of the array
    */ 
   public void append(E e) {
      if(buffer[maxLength() - 1] != null)
         resize(maxLength());
      else
         buffer[maxLength() - 1] = e;
   } 
   // 2. resize: reset the size of the array as the user insert data pass the
   //    maxSize/capacity or they explicitly invoke the operation   
    
   /*  
    *   
    * @ param index - index that the array needs to be resized to fit 
    */
   protected void resize(int index) throws IndexOutOfBoundsException { 
      if(index <= maxLength() - 1)
         throw new IndexOutOfBoundsException("This index already exists");
      E[] tempArr = (E[]) new Object[index + maxLength()];
      for(int i = 0; i < size; i++) 
         tempArr[i] = buffer[i];
      buffer = tempArr; 
      size = index;   
   }
   
    // 3. add getFirst/getLast methods to retrieve the corresponding element
    
    /*
     *
     * @return - the first element in the array 
     */
    public E getFirst() {
      return buffer[0];
    }
    
    /* 
     *
     * @return - the last element in the array
     */
    public E getLast() {
      return buffer[maxLength() - 1];
    }
    
   /**
    * 
    * @return the actual size of the array
    */
   public int length(){
	   return this.size;
   }
   
   /**
    * 
    * @return the max length of the dynamic array
    */
   public int maxLength(){
	   return this.buffer.length;
   }
   
   /**
    * 
    * @param index - the location of the element in the array
    * @return the element at the given location/index
    */
   public E elementAt(int index) throws Exception{
	   if(index < 0 || index >= maxLength())
		   throw new Exception("Index out of bound");
     return this.buffer[index];
   }
    /** ========+++ NEWLY ADDED METHOD FOR ITERATOR +++=======
     *  
     * @return an iterator for traversal
     */
   public Itr<E> iterator(){
     return new DArrayItr(this);
   }
   /**
    * 
    *@ return the DArray in string form
    */
   public String toString() {
      String output = "[";
      for(int i = 0; i < this.size; i++)
        output += " " + this.buffer[i];
      return output + " ]";
   }

   
   //////////////////////////////////////////////////////////
   //driver to test the code
   public static void main(String[] args) throws Exception{
      //create a dynamic array
	   DArray a = new DArray(5);
	   System.out.println(a.length());
	   System.out.println(a.maxLength()); 
     
      //give it some values 
      a.set(0,5);
      a.set(1,4);
      a.set(2,3);
      a.set(3,2);
      a.set(4,1);
      System.out.println("Original content of a: " + a);   
      
      //Illustration of iterator
      Itr itr = a.iterator();
      System.out.println("Iterator usage:");   
      while(itr.hasNext()){
        System.out.println(itr.next());
      }

      
      //create a new array and assign a to b
      DArray b = new DArray(a.length());
      System.out.println("Content of b: " + b);
      for(int i = 0; i < a.length(); i++ ) {
         b.set(i, a.elementAt(i));
      }
      System.out.println("Content of b: " + b);
      
      //testing equals method

      //check to see if the two arrays are equal      
      if(a.equals(b)){
        System.out.println("Array a is same as array b");
      }else{
        System.out.println("Array a is same as array b");
      } 
      a.set(1,9);  //change the content of array a

      //print the content of both arrays
      System.out.println("Content of a: " + a);
      System.out.println("Content of b: " + b);
	  
      //check to see if the two arrays are equal 
      if(a.equals(b)){
        System.out.println("Array a is same as array b");
      }else{
        System.out.println("Array a is NOT same as array b");
      }
      
      // testing other functionalities
      a.resize(20);
      System.out.println("The length is now: " + a.length());
      System.out.println("The maxLength is now: " + a.maxLength());
      a.set(0, 10); //set value 10 into index 0
      a.set(100, 50);//set value 50 to index 100 and should trigger a resize
      a.append(9); // adds 9 to the end
      System.out.println("The length is now: " + a.length());
      System.out.println("The maxLength is now: " + a.maxLength());
      System.out.println("The last element is: " + a.getLast());
      System.out.println("The first element is: " + a.getFirst());
      /*There are other functionalities but they were used in the first half
        of the driver*/
   }//end of main

}//end of DArray class
