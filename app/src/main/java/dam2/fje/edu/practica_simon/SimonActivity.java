package dam2.fje.edu.practica_simon;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SimonActivity extends AppCompatActivity implements View.OnClickListener {

    List<Integer> arrayJugador = new ArrayList<Integer>();
    List<Integer> arrayIA = new ArrayList<Integer>();


    public void tornIA(){
        //TODO mostrar imatges

        Random r = new Random();
        int aleatori = r.nextInt(13 - 1) + 1; // del 1 (inclos) al 13 (no inclos)

        arrayIA.add(aleatori);

        final ImageView img = (ImageView) findViewById(R.id.imageView1);
        img.setImageResource(R.mipmap.blanc);
        findViewById(R.id.imageView1).setVisibility(View.VISIBLE);

        final int []imageArray={R.mipmap.img1,R.mipmap.img2,R.mipmap.img3};

        final boolean[] sortida = {false};


        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {
                String pos = String.valueOf(arrayIA.get(i));
                int id = getResources().getIdentifier("img" + pos,"mipmap", getPackageName());
                System.out.println("entrada: " + i);
                img.setImageResource(id);
                i++;
                if (i > arrayIA.size() - 1) {
                    return;
                }
                handler.postDelayed(this, 800);
            }
        };
       handler.postDelayed(runnable, 1000);

       if(sortida[0]){
           handler.removeCallbacks(runnable);
       }


        System.out.println("array IA: " + arrayIA);
        System.out.println("ultima tirada IA: " + aleatori);

    }

    public void comprovarBoto(int numero){
        findViewById(R.id.imageView1).setVisibility(View.INVISIBLE);
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

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon);

        ImageButton btn1 =  (ImageButton) findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        ImageButton btn2 = (ImageButton) findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        ImageButton btn3 = (ImageButton) findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        ImageButton btn4 = (ImageButton) findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        ImageButton btn5 = (ImageButton) findViewById(R.id.button5);
        btn5.setOnClickListener(this);
        ImageButton btn6 = (ImageButton) findViewById(R.id.button6);
        btn6.setOnClickListener(this);
        ImageButton btn7 = (ImageButton) findViewById(R.id.button7);
        btn7.setOnClickListener(this);
        ImageButton btn8 = (ImageButton) findViewById(R.id.button8);
        btn8.setOnClickListener(this);
        ImageButton btn9 = (ImageButton) findViewById(R.id.button9);
        btn9.setOnClickListener(this);
        ImageButton btn10 = (ImageButton) findViewById(R.id.button10);
        btn10.setOnClickListener(this);
        ImageButton btn11 = (ImageButton) findViewById(R.id.button11);
        btn11.setOnClickListener(this);
        ImageButton btn12 = (ImageButton) findViewById(R.id.button12);
        btn12.setOnClickListener(this);

        tornIA();


    }

    @Override
    public void onClick(View v){
        final MediaPlayer mediaPlayer;
        switch (v.getId()) {

            case R.id.button1:
                System.out.println("has premut: 1");
                arrayJugador.add(1);
                comprovarBoto(1);
                mediaPlayer = MediaPlayer.create(this,R.raw.do_oct);
                mediaPlayer.start();
                System.out.println(arrayJugador);
                break;

            case R.id.button2:
                System.out.println("has premut: 2");

                arrayJugador.add(2);
                comprovarBoto(2);
                mediaPlayer = MediaPlayer.create(this,R.raw.re);
                mediaPlayer.start();
                break;

            case R.id.button3:
                System.out.println("has premut: 3");
                arrayJugador.add(3);
                comprovarBoto(3);
                mediaPlayer = MediaPlayer.create(this,R.raw.mi);
                mediaPlayer.start();
                break;

            case R.id.button4:
                System.out.println("has premut: 4");
                arrayJugador.add(4);
                comprovarBoto(4);
                mediaPlayer = MediaPlayer.create(this,R.raw.fa);
                mediaPlayer.start();
                break;

            case R.id.button5:
                System.out.println("has premut: 5");
                arrayJugador.add(5);
                comprovarBoto(5);
                mediaPlayer = MediaPlayer.create(this,R.raw.sol);
                mediaPlayer.start();
                break;

            case R.id.button6:
                System.out.println("has premut: 6");
                arrayJugador.add(6);
                comprovarBoto(6);
                mediaPlayer = MediaPlayer.create(this,R.raw.la);
                mediaPlayer.start();
                break;

            case R.id.button7:
                System.out.println("has premut: 7");
                arrayJugador.add(7);
                comprovarBoto(7);
                mediaPlayer = MediaPlayer.create(this,R.raw.do_str);
                mediaPlayer.start();
                break;

            case R.id.button8:
                System.out.println("has premut: 8");
                arrayJugador.add(8);
                comprovarBoto(8);
                mediaPlayer = MediaPlayer.create(this,R.raw.re_str);
                mediaPlayer.start();
                break;

            case R.id.button9:
                System.out.println("has premut: 9");
                arrayJugador.add(9);
                comprovarBoto(9);
                mediaPlayer = MediaPlayer.create(this,R.raw.mi_str);
                mediaPlayer.start();
                break;

            case R.id.button10:
                System.out.println("has premut: 10");
                arrayJugador.add(10);
                comprovarBoto(10);
                mediaPlayer = MediaPlayer.create(this,R.raw.fa_str);
                mediaPlayer.start();
                break;

            case R.id.button11:
                System.out.println("has premut: 11");
                arrayJugador.add(11);
                comprovarBoto(11);
                mediaPlayer = MediaPlayer.create(this,R.raw.sol_str);
                mediaPlayer.start();
                break;

            case R.id.button12:
                System.out.println("has premut: 12");
                arrayJugador.add(12);
                comprovarBoto(12);
                mediaPlayer = MediaPlayer.create(this,R.raw.si_str);
                mediaPlayer.start();
                break;

            default:
                break;
        }

    }
}
