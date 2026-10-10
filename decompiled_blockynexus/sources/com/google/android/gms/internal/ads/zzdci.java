package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdci implements zzdgx<zzdcg> {
    private final String zzdqu;
    private final zzcku zzgij;
    private final zzdzb zzguy;

    public zzdci(String str, zzdzb zzdzbVar, zzcku zzckuVar) {
        this.zzdqu = str;
        this.zzguy = zzdzbVar;
        this.zzgij = zzckuVar;
    }

    private static Bundle zzb(zzdpa zzdpaVar) {
        Bundle bundle = new Bundle();
        try {
            if (zzdpaVar.zzub() != null) {
                bundle.putString("sdk_version", zzdpaVar.zzub().toString());
            }
        } catch (zzdos unused) {
        }
        try {
            if (zzdpaVar.zzua() != null) {
                bundle.putString("adapter_version", zzdpaVar.zzua().toString());
            }
        } catch (zzdos unused2) {
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdcg> zzarj() {
        if (new BigInteger(this.zzdqu).equals(BigInteger.ONE)) {
            if (!zzdwf.zzas((String) zzwm.zzpx().zzd(zzabb.zzcqa))) {
                return this.zzguy.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdcl
                    private final zzdci zzgvq;

                    {
                        this.zzgvq = this;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zzgvq.zzarl();
                    }
                });
            }
        }
        return zzdyq.zzaf(new zzdcg(new Bundle()));
    }

    final /* synthetic */ zzdcg zzarl() throws Exception {
        List<String> listAsList = Arrays.asList(((String) zzwm.zzpx().zzd(zzabb.zzcqa)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : listAsList) {
            try {
                bundle.putBundle(str, zzb(this.zzgij.zzd(str, new JSONObject())));
            } catch (zzdos unused) {
            }
        }
        return new zzdcg(bundle);
    }
}
