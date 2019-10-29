package com.example.testupds;

public class perfil {
    String campo;
    int puntaje;
    public perfil() {
    }

    public perfil(String campo, int puntaje) {
        this.campo = campo;
        this.puntaje = puntaje;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
