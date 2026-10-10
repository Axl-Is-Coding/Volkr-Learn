package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbek implements zzom {
    private static final Pattern zzbie = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzbif = new AtomicReference<>();
    private final int zzbih;
    private final int zzbii;
    private final String zzbij;
    private final zzou zzbim;
    private final zzpa<? super zzbek> zzbin;
    private zzon zzbio;
    private HttpURLConnection zzbip;
    private InputStream zzbiq;
    private boolean zzbir;
    private long zzbis;
    private long zzbit;
    private long zzbiu;
    private long zzcq;
    private int zzeka;
    private SSLSocketFactory zzejz = new zzben(this);
    private Set<Socket> zzekb = new HashSet();

    zzbek(String str, zzpa<? super zzbek> zzpaVar, int i, int i2, int i3) {
        zzoz.checkNotEmpty(str);
        this.zzbij = str;
        this.zzbin = zzpaVar;
        this.zzbim = new zzou();
        this.zzbih = i;
        this.zzbii = i2;
        this.zzeka = i3;
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
                zzbbq.zzfc(sb.toString());
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
            zzbbq.zzfe(sb2.toString());
            return Math.max(j, j2);
        } catch (NumberFormatException unused2) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(headerField2).length() + 27);
            sb3.append("Unexpected Content-Range [");
            sb3.append(headerField2);
            sb3.append("]");
            zzbbq.zzfc(sb3.toString());
            return j;
        }
    }

    private final void zziq() {
        HttpURLConnection httpURLConnection = this.zzbip;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                zzbbq.zzc("Unexpected error while disconnecting", e2);
            }
            this.zzbip = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003a A[Catch: Exception -> 0x006b, all -> 0x0093, TryCatch #0 {all -> 0x0093, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x0010, B:9:0x0018, B:11:0x001e, B:26:0x006b, B:29:0x0072, B:30:0x007a, B:14:0x0024, B:16:0x002c, B:21:0x003a, B:23:0x004a, B:25:0x0052, B:8:0x0013), top: B:47:0x0002, inners: #2 }] */
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
            java.io.InputStream r2 = r9.zzbiq     // Catch: java.lang.Throwable -> L93
            if (r2 == 0) goto L7b
            java.net.HttpURLConnection r2 = r9.zzbip     // Catch: java.lang.Throwable -> L93
            long r3 = r9.zzbit     // Catch: java.lang.Throwable -> L93
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L13
            long r3 = r9.zzbit     // Catch: java.lang.Throwable -> L93
            goto L18
        L13:
            long r3 = r9.zzbit     // Catch: java.lang.Throwable -> L93
            long r7 = r9.zzcq     // Catch: java.lang.Throwable -> L93
            long r3 = r3 - r7
        L18:
            int r7 = com.google.android.gms.internal.ads.zzpq.SDK_INT     // Catch: java.lang.Throwable -> L93
            r8 = 19
            if (r7 == r8) goto L24
            int r7 = com.google.android.gms.internal.ads.zzpq.SDK_INT     // Catch: java.lang.Throwable -> L93
            r8 = 20
            if (r7 != r8) goto L6b
        L24:
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L34
            int r3 = r2.read()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            r4 = -1
            if (r3 != r4) goto L3a
            goto L6b
        L34:
            r5 = 2048(0x800, double:1.012E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L6b
        L3a:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            if (r4 != 0) goto L52
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            if (r3 == 0) goto L6b
        L52:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.Class r3 = r3.getSuperclass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            r4 = 1
            r3.setAccessible(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            r3.invoke(r2, r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
        L6b:
            java.io.InputStream r2 = r9.zzbiq     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L93
            r2.close()     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L93
            goto L7b
        L71:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzos r3 = new com.google.android.gms.internal.ads.zzos     // Catch: java.lang.Throwable -> L93
            com.google.android.gms.internal.ads.zzon r4 = r9.zzbio     // Catch: java.lang.Throwable -> L93
            r5 = 3
            r3.<init>(r2, r4, r5)     // Catch: java.lang.Throwable -> L93
            throw r3     // Catch: java.lang.Throwable -> L93
        L7b:
            r9.zzbiq = r0
            r9.zziq()
            boolean r0 = r9.zzbir
            if (r0 == 0) goto L8d
            r9.zzbir = r1
            com.google.android.gms.internal.ads.zzpa<? super com.google.android.gms.internal.ads.zzbek> r0 = r9.zzbin
            if (r0 == 0) goto L8d
            r0.zze(r9)
        L8d:
            java.util.Set<java.net.Socket> r0 = r9.zzekb
            r0.clear()
            return
        L93:
            r2 = move-exception
            r9.zzbiq = r0
            r9.zziq()
            boolean r0 = r9.zzbir
            if (r0 == 0) goto La6
            r9.zzbir = r1
            com.google.android.gms.internal.ads.zzpa<? super com.google.android.gms.internal.ads.zzbek> r0 = r9.zzbin
            if (r0 == 0) goto La6
            r0.zze(r9)
        La6:
            java.util.Set<java.net.Socket> r0 = r9.zzekb
            r0.clear()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbek.close():void");
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

    final void setReceiveBufferSize(int i) {
        this.zzeka = i;
        for (Socket socket : this.zzekb) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzeka);
                } catch (SocketException e2) {
                    zzbbq.zzd("Failed to update receive buffer size.", e2);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:?, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x012d, code lost:
    
        r23.zzbip = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012f, code lost:
    
        r0 = r23.zzbip.getResponseCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0137, code lost:
    
        if (r0 < 200) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x013b, code lost:
    
        if (r0 <= 299) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013e, code lost:
    
        if (r0 != 200) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0140, code lost:
    
        r4 = r24.position;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0146, code lost:
    
        if (r4 == 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0149, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x014b, code lost:
    
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x014c, code lost:
    
        r23.zzbis = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0153, code lost:
    
        if (r24.isFlagSet(1) != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0155, code lost:
    
        r3 = r24.zzcp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x015b, code lost:
    
        if (r3 == (-1)) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x015d, code lost:
    
        r23.zzbit = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0160, code lost:
    
        r3 = zzc(r23.zzbip);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0168, code lost:
    
        if (r3 == (-1)) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x016a, code lost:
    
        r3 = r3 - r23.zzbis;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x016e, code lost:
    
        r3 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x016f, code lost:
    
        r23.zzbit = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0172, code lost:
    
        r23.zzbit = r24.zzcp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0176, code lost:
    
        r23.zzbiq = r23.zzbip.getInputStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x017e, code lost:
    
        r23.zzbir = true;
        r0 = r23.zzbin;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0183, code lost:
    
        if (r0 == null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0185, code lost:
    
        r0.zza(r23, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x018a, code lost:
    
        return r23.zzbit;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x018b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x018c, code lost:
    
        zziq();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0195, code lost:
    
        throw new com.google.android.gms.internal.ads.zzos(r0, r24, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0196, code lost:
    
        r3 = r23.zzbip.getHeaderFields();
        zziq();
        r4 = new com.google.android.gms.internal.ads.zzor(r0, r3, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01a6, code lost:
    
        if (r0 != 416) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01a8, code lost:
    
        r4.initCause(new com.google.android.gms.internal.ads.zzoo(0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01b1, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01b2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01b3, code lost:
    
        zziq();
        r5 = java.lang.String.valueOf(r24.uri.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c6, code lost:
    
        if (r5.length() != 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01c8, code lost:
    
        r3 = "Unable to connect to ".concat(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01cd, code lost:
    
        r3 = new java.lang.String("Unable to connect to ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d7, code lost:
    
        throw new com.google.android.gms.internal.ads.zzos(r3, r0, r24, 1);
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010a A[Catch: IOException -> 0x0245, TryCatch #0 {IOException -> 0x0245, blocks: (B:3:0x000f, B:4:0x0027, B:6:0x002d, B:8:0x0037, B:9:0x003f, B:10:0x0057, B:12:0x005d, B:24:0x00d2, B:26:0x00db, B:27:0x00e2, B:31:0x00eb, B:33:0x00f0, B:35:0x00f8, B:37:0x010d, B:51:0x012d, B:96:0x01dc, B:98:0x01e7, B:100:0x01f8, B:102:0x0200, B:104:0x020e, B:106:0x0218, B:107:0x021b, B:105:0x0213, B:109:0x0224, B:110:0x022b, B:36:0x010a, B:19:0x0087, B:21:0x00a3, B:23:0x00cd, B:111:0x022c, B:112:0x0244), top: B:121:0x000f }] */
    @Override // com.google.android.gms.internal.ads.zzom
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zza(com.google.android.gms.internal.ads.zzon r24) throws com.google.android.gms.internal.ads.zzos {
        /*
            Method dump skipped, instruction units count: 618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbek.zza(com.google.android.gms.internal.ads.zzon):long");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Socket socket) {
        this.zzekb.add(socket);
    }
}
