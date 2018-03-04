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

    public void tornIA(){
        //TODO mostrar imatges

        Random r = new Random();

        int aleatori = r.nextInt(7 - 1) + 1;

        arrayIA.add(aleatori);

        System.out.println("array IA: " + arrayIA);
        System.out.println("ultima tirada IA: " +aleatori);

    }

    public void comprovarBoto(int numero){
        if(arrayIA.get(arrayJugador.size()-1) != arrayJugador.get(arrayJugador.size()-1)){
            System.out.println("has perdut");
            //TODO jugador perd, mostrar pantalla de derrota
        }else if (arrayJugador.size() == arrayIA.size()){
            System.out.println("mateixa mida, juga la maquina");
            System.out.println("arrayjugador(abans): " + arrayJugador);
            arrayJugador.clear();
            System.out.println("arrayjugador(despres: " + arrayJugador);
            tornIA();
        }else {
            System.out.println("segueixes tirant...");
        }
        /*for (int i = 0; i < arrayIA.size(); i++){
            arrayIA.get
        }*/

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon);

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

        tornIA();

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
                System.out.println("has premut: 1");
                arrayJugador.add(1);
                comprovarBoto(1);
                System.out.println(arrayJugador);
                break;

            case R.id.button2:
                System.out.println("has premut: 2");
                arrayJugador.add(2);
                comprovarBoto(2);
                break;

            case R.id.button3:
                System.out.println("has premut: 3");
                arrayJugador.add(3);
                comprovarBoto(3);
                break;

            case R.id.button4:
                System.out.println("has premut: 4");
                arrayJugador.add(4);
                comprovarBoto(4);
                break;

            case R.id.button5:
                System.out.println("has premut: 5");
                arrayJugador.add(5);
                comprovarBoto(5);
                break;

            case R.id.button6:
                System.out.println("has premut: 6");
                arrayJugador.add(6);
                comprovarBoto(6);
                break;

            default:
                break;
        }

    }
}
