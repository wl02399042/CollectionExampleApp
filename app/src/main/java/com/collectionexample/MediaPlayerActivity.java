package com.collectionexample;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.collectionexample.layout.MPLayout;

public class MediaPlayerActivity extends Activity implements View.OnClickListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener{
    private MPLayout MPL;
    private MediaPlayer MP;
    private boolean isPaused = false;
    public SurfaceHolder surfaceHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(MPL = new MPLayout(this));
        init();
    }
    private void init() {
        setsurfaceHolder();
        setMP();
        setOnClick();

    }
    private void setsurfaceHolder(){
        surfaceHolder = MPL.surfaceView.getHolder();
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
                Log.d("video", "surfaceChanged");
            }

            @Override
            public void surfaceCreated(SurfaceHolder arg0) {
                Log.e("video", "surfaceCreated");
                MP.setDisplay(surfaceHolder);
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder arg0) {
                Log.e("video", "surfaceDestroyed");
                if (MP != null) MP.release();
            }
        });
    }
    private void setMP() {
        MP = MediaPlayer.create(this, R.raw.movietest);
        MP.setOnCompletionListener(this);
        MP.setOnErrorListener(this);
    }

    private void setOnClick() {
        MPL.pasueBtn.setOnClickListener(this);
        MPL.startBtn.setOnClickListener(this);
        MPL.restartBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == MPL.pasueBtn) {
            try {
                if (MP != null) {
                    if (isPaused == false) {
                        MP.pause();
                        isPaused = true;
                        Toast.makeText(this, "暫停", Toast.LENGTH_SHORT).show();
                    } else if (isPaused == true) {
                        MP.start();
                        isPaused = false;
                        Toast.makeText(this, "開始播放", Toast.LENGTH_SHORT).show();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (v == MPL.startBtn) {
            try {
                if (MP != null) {
                    MP.stop();
                }
                MP.prepare();
                MP.start();
                Toast.makeText(this, "開始", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(v==MPL.restartBtn){
            try { if (MP != null) {
                MP.seekTo(0);
                MP.pause();

            }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        try {
              /*解除资源与MediaPlayer的赋值关系
               * 让资源可以为其它程序利用*/
//            mediaPlayer.release();
//            mediaPlayer.prepareAsync();
              /*改变TextView为播放结束*/
            Toast.makeText(this, "播放結束", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
        }

    }

    public boolean onError(MediaPlayer mediaPlayer, int arg1, int arg2) {
        // TODO Auto-generated method stub
        try {
              /*发生错误时也解除资源与MediaPlayer的赋值*/
            mediaPlayer.release();
            Toast.makeText(this, "錯誤", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
        }
        return false;
    }

}
