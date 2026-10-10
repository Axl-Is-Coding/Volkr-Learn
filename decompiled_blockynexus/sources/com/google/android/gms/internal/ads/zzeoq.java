package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzeoq {
    public static zzeoq zzn(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new zzeoj(cls.getSimpleName()) : new zzeol(cls.getSimpleName());
    }

    public abstract void zzik(String str);
}
