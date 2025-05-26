
public class LinkedList<T> {
	private Node<T> root;
	
	
	public LinkedList() {
		root = null;
	}
	
	public void insert(Node<T> newNode) {
		if (root == null) root = newNode;
		else {
			newNode.setNext(root);
			root = newNode;
		}
	}
	
	public String toString() {
		String message = "";
		Node<T> currentNode = root;
		while (currentNode != null) {
			message += currentNode.getData() + " ";
			currentNode = currentNode.getNext();
		}
		return message.trim();
	}
	
	public boolean search(T value) {
		Node<T> currentNode = root;
		while (currentNode != null) {
			if(currentNode.getData().equals(value)) {
				return true;
			}
			currentNode = currentNode.getNext();
		}
		return false;
	}
	
	public void delete(T value) {
		if (root.getData().equals(value))
			root = root.getNext();
		
		else {
			Node<T> currNode = root.getNext();
			Node<T> prevNode = root;
			boolean found = false;
			while(currNode != null && !found) {
				if(currNode.getData().equals(value)) {
					found = true;
					prevNode.setNext(currNode.getNext());
				}
				
				prevNode = currNode;
				currNode = currNode.getNext();
			}
		}
		
	}

}
