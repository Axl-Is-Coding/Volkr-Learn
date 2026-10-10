package b.b.a.a;

import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: TimeToSampleBox.java */
/* JADX INFO: loaded from: classes.dex */
public class w extends b.d.a.c {
    static Map<List<a>, SoftReference<long[]>> p;
    private static final /* synthetic */ a.InterfaceC0253a q = null;
    private static final /* synthetic */ a.InterfaceC0253a r = null;
    private static final /* synthetic */ a.InterfaceC0253a s = null;
    List<a> t;

    /* JADX INFO: compiled from: TimeToSampleBox.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f2464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f2465b;

        public a(long j, long j2) {
            this.f2464a = j;
            this.f2465b = j2;
        }

        public long a() {
            return this.f2464a;
        }

        public long b() {
            return this.f2465b;
        }

        public String toString() {
            return "Entry{count=" + this.f2464a + ", delta=" + this.f2465b + '}';
        }

        public void a(long j) {
            this.f2464a = j;
        }
    }

    static {
        i();
        p = new WeakHashMap();
    }

    public w() {
        super("stts");
        this.t = Collections.emptyList();
    }

    private static /* synthetic */ void i() {
        f.a.a.b.b bVar = new f.a.a.b.b("TimeToSampleBox.java", w.class);
        q = bVar.a("method-execution", bVar.a("1", "getEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.util.List"), 79);
        r = bVar.a("method-execution", bVar.a("1", "setEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "java.util.List", "entries", "", "void"), 83);
        s = bVar.a("method-execution", bVar.a("1", "toString", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.lang.String"), 87);
    }

    @Override // b.d.a.a
    protected long a() {
        return (this.t.size() * 8) + 8;
    }

    @Override // b.d.a.a
    protected void b(ByteBuffer byteBuffer) {
        d(byteBuffer);
        b.b.a.e.a(byteBuffer, this.t.size());
        for (a aVar : this.t) {
            b.b.a.e.a(byteBuffer, aVar.a());
            b.b.a.e.a(byteBuffer, aVar.b());
        }
    }

    public String toString() {
        b.d.a.g.a().a(f.a.a.b.b.a(s, this, this));
        return "TimeToSampleBox[entryCount=" + this.t.size() + "]";
    }

    @Override // b.d.a.a
    public void a(ByteBuffer byteBuffer) {
        c(byteBuffer);
        int iA = b.d.a.b.b.a(b.b.a.d.h(byteBuffer));
        this.t = new ArrayList(iA);
        for (int i = 0; i < iA; i++) {
            this.t.add(new a(b.b.a.d.h(byteBuffer), b.b.a.d.h(byteBuffer)));
        }
    }

    public void a(List<a> list) {
        b.d.a.g.a().a(f.a.a.b.b.a(r, this, this, list));
        this.t = list;
    }
}
