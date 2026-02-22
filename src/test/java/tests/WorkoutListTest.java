package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Workout;
import model.WorkoutList;
public class WorkoutListTest {

    private WorkoutList workoutList;
    private Workout workout1;
    private Workout workout2;

    @BeforeEach
    public void setUp() {
        workoutList = new WorkoutList();
        workout1 = new Workout("Upper");
    }

    @Test
    public void testAddWorkout() {
        workoutList.addWorkout(workout1);

        assertTrue(workoutList.contains(workout1));
    }

    @Test
    public void testGetWorkoutList() {
        workoutList.addWorkout(workout1);
        workoutList.addWorkout(workout2);

        assertEquals(2, workoutList.getWorkoutList().size());
        assertEquals(workout1, workoutList.getWorkoutList().get(0));
        assertEquals(workout2, workoutList.getWorkoutList().get(1));
    }

    @Test
    public void testWorkoutListSize() {
        workoutList.addWorkout(workout1);

        assertFalse(workoutList.getWorkoutList().isEmpty());

        workoutList.addWorkout(workout2);

        assertEquals(2, workoutList.getWorkoutList().size());
    }

    @Test
    public void testWorkoutListContains() {
        workoutList.addWorkout(workout2);

        assertTrue(workoutList.contains(workout2));
        assertFalse(workoutList.contains(workout1));
    }
}