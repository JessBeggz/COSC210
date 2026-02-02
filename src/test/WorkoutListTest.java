package test;
import model.WorkoutList;
import model.Workout;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
public class WorkoutListTest {

    private WorkoutList workoutList;
    private Workout workout1;
    private Workout workout2;
    @BeforeEach
    public void setUp() {
        workoutList = new WorkoutList();
        workout1 = new Workout("Upper");
        workout2 = new Workout("Lower");
    }

    @Test
    public void testAddWorkout() {
        workoutList.addWorkout(workout1);
        assertEquals(1, workoutList.size());
        assertTrue(workoutList.contains(workout1));
    }

    @Test
    public void testGetWorkoutList() {
        workoutList = new WorkoutList();
        workoutList.addWorkout(workout1);
        workoutList.addWorkout(workout2);
        assertEquals(2, workoutList.getWorkoutList().size());
    }
}