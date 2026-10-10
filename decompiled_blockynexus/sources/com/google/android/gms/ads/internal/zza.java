package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzasr;
import com.google.android.gms.internal.ads.zzawl;
import com.google.android.gms.internal.ads.zzayu;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zza {
    private boolean zzbof;
    private zzawl zzbog;
    private zzasr zzboh;
    private final Context zzvr;

    public zza(Context context, zzawl zzawlVar, zzasr zzasrVar) {
        this.zzvr = context;
        this.zzbog = zzawlVar;
        this.zzboh = null;
        if (this.zzboh == null) {
            this.zzboh = new zzasr();
        }
    }

    private final boolean zzjy() {
        zzawl zzawlVar = this.zzbog;
        return (zzawlVar != null && zzawlVar.zzvq().zzdxh) || this.zzboh.zzdtr;
    }

    public final void recordClick() {
        this.zzbof = true;
    }

    public final void zzbo(String str) {
        List<String> list;
        if (zzjy()) {
            if (str == null) {
                str = "";
            }
            zzawl zzawlVar = this.zzbog;
            if (zzawlVar != null) {
                zzawlVar.zza(str, null, 3);
                return;
            }
            zzasr zzasrVar = this.zzboh;
            if (!zzasrVar.zzdtr || (list = zzasrVar.zzdts) == null) {
                return;
            }
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    String strReplace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                    zzp.zzkr();
                    zzayu.zzb(this.zzvr, "", strReplace);
                }
            }
        }
    }

    public final boolean zzjz() {
        return !zzjy() || this.zzbof;
    }
}
