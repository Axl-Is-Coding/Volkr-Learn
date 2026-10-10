package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.internal.io.FileSystem;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: compiled from: DiskLruCache.java */
/* JADX INFO: loaded from: classes5.dex */
public final class g implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Pattern f23183a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final FileSystem f23184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final File f23185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f23186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f23187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final File f23188f;
    private final int g;
    private long h;
    final int i;
    BufferedSink k;
    int m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    private final Executor t;
    private long j = 0;
    final LinkedHashMap<String, b> l = new LinkedHashMap<>(0, 0.75f, true);
    private long s = 0;
    private final Runnable u = new d(this);

    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class c implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f23200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Source[] f23201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long[] f23202d;

        c(String str, long j, Source[] sourceArr, long[] jArr) {
            this.f23199a = str;
            this.f23200b = j;
            this.f23201c = sourceArr;
            this.f23202d = jArr;
        }

        public Source a(int i) {
            return this.f23201c[i];
        }

        public a b() throws IOException {
            return g.this.a(this.f23199a, this.f23200b);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (Source source : this.f23201c) {
                okhttp3.a.e.a(source);
            }
        }
    }

    g(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        this.f23184b = fileSystem;
        this.f23185c = file;
        this.g = i;
        this.f23186d = new File(file, "journal");
        this.f23187e = new File(file, "journal.tmp");
        this.f23188f = new File(file, "journal.bkp");
        this.i = i2;
        this.h = j;
        this.t = executor;
    }

    public static g a(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            return new g(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), okhttp3.a.e.a("OkHttp DiskLruCache", true)));
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private void e(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.l.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        b bVar = this.l.get(strSubstring);
        if (bVar == null) {
            bVar = new b(strSubstring);
            this.l.put(strSubstring, bVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            bVar.f23197e = true;
            bVar.f23198f = null;
            bVar.a(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            bVar.f23198f = new a(bVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private void f(String str) {
        if (f23183a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private synchronized void q() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private BufferedSink r() throws FileNotFoundException {
        return Okio.buffer(new e(this, this.f23184b.appendingSink(this.f23186d)));
    }

    private void s() throws IOException {
        this.f23184b.delete(this.f23187e);
        Iterator<b> it = this.l.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.f23198f == null) {
                while (i < this.i) {
                    this.j += next.f23194b[i];
                    i++;
                }
            } else {
                next.f23198f = null;
                while (i < this.i) {
                    this.f23184b.delete(next.f23195c[i]);
                    this.f23184b.delete(next.f23196d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    private void t() throws IOException {
        BufferedSource bufferedSourceBuffer = Okio.buffer(this.f23184b.source(this.f23186d));
        try {
            String utf8LineStrict = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict2 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict3 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict4 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict5 = bufferedSourceBuffer.readUtf8LineStrict();
            if (!"libcore.io.DiskLruCache".equals(utf8LineStrict) || !"1".equals(utf8LineStrict2) || !Integer.toString(this.g).equals(utf8LineStrict3) || !Integer.toString(this.i).equals(utf8LineStrict4) || !"".equals(utf8LineStrict5)) {
                throw new IOException("unexpected journal header: [" + utf8LineStrict + ", " + utf8LineStrict2 + ", " + utf8LineStrict4 + ", " + utf8LineStrict5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    e(bufferedSourceBuffer.readUtf8LineStrict());
                    i++;
                } catch (EOFException unused) {
                    this.m = i - this.l.size();
                    if (bufferedSourceBuffer.exhausted()) {
                        this.k = r();
                    } else {
                        n();
                    }
                    okhttp3.a.e.a(bufferedSourceBuffer);
                    return;
                }
            }
        } catch (Throwable th) {
            okhttp3.a.e.a(bufferedSourceBuffer);
            throw th;
        }
    }

    public void b() throws IOException {
        close();
        this.f23184b.deleteContents(this.f23185c);
    }

    public synchronized c c(String str) throws IOException {
        d();
        q();
        f(str);
        b bVar = this.l.get(str);
        if (bVar != null && bVar.f23197e) {
            c cVarA = bVar.a();
            if (cVarA == null) {
                return null;
            }
            this.m++;
            this.k.writeUtf8("READ").writeByte(32).writeUtf8(str).writeByte(10);
            if (g()) {
                this.t.execute(this.u);
            }
            return cVarA;
        }
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.o && !this.p) {
            for (b bVar : (b[]) this.l.values().toArray(new b[this.l.size()])) {
                if (bVar.f23198f != null) {
                    bVar.f23198f.a();
                }
            }
            o();
            this.k.close();
            this.k = null;
            this.p = true;
            return;
        }
        this.p = true;
    }

    public synchronized void d() throws IOException {
        if (this.o) {
            return;
        }
        if (this.f23184b.exists(this.f23188f)) {
            if (this.f23184b.exists(this.f23186d)) {
                this.f23184b.delete(this.f23188f);
            } else {
                this.f23184b.rename(this.f23188f, this.f23186d);
            }
        }
        if (this.f23184b.exists(this.f23186d)) {
            try {
                t();
                s();
                this.o = true;
                return;
            } catch (IOException e2) {
                okhttp3.a.b.f.a().a(5, "DiskLruCache " + this.f23185c + " is corrupt: " + e2.getMessage() + ", removing", e2);
                try {
                    b();
                    this.p = false;
                    n();
                    this.o = true;
                } catch (Throwable th) {
                    this.p = false;
                    throw th;
                }
            }
        }
        n();
        this.o = true;
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.o) {
            q();
            o();
            this.k.flush();
        }
    }

    boolean g() {
        int i = this.m;
        return i >= 2000 && i >= this.l.size();
    }

    public synchronized boolean isClosed() {
        return this.p;
    }

    synchronized void n() throws IOException {
        if (this.k != null) {
            this.k.close();
        }
        BufferedSink bufferedSinkBuffer = Okio.buffer(this.f23184b.sink(this.f23187e));
        try {
            bufferedSinkBuffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
            bufferedSinkBuffer.writeUtf8("1").writeByte(10);
            bufferedSinkBuffer.writeDecimalLong(this.g).writeByte(10);
            bufferedSinkBuffer.writeDecimalLong(this.i).writeByte(10);
            bufferedSinkBuffer.writeByte(10);
            for (b bVar : this.l.values()) {
                if (bVar.f23198f != null) {
                    bufferedSinkBuffer.writeUtf8("DIRTY").writeByte(32);
                    bufferedSinkBuffer.writeUtf8(bVar.f23193a);
                    bufferedSinkBuffer.writeByte(10);
                } else {
                    bufferedSinkBuffer.writeUtf8("CLEAN").writeByte(32);
                    bufferedSinkBuffer.writeUtf8(bVar.f23193a);
                    bVar.a(bufferedSinkBuffer);
                    bufferedSinkBuffer.writeByte(10);
                }
            }
            bufferedSinkBuffer.close();
            if (this.f23184b.exists(this.f23186d)) {
                this.f23184b.rename(this.f23186d, this.f23188f);
            }
            this.f23184b.rename(this.f23187e, this.f23186d);
            this.f23184b.delete(this.f23188f);
            this.k = r();
            this.n = false;
            this.r = false;
        } catch (Throwable th) {
            bufferedSinkBuffer.close();
            throw th;
        }
    }

    void o() throws IOException {
        while (this.j > this.h) {
            a(this.l.values().iterator().next());
        }
        this.q = false;
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    private final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f23193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long[] f23194b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final File[] f23195c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final File[] f23196d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f23197e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        a f23198f;
        long g;

        b(String str) {
            this.f23193a = str;
            int i = g.this.i;
            this.f23194b = new long[i];
            this.f23195c = new File[i];
            this.f23196d = new File[i];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < g.this.i; i2++) {
                sb.append(i2);
                this.f23195c[i2] = new File(g.this.f23185c, sb.toString());
                sb.append(".tmp");
                this.f23196d[i2] = new File(g.this.f23185c, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        void a(String[] strArr) throws IOException {
            if (strArr.length != g.this.i) {
                b(strArr);
                throw null;
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f23194b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    b(strArr);
                    throw null;
                }
            }
        }

        void a(BufferedSink bufferedSink) throws IOException {
            for (long j : this.f23194b) {
                bufferedSink.writeByte(32).writeDecimalLong(j);
            }
        }

        c a() {
            if (Thread.holdsLock(g.this)) {
                Source[] sourceArr = new Source[g.this.i];
                long[] jArr = (long[]) this.f23194b.clone();
                for (int i = 0; i < g.this.i; i++) {
                    try {
                        sourceArr[i] = g.this.f23184b.source(this.f23195c[i]);
                    } catch (FileNotFoundException unused) {
                        for (int i2 = 0; i2 < g.this.i && sourceArr[i2] != null; i2++) {
                            okhttp3.a.e.a(sourceArr[i2]);
                        }
                        try {
                            g.this.a(this);
                            return null;
                        } catch (IOException unused2) {
                            return null;
                        }
                    }
                }
                return g.this.new c(this.f23193a, this.g, sourceArr, jArr);
            }
            throw new AssertionError();
        }
    }

    public a a(String str) throws IOException {
        return a(str, -1L);
    }

    synchronized a a(String str, long j) throws IOException {
        d();
        q();
        f(str);
        b bVar = this.l.get(str);
        if (j != -1 && (bVar == null || bVar.g != j)) {
            return null;
        }
        if (bVar != null && bVar.f23198f != null) {
            return null;
        }
        if (!this.q && !this.r) {
            this.k.writeUtf8("DIRTY").writeByte(32).writeUtf8(str).writeByte(10);
            this.k.flush();
            if (this.n) {
                return null;
            }
            if (bVar == null) {
                bVar = new b(str);
                this.l.put(str, bVar);
            }
            a aVar = new a(bVar);
            bVar.f23198f = aVar;
            return aVar;
        }
        this.t.execute(this.u);
        return null;
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f23189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean[] f23190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f23191c;

        a(b bVar) {
            this.f23189a = bVar;
            this.f23190b = bVar.f23197e ? null : new boolean[g.this.i];
        }

        public Sink a(int i) {
            synchronized (g.this) {
                if (this.f23191c) {
                    throw new IllegalStateException();
                }
                if (this.f23189a.f23198f != this) {
                    return Okio.blackhole();
                }
                if (!this.f23189a.f23197e) {
                    this.f23190b[i] = true;
                }
                try {
                    return new f(this, g.this.f23184b.sink(this.f23189a.f23196d[i]));
                } catch (FileNotFoundException unused) {
                    return Okio.blackhole();
                }
            }
        }

        public void b() throws IOException {
            synchronized (g.this) {
                if (this.f23191c) {
                    throw new IllegalStateException();
                }
                if (this.f23189a.f23198f == this) {
                    g.this.a(this, true);
                }
                this.f23191c = true;
            }
        }

        void c() {
            if (this.f23189a.f23198f != this) {
                return;
            }
            int i = 0;
            while (true) {
                g gVar = g.this;
                if (i >= gVar.i) {
                    this.f23189a.f23198f = null;
                    return;
                } else {
                    try {
                        gVar.f23184b.delete(this.f23189a.f23196d[i]);
                    } catch (IOException unused) {
                    }
                    i++;
                }
            }
        }

        public void a() throws IOException {
            synchronized (g.this) {
                if (!this.f23191c) {
                    if (this.f23189a.f23198f == this) {
                        g.this.a(this, false);
                    }
                    this.f23191c = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }

    public synchronized boolean d(String str) throws IOException {
        d();
        q();
        f(str);
        b bVar = this.l.get(str);
        if (bVar == null) {
            return false;
        }
        boolean zA = a(bVar);
        if (zA && this.j <= this.h) {
            this.q = false;
        }
        return zA;
    }

    synchronized void a(a aVar, boolean z) throws IOException {
        b bVar = aVar.f23189a;
        if (bVar.f23198f == aVar) {
            if (z && !bVar.f23197e) {
                for (int i = 0; i < this.i; i++) {
                    if (aVar.f23190b[i]) {
                        if (!this.f23184b.exists(bVar.f23196d[i])) {
                            aVar.a();
                            return;
                        }
                    } else {
                        aVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.i; i2++) {
                File file = bVar.f23196d[i2];
                if (z) {
                    if (this.f23184b.exists(file)) {
                        File file2 = bVar.f23195c[i2];
                        this.f23184b.rename(file, file2);
                        long j = bVar.f23194b[i2];
                        long size = this.f23184b.size(file2);
                        bVar.f23194b[i2] = size;
                        this.j = (this.j - j) + size;
                    }
                } else {
                    this.f23184b.delete(file);
                }
            }
            this.m++;
            bVar.f23198f = null;
            if (bVar.f23197e | z) {
                bVar.f23197e = true;
                this.k.writeUtf8("CLEAN").writeByte(32);
                this.k.writeUtf8(bVar.f23193a);
                bVar.a(this.k);
                this.k.writeByte(10);
                if (z) {
                    long j2 = this.s;
                    this.s = 1 + j2;
                    bVar.g = j2;
                }
            } else {
                this.l.remove(bVar.f23193a);
                this.k.writeUtf8("REMOVE").writeByte(32);
                this.k.writeUtf8(bVar.f23193a);
                this.k.writeByte(10);
            }
            this.k.flush();
            if (this.j > this.h || g()) {
                this.t.execute(this.u);
            }
            return;
        }
        throw new IllegalStateException();
    }

    boolean a(b bVar) throws IOException {
        a aVar = bVar.f23198f;
        if (aVar != null) {
            aVar.c();
        }
        for (int i = 0; i < this.i; i++) {
            this.f23184b.delete(bVar.f23195c[i]);
            long j = this.j;
            long[] jArr = bVar.f23194b;
            this.j = j - jArr[i];
            jArr[i] = 0;
        }
        this.m++;
        this.k.writeUtf8("REMOVE").writeByte(32).writeUtf8(bVar.f23193a).writeByte(10);
        this.l.remove(bVar.f23193a);
        if (g()) {
            this.t.execute(this.u);
        }
        return true;
    }
}
