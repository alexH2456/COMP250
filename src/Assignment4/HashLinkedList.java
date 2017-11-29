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
		HashNode<K,V> newNode = new HashNode<K,V>(key, value);
		this.size++;
		
		if(this.head == null) {
			this.head = newNode;
		}
		else {
			newNode.next = this.head;
			this.head = newNode;
		}
		// ADD CODE ABOVE HERE
	}

	/*
	 * Get Hash(node) by key
	 * returns the node with key
	 */

	public HashNode<K,V> getListNode(K key){
		// ADD CODE BELOW HERE
		
		if(this.isEmpty()) {
			return null;
		}
		
		HashNode<K,V> previous = this.head;
		HashNode<K,V> current = previous.getNext();
		
		while(current != null) {
			if(current.getKey() == key) {
				return current;
			}
			previous = current;
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
		
		if(this.isEmpty()) {
			return null;
		}
		else {
			HashNode<K,V> removed = this.head;
			HashNode<K,V> newHead = removed.getNext();
			
			this.size--;
			this.head = newHead;
			
			return removed;
		}
	}

	/*
	 * Remove Node by key from linked list 
	 */

	public HashNode<K,V> remove(K key){
		// ADD CODE BELOW HERE
		
		if(this.isEmpty()) {
			return null;
		}
		
		HashNode<K,V> previous = this.head;
		HashNode<K,V> current = previous.getNext();
		
		while(current != null) {
			if(current.getKey() == key) {
				this.size--;
				previous = current.getNext();
				
				return current;
			}
			previous = current;
			current = current.getNext();
		}
		
		// ADD CODE ABOVE HERE
		return null; // removing failed
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


	//ADD YOUR HELPER METHODS ABOVE THIS


}
