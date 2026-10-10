package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* JADX INFO: compiled from: SingleAppData.java */
/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static s f6360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.c f6361b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.d.h f6363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TTRewardVideoAd.RewardAdInteractionListener f6364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b.a.a.a.a.a.b f6365f;
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6362c = true;
    private boolean h = false;

    private s() {
    }

    public static s a() {
        if (f6360a == null) {
            f6360a = new s();
        }
        return f6360a;
    }

    public boolean b() {
        return this.f6362c;
    }

    public com.bytedance.sdk.openadsdk.core.d.h c() {
        return this.f6363d;
    }

    public TTRewardVideoAd.RewardAdInteractionListener d() {
        return this.f6364e;
    }

    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e() {
        return this.g;
    }

    public b.a.a.a.a.a.b f() {
        return this.f6365f;
    }

    public void g() {
        this.f6361b = null;
        this.f6363d = null;
        this.f6364e = null;
        this.g = null;
        this.f6365f = null;
        this.h = false;
        this.f6362c = true;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public void a(boolean z) {
        this.f6362c = z;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        this.f6363d = hVar;
    }

    public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.g = fullScreenVideoAdInteractionListener;
    }

    public void a(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f6364e = rewardAdInteractionListener;
    }

    public void a(b.a.a.a.a.a.b bVar) {
        this.f6365f = bVar;
    }
}
