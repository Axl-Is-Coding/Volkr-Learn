package b.b.a.a.a;

import b.b.a.e;
import b.b.a.f;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: VisualSampleEntry.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends a implements b.b.a.a.d {
    private int n;
    private int o;
    private double p;
    private double q;
    private int r;
    private String s;
    private int t;
    private long[] u;

    public d(String str) {
        super(str);
        this.p = 72.0d;
        this.q = 72.0d;
        this.r = 1;
        this.s = "";
        this.t = 24;
        this.u = new long[3];
    }

    public void a(double d2) {
        this.p = d2;
    }

    public void b(double d2) {
        this.q = d2;
    }

    public void c(int i) {
        this.r = i;
    }

    public void d(int i) {
        this.o = i;
    }

    public void e(int i) {
        this.n = i;
    }

    @Override // b.d.a.b, b.b.a.a.b
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(g());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(78);
        byteBufferAllocate.position(6);
        e.a(byteBufferAllocate, this.m);
        e.a(byteBufferAllocate, 0);
        e.a(byteBufferAllocate, 0);
        e.a(byteBufferAllocate, this.u[0]);
        e.a(byteBufferAllocate, this.u[1]);
        e.a(byteBufferAllocate, this.u[2]);
        e.a(byteBufferAllocate, v());
        e.a(byteBufferAllocate, r());
        e.b(byteBufferAllocate, s());
        e.b(byteBufferAllocate, t());
        e.a(byteBufferAllocate, 0L);
        e.a(byteBufferAllocate, q());
        e.c(byteBufferAllocate, f.b(n()));
        byteBufferAllocate.put(f.a(n()));
        int iB = f.b(n());
        while (iB < 31) {
            iB++;
            byteBufferAllocate.put((byte) 0);
        }
        e.a(byteBufferAllocate, o());
        e.a(byteBufferAllocate, 65535);
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        a(writableByteChannel);
    }

    @Override // b.d.a.b, b.b.a.a.b
    public long getSize() {
        long jD = d() + 78;
        return jD + ((long) ((this.l || 8 + jD >= 4294967296L) ? 16 : 8));
    }

    public String n() {
        return this.s;
    }

    public int o() {
        return this.t;
    }

    public int q() {
        return this.r;
    }

    public int r() {
        return this.o;
    }

    public double s() {
        return this.p;
    }

    public double t() {
        return this.q;
    }

    public int v() {
        return this.n;
    }

    public void b(int i) {
        this.t = i;
    }
}
