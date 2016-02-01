package bongie.task;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;


public class ListAchiv extends ActionBarActivity {

    private ColNum columnNumberPreferences;

    private GridView grid;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        columnNumberPreferences = new ColNum(this);

        initializeGrid();
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter.notifyDataSetChanged();
    }

    private void initializeGrid() {

        grid = (GridView) findViewById(R.id.achiv_grid);
        adapter = new AchivAdapter(this);
        grid.setNumColumns(columnNumberPreferences.getSelectedNumberOfColumns());
        grid.setAdapter(adapter);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.exit) {
            finish();
            System.exit(0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setNumberOfGridColumns(int numberOfColumns) {
        grid.setNumColumns(numberOfColumns);
        columnNumberPreferences.saveSelectedNumberOfColumns(numberOfColumns);
    }
    private AchivAdapter adapter;
}


