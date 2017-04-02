/**
 * Everything works except the testEmptyQueueException test. 
 * -getFront, getBack, removeFront,removeBack all through emptyQueueException in the code but the test itself is not working
 * 
 * Things that have been tested
 * -adding to the front and back when the deque is empty
 * -getFront
 * -getBack
 * -removing the last node from the front and back
 * -isEmptyMethod
 * -clearMethod

 */
import org.junit.Test;

import junit.framework.TestCase;

public class DequeTest extends TestCase{

	public void main(String[] args) {
		CircularChainDeque deque = new CircularChainDeque();
		deque.getFront();
		testEmptyQueueException();
		testGetFront();
	}

	@Test (expected = EmptyQueueException.class)
	public void testEmptyQueueException() {
		CircularChainDeque deque = new CircularChainDeque();
		deque.getFront();
		//deque.getBack();
		//deque.removeBack();
		//deque.removeFront();
	}

	/*
	 * Testing AddToFront and RemoveFront
	 */
	public void testAddToFrontAndRemoveFront() {
		CircularChainDeque deque = new CircularChainDeque();
		//Testing AddToFront when queue is empty
		deque.addToFront(4);
		assert(deque.getFront().equals(4));
		assert(deque.getBack().equals(4));
		//clearing the test
		deque.clear();
		
		//Testing addToFront with Remove Front with multiple entries
		for(int i = 0; i < 51; i++) {
			deque.addToFront(i);

		}

		for(int i = 50; i >= 0; i--) {
			assert(deque.removeFront().equals(i));
		}
	}
	
	/*
	 * Testing AddToBack and RemoveBack
	 */
	public void testAddToBackAndRemoveBack() {
		CircularChainDeque deque = new CircularChainDeque();
		//Testing AddToFront when queue is empty
				deque.addToBack(4);
				assert(deque.getFront().equals(4));
				assert(deque.getBack().equals(4));
		//clearing the test
				deque.clear();
		for(int i = 0; i < 51; i++) {
			deque.addToBack(i);

		}
		//Testing that 0 is now the front of the deque
		assert(deque.removeFront().equals(0));
		for(int i = 50; i > 0; i--) {
			assert(deque.removeBack().equals(i));
		}
	}

	/*
	 * This method tests getFront. It adds an element. Then it checks to make sure the element is linked to itself.
	 * It fills the deque with
	 */
	public void testGetFront() {

		CircularChainDeque deque = new CircularChainDeque();
		deque.addToFront(50);
		assert(deque.getFront().equals(50));

		deque.addToFront(40);
		//Testing that multiple getFronts do not remove the entry
		assert(deque.getFront().equals(40));
		assert(deque.getFront().equals(40));

		//Testing addToBack does not modify the return of getToFront
		deque.addToBack(30);
		assert(deque.getFront().equals(40));
	}
	
	public void testGetBack() {
		CircularChainDeque deque = new CircularChainDeque();
		deque.addToBack(50);
		assert(deque.getBack().equals(50));

		//adding to back of node
		deque.addToBack(40);
		//Testing that multiple getBacks do not remove the entry
		assert(deque.getBack().equals(40));
		assert(deque.getBack().equals(40));
		//Testing that firstNode is now equal to 50
		assert(deque.getFront().equals(50));
		
		//Testing that add to Front does not change addToBack
		deque.addToFront(30);
		assert(deque.getBack().equals(40));
	}
	/*
	 * Tests if isEmpty correctly checks if the queue is empty
	 */
	public void testIsEmpty() {
		CircularChainDeque deque = new CircularChainDeque();
		assert(deque.isEmpty());
		deque.addToFront(40);
		assert(!deque.isEmpty());
	}
	public void testIsClear() {
		CircularChainDeque deque = new CircularChainDeque();
		assert(deque.isEmpty());
		deque.addToFront(40);
		assert(!deque.isEmpty());
		deque.clear();
		assert(deque.isEmpty());
	}
}
