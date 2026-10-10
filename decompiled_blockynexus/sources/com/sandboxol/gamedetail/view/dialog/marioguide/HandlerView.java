package com.sandboxol.gamedetail.view.dialog.marioguide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class HandlerView extends View {
    private OnClickStatusListener listener;

    public interface OnClickStatusListener {
        void a();

        void onClicking();
    }

    public HandlerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            OnClickStatusListener onClickStatusListener = this.listener;
            if (onClickStatusListener != null) {
                onClickStatusListener.onClicking();
            }
        } else {
            OnClickStatusListener onClickStatusListener2 = this.listener;
            if (onClickStatusListener2 != null) {
                onClickStatusListener2.a();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(OnClickStatusListener onClickStatusListener) {
        this.listener = onClickStatusListener;
    }
}
