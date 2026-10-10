package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzby;
import com.google.android.gms.internal.ads.zzcf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzed extends zzdy {
    private zzed(Context context, String str, boolean z, int i) {
        super(context, str, z, i);
    }

    public static zzed zzb(String str, Context context, boolean z) {
        return zzb(str, context, false, zzcw.zznj);
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    protected final List<Callable<Void>> zza(zzex zzexVar, Context context, zzcf.zza.C0108zza c0108zza, zzby.zza zzaVar) {
        if (zzexVar.zzcg() == null || !this.zzxj) {
            return super.zza(zzexVar, context, c0108zza, zzaVar);
        }
        int iZzbu = zzexVar.zzbu();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zza(zzexVar, context, c0108zza, zzaVar));
        arrayList.add(new zzfr(zzexVar, "mLW4WfBtN0b1ZboDT/Xcg0iQ140V7G6lHXVBVeBNgLy2jqsT86h2d5npN9bwHugA", "7PTXHfesCwrygeE6a5SpFPYapA+6N5AjzCxH/Yeev9s=", c0108zza, iZzbu, 24));
        return arrayList;
    }

    public static zzed zzb(String str, Context context, boolean z, int i) {
        zzdy.zza(context, z);
        zzdy.zza(str, context, z, i);
        return new zzed(context, str, z, i);
    }
}
