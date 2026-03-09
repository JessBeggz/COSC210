package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DefaultExerciseRemovalException;
import model.ExerciseList;
import model.WeightedExercise;

public class ExerciseListTest {
    ExerciseList list;
    WeightedExercise a;
    WeightedExercise b;

    @BeforeEach
    public void setUp() {
        list = new ExerciseList();
        a = new WeightedExercise("Squat");
        b = new WeightedExercise("Jump");
    }

    @Test
    public void testAdd() {
        list.add(b);
        assertEquals(9, list.size()); //Should change to 8 cause no exercise with the name Jump exists in the list
    }

    @Test
    public void testAddAlreadyInList() {
        list.add(a);
        assertEquals(8, list.size()); //Should stay the same (7) cause an exercise with the name Squat already exists in the list
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
        try {
            list.removeExercise("Jump");
        } catch (DefaultExerciseRemovalException e){
            assertFalse(list.contains(b));
        }
    }

    @Test
    public void testRemoveDefaultExercise() {
        try {
            list.removeExercise("Squat");
        } catch (DefaultExerciseRemovalException e) {
            assertEquals("This exercise cannot be removed as it is a default exercise.", e.getMessage());
            assertEquals(8, list.size()); //Should stay as 8 as removeExercise should not remove default exercises, and squat is a default exercise
        }
    }

    @Test
    public void testRemoveExerciseNotInList() {
        try {
            list.removeExercise("Jumping Jacks");
        } catch (DefaultExerciseRemovalException e) {
            assertEquals(8, list.size()); //Should stay as 8 as removeExercise should not remove anything when the name is not found
        }
    }
}
