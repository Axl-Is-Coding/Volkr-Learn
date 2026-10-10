package b.b.a.a;

import com.umeng.analytics.pro.au;
import java.nio.ByteBuffer;
import java.util.Date;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: MediaHeaderBox.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends b.d.a.c {
    private static final /* synthetic */ a.InterfaceC0253a p = null;
    private static final /* synthetic */ a.InterfaceC0253a q = null;
    private static final /* synthetic */ a.InterfaceC0253a r = null;
    private static final /* synthetic */ a.InterfaceC0253a s = null;
    private static final /* synthetic */ a.InterfaceC0253a t = null;
    private static final /* synthetic */ a.InterfaceC0253a u = null;
    private static final /* synthetic */ a.InterfaceC0253a v = null;
    private static final /* synthetic */ a.InterfaceC0253a w = null;
    private static final /* synthetic */ a.InterfaceC0253a x = null;
    private static final /* synthetic */ a.InterfaceC0253a y = null;
    private static final /* synthetic */ a.InterfaceC0253a z = null;
    private Date A;
    private Date B;
    private long C;
    private long D;
    private String E;

    static {
        m();
    }

    public l() {
        super("mdhd");
        this.A = new Date();
        this.B = new Date();
        this.E = "eng";
    }

    private static /* synthetic */ void m() {
        f.a.a.b.b bVar = new f.a.a.b.b("MediaHeaderBox.java", l.class);
        p = bVar.a("method-execution", bVar.a("1", "getCreationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 46);
        q = bVar.a("method-execution", bVar.a("1", "getModificationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 50);
        z = bVar.a("method-execution", bVar.a("1", "toString", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), 118);
        r = bVar.a("method-execution", bVar.a("1", "getTimescale", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "long"), 54);
        s = bVar.a("method-execution", bVar.a("1", "getDuration", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "long"), 58);
        t = bVar.a("method-execution", bVar.a("1", "getLanguage", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), 62);
        u = bVar.a("method-execution", bVar.a("1", "setCreationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "creationTime", "", "void"), 79);
        v = bVar.a("method-execution", bVar.a("1", "setModificationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "modificationTime", "", "void"), 83);
        w = bVar.a("method-execution", bVar.a("1", "setTimescale", "com.coremedia.iso.boxes.MediaHeaderBox", "long", "timescale", "", "void"), 87);
        x = bVar.a("method-execution", bVar.a("1", "setDuration", "com.coremedia.iso.boxes.MediaHeaderBox", "long", "duration", "", "void"), 91);
        y = bVar.a("method-execution", bVar.a("1", "setLanguage", "com.coremedia.iso.boxes.MediaHeaderBox", "java.lang.String", au.M, "", "void"), 95);
    }

    @Override // b.d.a.a
    protected long a() {
        return (g() == 1 ? 32L : 20L) + 2 + 2;
    }

    public void b(long j) {
        b.d.a.g.a().a(f.a.a.b.b.a(w, this, this, f.a.a.a.a.a(j)));
        this.C = j;
    }

    public Date h() {
        b.d.a.g.a().a(f.a.a.b.b.a(p, this, this));
        return this.A;
    }

    public long i() {
        b.d.a.g.a().a(f.a.a.b.b.a(s, this, this));
        return this.D;
    }

    public String j() {
        b.d.a.g.a().a(f.a.a.b.b.a(t, this, this));
        return this.E;
    }

    public Date k() {
        b.d.a.g.a().a(f.a.a.b.b.a(q, this, this));
        return this.B;
    }

    public long l() {
        b.d.a.g.a().a(f.a.a.b.b.a(r, this, this));
        return this.C;
    }

    public String toString() {
        b.d.a.g.a().a(f.a.a.b.b.a(z, this, this));
        return "MediaHeaderBox[creationTime=" + h() + ";modificationTime=" + k() + ";timescale=" + l() + ";duration=" + i() + ";language=" + j() + "]";
    }

    public void a(Date date) {
        b.d.a.g.a().a(f.a.a.b.b.a(u, this, this, date));
        this.A = date;
    }

    @Override // b.d.a.a
    protected void b(ByteBuffer byteBuffer) {
        d(byteBuffer);
        if (g() == 1) {
            b.b.a.e.b(byteBuffer, b.d.a.b.c.a(this.A));
            b.b.a.e.b(byteBuffer, b.d.a.b.c.a(this.B));
            b.b.a.e.a(byteBuffer, this.C);
            b.b.a.e.b(byteBuffer, this.D);
        } else {
            b.b.a.e.a(byteBuffer, b.d.a.b.c.a(this.A));
            b.b.a.e.a(byteBuffer, b.d.a.b.c.a(this.B));
            b.b.a.e.a(byteBuffer, this.C);
            b.b.a.e.a(byteBuffer, this.D);
        }
        b.b.a.e.a(byteBuffer, this.E);
        b.b.a.e.a(byteBuffer, 0);
    }

    public void a(long j) {
        b.d.a.g.a().a(f.a.a.b.b.a(x, this, this, f.a.a.a.a.a(j)));
        this.D = j;
    }

    public void a(String str) {
        b.d.a.g.a().a(f.a.a.b.b.a(y, this, this, str));
        this.E = str;
    }

    @Override // b.d.a.a
    public void a(ByteBuffer byteBuffer) {
        c(byteBuffer);
        if (g() == 1) {
            this.A = b.d.a.b.c.a(b.b.a.d.i(byteBuffer));
            this.B = b.d.a.b.c.a(b.b.a.d.i(byteBuffer));
            this.C = b.b.a.d.h(byteBuffer);
            this.D = b.b.a.d.i(byteBuffer);
        } else {
            this.A = b.d.a.b.c.a(b.b.a.d.h(byteBuffer));
            this.B = b.d.a.b.c.a(b.b.a.d.h(byteBuffer));
            this.C = b.b.a.d.h(byteBuffer);
            this.D = b.b.a.d.h(byteBuffer);
        }
        this.E = b.b.a.d.e(byteBuffer);
        b.b.a.d.f(byteBuffer);
    }
}
