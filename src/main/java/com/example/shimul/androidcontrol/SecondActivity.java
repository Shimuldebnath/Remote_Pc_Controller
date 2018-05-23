package com.example.shimul.androidcontrol;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class SecondActivity extends Activity {

    Button k;
    Button m;
    Button p;
    Button t;
    Button po;
    Button app;
    Button voice;
    Button web;
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle("Menus");

        k = (Button) findViewById(R.id.keyboard);
        m=(Button)findViewById(R.id.media);
        p=(Button)findViewById(R.id.presentation);
        t=(Button)findViewById(R.id.touchpad);
        po=(Button)findViewById(R.id.power);
        app=(Button)findViewById(R.id.application);
        voice=(Button)findViewById(R.id.VoiceRecognition);
        web=(Button)findViewById(R.id.Web);

    }

    public  void key(View view)
    {
        Intent intent = new Intent(this, Keyboard.class);
        startActivity(intent);
    }
    public  void med(View vie)
    {
        Intent intent =new Intent(this,Media.class);
        startActivity(intent);
    }

    public  void pre(View view)
    {
        Intent intent=new Intent(this,Presentation.class);
        startActivity(intent);

    }

    public void tou(View view)
    {
        Intent intent=new Intent(this,Touchpad.class);
        startActivity(intent);
    }

    public void pow(View view)
    {
        Intent intent=new Intent(this,Power.class);
        startActivity(intent);
    }
    public void appli (View view)
    {
        Intent intent=new Intent(this,Application.class);
        startActivity(intent);
    }

    public void websi (View view)
    {
        Intent intent = new Intent(this,Website.class);
        startActivity(intent);
    }
    public void voicer (View view)
    {
        Intent intent=new Intent(this,VoiceRecognition.class);
        startActivity(intent);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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
