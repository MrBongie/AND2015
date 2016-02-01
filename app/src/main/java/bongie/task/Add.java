package bongie.task;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        creatAchiv();
    }
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0) {
            return false;
        } else {
            return true;
        }
    }

    private void creatAchiv() {
        final EditText n = (EditText) findViewById(R.id.name);
        final EditText p = (EditText) findViewById(R.id.place);

        Button save = (Button) findViewById(R.id.saveButt);

        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if ((isEmpty(n) == false) || (isEmpty(p) == false)) {
                    String nameAchiv = n.getText().toString();
                    String placeAchiv = p.getText().toString();
                    saveAchiv(new Achiv(nameAchiv, placeAchiv));
                } else {
                    Toast.makeText(getApplicationContext(), "Fill missing information", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    private void saveAchiv (Achiv achiv){
        AchivDatabase achivDB = new AchivDatabase(this);
        achivDB.addAchiv(achiv);

        Toast.makeText(this, "" + achiv.getAchivName() + " saved", Toast.LENGTH_SHORT).show();

        finish();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
