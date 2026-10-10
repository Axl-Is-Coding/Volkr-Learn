package com.tencent.tp;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class TouchListenerProxy implements View.OnTouchListener {
    private static volatile TouchListenerProxy mInstance;
    private int mOnTouchCnt;
    private View.OnTouchListener mRawListener;
    private int mScreenHeight;
    private int mScreenWidth;

    private TouchListenerProxy() {
    }

    public static TouchListenerProxy getInstance() {
        if (mInstance == null) {
            synchronized (TouchListenerProxy.class) {
                if (mInstance == null) {
                    mInstance = new TouchListenerProxy();
                }
            }
        }
        return mInstance;
    }

    private void log(String str) {
        try {
            byte[] bytes = ("*#06#:" + str).getBytes("utf-8");
            TssSdk.onruntimeinfo(bytes, bytes.length);
        } catch (Exception unused) {
        }
    }

    private void notifyMotionEvent(MotionEvent motionEvent) {
        if (this.mScreenWidth == 0 || this.mScreenHeight == 0) {
            Context contextC = v.c();
            if (contextC == null) {
                return;
            }
            try {
                DisplayMetrics displayMetrics = contextC.getResources().getDisplayMetrics();
                this.mScreenWidth = displayMetrics.widthPixels;
                this.mScreenHeight = displayMetrics.heightPixels;
            } catch (Throwable unused) {
                this.mScreenWidth = 1;
                this.mScreenHeight = 1;
            }
        }
        if (this.mScreenWidth < 2 || this.mScreenHeight < 2) {
            return;
        }
        String str = String.format(Locale.ENGLISH, "AddTouchEvent:row=%d|col=%d|row_max=%d|col_max=%d", Integer.valueOf((int) motionEvent.getRawX()), Integer.valueOf((int) motionEvent.getRawY()), Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight));
        TssSdk.ioctl(str);
        int i = this.mOnTouchCnt;
        this.mOnTouchCnt = i + 1;
        if (i < 10) {
            log(str);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action;
        if (motionEvent != null && ((action = motionEvent.getAction()) == 0 || action == 1 || action == 2)) {
            notifyMotionEvent(motionEvent);
        }
        View.OnTouchListener onTouchListener = this.mRawListener;
        if (onTouchListener != null) {
            return onTouchListener.onTouch(view, motionEvent);
        }
        return false;
    }

    public void setRawListener(View.OnTouchListener onTouchListener) {
        this.mRawListener = onTouchListener;
    }
}
