package b.b.a.a;

import org.aspectj.lang.a;

/* JADX INFO: compiled from: ChunkOffsetBox.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c extends b.d.a.c {
    private static final /* synthetic */ a.InterfaceC0253a p = null;

    static {
        i();
    }

    public c(String str) {
        super(str);
    }

    private static /* synthetic */ void i() {
        f.a.a.b.b bVar = new f.a.a.b.b("ChunkOffsetBox.java", c.class);
        p = bVar.a("method-execution", bVar.a("1", "toString", "com.coremedia.iso.boxes.ChunkOffsetBox", "", "", "", "java.lang.String"), 18);
    }

    public abstract long[] h();

    public String toString() {
        b.d.a.g.a().a(f.a.a.b.b.a(p, this, this));
        return String.valueOf(getClass().getSimpleName()) + "[entryCount=" + h().length + "]";
    }
}
