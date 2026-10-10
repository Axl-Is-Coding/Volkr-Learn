package b.b.a.a;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: SampleToChunkBox.java */
/* JADX INFO: loaded from: classes.dex */
public class s extends b.d.a.c {
    private static final /* synthetic */ a.InterfaceC0253a p = null;
    private static final /* synthetic */ a.InterfaceC0253a q = null;
    private static final /* synthetic */ a.InterfaceC0253a r = null;
    private static final /* synthetic */ a.InterfaceC0253a s = null;
    List<a> t;

    /* JADX INFO: compiled from: SampleToChunkBox.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f2461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f2462b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f2463c;

        public a(long j, long j2, long j3) {
            this.f2461a = j;
            this.f2462b = j2;
            this.f2463c = j3;
        }

        public long a() {
            return this.f2461a;
        }

        public long b() {
            return this.f2463c;
        }

        public long c() {
            return this.f2462b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f2461a == aVar.f2461a && this.f2463c == aVar.f2463c && this.f2462b == aVar.f2462b;
        }

        public int hashCode() {
            long j = this.f2461a;
            long j2 = this.f2462b;
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.f2463c;
            return i + ((int) (j3 ^ (j3 >>> 32)));
        }

        public String toString() {
            return "Entry{firstChunk=" + this.f2461a + ", samplesPerChunk=" + this.f2462b + ", sampleDescriptionIndex=" + this.f2463c + '}';
        }
    }

    static {
        i();
    }

    public s() {
        super("stsc");
        this.t = Collections.emptyList();
    }

    private static /* synthetic */ void i() {
        f.a.a.b.b bVar = new f.a.a.b.b("SampleToChunkBox.java", s.class);
        p = bVar.a("method-execution", bVar.a("1", "getEntries", "com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.util.List"), 47);
        q = bVar.a("method-execution", bVar.a("1", "setEntries", "com.coremedia.iso.boxes.SampleToChunkBox", "java.util.List", "entries", "", "void"), 51);
        r = bVar.a("method-execution", bVar.a("1", "toString", "com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.lang.String"), 84);
        s = bVar.a("method-execution", bVar.a("1", "blowup", "com.coremedia.iso.boxes.SampleToChunkBox", "int", "chunkCount", "", "[J"), 95);
    }

    public void a(List<a> list) {
        b.d.a.g.a().a(f.a.a.b.b.a(q, this, this, list));
        this.t = list;
    }

    @Override // b.d.a.a
    protected void b(ByteBuffer byteBuffer) {
        d(byteBuffer);
        b.b.a.e.a(byteBuffer, this.t.size());
        for (a aVar : this.t) {
            b.b.a.e.a(byteBuffer, aVar.a());
            b.b.a.e.a(byteBuffer, aVar.c());
            b.b.a.e.a(byteBuffer, aVar.b());
        }
    }

    public List<a> h() {
        b.d.a.g.a().a(f.a.a.b.b.a(p, this, this));
        return this.t;
    }

    public String toString() {
        b.d.a.g.a().a(f.a.a.b.b.a(r, this, this));
        return "SampleToChunkBox[entryCount=" + this.t.size() + "]";
    }

    @Override // b.d.a.a
    protected long a() {
        return (this.t.size() * 12) + 8;
    }

    @Override // b.d.a.a
    public void a(ByteBuffer byteBuffer) {
        c(byteBuffer);
        int iA = b.d.a.b.b.a(b.b.a.d.h(byteBuffer));
        this.t = new ArrayList(iA);
        for (int i = 0; i < iA; i++) {
            this.t.add(new a(b.b.a.d.h(byteBuffer), b.b.a.d.h(byteBuffer), b.b.a.d.h(byteBuffer)));
        }
    }
}
