package b.d.a;

import b.b.a.a.i;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: AbstractFullBox.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends a implements i {
    private static final /* synthetic */ a.InterfaceC0253a l = null;
    private static final /* synthetic */ a.InterfaceC0253a m = null;
    private int n;
    private int o;

    static {
        h();
    }

    protected c(String str) {
        super(str);
    }

    private static /* synthetic */ void h() {
        f.a.a.b.b bVar = new f.a.a.b.b("AbstractFullBox.java", c.class);
        l = bVar.a("method-execution", bVar.a("1", "setVersion", "com.googlecode.mp4parser.AbstractFullBox", "int", "version", "", "void"), 51);
        m = bVar.a("method-execution", bVar.a("1", "setFlags", "com.googlecode.mp4parser.AbstractFullBox", "int", "flags", "", "void"), 64);
    }

    public void a(int i) {
        g.a().a(f.a.a.b.b.a(m, this, this, f.a.a.a.a.a(i)));
        this.o = i;
    }

    public void b(int i) {
        g.a().a(f.a.a.b.b.a(l, this, this, f.a.a.a.a.a(i)));
        this.n = i;
    }

    protected final long c(ByteBuffer byteBuffer) {
        this.n = b.b.a.d.j(byteBuffer);
        this.o = b.b.a.d.g(byteBuffer);
        return 4L;
    }

    protected final void d(ByteBuffer byteBuffer) {
        b.b.a.e.c(byteBuffer, this.n);
        b.b.a.e.b(byteBuffer, this.o);
    }

    public int f() {
        if (!this.f2480e) {
            e();
        }
        return this.o;
    }

    public int g() {
        if (!this.f2480e) {
            e();
        }
        return this.n;
    }
}
