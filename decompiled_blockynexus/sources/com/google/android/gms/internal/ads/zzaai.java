package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.ShouldDelayBannerRenderingListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaai extends zzafx {
    private final ShouldDelayBannerRenderingListener zzcle;

    public zzaai(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
        this.zzcle = shouldDelayBannerRenderingListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        return this.zzcle.shouldDelayBannerRendering((Runnable) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
