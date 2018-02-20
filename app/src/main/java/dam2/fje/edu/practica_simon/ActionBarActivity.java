package dam2.fje.edu.practica_simon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ActionBarActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ajuda:
                obrirAjuda();
                return true;
            case R.id.sortir:
                obrirSortida();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void obrirAjuda() {
        startActivity(new Intent(ActionBarActivity.this, WebviewActivity.class));
    }

    private void obrirSortida() {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);

    }

}
