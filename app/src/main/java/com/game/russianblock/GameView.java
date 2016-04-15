package com.game.russianblock;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
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
public class GameView extends Activity implements View.OnTouchListener {

    private ShapeButton mLeftBtn, mRightBtn, mDownBtn, mRotateBtn;
    private TextView mScore;
    private SurfaceView mSurfaceView;
    private SurfaceHolder mSurfaceHolder;
    private GameHandler mHandler = null;

    private int mBlockWidth;
    private int mGamePoolWidth;
    private int mDegree = 0;
    private int mGameOneStep;

    private boolean gameStarted = false;

    public static Blocks mIndicator;
    public static Blocks mGameBlock;
    public static int mRandomInt = 0;
    private static final int TIMER_TICK = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main_layout);

        //init buttons and view.
        mLeftBtn = (ShapeButton)findViewById(R.id.left_button);
        mDownBtn = (ShapeButton)findViewById(R.id.down_button);
        mRightBtn = (ShapeButton)findViewById(R.id.right_button);
        mRotateBtn = (ShapeButton)findViewById(R.id.rotate_button);

        mScore = (TextView)findViewById(R.id.score);
        mSurfaceView = (SurfaceView)findViewById(R.id.game_pool);
        mIndicator = (Blocks)findViewById(R.id.indicator);
        mGameBlock = (Blocks)findViewById(R.id.game_blocks);

        mLeftBtn.setOnTouchListener(this);
        mDownBtn.setOnTouchListener(this);
        mRightBtn.setOnTouchListener(this);
        mRotateBtn.setOnTouchListener(this);
        mSurfaceView.setOnTouchListener(this);
        mIndicator.setOnTouchListener(this);

        //init game parameters
        mGamePoolWidth = getResources().getDimensionPixelOffset(R.dimen.game_pool_width);
        mGameOneStep = getResources().getDimensionPixelOffset(R.dimen.a_block_width);

        mSurfaceHolder = mSurfaceView.getHolder();

        mScore = (TextView)findViewById(R.id.score);

        mHandler = new GameHandler(this);
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
    public boolean onTouch(View v, MotionEvent event) {
        switch(v.getId()) {
            case R.id.game_pool:
            case R.id.indicator:
                //if(! gameStarted) {
                    //startGame();
                //}
                //getRandomInt();
                //mHandler.sendEmptyMessage(0);
                Toast.makeText(getApplicationContext(), "indicator", Toast.LENGTH_LONG).show();
                break;
            case R.id.left_button:
                break;
            case R.id.right_button:
                break;
            case R.id.down_button:
                break;
            case R.id.rotate_button:
                Toast.makeText(getApplicationContext(), "onRotate()", Toast.LENGTH_LONG).show();
                mHandler.sendEmptyMessage(GameConstants.MSG_ROTATE);
                break;
            default:
                break;
        }
        return false;
    }

    public void startGame() {
        Timer timer = new Timer();
        GameTimeTask gameTimerTask = new GameTimeTask();
        timer.schedule(gameTimerTask, 0 , 3000);
        gameStarted = true;
    }

    public int getRandomInt() {
        int arr[] = {0, 1, 2, 3, 3, 4, 5, 6, 6, 6};
        Random rand = new Random();
        return arr[rand.nextInt(9)];
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
            //getRandomInt();
            //GameHandler.mHandler.sendEmptyMessage(0);
        }
    }
}