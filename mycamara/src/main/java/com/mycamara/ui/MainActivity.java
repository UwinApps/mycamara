package com.mycamara.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.mycamara.R;
import com.mycamara.ui.com.mycamara.view.CameraSurfaceView;


public class MainActivity extends Activity implements View.OnClickListener {

    private CameraSurfaceView mCameraSurfaceView;
    private ImageButton takePicBtn;
    private ImageButton btn_cancel;
    private ImageButton btn_ok;
    private RelativeLayout topBtton;
    public static Bitmap frame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mCameraSurfaceView = (CameraSurfaceView) findViewById(R.id.cameraSurfaceView);

        topBtton = (RelativeLayout) findViewById(R.id.topBtton);
        btn_cancel = (ImageButton) findViewById(R.id.btn_cancel);
        btn_ok = (ImageButton) findViewById(R.id.btn_ok);
        topBtton.setVisibility(View.GONE);


        takePicBtn = (ImageButton) findViewById(R.id.takePic);
        takePicBtn.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
        btn_ok.setOnClickListener(this);

        frame = BitmapFactory.decodeResource(getResources(), R.drawable.frame);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.takePic:
                takePic();

                break;
            case R.id.btn_cancel:
                mCameraSurfaceView.reShow();
                takePicBtn.setVisibility(View.VISIBLE);
                topBtton.setVisibility(View.INVISIBLE);

                break;
            case R.id.btn_ok:
                mCameraSurfaceView.reShow();
                takePicBtn.setVisibility(View.VISIBLE);
                topBtton.setVisibility(View.INVISIBLE);


                break;
            default:
                break;
        }
    }

    private void takePic() {

        takePicBtn.setVisibility(View.INVISIBLE);

        mCameraSurfaceView.takePicture();
        topBtton.setVisibility(View.VISIBLE);

    }


}
