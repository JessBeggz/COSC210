package model;
import org.json.JSONObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ExerciseTest {
    //This is a class only for testing Exercise's concrete methods
    class TestExercise extends Exercise {
        @Override
        public String getDescription() {
            return "This is a class only for testing Exercise's concrete methods";
        }

        @Override
        public JSONObject toJson() {
            return new JSONObject();
        }
    }

    @Test
    public void testName() {
        Exercise e = new TestExercise();

        e.setName("Jumping Jacks");
        assertEquals("Jumping Jacks", e.getName());
    }

    @Test
    public void testSets() {
        Exercise e = new TestExercise();

        e.setSets(3); //should stay at 0
        assertEquals(0, e.getSets());
    }

    @Test
    public void testReps() {
        Exercise e = new TestExercise();

        e.setReps(10); //should stay at 0
        assertEquals(0, e.getReps());
    }

    @Test
    public void testWeight() {
        Exercise e = new TestExercise();

        e.setWeight(1000); //should stay at 0
        assertEquals(0, e.getWeight());
    }

    @Test
    public void testTime() {
        Exercise e = new TestExercise();

        e.setTime(3); //should stay at 0
        assertEquals(0, e.getTime());
    }

    @Test
    public void testDistance() {
        Exercise e = new TestExercise();
        
        e.setDistance(3); //should stay at 0
        assertEquals(0, e.getDistance());
    }
}
