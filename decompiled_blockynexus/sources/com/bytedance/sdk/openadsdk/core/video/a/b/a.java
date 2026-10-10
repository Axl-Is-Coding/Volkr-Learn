package com.bytedance.sdk.openadsdk.core.video.a.b;

import android.content.Context;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.openadsdk.core.video.a.a.c;
import com.bytedance.sdk.openadsdk.i.b;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;

/* JADX INFO: compiled from: VideoPreload.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final HashSet<String> f6413e = new HashSet<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6417d;

    public a(Context context, String str, String str2, long j) {
        this.f6414a = context;
        this.f6415b = j;
        this.f6416c = str;
        this.f6417d = str2;
    }

    public boolean a() {
        return c.a(this.f6414a, this.f6417d).exists();
    }

    public void b() {
        if (a()) {
            o.c("VideoPreload", "Cache file is exist");
            return;
        }
        synchronized (f6413e) {
            if (com.bytedance.sdk.openadsdk.core.video.a.a.a(this.f6417d) == null && !f6413e.contains(this.f6417d)) {
                f6413e.add(this.f6417d);
                com.bytedance.sdk.openadsdk.i.a.a().b().execute(new b() { // from class: com.bytedance.sdk.openadsdk.core.video.a.b.a.1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.sdk.a.b.e] */
                    /* JADX WARN: Type inference failed for: r0v13 */
                    /* JADX WARN: Type inference failed for: r0v14 */
                    /* JADX WARN: Type inference failed for: r0v16, types: [com.bytedance.sdk.a.b.ab] */
                    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.sdk.a.b.ab] */
                    /* JADX WARN: Type inference failed for: r0v27, types: [com.bytedance.sdk.a.b.ab] */
                    /* JADX WARN: Type inference failed for: r3v12 */
                    /* JADX WARN: Type inference failed for: r3v13 */
                    /* JADX WARN: Type inference failed for: r3v14, types: [java.io.InputStream] */
                    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.String] */
                    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.InputStream] */
                    /* JADX WARN: Type inference failed for: r3v7 */
                    /* JADX WARN: Type inference failed for: r3v8 */
                    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.InputStream] */
                    @Override // java.lang.Runnable
                    public void run() throws Throwable {
                        FileOutputStream fileOutputStream;
                        ?? B = "RANGE";
                        ?? A = new v().a(new y.a().a("RANGE", "bytes=0-" + a.this.f6415b).a(a.this.f6416c).a().d());
                        File fileB = c.b(a.this.f6414a, a.this.f6417d);
                        FileOutputStream fileOutputStream2 = null;
                        try {
                            try {
                                try {
                                    A = A.a().g();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                                try {
                                    B = A.b();
                                    if (B == 0) {
                                        if (B != 0) {
                                            try {
                                                B.close();
                                            } catch (IOException e3) {
                                                e3.printStackTrace();
                                                return;
                                            }
                                        }
                                        if (A != 0) {
                                            A.close();
                                        }
                                        synchronized (a.f6413e) {
                                            a.f6413e.remove(a.this.f6417d);
                                        }
                                        if (com.bytedance.sdk.openadsdk.core.video.a.a.a(a.this.f6417d) != null) {
                                            fileB.delete();
                                            return;
                                        }
                                        if (!fileB.renameTo(c.a(a.this.f6414a, a.this.f6417d))) {
                                            fileB.delete();
                                        }
                                        o.c("VideoPreload", "preload success md5 = " + a.this.f6417d);
                                        return;
                                    }
                                    try {
                                        if (fileB.exists()) {
                                            fileB.delete();
                                        }
                                        fileOutputStream = new FileOutputStream(fileB);
                                    } catch (IOException e4) {
                                        e = e4;
                                    }
                                    try {
                                        byte[] bArr = new byte[16384];
                                        while (true) {
                                            int i = B.read(bArr);
                                            if (i == -1) {
                                                break;
                                            } else {
                                                fileOutputStream.write(bArr, 0, i);
                                            }
                                            e2.printStackTrace();
                                            return;
                                        }
                                        fileOutputStream.flush();
                                        fileOutputStream.close();
                                        if (B != 0) {
                                            B.close();
                                        }
                                        if (A != 0) {
                                            A.close();
                                        }
                                        synchronized (a.f6413e) {
                                            a.f6413e.remove(a.this.f6417d);
                                        }
                                        if (com.bytedance.sdk.openadsdk.core.video.a.a.a(a.this.f6417d) != null) {
                                            fileB.delete();
                                            return;
                                        }
                                        if (!fileB.renameTo(c.a(a.this.f6414a, a.this.f6417d))) {
                                            fileB.delete();
                                        }
                                        o.c("VideoPreload", "preload success md5 = " + a.this.f6417d);
                                    } catch (IOException e5) {
                                        e = e5;
                                        fileOutputStream2 = fileOutputStream;
                                        e.printStackTrace();
                                        if (fileOutputStream2 != null) {
                                            fileOutputStream2.close();
                                        }
                                        if (B != 0) {
                                            B.close();
                                        }
                                        if (A != 0) {
                                            A.close();
                                        }
                                        synchronized (a.f6413e) {
                                            a.f6413e.remove(a.this.f6417d);
                                        }
                                        if (com.bytedance.sdk.openadsdk.core.video.a.a.a(a.this.f6417d) != null) {
                                            fileB.delete();
                                            return;
                                        }
                                        if (!fileB.renameTo(c.a(a.this.f6414a, a.this.f6417d))) {
                                            fileB.delete();
                                        }
                                        o.c("VideoPreload", "preload success md5 = " + a.this.f6417d);
                                    } catch (Throwable th) {
                                        th = th;
                                        fileOutputStream2 = fileOutputStream;
                                        if (fileOutputStream2 != null) {
                                            try {
                                                fileOutputStream2.close();
                                            } catch (IOException e6) {
                                                e6.printStackTrace();
                                                throw th;
                                            }
                                        }
                                        if (B != 0) {
                                            B.close();
                                        }
                                        if (A != 0) {
                                            A.close();
                                        }
                                        synchronized (a.f6413e) {
                                            a.f6413e.remove(a.this.f6417d);
                                        }
                                        if (com.bytedance.sdk.openadsdk.core.video.a.a.a(a.this.f6417d) == null) {
                                            if (!fileB.renameTo(c.a(a.this.f6414a, a.this.f6417d))) {
                                                fileB.delete();
                                            }
                                            o.c("VideoPreload", "preload success md5 = " + a.this.f6417d);
                                        } else {
                                            fileB.delete();
                                        }
                                        throw th;
                                    }
                                } catch (IOException e7) {
                                    e = e7;
                                    B = 0;
                                } catch (Throwable th2) {
                                    th = th2;
                                    B = 0;
                                }
                            } catch (IOException e8) {
                                e = e8;
                                A = 0;
                                B = 0;
                            } catch (Throwable th3) {
                                th = th3;
                                A = 0;
                                B = 0;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                });
                return;
            }
            o.c("VideoPreload", "Cache file is downloading ...");
        }
    }
}
