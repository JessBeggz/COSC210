package tests;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.WeightedExercise;
import model.Workout;

public class WorkoutTest {
    Workout w = new Workout();;
    WeightedExercise a = new WeightedExercise("Squat");

    @Test
    public void testDefaultConstructor() {
        Workout d = new Workout();

        assertEquals("Unnamed Workout", d.getName());
    }

    @Test
    public void testCustomConstructor() {
        Workout c = new Workout("Workout 1!");

        assertEquals("Workout 1!", c.getName());
    }

    @Test
    public void testAddExercise() {
        assertEquals(0, w.size());
        w.addExercise(a);
        assertEquals(1, w.size());
        w.addExercise(a);
        assertEquals(1, w.size());
    }

    @Test
    public void testEmptyWorkoutExercises() {
        assertEquals(w.getWorkoutExercises().size(), 0);
    }
    @Test
    public void testGetWorkoutExercises() {
        w.addExercise(a);
        assertEquals(w.getWorkoutExercises().size(), 1);
    }

    @Test
    public void testSetName() {
        w.setName("Workout1");
        assertEquals(w.getName(), "Workout1");
    }
}
