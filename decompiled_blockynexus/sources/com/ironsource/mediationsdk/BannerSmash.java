package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.InterfaceC2348c;
import com.ironsource.mediationsdk.sdk.InterfaceC2349d;
import java.util.Timer;

/* JADX INFO: loaded from: classes2.dex */
public class BannerSmash implements InterfaceC2349d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AbstractC2311b f14625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Timer f14626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f14627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.ironsource.mediationsdk.model.p f14628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BANNER_SMASH_STATE f14629e = BANNER_SMASH_STATE.NO_INIT;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private InterfaceC2348c f14630f;
    private boolean g;
    private IronSourceBannerLayout h;
    private int i;

    protected enum BANNER_SMASH_STATE {
        NO_INIT,
        INIT_IN_PROGRESS,
        LOAD_IN_PROGRESS,
        LOADED,
        LOAD_FAILED,
        DESTROYED
    }

    BannerSmash(InterfaceC2348c interfaceC2348c, com.ironsource.mediationsdk.model.p pVar, AbstractC2311b abstractC2311b, long j, int i) {
        this.i = i;
        this.f14630f = interfaceC2348c;
        this.f14625a = abstractC2311b;
        this.f14628d = pVar;
        this.f14627c = j;
        this.f14625a.addBannerListener(this);
    }

    private void h() {
        if (this.f14625a == null) {
            return;
        }
        try {
            String strH = U.e().h();
            if (!TextUtils.isEmpty(strH)) {
                this.f14625a.setMediationSegment(strH);
            }
            String strC = com.ironsource.mediationsdk.a.a.a().c();
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            this.f14625a.setPluginData(strC, com.ironsource.mediationsdk.a.a.a().b());
        } catch (Exception e2) {
            a(":setCustomParams():" + e2.toString());
        }
    }

    private void i() {
        try {
            k();
            this.f14626b = new Timer();
            this.f14626b.schedule(new C2333m(this), this.f14627c);
        } catch (Exception e2) {
            a("startLoadTimer", e2.getLocalizedMessage());
        }
    }

    private void k() {
        try {
            try {
                if (this.f14626b != null) {
                    this.f14626b.cancel();
                }
            } catch (Exception e2) {
                a("stopLoadTimer", e2.getLocalizedMessage());
            }
        } finally {
            this.f14626b = null;
        }
    }

    public String c() {
        return this.f14628d.m() ? this.f14628d.i() : this.f14628d.h();
    }

    public int d() {
        return this.i;
    }

    public String e() {
        return this.f14628d.l();
    }

    public boolean f() {
        return this.g;
    }

    public void g() {
        a("reloadBanner()");
        IronSourceBannerLayout ironSourceBannerLayout = this.h;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) {
            this.f14630f.a(new com.ironsource.mediationsdk.logger.b(610, this.h == null ? "banner is null" : "banner is destroyed"), this, false);
            return;
        }
        i();
        a(BANNER_SMASH_STATE.LOADED);
        this.f14625a.reloadBanner(this.h, this.f14628d.d(), this);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2349d
    public void j() {
        InterfaceC2348c interfaceC2348c = this.f14630f;
        if (interfaceC2348c != null) {
            interfaceC2348c.a(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2349d
    public void o() {
        InterfaceC2348c interfaceC2348c = this.f14630f;
        if (interfaceC2348c != null) {
            interfaceC2348c.d(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2349d
    public void onBannerInitSuccess() {
        k();
        if (this.f14629e == BANNER_SMASH_STATE.INIT_IN_PROGRESS) {
            IronSourceBannerLayout ironSourceBannerLayout = this.h;
            if (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) {
                this.f14630f.a(new com.ironsource.mediationsdk.logger.b(605, this.h == null ? "banner is null" : "banner is destroyed"), this, false);
                return;
            }
            i();
            a(BANNER_SMASH_STATE.LOAD_IN_PROGRESS);
            this.f14625a.loadBanner(this.h, this.f14628d.d(), this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2349d
    public void p() {
        InterfaceC2348c interfaceC2348c = this.f14630f;
        if (interfaceC2348c != null) {
            interfaceC2348c.c(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2349d
    public void q() {
        InterfaceC2348c interfaceC2348c = this.f14630f;
        if (interfaceC2348c != null) {
            interfaceC2348c.b(this);
        }
    }

    public AbstractC2311b b() {
        return this.f14625a;
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2349d
    public void d(com.ironsource.mediationsdk.logger.b bVar) {
        a("onBannerAdLoadFailed()");
        k();
        boolean z = bVar.a() == 606;
        BANNER_SMASH_STATE banner_smash_state = this.f14629e;
        if (banner_smash_state == BANNER_SMASH_STATE.LOAD_IN_PROGRESS) {
            a(BANNER_SMASH_STATE.LOAD_FAILED);
            this.f14630f.a(bVar, this, z);
        } else if (banner_smash_state == BANNER_SMASH_STATE.LOADED) {
            this.f14630f.b(bVar, this, z);
        }
    }

    public void a(boolean z) {
        this.g = z;
    }

    public String a() {
        if (!TextUtils.isEmpty(this.f14628d.a())) {
            return this.f14628d.a();
        }
        return c();
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, String str, String str2) {
        a("loadBanner");
        this.g = false;
        if (ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed()) {
            if (this.f14625a == null) {
                a("loadBanner - mAdapter is null");
                this.f14630f.a(new com.ironsource.mediationsdk.logger.b(611, "adapter==null"), this, false);
                return;
            }
            this.h = ironSourceBannerLayout;
            i();
            if (this.f14629e == BANNER_SMASH_STATE.NO_INIT) {
                a(BANNER_SMASH_STATE.INIT_IN_PROGRESS);
                h();
                this.f14625a.initBanners(str, str2, this.f14628d.d(), this);
                return;
            } else {
                a(BANNER_SMASH_STATE.LOAD_IN_PROGRESS);
                this.f14625a.loadBanner(ironSourceBannerLayout, this.f14628d.d(), this);
                return;
            }
        }
        a("loadBanner - bannerLayout is null or destroyed");
        this.f14630f.a(new com.ironsource.mediationsdk.logger.b(610, ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed"), this, false);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2349d
    public void h(com.ironsource.mediationsdk.logger.b bVar) {
        k();
        if (this.f14629e == BANNER_SMASH_STATE.INIT_IN_PROGRESS) {
            this.f14630f.a(new com.ironsource.mediationsdk.logger.b(612, "Banner init failed"), this, false);
            a(BANNER_SMASH_STATE.NO_INIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BANNER_SMASH_STATE banner_smash_state) {
        this.f14629e = banner_smash_state;
        a("state=" + banner_smash_state.name());
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2349d
    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        a("onBannerAdLoaded()");
        k();
        BANNER_SMASH_STATE banner_smash_state = this.f14629e;
        if (banner_smash_state == BANNER_SMASH_STATE.LOAD_IN_PROGRESS) {
            a(BANNER_SMASH_STATE.LOADED);
            this.f14630f.a(this, view, layoutParams);
        } else if (banner_smash_state == BANNER_SMASH_STATE.LOADED) {
            this.f14630f.a(this, view, layoutParams, this.f14625a.shouldBindBannerViewOnReload());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.ADAPTER_API, "BannerSmash " + c() + " " + str, 1);
    }

    private void a(String str, String str2) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, str + " Banner exception: " + c() + " | " + str2, 3);
    }
}
