package com.sandboxol.center.view.dialog.adsturntable;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.E;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public class AdsLinearLayoutManager extends LinearLayoutManager {
    private float speed;

    public AdsLinearLayoutManager(Context context) {
        super(context);
        this.speed = 1.5f;
    }

    public void setSpeedFast() {
        this.speed = 0.7f;
    }

    public void setSpeedSlow() {
        this.speed = 1.5f;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.t tVar, int i) {
        E e2 = new E(recyclerView.getContext()) { // from class: com.sandboxol.center.view.dialog.adsturntable.AdsLinearLayoutManager.1
            @Override // androidx.recyclerview.widget.E
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return AdsLinearLayoutManager.this.speed;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.s
            public PointF computeScrollVectorForPosition(int i2) {
                return AdsLinearLayoutManager.this.computeScrollVectorForPosition(i2);
            }
        };
        e2.setTargetPosition(i);
        startSmoothScroll(e2);
    }

    public AdsLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        this.speed = 1.5f;
    }

    public AdsLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.speed = 1.5f;
    }
}
