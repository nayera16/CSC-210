
public class GenericMethod {
	public static <Type> String myString(Type something) {
		String message = "";
		message += something.getClass().getName();
		return message;
	}
	
	public static void main(String[] args) {
		System.out.println(myString('c'));
	}
	
	// linked list declaration
	/*
	 * public class Node {
    		int data;
    		Node next;
    
    		public Node(int data) {
        		this.data = data;
        		this.next = null;
    		}
		}
	 * 
	 */
}
