package com.example.testupds;

public class Student {
    String username, password, establecimiento, sexo;
    int edad;

    public Student() {
    }

    public Student(String username, String password, String establecimiento, int edad, String sexo) {
        this.username = username;
        this.password = password;
        this.establecimiento = establecimiento;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}

