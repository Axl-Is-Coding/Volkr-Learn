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
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.o;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTRewardVideoAdImpl.java */
/* JADX INFO: loaded from: classes.dex */
class j implements TTRewardVideoAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.d.h f5951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AdSlot f5952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TTRewardVideoAd.RewardAdInteractionListener f5953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b.a.a.a.a.a.b f5954e;
    private boolean g;
    private String h;
    private String i;
    private String k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5955f = true;
    private AtomicBoolean j = new AtomicBoolean(false);

    j(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
        this.f5950a = context;
        this.f5951b = hVar;
        this.f5952c = adSlot;
        if (getInteractionType() == 4) {
            this.f5954e = b.a.a.a.a.a.c.a(this.f5950a, this.f5951b, "rewarded_video");
        }
        this.g = false;
        this.k = com.bytedance.sdk.openadsdk.utils.h.a(this.f5951b.hashCode() + this.f5951b.Z().toString());
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getInteractionType() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f5951b;
        if (hVar == null) {
            return -1;
        }
        return hVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f5951b;
        if (hVar != null) {
            return hVar.T();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getRewardVideoAdType() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f5951b;
        if (hVar == null) {
            return -1;
        }
        if (hVar.r() && this.f5951b.c() == 1) {
            return 2;
        }
        return (this.f5951b.r() && this.f5951b.c() == 0) ? 1 : 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f5953d = rewardAdInteractionListener;
        a(0);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setShowDownLoadBar(boolean z) {
        this.f5955f = z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity) {
        if (activity != null && activity.isFinishing()) {
            o.e("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
            activity = null;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            o.e("TTRewardVideoAdImpl", "showRewardVideoAd error2: not main looper");
            throw new IllegalStateException("不能在子线程调用 TTRewardVideoAd.showRewardVideoAd");
        }
        if (this.j.get()) {
            return;
        }
        this.j.set(true);
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f5951b;
        if (hVar == null || hVar.v() == null) {
            return;
        }
        Context contextA = activity == null ? this.f5950a : activity;
        if (contextA == null) {
            contextA = com.bytedance.sdk.openadsdk.core.o.a();
        }
        Intent intent = this.f5951b.u() != null ? new Intent(contextA, (Class<?>) TTRewardExpressVideoActivity.class) : new Intent(contextA, (Class<?>) TTRewardVideoActivity.class);
        if (activity == null) {
            intent.addFlags(268435456);
        }
        intent.putExtra("reward_name", this.f5952c.getRewardName());
        intent.putExtra("reward_amount", this.f5952c.getRewardAmount());
        intent.putExtra("media_extra", this.f5952c.getMediaExtra());
        intent.putExtra("user_id", this.f5952c.getUserID());
        intent.putExtra("show_download_bar", this.f5955f);
        intent.putExtra(AdUnitActivity.EXTRA_ORIENTATION, this.f5952c.getOrientation());
        if (!TextUtils.isEmpty(this.i)) {
            intent.putExtra("rit_scene", this.i);
        }
        if (this.g) {
            intent.putExtra("video_cache_url", this.h);
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.f5951b.Z().toString());
            intent.putExtra("multi_process_meta_md5", this.k);
        } else {
            s.a().g();
            s.a().a(this.f5951b);
            s.a().a(this.f5953d);
            s.a().a(this.f5954e);
            this.f5953d = null;
        }
        com.bytedance.sdk.openadsdk.utils.b.a(contextA, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.reward.j.1
            @Override // com.bytedance.sdk.openadsdk.utils.b.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.b.a
            public void a(Throwable th) {
                o.c("TTRewardVideoAdImpl", "show reward video error: ", th);
            }
        });
        if (TextUtils.isEmpty(this.f5951b.M())) {
            return;
        }
        try {
            String strOptString = new JSONObject(this.f5951b.M()).optString("rit", null);
            AdSlot adSlotB = g.a(this.f5950a).b(strOptString);
            g.a(this.f5950a).a(strOptString);
            if (adSlotB != null) {
                if (!this.g || TextUtils.isEmpty(this.h)) {
                    g.a(this.f5950a).a(adSlotB);
                } else {
                    g.a(this.f5950a).b(adSlotB);
                }
            }
        } catch (Throwable unused) {
        }
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
            com.bytedance.sdk.openadsdk.i.a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.j.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a aVarA = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(j.this.f5950a);
                    if (i == 0 && j.this.f5953d != null) {
                        o.b("MultiProcess", "start registerRewardVideoListener ! ");
                        com.bytedance.sdk.openadsdk.multipro.aidl.b.b bVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.b(j.this.f5953d);
                        IListenerManager iListenerManagerAsInterface = IListenerManager.Stub.asInterface(aVarA.a(0));
                        if (iListenerManagerAsInterface != null) {
                            try {
                                iListenerManagerAsInterface.registerRewardVideoListener(j.this.k, bVar);
                                o.b("MultiProcess", "end registerRewardVideoListener ! ");
                            } catch (RemoteException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            o.e("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
            this.i = str;
        } else {
            this.i = ritScenes.getScenesName();
        }
        showRewardVideoAd(activity);
    }
}
