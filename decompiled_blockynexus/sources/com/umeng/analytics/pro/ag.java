package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import io.grpc.internal.GrpcUtil;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: HttpManager.java */
/* JADX INFO: loaded from: classes5.dex */
public class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f20628a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f20629b = 20000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static HostnameVerifier f20630c;

    private static HostnameVerifier a(HttpsURLConnection httpsURLConnection) {
        if (f20630c == null) {
            f20630c = new HostnameVerifier() { // from class: com.umeng.analytics.pro.ag.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    return "ucc.umeng.com".equalsIgnoreCase(str) || "pslog.umeng.com".equalsIgnoreCase(str);
                }
            };
        }
        return f20630c;
    }

    public static String b(String str, String str2) {
        for (int i = 0; i < 3; i++) {
            try {
                HttpsURLConnection httpsURLConnectionC = c(str, str2);
                if (httpsURLConnectionC == null || httpsURLConnectionC.getResponseCode() != 200) {
                    return null;
                }
                InputStreamReader inputStreamReader = new InputStreamReader(httpsURLConnectionC.getInputStream());
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int i2 = inputStreamReader.read();
                    if (i2 == -1) {
                        return stringBuffer.toString();
                    }
                    stringBuffer.append((char) i2);
                }
            } catch (Exception unused) {
                if (i == 2) {
                    return null;
                }
                try {
                    Thread.sleep(20000L);
                } catch (InterruptedException unused2) {
                }
            }
        }
        return null;
    }

    private static HttpsURLConnection c(String str, String str2) {
        HttpsURLConnection httpsURLConnection;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        } catch (Exception e2) {
            e = e2;
            httpsURLConnection = null;
        }
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(a(httpsURLConnection));
            httpsURLConnection.setRequestMethod(GrpcUtil.HTTP_METHOD);
            httpsURLConnection.setConnectTimeout(15000);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setReadTimeout(15000);
            httpsURLConnection.setRequestProperty("Content-Type", AbstractSpiCall.ACCEPT_JSON_VALUE);
            httpsURLConnection.connect();
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            outputStream.write(str2.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
        }
        return httpsURLConnection;
    }

    public static String a(String str, JSONObject jSONObject) {
        return b(str, jSONObject.toString());
    }

    public static String a(String str, JSONArray jSONArray) {
        return b(str, jSONArray.toString());
    }

    public static String a(String str, String str2) {
        return b(str, str2);
    }
}
