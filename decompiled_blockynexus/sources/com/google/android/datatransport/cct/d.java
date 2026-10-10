package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.cct.internal.a;
import com.google.android.datatransport.cct.internal.o;
import com.google.android.datatransport.cct.internal.p;
import com.google.android.datatransport.cct.internal.q;
import com.google.android.datatransport.cct.internal.r;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.g;
import com.google.android.datatransport.runtime.backends.m;
import com.google.android.datatransport.runtime.k;
import com.google.android.datatransport.runtime.l;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.just.agentweb.AgentWebPermissions;
import io.grpc.internal.GrpcUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: CctTransportBackend.java */
/* JADX INFO: loaded from: classes.dex */
final class d implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataEncoder f12732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConnectivityManager f12733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f12734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final URL f12735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.e.a f12736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.e.a f12737f;
    private final int g;

    /* JADX INFO: compiled from: CctTransportBackend.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final URL f12738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final o f12739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f12740c;

        a(URL url, o oVar, String str) {
            this.f12738a = url;
            this.f12739b = oVar;
            this.f12740c = str;
        }

        a a(URL url) {
            return new a(url, this.f12739b, this.f12740c);
        }
    }

    /* JADX INFO: compiled from: CctTransportBackend.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f12741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final URL f12742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f12743c;

        b(int i, URL url, long j) {
            this.f12741a = i;
            this.f12742b = url;
            this.f12743c = j;
        }
    }

    d(Context context, com.google.android.datatransport.runtime.e.a aVar, com.google.android.datatransport.runtime.e.a aVar2, int i) {
        this.f12732a = o.a();
        this.f12734c = context;
        this.f12733b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f12735d = a(com.google.android.datatransport.cct.a.f12724a);
        this.f12736e = aVar2;
        this.f12737f = aVar;
        this.g = i;
    }

    private static URL a(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Invalid url: " + str, e2);
        }
    }

    private static TelephonyManager b(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static int b(NetworkInfo networkInfo) {
        return networkInfo == null ? NetworkConnectionInfo.NetworkType.NONE.getValue() : networkInfo.getType();
    }

    private static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            com.google.android.datatransport.runtime.b.a.a("CctTransportBackend", "Unable to find version code for package", (Throwable) e2);
            return -1;
        }
    }

    private o b(g gVar) {
        p.a aVarA;
        HashMap map = new HashMap();
        for (l lVar : gVar.b()) {
            String strG = lVar.g();
            if (!map.containsKey(strG)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(lVar);
                map.put(strG, arrayList);
            } else {
                ((List) map.get(strG)).add(lVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            l lVar2 = (l) ((List) entry.getValue()).get(0);
            q.a aVarA2 = q.a();
            aVarA2.a(QosTier.DEFAULT);
            aVarA2.a(this.f12737f.getTime());
            aVarA2.b(this.f12736e.getTime());
            ClientInfo.a aVarA3 = ClientInfo.a();
            aVarA3.a(ClientInfo.ClientType.ANDROID_FIREBASE);
            a.AbstractC0101a abstractC0101aA = com.google.android.datatransport.cct.internal.a.a();
            abstractC0101aA.a(Integer.valueOf(lVar2.b("sdk-version")));
            abstractC0101aA.i(lVar2.a("model"));
            abstractC0101aA.e(lVar2.a("hardware"));
            abstractC0101aA.c(lVar2.a("device"));
            abstractC0101aA.k(lVar2.a("product"));
            abstractC0101aA.j(lVar2.a("os-uild"));
            abstractC0101aA.g(lVar2.a("manufacturer"));
            abstractC0101aA.d(lVar2.a("fingerprint"));
            abstractC0101aA.b(lVar2.a("country"));
            abstractC0101aA.f(lVar2.a("locale"));
            abstractC0101aA.h(lVar2.a("mcc_mnc"));
            abstractC0101aA.a(lVar2.a("application_build"));
            aVarA3.a(abstractC0101aA.a());
            aVarA2.a(aVarA3.a());
            try {
                aVarA2.a(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                aVarA2.b((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (l lVar3 : (List) entry.getValue()) {
                k kVarD = lVar3.d();
                com.google.android.datatransport.b bVarB = kVarD.b();
                if (bVarB.equals(com.google.android.datatransport.b.a("proto"))) {
                    aVarA = p.a(kVarD.a());
                } else if (bVarB.equals(com.google.android.datatransport.b.a("json"))) {
                    aVarA = p.a(new String(kVarD.a(), Charset.forName("UTF-8")));
                } else {
                    com.google.android.datatransport.runtime.b.a.b("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", bVarB);
                }
                aVarA.a(lVar3.e());
                aVarA.b(lVar3.h());
                aVarA.c(lVar3.c("tz-offset"));
                NetworkConnectionInfo.a aVarA4 = NetworkConnectionInfo.a();
                aVarA4.a(NetworkConnectionInfo.NetworkType.forNumber(lVar3.b("net-type")));
                aVarA4.a(NetworkConnectionInfo.MobileSubtype.forNumber(lVar3.b("mobile-subtype")));
                aVarA.a(aVarA4.a());
                if (lVar3.c() != null) {
                    aVarA.a(lVar3.c());
                }
                arrayList3.add(aVarA.a());
            }
            aVarA2.a(arrayList3);
            arrayList2.add(aVarA2.a());
        }
        return o.a(arrayList2);
    }

    @Override // com.google.android.datatransport.runtime.backends.m
    public l a(l lVar) {
        NetworkInfo activeNetworkInfo = this.f12733b.getActiveNetworkInfo();
        l.a aVarI = lVar.i();
        aVarI.a("sdk-version", Build.VERSION.SDK_INT);
        aVarI.a("model", Build.MODEL);
        aVarI.a("hardware", Build.HARDWARE);
        aVarI.a("device", Build.DEVICE);
        aVarI.a("product", Build.PRODUCT);
        aVarI.a("os-uild", Build.ID);
        aVarI.a("manufacturer", Build.MANUFACTURER);
        aVarI.a("fingerprint", Build.FINGERPRINT);
        aVarI.a("tz-offset", a());
        aVarI.a("net-type", b(activeNetworkInfo));
        aVarI.a("mobile-subtype", a(activeNetworkInfo));
        aVarI.a("country", Locale.getDefault().getCountry());
        aVarI.a("locale", Locale.getDefault().getLanguage());
        aVarI.a("mcc_mnc", b(this.f12734c).getSimOperator());
        aVarI.a("application_build", Integer.toString(a(this.f12734c)));
        return aVarI.a();
    }

    d(Context context, com.google.android.datatransport.runtime.e.a aVar, com.google.android.datatransport.runtime.e.a aVar2) {
        this(context, aVar, aVar2, 40000);
    }

    private static int a(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
        }
        if (NetworkConnectionInfo.MobileSubtype.forNumber(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b a(a aVar) throws IOException {
        com.google.android.datatransport.runtime.b.a.a("CctTransportBackend", "Making request to: %s", aVar.f12738a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f12738a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod(GrpcUtil.HTTP_METHOD);
        httpURLConnection.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, String.format("datatransport/%s android/", "2.3.2"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", AbstractSpiCall.ACCEPT_JSON_VALUE);
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f12740c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f12732a.encode(aVar.f12739b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    com.google.android.datatransport.runtime.b.a.a("CctTransportBackend", "Status Code: " + responseCode);
                    com.google.android.datatransport.runtime.b.a.a("CctTransportBackend", "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                    com.google.android.datatransport.runtime.b.a.a("CctTransportBackend", "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b(responseCode, new URL(httpURLConnection.getHeaderField(AgentWebPermissions.ACTION_LOCATION)), 0L);
                    }
                    if (responseCode != 200) {
                        return new b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream inputStreamA = a(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                        try {
                            b bVar = new b(responseCode, null, r.a(new BufferedReader(new InputStreamReader(inputStreamA))).a());
                            if (inputStreamA != null) {
                                inputStreamA.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bVar;
                        } catch (Throwable th) {
                            if (inputStreamA != null) {
                                try {
                                    inputStreamA.close();
                                } catch (Throwable unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                    throw th3;
                }
            } catch (Throwable th4) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th4;
            }
        } catch (EncodingException e2) {
            e = e2;
            com.google.android.datatransport.runtime.b.a.a("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        } catch (ConnectException e3) {
            e = e3;
            com.google.android.datatransport.runtime.b.a.a("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (UnknownHostException e4) {
            e = e4;
            com.google.android.datatransport.runtime.b.a.a("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (IOException e5) {
            e = e5;
            com.google.android.datatransport.runtime.b.a.a("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        }
    }

    private static InputStream a(InputStream inputStream, String str) throws IOException {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    @Override // com.google.android.datatransport.runtime.backends.m
    public BackendResponse a(g gVar) {
        o oVarB = b(gVar);
        URL urlA = this.f12735d;
        if (gVar.c() != null) {
            try {
                com.google.android.datatransport.cct.a aVarA = com.google.android.datatransport.cct.a.a(gVar.c());
                strC = aVarA.c() != null ? aVarA.c() : null;
                if (aVarA.d() != null) {
                    urlA = a(aVarA.d());
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.a();
            }
        }
        try {
            b bVar = (b) com.google.android.datatransport.runtime.c.b.a(5, new a(urlA, oVarB, strC), com.google.android.datatransport.cct.b.a(this), c.a());
            if (bVar.f12741a == 200) {
                return BackendResponse.a(bVar.f12743c);
            }
            if (bVar.f12741a < 500 && bVar.f12741a != 404) {
                return BackendResponse.a();
            }
            return BackendResponse.d();
        } catch (IOException e2) {
            com.google.android.datatransport.runtime.b.a.a("CctTransportBackend", "Could not make request to the backend", (Throwable) e2);
            return BackendResponse.d();
        }
    }

    static /* synthetic */ a a(a aVar, b bVar) {
        URL url = bVar.f12742b;
        if (url == null) {
            return null;
        }
        com.google.android.datatransport.runtime.b.a.a("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.f12742b);
    }

    static long a() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }
}
