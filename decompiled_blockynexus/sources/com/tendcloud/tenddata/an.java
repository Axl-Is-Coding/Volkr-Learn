package com.tendcloud.tenddata;

import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
final class an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f19785a = 60000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f19786b = 60000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private URL f19787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ar f19788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private aq f19789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ap f19790f;
    private String g;
    private String h;
    private String i;
    private int j;
    private int k;

    /* JADX INFO: compiled from: td */
    public static final class a {
        private ap body;
        private String cert;
        private aq headers;
        private String host;
        private String ip;
        private ar method;
        private URL url;
        private int connectionTimeout = 60000;
        private int readTimeout = 60000;

        a() {
        }

        public a body(ap apVar) {
            this.body = apVar;
            return this;
        }

        public an build() {
            return new an(this.url, this.method, this.headers, this.body, this.connectionTimeout, this.readTimeout, this.cert, this.host, this.ip);
        }

        public a cert(String str) {
            this.cert = str;
            return this;
        }

        public a connectionTimeout(int i) {
            this.connectionTimeout = i;
            return this;
        }

        public a header(aq aqVar) {
            this.headers = aqVar;
            return this;
        }

        public a host(String str) {
            this.host = str;
            return this;
        }

        public a ip(String str) {
            this.ip = str;
            return this;
        }

        public a method(ar arVar) {
            this.method = arVar;
            return this;
        }

        public a readTimeout(int i) {
            this.readTimeout = i;
            return this;
        }

        public a url(String str) {
            try {
                this.url = new URL(str);
                return this;
            } catch (MalformedURLException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
    }

    public ar a() {
        return this.f19788d;
    }

    as b() {
        as asVarA = as.a("");
        try {
            return a(false);
        } catch (Throwable th) {
            bp.postSDKError(th);
            return asVarA;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n url: ");
        sb.append(this.f19787c);
        sb.append("\n method: ");
        sb.append(this.f19788d);
        sb.append("\n headers: ");
        sb.append(this.f19789e);
        sb.append("\n content length: ");
        ap apVar = this.f19790f;
        sb.append(apVar != null ? Integer.valueOf(apVar.a().length) : "");
        sb.append("\n content Type: ");
        ap apVar2 = this.f19790f;
        sb.append(apVar2 != null ? apVar2.b() : "");
        sb.append("\n host: ");
        sb.append(this.h);
        sb.append("\n ip: ");
        sb.append(this.i);
        sb.append("\n connectionTimeout: ");
        sb.append(this.j);
        sb.append("\n readTimeout: ");
        sb.append(this.k);
        sb.append("\n cert:  ");
        sb.append(this.g);
        sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        return sb.toString();
    }

    private an(URL url, ar arVar, aq aqVar, ap apVar, int i, int i2, String str, String str2, String str3) {
        this.f19787c = url;
        this.f19788d = arVar;
        this.f19789e = aqVar;
        this.f19790f = apVar;
        this.j = i;
        this.k = i2;
        this.g = str;
        this.h = str2;
        this.i = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.tendcloud.tenddata.as a(boolean r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r6 = 0
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L98 java.lang.Throwable -> L9c
            java.net.URL r2 = r5.f19787c     // Catch: java.lang.Throwable -> L98 java.lang.Throwable -> L9c
            java.net.URLConnection r2 = r2.openConnection()     // Catch: java.lang.Throwable -> L98 java.lang.Throwable -> L9c
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch: java.lang.Throwable -> L98 java.lang.Throwable -> L9c
            r6 = 60000(0xea60, float:8.4078E-41)
            r2.setConnectTimeout(r6)     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            r2.setReadTimeout(r6)     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            java.net.URL r6 = r5.f19787c     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            if (r6 == 0) goto L3b
            java.net.URL r6 = r5.f19787c     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            java.lang.String r3 = "https://"
            boolean r6 = r6.startsWith(r3)     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            if (r6 == 0) goto L3b
            java.util.HashMap<java.lang.Long, java.lang.String> r6 = com.tendcloud.tenddata.ak.f19778a     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            long r3 = r3.getId()     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            java.lang.String r4 = r5.h     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            r6.put(r3, r4)     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
        L3b:
            java.lang.String r6 = r5.g     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            boolean r6 = com.tendcloud.tenddata.af.b(r6)     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            if (r6 != 0) goto L48
            java.lang.String r6 = r5.g     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            com.tendcloud.tenddata.ak.a(r2, r6)     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
        L48:
            java.lang.String r6 = r5.h     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            boolean r6 = com.tendcloud.tenddata.af.b(r6)     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            if (r6 != 0) goto L6a
            java.lang.String r6 = "Host"
            java.net.URL r3 = r5.f19787c     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            java.lang.String r3 = r3.getHost()     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            boolean r3 = com.tendcloud.tenddata.af.b(r3)     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            if (r3 == 0) goto L61
            java.lang.String r3 = r5.h     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            goto L67
        L61:
            java.net.URL r3 = r5.f19787c     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            java.lang.String r3 = r3.getHost()     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
        L67:
            r2.setRequestProperty(r6, r3)     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
        L6a:
            com.tendcloud.tenddata.ar r6 = r5.f19788d     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            if (r6 == 0) goto L73
            com.tendcloud.tenddata.ar r6 = r5.f19788d     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            r6.a(r2)     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
        L73:
            com.tendcloud.tenddata.aq r6 = r5.f19789e     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            if (r6 == 0) goto L7c
            com.tendcloud.tenddata.aq r6 = r5.f19789e     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            r6.a(r2)     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
        L7c:
            com.tendcloud.tenddata.ap r6 = r5.f19790f     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            if (r6 == 0) goto L85
            com.tendcloud.tenddata.ap r6 = r5.f19790f     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            r6.a(r2)     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
        L85:
            r2.connect()     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            java.lang.String r6 = r5.h     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            com.tendcloud.tenddata.ap r3 = r5.f19790f     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            com.tendcloud.tenddata.as r6 = com.tendcloud.tenddata.as.a(r6, r2, r0, r3)     // Catch: java.lang.Throwable -> L96 java.lang.Throwable -> Lae
            if (r2 == 0) goto Lad
        L92:
            r2.disconnect()
            goto Lad
        L96:
            r6 = move-exception
            goto L9f
        L98:
            r0 = move-exception
            r2 = r6
            r6 = r0
            goto Laf
        L9c:
            r0 = move-exception
            r2 = r6
            r6 = r0
        L9f:
            com.tendcloud.tenddata.bp.postSDKError(r6)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> Lae
            com.tendcloud.tenddata.as r6 = com.tendcloud.tenddata.as.a(r6)     // Catch: java.lang.Throwable -> Lae
            if (r2 == 0) goto Lad
            goto L92
        Lad:
            return r6
        Lae:
            r6 = move-exception
        Laf:
            if (r2 == 0) goto Lb4
            r2.disconnect()
        Lb4:
            goto Lb6
        Lb5:
            throw r6
        Lb6:
            goto Lb5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.an.a(boolean):com.tendcloud.tenddata.as");
    }
}
