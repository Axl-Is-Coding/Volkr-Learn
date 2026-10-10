package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.o;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTFullScreenVideoAdImpl.java */
/* JADX INFO: loaded from: classes.dex */
class i implements TTFullScreenVideoAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.d.h f5942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AdSlot f5943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f5944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b.a.a.a.a.a.b f5945e;
    private boolean g;
    private String h;
    private String i;
    private String l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5946f = true;
    private AtomicBoolean j = new AtomicBoolean(false);
    private boolean k = false;

    i(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
        this.f5941a = context;
        this.f5942b = hVar;
        this.f5943c = adSlot;
        if (getInteractionType() == 4) {
            this.f5945e = b.a.a.a.a.a.c.a(this.f5941a, this.f5942b, "fullscreen_interstitial_ad");
        }
        this.g = false;
        this.l = com.bytedance.sdk.openadsdk.utils.h.a(this.f5942b.hashCode() + this.f5942b.Z().toString());
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f5942b;
        if (hVar == null) {
            return -1;
        }
        if (hVar.r() && this.f5942b.c() == 1) {
            return 2;
        }
        return (this.f5942b.r() && this.f5942b.c() == 0) ? 1 : 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f5942b;
        if (hVar == null) {
            return -1;
        }
        return hVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f5942b;
        if (hVar != null) {
            return hVar.T();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f5944d = fullScreenVideoAdInteractionListener;
        a(1);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setShowDownLoadBar(boolean z) {
        this.f5946f = z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        if (activity != null && activity.isFinishing()) {
            o.e("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
            activity = null;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            o.e("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error2: not main looper");
            throw new IllegalStateException("不能在子线程调用 TTFullScreenVideoAd.showFullScreenVideoAd");
        }
        if (this.j.get()) {
            return;
        }
        this.j.set(true);
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f5942b;
        if (hVar == null || hVar.v() == null) {
            return;
        }
        Context contextA = activity == null ? this.f5941a : activity;
        if (contextA == null) {
            contextA = com.bytedance.sdk.openadsdk.core.o.a();
        }
        Intent intent = this.f5942b.u() != null ? new Intent(contextA, (Class<?>) TTFullScreenExpressVideoActivity.class) : new Intent(contextA, (Class<?>) TTFullScreenVideoActivity.class);
        if (activity == null) {
            intent.addFlags(268435456);
        }
        intent.putExtra("show_download_bar", this.f5946f);
        intent.putExtra(AdUnitActivity.EXTRA_ORIENTATION, this.f5943c.getOrientation());
        intent.putExtra("is_verity_playable", this.k);
        if (!TextUtils.isEmpty(this.i)) {
            intent.putExtra("rit_scene", this.i);
        }
        if (this.g) {
            intent.putExtra("video_cache_url", this.h);
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.f5942b.Z().toString());
            intent.putExtra("multi_process_meta_md5", this.l);
        } else {
            s.a().g();
            s.a().a(this.f5942b);
            s.a().a(this.f5944d);
            s.a().a(this.f5945e);
            this.f5944d = null;
        }
        com.bytedance.sdk.openadsdk.utils.b.a(contextA, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.reward.i.1
            @Override // com.bytedance.sdk.openadsdk.utils.b.a
            public void a() {
                if (i.this.k) {
                    try {
                        com.bytedance.sdk.openadsdk.f.a.a().a(i.this.f5942b.v().i());
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.utils.b.a
            public void a(Throwable th) {
                o.c("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
                if (i.this.k) {
                    try {
                        com.bytedance.sdk.openadsdk.f.a.a().a(i.this.f5942b.v().i(), -1, th != null ? th.getMessage() : "playable tool error open");
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        if (TextUtils.isEmpty(this.f5942b.M())) {
            return;
        }
        try {
            String strOptString = new JSONObject(this.f5942b.M()).optString("rit", null);
            AdSlot adSlotB = c.a(this.f5941a).b(strOptString);
            c.a(this.f5941a).a(strOptString);
            if (adSlotB != null) {
                if (!this.g || TextUtils.isEmpty(this.h)) {
                    c.a(this.f5941a).a(adSlotB);
                } else {
                    c.a(this.f5941a).b(adSlotB);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z) {
        this.k = z;
    }

    public void a(String str) {
        if (this.j.get()) {
            return;
        }
        this.g = true;
        this.h = str;
    }

    private void a(final int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.i.a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.i.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a aVarA = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(i.this.f5941a);
                    if (i == 1 && i.this.f5944d != null) {
                        o.b("MultiProcess", "start registerFullScreenVideoListener ! ");
                        com.bytedance.sdk.openadsdk.multipro.aidl.b.a aVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.a(i.this.f5944d);
                        IListenerManager iListenerManagerAsInterface = IListenerManager.Stub.asInterface(aVarA.a(1));
                        if (iListenerManagerAsInterface != null) {
                            try {
                                iListenerManagerAsInterface.registerFullVideoListener(i.this.l, aVar);
                                o.b("MultiProcess", "end registerFullScreenVideoListener ! ");
                            } catch (RemoteException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            o.e("TTFullScreenVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
            this.i = str;
        } else {
            this.i = ritScenes.getScenesName();
        }
        showFullScreenVideoAd(activity);
    }
}
