
//Sohan Chatterjee
//SSW 315 Lab 13 BST Test
//December 2, 2022
import static org.junit.Assert.*;
import org.junit.Test;

public class BSTtest {
    BST<Integer> tree = new BST<>();

    public BSTtest() {
        tree.insert(45);
        tree.insert(54);
        tree.insert(67);
        tree.insert(56);
        tree.insert(50);
        tree.insert(45);
        tree.insert(23);
        tree.insert(59);
        tree.insert(23);
        tree.insert(67);
    }

    @Test
    public void testInsert() {
        assertTrue("The element was not inserted.", tree.insert(76));
    }

    @Test
    public void testDelete() {
        assertTrue("The element was not deleted.", tree.delete(23));
    }

    @Test
    public void testGetNode() {
        assertEquals(tree.getNode(23), tree.getNode(23));
    }

    @Test
    public void testIsLeaf() {
        assertFalse("The element is a leaf.", tree.isLeaf(56));
    }

    @Test
    public void testPath() {
        tree.delete(tree.getRoot().element);
        assertEquals(tree.path(50), tree.path(50));
        assertEquals(tree.path(59), tree.path(59));
    }
}