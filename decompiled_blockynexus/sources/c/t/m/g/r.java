package c.t.m.g;

import android.os.SystemClock;
import android.text.TextUtils;
import c.t.m.g.qc;
import io.grpc.internal.GrpcUtil;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes.dex */
public final class r extends AbstractC0442l {
    long B;
    private C0454p G;
    private HttpURLConnection p;
    private DataOutputStream q;
    private DataInputStream r;
    private C0457q s;
    private String t;
    private boolean u;
    private boolean v;
    private int x;
    private String z;
    private String w = "";
    private long y = 0;
    private a A = new a(0);
    boolean C = false;
    private boolean D = false;
    int E = 0;
    boolean F = false;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f3363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f3364b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f3365c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f3366d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f3367e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f3368f;
        long g;
        long h;
        long i;
        long j;
        long k;

        private a() {
            this.g = -1L;
            this.h = -1L;
            this.i = -1L;
            this.j = -1L;
            this.k = -1L;
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void a() {
            long j = this.f3364b;
            this.g = j - this.f3363a;
            long j2 = this.f3365c;
            this.h = j2 - j;
            long j3 = this.f3366d;
            this.i = j3 - j2;
            long j4 = this.f3367e;
            this.j = j4 - j3;
            this.k = this.f3368f - j4;
            long j5 = this.g;
            if (j5 < 0) {
                j5 = -1;
            }
            this.g = j5;
            long j6 = this.h;
            if (j6 < 0) {
                j6 = -1;
            }
            this.h = j6;
            long j7 = this.i;
            if (j7 < 0) {
                j7 = -1;
            }
            this.i = j7;
            long j8 = this.j;
            if (j8 < 0) {
                j8 = -1;
            }
            this.j = j8;
            long j9 = this.k;
            if (j9 < 0) {
                j9 = -1;
            }
            this.k = j9;
        }

        public final String toString() {
            return "Stat{startToTryConnect=" + this.g + ", connectCost=" + this.h + ", connectToPost=" + this.i + ", postToRsp=" + this.j + ", rspToRead=" + this.k + '}';
        }
    }

    public r(String str, String str2, boolean z, Map<String, String> map, byte[] bArr, int i, String str3) {
        this.t = str;
        this.f3284b = str2;
        this.f3285c = z;
        this.f3286d = map;
        this.f3287e = bArr;
        int iA = qc.g() == 2 ? qc.a.a("direct_access_time_out", 1000, 60000, 15000) : qc.a.a("direct_access_time_out", 1000, 60000, 10000);
        this.f3288f = C0455pa.a(i < iA ? i : iA, 200, 60000, 10000);
        this.g = str3;
    }

    private void a(int i) throws IOException {
        int i2;
        C0457q c0457q;
        String strConcat;
        boolean z = false;
        try {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(this.p.getInputStream());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                i2 = 0;
                while (true) {
                    try {
                        int i3 = bufferedInputStream.read(bArr);
                        if (i3 == -1) {
                            z = true;
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i3);
                        i2 += i3;
                        if (i2 > i) {
                            this.s.f3344a = -303;
                            this.s.f3345b = "no-content-length";
                            break;
                        }
                    } catch (OutOfMemoryError unused) {
                        c0457q = this.s;
                        c0457q.f3344a = -306;
                        strConcat = "no-content-length:".concat(String.valueOf(i2));
                        c0457q.f3345b = strConcat;
                    }
                }
                if (z) {
                    this.s.f3347d = byteArrayOutputStream.toByteArray();
                    this.A.f3368f = SystemClock.elapsedRealtime();
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                c0457q = this.s;
                c0457q.f3344a = -287;
                strConcat = "read without content-length error";
                c0457q.f3345b = strConcat;
            }
        } catch (OutOfMemoryError unused4) {
            i2 = 0;
        }
    }

    private void b() {
        Map<String, String> map = this.f3286d;
        boolean z = false;
        if (map != null && map.size() > 0) {
            for (String str : this.f3286d.keySet()) {
                this.p.addRequestProperty(str, this.f3286d.get(str));
                if (str.toLowerCase().contains("host")) {
                    z = true;
                }
            }
        }
        if (!z) {
            this.p.setRequestProperty("Host", this.t);
        }
        this.p.setRequestProperty("Halley", this.g + "-" + this.E + "-" + System.currentTimeMillis());
        if (this.C) {
            this.p.setRequestProperty("X-Online-Host", this.t);
            this.p.setRequestProperty("x-tx-host", this.t);
        }
    }

