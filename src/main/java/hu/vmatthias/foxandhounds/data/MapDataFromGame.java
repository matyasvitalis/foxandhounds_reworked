package hu.vmatthias.foxandhounds.data;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Map data getting code.
 */
public class MapDataFromGame {
    static String[][] loadmap = Gameboard.shortTable;
    static String[] allmap;
    static ArrayList<String> mapdata = new ArrayList<>();

    /**
     * Get row0 values.
     */
    public static String getMap0() {
        for (int i = 0; i < 8; i++) {
            allmap = loadmap[i];
            mapdata.add(Arrays.toString(allmap));
        }
        return mapdata.get(0);
    }

    /**
     * Get row1 values.
     */
    public static String getMap1() {
        for (int i = 0; i < 8; i++) {
            allmap = loadmap[i];
            mapdata.add(Arrays.toString(allmap));
        }
        return mapdata.get(1);
    }

    /**
     * Get row2 values.
     */
    public static String getMap2() {
        for (int i = 0; i < 8; i++) {
            allmap = loadmap[i];
            mapdata.add(Arrays.toString(allmap));
        }
        return mapdata.get(2);
    }

    /**
     * Get row3 values.
     */
    public static String getMap3() {
        for (int i = 0; i < 8; i++) {
            allmap = loadmap[i];
            mapdata.add(Arrays.toString(allmap));
        }
        return mapdata.get(3);
    }

    /**
     * Get row4 values.
     */
    public static String getMap4() {
        for (int i = 0; i < 8; i++) {
            allmap = loadmap[i];
            mapdata.add(Arrays.toString(allmap));
        }
        return mapdata.get(4);
    }

    /**
     * Get row5 values.
     */
    public static String getMap5() {
        for (int i = 0; i < 8; i++) {
            allmap = loadmap[i];
            mapdata.add(Arrays.toString(allmap));
        }
        return mapdata.get(5);
    }

    /**
     * Get row6 values.
     */
    public static String getMap6() {
        for (int i = 0; i < 8; i++) {
            allmap = loadmap[i];
            mapdata.add(Arrays.toString(allmap));
        }
        return mapdata.get(6);
    }

    /**
     * Get row7 values.
     */
    public static String getMap7() {
        for (int i = 0; i < 8; i++) {
            allmap = loadmap[i];
            mapdata.add(Arrays.toString(allmap));
        }
        return mapdata.get(7);
    }
}
