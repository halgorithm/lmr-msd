package lmr.msd.models;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class Stage {
    public StageType type;
    public byte gfxFileId;
    public final List<AnimatedTile> animatedTiles;
    public final List<Scene> scenes;
    public byte id;

    private Path filePath;

    public Stage(List<AnimatedTile> animatedTiles, List<Scene> scenes) {
        this.type = StageType.UNKNOWN;
        this.animatedTiles = animatedTiles;
        this.scenes = scenes;
    }

    public Path filePath() {
        return filePath;
    }

    public void setFilePath(Path path) {
        setFilePath(path, true);
    }

    public void setFilePath(Path path, boolean setIdFromFilename) {
        this.filePath = path;

        if (path == null) {
            if (setIdFromFilename) this.id = -1;
        } else {
            var fileName = filePath.getFileName().toString();
            if (setIdFromFilename) this.id = parseIdFromFileName(fileName);
        }
    }

    public List<Byte> generateSceneScreenCounts() {
        var res = new ArrayList<Byte>(scenes.size());
        for (var scene : scenes)
            res.add(scene.screensCount());

        return res;
    }

    public static byte parseIdFromFileName(String fileName) {
        var numString = fileName.replaceAll("\\D+","");
        return numString.isEmpty() ? -1 : Byte.parseByte(numString);
    }
}
