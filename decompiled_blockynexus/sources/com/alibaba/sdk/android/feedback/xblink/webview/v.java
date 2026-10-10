package com.alibaba.sdk.android.feedback.xblink.webview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.alibaba.sdk.android.feedback.xblink.view.WebErrorView;
import com.alibaba.sdk.android.feedback.xblink.view.WebWaitingView;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f3933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f3934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f3935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f3936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3937e = false;

    public v(Context context, View view) {
        this.f3936d = context;
        this.f3935c = view;
    }

    public void a() {
        this.f3937e = true;
    }

    public void a(View view) {
        if (view != null) {
            this.f3933a = view;
            this.f3933a.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(14, 1);
            ViewParent parent = this.f3935c.getParent();
            if (parent != null) {
                ((ViewGroup) parent).addView(this.f3933a, layoutParams);
            }
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (view != null) {
            this.f3933a = view;
            this.f3933a.setVisibility(8);
            ViewParent parent = this.f3935c.getParent();
            if (parent != null) {
                ((ViewGroup) parent).addView(this.f3933a, layoutParams);
            }
        }
    }

    public void b() {
        if (this.f3937e) {
            if (this.f3933a == null) {
                this.f3933a = new WebWaitingView(this.f3936d);
                a(this.f3933a);
            }
            this.f3933a.bringToFront();
            if (this.f3933a.getVisibility() != 0) {
                this.f3933a.setVisibility(0);
            }
        }
    }

    public void b(View view) {
        if (view != null) {
            this.f3934b = view;
            this.f3934b.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(14, 1);
            ViewParent parent = this.f3935c.getParent();
            if (parent != null) {
                ((ViewGroup) parent).addView(this.f3934b, layoutParams);
            }
        }
    }

    public void c() {
        View view;
        if (!this.f3937e || (view = this.f3933a) == null || view.getVisibility() == 8) {
            return;
        }
        this.f3933a.setVisibility(8);
    }

    public void d() {
        if (this.f3934b == null) {
            this.f3934b = new WebErrorView(this.f3936d);
            b(this.f3934b);
        }
        this.f3934b.bringToFront();
        if (this.f3934b.getVisibility() != 0) {
            this.f3934b.setVisibility(0);
        }
    }

    public void e() {
        View view = this.f3934b;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        this.f3934b.setVisibility(8);
    }
}
