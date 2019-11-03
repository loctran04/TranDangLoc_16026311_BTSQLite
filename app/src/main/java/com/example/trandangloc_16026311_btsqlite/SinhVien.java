package com.example.trandangloc_16026311_btsqlite;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private int idSinhVien;
    private String name, className, subject;

    public SinhVien(int idSinhVien, String name, String className, String subject) {
        this.idSinhVien = idSinhVien;
        this.name = name;
        this.className = className;
        this.subject = subject;
    }

    public SinhVien(String name, String className, String subject) {
        this.name = name;
        this.className = className;
        this.subject = subject;
    }

    public SinhVien() {
    }

    public int getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(int idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "idSinhVien=" + idSinhVien +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
