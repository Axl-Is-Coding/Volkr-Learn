package com.google.android.gms.internal.ads;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeol extends zzeoq {
    private Logger logger;

    public zzeol(String str) {
        this.logger = Logger.getLogger(str);
    }

    @Override // com.google.android.gms.internal.ads.zzeoq
    public final void zzik(String str) {
        this.logger.logp(Level.FINE, "com.googlecode.mp4parser.util.JuliLogger", "logDebug", str);
    }
}
