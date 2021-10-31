package com.example.tuan5firebaserecyclerview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvItems;

    // Write a message to the database
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference mData = database.getReference();
    private  RecyclerDataAdapter recyclerDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        create firebase
//        mData.child("Person").push().setValue(new Person("Hai Phong",true));
//        mData.child("Person").push().setValue(new Person("Tuan Khoi",true));
//        mData.child("Person").push().setValue(new Person("Tuan Tu",true));
//        mData.child("Person").push().setValue(new Person("Khoi Ngo",true));
//        mData.child("Person").push().setValue(new Person("thanh danh",true));
//        mData.child("Person").push().setValue(new Person("Kim Uyeen",false));
//        mData.child("Person").push().setValue(new Person("Nhu Phuong",false));
//        mData.child("Person").push().setValue(new Person("Thu Thuy",false));
//        mData.child("Person").push().setValue(new Person("Anh Thu",false));

//        tao list de luu
        List<Person> peopleList = new ArrayList<Person>();

//        get data from firebase
        mData.child("Person").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Person ps = snapshot.getValue(Person.class);
//                SinhVien sinhVien1 = snapshot.getValue(SinhVien.class);

                peopleList.add(ps);
                recyclerDataAdapter.notifyDataSetChanged();

//                Toast.makeText(MainActivity.this, snapshot.getValue().toString(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, ps.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//        people.add(new Person("long",true));
//        people.add(new Person("Phong",true));
//        people.add(new Person("nhung",false));
//        people.add(new Person("Hoa",false));
        recyclerDataAdapter = new RecyclerDataAdapter(peopleList, this);

        rvItems = findViewById(R.id.rv_items);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rvItems.setLayoutManager(linearLayoutManager);
        rvItems.setHasFixedSize(true);
        rvItems.setAdapter(recyclerDataAdapter);

    }
}