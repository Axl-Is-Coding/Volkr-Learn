package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzaci<T> {
    private final T zzclg;
    private final String zzcn;
    private final int zzczv;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;TT;Ljava/lang/Integer;)V */
    /* JADX WARN: Multi-variable type inference failed */
    protected zzaci(String str, Object obj, int i) {
        this.zzcn = str;
        this.zzclg = obj;
        this.zzczv = i;
    }

    public static zzaci<Long> zzb(String str, long j) {
        return new zzaci<>(str, Long.valueOf(j), zzack.zzczx);
    }

    public static zzaci<Boolean> zzg(String str, boolean z) {
        return new zzaci<>(str, Boolean.valueOf(z), zzack.zzczw);
    }

    public static zzaci<String> zzi(String str, String str2) {
        return new zzaci<>(str, str2, zzack.zzczz);
    }

    public T get() {
        zzadk zzadkVarZzsa = zzadj.zzsa();
        if (zzadkVarZzsa == null) {
            throw new IllegalStateException("Flag is not initialized.");
        }
        int i = zzach.zzczu[this.zzczv - 1];
        if (i == 1) {
            return (T) zzadkVarZzsa.zzf(this.zzcn, ((Boolean) this.zzclg).booleanValue());
        }
        if (i == 2) {
            return (T) zzadkVarZzsa.getLong(this.zzcn, ((Long) this.zzclg).longValue());
        }
        if (i == 3) {
            return (T) zzadkVarZzsa.zza(this.zzcn, ((Double) this.zzclg).doubleValue());
        }
        if (i == 4) {
            return (T) zzadkVarZzsa.get(this.zzcn, (String) this.zzclg);
        }
        throw new IllegalStateException();
    }

    public static zzaci<Double> zzb(String str, double d2) {
        return new zzaci<>(str, Double.valueOf(d2), zzack.zzczy);
    }
}
