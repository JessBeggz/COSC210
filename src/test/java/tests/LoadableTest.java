package tests;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.ExerciseList;
import model.Loadable;
import model.Workout;
import model.WorkoutList;

public class LoadableTest {
    ExerciseList e;
    WorkoutList wl;

    @BeforeEach
    public void setUp() {
        e = new ExerciseList();
        wl = new WorkoutList();
    }

    @Test
    public void testLoadWorkoutList() {
        testLoad(wl);
        assertTrue(wl.getWorkoutList().isEmpty());
        Workout w = new Workout("Workout 1");
        wl.addWorkout(w);
        assertFalse(wl.getWorkoutList().isEmpty());
        testLoad(e);
        assertFalse(e.getExerciseList().isEmpty());
    }

    public void testLoad(Loadable l) {
        l.load();
    }

}
