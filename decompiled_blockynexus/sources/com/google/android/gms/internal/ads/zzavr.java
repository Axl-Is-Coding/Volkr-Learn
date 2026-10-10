package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzavr implements zzbbs {
    static final zzbbs zzbxx = new zzavr();

    private zzavr() {
    }

    @Override // com.google.android.gms.internal.ads.zzbbs
    public final Object apply(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
        return iInterfaceQueryLocalInterface instanceof zzave ? (zzave) iInterfaceQueryLocalInterface : new zzavh(iBinder);
    }
}
