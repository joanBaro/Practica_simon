package dam2.fje.edu.practica_simon;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity{
    boolean bmusic = false;
    protected EditText text;
    MyView mCustomDrawableView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MyView demoview = new MyView(this);
        //setContentView(demoview);



        text = (EditText)findViewById(R.id.entradaNom);

        Button btnJugar = (Button)findViewById(R.id.playButton);
        ImageButton btnMusica = (ImageButton)findViewById(R.id.btnMusic);

        final Intent i = new Intent(this, MyService.class);

        btnMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bmusic){
                    startService(i);
                    bmusic = true;
                    startFadeInAnimation();
                } else{
                    stopService(i);
                    bmusic = false;
                    startFadeInAnimation();
                }

            }
        });
        if (text.getText().toString().matches("[a-zA-Z_ ]{1,8}")) {
            btnJugar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, SimonActivity.class);
                    intent.putExtra("Name", text.getText().toString());
                    startActivity(intent);
                    //stopService(i);
                }
            });
        }else System.out.println("Invalid name");
    }

    public void startFadeInAnimation() {
        ImageButton imageButton = (ImageButton) findViewById(R.id.btnMusic);
        Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_animation);
        imageButton.startAnimation(startAnimation);
    }


    /*public void startService(View view) {

        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
        System.out.println( "servei aturat");
    }*/

}

//todo service->musica inicial joc
//todo intentservice->musica botons.