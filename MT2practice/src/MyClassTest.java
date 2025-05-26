import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MyClassTest {

	@Test
	void test() {
		MyClass objectOne = new MyClass();
		assertNull(objectOne.getX());
		objectOne.setX("hello");
		assertNotNull(objectOne.getX());
		objectOne.setY(3);
		assertEquals(objectOne.getY(),3);
		assertTrue(objectOne.isLonger(2));
	}

}
