package com.cunningbird;

import java.util.*;

public class House {

    private final List<Flat> flats;

    public House() {
        this.flats = new ArrayList<>();
    }

    public List<Flat> getFlats() {
        return flats;
    }

    public void appendFlat(Flat flat) {
        this.flats.add(flat);
    }

    public Map<Integer, Integer> roomsInfo() {
        Map<Integer, Integer> rooms = new HashMap<>();
        for (Flat flat : flats) {
            if (rooms.containsKey(flat.getRoomsCount())) {
                rooms.put(flat.getRoomsCount(), rooms.get(flat.getRoomsCount()) + 1);
            } else {
                rooms.put(flat.getRoomsCount(), 1);
            }
        }
        return rooms;
    }

    public List<Flat> getGreatestInAreaFlats(int flats) {
        List<Flat> flatList = new ArrayList<>(this.flats.size());
        for (int i = 0; i < flats; i++) {
            flatList.add(this.flats.get(i));
        }

        FlatAreaComparator flatAreaComparator = new FlatAreaComparator();
        flatList.sort(flatAreaComparator);

        List<Flat> result = new ArrayList<>(flatList);
        for (int i = 0; i < flats; i++) {
            result.add(result.get(i));
        }
        return result;
    }
}
