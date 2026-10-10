package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzadx extends NativeAd.AdChoicesInfo {
    private String text;
    private final List<NativeAd.Image> zzddd = new ArrayList();
    private final zzadw zzddo;

    public zzadx(zzadw zzadwVar) {
        zzaee zzaegVar;
        IBinder iBinder;
        this.zzddo = zzadwVar;
        try {
            this.text = this.zzddo.getText();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            this.text = "";
        }
        try {
            for (zzaee zzaeeVar : zzadwVar.zzsb()) {
                if (!(zzaeeVar instanceof IBinder) || (iBinder = (IBinder) zzaeeVar) == null) {
                    zzaegVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzaegVar = iInterfaceQueryLocalInterface instanceof zzaee ? (zzaee) iInterfaceQueryLocalInterface : new zzaeg(iBinder);
                }
                if (zzaegVar != null) {
                    this.zzddd.add(new zzaef(zzaegVar));
                }
            }
        } catch (RemoteException e3) {
            zzbbq.zzc("", e3);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zzddd;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.text;
    }
}