    private void c() {
        try {
            if (this.p != null) {
                this.p.disconnect();
            }
            if (this.q != null) {
                this.q.close();
            }
            if (this.r != null) {
                this.r.close();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // c.t.m.g.AbstractC0442l
    public final C0457q a() {
        HttpURLConnection httpURLConnection;
        C0457q c0457q;
        String string;
        this.m = System.currentTimeMillis();
        this.B = SystemClock.elapsedRealtime();
        this.A.f3363a = this.B;
        this.s = new C0457q(0, "");
        try {
            try {
                URL url = new URL(this.f3284b);
                this.u = url.getProtocol().toLowerCase().startsWith("https");
                this.v = C0455pa.d(url.getHost());
                if (this.u) {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((!this.C || qc.k() == null) ? url.openConnection() : url.openConnection(qc.k()));
                    httpURLConnection = httpsURLConnection;
                    if (this.v) {
                        this.G = new C0454p(this.t);
                        httpsURLConnection.setSSLSocketFactory(this.G);
                        httpsURLConnection.setHostnameVerifier(new C0451o(this.t));
                        httpURLConnection = httpsURLConnection;
                    }
                } else {
                    httpURLConnection = (HttpURLConnection) ((!this.C || qc.k() == null) ? url.openConnection() : url.openConnection(qc.k()));
                }
                this.p = httpURLConnection;
                this.p.setRequestMethod(this.f3285c ? "GET" : GrpcUtil.HTTP_METHOD);
                this.p.setConnectTimeout(this.f3288f);
                this.p.setReadTimeout(this.f3288f);
                this.p.setUseCaches(false);
                this.p.setDoInput(true);
                this.p.setInstanceFollowRedirects(false);
                b();
                if (!this.f3285c && !C0455pa.a(this.f3287e)) {
                    this.p.setDoOutput(true);
                    this.y = this.f3287e.length;
                }
                this.A.f3364b = SystemClock.elapsedRealtime();
                this.p.connect();
                this.A.f3365c = SystemClock.elapsedRealtime();
                if (!this.f3285c && !C0455pa.a(this.f3287e)) {
                    this.q = new DataOutputStream(this.p.getOutputStream());
                    this.q.write(this.f3287e);
                    this.q.flush();
                }
                this.A.f3366d = SystemClock.elapsedRealtime();
                int responseCode = this.p.getResponseCode();
                this.A.f3367e = SystemClock.elapsedRealtime();
                this.s.f3346c = responseCode;
                this.w = this.p.getContentType();
                HashMap map = new HashMap();
                for (Map.Entry<String, List<String>> entry : this.p.getHeaderFields().entrySet()) {
                    if (entry.getKey() != null) {
                        map.put(entry.getKey(), entry.getValue().get(0));
                    }
                }
                this.s.a(map);
                if (this.s.f3346c >= 200 && this.s.f3346c < 300) {
                    this.x = this.p.getContentLength();
                    int iA = qc.a.a("app_receive_pack_size", 524288, 10485760, 2097152);
                    if (this.x < 0) {
                        a(iA);
                    } else if (this.x == 0) {
                        this.s.f3347d = new byte[0];
                        this.A.f3368f = SystemClock.elapsedRealtime();
                    } else {
                        if (this.x > iA) {
                            this.s.f3344a = -303;
                            c0457q = this.s;
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.x);
                            string = sb.toString();
                        } else {
                            try {
                                byte[] bArr = new byte[this.x];
                                this.r = new DataInputStream(this.p.getInputStream());
                                this.r.readFully(bArr);
                                this.s.f3347d = bArr;
                                this.A.f3368f = SystemClock.elapsedRealtime();
                            } catch (OutOfMemoryError unused) {
                                this.s.f3344a = -306;
                                c0457q = this.s;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(this.x);
                                string = sb2.toString();
                                c0457q.f3345b = string;
                            }
                        }
                        c0457q.f3345b = string;
                    }
                } else if (this.s.f3346c >= 300 && this.s.f3346c < 400) {
                    this.h = this.s.a("location");
                }
            } catch (MalformedURLException unused2) {
                this.s.f3344a = -300;
                c();
                this.B = SystemClock.elapsedRealtime() - this.B;
                this.A.a();
                if (this.s.f3344a != 0 && qc.h() && this.s.f3344a != -20) {
                    if ((qc.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) == 1 ? 1 : 0) != 0) {
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                this.s.f3344a = -287;
                this.s.f3345b = th.getClass().getSimpleName() + "(" + th.getLocalizedMessage() + ")";
                boolean z = (this.G != null && this.G.f3339c) || (this.u && this.s.f3345b.toLowerCase().contains("cannot verify hostname")) || (this.u && this.s.f3345b.toLowerCase().contains("not verified"));
                if (!qc.h()) {
                    this.s.f3344a = -4;
                } else if (z) {
                    this.s.f3344a = -289;
                } else {
                    this.i = true;
                    if (th.getMessage() != null && th.getMessage().toLowerCase().contains("permission")) {
                        this.s.f3344a = -281;
                        this.s.f3345b = "no permission";
                    } else if (th instanceof UnknownHostException) {
                        this.s.f3344a = -284;
                    } else if (th instanceof ConnectException) {
                        this.s.f3344a = -42;
                    } else if (th instanceof SocketTimeoutException) {
                        String localizedMessage = th.getLocalizedMessage();
                        if (localizedMessage == null || !(localizedMessage.toLowerCase().contains("connect") || localizedMessage.toLowerCase().contains("connection"))) {
                            this.s.f3344a = -13;
                        } else {
                            this.s.f3344a = -10;
                        }
                    } else if (th instanceof SocketException) {
                        this.s.f3344a = -41;
                    } else if (th instanceof IOException) {
                        this.s.f3344a = -286;
                    }
                }
                c();
                this.B = SystemClock.elapsedRealtime() - this.B;
                this.A.a();
                if (this.s.f3344a != 0 && qc.h() && this.s.f3344a != -20) {
                    if ((qc.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) == 1 ? 1 : 0) != 0) {
                    }
                }
            }
            return this.s;
        } finally {
            c();
            this.B = SystemClock.elapsedRealtime() - this.B;
            this.A.a();
            if (this.s.f3344a != 0 && qc.h() && this.s.f3344a != -20) {
                if ((qc.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) == 1 ? 1 : 0) != 0) {
                    this.z = C0455pa.c(this.t);
                }
            }
        }
    }

    public final void a(Map<String, String> map, Map<String, String> map2) {
        int i;
        HashMap map3 = new HashMap();
        map3.putAll(map);
        StringBuilder sb = new StringBuilder();
        sb.append(this.B);
        map3.put("B59", sb.toString());
        if (this.u) {
            map3.put("B85", "1");
        }
        if (this.f3285c) {
            map3.put("B95", "1");
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.y);
            map3.put("B96", sb2.toString());
        }
        if (!this.v) {
            map3.put("B23", "1");
        }
        HashMap map4 = new HashMap();
        map4.putAll(map2);
        if (this.m != 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.m);
            map4.put("B84", sb3.toString());
        }
        map4.put("B87", this.w);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.x);
        map4.put("B88", sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.A.g);
        map4.put("B90", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append(this.A.h);
        map4.put("B91", sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append(this.A.i);
        map4.put("B92", sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append(this.A.j);
        map4.put("B93", sb8.toString());
        StringBuilder sb9 = new StringBuilder();
        sb9.append(this.A.k);
        map4.put("B94", sb9.toString());
        if (!TextUtils.isEmpty(this.h)) {
            map4.put("B47", this.h);
        }
        if (!TextUtils.isEmpty(this.z)) {
            map4.put("B41", this.z);
        }
        C0457q c0457q = this.s;
        int i2 = c0457q.f3344a;
        if (i2 != 0) {
            i = i2;
        } else {
            int i3 = c0457q.f3346c;
            i = i3 == 200 ? 0 : i3;
        }
        if (!this.F || i == -4) {
            C0449na.b("HLHttpDirect", fc.c(), i, this.s.f3345b, map3, map4, this.i);
        } else {
            C0449na.a("HLHttpDirect", fc.c(), i, this.s.f3345b, map3, map4, this.i);
        }
    }

    @Override // c.t.m.g.AbstractC0442l
    public final void a(boolean z) {
    }
}
