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
        list.add(b);
        assertEquals(8, list.size()); //Should change to 8 cause no exercise with the name Jump exists in the list
    }

    @Test
    public void testAddAlreadyInList() {
        list.add(a);
        assertEquals(7, list.size()); //Should stay the same (7) cause an exercise with the name Squat already exists in the list
    }

    @Test
    public void testContains() {
        list.add(b);
        assertTrue(list.contains(b));
    }

    @Test
    public void testContainsFalse() {
        assertFalse(list.contains(b));
    }

    @Test
    public void testRemoveExerciseCustom() {
        list.add(b);
        list.removeExercise("Jump");
        assertFalse(list.contains(b));
    }

    @Test
    public void testRemoveDefaultExercise() {
        list.removeExercise("Squat");
        assertEquals(7, list.size()); //Should stay as 7 as removeExercise should not remove default exercises, and squat is a default exercise
    }

    @Test
    public void testRemoveExerciseNotInList() {
        list.removeExercise("Jumping Jacks");
        assertEquals(7, list.size()); //Should stay as 7 as removeExercise should not remove anything when the name is not found
    }
}
