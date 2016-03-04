package com.game.russianblock;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016-01-26.
 * @author QiaoJiadong
 * add a comment test.
 */
public class GameView extends Activity implements View.OnClickListener {

    private ShapeButton mLeftBtn, mRightBtn, mDownBtn, mRotateBtn;
    private TextView mScore;
    private SurfaceView mSurfaceView;
    private SurfaceHolder mSurfaceHolder;
    private Blocks mIndicator;
    private int mBlockWidth;
    private int mGamePoolWidth;
    private int mDegree = 0;
    private int mRandomInt = 0;
    private boolean gameStarted = false;
    private static final int TIMER_TICK = 0;

    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    mIndicator.setRandomInt(mRandomInt);
                    int rand = new Random().nextInt(7);
                    mIndicator.rotateClockwise(rand);
                    Toast.makeText(getApplicationContext(), "rotate: " + rand + " shape: " + mRandomInt, Toast.LENGTH_SHORT).show();
                    mIndicator.invalidate();
                    mIndicator.requestLayout();
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main_layout);

        mLeftBtn = (ShapeButton)findViewById(R.id.left_button);
        mDownBtn = (ShapeButton)findViewById(R.id.down_button);
        mRightBtn = (ShapeButton)findViewById(R.id.right_button);
        mRotateBtn = (ShapeButton)findViewById(R.id.rotate_button);

        mScore = (TextView)findViewById(R.id.score);
        mSurfaceView = (SurfaceView)findViewById(R.id.game_pool);
        mIndicator = (Blocks)findViewById(R.id.indicator);

        mLeftBtn.setOnClickListener(this);
        mDownBtn.setOnClickListener(this);
        mRightBtn.setOnClickListener(this);
        mRotateBtn.setOnClickListener(this);
        mSurfaceView.setOnClickListener(this);
        mIndicator.setOnClickListener(this);

        mGamePoolWidth = getResources().getDimensionPixelOffset(R.dimen.game_pool_width);
        mBlockWidth = getResources().getDimensionPixelOffset(R.dimen.a_block_width);


        mSurfaceHolder = mSurfaceView.getHolder();

        mScore = (TextView)findViewById(R.id.score);

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.game_pool:
            case R.id.indicator:
                if(! gameStarted) {
                    //startGame();
                }
                getRandomInt();
                mHandler.sendEmptyMessage(0);
                break;
            case R.id.left_button:
                break;
            case R.id.right_button:
                break;
            case R.id.down_button:
                break;
            case R.id.rotate_button:
                break;
        }
    }

    public void startGame() {
        Timer timer = new Timer();
        GameTimeTask gameTimerTask = new GameTimeTask();
        timer.schedule(gameTimerTask, 0 , 3000);
        gameStarted = true;
    }

    public void getRandomInt() {
        int arr[] = {0, 1, 2, 3, 3, 4, 5, 6, 6, 6};
        Random rand = new Random();
        mRandomInt = arr[rand.nextInt(9)];
    }

    public void BlocksArrived(View v) {
        Canvas canvas = mSurfaceHolder.lockCanvas();
        Paint paint = new Paint();
        //paint.setColor(v.getColor());
        canvas.drawRect(0, 0, 0, 0, paint);
        mSurfaceHolder.unlockCanvasAndPost(canvas);
    }

    class GameTimeTask extends TimerTask {
        @Override
        public void run() {
            getRandomInt();
            mHandler.sendEmptyMessage(0);
        }
    }
}