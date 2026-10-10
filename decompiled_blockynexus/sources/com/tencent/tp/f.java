package com.tencent.tp;

import com.sandboxol.center.config.VipSubscribeStatus;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public class f {
    public static boolean a() {
        return (b() || c() || d()) ? false : true;
    }

    public static boolean b() {
        return MessageDigest.isEqual("123456".getBytes(), "456".getBytes());
    }

    public static boolean c() {
        try {
            Signature signature = Signature.getInstance(q.a("NCV1rdocMNV"));
            signature.initVerify(KeyFactory.getInstance(q.a("MNV")).generatePublic(new RSAPublicKeySpec(new BigInteger("123456", 16), new BigInteger(VipSubscribeStatus.SUBSCRIPTION_PAUSE_SCHEDULE_CHANGED, 16))));
            signature.update("367".getBytes());
            return signature.verify("123098".getBytes());
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException unused) {
            return false;
        }
    }

    public static boolean d() {
        try {
            Signature signature = Signature.getInstance(q.a("NCV1rdocMNV"));
            signature.initVerify(KeyFactory.getInstance(q.a("MNV")).generatePublic(new RSAPublicKeySpec(new BigInteger("12345678", 16), new BigInteger(VipSubscribeStatus.SUBSCRIPTION_PAUSE_SCHEDULE_CHANGED, 16))));
            signature.update("367".getBytes());
            return signature.verify("123908".getBytes(), 1, 5);
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException unused) {
            return false;
        }
    }
}
