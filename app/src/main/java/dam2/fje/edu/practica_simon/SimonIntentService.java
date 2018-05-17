package dam2.fje.edu.practica_simon;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;

public class SimonIntentService extends IntentService {
     MediaPlayer mediaPlayer;
    public static final String TAG = "dam2.fje.edu.practica_simon";

    public SimonIntentService() {
        super("SimonIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String nota = intent.getStringExtra("nota");

        switch (nota) {
            case "do_oct":
                mediaPlayer = MediaPlayer.create(this,R.raw.do_oct);
                mediaPlayer.start();

                break;
            case "re":
                mediaPlayer = MediaPlayer.create(this,R.raw.re);
                mediaPlayer.start();
                break;
            case "mi":
                mediaPlayer = MediaPlayer.create(this,R.raw.mi);
                mediaPlayer.start();
                break;
            case "fa":
                mediaPlayer = MediaPlayer.create(this,R.raw.fa);
                mediaPlayer.start();
                break;
            case "sol":
                mediaPlayer = MediaPlayer.create(this,R.raw.sol);
                mediaPlayer.start();
                break;
            case "la":
                mediaPlayer = MediaPlayer.create(this,R.raw.la);
                mediaPlayer.start();
                break;
            case "do_str":
                mediaPlayer = MediaPlayer.create(this,R.raw.do_str);
                mediaPlayer.start();
                break;
            case "re_str":
                mediaPlayer = MediaPlayer.create(this,R.raw.re_str);
                mediaPlayer.start();
                break;
            case "mi_str":
                mediaPlayer = MediaPlayer.create(this,R.raw.mi_str);
                mediaPlayer.start();
                break;
            case "fa_str":
                mediaPlayer = MediaPlayer.create(this,R.raw.fa_str);
                mediaPlayer.start();
                break;
            case "sol_str":
                mediaPlayer = MediaPlayer.create(this,R.raw.sol_str);
                mediaPlayer.start();
                break;
            case "si_str":
                mediaPlayer = MediaPlayer.create(this,R.raw.do_str);
                mediaPlayer.start();
                break;
             default:
                 mediaPlayer = MediaPlayer.create(this,R.raw.do_oct);
                 mediaPlayer.start();
                 break;

        }

    }
}
