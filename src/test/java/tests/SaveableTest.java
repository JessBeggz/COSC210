package tests;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.ExerciseList;
import model.Workout;
import model.WorkoutList;

public class SaveableTest {

    ExerciseList e;
    WorkoutList wl;
    Workout w;


    @BeforeEach
    public void setUp() {
        e = new ExerciseList();
        wl = new WorkoutList();
        w = new Workout();
    }

    @Test
    public void testSaveCreateFile() {
        File file = new File("./data/exerciseListData.json");
        if(file.exists()) file.delete();
        assertFalse(file.exists());
        e.save();
        assertTrue(file.exists());
    }

    @Test
    public void testSaveData() {
        File file = new File("./data/workoutListData.json");
        wl.addWorkout(w);
        e.save();
        assertTrue(file.exists());
        assertTrue(file.length() > 0);

    }

    
    // @Test
    // public void testSaveExerciseList() {
    //     e.save();
    //     FileReader file;
    //     String s = "";
    //     try {
    //     file = new FileReader("ExerciseListSave.txt");
    //     Scanner scanner = new Scanner(file);
    //         s = scanner.nextLine();
    //     } catch (FileNotFoundException e1) {
    //         e1.printStackTrace();
    //     }
    //     assertEquals(e.getExerciseList().get(0).getName(), s);
    // }

    // @Test
    // public void testSaveWorkoutList() {
    //     w.addWorkout(new Workout("Workout1"));
    //     w.save();
    //     FileReader file;
    //     String s = "";
    //     try {
    //     file = new FileReader("WorkoutListSave.txt");
    //     Scanner scanner = new Scanner(file);
    //         s = scanner.nextLine();
    //     } catch (FileNotFoundException e1) {
    //         e1.printStackTrace();
    //     }
    //     assertEquals(w.getWorkoutList().get(0).getName(), s);

    // }

    
}
