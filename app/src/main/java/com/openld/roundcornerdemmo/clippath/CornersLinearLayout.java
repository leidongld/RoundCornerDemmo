package com.openld.roundcornerdemmo.clippath;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.openld.roundcornerdemmo.R;

/**
 * author: lllddd
 * created on: 2020/6/9 10:55
 * description:
 */
public class CornersLinearLayout extends LinearLayout {
    private Context mContext;

    private float mCorners;
    private float mLeftTopCorner;
    private float mRightTopCorner;
    private float mLeftBottomCorner;
    private float mRightBottomCorner;

    private int mWidth;
    private int mHeight;

    public CornersLinearLayout(Context context) {
        this(context, null);
    }

    public CornersLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CornersLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CornersLinearLayout);
        mCorners = typedArray.getDimension(R.styleable.CornersLinearLayout_corner, 0F);
        mLeftTopCorner = typedArray.getDimension(R.styleable.CornersLinearLayout_leftTopCorner, 0F);
        mRightTopCorner = typedArray.getDimension(R.styleable.CornersLinearLayout_rightTopCorner, 0F);
        mRightBottomCorner = typedArray.getDimension(R.styleable.CornersLinearLayout_rightBottomCorner, 0F);
        mLeftBottomCorner = typedArray.getDimension(R.styleable.CornersLinearLayout_leftBottomCorner, 0F);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();

        Path path = new Path();
        RectF rectF = new RectF(0, 0, mWidth, mHeight);
        if (mCorners > 0F) {
            path.addRoundRect(rectF, mCorners, mCorners, Path.Direction.CCW);
        } else {
            float[] radii = new float[]{
                    mLeftTopCorner, mLeftTopCorner,
                    mRightTopCorner, mRightTopCorner,
                    mRightBottomCorner, mRightBottomCorner,
                    mLeftBottomCorner, mLeftBottomCorner
            };
            path.addRoundRect(rectF, radii, Path.Direction.CCW);
        }
        canvas.clipPath(path);

        super.draw(canvas);
    }
}
