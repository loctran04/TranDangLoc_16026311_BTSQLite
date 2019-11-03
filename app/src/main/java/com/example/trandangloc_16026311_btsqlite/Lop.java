package com.example.trandangloc_16026311_btsqlite;

public class Lop {
    private int idLop;
    private String name;

    public Lop(int idLop, String name) {
        this.idLop = idLop;
        this.name = name;
    }

    public Lop(String name) {
        this.name = name;
    }

    public int getIdLop() {
        return idLop;
    }

    public void setIdLop(int idLop) {
        this.idLop = idLop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lop{" +
                "idLop=" + idLop +
                ", name='" + name + '\'' +
                '}';
    }
}
