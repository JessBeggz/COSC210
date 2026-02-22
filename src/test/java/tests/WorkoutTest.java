package tests;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Exercise;
import model.Workout;

public class WorkoutTest {
    Workout w = new Workout();;
    Exercise a = new Exercise("Squat");

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
    public void testGetWorkoutExercises() {
        w.addExercise(a);
        assertEquals(w.getWorkoutExercises().size(), 1);
    }
}
