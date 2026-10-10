package com.bytedance.sdk.openadsdk.core.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import b.a.a.a.a.a.c;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TTInteractionExpressAdImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    a f6042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NativeExpressView f6043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f6044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h f6045d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TTNativeExpressAd.ExpressAdInteractionListener f6046f;
    private TTNativeExpressAd.AdInteractionListener g;
    private com.bytedance.sdk.openadsdk.dislike.b h;
    private b.a.a.a.a.a.b i;
    private Dialog j;
    private FrameLayout k;
    private String l = "interaction";

    public b(Context context, h hVar, AdSlot adSlot) {
        this.f6044c = context;
        this.f6045d = hVar;
        this.f6043b = new NativeExpressView(context, hVar, adSlot, this.l);
        a(this.f6043b, this.f6045d);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        NativeExpressView nativeExpressView = this.f6043b;
        if (nativeExpressView != null) {
            nativeExpressView.k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.f6043b;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public List<FilterWord> getFilterWords() {
        h hVar = this.f6045d;
        if (hVar == null) {
            return null;
        }
        return hVar.O();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        h hVar = this.f6045d;
        if (hVar == null) {
            return -1;
        }
        return hVar.N();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        h hVar = this.f6045d;
        if (hVar == null) {
            return -1;
        }
        return hVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        h hVar = this.f6045d;
        if (hVar != null) {
            return hVar.T();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.f6043b.h();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null || activity == null) {
            return;
        }
        a(activity, dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            o.b("dialog is null, please check");
            return;
        }
        tTDislikeDialogAbstract.setMaterialMeta(this.f6045d);
        NativeExpressView nativeExpressView = this.f6043b;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f6046f = expressAdInteractionListener;
        this.f6043b.setExpressInteractionListener(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void showInteractionExpressAd(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            o.b("can't invoke in child thread TTInteractionExpressAd.showInteractionAd");
        } else {
            a(activity);
        }
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.h == null) {
            this.h = new com.bytedance.sdk.openadsdk.dislike.b(activity, this.f6045d);
        }
        this.h.setDislikeInteractionCallback(dislikeInteractionCallback);
        NativeExpressView nativeExpressView = this.f6043b;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.h);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.g = adInteractionListener;
        this.f6046f = adInteractionListener;
        this.f6043b.setExpressInteractionListener(adInteractionListener);
    }

    private b.a.a.a.a.a.b a(h hVar) {
        if (hVar.x() == 4) {
            return c.a(this.f6044c, hVar, this.l);
        }
        return null;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(NativeExpressView nativeExpressView, final h hVar) {
        this.f6045d = hVar;
        this.f6043b.setBackupListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c() { // from class: com.bytedance.sdk.openadsdk.core.c.b.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView2, int i) {
                b.this.f6043b.l();
                b.this.f6042a = new a(nativeExpressView2.getContext());
                b bVar = b.this;
                bVar.f6042a.a(bVar.f6045d, b.this.f6043b, b.this.i);
                return true;
            }
        });
        this.i = a(hVar);
        d.a(hVar);
        EmptyView emptyViewA = a(nativeExpressView);
        if (emptyViewA == null) {
            emptyViewA = new EmptyView(this.f6044c, nativeExpressView);
            nativeExpressView.addView(emptyViewA);
        }
        emptyViewA.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.c.b.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                o.b("TTInteractionExpressAd", "ExpressView onWindowFocusChanged=" + z);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                o.b("TTInteractionExpressAd", "ExpressView SHOW");
                HashMap map = new HashMap();
                map.put("dynamic_show_type", Integer.valueOf(b.this.f6043b.m() ? 1 : 0));
                d.a(b.this.f6044c, hVar, b.this.l, map);
                if (b.this.f6046f != null) {
                    b.this.f6046f.onAdShow(view, hVar.x());
                }
                if (hVar.R()) {
                    ab.a(hVar, view);
                }
                if (!b.this.f6324e.getAndSet(true) && b.this.f6043b != null) {
                    ac.a(b.this.f6044c, b.this.f6045d, b.this.l, b.this.f6043b.getWebView());
                }
                if (b.this.f6043b != null) {
                    b.this.f6043b.i();
                    b.this.f6043b.g();
                }
            }
        });
        e eVar = new e(this.f6044c, hVar, this.l, 3);
        eVar.a(nativeExpressView);
        eVar.a(this.i);
        this.f6043b.setClickListener(eVar);
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.f6044c, hVar, this.l, 3);
        dVar.a(nativeExpressView);
        dVar.a(this.i);
        dVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.core.c.b.3
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i) {
                if (i == 2 || i == 3 || i == 5) {
                    b.this.a();
                }
            }
        });
        this.f6043b.setClickCreativeListener(dVar);
        emptyViewA.setNeedCheckingShow(true);
    }

    private EmptyView a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    private void a(Activity activity) {
        if (this.j == null) {
            this.j = new m(activity);
            this.j.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.c.b.4
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            });
            ((m) this.j).a(true, new m.a() { // from class: com.bytedance.sdk.openadsdk.core.c.b.5
                @Override // com.bytedance.sdk.openadsdk.core.m.a
                public void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout) {
                    b.this.k = frameLayout;
                    b.this.k.addView(b.this.f6043b, new FrameLayout.LayoutParams(-1, -1));
                }

                @Override // com.bytedance.sdk.openadsdk.core.m.a
                public void a(View view) {
                    b.this.a();
                    d.a(b.this.f6044c, b.this.f6045d, "interaction");
                    if (b.this.g != null) {
                        b.this.g.onAdDismiss();
                    }
                    o.b("TTInteractionExpressAd", "dislike事件发出");
                }
            });
        }
        a aVar = this.f6042a;
        if (aVar != null) {
            aVar.a(this.j);
        }
        if (this.j.isShowing()) {
            return;
        }
        this.j.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Dialog dialog = this.j;
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
