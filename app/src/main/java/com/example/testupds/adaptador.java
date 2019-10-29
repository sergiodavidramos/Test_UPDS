package com.example.testupds;
import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

public class adaptador extends BaseAdapter {
    private static LayoutInflater inflater = null;
    Context context;
    List<questions> datos;
    DatabaseReference db;
    String username;
    public adaptador(Context context, List<questions>  datos, String username) {
        this.context = context;
        this.datos = datos;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        this.username = username;
        db = FirebaseDatabase.getInstance().getReference("basedatos").child("students").child(username).child("pregunta_respuesta");
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.fragment_questionsfragment, null);
       final TextView txtPregunta =  vista.findViewById(R.id.textViewP);
        final RadioButton radioButton1 = vista.findViewById(R.id.radioButton1);
        RadioButton radioButton2 = vista.findViewById(R.id.radioButton2);
        RadioButton radioButton3 = vista.findViewById(R.id.radioButton3);
        RadioButton radioButton4 = vista.findViewById(R.id.radioButton4);
        RadioButton radioButton5 = vista.findViewById(R.id.radioButton5);
        txtPregunta.setText(datos.get(position).getPregunta());

        radioButton1.setTag(position);
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.child(String.valueOf(position)).child("respuesta").setValue(1);
                Log.i("exito","dato registrado :"+username+(position+1));
            }
        });
        radioButton2.setTag(position);
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.child(String.valueOf(position)).child("respuesta").setValue(2);
                Log.i("exito","dato registrado"+(position+1));



            }
        });
        radioButton3.setTag(position);
        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.child(String.valueOf(position)).child("respuesta").setValue(3);
                Log.i("exito","dato registrado"+(position+1));


            }
        });
        radioButton4.setTag(position);
        radioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.child(String.valueOf(position)).child("respuesta").setValue(4);
                Log.i("exito","dato registrado"+(position+1));

            }
        });
        radioButton5.setTag(position);
        radioButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.child(String.valueOf(position)).child("respuesta").setValue(5);
                Log.i("exito","dato registrado"+(position+1));

            }
        });
        if(datos.get(position).getRespuesta()==1)
        {
            radioButton1.setChecked(true);
        }
        if(datos.get(position).getRespuesta()==2)
        {
            radioButton2.setChecked(true);
        }
        if(datos.get(position).getRespuesta()==3)
        {
            radioButton3.setChecked(true);
        }
        if(datos.get(position).getRespuesta()==4)
        {
            radioButton4.setChecked(true);
        }
        if(datos.get(position).getRespuesta()==5)
        {
            radioButton5.setChecked(true);
        }
        return vista;
    }
}
