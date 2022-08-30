
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import utility.collection.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayTest {

    private ArrayList<String> list;

    @BeforeEach
    public void createArray() {
        list = new ArrayList<>();
        populateWithFive();
    }

    private void populateWithFive() {
        list.add("Troels");
        list.add("Joseph");
        list.add("Allan");
        list.add("Ib");
        list.add("Cramer");
    }

    @Test
    public void addedElementInArray() {
        list.add("Maria");
        assertTrue(list.contains("Maria"));
    }

    @Test
    public void addedElementInArrayInSpecificPosition() {
        list.add(2,"Mona");
        assertEquals(6, list.size());
        assertEquals(list.get(2),"Mona");
        assertEquals(list.get(5),"Cramer");
        assertEquals(list.get(3),"Allan");
    }

    @Test
    public void addedElementInArrayInSpecificPositionOutOfBoundary() {
        assertThrows(IndexOutOfBoundsException.class, ()->list.add(-1,"Mona"));
        assertThrows(IndexOutOfBoundsException.class, ()->list.add(6,"Mona"));
    }

    @Test
    public void containsElement() {

        assertTrue(list.contains("Ib"));
        assertFalse(list.contains("Mona"));
    }

    @Test
    public void getElementWithIndex() {
        assertEquals("Cramer", list.get(4));
        assertNotEquals("Kasper", list.get(3));
        assertThrows(IllegalStateException.class, ()->list.get(6));
    }

    @Test
    public void getIndexOf() {
        assertEquals(2, list.indexOf("Allan"));
        assertEquals(-1, list.indexOf("Mihail")); // if is not in the list
    }

    @Test
    public void isEmpty() {
        assertFalse(list.isEmpty());
        assertTrue(new ArrayList<>().isEmpty());
    }

    @Test
    public void isFull() {  //The error is here! the list can't never be full acording to the documentation.
        assertTrue(list.isFull());
    }

    @Test
    public void removeObjectByIndex() {
        list.remove(2);
        assertEquals(4, list.size());
        assertEquals("Ib", list.get(2));
    }

    @Test
    public void removeObjectByName() {
        list.remove("Ib");
        assertFalse(list.contains("Ib"));
        assertEquals(4, list.size());
        assertThrows(IllegalStateException.class, ()->list.remove("Vlad"));
    }

    @Test
    public void setAnObjectInTheList() {
        list.set(1, "Martin");
        assertFalse(list.contains("Josep"));
        assertTrue(list.contains("Martin"));
        assertEquals(5, list.size());
    }

    @Test
    public void getTheSizeOfTheList() {
        assertEquals(5, list.size());
        list.remove(0);
        list.remove(0);
        list.remove(0);
        assertEquals(2, list.size());
        assertEquals(0, new ArrayList<>().size());
    }

    @Test
    public void gettingResultToString() {
        assertEquals("{Troels, Joseph, Allan, Ib, Cramer}", list.toString());
        assertEquals("{}", new ArrayList<>().toString());
    }
}
