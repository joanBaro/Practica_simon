package dam2.fje.edu.practica_simon;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimonActivity extends AppCompatActivity implements View.OnClickListener {

    List<Integer> arrayJugador = new ArrayList<Integer>();
    List<Integer> arrayIA = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon);
        Random r = new Random();


        int aleatori = r.nextInt(7 - 1) + 1; // del 1 (inclos) al 7(no inclos)

        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        Button btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        Button btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(this);
        Button btn6 = (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(this);

        boolean sortida = false;
        do{
            arrayIA.add(r.nextInt(7 - 1) + 1);
            for (int i = 0; i < arrayIA.size(); i++ ){

            }


        }while(!sortida);


        /*
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
        */
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {

            case R.id.button1:
                System.out.println("1");
                arrayJugador.add(1);
                System.out.println(arrayJugador);
                break;

            case R.id.button2:
                System.out.println("2");
                arrayJugador.add(2);
                break;

            case R.id.button3:
                System.out.println("3");
                arrayJugador.add(3);
                break;

            case R.id.button4:
                System.out.println("4");
                arrayJugador.add(4);
                break;

            case R.id.button5:
                System.out.println("5");
                arrayJugador.add(5);
                break;

            case R.id.button6:
                System.out.println("6");
                arrayJugador.add(6);
                break;

            default:
                break;
        }

    }
}
