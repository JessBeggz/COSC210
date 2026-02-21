package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Exercise;
import model.ExerciseList;

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
        list.add(b);
        assertEquals(8, list.size());
        assertEquals(list.size(), 7);
    }

    @Test
    public void testContains() {
        list.add(b);
        assertTrue(list.contains(b));
        assertFalse(list.contains(b));
    }

    // @Test
    // public void testView() {
    //     list.add(b);
    //     list.view();
    // }


}
