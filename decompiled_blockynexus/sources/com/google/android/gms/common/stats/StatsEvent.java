package com.google.android.gms.common.stats;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    @KeepForSdk
    public interface Types {

        @KeepForSdk
        public static final int EVENT_TYPE_ACQUIRE_WAKE_LOCK = 7;

        @KeepForSdk
        public static final int EVENT_TYPE_RELEASE_WAKE_LOCK = 8;
    }

    public String toString() {
        long jZza = zza();
        int iZzb = zzb();
        long jZzc = zzc();
        String strZzd = zzd();
        StringBuilder sb = new StringBuilder(String.valueOf(strZzd).length() + 53);
        sb.append(jZza);
        sb.append("\t");
        sb.append(iZzb);
        sb.append("\t");
        sb.append(jZzc);
        sb.append(strZzd);
        return sb.toString();
    }

    public abstract long zza();

    public abstract int zzb();

    public abstract long zzc();

    public abstract String zzd();
}
