package b.b.a.a;

import java.nio.ByteBuffer;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: SyncSampleBox.java */
/* JADX INFO: loaded from: classes.dex */
public class v extends b.d.a.c {
    private static final /* synthetic */ a.InterfaceC0253a p = null;
    private static final /* synthetic */ a.InterfaceC0253a q = null;
    private static final /* synthetic */ a.InterfaceC0253a r = null;
    private long[] s;

    static {
        i();
    }

    public v() {
        super("stss");
    }

    private static /* synthetic */ void i() {
        f.a.a.b.b bVar = new f.a.a.b.b("SyncSampleBox.java", v.class);
        p = bVar.a("method-execution", bVar.a("1", "getSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "[J"), 46);
        q = bVar.a("method-execution", bVar.a("1", "toString", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "java.lang.String"), 77);
        r = bVar.a("method-execution", bVar.a("1", "setSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "[J", "sampleNumber", "", "void"), 81);
    }

    @Override // b.d.a.a
    protected long a() {
        return (this.s.length * 4) + 8;
    }

    @Override // b.d.a.a
    protected void b(ByteBuffer byteBuffer) {
        d(byteBuffer);
        b.b.a.e.a(byteBuffer, this.s.length);
        for (long j : this.s) {
            b.b.a.e.a(byteBuffer, j);
        }
    }

    public String toString() {
        b.d.a.g.a().a(f.a.a.b.b.a(q, this, this));
        return "SyncSampleBox[entryCount=" + this.s.length + "]";
    }

    @Override // b.d.a.a
    public void a(ByteBuffer byteBuffer) {
        c(byteBuffer);
        int iA = b.d.a.b.b.a(b.b.a.d.h(byteBuffer));
        this.s = new long[iA];
        for (int i = 0; i < iA; i++) {
            this.s[i] = b.b.a.d.h(byteBuffer);
        }
    }

    public void a(long[] jArr) {
        b.d.a.g.a().a(f.a.a.b.b.a(r, this, this, jArr));
        this.s = jArr;
    }
}
