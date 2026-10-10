package com.bytedance.sdk.openadsdk.core.a;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.g.g;

/* JADX INFO: compiled from: InteractionListener.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements View.OnClickListener, View.OnTouchListener {
    protected int r;
    protected int s;
    protected int t;
    protected int u;
    protected long v;
    protected long w;
    protected int x;
    protected int y;
    protected int z;

    protected abstract void a(View view, int i, int i2, int i3, int i4);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (g.a()) {
            a(view, this.r, this.s, this.t, this.u);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.r = (int) motionEvent.getRawX();
            this.s = (int) motionEvent.getRawY();
            this.v = System.currentTimeMillis();
            this.x = motionEvent.getToolType(0);
            this.y = motionEvent.getDeviceId();
            this.z = motionEvent.getSource();
        } else if (actionMasked == 1) {
            this.t = (int) motionEvent.getRawX();
            this.u = (int) motionEvent.getRawY();
            this.w = System.currentTimeMillis();
        }
        return false;
    }
}
