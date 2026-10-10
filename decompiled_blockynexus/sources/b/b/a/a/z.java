package b.b.a.a;

import java.nio.ByteBuffer;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: VideoMediaHeaderBox.java */
/* JADX INFO: loaded from: classes.dex */
public class z extends a {
    private static final /* synthetic */ a.InterfaceC0253a p = null;
    private static final /* synthetic */ a.InterfaceC0253a q = null;
    private static final /* synthetic */ a.InterfaceC0253a r = null;
    private static final /* synthetic */ a.InterfaceC0253a s = null;
    private static final /* synthetic */ a.InterfaceC0253a t = null;
    private int u;
    private int[] v;

    static {
        j();
    }

    public z() {
        super("vmhd");
        this.u = 0;
        this.v = new int[3];
        a(1);
    }

    private static /* synthetic */ void j() {
        f.a.a.b.b bVar = new f.a.a.b.b("VideoMediaHeaderBox.java", z.class);
        p = bVar.a("method-execution", bVar.a("1", "getGraphicsmode", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "int"), 39);
        q = bVar.a("method-execution", bVar.a("1", "getOpcolor", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "[I"), 43);
        r = bVar.a("method-execution", bVar.a("1", "toString", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "java.lang.String"), 71);
        s = bVar.a("method-execution", bVar.a("1", "setOpcolor", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "[I", "opcolor", "", "void"), 75);
        t = bVar.a("method-execution", bVar.a("1", "setGraphicsmode", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "int", "graphicsmode", "", "void"), 79);
    }

    @Override // b.d.a.a
    protected long a() {
        return 12L;
    }

    @Override // b.d.a.a
    public void a(ByteBuffer byteBuffer) {
        c(byteBuffer);
        this.u = b.b.a.d.f(byteBuffer);
        this.v = new int[3];
        for (int i = 0; i < 3; i++) {
            this.v[i] = b.b.a.d.f(byteBuffer);
        }
    }

    @Override // b.d.a.a
    protected void b(ByteBuffer byteBuffer) {
        d(byteBuffer);
        b.b.a.e.a(byteBuffer, this.u);
        for (int i : this.v) {
            b.b.a.e.a(byteBuffer, i);
        }
    }

    public int h() {
        b.d.a.g.a().a(f.a.a.b.b.a(p, this, this));
        return this.u;
    }

    public int[] i() {
        b.d.a.g.a().a(f.a.a.b.b.a(q, this, this));
        return this.v;
    }

    public String toString() {
        b.d.a.g.a().a(f.a.a.b.b.a(r, this, this));
        return "VideoMediaHeaderBox[graphicsmode=" + h() + ";opcolor0=" + i()[0] + ";opcolor1=" + i()[1] + ";opcolor2=" + i()[2] + "]";
    }
}
