package io.rong.message.utils;

import io.rong.common.RLog;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public class RCDHCodecTool {
    private static final String TAG = "io.rong.message.utils.RCDHCodecTool";
    private static final String gStrDefault = "3";
    private static final int lSize = 2048;
    private static final String pStrDefault = "25135566567101483196994790440833279750474660393232382279277736257066266618532493517139001963526957179514521981877335815379755618191324858392834843718048308951653115284529736874534289456833723962912807104017411854314007953484461899139734367756070456068592886771130491355511301923675421649355211882120329692353507392677087555292357140606251171702417804959957862991259464749806480821163999054978911727901705780417863120490095024926067731615229486812312187386108568833026386220686253160504779704721744600638258183939573405528962511242337923530869616215532193967628076922234051908977996352800560160181197923404454023908443";
    private static Map<String, RCDHCodecTool> sToolBag = new HashMap();
    private KeyPair mLocalKeyPair;
    private RCSecretKey mRCSecretKey;

    public static class RCDHPrivateKey implements DHPrivateKey {
        private BigInteger x;

        RCDHPrivateKey(BigInteger bigInteger) {
            this.x = bigInteger;
        }

        @Override // java.security.Key
        public String getAlgorithm() {
            return null;
        }

        @Override // java.security.Key
        public byte[] getEncoded() {
            return new byte[0];
        }

        @Override // java.security.Key
        public String getFormat() {
            return null;
        }

        @Override // javax.crypto.interfaces.DHKey
        public DHParameterSpec getParams() {
            return null;
        }

        @Override // javax.crypto.interfaces.DHPrivateKey
        public BigInteger getX() {
            return this.x;
        }

        public String toString() {
            return this.x.toString();
        }
    }

    public static class RCDHPublicKey implements DHPublicKey {
        private BigInteger Y;

        RCDHPublicKey(BigInteger bigInteger) {
            this.Y = bigInteger;
        }

        @Override // java.security.Key
        public String getAlgorithm() {
            return null;
        }

        @Override // java.security.Key
        public byte[] getEncoded() {
            return new byte[0];
        }

        @Override // java.security.Key
        public String getFormat() {
            return null;
        }

        @Override // javax.crypto.interfaces.DHKey
        public DHParameterSpec getParams() {
            return null;
        }

        @Override // javax.crypto.interfaces.DHPublicKey
        public BigInteger getY() {
            return this.Y;
        }

        public String toString() {
            return this.Y.toString();
        }
    }

    public static class RCSecretKey implements SecretKey {
        public BigInteger key;

        RCSecretKey(BigInteger bigInteger) {
            this.key = bigInteger;
        }

        @Override // java.security.Key
        public String getAlgorithm() {
            return null;
        }

        @Override // java.security.Key
        public byte[] getEncoded() {
            BigInteger bigInteger = this.key;
            byte[] bytes = null;
            if (bigInteger != null) {
                try {
                    bytes = bigInteger.toString().getBytes("utf-8");
                } catch (UnsupportedEncodingException e2) {
                    RLog.e(RCDHCodecTool.TAG, "RCSecretKey getEncoded", e2);
                    return null;
                }
            }
            return RCDHCodecTool.sha265Digest(bytes);
        }

        @Override // java.security.Key
        public String getFormat() {
            return null;
        }

        public String toString() {
            return this.key.toString();
        }
    }

    private static RCDHCodecTool create() {
        return new RCDHCodecTool();
    }

    public static byte[] decrypt(byte[] bArr, RCSecretKey rCSecretKey) {
        try {
            byte[] encoded = rCSecretKey.getEncoded();
            SecretKeySpec secretKeySpec = new SecretKeySpec(encoded, "AES");
            byte[] bArr2 = new byte[16];
            System.arraycopy(encoded, 0, bArr2, 0, 16);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e2) {
            RLog.e(TAG, "decrypt", e2);
            return null;
        } catch (InvalidKeyException e3) {
            e = e3;
            RLog.e(TAG, "decrypt", e);
            return null;
        } catch (NoSuchAlgorithmException e4) {
            e = e4;
            RLog.e(TAG, "decrypt", e);
            return null;
        } catch (BadPaddingException e5) {
            e = e5;
            RLog.e(TAG, "decrypt", e);
            return null;
        } catch (IllegalBlockSizeException e6) {
            e = e6;
            RLog.e(TAG, "decrypt", e);
            return null;
        } catch (NoSuchPaddingException e7) {
            e = e7;
            RLog.e(TAG, "decrypt", e);
            return null;
        }
    }

    public static byte[] encrypt(byte[] bArr, RCSecretKey rCSecretKey) {
        try {
            byte[] encoded = rCSecretKey.getEncoded();
            SecretKeySpec secretKeySpec = new SecretKeySpec(encoded, "AES");
            byte[] bArr2 = new byte[16];
            System.arraycopy(encoded, 0, bArr2, 0, 16);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            RLog.e(TAG, "return byte[0],exception occurs while calling encrypt() " + e2.getLocalizedMessage());
            return new byte[0];
        }
    }

    public static RCDHPrivateKey fromString2RCDHPrivateKey(String str) {
        try {
            return new RCDHPrivateKey(new BigInteger(str));
        } catch (Exception e2) {
            RLog.e(TAG, "fromString2RCDHPrivateKey exception occurs when transforming keyString to BigInger.", e2);
            return null;
        }
    }

    public static RCDHPublicKey fromString2RCDHPublicKey(String str) {
        try {
            return new RCDHPublicKey(new BigInteger(str));
        } catch (Exception e2) {
            RLog.e(TAG, "fromString2RCDHPublicKey exception occurs when transforming keyString to BigInger.", e2);
            return null;
        }
    }

    public static RCSecretKey fromString2RCSecretKey(String str) {
        try {
            return new RCSecretKey(new BigInteger(str));
        } catch (Exception unused) {
            RLog.e(TAG, "exception occurs when transforming keyString to BigInger.");
            return null;
        }
    }

    public static String genEncId() {
        int iNextInt;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Random random = new Random();
        do {
            iNextInt = random.nextInt(9999);
        } while (iNextInt / 1000 <= 0);
        return String.valueOf(jCurrentTimeMillis) + iNextInt;
    }

    private KeyPair genLocalKeyPair(DHParameterSpec dHParameterSpec) {
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            if (dHParameterSpec == null) {
                dHParameterSpec = new DHParameterSpec(new BigInteger(pStrDefault), new BigInteger("3"), 2048);
            }
            BigInteger p = dHParameterSpec.getP();
            BigInteger g = dHParameterSpec.getG();
            int l = dHParameterSpec.getL();
            BigInteger bigIntegerSubtract = p.subtract(BigInteger.valueOf(2L));
            while (true) {
                BigInteger bigInteger = new BigInteger(l, secureRandom);
                if (bigInteger.compareTo(BigInteger.valueOf(1L)) >= 0 && bigInteger.compareTo(bigIntegerSubtract) <= 0 && bigInteger.bitLength() == l) {
                    this.mLocalKeyPair = new KeyPair(new RCDHPublicKey(g.modPow(bigInteger, p)), new RCDHPrivateKey(bigInteger));
                    return this.mLocalKeyPair;
                }
            }
        } catch (NoSuchAlgorithmException e2) {
            RLog.e(TAG, "genLocalKeyPair could not get the NativePRNG random algorithm , generate local keypair failed!", e2);
            return null;
        }
    }

    public static RCSecretKey getRCSecretKeyByEncId(String str) {
        RCDHCodecTool rCDHCodecToolObtainWithEncId = obtainWithEncId(str);
        if (rCDHCodecToolObtainWithEncId == null) {
            return null;
        }
        return rCDHCodecToolObtainWithEncId.mRCSecretKey;
    }

    public static RCDHCodecTool obtainWithEncId(String str) {
        if (str == null || str.length() == 0) {
            RLog.w(TAG, "encId is null or empty while creating RCDHTool,so create a normal one.");
            return create();
        }
        if (sToolBag.containsKey(str)) {
            return sToolBag.get(str);
        }
        RCDHCodecTool rCDHCodecToolCreate = create();
        sToolBag.put(str, rCDHCodecToolCreate);
        return rCDHCodecToolCreate;
    }

    public static String[] parseEncTargetId(String str) {
        if (str != null && str.length() != 0) {
            return str.split(";;;");
        }
        RLog.e(TAG, "targetId is null or empty!");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] sha265Digest(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e2) {
            RLog.e(TAG, "sha265Digest", e2);
            return null;
        }
    }

    public RCSecretKey genSecretKey(RCDHPublicKey rCDHPublicKey) {
        KeyPair keyPair = this.mLocalKeyPair;
        if (keyPair == null || keyPair.getPrivate() == null) {
            genLocalKeyPair(null);
        }
        if (rCDHPublicKey == null || rCDHPublicKey.getY() == null) {
            RLog.e(TAG, "public key is null ,can not generate the SecretKey.");
            return null;
        }
        RCDHPrivateKey rCDHPrivateKey = this.mLocalKeyPair.getPrivate() instanceof RCDHPrivateKey ? (RCDHPrivateKey) this.mLocalKeyPair.getPrivate() : null;
        if (rCDHPrivateKey == null) {
            RLog.e(TAG, "private key is null ,can not generate the SecretKey.");
            return null;
        }
        try {
            this.mRCSecretKey = new RCSecretKey(rCDHPublicKey.getY().modPow(rCDHPrivateKey.getX(), new BigInteger(pStrDefault)));
            return this.mRCSecretKey;
        } catch (Exception e2) {
            RLog.e(TAG, "exception of " + e2.getLocalizedMessage() + "occurs,return null.");
            return null;
        }
    }

    public KeyPair getOrCreateLocalKeyPair(DHParameterSpec dHParameterSpec) {
        if (this.mLocalKeyPair == null) {
            this.mLocalKeyPair = genLocalKeyPair(dHParameterSpec);
        }
        return this.mLocalKeyPair;
    }

    public RCDHPrivateKey getRCPriKey() {
        KeyPair keyPair = this.mLocalKeyPair;
        if (keyPair != null && (keyPair.getPrivate() instanceof RCDHPrivateKey)) {
            return (RCDHPrivateKey) this.mLocalKeyPair.getPrivate();
        }
        return null;
    }

    public RCDHPublicKey getRCPubKey() {
        KeyPair keyPair = this.mLocalKeyPair;
        if (keyPair != null && (keyPair.getPublic() instanceof RCDHPublicKey)) {
            return (RCDHPublicKey) this.mLocalKeyPair.getPublic();
        }
        return null;
    }
}
