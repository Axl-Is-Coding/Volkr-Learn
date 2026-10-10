package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzaru {
    private static zzaxl zzdqb;
    private final zzyw zzacu;
    private final AdFormat zzdqa;
    private final Context zzvr;

    public zzaru(Context context, AdFormat adFormat, zzyw zzywVar) {
        this.zzvr = context;
        this.zzdqa = adFormat;
        this.zzacu = zzywVar;
    }

    public static zzaxl zzs(Context context) {
        zzaxl zzaxlVar;
        synchronized (zzaru.class) {
            if (zzdqb == null) {
                zzdqb = zzwm.zzpu().zza(context, new zzanc());
            }
            zzaxlVar = zzdqb;
        }
        return zzaxlVar;
    }

    public final void zza(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzaxl zzaxlVarZzs = zzs(this.zzvr);
        if (zzaxlVarZzs == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(this.zzvr);
        zzyw zzywVar = this.zzacu;
        try {
            zzaxlVarZzs.zza(iObjectWrapperWrap, new zzaxr(null, this.zzdqa.name(), null, zzywVar == null ? new zzvj().zzpj() : zzvl.zza(this.zzvr, zzywVar)), new zzarx(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
