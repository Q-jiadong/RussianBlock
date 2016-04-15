package com.game.russianblock;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by lenovo on 2016/4/11.
 * @author Qiaojiadong.
 */
public class GameHandler extends Handler {

    private Context mContext;
    private int rand = 0;

    public GameHandler(Context context) {
        mContext = context;
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                //GameView.mIndicator.setRandomInt(GameView.mRandomInt);
                //rand = new Random().nextInt(7);
                //GameView.mIndicator.rotateClockwise(rand);
                //GameView.mIndicator.invalidate();
                //GameView.mIndicator.requestLayout();
                break;
            case 1:
                break;
            case GameConstants.MSG_ROTATE:
                Toast.makeText(mContext, "handle rotate", Toast.LENGTH_LONG).show();
                GameView.mGameBlock.rotateClockwise(1);
                GameView.mGameBlock.requestLayout();
                break;
            default:
                break;
        }
    }
}
