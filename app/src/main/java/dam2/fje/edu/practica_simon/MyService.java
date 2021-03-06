package dam2.fje.edu.practica_simon;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
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

    PhoneStateListener phoneStateListener = new PhoneStateListener() {
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            if (state == TelephonyManager.CALL_STATE_RINGING) {
                mediaPlayer.stop();
            } else if(state == TelephonyManager.CALL_STATE_IDLE) {
                mediaPlayer.start();

            } else if(state == TelephonyManager.CALL_STATE_OFFHOOK) {
                mediaPlayer.stop();
                TelephonyManager mgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
                if(mgr != null) {
                    mgr.listen(phoneStateListener, PhoneStateListener.LISTEN_NONE);
                }
            }
            super.onCallStateChanged(state, incomingNumber);
        }

    };


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
