package b.b.a.a;

import java.nio.ByteBuffer;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: StaticChunkOffsetBox.java */
/* JADX INFO: loaded from: classes.dex */
public class u extends c {
    private static final /* synthetic */ a.InterfaceC0253a q = null;
    private static final /* synthetic */ a.InterfaceC0253a r = null;
    private long[] s;

    static {
        j();
    }

    public u() {
        super("stco");
        this.s = new long[0];
    }

    private static /* synthetic */ void j() {
        f.a.a.b.b bVar = new f.a.a.b.b("StaticChunkOffsetBox.java", u.class);
        q = bVar.a("method-execution", bVar.a("1", "getChunkOffsets", "com.coremedia.iso.boxes.StaticChunkOffsetBox", "", "", "", "[J"), 39);
        r = bVar.a("method-execution", bVar.a("1", "setChunkOffsets", "com.coremedia.iso.boxes.StaticChunkOffsetBox", "[J", "chunkOffsets", "", "void"), 48);
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

    @Override // b.b.a.a.c
    public long[] h() {
        b.d.a.g.a().a(f.a.a.b.b.a(q, this, this));
        return this.s;
    }

    public void a(long[] jArr) {
        b.d.a.g.a().a(f.a.a.b.b.a(r, this, this, jArr));
        this.s = jArr;
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
}
