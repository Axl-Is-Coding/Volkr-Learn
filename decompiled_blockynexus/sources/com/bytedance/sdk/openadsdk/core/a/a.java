package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: ClickCreativeListener.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends b {
    private boolean A;
    private TTDrawFeedAd.DrawVideoListener B;
    private int C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6002b;

    public a(Context context, h hVar, String str, int i) {
        super(context, hVar, str, i);
        this.f6001a = true;
        this.f6002b = false;
        this.A = false;
    }

    private boolean c(View view) {
        if (view == null) {
            return false;
        }
        if (view instanceof NativeVideoTsView) {
            o.c("ClickCreativeListener", "NativeVideoTsView....");
            return true;
        }
        if (view.getId() == t.e(this.f6003c, "tt_video_ad_cover_center_layout") || view.getId() == t.e(this.f6003c, "tt_video_ad_logo_image") || view.getId() == t.e(this.f6003c, "tt_video_btn_ad_image_tv") || view.getId() == t.e(this.f6003c, "tt_video_ad_name") || view.getId() == t.e(this.f6003c, "tt_video_ad_button")) {
            o.c("ClickCreativeListener", "tt_video_ad_cover_center_layout....");
            return true;
        }
        if (view.getId() == t.e(this.f6003c, "tt_root_view") || view.getId() == t.e(this.f6003c, "tt_video_play")) {
            o.c("ClickCreativeListener", "tt_root_view....");
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return false;
            }
            if (c(viewGroup.getChildAt(i))) {
                return true;
            }
            i++;
        }
    }

    private boolean d() {
        h hVar = this.f6004d;
        return hVar != null && hVar.e() == 1 && (this.f6004d.N() == 5 || this.f6004d.N() == 15);
    }

    private boolean e() {
        return this instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.d;
    }

    private boolean f() {
        if (this.f6004d == null || e()) {
            return false;
        }
        if (this.f6004d.N() != 5 && this.f6004d.N() != 15) {
            return false;
        }
        if (this.C == 0) {
            this.C = ab.c(this.f6004d.M());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("!isViewVisibility()=");
        sb.append(!b());
        sb.append(",isAutoPlay()=");
        sb.append(a());
        sb.append(",!isCoverPageVisibility()=");
        sb.append(!c());
        o.b("ClickCreativeListener", sb.toString());
        if (this.C == 5 && d() && a() && !b() && !c()) {
            return false;
        }
        int i = this.C;
        return i == 1 || i == 2 || i == 5;
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.B = drawVideoListener;
    }

    public void b(boolean z) {
        this.f6002b = z;
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public void a(boolean z) {
        this.f6001a = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i, int i2, int i3, int i4) {
        TTDrawFeedAd.DrawVideoListener drawVideoListener;
        if (a(2)) {
            return;
        }
        if (f() && c(view) && !this.A) {
            o.b("ClickCreativeListener", "拦截原生视频view走普通点击事件.....");
            super.a(view, i, i2, i3, i4);
            return;
        }
        o.b("ClickCreativeListener", "走创意区域点击事件.....");
        if (this.f6003c == null) {
            this.f6003c = com.bytedance.sdk.openadsdk.core.o.a();
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
        int iX = this.f6004d.x();
        if (iX == 2 || iX == 3) {
            if (this.k != null || this.f6002b) {
                com.bytedance.sdk.openadsdk.c.d.a(this.f6003c, "click_button", this.f6004d, this.i, this.f6005e, true, this.o);
            }
            x.a(true);
            Context context = this.f6003c;
            h hVar = this.f6004d;
            int i5 = this.f6006f;
            boolean zA = x.a(context, hVar, i5, this.k, this.p, ab.a(i5), this.n, true);
            if (this.f6001a) {
                com.bytedance.sdk.openadsdk.c.d.a(this.f6003c, "click", this.f6004d, this.i, this.f6005e, zA, this.o);
            }
        } else if (iX != 4) {
            if (iX != 5) {
                iX = -1;
            } else {
                String strA = a(this.f6005e);
                if (!TextUtils.isEmpty(strA)) {
                    com.bytedance.sdk.openadsdk.c.d.a(this.f6003c, "click_call", this.f6004d, this.i, strA, true, this.o);
                }
                com.bytedance.sdk.openadsdk.c.d.a(this.f6003c, "click", this.f6004d, this.i, this.f6005e, ab.d(view.getContext(), this.f6004d.C()), this.o);
            }
        } else if (this.f6004d.r() && (this.k != null || this.p != null)) {
            boolean zA2 = x.a(this.f6003c, this.f6004d, this.f6006f, this.k, this.p, this.f6005e, this.n, true);
            if (this.f6001a) {
                com.bytedance.sdk.openadsdk.c.d.a(this.f6003c, "click", this.f6004d, this.i, this.f6005e, zA2, this.o);
            }
        } else {
            b.a.a.a.a.a.b bVar = this.n;
            if (bVar != null) {
                bVar.a();
                if (this.f6001a) {
                    com.bytedance.sdk.openadsdk.c.d.a(this.f6003c, "click", this.f6004d, this.i, this.f6005e, true, this.o);
                }
            }
        }
        b.a aVar = this.j;
        if (aVar != null) {
            aVar.a(view, iX);
        }
        if (!ab.a(this.f6004d) || (drawVideoListener = this.B) == null) {
            return;
        }
        drawVideoListener.onClick();
    }

    public void c(boolean z) {
        this.A = z;
    }

    protected boolean a() {
        h hVar = this.f6004d;
        if (hVar == null) {
            return true;
        }
        int iC = com.bytedance.sdk.openadsdk.core.o.h().c(ab.d(hVar.M()));
        if (iC == 1) {
            return q.d(this.f6003c);
        }
        if (iC == 2) {
            return q.e(this.f6003c) || q.d(this.f6003c);
        }
        if (iC == 3) {
            return false;
        }
        if (iC != 4) {
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            java.lang.String r1 = "splash_ad"
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r0) {
                case -1695837674: goto L3f;
                case -712491894: goto L35;
                case 174971131: goto L2d;
                case 1844104722: goto L23;
                case 1912999166: goto L19;
                case 2091589896: goto Lf;
                default: goto Le;
            }
        Le:
            goto L49
        Lf:
            java.lang.String r0 = "slide_banner_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L49
            r8 = 3
            goto L4a
        L19:
            java.lang.String r0 = "draw_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L49
            r8 = 1
            goto L4a
        L23:
            java.lang.String r0 = "interaction"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L49
            r8 = 4
            goto L4a
        L2d:
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L49
            r8 = 5
            goto L4a
        L35:
            java.lang.String r0 = "embeded_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L49
            r8 = 0
            goto L4a
        L3f:
            java.lang.String r0 = "banner_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L49
            r8 = 2
            goto L4a
        L49:
            r8 = -1
        L4a:
            if (r8 == 0) goto L60
            if (r8 == r6) goto L60
            java.lang.String r0 = "banner_call"
            if (r8 == r5) goto L5f
            if (r8 == r4) goto L5f
            if (r8 == r3) goto L5c
            if (r8 == r2) goto L5b
            java.lang.String r8 = ""
            return r8
        L5b:
            return r1
        L5c:
            java.lang.String r8 = "interaction_call"
            return r8
        L5f:
            return r0
        L60:
            java.lang.String r8 = "feed_call"
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.a.a.a(java.lang.String):java.lang.String");
    }
}
