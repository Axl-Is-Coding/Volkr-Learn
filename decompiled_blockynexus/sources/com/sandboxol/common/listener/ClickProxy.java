package com.sandboxol.common.listener;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class ClickProxy implements View.OnClickListener {
    private long lastClick;
    private IAgain mIAgain;
    private View.OnClickListener origin;
    private long times;

    public interface IAgain {
        void onAgain();
    }

    public ClickProxy(View.OnClickListener onClickListener) {
        this.lastClick = 0L;
        this.times = 1000L;
        this.origin = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (System.currentTimeMillis() - this.lastClick >= this.times) {
            this.origin.onClick(view);
            this.lastClick = System.currentTimeMillis();
        } else {
            IAgain iAgain = this.mIAgain;
            if (iAgain != null) {
                iAgain.onAgain();
            }
        }
    }

    public ClickProxy(View.OnClickListener onClickListener, long j) {
        this.lastClick = 0L;
        this.times = 1000L;
        this.origin = onClickListener;
        this.times = j;
    }

    public ClickProxy(View.OnClickListener onClickListener, long j, IAgain iAgain) {
        this.lastClick = 0L;
        this.times = 1000L;
        this.origin = onClickListener;
        this.mIAgain = iAgain;
        this.times = j;
    }
}
