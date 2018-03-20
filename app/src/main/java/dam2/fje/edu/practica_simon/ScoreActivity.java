package dam2.fje.edu.practica_simon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        lv = (ListView) findViewById(R.id.ListView1);

        List<String> arrayPuntuacio = new ArrayList<String>();
        arrayPuntuacio.add("foo");
        arrayPuntuacio.add("bar");

        if(arrayPuntuacio.size() != 0) {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, arrayPuntuacio );

            lv.setAdapter(arrayAdapter);
        }

    }
}
