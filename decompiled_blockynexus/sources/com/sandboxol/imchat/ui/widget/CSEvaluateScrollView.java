package com.sandboxol.imchat.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes4.dex */
public class CSEvaluateScrollView extends ScrollView {
    Context mContext;

    public CSEvaluateScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? getResources().getDimensionPixelSize(identifier) : -1;
        Log.e("WangJ", "状态栏-方法1:" + dimensionPixelSize);
        return dimensionPixelSize;
    }

    private int getWindowHeight() {
        return ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getHeight();
    }
}
