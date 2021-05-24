package com.cunningbird;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class HouseTest {

    @Test
    public void houseTest() {
        House house = new House();

        Flat flat1 = new Flat(2, 35);
        Flat flat2 = new Flat(4, 65);
        Flat flat3 = new Flat(3, 75);
        Flat flat5 = new Flat(3, 56);
        Flat flat4 = new Flat(3, 75);

        house.appendFlat(flat1);
        house.appendFlat(flat2);
        house.appendFlat(flat3);
        house.appendFlat(flat4);
        house.appendFlat(flat5);

        Map<Integer, Integer> hoseInfo = house.roomsInfo();
        System.out.println(hoseInfo);

        List<Flat> greatestFlats = house.getGreatestInAreaFlats(3);
        greatestFlats.forEach(System.out::println);
    }
}
