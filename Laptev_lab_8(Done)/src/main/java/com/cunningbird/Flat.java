package com.cunningbird;

import java.util.Objects;

public class Flat {

    private int roomsCount;

    private int square;

    public Flat(int roomsCount, int square) {
        this.roomsCount = roomsCount;
        this.square = square;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return roomsCount == flat.roomsCount && Double.compare(flat.square, square) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomsCount, square);
    }

    @Override
    public String toString() {
        return "Flat{" +
                "roomsCount=" + roomsCount +
                ", square=" + square +
                '}';
    }
}
