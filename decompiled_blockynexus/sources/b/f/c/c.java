package b.f.c;

import android.net.Uri;
import android.util.Pair;
import io.grpc.internal.GrpcUtil;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ISHttpService.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: compiled from: ISHttpService.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f2609a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f2610b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f2611c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f2612d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f2613e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final String f2614f;
        ArrayList<Pair<String, String>> g;

        /* JADX INFO: renamed from: b.f.c.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ISHttpService.java */
        static class C0042a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            String f2616b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            String f2618d;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            List<Pair<String, String>> f2615a = new ArrayList();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            String f2617c = GrpcUtil.HTTP_METHOD;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f2619e = 15000;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f2620f = 15000;
            String g = "UTF-8";

            C0042a() {
            }

            C0042a a(String str) {
                this.f2618d = str;
                return this;
            }

            C0042a b(String str) {
                this.f2616b = str;
                return this;
            }

            C0042a c(String str) {
                this.f2617c = str;
                return this;
            }

            C0042a a(List<Pair<String, String>> list) {
                this.f2615a.addAll(list);
                return this;
            }

            a a() {
                return new a(this);
            }
        }

        public a(C0042a c0042a) {
            this.f2609a = c0042a.f2616b;
            this.f2610b = c0042a.f2617c;
            this.f2611c = c0042a.f2618d;
            this.g = new ArrayList<>(c0042a.f2615a);
            this.f2612d = c0042a.f2619e;
            this.f2613e = c0042a.f2620f;
            this.f2614f = c0042a.g;
        }

        boolean a() {
            return GrpcUtil.HTTP_METHOD.equals(this.f2610b);
        }
    }

    public static d a(String str, String str2, List<Pair<String, String>> list) throws Exception {
        Uri uriBuild = Uri.parse(str).buildUpon().encodedQuery(str2).build();
        a.C0042a c0042a = new a.C0042a();
        c0042a.b(uriBuild.toString());
        c0042a.a(str2);
        c0042a.c("GET");
        c0042a.a(list);
        return a(c0042a.a());
    }

    public static d b(String str, String str2, List<Pair<String, String>> list) throws Exception {
        a.C0042a c0042a = new a.C0042a();
        c0042a.b(str);
        c0042a.a(str2);
        c0042a.c(GrpcUtil.HTTP_METHOD);
        c0042a.a(list);
        return a(c0042a.a());
    }

    private static HttpURLConnection b(a aVar) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(aVar.f2609a).openConnection();
        httpURLConnection.setConnectTimeout(aVar.f2612d);
        httpURLConnection.setReadTimeout(aVar.f2613e);
        httpURLConnection.setRequestMethod(aVar.f2610b);
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static b.f.c.d a(b.f.c.c.a r7) throws java.lang.Exception {
        /*
            java.lang.String r0 = r7.f2609a
            java.lang.String r1 = r7.f2611c
            boolean r0 = a(r0, r1)
            if (r0 == 0) goto L94
            b.f.c.d r0 = new b.f.c.d
            r0.<init>()
            r1 = 0
            java.net.HttpURLConnection r2 = b(r7)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4c
            java.util.ArrayList<android.util.Pair<java.lang.String, java.lang.String>> r3 = r7.g     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L44
            a(r2, r3)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L44
            boolean r3 = r7.a()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L44
            if (r3 == 0) goto L22
            a(r2, r7)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L44
        L22:
            java.io.InputStream r1 = r2.getInputStream()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L44
            int r3 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L44
            r0.f2621a = r3     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L44
            if (r1 == 0) goto L34
            byte[] r3 = b.f.c.e.a(r1)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L44
            r0.f2622b = r3     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L44
        L34:
            if (r1 == 0) goto L39
            r1.close()
        L39:
            if (r2 == 0) goto L86
            r2.disconnect()
            goto L86
        L3f:
            r7 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L89
        L44:
            r3 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L4e
        L49:
            r7 = move-exception
            r2 = r1
            goto L89
        L4c:
            r3 = move-exception
            r2 = r1
        L4e:
            if (r1 == 0) goto L87
            int r4 = r1.getResponseCode()     // Catch: java.lang.Throwable -> L88
            r0.f2621a = r4     // Catch: java.lang.Throwable -> L88
            r5 = 400(0x190, float:5.6E-43)
            if (r4 < r5) goto L87
            java.lang.String r3 = "ISHttpService"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L88
            r4.<init>()     // Catch: java.lang.Throwable -> L88
            java.lang.String r5 = "Failed post to "
            r4.append(r5)     // Catch: java.lang.Throwable -> L88
            java.lang.String r7 = r7.f2609a     // Catch: java.lang.Throwable -> L88
            r4.append(r7)     // Catch: java.lang.Throwable -> L88
            java.lang.String r7 = " StatusCode: "
            r4.append(r7)     // Catch: java.lang.Throwable -> L88
            int r7 = r0.f2621a     // Catch: java.lang.Throwable -> L88
            r4.append(r7)     // Catch: java.lang.Throwable -> L88
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L88
            android.util.Log.d(r3, r7)     // Catch: java.lang.Throwable -> L88
            if (r2 == 0) goto L81
            r2.close()
        L81:
            if (r1 == 0) goto L86
            r1.disconnect()
        L86:
            return r0
        L87:
            throw r3     // Catch: java.lang.Throwable -> L88
        L88:
            r7 = move-exception
        L89:
            if (r2 == 0) goto L8e
            r2.close()
        L8e:
            if (r1 == 0) goto L93
            r1.disconnect()
        L93:
            throw r7
        L94:
            java.security.InvalidParameterException r7 = new java.security.InvalidParameterException
            java.lang.String r0 = "not valid params"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.c.c.a(b.f.c.c$a):b.f.c.d");
    }

    private static void a(HttpURLConnection httpURLConnection, List<Pair<String, String>> list) throws ProtocolException {
        for (Pair<String, String> pair : list) {
            httpURLConnection.setRequestProperty((String) pair.first, (String) pair.second);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, a aVar) throws Exception {
        httpURLConnection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        try {
            dataOutputStream.write(aVar.f2611c.getBytes(aVar.f2614f));
            dataOutputStream.flush();
        } finally {
            dataOutputStream.close();
        }
    }

    private static boolean a(String str, String str2) {
        return (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) ? false : true;
    }
}
