package com.sandboxol.gamedetail.view.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

/* JADX INFO: loaded from: classes3.dex */
public class ClickingHideView extends Button {
    public ClickingHideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            setVisibility(4);
        } else {
            setVisibility(0);
        }
        return super.onTouchEvent(motionEvent);
    }
}
