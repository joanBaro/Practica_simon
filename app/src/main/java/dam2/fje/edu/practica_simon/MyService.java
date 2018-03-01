package dam2.fje.edu.practica_simon;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.widget.Toast;


public class MyService extends IntentService {

    public MyService() {
        super("My_worker_service");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Toast.makeText(this,"service started...", Toast.LENGTH_LONG).show();
       MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.m02_audio1);
        mediaPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this,"service Stopped...", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        synchronized (this)
        {
            int count = 0;
            while(count<10)
            {
                try {
                    wait(1500);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
