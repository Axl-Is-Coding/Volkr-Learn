package com.bytedance.sdk.openadsdk.component.banner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTBannerAd;
import com.bytedance.sdk.openadsdk.component.banner.b;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.o;
import com.sandboxol.center.config.IntConstant;
import java.util.Map;

/* JADX INFO: compiled from: TTBannerAdImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements TTBannerAd, ad.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f5843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f5844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f5845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ad f5846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private h f5848f;
    private TTBannerAd.AdInteractionListener g;
    private com.bytedance.sdk.openadsdk.dislike.b h;
    private final b i;
    private b.a.a.a.a.a.b j;
    private String k = "banner_ad";
    private AdSlot l;

    public e(Context context, a aVar, AdSlot adSlot) {
        this.f5845c = context;
        this.f5844b = aVar;
        this.l = adSlot;
        this.f5848f = aVar.b();
        this.f5843a = new d(context);
        this.i = b.a(this.f5845c);
        a(this.f5843a.b(), aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public View getBannerView() {
        return this.f5843a;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public TTAdDislike getDislikeDialog(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null) {
            return null;
        }
        b(dislikeInteractionCallback);
        return this.h;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public int getInteractionType() {
        h hVar = this.f5848f;
        if (hVar == null) {
            return -1;
        }
        return hVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public Map<String, Object> getMediaExtraInfo() {
        h hVar = this.f5848f;
        if (hVar != null) {
            return hVar.T();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setBannerInteractionListener(TTBannerAd.AdInteractionListener adInteractionListener) {
        this.g = adInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null) {
            return;
        }
        a(dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setSlideIntervalTime(int i) {
        if (i <= 0) {
            return;
        }
        this.k = "slide_banner_ad";
        a(this.f5843a.b(), this.f5844b);
        this.f5843a.a();
        this.f5843a.a(1000);
        if (i < 30000) {
            i = 30000;
        } else if (i > 120000) {
            i = IntConstant.ADS_INTERVAL;
        }
        this.f5847e = i;
        this.f5846d = new ad(Looper.getMainLooper(), this);
    }

    private void b(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.h == null) {
            this.h = new com.bytedance.sdk.openadsdk.dislike.b(this.f5845c, this.f5848f);
        }
        this.h.setDislikeInteractionCallback(dislikeInteractionCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ad adVar = this.f5846d;
        if (adVar != null) {
            adVar.removeCallbacksAndMessages(null);
        }
    }

    private void a(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        b(dislikeInteractionCallback);
        this.f5843a.a(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ad adVar = this.f5846d;
        if (adVar != null) {
            adVar.removeCallbacksAndMessages(null);
            this.f5846d.sendEmptyMessageDelayed(1, this.f5847e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    public void a(Message message) {
        if (message.what == 1) {
            a();
        }
    }

    private void a() {
        this.i.a(this.l, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.banner.e.1
            @Override // com.bytedance.sdk.openadsdk.component.banner.b.a
            public void a(a aVar) {
                e.this.a(aVar);
                e.this.f5843a.e();
                e.this.b();
            }

            @Override // com.bytedance.sdk.openadsdk.component.banner.b.a
            public void a() {
                e.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (this.f5843a.c() == null || this.f5843a.f()) {
            return;
        }
        a(this.f5843a.c(), aVar);
    }

    private b.a.a.a.a.a.b a(h hVar) {
        if (hVar.x() == 4) {
            return b.a.a.a.a.a.c.a(this.f5845c, hVar, this.k);
        }
        return null;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(c cVar, a aVar) {
        cVar.a(aVar.a());
        final h hVarB = aVar.b();
        this.f5848f = hVarB;
        this.h = new com.bytedance.sdk.openadsdk.dislike.b(this.f5845c, this.f5848f);
        cVar.a(hVarB);
        this.j = a(hVarB);
        com.bytedance.sdk.openadsdk.c.d.a(hVarB);
        EmptyView emptyViewA = a(cVar);
        if (emptyViewA == null) {
            emptyViewA = new EmptyView(this.f5845c, cVar);
            cVar.addView(emptyViewA);
        }
        emptyViewA.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.component.banner.e.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                if (z) {
                    e.this.b();
                    o.b("TTBannerAd", "获得焦点，开始计时");
                } else {
                    o.b("TTBannerAd", "失去焦点，停止计时");
                    e.this.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                e.this.c();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                e.this.b();
                o.b("TTBannerAd", "BANNER SHOW");
                com.bytedance.sdk.openadsdk.c.d.a(e.this.f5845c, hVarB, e.this.k, (Map<String, Object>) null);
                if (e.this.g != null) {
                    e.this.g.onAdShow(view, hVarB.x());
                }
                if (hVarB.R()) {
                    ab.a(hVarB, view);
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(this.f5845c, hVarB, this.k, 2);
        aVar2.a(cVar);
        aVar2.b(this.f5843a.d());
        aVar2.a(this.j);
        aVar2.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.component.banner.e.3
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i) {
                if (e.this.g != null) {
                    e.this.g.onAdClicked(view, i);
                }
            }
        });
        cVar.setOnClickListener(aVar2);
        cVar.setOnTouchListener(aVar2);
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
