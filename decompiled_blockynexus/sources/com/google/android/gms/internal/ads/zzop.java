package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzop implements zzom {
    private static final Pattern zzbie = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzbif = new AtomicReference<>();
    private final boolean zzbig;
    private final int zzbih;
    private final int zzbii;
    private final String zzbij;
    private final zzpm<String> zzbik;
    private final zzou zzbil;
    private final zzou zzbim;
    private final zzpa<? super zzop> zzbin;
    private zzon zzbio;
    private HttpURLConnection zzbip;
    private InputStream zzbiq;
    private boolean zzbir;
    private long zzbis;
    private long zzbit;
    private long zzbiu;
    private long zzcq;

    public zzop(String str, zzpm<String> zzpmVar, zzpa<? super zzop> zzpaVar, int i, int i2, boolean z, zzou zzouVar) {
        zzoz.checkNotEmpty(str);
        this.zzbij = str;
        this.zzbik = null;
        this.zzbin = zzpaVar;
        this.zzbim = new zzou();
        this.zzbih = i;
        this.zzbii = i2;
        this.zzbig = true;
        this.zzbil = null;
    }

    private static long zzc(HttpURLConnection httpURLConnection) {
        long j;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (TextUtils.isEmpty(headerField)) {
            j = -1;
        } else {
            try {
                j = Long.parseLong(headerField);
            } catch (NumberFormatException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(headerField).length() + 28);
                sb.append("Unexpected Content-Length [");
                sb.append(headerField);
                sb.append("]");
                Log.e("DefaultHttpDataSource", sb.toString());
                j = -1;
            }
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField2)) {
            return j;
        }
        Matcher matcher = zzbie.matcher(headerField2);
        if (!matcher.find()) {
            return j;
        }
        try {
            long j2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            if (j < 0) {
                return j2;
            }
            if (j == j2) {
                return j;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(headerField).length() + 26 + String.valueOf(headerField2).length());
            sb2.append("Inconsistent headers [");
            sb2.append(headerField);
            sb2.append("] [");
            sb2.append(headerField2);
            sb2.append("]");
            Log.w("DefaultHttpDataSource", sb2.toString());
            return Math.max(j, j2);
        } catch (NumberFormatException unused2) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(headerField2).length() + 27);
            sb3.append("Unexpected Content-Range [");
            sb3.append(headerField2);
            sb3.append("]");
            Log.e("DefaultHttpDataSource", sb3.toString());
            return j;
        }
    }

    private final void zziq() {
        HttpURLConnection httpURLConnection = this.zzbip;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
            this.zzbip = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003a A[Catch: Exception -> 0x006b, all -> 0x008e, TryCatch #0 {Exception -> 0x006b, blocks: (B:14:0x0024, B:16:0x002c, B:21:0x003a, B:23:0x004a, B:25:0x0052), top: B:45:0x0024 }] */
    @Override // com.google.android.gms.internal.ads.zzom
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() throws com.google.android.gms.internal.ads.zzos {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.zzbiq     // Catch: java.lang.Throwable -> L8e
            if (r2 == 0) goto L7b
            java.net.HttpURLConnection r2 = r9.zzbip     // Catch: java.lang.Throwable -> L8e
            long r3 = r9.zzbit     // Catch: java.lang.Throwable -> L8e
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L13
            long r3 = r9.zzbit     // Catch: java.lang.Throwable -> L8e
            goto L18
        L13:
            long r3 = r9.zzbit     // Catch: java.lang.Throwable -> L8e
            long r7 = r9.zzcq     // Catch: java.lang.Throwable -> L8e
            long r3 = r3 - r7
        L18:
            int r7 = com.google.android.gms.internal.ads.zzpq.SDK_INT     // Catch: java.lang.Throwable -> L8e
            r8 = 19
            if (r7 == r8) goto L24
            int r7 = com.google.android.gms.internal.ads.zzpq.SDK_INT     // Catch: java.lang.Throwable -> L8e
            r8 = 20
            if (r7 != r8) goto L6b
        L24:
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L34
            int r3 = r2.read()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            r4 = -1
            if (r3 != r4) goto L3a
            goto L6b
        L34:
            r5 = 2048(0x800, double:1.012E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L6b
        L3a:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            if (r4 != 0) goto L52
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            if (r3 == 0) goto L6b
        L52:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            java.lang.Class r3 = r3.getSuperclass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            r4 = 1
            r3.setAccessible(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            r3.invoke(r2, r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
        L6b:
            java.io.InputStream r2 = r9.zzbiq     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L8e
            r2.close()     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L8e
            goto L7b
        L71:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzos r3 = new com.google.android.gms.internal.ads.zzos     // Catch: java.lang.Throwable -> L8e
            com.google.android.gms.internal.ads.zzon r4 = r9.zzbio     // Catch: java.lang.Throwable -> L8e
            r5 = 3
            r3.<init>(r2, r4, r5)     // Catch: java.lang.Throwable -> L8e
            throw r3     // Catch: java.lang.Throwable -> L8e
        L7b:
            r9.zzbiq = r0
            r9.zziq()
            boolean r0 = r9.zzbir
            if (r0 == 0) goto L8d
            r9.zzbir = r1
            com.google.android.gms.internal.ads.zzpa<? super com.google.android.gms.internal.ads.zzop> r0 = r9.zzbin
            if (r0 == 0) goto L8d
            r0.zze(r9)
        L8d:
            return
        L8e:
            r2 = move-exception
            r9.zzbiq = r0
            r9.zziq()
            boolean r0 = r9.zzbir
            if (r0 == 0) goto La1
            r9.zzbir = r1
            com.google.android.gms.internal.ads.zzpa<? super com.google.android.gms.internal.ads.zzop> r0 = r9.zzbin
            if (r0 == 0) goto La1
            r0.zze(r9)
        La1:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzop.close():void");
    }

    public final Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.zzbip;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.zzbip;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final int read(byte[] bArr, int i, int i2) throws zzos {
        try {
            if (this.zzbiu != this.zzbis) {
                byte[] andSet = zzbif.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.zzbiu != this.zzbis) {
                    int i3 = this.zzbiq.read(andSet, 0, (int) Math.min(this.zzbis - this.zzbiu, andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (i3 == -1) {
                        throw new EOFException();
                    }
                    this.zzbiu += (long) i3;
                    if (this.zzbin != null) {
                        this.zzbin.zzc(this, i3);
                    }
                }
                zzbif.set(andSet);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.zzbit != -1) {
                long j = this.zzbit - this.zzcq;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j);
            }
            int i4 = this.zzbiq.read(bArr, i, i2);
            if (i4 == -1) {
                if (this.zzbit == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.zzcq += (long) i4;
            if (this.zzbin != null) {
                this.zzbin.zzc(this, i4);
            }
            return i4;
        } catch (IOException e2) {
            throw new zzos(e2, this.zzbio, 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0097  */
    @Override // com.google.android.gms.internal.ads.zzom
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zza(com.google.android.gms.internal.ads.zzon r25) throws com.google.android.gms.internal.ads.zzos {
        /*
            Method dump skipped, instruction units count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzop.zza(com.google.android.gms.internal.ads.zzon):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.net.HttpURLConnection zza(java.net.URL r6, byte[] r7, long r8, long r10, boolean r12, boolean r13) throws java.io.IOException {
        /*
            r5 = this;
            java.net.URLConnection r6 = r6.openConnection()
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6
            int r0 = r5.zzbih
            r6.setConnectTimeout(r0)
            int r0 = r5.zzbii
            r6.setReadTimeout(r0)
            com.google.android.gms.internal.ads.zzou r0 = r5.zzbim
            java.util.Map r0 = r0.zzit()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L1e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L3a
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r6.setRequestProperty(r2, r1)
            goto L1e
        L3a:
            r0 = 0
            r2 = -1
            int r4 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r4 != 0) goto L46
            int r0 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r0 == 0) goto L88
        L46:
            r0 = 27
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "bytes="
            r1.append(r0)
            r1.append(r8)
            java.lang.String r0 = "-"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            int r1 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r1 == 0) goto L83
            java.lang.String r0 = java.lang.String.valueOf(r0)
            long r8 = r8 + r10
            r10 = 1
            long r8 = r8 - r10
            java.lang.String r10 = java.lang.String.valueOf(r0)
            int r10 = r10.length()
            int r10 = r10 + 20
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r10)
            r11.append(r0)
            r11.append(r8)
            java.lang.String r0 = r11.toString()
        L83:
            java.lang.String r8 = "Range"
            r6.setRequestProperty(r8, r0)
        L88:
            java.lang.String r8 = r5.zzbij
            java.lang.String r9 = "User-Agent"
            r6.setRequestProperty(r9, r8)
            if (r12 != 0) goto L98
            java.lang.String r8 = "Accept-Encoding"
            java.lang.String r9 = "identity"
            r6.setRequestProperty(r8, r9)
        L98:
            r6.setInstanceFollowRedirects(r13)
            if (r7 == 0) goto L9f
            r8 = 1
            goto La0
        L9f:
            r8 = 0
        La0:
            r6.setDoOutput(r8)
            if (r7 == 0) goto Lbf
            java.lang.String r8 = "POST"
            r6.setRequestMethod(r8)
            int r8 = r7.length
            if (r8 == 0) goto Lbf
            int r8 = r7.length
            r6.setFixedLengthStreamingMode(r8)
            r6.connect()
            java.io.OutputStream r8 = r6.getOutputStream()
            r8.write(r7)
            r8.close()
            goto Lc2
        Lbf:
            r6.connect()
        Lc2:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzop.zza(java.net.URL, byte[], long, long, boolean, boolean):java.net.HttpURLConnection");
    }
}
