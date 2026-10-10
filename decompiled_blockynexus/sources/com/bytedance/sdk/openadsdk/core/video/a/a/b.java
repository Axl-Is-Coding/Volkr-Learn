package com.bytedance.sdk.openadsdk.core.video.a.a;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: VideoCacheImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f6401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RandomAccessFile f6402b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile InputStream f6405e;
    private long g;
    private volatile boolean i;
    private boolean j;
    private String k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f6403c = -2147483648L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f6406f = new Object();
    private volatile boolean h = false;

    public b(String str, String str2, File file) {
        this.g = 0L;
        this.i = false;
        this.f6404d = str;
        this.k = str2;
        try {
            this.f6401a = file;
            boolean zF = f();
            this.j = this.j;
            this.f6402b = new RandomAccessFile(this.f6401a, zF ? "r" : "rw");
            this.g = e();
            if (zF) {
                return;
            }
            this.i = true;
            d();
        } catch (IOException unused) {
            o.c("VideoCacheImpl", "Error using file " + file + " as disc cache");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() throws IOException {
        if (f()) {
            return;
        }
        try {
            synchronized (this.f6406f) {
                File file = new File(this.f6401a.getParentFile(), this.f6401a.getName().substring(0, this.f6401a.getName().length() - 9));
                if (!this.f6401a.renameTo(file)) {
                    throw new IOException("Error renaming file " + this.f6401a + " to " + file + " for completion!");
                }
                this.f6401a = file;
                if (this.f6402b != null) {
                    this.f6402b.close();
                }
                this.f6402b = new RandomAccessFile(this.f6401a, "r");
            }
        } catch (IOException e2) {
            throw new IOException("Error opening " + this.f6401a + " as disc cache", e2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.a.a.a
    public long b() throws IOException {
        if (f()) {
            this.f6403c = e();
        } else {
            synchronized (this.f6406f) {
                while (this.f6403c == -2147483648L) {
                    try {
                        o.c("VideoCacheImpl", "length: wait");
                        this.f6406f.wait(5L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        throw new IOException("total length InterruptException");
                    }
                }
            }
        }
        return this.f6403c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.a.a.a
    public boolean c() {
        return this.i;
    }

    public void d() {
        com.bytedance.sdk.openadsdk.i.a.a().b().execute(new com.bytedance.sdk.openadsdk.i.b() { // from class: com.bytedance.sdk.openadsdk.core.video.a.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        try {
                            b.this.f6405e = b.this.a(b.this.e());
                            if (b.this.f6405e == null) {
                                com.bytedance.sdk.openadsdk.core.video.a.a.b(b.this.k);
                                try {
                                    if (b.this.f6405e != null) {
                                        b.this.f6405e.close();
                                    }
                                    if (b.this.e() == b.this.f6403c) {
                                        b.this.g();
                                        b.this.i = false;
                                    }
                                    if (!b.this.h || b.this.f6402b == null) {
                                        return;
                                    }
                                    b.this.f6402b.close();
                                    return;
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            byte[] bArr = new byte[16384];
                            long j = 0;
                            loop0: while (true) {
                                int i = 0;
                                do {
                                    int i2 = b.this.f6405e.read(bArr, i, 16384 - i);
                                    if (i2 == -1) {
                                        break loop0;
                                    }
                                    i += i2;
                                    j += (long) i2;
                                    if (j % PlaybackStateCompat.ACTION_PREPARE == 0) {
                                        break;
                                    }
                                } while (j != b.this.f6403c - b.this.g);
                                synchronized (b.this.f6406f) {
                                    b.this.a(bArr, i);
                                }
                            }
                            com.bytedance.sdk.openadsdk.core.video.a.a.b(b.this.k);
                            if (b.this.f6405e != null) {
                                b.this.f6405e.close();
                            }
                            if (b.this.e() == b.this.f6403c) {
                                b.this.g();
                                b.this.i = false;
                            }
                            if (!b.this.h || b.this.f6402b == null) {
                                return;
                            }
                            b.this.f6402b.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            com.bytedance.sdk.openadsdk.core.video.a.a.b(b.this.k);
                            if (b.this.f6405e != null) {
                                b.this.f6405e.close();
                            }
                            if (b.this.e() == b.this.f6403c) {
                                b.this.g();
                                b.this.i = false;
                            }
                            if (!b.this.h || b.this.f6402b == null) {
                                return;
                            }
                            b.this.f6402b.close();
                        }
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.core.video.a.a.b(b.this.k);
                    try {
                        if (b.this.f6405e != null) {
                            b.this.f6405e.close();
                        }
                        if (b.this.e() == b.this.f6403c) {
                            b.this.g();
                            b.this.i = false;
                        }
                        if (b.this.h && b.this.f6402b != null) {
                            b.this.f6402b.close();
                        }
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            }
        });
    }

    public long e() throws IOException {
        try {
            return this.f6402b.length();
        } catch (IOException e2) {
            throw new IOException("Error reading length of file " + this.f6401a, e2);
        }
    }

    public boolean f() {
        return !this.f6401a.getName().endsWith(".download");
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.a.a.a
    public int a(long j, byte[] bArr, int i, int i2) throws IOException {
        try {
            try {
            } catch (IOException e2) {
                throw new IOException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(e()), Integer.valueOf(bArr.length)), e2);
            }
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        if (j == this.f6403c) {
            return -1;
        }
        int i3 = 0;
        while (!this.h) {
            synchronized (this.f6406f) {
                if (j < e()) {
                    o.c("VideoCacheImpl", "read:  read " + j + " success");
                    this.f6402b.seek(j);
                    i3 = this.f6402b.read(bArr, i, i2);
                } else {
                    o.c("VideoCacheImpl", "read: wait at " + j + "  file size = " + e());
                    this.f6406f.wait(33L);
                }
            }
            if (i3 > 0) {
                return i3;
            }
        }
        return -1;
    }

    public void a(byte[] bArr, int i) throws IOException {
        try {
            this.f6402b.seek(e());
            this.f6402b.write(bArr, 0, i);
            this.f6406f.notifyAll();
            o.c("VideoCacheImpl", "append:  pisition =" + e() + "  length =" + i);
        } catch (IOException e2) {
            throw new IOException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.f6402b, Integer.valueOf(bArr.length)), e2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.a.a.a
    public void a() throws IOException {
        try {
            if (!this.i) {
                this.f6402b.close();
            }
            this.h = true;
        } catch (IOException e2) {
            throw new IOException("Error closing file " + this.f6401a, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream a(long j) throws IOException {
        ab abVarG = new v().a(new y.a().a("RANGE", "bytes=" + j + "-").a(this.f6404d).a().d()).a().g();
        if (abVarG == null) {
            return null;
        }
        this.f6403c = abVarG.a() + j;
        return abVarG.b();
    }
}
