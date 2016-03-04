package com.game.russianblock;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Administrator on 2016-01-26.
 * @author QiaoJiadong
 */
public class GamePoolSurface extends SurfaceView implements SurfaceHolder.Callback {

    public GamePoolSurface(Context context){
        super(context, null);
    }

    public GamePoolSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    class BlockThread extends Thread {

        public BlockThread() {

        }

        @Override
        public void run() {
            Canvas canvas = getHolder().lockCanvas();
            getHolder().unlockCanvasAndPost(canvas);
        }
    }
}
