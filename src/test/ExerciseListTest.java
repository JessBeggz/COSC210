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
        a = new Exercise("Squat");
        b = new Exercise("Jump");
    }

    @Test
    public void testAdd() {
        assertEquals(7, list.size());
        list.add(a);
        assertEquals(7, list.size()); //Should stay the same (7) cause an exercise with the name Squat already exists in the list
        list.add(b);
        assertEquals(8, list.size()); //Should change to 8 cause no exercise with the name Jump already exists in the list
        
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

    @Test
    public void testView() {
        list.add(a);
        list.view();
    }

}
