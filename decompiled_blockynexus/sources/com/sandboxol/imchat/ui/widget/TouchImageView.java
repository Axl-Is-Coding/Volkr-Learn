package com.sandboxol.imchat.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatImageView;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes4.dex */
public class TouchImageView extends AppCompatImageView {
    private float firstX;
    private float firstY;
    private float maxDis;
    private int screenHeight;
    private int screenWidth;
    float x;
    float y;

    public TouchImageView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            this.screenWidth = windowManager.getDefaultDisplay().getWidth();
            this.screenHeight = windowManager.getDefaultDisplay().getHeight();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.screenHeight != 0 && this.screenWidth != 0) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.maxDis = WheelView.DividerConfig.FILL;
                this.firstX = motionEvent.getRawX();
                this.firstY = motionEvent.getRawY();
            } else {
                if (action == 1) {
                    return Math.abs(this.maxDis) > 4.0f || super.onTouchEvent(motionEvent);
                }
                if (action == 2) {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    float f2 = rawX - this.x;
                    float f3 = rawY - this.y;
                    float x = getX() + f2;
                    float y = getY() + f3;
                    float width = this.screenHeight - (getWidth() * 2.2f);
                    float width2 = (this.screenWidth - getWidth()) - 10;
                    if (getX() <= 10.0f || getY() <= 10.0f || getX() >= width2 || getY() >= width) {
                        if (getX() <= 10.0f) {
                            if (f2 <= WheelView.DividerConfig.FILL) {
                                setX(10.0f);
                            } else {
                                setX(x);
                            }
                        }
                        if (getX() >= width2) {
                            if (f2 >= WheelView.DividerConfig.FILL) {
                                setX(width2);
                            } else {
                                setX(x);
                            }
                        }
                        if (getY() <= 10.0f) {
                            if (f3 <= WheelView.DividerConfig.FILL) {
                                setY(10.0f);
                            } else {
                                setY(y);
                            }
                        }
                        if (getY() >= width) {
                            if (f3 >= WheelView.DividerConfig.FILL) {
                                setY(width);
                            } else {
                                setY(y);
                            }
                        }
                    } else {
                        setX(x);
                        setY(y);
                    }
                    float f4 = f2 + f3;
                    if (this.maxDis < Math.abs(f4)) {
                        this.maxDis = Math.abs(f4);
                    }
                }
            }
            this.x = motionEvent.getRawX();
            this.y = motionEvent.getRawY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public TouchImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
