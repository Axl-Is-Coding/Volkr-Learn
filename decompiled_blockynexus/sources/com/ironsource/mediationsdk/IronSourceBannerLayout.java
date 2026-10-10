package com.ironsource.mediationsdk;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.InterfaceC2347b;

/* JADX INFO: loaded from: classes2.dex */
public class IronSourceBannerLayout extends FrameLayout {
    private boolean isDestroyed;
    private Activity mActivity;
    private InterfaceC2347b mBannerListener;
    private View mBannerView;
    private boolean mIsBannerDisplayed;
    private String mPlacementName;
    private C2374v mSize;

    public IronSourceBannerLayout(Activity activity, C2374v c2374v) {
        super(activity);
        this.isDestroyed = false;
        this.mIsBannerDisplayed = false;
        this.mActivity = activity;
        this.mSize = c2374v == null ? C2374v.f15055a : c2374v;
    }

    void addViewWithFrameLayoutParams(View view, FrameLayout.LayoutParams layoutParams) {
        new Handler(Looper.getMainLooper()).post(new S(this, view, layoutParams));
    }

    protected void destroyBanner() {
        this.isDestroyed = true;
        this.mBannerListener = null;
        this.mActivity = null;
        this.mSize = null;
        this.mPlacementName = null;
        this.mBannerView = null;
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public InterfaceC2347b getBannerListener() {
        return this.mBannerListener;
    }

    public View getBannerView() {
        return this.mBannerView;
    }

    public String getPlacementName() {
        return this.mPlacementName;
    }

    public C2374v getSize() {
        return this.mSize;
    }

    public boolean isDestroyed() {
        return this.isDestroyed;
    }

    public void removeBannerListener() {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.API, "removeBannerListener()", 1);
        this.mBannerListener = null;
    }

    void sendBannerAdClicked() {
        if (this.mBannerListener != null) {
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onBannerAdClicked()", 1);
            this.mBannerListener.o();
        }
    }

    void sendBannerAdLeftApplication() {
        if (this.mBannerListener != null) {
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onBannerAdLeftApplication()", 1);
            this.mBannerListener.j();
        }
    }

    void sendBannerAdLoadFailed(com.ironsource.mediationsdk.logger.b bVar) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onBannerAdLoadFailed()  error=" + bVar, 1);
        new Handler(Looper.getMainLooper()).post(new Q(this, bVar));
    }

    void sendBannerAdLoaded(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "onBannerAdLoaded() | internal | adapter: " + str, 0);
        if (this.mBannerListener != null && !this.mIsBannerDisplayed) {
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onBannerAdLoaded()", 1);
            this.mBannerListener.r();
        }
        this.mIsBannerDisplayed = true;
    }

    void sendBannerAdScreenDismissed() {
        if (this.mBannerListener != null) {
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onBannerAdScreenDismissed()", 1);
            this.mBannerListener.p();
        }
    }

    void sendBannerAdScreenPresented() {
        if (this.mBannerListener != null) {
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onBannerAdScreenPresented()", 1);
            this.mBannerListener.q();
        }
    }

    public void setBannerListener(InterfaceC2347b interfaceC2347b) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.API, "setBannerListener()", 1);
        this.mBannerListener = interfaceC2347b;
    }

    public void setPlacementName(String str) {
        this.mPlacementName = str;
    }
}
