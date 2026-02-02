package test;
import model.Exercise;
import model.Workout;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class WorkoutTest {
    Workout w;
    Exercise a;
    Exercise b;

    @BeforeEach
    public void setUp() {
        w = new Workout();
        a = new Exercise("Squat");
    }

    @Test
    public void testAddExercise() {
        assertEquals(0, w.size());
        w.addExercise(a);
        assertEquals(1, w.size());
        w.addExercise(a);
        assertEquals(1, w.size()); //Should stay the same (1) cause an exercise with the name Squat already exists in the list
    }
}
