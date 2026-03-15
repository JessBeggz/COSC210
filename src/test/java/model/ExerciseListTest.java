package model;
import org.json.JSONArray;
import org.json.JSONObject;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.exceptions.DefaultExerciseRemovalException;
import model.exceptions.DuplicateExerciseException;
import model.exceptions.ExerciseNotFoundException;

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
        try {
            list.add(b);
        } catch (DuplicateExerciseException e) {
            fail();
        }
        assertEquals(9, list.size()); //Should change to 9 cause no exercise with the name Jump exists in the list
    }

    @Test
    public void testGetExerciseList() {
        assertEquals("Squat",list.getExerciseList().get(0).getName());
    }

    @Test
    public void testAddAlreadyInList() {
        try {
            list.add(a);
            fail();
        } catch (DuplicateExerciseException e) {
            assertEquals("Exercise already exits, cannot add duplicates", e.getMessage());
        }
        assertEquals(8, list.size()); //Should stay the same (8) cause an exercise with the name Squat already exists in the list
        
    }

    @Test
    public void testContains() {
        try {
            list.add(b);
        } catch (DuplicateExerciseException e) {
            fail();
        }
        assertTrue(list.contains(b));
    }

    @Test
    public void testContainsFalse() {
        assertFalse(list.contains(b));
    }

    @Test
    public void testRemoveExerciseCustom() throws DuplicateExerciseException, ExerciseNotFoundException {
        list.add(b);
        try {
            list.removeExercise("Jump");
        } catch (DefaultExerciseRemovalException e){
            fail();
        } catch (ExerciseNotFoundException e){
            fail();
        }
        assertFalse(list.contains(b));
    }

    @Test
    public void testRemoveDefaultExercise() {
        try {
            list.removeExercise("Squat");
        } catch (DefaultExerciseRemovalException e) {
            assertEquals("This exercise cannot be removed as it is a default exercise.", e.getMessage());
            assertEquals(8, list.size()); //Should stay as 8 as removeExercise should not remove default exercises, and squat is a default exercise
        } catch (ExerciseNotFoundException e){
            fail();
        }
    }

    @Test
    public void testRemoveExerciseNotInList() {
        try {
            list.removeExercise("Jumping Jacks");
        } catch (DefaultExerciseRemovalException e) {
            fail();
        } catch (ExerciseNotFoundException e){
            assertEquals(8, list.size()); //Should stay as 8 as removeExercise should not remove anything when the name is not found
        }
    }

    @Test
    public void testToJson() {
        JSONObject jsonTest = list.toJson();
        JSONArray jsonWeightedList = jsonTest.getJSONArray("exerciseList");
        JSONArray jsonCardioList = jsonTest.getJSONArray("cardioExerciseList");

        JSONObject jsonSquat = jsonWeightedList.getJSONObject(0);
        JSONObject jsonRun = jsonCardioList.getJSONObject(0);

        assertEquals("Squat", jsonSquat.getString("name"));
        assertEquals(0, jsonSquat.getInt("reps"));
        assertEquals(0, jsonSquat.getInt("sets"));
        assertEquals(0, jsonSquat.getInt("weight"));

        assertEquals("Run", jsonRun.getString("name"));
        assertEquals(0, jsonRun.getInt("time"));
        assertEquals(0, jsonRun.getInt("distance"));
    }
}
