package com.example.testupds;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import static java.lang.Integer.parseInt;

public class TestActivity extends AppCompatActivity {
    DatabaseReference db;
    String username;
    int p0=0,p1=0,p2=0,p3=0,p4=0,p5=0,p6=0,p7=0,p8=0,p9=0,cont1=1,
            cont2=2,cont3=3,cont4=4,cont5=5,cont6=31,cont7=32,cont8=33,cont9=34,cont10=35, puntomaximo=0;
    List<perfil> perfilList;
    String user,campo;
    int temp;
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment inicio = null;
            switch (item.getItemId()){
                case R.id.navigation_home:
                    Log.i("exito", "Hola Mundo");
                    inicio = new InitFragmentFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor,inicio).commit();
                    return true;
                case R.id.navigation_dashboard:
                    cargardashboard22();
                    return true;
                case R.id.navigation_notifications:
                    inicio = new profileFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("username",user);
                    inicio.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor,inicio).commit();
                    return true;
            }
//            if(inicio!=null){
//                getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor,inicio).commit();
//            }
            return false;
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
          if(navigation.getSelectedItemId()==R.id.navigation_home){

            Toast.makeText(getApplicationContext(), "bye!!",
                    Toast.LENGTH_SHORT).show();
              finish();
          }
          else{
              getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor, new InitFragmentFragment()).commit();
              navigation.setSelectedItemId(R.id.navigation_home);
          }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Test Vocacional");
        setContentView(R.layout.activity_test);

        TextView tvTitulo,tv1,tv2,tv3,tv4,tv5;
        tvTitulo = findViewById(R.id.textViewTitulo);
        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);
        tv5 = findViewById(R.id.textView5);
        Bundle extra = getIntent().getExtras();
         navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        temp =extra.getInt("menu");
        user =extra.getString("username");

        db = FirebaseDatabase.getInstance().getReference("basedatos").child("students").child(user);
        if(temp==2){
            cargardashboard();
            navigation.setSelectedItemId(R.id.navigation_dashboard);
        }
        else{
            getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor, new InitFragmentFragment()).commit();
        }

        username =extra.getString("username");
        BlankFragment blan = new BlankFragment();

    }

    private void cargardashboard22() {
        db.child("perfil").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){


                    db.child("perfil").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                for (DataSnapshot ds : dataSnapshot.getChildren()){
                                    String p = ds.child("puntaje").getValue().toString();
                                    String cap = ds.child("campo").getValue().toString();
                                    //  Log.i("exito", String.valueOf(p));
                                    if(puntomaximo < parseInt(p)){
                                        puntomaximo=Integer.parseInt(p);
                                        campo = cap;
                                    }
                                }

                            }
                            //  Log.i("exito", "entro al if"+puntomaximo);
                            BlankFragment dash= new BlankFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("username",user);
                            bundle.putInt("nota",puntomaximo);
                            bundle.putString("campo",campo);
                            dash.setArguments(bundle);
                            getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor, dash).commit();

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                else {
                        BlankFragment dash= new BlankFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("username",user);
                        bundle.putInt("nota",puntomaximo);
                        bundle.putString("campo",campo);
                        dash.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor, dash).commit();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void cargardashboard() {

        //  DatabaseReference db;
        Log.i("exito","entro para cargar todo");

        db.child("pregunta_respuesta").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                perfilList = new ArrayList<>();
                if(dataSnapshot.exists()){
                    for (DataSnapshot ds : dataSnapshot.getChildren()){
                        int i=ds.child("id").getValue().hashCode();
                        String pregunta = ds.child("pregunta").getValue().toString();
                        int re = ds.child("respuesta").getValue().hashCode();
                        if(i==cont1){
                            p0=p0+re;
                            cont1=cont1+5;
                        }
                        if(i==cont2){
                            p1=p1+re;
                            cont2=cont2+5;
                        }
                        if(i==cont3){
                            p2=p2+re;
                            cont3=cont3+5;
                        }
                        if(i==cont4){
                            p3=p3+re;
                            cont4=cont4+5;
                        }
                        if(i==cont5){
                            p4=p4+re;
                            cont5=cont5+5;
                        }
                        if (i==30){
                            String id0="aire_libre";
                            perfil nuevo = new perfil();
                            nuevo.setCampo(id0);
                            nuevo.setPuntaje(p0);
                            db.child("perfil").child(id0).setValue(nuevo);

                            String id1="mecanico_constructivo";
                            nuevo = new perfil();
                            nuevo.setCampo(id1);
                            nuevo.setPuntaje(p1);
                            db.child("perfil").child(id1).setValue(nuevo);

                            String id2="calculo";
                            nuevo = new perfil();
                            nuevo.setCampo(id2);
                            nuevo.setPuntaje(p2);
                            db.child("perfil").child(id2).setValue(nuevo);

                            String id3="cientifico";
                            nuevo = new perfil();
                            nuevo.setCampo(id3);
                            nuevo.setPuntaje(p3);
                            db.child("perfil").child(id3).setValue(nuevo);

                            String id4="persuasivo";
                            nuevo = new perfil();
                            nuevo.setCampo(id4);
                            nuevo.setPuntaje(p4);
                            db.child("perfil").child(id4).setValue(nuevo);
                        }


                        if(i==cont6){
                            p5=p5+re;
                            cont6=cont6+5;
                        }
                        if(i==cont7){
                            p6=p6+re;
                            cont7=cont7+5;
                        }
                        if(i==cont8){
                            p7=p7+re;
                            cont8=cont8+5;
                        }
                        if(i==cont9){
                            p8=p8+re;
                            cont9=cont9+5;
                        }
                        if(i==cont10){
                            p9=p9+re;
                            cont10=cont10+5;
                        }


                        if(i==60){
                            String id5="artistico";
                            perfil nuevo = new perfil();
                            nuevo.setCampo(id5);
                            nuevo.setPuntaje(p5);
                            db.child("perfil").child(id5).setValue(nuevo);

                            String id6="literario";
                            nuevo = new perfil();
                            nuevo.setCampo(id6);
                            nuevo.setPuntaje(p6);
                            db.child("perfil").child(id6).setValue(nuevo);

                            String id7="musical";
                            nuevo = new perfil();
                            nuevo.setCampo(id7);
                            nuevo.setPuntaje(p7);
                            db.child("perfil").child(id7).setValue(nuevo);

                            String id8="servicio_social";
                            nuevo = new perfil();
                            nuevo.setCampo(id8);
                            nuevo.setPuntaje(p8);
                            db.child("perfil").child(id8).setValue(nuevo);

                            String id9="ofisina";
                            nuevo = new perfil();
                            nuevo.setCampo(id9);
                            nuevo.setPuntaje(p9);
                            db.child("perfil").child(id9).setValue(nuevo);
                        }

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        db.child("perfil").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for (DataSnapshot ds : dataSnapshot.getChildren()){
                        String p = ds.child("puntaje").getValue().toString();
                        String cap = ds.child("campo").getValue().toString();
                      //  Log.i("exito", String.valueOf(p));
                        if(puntomaximo < parseInt(p)){
                            puntomaximo=Integer.parseInt(p);
                            campo = cap;
                        }
                    }

                }
                BlankFragment dash= new BlankFragment();
                Bundle bundle = new Bundle();
                bundle.putString("username",user);
                bundle.putInt("nota",puntomaximo);
                bundle.putString("campo",campo);
                dash.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor, dash).commit();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void inConsis (View v){
        Log.i("exito", "Hola Mundo");
        getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor, new InicioFragment()).commit();
    }
    public void goTest(View v){
        Intent in =new Intent(TestActivity.this, questionsActivity.class);
        Bundle extra = new Bundle();
        extra.putString("username", username);
        in.putExtras(extra);
        startActivity(in);

    }
    public void goResult(View v){
        questionsFragment fragment = new questionsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("username",username);
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor,fragment).commit();
    }

//    public void reiniciar(View v){
//
//
//
//    }
    @Override
    public void onBackPressed(){
        getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor, new InitFragmentFragment()).commit();
        super.onBackPressed();
    }

}
