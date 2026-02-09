package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

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

    @BeforeEach
    public void setUp() {
        e = new ExerciseList();
        w = new WorkoutList();
    }

    @Test
    public void testSaveExerciseList() {
        e.save();
        FileReader file;
        String s = "";
        try {
         file = new FileReader("ExerciseListSave.txt");
         Scanner scanner = new Scanner(file);
            s = scanner.nextLine();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        assertEquals(e.getExerciseList().get(0).getName(), s);
    }

    @Test
    public void testSaveWorkoutList() {
        w.addWorkout(new Workout("Workout1"));
        w.save();
        FileReader file;
        String s = "";
        try {
         file = new FileReader("WorkoutListSave.txt");
         Scanner scanner = new Scanner(file);
            s = scanner.nextLine();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        assertEquals(w.getWorkoutList().get(0).getName(), s);

    }

    
}
