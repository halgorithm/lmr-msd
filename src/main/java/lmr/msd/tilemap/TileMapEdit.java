package lmr.msd.tilemap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

// TileMap data mutation logic, mostly shared between TileMap and RectangleSelection.
public class TileMapEdit {
    public static <T> List<List<T>> buildData(short width, short height, T fillValue) {
        return buildData(width, height, (x,y) -> fillValue);
    }

    public static <T> List<List<T>> buildData(short width, short height, BiFunction<Short, Short, T> supplier) {
        var res = new ArrayList<List<T>>(width);

        for (short x = 0; x < width; x++) {
            var column = new ArrayList<T>(height);
            for (short y = 0; y < height; y++) {
                var val = supplier.apply(x, y);
                column.add(val);
            }

            res.add(column);
        }

        return res;
    }

    public static <T> short getWidth(List<List<T>> data) {
        return (short) data.size();
    }

    public static <T> short getHeight(List<List<T>> data) {
        return (short) (data.isEmpty() ? 0 : data.get(0).size());
    }

    public static <T> boolean isInBounds(List<List<T>> data, int x, int y) {
        return isInBounds(x, y, 0, 0, getWidth(data), getHeight(data));
    }

    public static boolean isInBounds(int x, int y, Rectangle rect) {
        return isInBounds(x, y, rect.x, rect.y, rect.width, rect.height);
    }

    public static boolean isInBounds(int x, int y, int rectX, int rectY, int width, int height) {
        return x >= rectX && x < rectX + width && y >= rectY && y < rectY + height;
    }

    public static <T> void ensureInBounds(List<List<T>> data, int x, int y, int width, int height) {
        ensureInBounds(data, x, y);
        ensureInBounds(data, x + width - 1, y + height - 1);
    }

    public static <T> void ensureInBounds(List<List<T>> data, int x, int y) {
        if (isInBounds(data, x, y)) return;
        throw new IndexOutOfBoundsException();
    }

    public static <T> T getTile(List<List<T>> data, int x, int y) {
        return isInBounds(data, x, y) ? getTileUnchecked(data, x, y) : null;
    }

    public static <T> T getTileUnchecked(List<List<T>> data, int x, int y) {
        return data.get(x).get(y);
    }

    public static <T> void setTile(List<List<T>> data, int x, int y, T value) {
        ensureInBounds(data, x, y);
        setTileUnchecked(data, x, y, value);
    }

    public static <T> void setTileUnchecked(List<List<T>> data, int x, int y, T value) {
        data.get(x).set(y, value);
    }

    public static <T> void onRect(List<List<T>> data, int x, int y, int width, int height, TileAndCoordsConsumer<T> consumer) {
        ensureInBounds(data, x, y, width, height);

        for (short iy = 0; iy < height; iy++) {
            for (short ix = 0; ix < width; ix++) {
                var value = getTileUnchecked(data, x + ix, y + iy);
                consumer.accept(value, ix, iy);
            }
        }
    }

    public static <T> void resize(List<List<T>> data, short width, short height, T fillValue) {
        // eventually support an overload to specify anchor TOP_LEFT, CENTER, RIGHT etc.
        // it would translate the data content then perform the resize

        var widthChange = width - getWidth(data);
        if (widthChange < 0) {
            for (int i = 0; i < -widthChange; i++) {
                data.remove(data.size() - 1);
            }
        } else if (widthChange > 0) {
            for (int i = 0; i < widthChange; i++) {
                data.add(new ArrayList<>(height));
            }
        }

        var heightChange = height - getHeight(data);
        if (heightChange < 0) {
            for (int c = 0; c < width; c++) {
                for (int i = 0; i < -heightChange; i++) {
                    var column = data.get(c);
                    column.remove(column.size() - 1);
                }
            }
        } else if (heightChange > 0) {
            for (int c = 0; c < width; c++) {
                for (int i = 0; i < heightChange; i++) {
                    var column = data.get(c);
                    column.add(fillValue);
                }
            }
        }
    }

    public static <T> List<Point> testTiles(
        List<List<T>> data, int x, int y, int width, int height, TileAndCoordsPredicate<T> predicate
    ) {
        ensureInBounds(data, x, y, width, height);

        var points = new ArrayList<Point>();

        for (short ix = 0; ix < width; ix++) {
            var column = data.get(x + ix);
            for (short iy = 0; iy < height; iy++) {
                var value = column.get(y + iy);
                if (predicate.test(value, ix, iy))
                    points.add(new Point(x + ix, y + iy));
            }
        }

        return points;
    }
}
