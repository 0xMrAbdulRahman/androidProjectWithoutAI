package org.meicode.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class profile extends AppCompatActivity {
    TextView view;
    Button Btn;
    DatabaseHelper databaseHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        view=findViewById(R.id.textView);
        Btn=findViewById(R.id.button);
        databaseHelper =new DatabaseHelper(this);
        String USERLOgin = getIntent().getStringExtra("username");
         view.setText(" WELCOME " + USERLOgin);

         Btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 logout();
             }


         });
    }


    private void logout() {
            Intent intent=new Intent(profile.this,MainActivity.class);
            finish();
        }



}