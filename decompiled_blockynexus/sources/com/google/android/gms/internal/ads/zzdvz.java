package com.google.android.gms.internal.ads;

import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdvz {
    private static final Logger logger = Logger.getLogger(zzdvz.class.getName());
    private static final zzdwa zzhpc = new zza();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    static final class zza {
        private zza() {
        }
    }

    private zzdvz() {
    }

    static String emptyToNull(String str) {
        if (zzhh(str)) {
            return null;
        }
        return str;
    }

    static boolean zzhh(String str) {
        return str == null || str.isEmpty();
    }

    static String zzhi(String str) {
        return str == null ? "" : str;
    }
}
