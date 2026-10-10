package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import cn.qqtheme.framework.widget.WheelView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ac;

/* JADX INFO: compiled from: VideoOnTouchLayout.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f6613a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f6616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f6617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6618f;
    private int g;
    private boolean k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6614b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6615c = false;
    private boolean h = true;
    private boolean i = false;
    private final View.OnTouchListener j = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.d.1
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.f6613a.m()) {
                return d.this.f6614b || !d.this.f6615c;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                d dVar = d.this;
                dVar.k = dVar.a(motionEvent);
                d.this.f6616d = x;
                d.this.f6617e = y;
                d.this.f6618f = (int) x;
                d.this.g = (int) y;
                d.this.h = true;
                if (d.this.f6613a != null && d.this.f6615c && !d.this.f6614b) {
                    d.this.f6613a.a(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x - d.this.f6618f) > 20.0f || Math.abs(y - d.this.g) > 20.0f) {
                    d.this.h = false;
                }
                if (!d.this.f6614b) {
                    d.this.h = true;
                }
                d.this.i = false;
                d.this.f6616d = WheelView.DividerConfig.FILL;
                d.this.f6617e = WheelView.DividerConfig.FILL;
                d.this.f6618f = 0;
                if (d.this.f6613a != null) {
                    d.this.f6613a.a(view, d.this.h);
                }
                d.this.k = false;
            } else if (action != 2) {
                if (action == 3) {
                    d.this.k = false;
                }
            } else if (d.this.f6614b && !d.this.k) {
                float f2 = x - d.this.f6616d;
                float f3 = y - d.this.f6617e;
                float fAbs = Math.abs(f2);
                float fAbs2 = Math.abs(f3);
                if (!d.this.i) {
                    if (fAbs <= 20.0f && fAbs2 <= 20.0f) {
                        return true;
                    }
                    d.this.i = true;
                }
                if (d.this.f6613a != null) {
                    d.this.f6613a.l();
                }
                d.this.f6616d = x;
                d.this.f6617e = y;
            }
            return d.this.f6614b || !d.this.f6615c;
        }
    };

    /* JADX INFO: compiled from: VideoOnTouchLayout.java */
    public interface a {
        void a(View view, boolean z);

        void l();

        boolean m();
    }

    public d(a aVar) {
        this.f6613a = aVar;
    }

    public void a(View view) {
        if (view != null) {
            view.setOnTouchListener(this.j);
        }
    }

    public void a(boolean z) {
        this.f6615c = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int iC = ac.c(o.a().getApplicationContext());
        int iD = ac.d(o.a().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f2 = iC;
        if (rawX > f2 * 0.01f && rawX < f2 * 0.99f) {
            float f3 = iD;
            if (rawY > 0.01f * f3 && rawY < f3 * 0.99f) {
                return false;
            }
        }
        return true;
    }
}
