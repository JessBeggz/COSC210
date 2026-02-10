package test;
import model.WorkoutList;
import model.Workout;
import model.ExerciseList;
import model.Loadable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

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
