package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdhv implements zzdgx<zzdhs> {
    private final String packageName;
    private final zzdzb zzgcz;
    private final zzatj zzgyy;
    private final Context zzvr;

    public zzdhv(zzatj zzatjVar, Context context, String str, zzdzb zzdzbVar) {
        this.zzgyy = zzatjVar;
        this.zzvr = context;
        this.packageName = str;
        this.zzgcz = zzdzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdhs> zzarj() {
        return this.zzgcz.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdhu
            private final zzdhv zzgyx;

            {
                this.zzgyx = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgyx.zzasd();
            }
        });
    }

    final /* synthetic */ zzdhs zzasd() throws Exception {
        JSONObject jSONObject = new JSONObject();
        zzatj zzatjVar = this.zzgyy;
        if (zzatjVar != null) {
            zzatjVar.zza(this.zzvr, this.packageName, jSONObject);
        }
        return new zzdhs(jSONObject);
    }
}
