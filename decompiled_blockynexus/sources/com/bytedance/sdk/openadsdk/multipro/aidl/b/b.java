package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* JADX INFO: compiled from: RewardVideoListenerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends IRewardAdInteractionListener.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TTRewardVideoAd.RewardAdInteractionListener f7044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f7045b = new Handler(Looper.getMainLooper());

    public b(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f7044a = rewardAdInteractionListener;
    }

    private Handler b() {
        Handler handler = this.f7045b;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.f7045b = handler2;
        return handler2;
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdClose() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f7044a != null) {
                    b.this.f7044a.onAdClose();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdShow() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f7044a != null) {
                    b.this.f7044a.onAdShow();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f7044a != null) {
                    b.this.f7044a.onAdVideoBarClick();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onDestroy() throws RemoteException {
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onRewardVerify(final boolean z, final int i, final String str) throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.7
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f7044a != null) {
                    b.this.f7044a.onRewardVerify(z, i, str);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onSkippedVideo() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.6
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f7044a != null) {
                    b.this.f7044a.onSkippedVideo();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onVideoComplete() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f7044a != null) {
                    b.this.f7044a.onVideoComplete();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onVideoError() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f7044a != null) {
                    b.this.f7044a.onVideoError();
                }
            }
        });
    }

    private void a() {
        this.f7044a = null;
        this.f7045b = null;
    }
}
