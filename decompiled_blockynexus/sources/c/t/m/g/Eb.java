package c.t.m.g;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.IOException;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public class Eb implements Gb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static C f2901a;

    Eb() {
    }

    private static InterfaceC0447mb b(String str, byte[] bArr) {
        Ia iaA;
        try {
            SystemClock.elapsedRealtime();
            iaA = C0409a.a(f2901a);
        } catch (Throwable unused) {
            iaA = null;
        }
        if (iaA == null) {
            return null;
        }
        InterfaceC0447mb interfaceC0447mbA = iaA.a(str, bArr);
        interfaceC0447mbA.a(AbstractSpiCall.HEADER_USER_AGENT, "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
        interfaceC0447mbA.b();
        return interfaceC0447mbA;
    }

    @Override // c.t.m.g.Gb
    public final Bundle a(String str, byte[] bArr) throws IOException {
        Ia iaA;
        String str2;
        try {
            SystemClock.elapsedRealtime();
            iaA = C0409a.a(f2901a);
        } catch (Throwable unused) {
            iaA = null;
        }
        if (iaA == null) {
            throw new IOException("can not init net sdk");
        }
        try {
            InterfaceC0447mb interfaceC0447mbB = b(str, bArr);
            Sb sbA = a(interfaceC0447mbB);
            String strA = interfaceC0447mbB == null ? "null" : interfaceC0447mbB.a();
            if (sbA != null && sbA.a() == 0 && sbA.c() >= 200 && sbA.c() < 300) {
                Bundle bundle = new Bundle();
                bundle.putString("req_key", strA);
                if (sbA.d() == null) {
                    bundle.putByteArray("data_bytes", "{}".getBytes("UTF-8"));
                    bundle.putString("data_charset", "utf-8");
                    return bundle;
                }
                String strA2 = a(sbA.a("content-type"));
                bundle.putByteArray("data_bytes", sbA.d());
                bundle.putString("data_charset", strA2);
                return bundle;
            }
            if (sbA == null) {
                str2 = "response is null";
            } else {
                str2 = "errCode: " + sbA.a() + ", errInfo: " + sbA.b() + ", statusCode: " + sbA.c() + ", reqKey: " + strA;
            }
            throw new IOException("net sdk error: ".concat(String.valueOf(str2)));
        } catch (Exception e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public Eb(Context context, String str) {
        f2901a = new C(context, "test_uuid", str);
    }

    private static Sb a(InterfaceC0447mb interfaceC0447mb) throws IOException {
        Ia iaA;
        try {
            SystemClock.elapsedRealtime();
            iaA = C0409a.a(f2901a);
        } catch (Throwable unused) {
            iaA = null;
        }
        if (iaA == null) {
            return null;
        }
        return iaA.a(interfaceC0447mb);
    }

    private static String a(String str) {
        if (str != null) {
            for (String str2 : str.split(";")) {
                String strTrim = str2.trim();
                int iIndexOf = strTrim.indexOf("charset=");
                if (-1 != iIndexOf) {
                    return strTrim.substring(iIndexOf + 8, strTrim.length());
                }
            }
        }
        return "GBK";
    }
}
