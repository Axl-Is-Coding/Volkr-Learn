package c.t.m.g;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Wb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3038c;

    Wb() {
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toHexString(b2 & 255));
                sb.append("");
            }
            return sb.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static byte[] b(byte[] bArr) throws IOException {
        int i;
        if (bArr == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        byte[] bArr3 = new byte[0];
        int i2 = 0;
        do {
            try {
                i = inflaterInputStream.read(bArr2);
                if (i > 0) {
                    i2 += i;
                    byte[] bArr4 = new byte[i2];
                    System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                    System.arraycopy(bArr2, 0, bArr4, bArr3.length, i);
                    bArr3 = bArr4;
                }
            } catch (IOException | Exception unused) {
                return null;
            }
        } while (i > 0);
        byteArrayInputStream.close();
        inflaterInputStream.close();
        return bArr3;
    }

    public Wb(JSONObject jSONObject) {
        this.f3036a = jSONObject.optString("bid", null);
        this.f3037b = jSONObject.optString("floor", "1000");
        this.f3038c = jSONObject.optInt("type", -1);
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr, 0, bArr.length);
            deflaterOutputStream.finish();
            deflaterOutputStream.flush();
            deflaterOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception unused) {
            return null;
        }
    }
}
