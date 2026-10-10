package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManagerEx;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import io.grpc.internal.GrpcUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: NetworkHelper.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f21249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f21250f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f21251a = "10.0.0.172";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f21252b = 80;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f21253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f21254d;

    public c(Context context) {
        this.f21253c = context;
    }

    private void b() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f21253c, "domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f21253c, "domain_s", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(strImprintProperty2);
        }
        String strImprintProperty3 = UMEnvelopeBuild.imprintProperty(this.f21253c, "oversea_domain_p", "");
        String strImprintProperty4 = UMEnvelopeBuild.imprintProperty(this.f21253c, "oversea_domain_s", "");
        if (!TextUtils.isEmpty(strImprintProperty3)) {
            UMServerURL.OVERSEA_DEFAULT_URL = DataHelper.assembleURL(strImprintProperty3);
        }
        if (!TextUtils.isEmpty(strImprintProperty4)) {
            UMServerURL.OVERSEA_SECONDARY_URL = DataHelper.assembleURL(strImprintProperty4);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.OVERSEA_DEFAULT_URL, UMServerURL.OVERSEA_SECONDARY_URL};
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.f21143b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.f21143b.startsWith("460") || com.umeng.commonsdk.statistics.b.f21143b.startsWith("461")) {
            AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
        }
    }

    private void c() {
        if (f21250f) {
            return;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 注册零号报文 imprint 应答处理回调。");
        ImprintHandler.getImprintService(this.f21253c).registPreProcessCallback(AnalyticsConstants.ZERO_RESPONSE_FLAG, new UMImprintPreProcessCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
            public boolean onPreProcessImprintKey(String str, String str2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManagerEx.a().a(c.this.f21253c);
                UMWorkDispatch.sendEvent(c.this.f21253c, com.umeng.commonsdk.internal.a.s, com.umeng.commonsdk.internal.b.a(c.this.f21253c).a(), null);
                ImprintHandler.getImprintService(c.this.f21253c).a(AnalyticsConstants.ZERO_RESPONSE_FLAG);
                return true;
            }
        });
        ImprintHandler.getImprintService(this.f21253c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.2
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                if (FieldManagerEx.b()) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> onImprintValueChanged: FieldManagerEx类已经完成init，忽略此配置下发。");
                    ImprintHandler.getImprintService(c.this.f21253c).unregistImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, this);
                    return;
                }
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManagerEx.a().a(c.this.f21253c, str2);
                UMWorkDispatch.sendEvent(c.this.f21253c, com.umeng.commonsdk.internal.a.s, com.umeng.commonsdk.internal.b.a(c.this.f21253c).a(), null);
                ImprintHandler.getImprintService(c.this.f21253c).unregistImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, this);
            }
        });
        f21250f = true;
    }

    private boolean d() {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        if (this.f21253c.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f21253c.getPackageName()) != 0) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f21253c.getSystemService("connectivity");
            if (DeviceConfig.checkPermission(this.f21253c, "android.permission.ACCESS_NETWORK_STATE") && connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() != 1 && (extraInfo = activeNetworkInfo.getExtraInfo()) != null) {
                if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap")) {
                    if (extraInfo.equals("uniwap")) {
                    }
                }
                return true;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f21253c, th);
        }
        return false;
    }

    public void a(b bVar) {
        this.f21254d = bVar;
    }

    private void a() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f21253c, "domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f21253c, "domain_s", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(strImprintProperty2);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    }

    private String a(String str) {
        try {
            URL url = new URL(str);
            String protocol = url.getProtocol();
            String host = url.getHost();
            if (!TextUtils.isEmpty(protocol) && !TextUtils.isEmpty(host)) {
                return new URL(protocol, host, UMServerURL.ZCFG_PATH).toString();
            }
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public byte[] a(byte[] bArr, boolean z, boolean z2) throws Throwable {
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            UMServerURL.DEFAULT_URL = UMServerURL.OVERSEA_DEFAULT_URL;
            UMServerURL.SECONDARY_URL = UMServerURL.OVERSEA_SECONDARY_URL;
            b();
        }
        int i = 0;
        byte[] bArrA = null;
        while (true) {
            String[] strArr = AnalyticsConstants.APPLOG_URL_LIST;
            if (i >= strArr.length) {
                break;
            }
            String strA = strArr[i];
            if (z2) {
                strA = a(strA);
                c();
            }
            bArrA = a(bArr, strA);
            if (bArrA != null) {
                b bVar = this.f21254d;
                if (bVar != null) {
                    bVar.onRequestSucceed(z);
                }
            } else {
                b bVar2 = this.f21254d;
                if (bVar2 != null) {
                    bVar2.onRequestFailed();
                }
                i++;
            }
        }
        return bArrA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x018c: MOVE (r3 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:90:0x018c */
    /* JADX WARN: Type inference failed for: r11v11, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v2 */
    public byte[] a(byte[] bArr, String str) throws Throwable {
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        OutputStream outputStream3 = null;
        try {
            try {
                if (this.f21254d != null) {
                    this.f21254d.onRequestStart();
                }
                if (d()) {
                    str = (HttpsURLConnection) new URL(str).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.f21251a, this.f21252b)));
                } else {
                    str = (HttpsURLConnection) new URL(str).openConnection();
                }
            } catch (Throwable th) {
                th = th;
                outputStream3 = outputStream2;
            }
        } catch (UnknownHostException unused) {
            str = 0;
            outputStream = null;
        } catch (SSLHandshakeException unused2) {
            str = 0;
            outputStream = null;
        } catch (Throwable unused3) {
            httpsURLConnection = 0;
            outputStream = null;
        }
        try {
            if (!f21249e) {
                str.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, new SecureRandom());
                str.setSSLSocketFactory(sSLContext.getSocketFactory());
                f21249e = true;
            }
            str.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
            str.setRequestProperty("X-Umeng-Sdk", a.a(this.f21253c).b());
            str.setRequestProperty("Content-Type", a.a(this.f21253c).a());
            str.setRequestProperty("Msg-Type", "envelope/json");
            str.setRequestProperty("X-Umeng-Pro-Ver", "1.0.0");
            str.setConnectTimeout(30000);
            str.setReadTimeout(30000);
            str.setRequestMethod(GrpcUtil.HTTP_METHOD);
            str.setDoOutput(true);
            str.setDoInput(true);
            boolean z = false;
            str.setUseCaches(false);
            outputStream = str.getOutputStream();
            try {
                outputStream.write(bArr);
                outputStream.flush();
                str.connect();
                if (this.f21254d != null) {
                    this.f21254d.onRequestEnd();
                }
                int responseCode = str.getResponseCode();
                String headerField = str.getHeaderField("Content-Type");
                if (!TextUtils.isEmpty(headerField) && headerField.equalsIgnoreCase("application/thrift")) {
                    z = true;
                }
                boolean z2 = AnalyticsConstants.UM_DEBUG;
                if (responseCode != 200 || !z) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e2) {
                            UMCrashManager.reportCrash(this.f21253c, e2);
                        }
                    }
                    if (str != 0) {
                        try {
                            str.getInputStream().close();
                        } catch (IOException unused4) {
                        }
                        str.disconnect();
                    }
                    return null;
                }
                InputStream inputStream = str.getInputStream();
                try {
                    byte[] streamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e3) {
                            UMCrashManager.reportCrash(this.f21253c, e3);
                        }
                    }
                    if (str != 0) {
                        try {
                            str.getInputStream().close();
                        } catch (IOException unused5) {
                        }
                        str.disconnect();
                    }
                    return streamToByteArray;
                } finally {
                    HelperUtils.safeClose(inputStream);
                }
            } catch (UnknownHostException unused6) {
                UMLog.aq("A_10200", 2, "\\|");
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e4) {
                        UMCrashManager.reportCrash(this.f21253c, e4);
                    }
                }
                if (str != 0) {
                    try {
                        str.getInputStream().close();
                    } catch (IOException unused7) {
                    }
                    str.disconnect();
                }
                return null;
            } catch (SSLHandshakeException unused8) {
                UMLog.aq("A_10201", 2, "\\|");
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e5) {
                        UMCrashManager.reportCrash(this.f21253c, e5);
                    }
                }
                if (str != 0) {
                    try {
                        str.getInputStream().close();
                    } catch (IOException unused9) {
                    }
                    str.disconnect();
                }
                return null;
            } catch (Throwable unused10) {
                httpsURLConnection = str;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e6) {
                        UMCrashManager.reportCrash(this.f21253c, e6);
                    }
                }
                if (httpsURLConnection != 0) {
                    try {
                        httpsURLConnection.getInputStream().close();
                    } catch (IOException unused11) {
                    }
                    httpsURLConnection.disconnect();
                }
                return null;
            }
        } catch (UnknownHostException unused12) {
            outputStream = null;
        } catch (SSLHandshakeException unused13) {
            outputStream = null;
        } catch (Throwable unused14) {
            outputStream = null;
            httpsURLConnection = str;
        }
    }
}
