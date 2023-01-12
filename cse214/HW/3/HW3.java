/**
 * Name: Taehyun Park
 * SBU ID: 115242740
 * Describe your approach in a single paragraph.
 */
// Do not add any imports

public class HW3<E> {

	/*
	 * You must use rawData declared below. Do not modify its type.
	 */
	Object[] rawData;
	int size;
	// You may add whatever fields/methods that are deemed necessary

	public void grow() {   //to grow capacity
		Object[] temp = new Object[rawData.length + 30];
		for (int i = 0; i < rawData.length; i++) temp[i] = rawData[i]; //copy all elements into new ary
	}




	public HW3() {
		rawData = new Object[30];
		size = 0;
	}
	
	/*
	 * TODO: implement the following methods with appropriate header comments. 
	 */

	/* O(N), It has one for loop that operates N times.
	*/
	public void insertFront(E obj) {
		if(rawData.length == size) {
			grow(); //increase capacity if lack of capacity
		}
		for(int i = size;i>0;i--) rawData[i] =rawData[i-1]; //push back all the elements
		rawData[0] = obj; //put obj into the first index
		size++;
	}

	/* O(1), It has no loop to operate, so no matter how big the size is, just one operation will occur.
	*/
	public void insertRear(E obj) {
		if(rawData.length == size) {
			grow(); //increase capacity if lack of capacity
		}
		rawData[size] = obj; //put obj into last index+1
		size++;
	}
	
	/*
	 * Return the deleted element.
	 * Your code should also take appropriate action when deleting the front item is not possible.
	 * (same for deleteRear(), getFront(), and getRear()) 
	 */

	/* O(N), It has one for loop that operates N times
	*/
	public E deleteFront() {
		if(size == 0) return null;
		else{
			E old = (E) rawData[0];
			for(int i = 0;i<size;i++) rawData[i] =rawData[i+1];//push front all the elements
			size--;
			return old;
		}
	}

	/* O(1), It has no loop to operate, so no matter how big the size is, just one operation will occur.
	*/
	public E deleteRear() {
		if(size == 0) return null;
		else{
			E old = (E) rawData[size-1];
			rawData[size-1] = null;
			size--;
			return old;
		}
	}
	
	public E getFront() {
		if(rawData[0] == null) return null;
		else{
			return (E) rawData[0];
		}
	}
		
	public E getRear() {
		if(size == 0) return null;
		else{
			return (E) rawData[size-1];
		}
	}
	
	public int size() {
		return size;
	}
	
	public E get(int index) {
		return (E) rawData[index];
	}
	
	public void reverse() {
		for(int i = 0;i< size/2;i++){   //until mid one
			Object temp = rawData[i];   //change symmetrically
			rawData[i] = rawData[size-i-1];
			rawData[size-i-1] = temp;
		}
	}
	
	// Same effect as ArrayList and LinkedList's clear().
	public void clear() {
		for(int i =0;i<size;i++)
		rawData[i] = null;
		size =0;
	}
	
	/*
	 * Provide your answer to the last question here. 
	 * I think it is better to use linked list because there would be a lot of changes in arraylist,
	 * however, in this file, the list needs to be entirely copied or changed
	 * whenever any small changes(such as add front or add last) is occurred in the list.
	 * If we use linked list instead, then there would be fewer operations occurred than this file It is
	 *  because of its node system. Linked list is consist of nodes which made relation between elements.
	 * since it does not handle with the whole list, instead simply change links between nodes so that it does not
	 * have to make movement or change with each single elements inside the list.
	 */
	
	public static void main(String[] args) {
		HW3<Integer> hw = new HW3<Integer>();
		hw.insertFront(3);
		hw.insertFront(2);
		hw.insertFront(1);
		hw.insertRear(4);
		hw.insertFront(0);
		System.out.println(hw.size());
		System.out.println(hw.get(4));
		hw.reverse();
		System.out.println(hw.getRear());
		System.out.println(hw.deleteFront());
		System.out.println(hw.deleteRear());
		System.out.println(hw.size());
		hw.clear();
		hw.insertRear(3);
		System.out.println(hw.size());
		System.out.println(hw.rawData.length);


	}
}
