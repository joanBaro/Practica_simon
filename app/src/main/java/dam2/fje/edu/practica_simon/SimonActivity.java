package dam2.fje.edu.practica_simon;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class SimonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon);

        ImageView img = (ImageView) findViewById(R.id.imageView1);
        img.setVisibility(View.VISIBLE);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.imageView1).setVisibility(View.INVISIBLE);
                findViewById(R.id.imageView2).setVisibility(View.VISIBLE);
                System.out.println("hola");
            }
        }, 2000);
    }
}
