package com.alibaba.sdk.android.feedback.windvane;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class h implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WXBaseHybridActivity f3745a;

    h(WXBaseHybridActivity wXBaseHybridActivity) {
        this.f3745a = wXBaseHybridActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if ((action != 0 && action != 1) || view.hasFocus()) {
            return false;
        }
        view.requestFocus();
        return false;
    }
}
