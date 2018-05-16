package dam2.fje.edu.practica_simon;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.view.View;

public class MyService extends Service {

     MediaPlayer mediaPlayer;

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         super.onStartCommand(intent, flags, startId);
        mediaPlayer = MediaPlayer.create(this, R.raw.m02_audio1);
         Runnable r = new Runnable() {
             @Override
             public void run() {


                 if (mediaPlayer.isPlaying()) {
                     mediaPlayer.pause();
                 }else {
                     mediaPlayer.start();
                 }
             }
         };

         Thread fil  = new Thread(r);
         fil.start();
        return START_NOT_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
