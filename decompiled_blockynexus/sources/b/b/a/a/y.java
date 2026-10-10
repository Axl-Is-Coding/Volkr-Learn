package b.b.a.a;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.nio.ByteBuffer;
import java.util.Date;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: TrackHeaderBox.java */
/* JADX INFO: loaded from: classes.dex */
public class y extends b.d.a.c {
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
    private static final /* synthetic */ a.InterfaceC0253a S = null;
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
    private Date T;
    private Date U;
    private long V;
    private long W;
    private int X;
    private int Y;
    private float Z;
    private b.d.a.b.h aa;
    private double ba;
    private double ca;

    static {
        q();
    }

    public y() {
        super("tkhd");
        this.aa = b.d.a.b.h.f2529a;
    }

    private static /* synthetic */ void q() {
        f.a.a.b.b bVar = new f.a.a.b.b("TrackHeaderBox.java", y.class);
        p = bVar.a("method-execution", bVar.a("1", "getCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 60);
        q = bVar.a("method-execution", bVar.a("1", "getModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 64);
        z = bVar.a("method-execution", bVar.a("1", "getContent", "com.coremedia.iso.boxes.TrackHeaderBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 142);
        A = bVar.a("method-execution", bVar.a("1", "toString", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.lang.String"), 170);
        B = bVar.a("method-execution", bVar.a("1", "setCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "creationTime", "", "void"), 196);
        C = bVar.a("method-execution", bVar.a("1", "setModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "modificationTime", "", "void"), 203);
        D = bVar.a("method-execution", bVar.a("1", "setTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "trackId", "", "void"), 211);
        E = bVar.a("method-execution", bVar.a("1", "setDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "duration", "", "void"), 215);
        F = bVar.a("method-execution", bVar.a("1", "setLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "layer", "", "void"), 222);
        G = bVar.a("method-execution", bVar.a("1", "setAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "alternateGroup", "", "void"), 226);
        H = bVar.a("method-execution", bVar.a("1", "setVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "float", "volume", "", "void"), 230);
        I = bVar.a("method-execution", bVar.a("1", "setMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), 234);
        r = bVar.a("method-execution", bVar.a("1", "getTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 68);
        J = bVar.a("method-execution", bVar.a("1", "setWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "double", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "", "void"), 238);
        K = bVar.a("method-execution", bVar.a("1", "setHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "double", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "void"), 242);
        L = bVar.a("method-execution", bVar.a("1", "isEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 247);
        M = bVar.a("method-execution", bVar.a("1", "isInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 251);
        N = bVar.a("method-execution", bVar.a("1", "isInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 255);
        O = bVar.a("method-execution", bVar.a("1", "isInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 259);
        P = bVar.a("method-execution", bVar.a("1", "setEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "enabled", "", "void"), 263);
        Q = bVar.a("method-execution", bVar.a("1", "setInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inMovie", "", "void"), 271);
        R = bVar.a("method-execution", bVar.a("1", "setInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPreview", "", "void"), 279);
        S = bVar.a("method-execution", bVar.a("1", "setInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPoster", "", "void"), 287);
        s = bVar.a("method-execution", bVar.a("1", "getDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 72);
        t = bVar.a("method-execution", bVar.a("1", "getLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 76);
        u = bVar.a("method-execution", bVar.a("1", "getAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 80);
        v = bVar.a("method-execution", bVar.a("1", "getVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "float"), 84);
        w = bVar.a("method-execution", bVar.a("1", "getMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 88);
        x = bVar.a("method-execution", bVar.a("1", "getWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 92);
        y = bVar.a("method-execution", bVar.a("1", "getHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 96);
    }

    @Override // b.d.a.a
    protected long a() {
        return (g() == 1 ? 36L : 24L) + 60;
    }

    @Override // b.d.a.a
    public void b(ByteBuffer byteBuffer) {
        b.d.a.g.a().a(f.a.a.b.b.a(z, this, this, byteBuffer));
        d(byteBuffer);
        if (g() == 1) {
            b.b.a.e.b(byteBuffer, b.d.a.b.c.a(this.T));
            b.b.a.e.b(byteBuffer, b.d.a.b.c.a(this.U));
            b.b.a.e.a(byteBuffer, this.V);
            b.b.a.e.a(byteBuffer, 0L);
            b.b.a.e.b(byteBuffer, this.W);
        } else {
            b.b.a.e.a(byteBuffer, b.d.a.b.c.a(this.T));
            b.b.a.e.a(byteBuffer, b.d.a.b.c.a(this.U));
            b.b.a.e.a(byteBuffer, this.V);
            b.b.a.e.a(byteBuffer, 0L);
            b.b.a.e.a(byteBuffer, this.W);
        }
        b.b.a.e.a(byteBuffer, 0L);
        b.b.a.e.a(byteBuffer, 0L);
        b.b.a.e.a(byteBuffer, this.X);
        b.b.a.e.a(byteBuffer, this.Y);
        b.b.a.e.c(byteBuffer, this.Z);
        b.b.a.e.a(byteBuffer, 0);
        this.aa.b(byteBuffer);
        b.b.a.e.b(byteBuffer, this.ba);
        b.b.a.e.b(byteBuffer, this.ca);
    }

    public void c(int i) {
        b.d.a.g.a().a(f.a.a.b.b.a(G, this, this, f.a.a.a.a.a(i)));
        this.Y = i;
    }

    public void d(int i) {
        b.d.a.g.a().a(f.a.a.b.b.a(F, this, this, f.a.a.a.a.a(i)));
        this.X = i;
    }

    public int h() {
        b.d.a.g.a().a(f.a.a.b.b.a(u, this, this));
        return this.Y;
    }

    public Date i() {
        b.d.a.g.a().a(f.a.a.b.b.a(p, this, this));
        return this.T;
    }

    public long j() {
        b.d.a.g.a().a(f.a.a.b.b.a(s, this, this));
        return this.W;
    }

    public double k() {
        b.d.a.g.a().a(f.a.a.b.b.a(y, this, this));
        return this.ca;
    }

    public int l() {
        b.d.a.g.a().a(f.a.a.b.b.a(t, this, this));
        return this.X;
    }

    public Date m() {
        b.d.a.g.a().a(f.a.a.b.b.a(q, this, this));
        return this.U;
    }

    public long n() {
        b.d.a.g.a().a(f.a.a.b.b.a(r, this, this));
        return this.V;
    }

    public float o() {
        b.d.a.g.a().a(f.a.a.b.b.a(v, this, this));
        return this.Z;
    }

    public double p() {
        b.d.a.g.a().a(f.a.a.b.b.a(x, this, this));
        return this.ba;
    }

    public String toString() {
        b.d.a.g.a().a(f.a.a.b.b.a(A, this, this));
        return "TrackHeaderBox[creationTime=" + i() + ";modificationTime=" + m() + ";trackId=" + n() + ";duration=" + j() + ";layer=" + l() + ";alternateGroup=" + h() + ";volume=" + o() + ";matrix=" + this.aa + ";width=" + p() + ";height=" + k() + "]";
    }

    @Override // b.d.a.a
    public void a(ByteBuffer byteBuffer) {
        c(byteBuffer);
        if (g() == 1) {
            this.T = b.d.a.b.c.a(b.b.a.d.i(byteBuffer));
            this.U = b.d.a.b.c.a(b.b.a.d.i(byteBuffer));
            this.V = b.b.a.d.h(byteBuffer);
            b.b.a.d.h(byteBuffer);
            this.W = byteBuffer.getLong();
            if (this.W < -1) {
                throw new RuntimeException("The tracks duration is bigger than Long.MAX_VALUE");
            }
        } else {
            this.T = b.d.a.b.c.a(b.b.a.d.h(byteBuffer));
            this.U = b.d.a.b.c.a(b.b.a.d.h(byteBuffer));
            this.V = b.b.a.d.h(byteBuffer);
            b.b.a.d.h(byteBuffer);
            this.W = b.b.a.d.h(byteBuffer);
        }
        b.b.a.d.h(byteBuffer);
        b.b.a.d.h(byteBuffer);
        this.X = b.b.a.d.f(byteBuffer);
        this.Y = b.b.a.d.f(byteBuffer);
        this.Z = b.b.a.d.d(byteBuffer);
        b.b.a.d.f(byteBuffer);
        this.aa = b.d.a.b.h.a(byteBuffer);
        this.ba = b.b.a.d.c(byteBuffer);
        this.ca = b.b.a.d.c(byteBuffer);
    }

    public void c(boolean z2) {
        b.d.a.g.a().a(f.a.a.b.b.a(R, this, this, f.a.a.a.a.a(z2)));
        if (z2) {
            a(f() | 4);
        } else {
            a(f() & (-5));
        }
    }

    public void b(Date date) {
        b.d.a.g.a().a(f.a.a.b.b.a(C, this, this, date));
        this.U = date;
        if (b.d.a.b.c.a(date) >= 4294967296L) {
            b(1);
        }
    }

    public void a(Date date) {
        b.d.a.g.a().a(f.a.a.b.b.a(B, this, this, date));
        this.T = date;
        if (b.d.a.b.c.a(date) >= 4294967296L) {
            b(1);
        }
    }

    public void b(long j) {
        b.d.a.g.a().a(f.a.a.b.b.a(D, this, this, f.a.a.a.a.a(j)));
        this.V = j;
    }

    public void b(double d2) {
        b.d.a.g.a().a(f.a.a.b.b.a(J, this, this, f.a.a.a.a.a(d2)));
        this.ba = d2;
    }

    public void b(boolean z2) {
        b.d.a.g.a().a(f.a.a.b.b.a(Q, this, this, f.a.a.a.a.a(z2)));
        if (z2) {
            a(f() | 2);
        } else {
            a(f() & (-3));
        }
    }

    public void a(long j) {
        b.d.a.g.a().a(f.a.a.b.b.a(E, this, this, f.a.a.a.a.a(j)));
        this.W = j;
        if (j >= 4294967296L) {
            a(1);
        }
    }

    public void a(float f2) {
        b.d.a.g.a().a(f.a.a.b.b.a(H, this, this, f.a.a.a.a.a(f2)));
        this.Z = f2;
    }

    public void a(b.d.a.b.h hVar) {
        b.d.a.g.a().a(f.a.a.b.b.a(I, this, this, hVar));
        this.aa = hVar;
    }

    public void a(double d2) {
        b.d.a.g.a().a(f.a.a.b.b.a(K, this, this, f.a.a.a.a.a(d2)));
        this.ca = d2;
    }

    public void a(boolean z2) {
        b.d.a.g.a().a(f.a.a.b.b.a(P, this, this, f.a.a.a.a.a(z2)));
        if (z2) {
            a(f() | 1);
        } else {
            a(f() & (-2));
        }
    }
}
