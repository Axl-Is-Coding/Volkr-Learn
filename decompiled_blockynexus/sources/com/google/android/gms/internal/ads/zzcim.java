package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.alibaba.android.arouter.utils.Consts;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcim implements zzahq<Object> {
    private final zzeos<zzcif> zzfza;
    private final zzcil zzgbo;
    private final zzafk zzgej;

    public zzcim(zzcep zzcepVar, zzcei zzceiVar, zzcil zzcilVar, zzeos<zzcif> zzeosVar) {
        this.zzgej = zzcepVar.zzge(zzceiVar.getCustomTemplateId());
        this.zzgbo = zzcilVar;
        this.zzfza = zzeosVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("asset");
        try {
            this.zzgej.zza(this.zzfza.get(), str);
        } catch (RemoteException e2) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(Consts.DOT);
            zzbbq.zzd(sb.toString(), e2);
        }
    }

    public final void zzant() {
        if (this.zzgej == null) {
            return;
        }
        this.zzgbo.zza("/nativeAdCustomClick", this);
    }
}
