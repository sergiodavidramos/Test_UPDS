package com.example.testupds;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;


/**
 * A simple {@link Fragment} subclass.
 */
public class profileFragment extends Fragment {
TextView tNombre;
private Button btn;
DatabaseReference db;
String user;
   // DatabaseReference db;
    public profileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // u = getArguments().getString("username");
            //punt = getArguments().getInt("nota");
           user = getArguments().getString("username");


        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_profile, container, false);
        tNombre = view.findViewById(R.id.tvNombre);
        tNombre.setText(user);
        //btn = view.findViewById(R.id.buttonreinicio);
        db = FirebaseDatabase.getInstance().getReference("basedatos").child("students");
        // Inflate the layout for this fragment
        return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.menu_inflater, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_reset:
        res();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void res() {
        Log.i("exito",user);
        List<questions> questionsList;
        questionsList = new ArrayList<>();

        questionsList.add(new questions(1,0,"Coleccionar diferentes muestras de minerales"));
        questionsList.add(new questions(2,0,"Trabajar en una fábrica como mecánico"));
        questionsList.add(new questions(3,0,"Determinar el Cálculo de precios de nuevos productos"));
        questionsList.add(new questions(4,0,"Seguir un curso de Biología"));
        questionsList.add(new questions(5,0,"Ser un experto en propaganda comercial o Publicidad"));
        questionsList.add(new questions(6,0,"Trabajar como Técnico Agrícola en una cooperativa"));
        questionsList.add(new questions(7,0,"Desarmar un juguete electrónico malogrado e intentar arreglarlo"));
        questionsList.add(new questions(8,0,"Organizar los cálculos y resultados de una enc"));
        questionsList.add(new questions(9,0,"Investigar las causas de las enfermedades o plagas de las plantas"));
        questionsList.add(new questions(10,0,"Ser un Agente de Ventas o Promotor"));
        questionsList.add(new questions(11,0,"Criar ganado vacuno"));
        questionsList.add(new questions(12,0,"Reparar aparatos domésticos"));
        questionsList.add(new questions(13,0,"Hacer operaciones con una máquina calculadora"));
        questionsList.add(new questions(14,0,"Investigar una nueva información de un hecho histórico famoso"));
        questionsList.add(new questions(15,0,"Dirigir campañas por la defensa de los Derechos Humanos"));
        questionsList.add(new questions(16,0,"Estudiar las costumbres de la población de otros países"));
        questionsList.add(new questions(17,0,"Ser Ingeniero Mecánico o Electrónico"));
        questionsList.add(new questions(18,0,"Llevar libros de Contabilidad de un negocio"));
        questionsList.add(new questions(19,0,"Hacer el análisis clínico de un producto farmacéutico"));
        questionsList.add(new questions(20,0,"Encargarme de resolver problemas de personal de una empresa"));
        questionsList.add(new questions(21,0,"Trabajar en la pesca en alta mar"));
        questionsList.add(new questions(22,0,"Visitar un taller de reparaciones de aviones"));
        questionsList.add(new questions(23,0,"Ser un profesor de Matemáticas"));
        questionsList.add(new questions(24,0,"Trabajar en el perfeccionamiento de un nuevo metal"));
        questionsList.add(new questions(25,0,"Supervisar las ventas en un Centro Comercial"));
        questionsList.add(new questions(26,0,"Supervisar el trabajo de los obreros en una plantación de caña"));
        questionsList.add(new questions(27,0,"Reparar o retocar los muebles gastados"));
        questionsList.add(new questions(28,0,"Realizar trabajos que requieran operaciones aritméticas mentales"));
        questionsList.add(new questions(29,0,"Investigar las causas de las enfermedades mentales"));
        questionsList.add(new questions(30,0,"Exponer en un auditorio sobre 'El Arte de Convencer a la Gente'"));
        questionsList.add(new questions(31,0,"Seguir un curso de Dibujo Lineal"));
        questionsList.add(new questions(32,0,"Enseñar castellano"));
        questionsList.add(new questions(33,0,"Ser Pianista"));
        questionsList.add(new questions(34,0,"Trabajar con enfermeros o personas necesitadas"));
        questionsList.add(new questions(35,0,"Pagar los cheques al público en un Banco"));
        questionsList.add(new questions(36,0,"Ser un experto en fotografía"));
        questionsList.add(new questions(37,0,"Escribir novelas"));
        questionsList.add(new questions(38,0,"Escribir novelas"));
        questionsList.add(new questions(39,0,"Colaborar en un centro de recreación"));
        questionsList.add(new questions(40,0,"Recibir las llamadas telefónicas en una oficina"));
        questionsList.add(new questions(41,0,"Dibujar o pintar una escena importante"));
        questionsList.add(new questions(42,0,"Escribir artículos o editoriales para un periódico"));
        questionsList.add(new questions(43,0,"Ser comentarista de Música en la radio o TV"));
        questionsList.add(new questions(44,0,"Orientar a la gente joven en la elección de una ocupación"));
        questionsList.add(new questions(45,0,"Clasificar los documentos en una oficina"));
        questionsList.add(new questions(46,0,"Ser profesor de Arquitectura"));
        questionsList.add(new questions(47,0,"Estudiar Composición Literaria"));
        questionsList.add(new questions(48,0,"Trabajar en un establecimiento de discos o instrumentos musicales"));
        questionsList.add(new questions(49,0,"Trabajar en un albergue para niños huérfanos"));
        questionsList.add(new questions(50,0,"Corregir los errores mecanográficos de un informe"));
        questionsList.add(new questions(51,0,"Hacer una escultura de una persona famosa"));
        questionsList.add(new questions(52,0,"Ser periodista"));
        questionsList.add(new questions(53,0,"Ser profesor de música"));
        questionsList.add(new questions(54,0,"Ser profesor de música"));
        questionsList.add(new questions(55,0,"Seguir un curso de Redacción Comercial"));
        questionsList.add(new questions(56,0,"Diseñar y decorar nuevos ambientes"));
        questionsList.add(new questions(57,0,"Ser escritor"));
        questionsList.add(new questions(58,0,"Ser director de una orquesta"));
        questionsList.add(new questions(59,0,"Ser Trabajador Social o Asistente Social"));
        questionsList.add(new questions(60,0,"Ser secretario(a) de una institución"));

        db.child(user).child("pregunta_respuesta").setValue(questionsList);
//           db.child("pregunta_respuesta").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if(dataSnapshot.exists()){
//                    int c=0;
//                    for (DataSnapshot s : dataSnapshot.getChildren()){
//                        db = FirebaseDatabase.getInstance().getReference("basedatos").child("students").child(user).child("pregunta_respuesta");
//                        db.child(String.valueOf(c)).child("respuesta").setValue(0);
//                        Log.i("exito",s.getKey());
//                        c++;
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
    }

    public void reiniciar(View v){
Log.i("exito","hola");
    }

}
