package lmr.msd.validate;

import lmr.msd.models.Scene;
import lmr.msd.models.Stage;

public class CollisionDimensionsMismatchException extends SceneValidationException {
    public CollisionDimensionsMismatchException(Stage stage, Scene scene) {
        super("Collision dimensions must be twice the dimensions of the prime LayerGroup.", stage, scene);
    }
}
