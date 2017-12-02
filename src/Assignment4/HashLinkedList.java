package Assignment4;


public class HashLinkedList<K,V>{
	/*
	 * Fields
	 */
	private HashNode<K,V> head;

	private Integer size;

	/*
	 * Constructor
	 */

	HashLinkedList(){
		head = null;
		size = 0;
	}


	/*
	 *Add (Hash)node at the front of the linked list
	 */

	public void add(K key, V value){
		// ADD CODE BELOW HERE
		
		// Make newNode head. Move current head to next node.
		HashNode<K,V> newNode = new HashNode<K,V>(key, value);
		size++;

		if(head == null) {
			head = newNode;
		}
		else {
			newNode.next = head;
			head = newNode;
		}
		
		// ADD CODE ABOVE HERE
	}

	/*
	 * Get Hash(node) by key
	 * returns the node with key
	 */

	public HashNode<K,V> getListNode(K key){
		// ADD CODE BELOW HERE
		
		// Go through list and return if key matches, else return null.
		if(isEmpty()) {
			return null;
		}

		HashNode<K,V> current = head;

		while(current != null) {
			if(current.getKey() == key) {
				return current;
			}
			current = current.getNext();
		}

		return null;

		// ADD CODE ABOVE HERE
	}


	/*
	 * Remove the head node of the list
	 * Note: Used by remove method and next method of hash table Iterator
	 */

	public HashNode<K,V> removeFirst(){
		// ADD CODE BELOW HERE
		
		// Remove current head, set head to next node.
		if(isEmpty()) {
			return null;
		}
		
		HashNode<K,V> removed = head;

		size--;
		head = head.next;

		return removed;
		
		// ADD CODE ABOVE HERE
	}

	/*
	 * Remove Node by key from linked list 
	 */

	public HashNode<K,V> remove(K key){
		// ADD CODE BELOW HERE
		
		// Look for key in the list, if key is the head, set head to next node. 
		// Otherwise remove node by setting previous node to next node.
		HashNode<K,V> previous = null;
		HashNode<K,V> current = head;
		HashNode<K,V> deleted = null;

		if(isEmpty()) {
			return null;
		}
		
		while(current != null) {
			if(current.getKey() == key) {
				
				deleted = current;
				
				if(current == head) {
					head = head.next;
				}
				else {
					previous.next = current.next;
				}
				size--;
			}
			else {
				previous = current;
			}
			current = current.next;
		}
		
		return deleted;

		// ADD CODE ABOVE HERE
	}



	/*
	 * Delete the whole linked list
	 */
	public void clear(){
		head = null;
		size = 0;
	}
	/*
	 * Check if the list is empty
	 */

	boolean isEmpty(){
		return size == 0? true:false;
	}

	int size(){
		return this.size;
	}

	//ADD YOUR HELPER  METHODS BELOW THIS

	//Method for getting the head
	public HashNode<K,V> getHead() {
		return head;
	}

	//ADD YOUR HELPER METHODS ABOVE THIS


}
