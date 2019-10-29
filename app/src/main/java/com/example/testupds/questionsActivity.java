package com.example.testupds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class questionsActivity extends AppCompatActivity {
    private ListView lvItems;
    private String user;
    DatabaseReference db;
    List<questions> pre;
    int cont;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        getSupportActionBar().setTitle("Test Vocacional");
        final Bundle extra = getIntent().getExtras();
        user = extra.getString("username");

        db = FirebaseDatabase.getInstance().getReference("basedatos").child("students").child(user);

    DatabaseReference rDatabase = FirebaseDatabase.getInstance().getReference("basedatos").child("students").child(user);
    rDatabase.child("pregunta_respuesta").addValueEventListener(new ValueEventListener() {

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        pre = new ArrayList<>();

        if(dataSnapshot.exists()){
            cont=0;
        for (DataSnapshot ds : dataSnapshot.getChildren()){
             int i=ds.child("id").getValue().hashCode();
             String pregunta = ds.child("pregunta").getValue().toString();
             int re = ds.child("respuesta").getValue().hashCode();
            pre.add(new questions(i,re,pregunta));
         //   Log.i("exito",String.valueOf(i));
            if(re==0){
                cont++;
            }
        }
        enviarDatos(pre);
        if(cont==0){
            AlertDialog.Builder dia1 = new AlertDialog.Builder(questionsActivity.this);
            dia1.setTitle("HAS FINALIZADO EL TEST");
            dia1.setMessage("¿Deseas ver los resultados?");
            dia1.setCancelable(false);
            dia1.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(questionsActivity.this,TestActivity.class);
                                Bundle extras = new Bundle();
                                extras.putInt("menu",2);
                                extras.putString("username",user);
                                i.putExtras(extras);
                                startActivity(i);

                }
            });
            dia1.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {

                }
            });
            dia1.show();

        }
        else {
            Log.i("exito", "entro y hay ceros :"+cont);
        }
        }
    }
    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
    }
    });
    }

    private void enviarDatos(List<questions> pre) {
        lvItems = (ListView) findViewById(R.id.lvItem);
         i = lvItems.getFirstVisiblePosition();
        lvItems.setAdapter(new adaptador(questionsActivity.this,pre,user));
        lvItems.setSelection(i);
    }
}
