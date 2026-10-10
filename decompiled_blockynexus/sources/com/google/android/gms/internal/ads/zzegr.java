package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzegr implements zzdzz {
    private static final byte[] zzhvu = new byte[0];
    private final ECPrivateKey zzicc;
    private final zzegt zzicd;
    private final String zzice;
    private final byte[] zzicf;
    private final zzegz zzicg;
    private final zzegs zzich;

    public zzegr(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzegz zzegzVar, zzegs zzegsVar) throws GeneralSecurityException {
        this.zzicc = eCPrivateKey;
        this.zzicd = new zzegt(eCPrivateKey);
        this.zzicf = bArr;
        this.zzice = str;
        this.zzicg = zzegzVar;
        this.zzich = zzegsVar;
    }
}
