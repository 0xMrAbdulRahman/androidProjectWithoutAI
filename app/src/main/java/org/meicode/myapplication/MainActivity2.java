package org.meicode.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    EditText username,email,password;
    Button login,singup;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

             username=findViewById(R.id.usernameS);
             email=findViewById(R.id.Email);
             password=findViewById(R.id.password);
             singup=findViewById(R.id.SignUP);
             login=findViewById(R.id.Login);

             login.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent =new Intent(MainActivity2.this,MainActivity.class);
                     startActivity(intent);

                 }
             });
             singup.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     String USER=username.getText().toString().trim();
                     String Email=email.getText().toString().trim();
                     String PASS=password.getText().toString().trim();
                     if(USER==null||PASS==null||Email==null){
                         Toast.makeText(MainActivity2.this,"Sign up..... ",Toast.LENGTH_SHORT).show();
                     }
                     else{
                         if(databaseHelper.insertData(USER,Email,PASS)){
                             Toast.makeText(MainActivity2.this, "Sign up successfully....", Toast.LENGTH_SHORT).show();
                             Intent intent=new Intent(MainActivity2.this, MainActivity.class);
                             startActivity(intent);
                         }
                         else{
                             Toast.makeText(MainActivity2.this, "Error Sign up Error OR user exist.....", Toast.LENGTH_SHORT).show();

                         }
                     }
                 }
             });


        }
    }
