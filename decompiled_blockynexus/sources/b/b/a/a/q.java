package b.b.a.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: SampleSizeBox.java */
/* JADX INFO: loaded from: classes.dex */
public class q extends b.d.a.c {
    private static final /* synthetic */ a.InterfaceC0253a p = null;
    private static final /* synthetic */ a.InterfaceC0253a q = null;
    private static final /* synthetic */ a.InterfaceC0253a r = null;
    private static final /* synthetic */ a.InterfaceC0253a s = null;
    private static final /* synthetic */ a.InterfaceC0253a t = null;
    private static final /* synthetic */ a.InterfaceC0253a u = null;
    private static final /* synthetic */ a.InterfaceC0253a v = null;
    private long w;
    private long[] x;
    int y;

    static {
        j();
    }

    public q() {
        super("stsz");
        this.x = new long[0];
    }

    private static /* synthetic */ void j() {
        f.a.a.b.b bVar = new f.a.a.b.b("SampleSizeBox.java", q.class);
        p = bVar.a("method-execution", bVar.a("1", "getSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 50);
        q = bVar.a("method-execution", bVar.a("1", "setSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "long", "sampleSize", "", "void"), 54);
        r = bVar.a("method-execution", bVar.a("1", "getSampleSizeAtIndex", "com.coremedia.iso.boxes.SampleSizeBox", "int", FirebaseAnalytics.Param.INDEX, "", "long"), 59);
        s = bVar.a("method-execution", bVar.a("1", "getSampleCount", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 67);
        t = bVar.a("method-execution", bVar.a("1", "getSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "[J"), 76);
        u = bVar.a("method-execution", bVar.a("1", "setSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "[J", "sampleSizes", "", "void"), 80);
        v = bVar.a("method-execution", bVar.a("1", "toString", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "java.lang.String"), 119);
    }

    public void a(long[] jArr) {
        b.d.a.g.a().a(f.a.a.b.b.a(u, this, this, jArr));
        this.x = jArr;
    }

    @Override // b.d.a.a
    protected void b(ByteBuffer byteBuffer) {
        d(byteBuffer);
        b.b.a.e.a(byteBuffer, this.w);
        if (this.w != 0) {
            b.b.a.e.a(byteBuffer, this.y);
            return;
        }
        b.b.a.e.a(byteBuffer, this.x.length);
        for (long j : this.x) {
            b.b.a.e.a(byteBuffer, j);
        }
    }

    public long h() {
        b.d.a.g.a().a(f.a.a.b.b.a(s, this, this));
        return this.w > 0 ? this.y : this.x.length;
    }

    public long i() {
        b.d.a.g.a().a(f.a.a.b.b.a(p, this, this));
        return this.w;
    }

    public String toString() {
        b.d.a.g.a().a(f.a.a.b.b.a(v, this, this));
        return "SampleSizeBox[sampleSize=" + i() + ";sampleCount=" + h() + "]";
    }

    @Override // b.d.a.a
    protected long a() {
        return (this.w == 0 ? this.x.length * 4 : 0) + 12;
    }

    @Override // b.d.a.a
    public void a(ByteBuffer byteBuffer) {
        c(byteBuffer);
        this.w = b.b.a.d.h(byteBuffer);
        this.y = b.d.a.b.b.a(b.b.a.d.h(byteBuffer));
        if (this.w == 0) {
            this.x = new long[this.y];
            for (int i = 0; i < this.y; i++) {
                this.x[i] = b.b.a.d.h(byteBuffer);
            }
        }
    }
}
