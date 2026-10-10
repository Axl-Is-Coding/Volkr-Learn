package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zzcw {
    public static <V> V zza(zzcz<V> zzczVar) {
        try {
            return zzczVar.zza();
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzczVar.zza();
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }
}
