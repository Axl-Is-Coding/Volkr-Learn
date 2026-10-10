package com.alibaba.sdk.android.feedback.xblink.view;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3904a;

    b(a aVar) {
        this.f3904a = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int top = this.f3904a.f3902e.getTop();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 1 && y < top) {
            this.f3904a.f3900c.dismiss();
        }
        return true;
    }
}
