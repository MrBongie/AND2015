package bongie.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class AchivAdapter extends BaseAdapter {

    private AchivProvider achivProvider;
    private Context context;

    public AchivAdapter(Context context) {
        this.context = context;
        this.achivProvider = new AchivDatabase(context);
    }

    @Override
    public int getCount() {
        return achivProvider.getAchivNumber();
    }

    @Override
    public Achiv getItem(int position) {
        return achivProvider.getAchiv(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View achivView;

        if (convertView == null) {
            achivView = LayoutInflater.from(context).inflate(R.layout.achiv_row, parent, false);
        } else {
            achivView = convertView;
        }

        bindAchivToView(getItem(position), achivView, position);

        return achivView;
    }

    private void bindAchivToView(Achiv achiv, View achivView, int position) {


        TextView AchivName = (TextView) achivView.findViewById(R.id.achiv_name);
        AchivName.setText(achiv.getAchivName());

        TextView AchivPlace = (TextView) achivView.findViewById(R.id.achiv_place);
        AchivPlace.setText(achiv.getAchivPlace());
    }

}
