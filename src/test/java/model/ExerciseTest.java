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

}
