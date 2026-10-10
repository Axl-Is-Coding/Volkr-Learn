package b.b.a.a;

import java.nio.ByteBuffer;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: DataEntryUrlBox.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends b.d.a.c {
    private static final /* synthetic */ a.InterfaceC0253a p = null;

    static {
        i();
    }

    public e() {
        super("url ");
    }

    private static /* synthetic */ void i() {
        f.a.a.b.b bVar = new f.a.a.b.b("DataEntryUrlBox.java", e.class);
        p = bVar.a("method-execution", bVar.a("1", "toString", "com.coremedia.iso.boxes.DataEntryUrlBox", "", "", "", "java.lang.String"), 51);
    }

    @Override // b.d.a.a
    protected long a() {
        return 4L;
    }

    @Override // b.d.a.a
    public void a(ByteBuffer byteBuffer) {
        c(byteBuffer);
    }

    @Override // b.d.a.a
    protected void b(ByteBuffer byteBuffer) {
        d(byteBuffer);
    }

    public String toString() {
        b.d.a.g.a().a(f.a.a.b.b.a(p, this, this));
        return "DataEntryUrlBox[]";
    }
}
