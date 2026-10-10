package b.b.a.a.a;

import b.b.a.e;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: AudioSampleEntry.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a {
    private int n;
    private int o;
    private long p;
    private int q;
    private int r;
    private int s;
    private long t;
    private long u;
    private long v;
    private long w;
    private int x;
    private long y;
    private byte[] z;

    public b(String str) {
        super(str);
    }

    public void b(int i) {
        this.n = i;
    }

    public void c(int i) {
        this.o = i;
    }

    @Override // b.d.a.b, b.b.a.a.b
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(g());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((this.q == 1 ? 16 : 0) + 28 + (this.q == 2 ? 36 : 0));
        byteBufferAllocate.position(6);
        e.a(byteBufferAllocate, this.m);
        e.a(byteBufferAllocate, this.q);
        e.a(byteBufferAllocate, this.x);
        e.a(byteBufferAllocate, this.y);
        e.a(byteBufferAllocate, this.n);
        e.a(byteBufferAllocate, this.o);
        e.a(byteBufferAllocate, this.r);
        e.a(byteBufferAllocate, this.s);
        if (this.k.equals("mlpa")) {
            e.a(byteBufferAllocate, o());
        } else {
            e.a(byteBufferAllocate, o() << 16);
        }
        if (this.q == 1) {
            e.a(byteBufferAllocate, this.t);
            e.a(byteBufferAllocate, this.u);
            e.a(byteBufferAllocate, this.v);
            e.a(byteBufferAllocate, this.w);
        }
        if (this.q == 2) {
            e.a(byteBufferAllocate, this.t);
            e.a(byteBufferAllocate, this.u);
            e.a(byteBufferAllocate, this.v);
            e.a(byteBufferAllocate, this.w);
            byteBufferAllocate.put(this.z);
        }
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        a(writableByteChannel);
    }

    @Override // b.d.a.b, b.b.a.a.b
    public long getSize() {
        int i = 16;
        long jD = ((long) ((this.q == 1 ? 16 : 0) + 28 + (this.q == 2 ? 36 : 0))) + d();
        if (!this.l && 8 + jD < 4294967296L) {
            i = 8;
        }
        return jD + ((long) i);
    }

    public int n() {
        return this.n;
    }

    public long o() {
        return this.p;
    }

    @Override // b.d.a.e
    public String toString() {
        return "AudioSampleEntry{bytesPerSample=" + this.w + ", bytesPerFrame=" + this.v + ", bytesPerPacket=" + this.u + ", samplesPerPacket=" + this.t + ", packetSize=" + this.s + ", compressionId=" + this.r + ", soundVersion=" + this.q + ", sampleRate=" + this.p + ", sampleSize=" + this.o + ", channelCount=" + this.n + ", boxes=" + b() + '}';
    }

    public void b(long j) {
        this.p = j;
    }
}
