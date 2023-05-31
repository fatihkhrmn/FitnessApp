package com.example.fitnessapp;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText username, password, cPassword;
    Button fitSignup;
    DBHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        cPassword = findViewById(R.id.cPassword);
        fitSignup = findViewById(R.id.fitSignup);
        DB = new DBHelper(this);

        fitSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                String cPass = cPassword.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(cPass)){
                    Toast.makeText(signup.this, "Tüm Alanları Doldurunuz", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (pass.equals(cPass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertdata(user, pass);
                            if (insert==true){
                                Toast.makeText(signup.this, "Kayıt Başarılı!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), login.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(signup.this, "Yeniden Deneyiniz", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(signup.this, "Bu Kullanıcı Zaten Kayıtlı", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(signup.this, "Parolalar Uyuşmuyor", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}