package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.sandboxol.common.interfaces.OnDataListener;

/* JADX INFO: loaded from: classes.dex */
public class GameDetailRelativeLayout extends RelativeLayout {
    private OnDataListener<Integer> listener;

    public GameDetailRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.listener != null) {
            int action = motionEvent.getAction();
            if (action == 1) {
                this.listener.onSuccess(1);
            } else if (action == 2) {
                this.listener.onSuccess(2);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setTouchListener(OnDataListener<Integer> onDataListener) {
        this.listener = onDataListener;
    }

    public GameDetailRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GameDetailRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
