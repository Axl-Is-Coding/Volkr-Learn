package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbml {
    private final Executor executor;
    private final String zzbrd;
    private final zzamk zzfni;
    private zzbmu zzfnj;
    private final zzahq<Object> zzfnk = new zzbmo(this);
    private final zzahq<Object> zzfnl = new zzbmq(this);

    public zzbml(String str, zzamk zzamkVar, Executor executor) {
        this.zzbrd = str;
        this.zzfni = zzamkVar;
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzm(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.zzbrd);
    }

    public final void zza(zzbmu zzbmuVar) {
        this.zzfni.zzc("/updateActiveView", this.zzfnk);
        this.zzfni.zzc("/untrackActiveViewUnit", this.zzfnl);
        this.zzfnj = zzbmuVar;
    }

    public final void zzahe() {
        this.zzfni.zzd("/updateActiveView", this.zzfnk);
        this.zzfni.zzd("/untrackActiveViewUnit", this.zzfnl);
    }

    public final void zzd(zzbgj zzbgjVar) {
        zzbgjVar.zza("/updateActiveView", this.zzfnk);
        zzbgjVar.zza("/untrackActiveViewUnit", this.zzfnl);
    }

    public final void zze(zzbgj zzbgjVar) {
        zzbgjVar.zzb("/updateActiveView", this.zzfnk);
        zzbgjVar.zzb("/untrackActiveViewUnit", this.zzfnl);
    }
}
