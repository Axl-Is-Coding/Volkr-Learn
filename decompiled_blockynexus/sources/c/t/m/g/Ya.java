package c.t.m.g;

import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import io.grpc.internal.GrpcUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLException;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Ya {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0423eb f3057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f3061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f3062f;
    public String g;
    public String h;
    public String i;
    public String j;
    public int k;
    public String l;
    public long m;
    private String r;
    public volatile long n = 0;
    public volatile long o = 0;
    public volatile long p = 0;
    public volatile String q = "";
    private int s = 0;
    private int t = 0;
    private int u = 0;
    public boolean v = true;
    public boolean w = true;
    public boolean x = true;
    private boolean y = false;
    private boolean z = false;
    private boolean A = false;
    private boolean B = false;
    private long C = 20000;
    private long D = com.tendcloud.tenddata.ab.R;
    private String E = "7.1.6.1";
    private String F = "190409";
    public String G = "7.1.6.1";

    /* JADX INFO: compiled from: TL */
    public interface a {
        byte[] a(byte[] bArr);
    }

    /* JADX INFO: compiled from: TL */
    public interface b {
        void a(String str);

        void b(String str);
    }

    public Ya(C0423eb c0423eb) {
        this.f3057a = c0423eb;
    }

    public static void a(String str, byte[] bArr, int i, b bVar) {
        while (true) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
                httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                httpURLConnection.setRequestMethod(GrpcUtil.HTTP_METHOD);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.setRequestProperty("Connection", "close");
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    bVar.b("net sdk error: ".concat(String.valueOf(responseCode)));
                } else {
                    bVar.a(new String(a(httpURLConnection.getInputStream()), a(httpURLConnection.getHeaderField("content-type"))));
                }
                httpURLConnection.disconnect();
                return;
            } catch (Throwable th) {
                if (i > 0 || !((th instanceof GeneralSecurityException) || (th instanceof SSLException))) {
                    bVar.b("tryTime=" + i + "," + str + "," + Log.getStackTraceString(th));
                }
                str = str.replaceAll("https:", "http:");
                i++;
            }
        }
        bVar.b("tryTime=" + i + "," + str + "," + Log.getStackTraceString(th));
    }

    public final String b() {
        return TextUtils.isEmpty(this.f3060d) ? "0123456789ABCDEF" : this.f3060d;
    }

    public final String c() {
        return (TextUtils.isEmpty(this.f3062f) || this.f3062f.contains("0000")) ? "0123456789ABCDEF" : this.f3062f;
    }

    public final String d() {
        String str = this.E;
        return str == null ? "None" : str;
    }

    public final String e() {
        String str = this.F;
        return str == null ? "None" : str;
    }

    public final String f() {
        if (this.r == null) {
            StringBuilder sb = new StringBuilder(100);
            sb.append(a());
            sb.append("_");
            sb.append(b());
            sb.append("_");
            sb.append(c());
            sb.append("_QQGeoLocation");
            this.r = Wb.a(sb.toString());
        }
        return this.r;
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
        byte[] bArrA = Sa.a().a(512);
        while (true) {
            int i = inputStream.read(bArrA);
            if (i != -1) {
                byteArrayOutputStream.write(bArrA, 0, i);
            } else {
                inputStream.close();
                Sa.a().a(bArrA);
                return byteArrayOutputStream.toByteArray();
            }
        }
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

    public final String a() {
        return TextUtils.isEmpty(this.f3059c) ? "0123456789ABCDEF" : this.f3059c;
    }
}
