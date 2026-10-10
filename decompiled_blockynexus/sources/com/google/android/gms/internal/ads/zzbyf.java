package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbyf extends zzbyr<AppEventListener> implements zzagv {
    public zzbyf(Set<zzcab<AppEventListener>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzagv
    public final synchronized void onAppEvent(final String str, final String str2) {
        zza(new zzbyt(str, str2) { // from class: com.google.android.gms.internal.ads.zzbye
            private final String zzdgm;
            private final String zzdgt;

            {
                this.zzdgt = str;
                this.zzdgm = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((AppEventListener) obj).onAppEvent(this.zzdgt, this.zzdgm);
            }
        });
    }
}
