package zlc.season.rxdownload4.download.downloader;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import retrofit2.Response;

/* JADX INFO: compiled from: RangeTmpFile.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f23910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f23911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f23912c;

    /* JADX INFO: compiled from: RangeTmpFile.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f23914a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f23915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f23916c;

        /* JADX INFO: compiled from: RangeTmpFile.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        public b(long j, long j2) {
            this.f23915b = j;
            this.f23916c = j2;
        }

        public final long a() {
            return this.f23916c;
        }

        public final long b() {
            return this.f23915b;
        }

        public /* synthetic */ b(long j, long j2, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2);
        }

        public final void a(BufferedSink bufferedSink, long j, long j2) throws IOException {
            kotlin.jvm.internal.i.b(bufferedSink, "sink");
            this.f23915b = j;
            this.f23916c = j2;
            bufferedSink.write(ByteString.Companion.decodeHex("a1b2c3d4e5f6"));
            bufferedSink.writeLong(j);
            bufferedSink.writeLong(j2);
        }

        public final void a(BufferedSource bufferedSource) {
            kotlin.jvm.internal.i.b(bufferedSource, "source");
            if (!(!kotlin.jvm.internal.i.a((Object) bufferedSource.readByteString(6L).hex(), (Object) "a1b2c3d4e5f6"))) {
                this.f23915b = bufferedSource.readLong();
                this.f23916c = bufferedSource.readLong();
                return;
            }
            throw new RuntimeException("not a tmp file");
        }

        public final boolean a(long j, long j2) {
            return this.f23915b == j && this.f23916c == j2;
        }
    }

    /* JADX INFO: compiled from: RangeTmpFile.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f23917a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f23918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f23919c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f23920d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f23921e;

        /* JADX INFO: compiled from: RangeTmpFile.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        public c() {
            this(0L, 0L, 0L, 0L, 15, null);
        }

        public c(long j, long j2, long j3, long j4) {
            this.f23918b = j;
            this.f23919c = j2;
            this.f23920d = j3;
            this.f23921e = j4;
        }

        public final c a(BufferedSink bufferedSink) throws IOException {
            kotlin.jvm.internal.i.b(bufferedSink, "sink");
            bufferedSink.writeLong(this.f23918b);
            bufferedSink.writeLong(this.f23919c);
            bufferedSink.writeLong(this.f23920d);
            bufferedSink.writeLong(this.f23921e);
            return this;
        }

        public final long b() {
            return this.f23920d;
        }

        public final long c() {
            return this.f23921e;
        }

        public final boolean d() {
            return this.f23920d - this.f23921e == 1;
        }

        public final long e() {
            return (this.f23921e - this.f23920d) + 1;
        }

        public final long f() {
            return (this.f23918b * 32) + 22;
        }

        public /* synthetic */ c(long j, long j2, long j3, long j4, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? 0L : j3, (i & 8) == 0 ? j4 : 0L);
        }

        public final c a(BufferedSource bufferedSource) throws IOException {
            kotlin.jvm.internal.i.b(bufferedSource, "source");
            Buffer buffer = new Buffer();
            bufferedSource.readFully(buffer, 32L);
            this.f23918b = buffer.readLong();
            this.f23919c = buffer.readLong();
            this.f23920d = buffer.readLong();
            this.f23921e = buffer.readLong();
            return this;
        }

        public final long a() {
            return this.f23920d - this.f23919c;
        }
    }

    public q(File file) {
        kotlin.jvm.internal.i.b(file, "tmpFile");
        this.f23912c = file;
        this.f23910a = new b(0L, 0L, 3, null);
        this.f23911b = new a();
    }

    public final boolean a(Response<?> response, zlc.season.rxdownload4.a.a.e eVar) throws IOException {
        kotlin.jvm.internal.i.b(response, "response");
        kotlin.jvm.internal.i.b(eVar, "taskInfo");
        long jA = zlc.season.rxdownload4.download.utils.b.a(response);
        long jA2 = zlc.season.rxdownload4.download.utils.b.a(response, eVar.c());
        BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(this.f23912c));
        Throwable th = null;
        try {
            try {
                this.f23910a.a(bufferedSourceBuffer);
                this.f23911b.a(bufferedSourceBuffer, this.f23910a.a());
                kotlin.l lVar = kotlin.l.f22855a;
                kotlin.io.a.a(bufferedSourceBuffer, null);
                return this.f23910a.a(jA, jA2);
            } finally {
            }
        } catch (Throwable th2) {
            kotlin.io.a.a(bufferedSourceBuffer, th);
            throw th2;
        }
    }

    public final void b(Response<?> response, zlc.season.rxdownload4.a.a.e eVar) throws IOException {
        kotlin.jvm.internal.i.b(response, "response");
        kotlin.jvm.internal.i.b(eVar, "taskInfo");
        long jA = zlc.season.rxdownload4.download.utils.b.a(response);
        long jA2 = zlc.season.rxdownload4.download.utils.b.a(response, eVar.c());
        Throwable th = null;
        BufferedSink bufferedSinkBuffer = Okio.buffer(Okio.sink$default(this.f23912c, false, 1, null));
        try {
            try {
                this.f23910a.a(bufferedSinkBuffer, jA, jA2);
                this.f23911b.a(bufferedSinkBuffer, jA, jA2, eVar.c());
                bufferedSinkBuffer.flush();
                Log.d("tmpFile.sink().buffer()", "tmpFile = " + this.f23912c.getName() + " totalSize = " + jA + " totalSegments = " + eVar.c());
            } finally {
            }
        } finally {
            kotlin.io.a.a(bufferedSinkBuffer, th);
        }
    }

    /* JADX INFO: compiled from: RangeTmpFile.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<c> f23913a = new ArrayList();

        public final void a(BufferedSink bufferedSink, long j, long j2, long j3) throws IOException {
            kotlin.jvm.internal.i.b(bufferedSink, "sink");
            this.f23913a.clear();
            a(j, j2, j3);
            Iterator<T> it = this.f23913a.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(bufferedSink);
            }
        }

        public final List<c> b() {
            return this.f23913a;
        }

        public final void a(BufferedSource bufferedSource, long j) throws IOException {
            a aVar = this;
            kotlin.jvm.internal.i.b(bufferedSource, "source");
            aVar.f23913a.clear();
            long j2 = 0;
            while (j2 < j) {
                List<c> list = aVar.f23913a;
                c cVar = new c(0L, 0L, 0L, 0L, 15, null);
                cVar.a(bufferedSource);
                list.add(cVar);
                j2++;
                aVar = this;
            }
        }

        public final long a() {
            Iterator<T> it = this.f23913a.iterator();
            long jA = 0;
            while (it.hasNext()) {
                jA += ((c) it.next()).a();
            }
            return jA;
        }

        private final void a(long j, long j2, long j3) {
            long j4 = 0;
            long j5 = 0;
            while (j4 < j2) {
                this.f23913a.add(new c(j4, j5, j5, j4 == j2 - 1 ? j - 1 : (j5 + j3) - 1));
                j5 += j3;
                j4++;
            }
        }
    }

    public final List<c> b() {
        List<c> listB = this.f23911b.b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listB) {
            if (!((c) obj).d()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final Pair<Long, Long> a() {
        return new Pair<>(Long.valueOf(this.f23911b.a()), Long.valueOf(this.f23910a.b()));
    }
}
