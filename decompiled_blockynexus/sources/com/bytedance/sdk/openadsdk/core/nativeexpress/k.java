package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TTNativeExpressAdImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected NativeExpressView f6316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f6317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.d.h f6318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f6319d = "embeded_ad";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TTNativeExpressAd.ExpressAdInteractionListener f6320f;
    private TTAdDislike.DislikeInteractionCallback g;
    private com.bytedance.sdk.openadsdk.dislike.b h;
    private TTDislikeDialogAbstract i;
    private b.a.a.a.a.a.b j;

    public k(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
        this.f6317b = context;
        this.f6318c = hVar;
        a(context, hVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        NativeExpressView nativeExpressView = this.f6316a;
        if (nativeExpressView != null) {
            nativeExpressView.k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.f6316a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public List<FilterWord> getFilterWords() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f6318c;
        if (hVar == null) {
            return null;
        }
        return hVar.O();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f6318c;
        if (hVar == null) {
            return -1;
        }
        return hVar.N();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f6318c;
        if (hVar == null) {
            return -1;
        }
        return hVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f6318c;
        if (hVar != null) {
            return hVar.T();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.f6316a.h();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null || activity == null) {
            return;
        }
        this.g = dislikeInteractionCallback;
        a(activity, dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            o.b("dialog is null, please check");
            return;
        }
        this.i = tTDislikeDialogAbstract;
        tTDislikeDialogAbstract.setMaterialMeta(this.f6318c);
        NativeExpressView nativeExpressView = this.f6316a;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f6320f = expressAdInteractionListener;
        this.f6316a.setExpressInteractionListener(expressAdInteractionListener);
    }

    public void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
        this.f6316a = new NativeExpressView(context, hVar, adSlot, this.f6319d);
        a(this.f6316a, this.f6318c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.f6320f = adInteractionListener;
        this.f6316a.setExpressInteractionListener(adInteractionListener);
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.h == null) {
            this.h = new com.bytedance.sdk.openadsdk.dislike.b(activity, this.f6318c);
        }
        this.h.setDislikeInteractionCallback(dislikeInteractionCallback);
        NativeExpressView nativeExpressView = this.f6316a;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.h);
        }
    }

    private b.a.a.a.a.a.b a(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        if (hVar.x() == 4) {
            return b.a.a.a.a.a.c.a(this.f6317b, hVar, this.f6319d);
        }
        return null;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void a(NativeExpressView nativeExpressView, final com.bytedance.sdk.openadsdk.core.d.h hVar) {
        this.f6318c = hVar;
        nativeExpressView.setBackupListener(new c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView2, int i) {
                nativeExpressView2.l();
                h hVar2 = new h(nativeExpressView2.getContext());
                k kVar = k.this;
                hVar2.a(kVar.f6318c, nativeExpressView2, kVar.j);
                hVar2.setDislikeInner(k.this.h);
                hVar2.setDislikeOuter(k.this.i);
                return true;
            }
        });
        this.j = a(hVar);
        com.bytedance.sdk.openadsdk.c.d.a(hVar);
        EmptyView emptyViewA = a(nativeExpressView);
        if (emptyViewA == null) {
            emptyViewA = new EmptyView(this.f6317b, nativeExpressView);
            nativeExpressView.addView(emptyViewA);
        }
        emptyViewA.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                k kVar;
                NativeExpressView nativeExpressView2;
                o.b("TTNativeExpressAd", "ExpressView SHOW");
                HashMap map = new HashMap();
                map.put("dynamic_show_type", Integer.valueOf(k.this.f6316a.m() ? 1 : 0));
                k kVar2 = k.this;
                com.bytedance.sdk.openadsdk.c.d.a(kVar2.f6317b, hVar, kVar2.f6319d, map);
                if (k.this.f6320f != null) {
                    k.this.f6320f.onAdShow(view, hVar.x());
                }
                if (hVar.R()) {
                    ab.a(hVar, view);
                }
                if (!k.this.f6324e.getAndSet(true) && (nativeExpressView2 = (kVar = k.this).f6316a) != null) {
                    ac.a(kVar.f6317b, kVar.f6318c, kVar.f6319d, nativeExpressView2.getWebView());
                }
                NativeExpressView nativeExpressView3 = k.this.f6316a;
                if (nativeExpressView3 != null) {
                    nativeExpressView3.i();
                    k.this.f6316a.g();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
            }
        });
        Context context = this.f6317b;
        String str = this.f6319d;
        e eVar = new e(context, hVar, str, ab.a(str));
        eVar.a(nativeExpressView);
        eVar.a(this.j);
        eVar.a(this);
        this.f6316a.setClickListener(eVar);
        Context context2 = this.f6317b;
        String str2 = this.f6319d;
        d dVar = new d(context2, hVar, str2, ab.a(str2));
        dVar.a(nativeExpressView);
        dVar.a(this.j);
        dVar.a(this);
        this.f6316a.setClickCreativeListener(dVar);
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
}
