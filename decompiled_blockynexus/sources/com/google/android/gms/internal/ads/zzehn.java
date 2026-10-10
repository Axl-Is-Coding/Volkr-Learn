package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzehn implements zzecx {
    private final ThreadLocal<Mac> zzidk = new zzehq(this);
    private final String zzidl;
    private final Key zzidm;
    private final int zzidn;

    public zzehn(String str, Key key) throws GeneralSecurityException {
        this.zzidl = str;
        this.zzidm = key;
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        byte b2 = -1;
        int iHashCode = str.hashCode();
        if (iHashCode != -1823053428) {
            if (iHashCode != 392315118) {
                if (iHashCode == 392317873 && str.equals("HMACSHA512")) {
                    b2 = 2;
                }
            } else if (str.equals("HMACSHA256")) {
                b2 = 1;
            }
        } else if (str.equals("HMACSHA1")) {
            b2 = 0;
        }
        if (b2 == 0) {
            this.zzidn = 20;
        } else if (b2 == 1) {
            this.zzidn = 32;
        } else {
            if (b2 != 2) {
                String strValueOf = String.valueOf(str);
                throw new NoSuchAlgorithmException(strValueOf.length() != 0 ? "unknown Hmac algorithm: ".concat(strValueOf) : new String("unknown Hmac algorithm: "));
            }
            this.zzidn = 64;
        }
        this.zzidk.get();
    }

    @Override // com.google.android.gms.internal.ads.zzecx
    public final byte[] zzd(byte[] bArr, int i) throws GeneralSecurityException {
        if (i > this.zzidn) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        this.zzidk.get().update(bArr);
        return Arrays.copyOf(this.zzidk.get().doFinal(), i);
    }
}
