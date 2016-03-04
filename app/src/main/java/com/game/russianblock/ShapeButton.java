package com.game.russianblock;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016-01-26.
 * @author QiaoJiadong
 */
public class ShapeButton extends View {
    private Paint mPaint;
    private boolean mIsRound = false;
    private float mRotation;

    public ShapeButton(Context context) {
        super(context, null);
    }

    public ShapeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ShapeButtonStyle);
        mIsRound = ta.getBoolean(R.styleable.ShapeButtonStyle_isRound, false);
        mRotation = ta.getFloat(R.styleable.ShapeButtonStyle_rotation, 0);
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
    }

    @Override
    public void onDraw(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

        if(mIsRound) {
            canvas.drawCircle(70, 70, 70, mPaint);
        } else {
            Path path = new Path();
            path.moveTo(0, 0);
            path.lineTo(140, 60);
            path.lineTo(0, 120);
            path.close();
            canvas.rotate(mRotation, 70, 60);
            canvas.drawPath(path, mPaint);
        }
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(140), measureHeight(140));
    }

    public int measureWidth(int measureSpec) {
        //int specMode = MeasureSpec.getMode(measureSpec);
        //int specSize = MeasureSpec.getSize(measureSpec);
        return measureSpec;
    }

    public int measureHeight(int measureSpec) {
        //int specMode = MeasureSpec.getMode(measureSpec);
        //int specSize = MeasureSpec.getSize(measureSpec);
        return measureSpec;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            mPaint.setColor(getResources().getColor(R.color.fluorescent_green));
            postInvalidate();
        }
        if(event.getAction() == MotionEvent.ACTION_UP) {
            mPaint.setColor(Color.WHITE);
            postInvalidate();
        }
        return true;
    }
}

