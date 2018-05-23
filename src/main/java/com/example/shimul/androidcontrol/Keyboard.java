package com.example.shimul.androidcontrol;

import android.app.Activity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.PrintWriter;
import java.net.Socket;
/**
 * Created by Shimul on 12/31/2016.
 */

public class Keyboard extends AppCompatActivity {

    String value, data, str1;
    private Socket client;
    private  Toolbar toolbar;
    private Boolean flag = false;
    private PrintWriter printwriter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);
        str1 = "192.168.173.1";
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
    }
    public  void click(MenuItem item)
    {
        Intent intent=new Intent(Keyboard.this,KeyboardReading.class);
        startActivity(intent);
    }

    public void ext(View view)
    {
        switch (view.getId())
        {
            case R.id.one:
                data="One";
                break;

            case R.id.two:
                data="Two";
                break;

            case R.id.three:
                data="Three";
                break;

            case R.id.four:
                data="Four";
                break;

            case R.id.five:
                data="Five";
                break;

            case R.id.six:
                data="Six";
                break;

            case R.id.seven:
                data="Seven";
                break;

            case R.id.eight:
                data="Eight";
                break;

            case R.id.nine:
                data="Nine";
                break;

            case R.id.zero:
                data="Zero";
                break;

            case R.id.QButton:
                data="Q";
                break;

            case R.id.WButton:
                data="W";
                break;
            case R.id.EButton:
                data="E";
                break;

            case R.id.RButton:
                data="R";
                break;

            case R.id.TButton:
                data="T";
                break;

            case R.id.YButton:
                data="Y";
                break;

            case R.id.UButton:
                data="U";
                break;

            case R.id.IButton:
                data="I";
                break;

            case R.id.OButton:
                data="O";
                break;

            case R.id.PButton:
                data="P";
                break;

            case R.id.AButton:
                data="A";
                break;

            case R.id.SButton:
                data="S";
                break;

            case R.id.DButton:
                data="D";
                break;

            case R.id.FButton:
                data="F";
                break;

            case R.id.GButton:
                data="G";
                break;

            case R.id.HButton:
                data="H";
                break;

            case R.id.JButton:
                data="J";
                break;

            case R.id.KButton:
                data="K";
                break;

            case R.id.LButton:
                data="L";
                break;

            case R.id.ZButton:
                data="Z";
                break;

            case R.id.XButton:
                data="X";
                break;

            case R.id.CButton:
                data="C";
                break;

            case R.id.VButton:
                data="V";
                break;

            case R.id.BButton:
                data="B";
                break;

            case R.id.NButton:
                data="N";
                break;

            case R.id.MButton:
                data="M";
                break;

            case R.id.BacksapceButton:
                data="backspace";
                break;

            case R.id.obakteButton:
                data="obak";
                break;
            case R.id.onButton:
                data="onbut";
                break;

            case R.id.LeftbracketButton:
                data="leftbracket";
                break;

            case R.id.RightbracketButton:
                data="rightbracket";
                break;

            case R.id.duifotaButton:
                data="duifota";
                break;
            case R.id.ctrlVButton:
                data="Ctrl+V";
                break;



            case R.id.CntrZButton:
                data="Ctrl+Z";
                break;

            case R.id.DeleteButton:
                data="Delete";
                break;

            case R.id.ShiftDeleteButton:
                data="Shift+Delete";
                break;

            case R.id.CtrlSButton:
                data="Ctrl+S";
                break;

            case R.id.CtrlsButton:
                data="Ctrl+A";
                break;


            case R.id.CtrlXButton:
                data="Ctrl+X";
                break;

            case R.id.CtrlCButton:
                data="Ctrl+C";
                break;

            case R.id.comaButton:
                data="coma";
                break;
            case R.id.QuestionButton:
                data="Question";
                break;

            case R.id.tabButton:
                data="Tab";
                break;

            case R.id.enterButton:
                data="Enter";
                break;

            case R.id.CapsLockButton:
                data="CapsLock";
                break;

            case R.id.shiftButton:
                data="Shift";
                break;

            case R.id.CtrlButton:
                data="Ctrl";
                break;

            case R.id.AltButton:
                data="Alt";
                break;
            case R.id.SpaceButton:
                data="space";
                break;
            case R.id.altf4:
                data="AltF4";
                break;

            case R.id.escButton:
                data="escape";
                break;

            case R.id.LeftButton:
                data="LeftArrow";
                break;

            case R.id.RightButton:
                data="RightArrow";
                break;

            case R.id.UpButton:
                data="UpArrow";
                break;

            case R.id.DownButton:
                data="DownArrow";
                break;

            case R.id.HashButton:
                data="Hash";
                break;

            case R.id.DollarButton:
                data="Dollar";
                break;

            case R.id.PercentageButton:
                data="Percentage";
                break;

            case R.id.AttherateButton:
                data="Attherate";
                break;
            case R.id.AstericsButton:
                data="Asterics";
                break;

            case R.id.PlusButton:
                data="Plus";
                break;

            case R.id.MinusButton:
                data="Minus";
                break;
            case R.id.EqualButton:
                data="Equal";
                break;
            case R.id.SlashButton:
                data="Slash";
                break;
            case R.id.SemicolonnButton:
                data="Semicolon";
                break;




        }

        if (flag == true) {
            Context context = getApplicationContext();

            CharSequence text = "Connection failed or Invalid IpAddress !!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            //   Toast.makeText("Connection failed or Invalid IpAddress !!", Toast.LENGTH_LONG).show();
            // msg.setText("Could not Connected or Invalid IpAddress !!");
            flag = false;

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);

            builder.setMessage("Connection failed or Invalid IpAddress !!")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    });


            AlertDialog alert = builder.create();
            alert.setTitle("AlertDialog");
            alert.show();
            // setContentView(R.layout.activity_client);

        }

        SendMessage sendMessageTask = new SendMessage();
        sendMessageTask.execute();

    }

    private class SendMessage extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                //String str = new String("116.202.91.218");
                client = new Socket(str1, 4444); // connect to the server
                printwriter = new PrintWriter(client.getOutputStream(), true);
                printwriter.write(data); // write the message to output stream
                printwriter.flush();
                printwriter.close();
                client.close(); // closing the connection

            } catch (Exception e) {
                flag = true;
            }
            return null;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
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
