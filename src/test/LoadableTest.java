package test;
import model.WorkoutList;
import model.Loadable;

public class LoadableTest {

    @Test
    public void testLoadWorkoutList() {
        WorkoutList wl = new WorkoutList();
        testLoad(wl);
    }

    public void testLoad(Loadable l) {
        l.load();
    }

}
