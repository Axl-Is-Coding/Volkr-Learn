package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.b;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.o;
import com.sandboxol.center.config.IntConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TTBannerExpressAdImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends l implements ad.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    TTDislikeDialogAbstract f6028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f6029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f6030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h f6031d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AdSlot f6032f;
    private TTNativeExpressAd.ExpressAdInteractionListener g;
    private com.bytedance.sdk.openadsdk.dislike.b h;
    private b.a.a.a.a.a.b i;
    private ad j;
    private int k;
    private TTAdDislike.DislikeInteractionCallback l;
    private Context m;
    private String n = "banner_ad";

    public b(Context context, h hVar, AdSlot adSlot) {
        this.f6030c = context;
        this.f6031d = hVar;
        this.f6032f = adSlot;
        this.f6029b = new a(context, hVar, adSlot);
        b(this.f6029b.c(), this.f6031d);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        a aVar = this.f6029b;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.f6029b;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public List<FilterWord> getFilterWords() {
        h hVar = this.f6031d;
        if (hVar == null) {
            return null;
        }
        return hVar.O();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        h hVar = this.f6031d;
        if (hVar == null) {
            return -1;
        }
        return hVar.N();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        h hVar = this.f6031d;
        if (hVar == null) {
            return -1;
        }
        return hVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        h hVar = this.f6031d;
        if (hVar != null) {
            return hVar.T();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.f6029b.a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null || activity == null) {
            return;
        }
        this.l = dislikeInteractionCallback;
        a(activity, dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            o.b("dialog is null, please check");
            return;
        }
        this.f6028a = tTDislikeDialogAbstract;
        tTDislikeDialogAbstract.setMaterialMeta(this.f6031d);
        a aVar = this.f6029b;
        if (aVar == null || aVar.c() == null) {
            return;
        }
        this.f6029b.c().setOuterDislike(tTDislikeDialogAbstract);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.g = expressAdInteractionListener;
        this.f6029b.a(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setSlideIntervalTime(int i) {
        if (i <= 0) {
            return;
        }
        this.n = "slide_banner_ad";
        b(this.f6029b.c(), this.f6031d);
        this.f6029b.a(1000);
        if (i < 30000) {
            i = 30000;
        } else if (i > 120000) {
            i = IntConstant.ADS_INTERVAL;
        }
        this.k = i;
        this.j = new ad(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ad adVar = this.j;
        if (adVar != null) {
            adVar.removeCallbacksAndMessages(null);
        }
    }

    private void c() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f6030c).a(this.f6032f, 1, null, new b.a() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.3
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.a
            public void a(List<h> list) {
                h hVar = list == null ? null : list.get(0);
                b.this.f6029b.a(hVar, b.this.f6032f);
                b.this.b(hVar);
                b.this.f6029b.e();
                b.this.a();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.a
            public void a() {
                b.this.a();
            }
        }, 5000);
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.h == null) {
            this.h = new com.bytedance.sdk.openadsdk.dislike.b(activity, this.f6031d);
        }
        this.m = activity;
        this.h.setDislikeInteractionCallback(dislikeInteractionCallback);
        a aVar = this.f6029b;
        if (aVar == null || aVar.c() == null) {
            return;
        }
        this.f6029b.c().setDislike(this.h);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.g = adInteractionListener;
        this.f6029b.a(adInteractionListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(h hVar) {
        if (this.f6029b.d() == null || !this.f6029b.f()) {
            return;
        }
        a(this.f6029b.d(), hVar);
        b(this.f6029b.d(), hVar);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void b(final NativeExpressView nativeExpressView, final h hVar) {
        if (nativeExpressView == null || hVar == null) {
            return;
        }
        this.f6031d = hVar;
        this.i = a(hVar);
        nativeExpressView.setBackupListener(new c() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView2, int i) {
                nativeExpressView2.l();
                BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(nativeExpressView2.getContext());
                bannerExpressBackupView.a(b.this.f6031d, nativeExpressView2, b.this.i);
                bannerExpressBackupView.setDislikeInner(b.this.h);
                bannerExpressBackupView.setDislikeOuter(b.this.f6028a);
                return true;
            }
        });
        d.a(hVar);
        EmptyView emptyViewA = a(nativeExpressView);
        if (emptyViewA == null) {
            emptyViewA = new EmptyView(this.f6030c, nativeExpressView);
            nativeExpressView.addView(emptyViewA);
        }
        emptyViewA.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                if (z) {
                    b.this.a();
                    o.b("TTBannerExpressAd", "获得焦点，开始计时");
                } else {
                    o.b("TTBannerExpressAd", "失去焦点，停止计时");
                    b.this.b();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                o.b("TTBannerExpressAd", "ExpressView SHOW");
                HashMap map = new HashMap();
                map.put("dynamic_show_type", Integer.valueOf(nativeExpressView.m() ? 1 : 0));
                d.a(b.this.f6030c, hVar, b.this.n, map);
                if (b.this.g != null) {
                    b.this.g.onAdShow(view, hVar.x());
                }
                if (hVar.R()) {
                    ab.a(hVar, view);
                }
                b.this.a();
                if (!b.this.f6324e.getAndSet(true) && b.this.f6029b != null && b.this.f6029b.c() != null) {
                    ac.a(b.this.f6030c, b.this.f6031d, b.this.n, b.this.f6029b.c().getWebView());
                }
                if (b.this.f6029b == null || b.this.f6029b.c() == null) {
                    return;
                }
                b.this.f6029b.c().i();
                b.this.f6029b.c().g();
            }
        });
        e eVar = new e(this.f6030c, hVar, this.n, 2);
        eVar.a(nativeExpressView);
        eVar.a(this.i);
        nativeExpressView.setClickListener(eVar);
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.f6030c, hVar, this.n, 2);
        dVar.a(nativeExpressView);
        dVar.a(this.i);
        nativeExpressView.setClickCreativeListener(dVar);
        emptyViewA.setNeedCheckingShow(true);
    }

    private b.a.a.a.a.a.b a(h hVar) {
        if (hVar.x() == 4) {
            return b.a.a.a.a.a.c.a(this.f6030c, hVar, this.n);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ad adVar = this.j;
        if (adVar != null) {
            adVar.removeCallbacksAndMessages(null);
            this.j.sendEmptyMessageDelayed(112201, this.k);
        }
    }

    private void a(NativeExpressView nativeExpressView, h hVar) {
        if (nativeExpressView == null || hVar == null) {
            return;
        }
        if (this.l != null) {
            this.h.a(hVar);
            if (nativeExpressView != null) {
                nativeExpressView.setDislike(this.h);
            }
        }
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f6028a;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.setMaterialMeta(hVar);
            if (nativeExpressView != null) {
                nativeExpressView.setOuterDislike(this.f6028a);
            }
        }
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

    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    public void a(Message message) {
        if (message.what == 112201) {
            c();
        }
    }
}
