package eazy.secondapplication;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final Uri Content_uri=Uri.parse("content://eazy.firstapplication.MyData/dummy");
    ContentResolver cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cnt=getContentResolver();
        Cursor c=cnt.query(Content_uri,new String[]{"name"},null,null,null);

        if (c.getCount()>0){
            if (c.moveToFirst()){
                do {

                    String name=c.getString(c.getColumnIndex("name"));
                    Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
                }while (c.moveToNext());
            }
        }



       /* Bundle data = getIntent().getExtras();
        if(data!=null){
            String myString = data.getString("Id");
            Toast.makeText(this, myString, Toast.LENGTH_SHORT).show();

        }*/
    }
}
