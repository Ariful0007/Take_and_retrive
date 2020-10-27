package com.example.take_and_retrive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    List<ModelUser> studentsList;
    DatabaseReference studentsRef;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        studentsList=new ArrayList<ModelUser>();
        studentsRef= FirebaseDatabase.getInstance().getReference("Baba");
       // sraech=view.findViewById(R.id.search_name);
        studentsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                studentsList.clear();
                for (DataSnapshot ds:snapshot.getChildren()) {
                    ModelUser tamim=ds.getValue(ModelUser.class);
                    studentsList.add(tamim);

                }
                Adapter adapter=new Adapter(MainActivity2.this,studentsList);

                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity2.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });

    }
}