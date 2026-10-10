package b.b.a.a;

import java.nio.ByteBuffer;
import java.util.Date;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: MovieHeaderBox.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends b.d.a.c {
    private static final /* synthetic */ a.InterfaceC0253a A = null;
    private static final /* synthetic */ a.InterfaceC0253a B = null;
    private static final /* synthetic */ a.InterfaceC0253a C = null;
    private static final /* synthetic */ a.InterfaceC0253a D = null;
    private static final /* synthetic */ a.InterfaceC0253a E = null;
    private static final /* synthetic */ a.InterfaceC0253a F = null;
    private static final /* synthetic */ a.InterfaceC0253a G = null;
    private static final /* synthetic */ a.InterfaceC0253a H = null;
    private static final /* synthetic */ a.InterfaceC0253a I = null;
    private static final /* synthetic */ a.InterfaceC0253a J = null;
    private static final /* synthetic */ a.InterfaceC0253a K = null;
    private static final /* synthetic */ a.InterfaceC0253a L = null;
    private static final /* synthetic */ a.InterfaceC0253a M = null;
    private static final /* synthetic */ a.InterfaceC0253a N = null;
    private static final /* synthetic */ a.InterfaceC0253a O = null;
    private static final /* synthetic */ a.InterfaceC0253a P = null;
    private static final /* synthetic */ a.InterfaceC0253a Q = null;
    private static final /* synthetic */ a.InterfaceC0253a R = null;
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
    private Date S;
    private Date T;
    private long U;
    private long V;
    private double W;
    private float X;
    private b.d.a.b.h Y;
    private long Z;
    private int aa;
    private int ba;
    private int ca;
    private int da;
    private int ea;
    private int fa;

    static {
        o();
    }

    public o() {
        super("mvhd");
        this.W = 1.0d;
        this.X = 1.0f;
        this.Y = b.d.a.b.h.f2529a;
    }

    private static /* synthetic */ void o() {
        f.a.a.b.b bVar = new f.a.a.b.b("MovieHeaderBox.java", o.class);
        p = bVar.a("method-execution", bVar.a("1", "getCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 63);
        q = bVar.a("method-execution", bVar.a("1", "getModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 67);
        z = bVar.a("method-execution", bVar.a("1", "setModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "modificationTime", "", "void"), 203);
        A = bVar.a("method-execution", bVar.a("1", "setTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "timescale", "", "void"), 211);
        B = bVar.a("method-execution", bVar.a("1", "setDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "duration", "", "void"), 215);
        C = bVar.a("method-execution", bVar.a("1", "setRate", "com.coremedia.iso.boxes.MovieHeaderBox", "double", "rate", "", "void"), 222);
        D = bVar.a("method-execution", bVar.a("1", "setVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "float", "volume", "", "void"), 226);
        E = bVar.a("method-execution", bVar.a("1", "setMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), 230);
        F = bVar.a("method-execution", bVar.a("1", "setNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "nextTrackId", "", "void"), 234);
        G = bVar.a("method-execution", bVar.a("1", "getPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 238);
        H = bVar.a("method-execution", bVar.a("1", "setPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewTime", "", "void"), 242);
        I = bVar.a("method-execution", bVar.a("1", "getPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 246);
        r = bVar.a("method-execution", bVar.a("1", "getTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 71);
        J = bVar.a("method-execution", bVar.a("1", "setPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewDuration", "", "void"), 250);
        K = bVar.a("method-execution", bVar.a("1", "getPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 254);
        L = bVar.a("method-execution", bVar.a("1", "setPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "posterTime", "", "void"), 258);
        M = bVar.a("method-execution", bVar.a("1", "getSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 262);
        N = bVar.a("method-execution", bVar.a("1", "setSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionTime", "", "void"), 266);
        O = bVar.a("method-execution", bVar.a("1", "getSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 270);
        P = bVar.a("method-execution", bVar.a("1", "setSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionDuration", "", "void"), 274);
        Q = bVar.a("method-execution", bVar.a("1", "getCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 278);
        R = bVar.a("method-execution", bVar.a("1", "setCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "currentTime", "", "void"), 282);
        s = bVar.a("method-execution", bVar.a("1", "getDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 75);
        t = bVar.a("method-execution", bVar.a("1", "getRate", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "double"), 79);
        u = bVar.a("method-execution", bVar.a("1", "getVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "float"), 83);
        v = bVar.a("method-execution", bVar.a("1", "getMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 87);
        w = bVar.a("method-execution", bVar.a("1", "getNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 91);
        x = bVar.a("method-execution", bVar.a("1", "toString", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.lang.String"), 139);
        y = bVar.a("method-execution", bVar.a("1", "setCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "creationTime", "", "void"), 195);
    }

    @Override // b.d.a.a
    protected long a() {
        return (g() == 1 ? 32L : 20L) + 80;
    }

    @Override // b.d.a.a
    protected void b(ByteBuffer byteBuffer) {
        d(byteBuffer);
        if (g() == 1) {
            b.b.a.e.b(byteBuffer, b.d.a.b.c.a(this.S));
            b.b.a.e.b(byteBuffer, b.d.a.b.c.a(this.T));
            b.b.a.e.a(byteBuffer, this.U);
            b.b.a.e.b(byteBuffer, this.V);
        } else {
            b.b.a.e.a(byteBuffer, b.d.a.b.c.a(this.S));
            b.b.a.e.a(byteBuffer, b.d.a.b.c.a(this.T));
            b.b.a.e.a(byteBuffer, this.U);
            b.b.a.e.a(byteBuffer, this.V);
        }
        b.b.a.e.b(byteBuffer, this.W);
        b.b.a.e.c(byteBuffer, this.X);
        b.b.a.e.a(byteBuffer, 0);
        b.b.a.e.a(byteBuffer, 0L);
        b.b.a.e.a(byteBuffer, 0L);
        this.Y.b(byteBuffer);
        byteBuffer.putInt(this.aa);
        byteBuffer.putInt(this.ba);
        byteBuffer.putInt(this.ca);
        byteBuffer.putInt(this.da);
        byteBuffer.putInt(this.ea);
        byteBuffer.putInt(this.fa);
        b.b.a.e.a(byteBuffer, this.Z);
    }

    public void c(long j) {
        b.d.a.g.a().a(f.a.a.b.b.a(A, this, this, f.a.a.a.a.a(j)));
        this.U = j;
    }

    public Date h() {
        b.d.a.g.a().a(f.a.a.b.b.a(p, this, this));
        return this.S;
    }

    public long i() {
        b.d.a.g.a().a(f.a.a.b.b.a(s, this, this));
        return this.V;
    }

    public Date j() {
        b.d.a.g.a().a(f.a.a.b.b.a(q, this, this));
        return this.T;
    }

    public long k() {
        b.d.a.g.a().a(f.a.a.b.b.a(w, this, this));
        return this.Z;
    }

    public double l() {
        b.d.a.g.a().a(f.a.a.b.b.a(t, this, this));
        return this.W;
    }

    public long m() {
        b.d.a.g.a().a(f.a.a.b.b.a(r, this, this));
        return this.U;
    }

    public float n() {
        b.d.a.g.a().a(f.a.a.b.b.a(u, this, this));
        return this.X;
    }

    public String toString() {
        b.d.a.g.a().a(f.a.a.b.b.a(x, this, this));
        return "MovieHeaderBox[creationTime=" + h() + ";modificationTime=" + j() + ";timescale=" + m() + ";duration=" + i() + ";rate=" + l() + ";volume=" + n() + ";matrix=" + this.Y + ";nextTrackId=" + k() + "]";
    }

    @Override // b.d.a.a
    public void a(ByteBuffer byteBuffer) {
        c(byteBuffer);
        if (g() == 1) {
            this.S = b.d.a.b.c.a(b.b.a.d.i(byteBuffer));
            this.T = b.d.a.b.c.a(b.b.a.d.i(byteBuffer));
            this.U = b.b.a.d.h(byteBuffer);
            this.V = b.b.a.d.i(byteBuffer);
        } else {
            this.S = b.d.a.b.c.a(b.b.a.d.h(byteBuffer));
            this.T = b.d.a.b.c.a(b.b.a.d.h(byteBuffer));
            this.U = b.b.a.d.h(byteBuffer);
            this.V = b.b.a.d.h(byteBuffer);
        }
        this.W = b.b.a.d.c(byteBuffer);
        this.X = b.b.a.d.d(byteBuffer);
        b.b.a.d.f(byteBuffer);
        b.b.a.d.h(byteBuffer);
        b.b.a.d.h(byteBuffer);
        this.Y = b.d.a.b.h.a(byteBuffer);
        this.aa = byteBuffer.getInt();
        this.ba = byteBuffer.getInt();
        this.ca = byteBuffer.getInt();
        this.da = byteBuffer.getInt();
        this.ea = byteBuffer.getInt();
        this.fa = byteBuffer.getInt();
        this.Z = b.b.a.d.h(byteBuffer);
    }

    public void b(Date date) {
        b.d.a.g.a().a(f.a.a.b.b.a(z, this, this, date));
        this.T = date;
        if (b.d.a.b.c.a(date) >= 4294967296L) {
            b(1);
        }
    }

    public void a(Date date) {
        b.d.a.g.a().a(f.a.a.b.b.a(y, this, this, date));
        this.S = date;
        if (b.d.a.b.c.a(date) >= 4294967296L) {
            b(1);
        }
    }

    public void b(long j) {
        b.d.a.g.a().a(f.a.a.b.b.a(F, this, this, f.a.a.a.a.a(j)));
        this.Z = j;
    }

    public void a(long j) {
        b.d.a.g.a().a(f.a.a.b.b.a(B, this, this, f.a.a.a.a.a(j)));
        this.V = j;
        if (j >= 4294967296L) {
            b(1);
        }
    }

    public void a(b.d.a.b.h hVar) {
        b.d.a.g.a().a(f.a.a.b.b.a(E, this, this, hVar));
        this.Y = hVar;
    }
}
