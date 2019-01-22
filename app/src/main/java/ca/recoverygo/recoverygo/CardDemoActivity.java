package ca.recoverygo.recoverygo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CardDemoActivity extends AppCompatActivity {

    InputStream inputStream;
    String[] data;

    ArrayList<String> mName;
    ArrayList<String> mStreet;
    ArrayList<String> mCity;
    ArrayList<String> mProv;
    ArrayList<String> mPcode;
    ArrayList<String> mPhone1;
    ArrayList<String> mPhone2;
    ArrayList<String> mType;
    ArrayList<String> mAccess;
    ArrayList<String> mCapacity;
    ArrayList<String> mEmail;
    ArrayList<String> mWebsite;
    ArrayList<String> mLogo;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_demo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /* CSV File to Arrays */
        inputStream = getResources().openRawResource(R.raw.states);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        mName       = new ArrayList<>();
        mStreet     = new ArrayList<>();
        mCity       = new ArrayList<>();
        mProv       = new ArrayList<>();
        mPcode      = new ArrayList<>();
        mPhone1     = new ArrayList<>();
        mPhone2     = new ArrayList<>();
        mType       = new ArrayList<>();
        mAccess     = new ArrayList<>();
        mCapacity   = new ArrayList<>();
        mEmail      = new ArrayList<>();
        mWebsite    = new ArrayList<>();
        mLogo       = new ArrayList<>();

        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {

                data=csvLine.split(",");

                try{

                    mName.add(data[1]);
                    mStreet.add(data[2]);
                    mCity.add(data[3]);
                    mProv.add(data[4]);
                    mPcode.add(data[5]);
                    mPhone1.add(data[6]);
                    mPhone2.add(data[7]);
                    mType.add(data[8]);
                    mAccess.add(data[9]);
                    mCapacity.add(data[10]);
                    mEmail.add(data[11]);
                    mWebsite.add(data[12]);
                    mLogo.add(data[13]);

                    Log.i("DATA RECORD IMPORT:","states.csv IMPORTED SUCCESSFULLY");
                }
                catch (Exception e) {
                    Log.e("DATA RECORD IMPORT FAIL",e.toString());
                }
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error reading states.csv file: "+ ex);
        }

        /* CSV File End */
        recyclerView = findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_card_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
