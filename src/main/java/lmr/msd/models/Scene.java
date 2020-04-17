package lmr.msd.models;

import java.util.List;

public class Scene {
    public boolean useBossGfx;
    public byte primeLayerGroupIdx;
    public final Collision collision;
    public final List<LayerGroup> layerGroups;

    public Scene(Collision collision, List<LayerGroup> layerGroups) {
        this.collision = collision;
        this.layerGroups = layerGroups;
    }

    public LayerGroup primeGroup() {
        return primeLayerGroupIdx < layerGroups.size() ? layerGroups.get(primeLayerGroupIdx) : null;
    }

    public short widthInGfxTiles() {
        return (short) (collision.width() / 2);
    }

    public short heightInGfxTiles() {
        return (byte) (collision.height() / 2);
    }

    public byte widthInScreens() {
        return (byte) (collision.width() / 64);
    }

    public byte heightInScreens() {
        return (byte) (collision.height() / 48);
    }

    public byte screensCount() {
        return (byte) (widthInScreens() * heightInScreens());
    }
}
