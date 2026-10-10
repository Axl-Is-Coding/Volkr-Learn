package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.d;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: ClickListener.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Context f6003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final h f6004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final String f6005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final int f6006f;
    protected WeakReference<View> g;
    protected WeakReference<View> h;
    protected com.bytedance.sdk.openadsdk.core.d.d i;
    protected a j;
    protected TTNativeAd k;
    protected com.bytedance.sdk.openadsdk.core.video.nativevideo.c l;
    protected boolean m = false;
    protected b.a.a.a.a.a.b n;
    protected Map<String, Object> o;
    protected TTNativeExpressAd p;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.a q;

    /* JADX INFO: compiled from: ClickListener.java */
    public interface a {
        void a(View view, int i);
    }

    public b(Context context, h hVar, String str, int i) {
        this.f6003c = context;
        this.f6004d = hVar;
        this.f6005e = str;
        this.f6006f = i;
    }

    public void a(b.a.a.a.a.a.b bVar) {
        this.n = bVar;
    }

    public void b(View view) {
        this.h = new WeakReference<>(view);
    }

    public void d(boolean z) {
        this.m = z;
    }

    public void a(com.bytedance.sdk.openadsdk.core.nativeexpress.a aVar) {
        this.q = aVar;
    }

    public void a(TTNativeAd tTNativeAd) {
        this.k = tTNativeAd;
    }

    public void a(TTNativeExpressAd tTNativeExpressAd) {
        this.p = tTNativeExpressAd;
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar) {
        this.l = cVar;
    }

    public void a(a aVar) {
        this.j = aVar;
    }

    public void a(View view) {
        this.g = new WeakReference<>(view);
    }

    public void a(Map<String, Object> map) {
        this.o = map;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i, int i2, int i3, int i4) {
        h hVar;
        if (a(1)) {
            return;
        }
        if (this.f6003c == null) {
            this.f6003c = o.a();
        }
        if (this.f6003c == null) {
            return;
        }
        long j = this.v;
        long j2 = this.w;
        WeakReference<View> weakReference = this.g;
        View view2 = weakReference == null ? null : weakReference.get();
        WeakReference<View> weakReference2 = this.h;
        this.i = a(i, i2, i3, i4, j, j2, view2, weakReference2 == null ? null : weakReference2.get());
        a aVar = this.j;
        if (aVar != null) {
            aVar.a(view, -1);
        }
        boolean zR = this.f6004d.r();
        boolean zA = x.a(this.f6003c, this.f6004d, this.f6006f, this.k, this.p, zR ? this.f6005e : ab.a(this.f6006f), this.n, zR);
        if (zA || (hVar = this.f6004d) == null || hVar.L() == null || this.f6004d.L().c() != 2) {
            if (!zA && TextUtils.isEmpty(this.f6004d.A()) && "embeded_ad".equals(this.f6005e)) {
                b.a.a.a.a.a.c.a(this.f6003c, this.f6004d, this.f6005e).a();
            }
            com.bytedance.sdk.openadsdk.c.d.a(this.f6003c, "click", this.f6004d, this.i, this.f6005e, zA, this.o);
        }
    }

    protected com.bytedance.sdk.openadsdk.core.d.d a(int i, int i2, int i3, int i4, long j, long j2, View view, View view2) {
        return new d.a().d(i).c(i2).b(i3).a(i4).b(j).a(j2).b(ac.a(view)).a(ac.a(view2)).c(ac.c(view)).d(ac.c(view2)).e(this.x).f(this.y).g(this.z).a();
    }

    protected boolean a(int i) {
        if (this.q == null) {
            return false;
        }
        int[] iArrA = new int[2];
        int[] iArrC = new int[2];
        WeakReference<View> weakReference = this.h;
        if (weakReference != null) {
            iArrA = ac.a(weakReference.get());
            iArrC = ac.c(this.h.get());
        }
        this.q.a(i, new f.a().d(this.r).c(this.s).b(this.t).a(this.u).b(this.v).a(this.w).e(iArrA[0]).f(iArrA[1]).g(iArrC[0]).h(iArrC[1]).a());
        return true;
    }
}
