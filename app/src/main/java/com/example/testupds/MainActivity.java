package com.example.testupds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    TextView tvGoSignUp;
    DatabaseReference db;
    EditText etUsername;
    EditText etPassword;
    String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getSupportActionBar().setTitle("sds");

        db = FirebaseDatabase.getInstance().getReference("basedatos").child("students");
        btnLogin = findViewById(R.id.btnRegister);
        tvGoSignUp = findViewById(R.id.btnGoLogin);
        etUsername = findViewById(R.id.txtUsuario);
        etPassword = findViewById(R.id.txtPassword);

    }

    public void intentarRegistrar(View view) {
        Intent intent = new Intent(MainActivity.this, SingUpActivity.class);
        startActivity(intent);
    }
    public void Acceder (View view){
        username = etUsername.getText().toString();
        password = etPassword.getText().toString();
        if(username.isEmpty()){
            etUsername.setError("El nombre del usuario es Obligatorio");
        }
        else if(password.isEmpty()){
            etPassword.setError("La contraseña es Obligatorio");
        }else{
            successful();
        }
    }

    private void successful() {
        Student es = new Student();
        es.setUsername(username);
        es.setPassword(password);
        Query consultUser = db.orderByChild("username").equalTo(username);
        consultUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int cant =0;
                Student es = new Student();
                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    es = singleSnapshot.getValue(Student.class);
                    Log.i("exito",es.password);
                    cant++;
                }
                if(cant==1){
                    if(es.getPassword().compareTo(password)==0){
                        Intent intent = new Intent(MainActivity.this, TestActivity.class);
                        intent.putExtra("username",username);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        etPassword.setError("Password Incorrecto");
                    }
                }else if(cant==0){
                    etUsername.setError("Usuario Incorrecto");
                    etPassword.setError("Password Incorrecto");
                    Toast.makeText(getApplicationContext(),"No existe el Usuario",Toast.LENGTH_LONG).show();
                    etUsername.setText("");
                    etPassword.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    
}
