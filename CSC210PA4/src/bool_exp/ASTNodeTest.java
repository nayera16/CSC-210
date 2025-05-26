package bool_exp;
//package com.gradescope.bool_exp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ASTNodeTest {

	@Test 
	public void testNandNullChildren() {
		ASTNode nullChildren = ASTNode.createNandNode(null, null);
		assertNull(nullChildren.child1);
		assertNull(nullChildren.child2);
		assertTrue(nullChildren.isNand());
	
	}
	
	@Test
	public void testNandNodeChildren() {
		ASTNode child1 = ASTNode.createIdNode("a");
		ASTNode child2 = ASTNode.createIdNode("b");
		ASTNode nodeChildren = ASTNode.createNandNode(child1, child2);
		
		assertNotNull(nodeChildren);
		assertEquals(child1, nodeChildren.child1);
		assertEquals(child2, nodeChildren.child2);
		
		
	}
	
	@Test
	public void testIDNullChildren() {
		ASTNode idNode = ASTNode.createIdNode("a");
		assertNotNull(idNode);
		assertNull(idNode.child1);
		assertNull(idNode.child2);
		
	}
	
	@Test
	public void testIDNodeChildren() {
		ASTNode child1 = ASTNode.createIdNode("a");
		ASTNode oneNodeChild = ASTNode.createNandNode(child1, null);
		
		assertNotNull(oneNodeChild.child1);
		assertNull(oneNodeChild.child2);
		assertNotNull(oneNodeChild);
	}
	
	@Test
	public void testIsNand() {
		ASTNode nandNode = ASTNode.createNandNode(null,  null);
		
		assertTrue(nandNode.isNand());
		assertFalse(nandNode.isId());
		
	}
	
	@Test
	public void testIsId()	{
		ASTNode idNode = ASTNode.createIdNode("a");
		
		assertTrue(idNode.isId());
		assertFalse(idNode.isNand());
	}
	
	@Test
	public void testGetId() {
		ASTNode idNode = ASTNode.createIdNode("a");
		assertEquals("a", idNode.getId());
	}
	

}
