package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzvk implements Comparator {
    static final Comparator zzchr = new zzvk();

    private zzvk() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return zzvl.zzd((String) obj, (String) obj2);
    }
}
