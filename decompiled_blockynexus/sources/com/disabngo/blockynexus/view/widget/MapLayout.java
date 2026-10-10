package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.utils.SizeUtil;

/* JADX INFO: loaded from: classes.dex */
public class MapLayout extends RelativeLayout {
    public final int MULTIPLE;
    private boolean isMove;
    private int lastPerspectiveLeft;
    private int lastPerspectiveTop;
    private int mLastX;
    private int mLastY;
    private Paint paint;
    private int screenHeight;
    private int screenWidth;

    public MapLayout(Context context) {
        super(context);
        this.isMove = true;
        this.MULTIPLE = 19;
        init();
    }

    private void init() {
        this.lastPerspectiveLeft = getLeft();
        this.lastPerspectiveTop = getTop();
        this.paint = new Paint(1);
        this.paint.setColor(androidx.core.content.b.a(getContext(), R.color.friendMatchMapCircleBg));
        this.paint.setStrokeWidth(SizeUtil.dp2px(getContext(), 2.0f));
        this.paint.setStyle(Paint.Style.STROKE);
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager == null) {
            this.screenWidth = 1080;
            this.screenHeight = 1920;
            return;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (defaultDisplay == null) {
            this.screenWidth = 1080;
            this.screenHeight = 1920;
        } else {
            defaultDisplay.getMetrics(displayMetrics);
            this.screenWidth = displayMetrics.widthPixels;
            this.screenHeight = displayMetrics.heightPixels;
        }
    }

    public void isCanMove(boolean z) {
        this.isMove = z;
    }

    public void moveCenter() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = this.lastPerspectiveLeft;
        layoutParams.topMargin = this.lastPerspectiveTop;
        layoutParams.addRule(13);
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.lastPerspectiveLeft = getLeft();
        this.lastPerspectiveTop = getTop();
        if (this.paint != null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int i = (measuredWidth > measuredHeight ? measuredHeight : measuredWidth) / 19;
            float f2 = measuredWidth / 2;
            float f3 = measuredHeight / 2;
            for (int i2 = 0; i2 < 9; i2++) {
                canvas.drawCircle(f2, f3, (i2 + 2) * i, this.paint);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        Drawable background = getBackground();
        super.onMeasure(background.getIntrinsicWidth(), background.getIntrinsicHeight());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.isMove) {
            return super.onTouchEvent(motionEvent);
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastX = x;
            this.mLastY = y;
            return true;
        }
        if (action != 2) {
            return true;
        }
        int right = x - this.mLastX;
        int bottom = y - this.mLastY;
        if (getLeft() + right > 0) {
            right = -getLeft();
        }
        if (getTop() + bottom > 0) {
            bottom = -getTop();
        }
        int right2 = getRight() + right;
        int i = this.screenWidth;
        if (right2 < i) {
            right = i - getRight();
        }
        int bottom2 = getBottom() + bottom;
        int i2 = this.screenHeight;
        if (bottom2 < i2) {
            bottom = i2 - getBottom();
        }
        this.lastPerspectiveLeft = getLeft() + right;
        this.lastPerspectiveTop = getTop() + bottom;
        layout(getLeft() + right, getTop() + bottom, getRight() + right, getBottom() + bottom);
        return true;
    }

    public void removeAllFriendView() {
        try {
            for (int childCount = getChildCount() - 1; childCount > 0; childCount--) {
                removeViewAt(childCount);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setLastMove() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = this.lastPerspectiveLeft;
        layoutParams.topMargin = this.lastPerspectiveTop;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(13);
        } else {
            layoutParams.addRule(13, 0);
        }
        setLayoutParams(layoutParams);
    }

    public MapLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isMove = true;
        this.MULTIPLE = 19;
        init();
    }

    public MapLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isMove = true;
        this.MULTIPLE = 19;
        init();
    }
}
