package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Workout;
import model.WorkoutList;
public class WorkoutListTest {

    private WorkoutList workoutList;
    private WorkoutList workoutList2;
    private Workout workout1;
    private Workout workout2;
    @BeforeEach
    public void setUp() {
        workoutList = new WorkoutList();
        workoutList2 = new WorkoutList();
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

    @Test
    public void testWorkoutListSize() {
        workoutList = new WorkoutList();
        workoutList.addWorkout(workout1);
        assertTrue(!workoutList.getWorkoutList().isEmpty());
        workoutList.addWorkout(workout2);
        assertEquals(workoutList.getWorkoutList().size(), 2);
    }

    @Test
    public void testWorkoutListContains() {
        workoutList = new WorkoutList();
        workoutList.addWorkout(workout2);
        assertTrue(workoutList.contains(workout2));
        assertTrue(!workoutList.contains(workout1));
    }





}