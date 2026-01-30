package test;
import model.ExerciseList;
import model.Exercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ExerciseListTest {
    ExerciseList list;
    Exercise a;
    Exercise b;

    @BeforeEach
    public void setUp() {
        list = new ExerciseList();
        a = new Exercise("pullUp");
        b = new Exercise("pushUp");
    }

    @Test
    public void testAdd() {
        assertEquals(0, list.size());
        list.add(a);
        assertEquals(1, list.size());
        
    }

    @Test
    public void testRemove() {
        list.add(a);
        assertEquals(1, list.size());
        list.remove(a);
        assertEquals(list.size(), 0);
    }

    @Test
    public void testContains() {
        list.add(a);
        assertTrue(list.contains(a));
        list.remove(a);
        assertFalse(list.contains(a));
    }
}
