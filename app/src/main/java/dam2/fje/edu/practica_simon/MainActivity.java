package dam2.fje.edu.practica_simon;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ImageButton btnMusica = (ImageButton)findViewById(R.id.btnMusic);
       Button btnJugar = (Button)findViewById(R.id.playButton);

       final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.m02_audio1);
       btnMusica.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (mediaPlayer.isPlaying()) {
                   mediaPlayer.pause();
               }else{
                   mediaPlayer.start();
               }
           }
       });

       btnJugar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(MainActivity.this, SimonActivity.class));           }
       });
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
