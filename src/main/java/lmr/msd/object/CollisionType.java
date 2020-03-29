package lmr.msd.object;

import java.util.*;

// FIXME: convert to ints, get rid of enum
public abstract class CollisionType {
    private static final Set<Byte> KNOWN_VALUES = new HashSet<>(56);

    private static Byte add(int value) {
        var byteValue = Byte.valueOf((byte) (value > 0x7F ? value - 256 : value));
        KNOWN_VALUES.add(byteValue);
        return byteValue;
    }

    public static final Byte EMPTY = add(0x00);
    public static final Byte LADDER_LEFT = add(0x01);
    public static final Byte LADDER_LEFT_CENTER = add(0x02);
    public static final Byte LADDER_RIGHT_CENTER = add(0x03);
    public static final Byte LADDER_RIGHT = add(0x04);
    public static final Byte WATER = add(0x05);
    public static final Byte WATER_FLOW_UP = add(0x06);
    public static final Byte WATER_FLOW_RIGHT = add(0x07);
    public static final Byte WATER_FLOW_DOWN = add(0x08);
    public static final Byte WATER_FLOW_LEFT = add(0x09);
    public static final Byte WATER_LADDER_LEFT = add(0x0A);
    public static final Byte WATER_LADDER_LEFT_CENTER = add(0x0B);
    public static final Byte WATER_LADDER_RIGHT_CENTER = add(0x0C);
    public static final Byte WATER_LADDER_RIGHT = add(0x0D);
    public static final Byte LAVA = add(0x10);
    public static final Byte LAVA_FLOW_UP = add(0x11);
    public static final Byte LAVA_FLOW_RIGHT = add(0x12);
    public static final Byte LAVA_FLOW_DOWN = add(0x13);
    public static final Byte LAVA_FLOW_LEFT = add(0x14);
    public static final Byte LAVA_LADDER_LEFT = add(0x15);
    public static final Byte LAVA_LADDER_LEFT_CENTER = add(0x16);
    public static final Byte LAVA_LADDER_RIGHT_CENTER = add(0x17);
    public static final Byte LAVA_LADDER_RIGHT = add(0x18);
    public static final Byte WATERFALL = add(0x20);
    public static final Byte YOWIE_TILE = add(0x30); // For wall-scarabs in Moonlight
    public static final Byte OVERRIDE_EMPTY = add(0x7F);
    // Values past here are written unsigned to match the docs, but are actually stored as the shown value - 256 since
    // Java doesn't have unsigned int types.
    public static final Byte GROUND = add(0x80);
    public static final Byte SLOPE_45_ASC = add(0x81);
    public static final Byte SLOPE_45_DESC = add(0x82);
    public static final Byte SLOPE_30_ASC_LOWER = add(0x83);
    public static final Byte SLOPE_30_ASC_UPPER = add(0x84);
    public static final Byte SLOPE_30_DESC_UPPER = add(0x85);
    public static final Byte SLOPE_30_DESC_LOWER = add(0x86);
    public static final Byte SLOPE_60_ASC_LOWER = add(0x87);
    public static final Byte SLOPE_60_ASC_UPPER = add(0x88);
    public static final Byte SLOPE_60_DESC_UPPER = add(0x89);
    public static final Byte SLOPE_60_DESC_LOWER = add(0x8A);
    public static final Byte ICE = add(0x8C);
    public static final Byte ICE_SLOPE_45_ASC = add(0x8D);
    public static final Byte ICE_SLOPE_45_DESC = add(0x8E);
    public static final Byte ICE_SLOPE_30_ASC_LOWER = add(0x8F);
    public static final Byte ICE_SLOPE_30_ASC_UPPER = add(0x90);
    public static final Byte ICE_SLOPE_30_DESC_UPPER = add(0x91);
    public static final Byte ICE_SLOPE_30_DESC_LOWER = add(0x92);
    public static final Byte SAND_SLOPE_45_ASC = add(0xA1);
    public static final Byte SAND_SLOPE_45_DESC = add(0xA3);
    public static final Byte SAND_SLOPE_30_ASC_LOWER = add(0xA6);
    public static final Byte SAND_SLOPE_30_ASC_UPPER = add(0xA7);
    public static final Byte SAND_SLOPE_30_DESC_UPPER = add(0xAA);
    public static final Byte SAND_SLOPE_30_DESC_LOWER = add(0xAB);
    public static final Byte CEILING_SLOPE_45_ASC = add(0xB5);
    public static final Byte CEILING_SLOPE_45_DESC = add(0xB6);
    public static final Byte CEILING_SLOPE_30_ASC_LOWER = add(0xB7);
    public static final Byte CEILING_SLOPE_30_ASC_UPPER = add(0xB8);
    public static final Byte CRUSH_VERTICAL = add(0xC0);
    public static final Byte CRUSH_HORIZONTAL = add(0xC1);

