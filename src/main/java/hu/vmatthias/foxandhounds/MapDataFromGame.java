package hu.vmatthias.foxandhounds;

import java.util.ArrayList;
import java.util.Arrays;

public class MapDataFromGame {
    static String[][] loadmap = Gameboard.shortTable;
    static String[] allmap;
    static ArrayList<String> mapdata = new ArrayList<>();

    public MapDataFromGame() {
    }

    public static String getMap0() {
        for (int i = 0; i < 8; i++) {
            allmap = loadmap[i];
            mapdata.add(Arrays.toString(allmap));
        }
        return mapdata.get(0);
    }

    public static String getMap1() {
        for (int i = 0; i < 8; i++) {
            allmap = loadmap[i];
            mapdata.add(Arrays.toString(allmap));
        }
        return mapdata.get(1);
    }

    public static String getMap2() {
        for (int i = 0; i < 8; i++) {
            allmap = loadmap[i];
            mapdata.add(Arrays.toString(allmap));
        }
        return mapdata.get(2);
    }

    public static String getMap3() {
        for (int i = 0; i < 8; i++) {
            allmap = loadmap[i];
            mapdata.add(Arrays.toString(allmap));
        }
        return mapdata.get(3);
    }

    public static String getMap4() {
        for (int i = 0; i < 8; i++) {
            allmap = loadmap[i];
            mapdata.add(Arrays.toString(allmap));
        }
        return mapdata.get(4);
    }

    public static String getMap5() {
        for (int i = 0; i < 8; i++) {
            allmap = loadmap[i];
            mapdata.add(Arrays.toString(allmap));
        }
        return mapdata.get(5);
    }

    public static String getMap6() {
        for (int i = 0; i < 8; i++) {
            allmap = loadmap[i];
            mapdata.add(Arrays.toString(allmap));
        }
        return mapdata.get(6);
    }

    public static String getMap7() {
        for (int i = 0; i < 8; i++) {
            allmap = loadmap[i];
            mapdata.add(Arrays.toString(allmap));
        }
        return mapdata.get(7);
    }
}
