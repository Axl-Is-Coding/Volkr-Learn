package zlc.season.rxdownload3.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.io.a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.l;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* JADX INFO: compiled from: RangeTmpFile.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class RangeTmpFile {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f23727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FileStructure f23728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Status f23729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RealMission f23730f;

    /* JADX INFO: compiled from: RangeTmpFile.kt */
    public final class FileStructure {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f23733c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f23734d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23731a = "a1b2c3d4e5f6";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ByteString f23732b = ByteString.decodeHex(this.f23731a);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List<Segment> f23735e = new ArrayList();

        public FileStructure() {
        }

        private final long e() {
            return RangeTmpFile.this.e().f() % DownloadConfig.r.p() == 0 ? RangeTmpFile.this.e().f() / DownloadConfig.r.p() : (RangeTmpFile.this.e().f() / DownloadConfig.r.p()) + 1;
        }

        public final List<Segment> a() {
            return this.f23735e;
        }

        public final long b() {
            return this.f23733c;
        }

        public final boolean c() {
            if (this.f23735e.isEmpty()) {
                return false;
            }
            List<Segment> list = this.f23735e;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((Segment) it.next()).e()) {
                    return true;
                }
            }
            return false;
        }

        public final long d() {
            return ((long) this.f23732b.size()) + 16;
        }

        public final void a(BufferedSink bufferedSink) throws IOException {
            i.b(bufferedSink, "sink");
            this.f23733c = RangeTmpFile.this.e().f();
            this.f23734d = e();
            bufferedSink.write(this.f23732b);
            bufferedSink.writeLong(this.f23733c);
            bufferedSink.writeLong(this.f23734d);
        }

        public final void b(BufferedSink bufferedSink) {
            FileStructure fileStructure = this;
            i.b(bufferedSink, "sink");
            fileStructure.f23735e.clear();
            long j = 0;
            long jP = 0;
            for (long j2 = fileStructure.f23734d; j < j2; j2 = j2) {
                fileStructure.f23735e.add(new Segment(j, jP, jP, (j == fileStructure.f23734d - 1 ? RangeTmpFile.this.e().f() : DownloadConfig.r.p() + jP) - 1).a(bufferedSink));
                jP += DownloadConfig.r.p();
                j++;
                fileStructure = this;
            }
        }

        private final void c(BufferedSource bufferedSource) {
            if (!i.a((Object) bufferedSource.readByteString(this.f23732b.size()).hex(), (Object) this.f23731a)) {
                throw new RuntimeException(RangeTmpFile.this.f23727c + " not a tmp file");
            }
        }

        public final void a(BufferedSource bufferedSource) {
            i.b(bufferedSource, "source");
            c(bufferedSource);
            this.f23733c = bufferedSource.readLong();
            this.f23734d = bufferedSource.readLong();
        }

        public final void b(BufferedSource bufferedSource) throws IOException {
            i.b(bufferedSource, "source");
            this.f23735e.clear();
            long j = this.f23734d;
            for (long j2 = 0; j2 < j; j2++) {
                Buffer buffer = new Buffer();
                bufferedSource.readFully(buffer, 32L);
                this.f23735e.add(new Segment(buffer.readLong(), buffer.readLong(), buffer.readLong(), buffer.readLong()));
            }
        }
    }

    /* JADX INFO: compiled from: RangeTmpFile.kt */
    public static final class Segment {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f23737a = new Companion(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f23738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f23739c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f23740d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f23741e;

        /* JADX INFO: compiled from: RangeTmpFile.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }
        }

        public Segment(long j, long j2, long j3, long j4) {
            this.f23738b = j;
            this.f23739c = j2;
            this.f23740d = j3;
            this.f23741e = j4;
        }

        public final long a() {
            return this.f23740d;
        }

        public final long b() {
            return this.f23741e;
        }

        public final long c() {
            return this.f23738b;
        }

        public final long d() {
            return this.f23739c;
        }

        public final boolean e() {
            return this.f23740d - this.f23741e == 1;
        }

        public final void a(long j) {
            this.f23740d = j;
        }

        public final Segment a(BufferedSink bufferedSink) throws IOException {
            i.b(bufferedSink, "sink");
            bufferedSink.writeLong(this.f23738b);
            bufferedSink.writeLong(this.f23739c);
            bufferedSink.writeLong(this.f23740d);
            bufferedSink.writeLong(this.f23741e);
            return this;
        }
    }

    public RangeTmpFile(RealMission realMission) throws IOException {
        i.b(realMission, "mission");
        this.f23730f = realMission;
        this.f23725a = this.f23730f.b().c() + File.separator + ".TMP";
        this.f23726b = this.f23725a + File.separator + this.f23730f.b().b() + ".tmp";
        this.f23727c = new File(this.f23726b);
        this.f23728d = new FileStructure();
        this.f23729e = new Status(0L, 0L, false, this.f23730f.b().e(), 7, null);
        File file = new File(this.f23725a);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        if (this.f23727c.exists()) {
            i();
        }
    }

    private final void i() throws IOException {
        BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(this.f23727c));
        try {
            FileStructure fileStructure = this.f23728d;
            i.a((Object) bufferedSourceBuffer, "it");
            fileStructure.a(bufferedSourceBuffer);
            this.f23728d.b(bufferedSourceBuffer);
            l lVar = l.f22855a;
        } finally {
            a.a(bufferedSourceBuffer, null);
        }
    }

    private final void j() throws IOException {
        BufferedSink bufferedSinkBuffer = Okio.buffer(Okio.sink(this.f23727c));
        try {
            FileStructure fileStructure = this.f23728d;
            i.a((Object) bufferedSinkBuffer, "it");
            fileStructure.a(bufferedSinkBuffer);
            this.f23728d.b(bufferedSinkBuffer);
            l lVar = l.f22855a;
        } finally {
            a.a(bufferedSinkBuffer, null);
        }
    }

    public final Status b() {
        long jB = this.f23728d.b();
        long jA = 0;
        for (Segment segment : f()) {
            jA += segment.a() - segment.d();
        }
        this.f23729e.a(jA);
        this.f23729e.b(jB);
        return this.f23729e;
    }

    public final void c() {
        if (this.f23727c.exists()) {
            this.f23727c.delete();
        }
    }

    public final File d() {
        return this.f23727c;
    }

    public final RealMission e() {
        return this.f23730f;
    }

    public final List<Segment> f() {
        return this.f23728d.a();
    }

    public final boolean g() {
        return this.f23728d.c();
    }

    public final void h() {
        this.f23727c.delete();
        this.f23727c.createNewFile();
        j();
    }

    public final void a() {
        if (!this.f23727c.exists()) {
            this.f23727c.createNewFile();
            j();
        } else if (this.f23728d.b() != this.f23730f.f()) {
            h();
        }
    }

    public final long a(Segment segment) {
        i.b(segment, "segment");
        return this.f23728d.d() + (segment.c() * 32);
    }
}
