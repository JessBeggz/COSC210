package test;

import model.Exercise;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;

import model.Saveable;
import model.Workout;
import model.ExerciseList;
import model.WorkoutList;

public class SaveableTest {

    ExerciseList e;
    WorkoutList w;

    @Before
    public void before() {
        e = new ExerciseList();
        w = new WorkoutList();
    }

    @Test
    public void testSaveExerciseList() {
        e.add(new Exercise("One leg weight Jumps"));
        e.save();
    }

    @Test
    public void testSaveWorkoutList() {
        w.addWorkout(new Workout("Workout1"));
        w.save();
    }
    
}
