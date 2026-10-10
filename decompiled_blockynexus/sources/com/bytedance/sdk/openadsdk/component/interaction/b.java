package com.bytedance.sdk.openadsdk.component.interaction;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import b.a.a.a.a.a.c;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.TTInteractionAd;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.o;
import java.util.Map;

/* JADX INFO: compiled from: TTInteractionAdImpl.java */
/* JADX INFO: loaded from: classes.dex */
class b implements TTInteractionAd {
    private static boolean i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f5860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Dialog f5861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TTInteractionAd.AdInteractionListener f5862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b.a.a.a.a.a.b f5863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private k f5864f;
    private ImageView g;
    private ImageView h;

    b(Context context, h hVar) {
        this.f5859a = context;
        this.f5860b = hVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public int getInteractionType() {
        h hVar = this.f5860b;
        if (hVar == null) {
            return -1;
        }
        return hVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public Map<String, Object> getMediaExtraInfo() {
        h hVar = this.f5860b;
        if (hVar != null) {
            return hVar.T();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setAdInteractionListener(TTInteractionAd.AdInteractionListener adInteractionListener) {
        this.f5862d = adInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void showInteractionAd(Activity activity) {
        if (activity.isFinishing()) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("can't not running in child thread >>> TTInteractionAd.showInteractionAd");
        }
        if (i) {
            return;
        }
        i = true;
        this.f5861c.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int iB = this.f5860b.B().get(0).b();
        d.a(this.f5859a).g().a(this.f5860b.B().get(0).a(), new d.InterfaceC0070d() { // from class: com.bytedance.sdk.openadsdk.component.interaction.b.5
            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0070d
            public void a() {
            }

            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0070d
            public void a(d.c cVar, boolean z) {
                if (cVar == null || cVar.a() == null) {
                    if (b.this.f5864f != null) {
                        b.this.f5864f.b();
                    }
                } else {
                    b.this.h.setImageBitmap(cVar.a());
                    if (b.this.f5864f != null) {
                        b.this.f5864f.a();
                    }
                }
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void a(m<Bitmap> mVar) {
            }

            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0070d
            public void b() {
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void b(m<Bitmap> mVar) {
                if (b.this.f5864f != null) {
                    b.this.f5864f.b();
                }
            }
        }, iB, iB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        i = false;
        this.f5861c.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void b() {
        com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(this.f5859a, this.f5860b, "interaction", 3);
        aVar.a(this.h);
        aVar.b(this.g);
        aVar.a(this.f5863e);
        aVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.component.interaction.b.4
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i2) {
                if (b.this.f5862d != null) {
                    b.this.f5862d.onAdClicked();
                }
                if (i2 == 2 || i2 == 3 || i2 == 5) {
                    b.this.d();
                    if (b.this.f5862d != null) {
                        b.this.f5862d.onAdDismiss();
                    }
                }
            }
        });
        this.h.setOnClickListener(aVar);
        this.h.setOnTouchListener(aVar);
    }

    void a(k kVar) {
        this.f5864f = kVar;
        com.bytedance.sdk.openadsdk.c.d.a(this.f5860b);
        if (getInteractionType() == 4) {
            this.f5863e = c.a(this.f5859a, this.f5860b, "interaction");
        }
        a();
    }

    private void a() {
        if (this.f5861c == null) {
            this.f5861c = new com.bytedance.sdk.openadsdk.core.m(this.f5859a);
            this.f5861c.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.sdk.openadsdk.component.interaction.b.1
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    if (b.this.f5861c.isShowing()) {
                        com.bytedance.sdk.openadsdk.c.d.a(b.this.f5859a, b.this.f5860b, "interaction", (Map<String, Object>) null);
                        if (b.this.f5862d != null) {
                            b.this.f5862d.onAdShow();
                        }
                        if (b.this.f5860b.R()) {
                            ab.a(b.this.f5860b, b.this.h);
                        }
                    }
                }
            });
            this.f5861c.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.component.interaction.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            });
            ((com.bytedance.sdk.openadsdk.core.m) this.f5861c).a(false, new m.a() { // from class: com.bytedance.sdk.openadsdk.component.interaction.b.3
                @Override // com.bytedance.sdk.openadsdk.core.m.a
                public void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout) {
                    b.this.h = imageView;
                    b.this.g = imageView2;
                    b.this.b();
                    b.this.c();
                }

                @Override // com.bytedance.sdk.openadsdk.core.m.a
                public void a(View view) {
                    b.this.d();
                    com.bytedance.sdk.openadsdk.c.d.a(b.this.f5859a, b.this.f5860b, "interaction");
                    if (b.this.f5862d != null) {
                        b.this.f5862d.onAdDismiss();
                    }
                    o.b("TTInteractionAdImpl", "dislike事件发出");
                }
            });
        }
    }
}
