package b.b.a.a;

import java.nio.ByteBuffer;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: SoundMediaHeaderBox.java */
/* JADX INFO: loaded from: classes.dex */
public class t extends a {
    private static final /* synthetic */ a.InterfaceC0253a p = null;
    private static final /* synthetic */ a.InterfaceC0253a q = null;
    private float r;

    static {
        i();
    }

    public t() {
        super("smhd");
    }

    private static /* synthetic */ void i() {
        f.a.a.b.b bVar = new f.a.a.b.b("SoundMediaHeaderBox.java", t.class);
        p = bVar.a("method-execution", bVar.a("1", "getBalance", "com.coremedia.iso.boxes.SoundMediaHeaderBox", "", "", "", "float"), 36);
        q = bVar.a("method-execution", bVar.a("1", "toString", "com.coremedia.iso.boxes.SoundMediaHeaderBox", "", "", "", "java.lang.String"), 58);
    }

    @Override // b.d.a.a
    protected long a() {
        return 8L;
    }

    @Override // b.d.a.a
    public void a(ByteBuffer byteBuffer) {
        c(byteBuffer);
        this.r = b.b.a.d.d(byteBuffer);
        b.b.a.d.f(byteBuffer);
    }

    @Override // b.d.a.a
    protected void b(ByteBuffer byteBuffer) {
        d(byteBuffer);
        b.b.a.e.c(byteBuffer, this.r);
        b.b.a.e.a(byteBuffer, 0);
    }

    public float h() {
        b.d.a.g.a().a(f.a.a.b.b.a(p, this, this));
        return this.r;
    }

    public String toString() {
        b.d.a.g.a().a(f.a.a.b.b.a(q, this, this));
        return "SoundMediaHeaderBox[balance=" + h() + "]";
    }
}
