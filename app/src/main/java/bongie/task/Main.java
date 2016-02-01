package bongie.task;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Main extends ActionBarActivity {

    private AlertDialog.Builder dialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ActionBar actionBar = getActionBar();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.info) {
            Dialog();
            return true;
        }
        if (id == R.id.exit) {
            finish();
            System.exit(0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Dialog() {
        dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Information");
        dialogBuilder.setMessage("Project made by Bartosz Kania");
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Closed Info", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog InfoDialog = dialogBuilder.create();
        InfoDialog.show();
    }

    public void listAchiv(View v) {
        startActivity(new Intent(this, ListAchiv.class));
    }

    public void addAchiv(View v) {
        startActivity(new Intent(this, Add.class));
    }

    public void locatAchiv(View v) {
        startActivity(new Intent(this, Location.class));
    }
}
