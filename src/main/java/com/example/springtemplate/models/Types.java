package com.example.springtemplate.models;


public enum Types {
    AC(1), NonAC(2), Smoking(3), NonSmoking(4),
    BeachFacing(5), MountainFacing(6), Dorm(7),Suite(8);

    private int roomtype;

    private Types(int roomtype) {
        this.setRoomtype(roomtype);
    }


    public int getRoomtype() {
        return roomtype;
    }
    public void setRoomtype(int roomtype) {
        this.roomtype = roomtype;
    }

    public static Types getRoom(int id) {
        Types[] types = new Types[Types.values().length];
        types = Types.values();
        return types[id-1];
    }
}