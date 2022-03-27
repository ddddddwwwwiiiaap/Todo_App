package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //deklarasi variabel untuk button
    Button btnLogin;

    //deklrasi variabel untuk TextVidew
    TextView regis;

    //deklrasi variabel untuk EditText
    EditText ednama, edpassword;

    //deklarasi variabel untuk menyimpan email dan password
    String nama, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        regis = findViewById(R.id.tRegister);
        btnLogin = findViewById(R.id.btsign);
        ednama = findViewById(R.id.user1);
        edpassword = findViewById(R.id.pass1);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegistrasiAct.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //menyimpan input user di eddittex email kedalam variabel nama
                nama = ednama.getText().toString();

                //menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                Bundle b = new Bundle();
                b.putString("name", nama.trim());

                if(ednama.getText().toString().equals("") && edpassword.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(), "Username dan Password Harus Diisi!!!", Toast.LENGTH_SHORT).show();
                }
                else if (ednama.getText().toString().length()==0) {
                    ednama.setError("Username!");
                    Toast.makeText(getApplicationContext(), "Username Harus Diisi", Toast.LENGTH_SHORT).show();
                }
                else if (edpassword.getText().toString().length()==0) {
                    edpassword.setError("Password!");
                    Toast.makeText(getApplicationContext(), "Password Harus Diisi", Toast.LENGTH_SHORT).show();
                }
                else if(!ednama.getText().toString().equals("Dwi")){
                    Toast.makeText(getApplicationContext(), "Nama Salah", Toast.LENGTH_SHORT).show();
                }
                else if(!edpassword.getText().toString().equals("20200140055")){
                    Toast.makeText(getApplicationContext(), "Password Salah", Toast.LENGTH_SHORT).show();
                }
                else if(ednama.getText().toString().equals("Dwi") && edpassword.getText().toString().equals("20200140055")){

                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(getApplicationContext(), TaskAct.class);
                    i.putExtras(b);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}