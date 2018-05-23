package com.example.shimul.androidcontrol;

        import android.app.Activity;
        import android.app.AlertDialog;
        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.AsyncTask;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.Toast;
        import java.io.PrintWriter;
        import java.net.Socket;
        import android.util.Log;
        import android.widget.Button;
        import java.net.InetAddress;
        import android.os.AsyncTask;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.OutputStreamWriter;




public class Media extends Activity {

    Context context;
    Button play;
    Button forward;
    Button back;
    Button up;
    Button down;

    private boolean isConnected=false;
    private boolean mouseMoved=false;
    private Socket socket;
    private PrintWriter out;

    public static String data,ipaddres;
    private Socket client;
    private Boolean flag = false;
    private PrintWriter printwriter;
    public  int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        ipaddres ="192.168.173.1";
    }

    public void onclick(View view) {
        switch (view.getId())
        {
            case R.id.forward:
                data="RightArrow";
                break;
            case R.id.back:
                data="LeftArrow";
                break;
            case R.id.up:
                data="UpArrow";
                break;
            case R.id.down:
                data="DownArrow";
                break;
            case R.id.play:
            {
                count++;
                data="space";
                if(count%2==1)
                {
                    ImageButton b = (ImageButton) findViewById(R.id.play);
                    b.setBackgroundResource(R.drawable.play);
                }
                else
                {
                    ImageButton b = (ImageButton) findViewById(R.id.play);
                    b.setBackgroundResource(R.drawable.pause);
                }
                break;
            }

        }

        if (flag == true) {
            Context context = getApplicationContext();

            CharSequence text = "Connection failed or Invalid IpAddress !!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

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


        }
        SendMessage sendMessageTask = new SendMessage();
        sendMessageTask.execute();
    }

    private class SendMessage extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {

                client = new Socket(ipaddres, 4444); // connect to the server
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
}
