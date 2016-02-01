package bongie.task;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;


public class Location extends Activity {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activ);
        mMapFragment = MapFragment.newInstance();
        FragmentTransaction fragmentTransaction =
                getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.my_container, mMapFragment);
        fragmentTransaction.commit();
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
    }
}