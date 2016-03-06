package com.game.russianblock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016-02-05.
 * QJD
 */
public class Blocks extends View {

    private Paint mPaint;
    private static int mDegree = 0;
    private static int translateToX = 0;
    private static int translateToY = 0;
    private static int mRandomInt = 1;

    public Blocks(Context context) {
        super(context);
    }

    public Blocks(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);

        switch(mRandomInt) {
            case GameConstants.O:
                mPaint.setColor(Color.MAGENTA);
                drawBlocks_O(mPaint, canvas);
                break;
            case GameConstants.I:
                mPaint.setColor(Color.RED);
                drawBlocks_I(mPaint, canvas);
                break;
            case GameConstants.Z:
                mPaint.setColor(Color.DKGRAY);
                drawBlocks_Z(mPaint, canvas);
                break;
            case GameConstants.S:
                mPaint.setColor(Color.YELLOW);
                drawBlocks_S(mPaint, canvas);
                break;
            case GameConstants.L:
                mPaint.setColor(Color.BLUE);
                drawBlocks_L(mPaint, canvas);
                break;
            case GameConstants.J:
                mPaint.setColor(Color.CYAN);
                drawBlocks_J(mPaint, canvas);
                break;
            case GameConstants.T:
                mPaint.setColor(Color.GREEN);
                drawBlocks_T(mPaint, canvas);
                break;
        }
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //after every measure, the view would restore its measurevalue
        //if we don't call onMeasure() once again, the view would keep its size.
        //use requestLayout() to make the view recall omMeasure().
        int height = 0, width=0;
        switch(mRandomInt) {
            case GameConstants.O:
                height = 126;
                width = 126;
                break;
            case GameConstants.I:
                height = (mDegree%2 == 0) ? 60 : 258;
                width = (mDegree%2 == 0) ? 258 : 60;
                break;
            case GameConstants.Z:
            case GameConstants.S:
            case GameConstants.L:
            case GameConstants.J:
            case GameConstants.T:
                height = (mDegree%2 == 0) ? 126:192;
                width = (mDegree%2 == 0) ? 192:126;
                break;
        }
        //Toast.makeText(getContext(), "onMeasure()" + mRandomInt, Toast.LENGTH_SHORT).show();
        setMeasuredDimension(width, height);
    }

    public int getColor() {
        int color = 0;
        switch(mRandomInt) {
            case GameConstants.O:
                color = Color.MAGENTA;
                break;
            case GameConstants.I:
                color = Color.RED;
                break;
            case GameConstants.Z:
                color = Color.DKGRAY;
                break;
            case GameConstants.S:
                color = Color.YELLOW;
                break;
            case GameConstants.L:
                color = Color.BLUE;
                break;
            case GameConstants.J:
                color = Color.CYAN;
                break;
            case GameConstants.T:
                color = Color.GREEN;
                break;
        }
        return color;
    }

    public void rotateClockwise(int i) {
        mDegree = i;
        switch(mRandomInt) {
            case GameConstants.O:
                break;
            case GameConstants.I:
                if(mDegree%2 != 0) {
                    translateToX = -99;
                    translateToY = 99;
                } else {
                    translateToX = 0;
                    translateToY = 0;
                }
                break;
            case GameConstants.Z:
            case GameConstants.S:
            case GameConstants.L:
            case GameConstants.J:
            case GameConstants.T:
                if(mDegree%2 != 0) {
                    translateToX = -33;
                    translateToY = 33;
                } else {
                    translateToX = 0;
                    translateToY = 0;
                }
                break;
        }
    }

    public void setRandomInt(int rand) {
        mRandomInt = rand;
    }

    public void drawBlocks_O(Paint p, Canvas canvas) {
        canvas.rotate(mDegree * 90, 63, 63);
        canvas.drawRect(0, 0, 60, 60, p);
        canvas.drawRect(66, 0, 126, 60, p);
        canvas.drawRect(0, 66, 60, 126, p);
        canvas.drawRect(66, 66, 126, 126, p);
    }

    public void drawBlocks_I(Paint p, Canvas canvas) {
        canvas.translate(translateToX, translateToY);
        canvas.rotate(mDegree * 90, 129, 30);
        canvas.drawRect(0, 0, 60, 60, p);
        canvas.drawRect(66, 0, 126, 60, p);
        canvas.drawRect(132, 0, 192, 60, p);
        canvas.drawRect(198, 0, 258, 60, p);
    }
    public void drawBlocks_Z(Paint p, Canvas canvas) {
        canvas.translate(translateToX, translateToY);
        canvas.rotate(mDegree * 90, 96, 63);
        canvas.drawRect(0, 0, 60, 60, p);
        canvas.drawRect(66, 0, 126, 60, p);
        canvas.drawRect(66, 66, 126, 126, p);
        canvas.drawRect(132, 66, 192, 126, p);
    }

    public void drawBlocks_S(Paint p, Canvas canvas) {
        canvas.translate(translateToX, translateToY);
        canvas.rotate(mDegree * 90, 96, 63);
        canvas.drawRect(66, 0, 126, 60, p);
        canvas.drawRect(132, 0, 192, 60, p);
        canvas.drawRect(0, 66, 60, 126, p);
        canvas.drawRect(66, 66, 126, 126, p);
    }

    public void drawBlocks_L(Paint p, Canvas canvas) {
        canvas.translate(translateToX, translateToY);
        canvas.rotate(mDegree * 90, 96, 63);
        canvas.drawRect(132, 0, 192, 60, p);
        canvas.drawRect(0, 66, 60, 126, p);
        canvas.drawRect(66, 66, 126, 126, p);
        canvas.drawRect(132, 66, 192, 126, p);
    }

    public void drawBlocks_J(Paint p, Canvas canvas) {
        canvas.translate(translateToX, translateToY);
        canvas.rotate(mDegree * 90, 96, 63);
        canvas.drawRect(0, 0, 60, 60, p);
        canvas.drawRect(0, 66, 60, 126, p);
        canvas.drawRect(66, 66, 126, 126, p);
        canvas.drawRect(132, 66, 192, 126, p);
    }

    public void drawBlocks_T(Paint p, Canvas canvas) {
        canvas.translate(translateToX, translateToY);
        canvas.rotate(mDegree * 90, 96, 63);
        canvas.drawRect(0, 0, 60, 60, p);
        canvas.drawRect(66, 0, 126, 60, p);
        canvas.drawRect(132, 0, 192, 60, p);
        canvas.drawRect(66, 66, 126, 126, p);
    }
}
