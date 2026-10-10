package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: HackTouchDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends TouchDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f7114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Rect f7115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Rect f7116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7118e;

    public j(Rect rect, View view) {
        super(rect, view);
        this.f7115b = rect;
        this.f7118e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f7116c = new Rect(rect);
        Rect rect2 = this.f7116c;
        int i = this.f7118e;
        rect2.inset(-i, -i);
        this.f7114a = view;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean zContains = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                z = this.f7117d;
                if (z) {
                    zContains = this.f7116c.contains(x, y);
                }
            } else if (action != 3) {
                z = false;
            } else {
                boolean z2 = this.f7117d;
                this.f7117d = false;
                z = z2;
            }
        } else if (this.f7115b.contains(x, y)) {
            this.f7117d = true;
            z = true;
        } else {
            this.f7117d = false;
            z = false;
        }
        if (!z) {
            return false;
        }
        View view = this.f7114a;
        if (zContains) {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        } else {
            float f2 = -(this.f7118e * 2);
            motionEvent.setLocation(f2, f2);
        }
        if (view.getVisibility() == 0) {
            return view.dispatchTouchEvent(motionEvent);
        }
        return false;
    }
}
