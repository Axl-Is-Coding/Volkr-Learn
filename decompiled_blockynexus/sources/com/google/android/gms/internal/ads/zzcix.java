package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcix<T> implements zzahq<Object> {
    private final WeakReference<T> zzgeu;
    private final String zzgev;
    private final zzahq<T> zzgew;
    private final /* synthetic */ zzcil zzgex;

    private zzcix(zzcil zzcilVar, WeakReference<T> weakReference, String str, zzahq<T> zzahqVar) {
        this.zzgex = zzcilVar;
        this.zzgeu = weakReference;
        this.zzgev = str;
        this.zzgew = zzahqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final void zza(Object obj, Map<String, String> map) {
        T t = this.zzgeu.get();
        if (t == null) {
            this.zzgex.zzb(this.zzgev, this);
        } else {
            this.zzgew.zza(t, map);
        }
    }

    /* synthetic */ zzcix(zzcil zzcilVar, WeakReference weakReference, String str, zzahq zzahqVar, zzciq zzciqVar) {
        this(zzcilVar, weakReference, str, zzahqVar);
    }
}
