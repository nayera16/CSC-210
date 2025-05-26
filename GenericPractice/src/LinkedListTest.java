import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void testNodeNull() {
		Node<Integer> myNode = new Node<>(10);
		assertNull(myNode.getNext());
	}
	
	@Test
	void testNodeValue() {
		Node<String> myNode = new Node<>("aa");
		assertEquals("aa", myNode.getData());
	}
	
	@Test 
	void testIntList() {
		LinkedList<Integer> mylist = new LinkedList<>();
		mylist.insert(new Node<>(10));
		mylist.insert(new Node<>(5));
		mylist.insert(new Node<>(1));
		String expected = "1 5 10";
		assertEquals(expected, mylist.toString());
	}
	
	@Test
	void TestSearch() {
		LinkedList<String> mylist = new LinkedList<>();
		mylist.insert(new Node<>("aa"));
		mylist.insert(new Node<>("bb"));
		mylist.insert(new Node<>("cc"));
		assertTrue(mylist.search("bb"));
		assertFalse(mylist.search("ls"));
	}
	
	@Test
	void TestDelete() {
		LinkedList<String> mylist = new LinkedList<>();
		mylist.insert(new Node<>("aa"));
		mylist.insert(new Node<>("bb"));
		mylist.insert(new Node<>("cc"));
		mylist.delete("bb");
		assertFalse(mylist.search("bb"));
	}

}
