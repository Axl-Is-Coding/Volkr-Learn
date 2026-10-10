package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzehr extends ThreadLocal<SecureRandom> {
    zzehr() {
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ SecureRandom initialValue() {
        return zzehs.zzbdr();
    }
}
