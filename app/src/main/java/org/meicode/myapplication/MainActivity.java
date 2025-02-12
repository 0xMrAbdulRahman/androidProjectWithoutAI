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

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button login,singup;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        singup=findViewById(R.id.SignUP);
        login=findViewById(R.id.Login);

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String USER=username.getText().toString().trim();
                String PASS=password.getText().toString().trim();
                if(USER==null||PASS==null){
                    Toast.makeText(MainActivity.this,"Please enter your username and password",Toast.LENGTH_SHORT).show();
                }
                else{
                    String user=databaseHelper.checkData(USER,PASS);
                    if(user!=null){
                        Intent intent=new Intent(MainActivity.this,profile.class);
                        intent.putExtra("username",user);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this,"invalid uername or password",Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });
    }
}