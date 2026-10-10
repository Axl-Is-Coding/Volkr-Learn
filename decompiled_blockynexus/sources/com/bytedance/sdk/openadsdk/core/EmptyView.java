package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ad;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class EmptyView extends View implements ad.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f5997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f5998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<View> f5999e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<View> f6000f;
    private boolean g;
    private int h;
    private final Handler i;
    private final AtomicBoolean j;

    public interface a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public EmptyView(Context context, View view) {
        super(o.a());
        this.i = new ad(Looper.getMainLooper(), this);
        this.j = new AtomicBoolean(true);
        this.f5998d = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void b() {
        a aVar;
        if (!this.j.getAndSet(false) || (aVar = this.f5997c) == null) {
            return;
        }
        aVar.a();
    }

    private void c() {
        a aVar;
        if (this.j.getAndSet(true) || (aVar = this.f5997c) == null) {
            return;
        }
        aVar.b();
    }

    private void d() {
        if (!this.f5996b || this.f5995a) {
            return;
        }
        this.f5995a = true;
        this.i.sendEmptyMessage(1);
    }

    private void e() {
        if (this.f5995a) {
            this.i.removeCallbacksAndMessages(null);
            this.f5995a = false;
        }
    }

    public void a() {
        a(this.f5999e, null);
        a(this.f6000f, null);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
        this.g = false;
        b();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        this.g = true;
        c();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        b();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        c();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a aVar = this.f5997c;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void setAdType(int i) {
        this.h = i;
    }

    public void setCallback(a aVar) {
        this.f5997c = aVar;
    }

    public void setNeedCheckingShow(boolean z) {
        this.f5996b = z;
        if (!z && this.f5995a) {
            e();
        } else {
            if (!z || this.f5995a) {
                return;
            }
            d();
        }
    }

    public void setRefClickViews(List<View> list) {
        this.f5999e = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.f6000f = list;
    }

    public void a(List<View> list, com.bytedance.sdk.openadsdk.core.a.c cVar) {
        if (com.bytedance.sdk.openadsdk.utils.m.b(list)) {
            for (View view : list) {
                view.setOnClickListener(cVar);
                view.setOnTouchListener(cVar);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    public void a(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            boolean zC = ab.c(o.a(), o.a().getPackageName());
            if (!w.a(this.f5998d, 20, this.h) && zC) {
                if (this.g) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            this.i.sendEmptyMessageDelayed(2, 1000L);
            return;
        }
        if (this.f5995a) {
            if (w.a(this.f5998d, 20, this.h)) {
                e();
                this.i.sendEmptyMessageDelayed(2, 1000L);
                a aVar = this.f5997c;
                if (aVar != null) {
                    aVar.a(this.f5998d);
                    return;
                }
                return;
            }
            this.i.sendEmptyMessageDelayed(1, 1000L);
        }
    }
}
