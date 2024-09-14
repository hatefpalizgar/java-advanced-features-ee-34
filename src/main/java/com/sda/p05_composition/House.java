package com.sda.p05_composition;

// A House:
// - manages an array of rooms and their count
// - responsible for creating of the rooms
// - rooms do not exist independently of the house; if the house is destroyed,
// the rooms are also destroyed
public class House {
    private Room[] rooms; // a house is composed of rooms (composition)
    private int roomCount;

    public House(int roomCount) {
        this.roomCount = 0;
        this.rooms = new Room[roomCount];
    }

    public void addRoom(String roomName) {
        if (roomCount < rooms.length) {
            rooms[roomCount] = new Room(roomName);
            roomCount++;
        } else {
            System.out.println("ERROR: House has the maximum number of rooms");
        }
    }

    public Room[] getRooms() {
        return rooms;
    }
}
