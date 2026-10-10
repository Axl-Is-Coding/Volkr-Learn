package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* JADX INFO: compiled from: FullScreenVideoListenerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends IFullScreenVideoAdInteractionListener.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f7037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f7038b = new Handler(Looper.getMainLooper());

    public a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f7037a = fullScreenVideoAdInteractionListener;
    }

    private Handler b() {
        Handler handler = this.f7038b;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.f7038b = handler2;
        return handler2;
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdClose() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f7037a != null) {
                    a.this.f7037a.onAdClose();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdShow() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f7037a != null) {
                    a.this.f7037a.onAdShow();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f7037a != null) {
                    a.this.f7037a.onAdVideoBarClick();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onDestroy() throws RemoteException {
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onSkippedVideo() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f7037a != null) {
                    a.this.f7037a.onSkippedVideo();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onVideoComplete() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f7037a != null) {
                    a.this.f7037a.onVideoComplete();
                }
            }
        });
    }

    private void a() {
        this.f7037a = null;
        this.f7038b = null;
    }
}
