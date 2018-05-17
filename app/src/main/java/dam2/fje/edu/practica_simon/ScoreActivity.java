package dam2.fje.edu.practica_simon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {

    private DatabaseReference dbPuntuacio = FirebaseDatabase.getInstance().getReference("Puntuacio");

    public HashMap<String, String> entradaPuntuacions;
    public List<String> arrayPuntuacio = new ArrayList<String>();
    public List<String> arrayNom = new ArrayList<String>();

    protected String Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        int scoreInt = getIntent().getIntExtra("Score",0);
        Score = String.valueOf(scoreInt);

        updateFirebase();

    }

    protected void updateFirebase(){
        DatabaseReference entrada = dbPuntuacio.child(getIntent().getStringExtra("Name")); //nom usuari
        entrada.setValue(Score); //puntuacio
        //TODO acualitzar firebase
    }

    protected void updateLlista(){
        ListView lv1 = (ListView) findViewById(R.id.ListView1);
        ListView lv2 = (ListView) findViewById(R.id.ListView2);

        /*List<String> arrayPuntuacio = new ArrayList<String>();
        List<String> arrayNom = new ArrayList<String>();
        arrayPuntuacio.add("foo");
        arrayNom.add("bar");*/
        System.out.println("entrada a update llista");

        if (arrayPuntuacio.size() != 0) {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, arrayPuntuacio);
            lv2.setAdapter(arrayAdapter);
            System.out.println("entrada a array puntuacio");
        }

        if (arrayNom.size() != 0) {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, arrayNom);
            lv1.setAdapter(arrayAdapter);
        }


    }

    @Override
    protected void onStart() {
        super.onStart();

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                entradaPuntuacions = new HashMap<>();

                for(DataSnapshot input : dataSnapshot.getChildren()){
                    entradaPuntuacions.put(input.getKey(), input.getValue(String.class));
                    arrayNom.add(input.getKey());
                    arrayPuntuacio.add(input.getValue(String.class));
                }

                for (String name: entradaPuntuacions.keySet()){

                    /*String key = name;
                    String value = entradaPuntuacions.get(name);*/
                    System.out.println(arrayNom + " " + arrayPuntuacio);
                }
                updateLlista();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        };
        dbPuntuacio.addValueEventListener(postListener);

    }



}
