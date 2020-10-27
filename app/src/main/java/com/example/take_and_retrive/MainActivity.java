package com.example.take_and_retrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView name;
    Button button;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.text);
        button=findViewById(R.id.bu);
        databaseReference=FirebaseDatabase.getInstance().getReference("Baba");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final  String name1=name.getText().toString().trim();
                String key=databaseReference.push().getKey();
                HashMap<Object,String> hashMap=new HashMap<>();
                hashMap.put("name",name1);
                databaseReference.child(key).setValue(hashMap);
                name.setText("");
                Toast.makeText(MainActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainActivity2.class));

            }
        });

    }
}