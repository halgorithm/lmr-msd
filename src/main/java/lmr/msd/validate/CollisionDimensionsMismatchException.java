package lmr.msd.validate;

import lmr.msd.object.Scene;
import lmr.msd.object.Stage;

public class CollisionDimensionsMismatchException extends SceneValidationException {
    public CollisionDimensionsMismatchException(Stage stage, Scene scene) {
        super("Collision dimensions must be twice the dimensions of the prime LayerGroup.", stage, scene);
    }
}
