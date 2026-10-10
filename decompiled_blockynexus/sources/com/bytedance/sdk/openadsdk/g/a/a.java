package com.bytedance.sdk.openadsdk.g.a;

import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.utils.h;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: GifCache.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f6760a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile a f6761e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakHashMap<String, String> f6762b = new WeakHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LruCache<String, C0087a> f6764d = new LruCache<String, C0087a>(5242880) { // from class: com.bytedance.sdk.openadsdk.g.a.a.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, C0087a c0087a) {
            byte[] bArr = c0087a.f6766a;
            int length = bArr != null ? 0 + bArr.length : 0;
            return length == 0 ? super.sizeOf(str, c0087a) : length;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z, String str, C0087a c0087a, C0087a c0087a2) {
            super.entryRemoved(z, str, c0087a, c0087a2);
            if (!z || c0087a == null) {
                return;
            }
            c0087a.f6766a = null;
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.b.a f6763c = new d();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.g.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GifCache.java */
    public static class C0087a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        byte[] f6766a;

        public C0087a(byte[] bArr) {
            this.f6766a = bArr;
        }
    }

    private a() {
    }

    public static a a() {
        if (f6761e == null) {
            synchronized (a.class) {
                if (f6761e == null) {
                    f6761e = new a();
                }
            }
        }
        return f6761e;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0081 A[Catch: all -> 0x0090, Throwable -> 0x0092, TryCatch #8 {all -> 0x0090, Throwable -> 0x0092, blocks: (B:25:0x0067, B:27:0x0073, B:29:0x007b, B:31:0x0081, B:32:0x0084, B:33:0x0087), top: B:70:0x0067 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void b(java.lang.String r8, byte[] r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> Lac
            if (r0 != 0) goto Laa
            if (r9 != 0) goto Lb
            goto Laa
        Lb:
            boolean r0 = r7.a(r9)     // Catch: java.lang.Throwable -> Lac
            if (r0 != 0) goto L24
            android.util.LruCache<java.lang.String, com.bytedance.sdk.openadsdk.g.a.a$a> r0 = r7.f6764d     // Catch: java.lang.Throwable -> L1c java.lang.Throwable -> Lac
            com.bytedance.sdk.openadsdk.g.a.a$a r1 = new com.bytedance.sdk.openadsdk.g.a.a$a     // Catch: java.lang.Throwable -> L1c java.lang.Throwable -> Lac
            r1.<init>(r9)     // Catch: java.lang.Throwable -> L1c java.lang.Throwable -> Lac
            r0.put(r8, r1)     // Catch: java.lang.Throwable -> L1c java.lang.Throwable -> Lac
            goto L24
        L1c:
            r0 = move-exception
            java.lang.String r1 = "GifCache"
            java.lang.String r2 = "gifCache mLruCache.put error "
            com.bytedance.sdk.openadsdk.utils.o.c(r1, r2, r0)     // Catch: java.lang.Throwable -> Lac
        L24:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> Lac
            java.lang.String r1 = b()     // Catch: java.lang.Throwable -> Lac
            r0.<init>(r1, r8)     // Catch: java.lang.Throwable -> Lac
            boolean r8 = r0.exists()     // Catch: java.lang.Throwable -> Lac
            r1 = 0
            if (r8 == 0) goto L45
            boolean r8 = r0.isFile()     // Catch: java.lang.Throwable -> Lac
            if (r8 == 0) goto L45
            long r3 = r0.length()     // Catch: java.lang.Throwable -> Lac
            int r8 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r8 <= 0) goto L45
            monitor-exit(r7)
            return
        L45:
            java.io.File r8 = new java.io.File     // Catch: java.lang.Throwable -> Lac
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac
            r3.<init>()     // Catch: java.lang.Throwable -> Lac
            r3.append(r0)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r4 = ".tmp"
            r3.append(r4)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lac
            r8.<init>(r3)     // Catch: java.lang.Throwable -> Lac
            r8.delete()     // Catch: java.lang.Throwable -> Lac
            r3 = 0
            r8.createNewFile()     // Catch: java.lang.Throwable -> L94 java.lang.Throwable -> L97
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L94 java.lang.Throwable -> L97
            r4.<init>(r8)     // Catch: java.lang.Throwable -> L94 java.lang.Throwable -> L97
            r4.write(r9)     // Catch: java.lang.Throwable -> L90 java.lang.Throwable -> L92
            r4.flush()     // Catch: java.lang.Throwable -> L90 java.lang.Throwable -> L92
            boolean r9 = r8.exists()     // Catch: java.lang.Throwable -> L90 java.lang.Throwable -> L92
            if (r9 == 0) goto L87
            long r5 = r8.length()     // Catch: java.lang.Throwable -> L90 java.lang.Throwable -> L92
            int r9 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r9 <= 0) goto L87
            boolean r9 = r0.exists()     // Catch: java.lang.Throwable -> L90 java.lang.Throwable -> L92
            if (r9 == 0) goto L84
            r0.delete()     // Catch: java.lang.Throwable -> L90 java.lang.Throwable -> L92
        L84:
            r8.renameTo(r0)     // Catch: java.lang.Throwable -> L90 java.lang.Throwable -> L92
        L87:
            com.bytedance.sdk.openadsdk.b.a r9 = r7.f6763c     // Catch: java.lang.Throwable -> L90 java.lang.Throwable -> L92
            r9.a(r0)     // Catch: java.lang.Throwable -> L90 java.lang.Throwable -> L92
            r4.close()     // Catch: java.io.IOException -> La2 java.lang.Throwable -> Lac
            goto La2
        L90:
            r8 = move-exception
            goto La4
        L92:
            r3 = r4
            goto L97
        L94:
            r8 = move-exception
            r4 = r3
            goto La4
        L97:
            r8.delete()     // Catch: java.lang.Throwable -> L94
            r0.delete()     // Catch: java.lang.Throwable -> L94
            if (r3 == 0) goto La2
            r3.close()     // Catch: java.io.IOException -> La2 java.lang.Throwable -> Lac
        La2:
            monitor-exit(r7)
            return
        La4:
            if (r4 == 0) goto La9
            r4.close()     // Catch: java.io.IOException -> La9 java.lang.Throwable -> Lac
        La9:
            throw r8     // Catch: java.lang.Throwable -> Lac
        Laa:
            monitor-exit(r7)
            return
        Lac:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.g.a.a.b(java.lang.String, byte[]):void");
    }

    public synchronized void a(String str, byte[] bArr) {
        b(str, bArr);
    }

    private boolean a(byte[] bArr) {
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public synchronized File a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(b(), str);
        if (file.exists()) {
            if (file.length() > 0) {
                return file;
            }
        }
        return null;
    }

    public synchronized String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("https")) {
            str = str.replaceFirst("https", "http");
        }
        String str2 = this.f6762b.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String strA = h.a(str);
        this.f6762b.put(str, strA);
        return strA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public synchronized C0087a b(String str) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0087a c0087a = this.f6764d.get(str);
        if (c0087a != null) {
            return c0087a;
        }
        File file = new File(b(), str);
        ?? Exists = file.exists();
        try {
            if (Exists != 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(Long.valueOf(file.length()).intValue());
                        fileInputStream.getChannel().read(byteBufferAllocate);
                        byte[] bArrArray = byteBufferAllocate.array();
                        try {
                            C0087a c0087a2 = new C0087a(bArrArray);
                            try {
                                fileInputStream.close();
                            } catch (IOException unused) {
                            }
                            return c0087a2;
                        } catch (Throwable unused2) {
                            if (bArrArray != null) {
                                C0087a c0087a3 = new C0087a(bArrArray);
                                this.f6764d.put(str, c0087a3);
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused3) {
                                }
                                return c0087a3;
                            }
                            try {
                                fileInputStream.close();
                            } catch (IOException unused4) {
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        o.c("GifCache", "gifCache get error ", th);
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static String b() {
        if (TextUtils.isEmpty(f6760a)) {
            File file = new File(com.bytedance.sdk.adnet.a.b(com.bytedance.sdk.openadsdk.core.o.a()), "diskGif");
            file.mkdirs();
            f6760a = file.getAbsolutePath();
        }
        return f6760a;
    }
}
