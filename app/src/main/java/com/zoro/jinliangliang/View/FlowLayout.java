package com.zoro.jinliangliang.View;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hugh on 2019/7/15.
 */
public class FlowLayout extends RadioGroup {

    private boolean lineFeed = true;

    /**
     * 设置是否可以换行
     *
     * @param lineFeed
     */
    public void setLineFeed(boolean lineFeed) {
        this.lineFeed = lineFeed;
    }

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = 0, measuredHeight = 0;

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        Map<String, Integer> compute = compute(widthSize - getPaddingRight());
        if (widthMode == MeasureSpec.EXACTLY) {
            measuredWidth = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            measuredWidth = compute.get("allChildWidth");
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            measuredHeight = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            measuredHeight = compute.get("allChildHeight");
        } else if (heightMode == MeasureSpec.UNSPECIFIED) {
            measuredHeight = compute.get("allChildHeight");
        } else {
            measuredHeight = compute.get("allChildHeight");
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            Rect rect = (Rect) getChildAt(i).getTag();
            child.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    private Map<String, Integer> compute(int flowWidth) {
        //是否是单行
        boolean aRow = true;
        MarginLayoutParams marginParams;
        int rowsWidth = getPaddingLeft();
        int columnHeight = getPaddingTop();
        int rowsMaxHeight = 0;
        boolean isChange = false;//是否换行
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            int measuredWidth = child.getMeasuredWidth();
            int measuredHeight = child.getMeasuredHeight();
            marginParams = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = marginParams.leftMargin + marginParams.rightMargin + measuredWidth;
            int childHeight = marginParams.topMargin + marginParams.bottomMargin + measuredHeight;
            rowsMaxHeight = Math.max(rowsMaxHeight, childHeight);
            if (rowsWidth + childWidth > flowWidth && lineFeed) {
                rowsWidth = getPaddingLeft() + getPaddingRight();
                columnHeight += rowsMaxHeight;
                rowsMaxHeight = childHeight;
                isChange = true;
                aRow = false;
            }
            if (columnHeight == getPaddingTop()) {
                columnHeight -= marginParams.topMargin;
            }

            //child.setTag(new Rect(rowsWidth - childWidth + marginParams.leftMargin, columnHeight + marginParams.topMargin, rowsWidth - marginParams.rightMargin, columnHeight + childHeight - marginParams.bottomMargin));
            if (i == 0 || isChange) {
                rowsWidth += childWidth - marginParams.leftMargin;
                child.setTag(new Rect(0, columnHeight + marginParams.topMargin, rowsWidth - marginParams.rightMargin - (rowsWidth - childWidth + marginParams.leftMargin), columnHeight + childHeight - marginParams.bottomMargin));
                isChange = false;
            } else {
                rowsWidth += childWidth;
                child.setTag(new Rect(rowsWidth - childWidth + marginParams.leftMargin, (columnHeight == getPaddingTop() ? columnHeight : columnHeight + marginParams.topMargin), rowsWidth - marginParams.rightMargin, columnHeight + childHeight - marginParams.bottomMargin));
            }
        }

        Map<String, Integer> flowMap = new HashMap<>();
        if (aRow) {
            flowMap.put("allChildWidth", rowsWidth);
        } else {
            flowMap.put("allChildWidth", flowWidth);
        }
        flowMap.put("allChildHeight", columnHeight + rowsMaxHeight + getPaddingBottom());
        return flowMap;
    }
}

