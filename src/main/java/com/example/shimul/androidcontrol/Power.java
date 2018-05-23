package com.example.shimul.androidcontrol;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import java.io.PrintWriter;
import java.net.Socket;


public class Power extends Activity {



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
        setContentView(R.layout.activity_power);
        ipaddres ="192.168.173.1";
    }

    public void func(View view) {
        switch (view.getId())
        {
            case R.id.shutdownButton:
                data="Shut";
                break;
            case R.id.restartButton:
                data = "Restart";
                break;
            case R.id.sleepButton:
                data ="Sleep";
                break;
            case R.id.lockButton:
                data = "lock";
                break;

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
