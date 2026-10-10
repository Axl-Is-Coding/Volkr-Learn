package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzczr implements AppEventListener {
    private zzxk zzgtg;

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final synchronized void onAppEvent(String str, String str2) {
        if (this.zzgtg != null) {
            try {
                this.zzgtg.onAppEvent(str, str2);
            } catch (RemoteException e2) {
                zzbbq.zzd("Remote Exception at onAppEvent.", e2);
            }
        }
    }

    public final synchronized zzxk zzaqs() {
        return this.zzgtg;
    }

    public final synchronized void zzb(zzxk zzxkVar) {
        this.zzgtg = zzxkVar;
    }
}
