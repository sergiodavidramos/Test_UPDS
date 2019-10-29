package com.example.testupds;

public class questions {
   int id, respuesta;
   String pregunta;
    public questions() {
        ;
    }

    public questions(int id, int respuesta, String pregunta) {
        this.id = id;
        this.respuesta = respuesta;
        this.pregunta = pregunta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
}
