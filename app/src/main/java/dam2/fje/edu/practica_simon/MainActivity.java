package dam2.fje.edu.practica_simon;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /* Button btn = (Button)findViewById(R.id.btn_f1);
        Button btn2 = (Button)findViewById(R.id.btn_f2);*/

        //MediaPlayer.create(this, R.raw.m02_audio1);
    }

    public void startService(View view) {

        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
        System.out.println( "servei aturat");
    }
    /*public void selectFrag(View view) {

        FragmentOne fragmentOne = new FragmentOne();
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, fragmentOne);
        //transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack(null);
        transaction.commit();


    }*/
}
