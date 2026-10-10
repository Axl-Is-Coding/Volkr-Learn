package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbbt {
    public static <T> T zza(Context context, String str, zzbbs<IBinder, T> zzbbsVar) throws zzbbv {
        try {
            return zzbbsVar.apply(zzbv(context).instantiate(str));
        } catch (Exception e2) {
            throw new zzbbv(e2);
        }
    }

    public static Context zzbu(Context context) throws zzbbv {
        return zzbv(context).getModuleContext();
    }

    private static DynamiteModule zzbv(Context context) throws zzbbv {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID);
        } catch (Exception e2) {
            throw new zzbbv(e2);
        }
    }
}
