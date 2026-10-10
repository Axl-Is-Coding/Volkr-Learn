package com.bytedance.sdk.openadsdk.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.e;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.face.IHttpStack;
import com.bytedance.sdk.openadsdk.core.o;

/* JADX INFO: compiled from: TTNetClient.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile d f6808a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static IHttpStack f6809c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f6810b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private l f6811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.sdk.adnet.b.b f6812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private l f6813f;
    private l g;
    private com.bytedance.sdk.adnet.b.d h;
    private com.bytedance.sdk.openadsdk.g.a.b i;

    /* JADX INFO: compiled from: TTNetClient.java */
    static class a implements d.InterfaceC0070d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ImageView f6814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f6816c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f6817d;

        a(ImageView imageView, String str, int i, int i2) {
            this.f6814a = imageView;
            this.f6815b = str;
            this.f6816c = i;
            this.f6817d = i2;
            ImageView imageView2 = this.f6814a;
            if (imageView2 != null) {
                imageView2.setTag(1094453505, str);
            }
        }

        private boolean c() {
            Object tag;
            ImageView imageView = this.f6814a;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.f6815b)) ? false : true;
        }

        @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0070d
        public void a() {
            int i;
            ImageView imageView = this.f6814a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f6814a.getContext()).isFinishing()) || this.f6814a == null || !c() || (i = this.f6816c) == 0) {
                return;
            }
            this.f6814a.setImageResource(i);
        }

        @Override // com.bytedance.sdk.adnet.core.m.a
        public void a(m<Bitmap> mVar) {
        }

        @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0070d
        public void b() {
            this.f6814a = null;
        }

        @Override // com.bytedance.sdk.adnet.core.m.a
        public void b(m<Bitmap> mVar) {
            ImageView imageView = this.f6814a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f6814a.getContext()).isFinishing()) || this.f6814a == null || this.f6817d == 0 || !c()) {
                return;
            }
            this.f6814a.setImageResource(this.f6817d);
        }

        @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0070d
        public void a(d.c cVar, boolean z) {
            ImageView imageView = this.f6814a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f6814a.getContext()).isFinishing()) || this.f6814a == null || !c() || cVar.a() == null) {
                return;
            }
            this.f6814a.setImageBitmap(cVar.a());
        }
    }

    private d(Context context) {
        this.f6810b = context == null ? o.a() : context.getApplicationContext();
    }

    public static IHttpStack a() {
        return f6809c;
    }

    public static e b() {
        return new e();
    }

    private void h() {
        if (this.i == null) {
            k();
            this.i = new com.bytedance.sdk.openadsdk.g.a.b(this.g);
        }
    }

    private void i() {
        if (this.h == null) {
            k();
            this.h = new com.bytedance.sdk.adnet.b.d(this.g, com.bytedance.sdk.openadsdk.g.a.a());
        }
    }

    private void j() {
        if (this.f6811d == null) {
            this.f6811d = com.bytedance.sdk.adnet.a.a(this.f6810b, a());
        }
    }

    private void k() {
        if (this.g == null) {
            this.g = com.bytedance.sdk.adnet.a.a(this.f6810b);
        }
    }

    public l c() {
        j();
        return this.f6811d;
    }

    public l d() {
        k();
        return this.g;
    }

    public l e() {
        if (this.f6813f == null) {
            this.f6813f = com.bytedance.sdk.adnet.a.a(this.f6810b);
        }
        return this.f6813f;
    }

    public com.bytedance.sdk.openadsdk.g.a.b f() {
        h();
        return this.i;
    }

    public com.bytedance.sdk.adnet.b.d g() {
        i();
        return this.h;
    }

    public static void a(IHttpStack iHttpStack) {
        f6809c = iHttpStack;
    }

    public static d a(Context context) {
        if (f6808a == null) {
            synchronized (d.class) {
                if (f6808a == null) {
                    f6808a = new d(context);
                }
            }
        }
        return f6808a;
    }

    public void a(String str, b.a aVar) {
        j();
        if (this.f6812e == null) {
            this.f6812e = new com.bytedance.sdk.adnet.b.b(this.f6810b, this.f6811d);
        }
        this.f6812e.a(str, aVar);
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, a(str, imageView, 0, 0));
    }

    public void a(String str, ImageView imageView, d.InterfaceC0070d interfaceC0070d) {
        i();
        this.h.a(str, interfaceC0070d);
    }

    public static a a(String str, ImageView imageView, int i, int i2) {
        return new a(imageView, str, i, i2);
    }
}