    public static Set<Byte> SOLIDS = Set.of(
        GROUND,
        CRUSH_HORIZONTAL,
        CRUSH_VERTICAL,
        ICE
    );

    public static Set<Byte> WATERS = Set.of(
        WATER,
        WATER_LADDER_LEFT,
        WATER_LADDER_LEFT_CENTER,
        WATER_LADDER_RIGHT,
        WATER_LADDER_RIGHT_CENTER,
        WATER_FLOW_LEFT,
        WATER_FLOW_RIGHT,
        WATER_FLOW_DOWN,
        WATER_FLOW_UP
    );

    public static Set<Byte> LAVAS = Set.of(
        LAVA,
        LAVA_LADDER_LEFT,
        LAVA_LADDER_LEFT_CENTER,
        LAVA_LADDER_RIGHT_CENTER,
        LAVA_LADDER_RIGHT,
        LAVA_FLOW_DOWN,
        LAVA_FLOW_LEFT,
        LAVA_FLOW_RIGHT,
        LAVA_FLOW_UP
    );

    public static Set<Byte> LADDERS = Set.of(
        LADDER_LEFT,
        LADDER_RIGHT,
        LADDER_LEFT_CENTER,
        LADDER_RIGHT_CENTER,
        WATER_LADDER_LEFT,
        WATER_LADDER_LEFT_CENTER,
        WATER_LADDER_RIGHT_CENTER,
        WATER_LADDER_RIGHT,
        LAVA_LADDER_LEFT,
        LAVA_LADDER_LEFT_CENTER,
        LAVA_LADDER_RIGHT_CENTER,
        LAVA_LADDER_RIGHT
    );

    public static Set<Byte> ICES = Set.of(
        ICE,
        ICE_SLOPE_45_ASC,
        ICE_SLOPE_45_DESC,
        ICE_SLOPE_30_ASC_LOWER,
        ICE_SLOPE_30_ASC_UPPER,
        ICE_SLOPE_30_DESC_UPPER,
        ICE_SLOPE_30_DESC_LOWER
    );

    private static boolean contains(Set<Byte> set, Byte value) {
        return value != null && set.contains(value);
    }

    public static boolean isEmpty(Byte value) {
        return Objects.equals(value, EMPTY) || Objects.equals(value, OVERRIDE_EMPTY);
    }

    public static boolean isSolid(Byte value) {
        return contains(SOLIDS, value);
    }

    public static boolean isWater(Byte value) {
        return contains(WATERS, value);
    }

    public static boolean isLava(Byte value) {
        return contains(LAVAS, value);
    }

    public static boolean isLadder(Byte value) {
        return contains(LADDERS, value);
    }

    public static boolean isIce(Byte value) {
        return contains(ICES, value);
    }

    public static boolean isCrush(Byte value) {
        return Objects.equals(value, CRUSH_HORIZONTAL) || Objects.equals(value, CRUSH_VERTICAL);
    }

    public static boolean isKnown(Byte value) {
        return contains(KNOWN_VALUES, value);
    }
}
