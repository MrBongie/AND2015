package bongie.task;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

public class AchivDatabase implements AchivProvider {

    static final public String TABLE_NAME = "Achivs";
    private AchivDbHelper DbHelper;

    public AchivDatabase(Context context) {
        this.DbHelper = new AchivDbHelper(context);
    }

    public void addAchiv(Achiv achiv) {
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", achiv.getAchivName());
        values.put("place", achiv.getAchivPlace());


        db.insert(TABLE_NAME, null, values);
    }

    public Achiv getAchiv(int position) {
        SQLiteDatabase db = DbHelper.getReadableDatabase();

        String[] projection = {
                "name", "place"
        };

        Cursor cursor = db.query(
                TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        cursor.moveToPosition(position);

        String name = cursor.getString(0);
        String place = cursor.getString(1);

        return new Achiv(name, place);
    }

    public int getAchivNumber() {
        SQLiteDatabase db =  DbHelper.getReadableDatabase();

        return (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME, null, null);
    }
}
