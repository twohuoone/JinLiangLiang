package com.zoro.jinliangliang.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * Created by Zoro
 * Created on 2020/12/10
 * description:  https://www.jianshu.com/p/c4601bab860a
 */
public class LineChartView extends View {
    /**
     * 自定义view实现柱状图
     * 首先定义一个类实现View
     */

    //定义画笔
    private Paint mLinePaint;//
    private Paint mTextPaint;
    private Paint mXDescPaint;
    private Paint mYDescPaint;
    private Paint mValuePaint;
    private Paint mDotPaint;
    private Paint mPathPaint;
    private Paint mPathMantlePaint;
    //绘制折线图
    private Path path;
    //绘制折线蒙层
    private Path pathMantl;
    //定义上下文
    private Context mContext;
    //定义宽高
    private float weight;
    private float height;
    private float mScale;
    //这个数组是高度的值
    private List<String> y_title = new ArrayList<>();
    //分别为定义数据与数据源名称的集合
    private List<Float> mData;
    private List<String> mNames;
    private Float max = 0f;
    private List<PointF> mValuePointList = new ArrayList<>();
    private List<PointF> mControlPointList = new ArrayList<>();
    private static float SMOOTHNESS = 0.2f;
    private int mDrawCirclePosition = 0;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (mDrawCirclePosition == mData.size()) {
                mDrawCirclePosition = 0;
            }
            invalidate();
            mDrawCirclePosition++;
            handler.sendEmptyMessageDelayed(1, 5000);
        }
    };

    public LineChartView(Context context) {
        super(context);
        init(context);
    }

    public LineChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LineChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LineChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        //给定义的画笔进行加工
        mContext = context;
        mLinePaint = new Paint();
        mXDescPaint = new Paint();
        mYDescPaint = new Paint();
        mTextPaint = new Paint();
        mValuePaint = new Paint();
        mPathPaint = new Paint();
        mDotPaint = new Paint();
        mPathMantlePaint = new Paint();
        mPathPaint.setStrokeWidth(2.5f);
        path = new Path();
        pathMantl = new Path();
        mLinePaint.setColor(0x2931F7FF);
        mXDescPaint.setColor(0xFF7195BA);
        mYDescPaint.setColor(0xFF7195BA);
        mTextPaint.setColor(0x1AFFFFFF);
        mDotPaint.setColor(0xFF31F7FF);
        mPathPaint.setColor(0xFF31F7FF);
        mValuePaint.setColor(0xFF31F7FF);
        mPathMantlePaint.setColor(0x1431F7FF);

        mPathPaint.setStyle(Paint.Style.STROKE);
        mPathMantlePaint.setStyle(Paint.Style.FILL);

        mTextPaint.setAntiAlias(true);
        mLinePaint.setAntiAlias(true);
        mPathPaint.setAntiAlias(true);
        mXDescPaint.setAntiAlias(true);
        mYDescPaint.setAntiAlias(true);
        mDotPaint.setAntiAlias(true);
        mValuePaint.setAntiAlias(true);

        mXDescPaint.setTextSize(16);
        mXDescPaint.setTextAlign(Paint.Align.RIGHT);
        mYDescPaint.setTextSize(16);
        mYDescPaint.setTextAlign(Paint.Align.CENTER);
        mValuePaint.setTextSize(33);
        mValuePaint.setTextAlign(Paint.Align.CENTER);
        mScale = context.getResources().getDisplayMetrics().density;
        //初始化数据
        mData = new ArrayList<>();
        mNames = new ArrayList<>();
        handler.sendEmptyMessageDelayed(1, 5000);
    }

    //尺寸发生改变的时候调用
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        weight = 0.93F * w;
        height = 0.88F * h;
    }

    //绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mData.size() > 0) {
            mValuePointList.clear();
            path.reset();
            pathMantl.reset();
            float min_height = height / 5;
            float min_weight = (weight - 150) / (mData.size());
            for (int i = y_title.size(); i > 0; i--) {
                canvas.drawLine(70, min_height * i, weight / 0.9f - 20, min_height * i, mLinePaint);
                mTextPaint.setTextAlign(Paint.Align.RIGHT);
                mTextPaint.setTextSize(15);
                mTextPaint.setColor(0x66FFFFFF);
                canvas.drawText(y_title.get(i - 1) + "千米", 60, min_height * i + 5, mXDescPaint);
            }
            for (int i = 0; i < mData.size(); i++) {
                float leftR;
                if (i == 0) {
                    leftR = (int) (77 + i * min_weight);
                } else {
                    leftR = (int) (77 + i * (min_weight + 27));
                }
                float rightR = leftR + (min_weight / 2 - 15);
                float buttomR = height;
                float topR = buttomR - ((buttomR - min_height) / max * mData.get(i));
                mTextPaint.setColor(0x66FFFFFF);
                mTextPaint.setTextSize(15);
                mTextPaint.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(mNames.get(i), (rightR + leftR) / 2, buttomR + 25, mYDescPaint);
                mValuePointList.add(new PointF((rightR + leftR) / 2, topR));
            }
            calculateControlPoint(mValuePointList);
            PointF firstPoint = mValuePointList.get(0);
            pathMantl.moveTo(firstPoint.x, height);
            pathMantl.lineTo(firstPoint.x, firstPoint.y);
            path.moveTo(firstPoint.x, firstPoint.y);
            for (int i = 0; i < mValuePointList.size() * 2 - 2; i = i + 2) {
                PointF leftControlPoint = mControlPointList.get(i);
                PointF rightControlPoint = mControlPointList.get(i + 1);
                PointF rightPoint = mValuePointList.get(i / 2 + 1);
                path.cubicTo(leftControlPoint.x, leftControlPoint.y, rightControlPoint.x, rightControlPoint.y, rightPoint.x, rightPoint.y);
                pathMantl.cubicTo(leftControlPoint.x, leftControlPoint.y, rightControlPoint.x, rightControlPoint.y, rightPoint.x, rightPoint.y);
            }
            PointF lastPoint = mValuePointList.get(mValuePointList.size() - 1);
            pathMantl.lineTo(lastPoint.x, height);
            pathMantl.lineTo(firstPoint.x, height);
            canvas.drawPath(path, mPathPaint);
            canvas.drawPath(pathMantl, mPathMantlePaint);
            if (mDrawCirclePosition == mValuePointList.size()) {
                mDrawCirclePosition = 0;
            }
            PointF point = mValuePointList.get(mDrawCirclePosition);
            mDotPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(point.x, point.y, 4, mDotPaint);
            mDotPaint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(point.x, point.y, 11, mDotPaint);
            //折线图大小问题  文字会被右侧切割
            if (mDrawCirclePosition == mValuePointList.size() - 1) {
                mValuePaint.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(mData.get(mDrawCirclePosition) + "", mValuePointList.get(mDrawCirclePosition).x, mValuePointList.get(mDrawCirclePosition).y - 20, mValuePaint);
            } else {
                mValuePaint.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(mData.get(mDrawCirclePosition) + "", mValuePointList.get(mDrawCirclePosition).x, mValuePointList.get(mDrawCirclePosition).y - 20, mValuePaint);
            }
        }
    }

    private void calculateControlPoint(List<PointF> pointList) {
        mControlPointList.clear();
        if (pointList.size() <= 1) {
            return;
        }
        for (int i = 0; i < pointList.size(); i++) {
            if (i == 0) {
                PointF nextPoint = pointList.get(i + 1);
                float controlX = pointList.get(i).x + (nextPoint.x - pointList.get(i).x) * SMOOTHNESS;
                float controlY = pointList.get(i).y;
                mControlPointList.add(new PointF(controlX, controlY));
            } else if (i == pointList.size() - 1) {
                //添加前控制点
                PointF lastPoint = pointList.get(i - 1);
                float controlX = pointList.get(i).x - (pointList.get(i).x - lastPoint.x) * SMOOTHNESS;
                float controlY = pointList.get(i).y;
                mControlPointList.add(new PointF(controlX, controlY));
            } else {
                PointF lastPoint = pointList.get(i - 1);
                PointF nextPoint = pointList.get(i + 1);
                float k = (nextPoint.y - lastPoint.y) / (nextPoint.x - lastPoint.x);
                float b = pointList.get(i).y - k * pointList.get(i).x;
                //添加前控制点
                float lastControlX = pointList.get(i).x - (pointList.get(i).x - lastPoint.x) * SMOOTHNESS;
                float lastControlY = k * lastControlX + b;
                mControlPointList.add(new PointF(lastControlX, lastControlY));
                //添加后控制点
                float nextControlX = pointList.get(i).x + (nextPoint.x - pointList.get(i).x) * SMOOTHNESS;
                float nextControlY = k * nextControlX + b;
                mControlPointList.add(new PointF(nextControlX, nextControlY));
            }
        }
    }

    //传入数据并进行绘制
    public void updateThisData(List<Float> data, List<String> name, Float max) {
        mData = data;
        mNames = name;
        this.max = max;
        y_title.clear();
        y_title.add( Math.round(max) + "");
        y_title.add(Math.round( max * 3 / 4) + "");
        y_title.add(Math.round(max / 2 )+ "");
        y_title.add(Math.round(max * 1 / 4 )+ "");
        y_title.add(0 + "");
    }

}