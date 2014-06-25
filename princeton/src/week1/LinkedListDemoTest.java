package week1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListDemoTest {
    class Node {
        String info;
        Node next;
    }

    @Test
    public void simpleNode() {
        Node n = new Node();
        n.info = "some info";
        n.next = null;
        Node end = new Node();
        end.info = "this is the end";
        n.next = end;
        end.next = null;
        assertEquals(n.next.info, end.info);
    }
}