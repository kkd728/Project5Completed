
public class CircularChainDeque implements DequeInterface{
	Node firstNode;

	private class Node<T> {
		Object data;
		Node next; 
		Node prev;

		private Node() {
			this(null);
		}
		private Node(T data) {
			this(data, null, null);
		}
		private Node(T data, Node next, Node prev) {
			this.data = data;
			this.next = next; 
			this.prev = prev;
		}
	}
	@Override
	public void addToFront(Object newEntry) {
		//Create new node
		Node newNode = new Node(newEntry);

		if(isEmpty()) {
			firstNode = newNode;
			firstNode.next = firstNode;
			firstNode.prev = firstNode;
		}
		//Store lastNode
		Node lastNode = firstNode.prev;
		
		//link newNode to lastNode
		newNode.prev = lastNode;
		lastNode.next = newNode;
		
		//link newNode to fistNode;
		newNode.next = firstNode;
		firstNode.prev = newNode;

		//change firstNode to newNode
		firstNode = newNode;
	}

	@Override
	public void addToBack(Object newEntry) {
		Node newNode = new Node(newEntry);

		if(isEmpty()) {
			firstNode = newNode;
			firstNode.next = firstNode;
			firstNode.prev = firstNode;
		}
		//Set newNode's pointers to last node and firstNode
		newNode.next = firstNode;
		newNode.prev = firstNode.prev;

		//change last node's next to newNode
		firstNode.prev.next = newNode;
		firstNode.prev = newNode;

	}

	@Override
	/*
	 * This method removes the front of the queue and the next data in line becomes the front of the queue
	 * (non-Javadoc)
	 * @see DequeInterface#removeFront()
	 */
	public Object removeFront() {
		//if the queue is empty, throw an exception
		if(isEmpty()) throw new EmptyQueueException();

		//save the data of the firstNode
		Object data = firstNode.data;

		//Last node is the bottom most node
		Node lastNode = firstNode.prev;
		//Have firstNode become firstNode.next		
		firstNode = firstNode.next;

		//like the last node to firstNode's next node
		lastNode.next = firstNode;
		firstNode.prev = lastNode;

		return data;
	}

	@Override
	public Object removeBack() {
		//if the queue is empty, throw an exception
		if(isEmpty()) throw new EmptyQueueException();

		Object data = firstNode.prev.data;

		//Get the node behind lastNode
		Node newLastNode = firstNode.prev.prev;

		firstNode.prev = newLastNode;
		newLastNode.next = firstNode;

		return data;
	}

	@Override
	public Object getFront() {
		//if the queue is empty, throw an exception
		if(isEmpty()) throw new EmptyQueueException();
		return firstNode.data;
	}

	@Override
	public Object getBack() {
		//if the queue is empty, throw an exception
		if(isEmpty()) throw new EmptyQueueException();
		return firstNode.prev.data;
	}

	@Override
	public boolean isEmpty() {
		return firstNode == null;
	}

	@Override
	public void clear() {
		firstNode = null;
	}

}
