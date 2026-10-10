package b.d.a;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: AbstractBox.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements b.b.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b.d.a.b.g f2476a = b.d.a.b.g.a(a.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f2477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f2478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b.b.a.a.d f2479d;
    private ByteBuffer g;
    long h;
    f j;
    long i = -1;
    private ByteBuffer k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f2481f = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f2480e = true;

    protected a(String str) {
        this.f2477b = str;
    }

    private boolean f() {
        int i = "uuid".equals(b()) ? 24 : 8;
        if (!this.f2481f) {
            return this.i + ((long) i) < 4294967296L;
        }
        if (!this.f2480e) {
            return ((long) (this.g.limit() + i)) < 4294967296L;
        }
        long jA = a();
        ByteBuffer byteBuffer = this.k;
        return (jA + ((long) (byteBuffer != null ? byteBuffer.limit() : 0))) + ((long) i) < 4294967296L;
    }

    private synchronized void g() {
        if (!this.f2481f) {
            try {
                f2476a.a("mem mapping " + b());
                this.g = this.j.a(this.h, this.i);
                this.f2481f = true;
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    protected abstract long a();

    protected abstract void a(ByteBuffer byteBuffer);

    public String b() {
        return this.f2477b;
    }

    protected abstract void b(ByteBuffer byteBuffer);

    public byte[] c() {
        return this.f2478c;
    }

    public boolean d() {
        return this.f2480e;
    }

    public final synchronized void e() {
        g();
        f2476a.a("parsing details of " + b());
        if (this.g != null) {
            ByteBuffer byteBuffer = this.g;
            this.f2480e = true;
            byteBuffer.rewind();
            a(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.k = byteBuffer.slice();
            }
            this.g = null;
        }
    }

    @Override // b.b.a.a.b
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        if (!this.f2481f) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((f() ? 8 : 16) + ("uuid".equals(b()) ? 16 : 0));
            c(byteBufferAllocate);
            writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
            this.j.a(this.h, this.i, writableByteChannel);
            return;
        }
        if (!this.f2480e) {
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate((f() ? 8 : 16) + ("uuid".equals(b()) ? 16 : 0));
            c(byteBufferAllocate2);
            writableByteChannel.write((ByteBuffer) byteBufferAllocate2.rewind());
            writableByteChannel.write((ByteBuffer) this.g.position(0));
            return;
        }
        ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(b.d.a.b.b.a(getSize()));
        c(byteBufferAllocate3);
        b(byteBufferAllocate3);
        ByteBuffer byteBuffer = this.k;
        if (byteBuffer != null) {
            byteBuffer.rewind();
            while (this.k.remaining() > 0) {
                byteBufferAllocate3.put(this.k);
            }
        }
        writableByteChannel.write((ByteBuffer) byteBufferAllocate3.rewind());
    }

    @Override // b.b.a.a.b
    public long getSize() {
        long jLimit;
        if (!this.f2481f) {
            jLimit = this.i;
        } else if (this.f2480e) {
            jLimit = a();
        } else {
            ByteBuffer byteBuffer = this.g;
            jLimit = byteBuffer != null ? byteBuffer.limit() : 0;
        }
        long j = jLimit + ((long) ((jLimit >= 4294967288L ? 8 : 0) + 8 + ("uuid".equals(b()) ? 16 : 0)));
        ByteBuffer byteBuffer2 = this.k;
        return j + ((long) (byteBuffer2 != null ? byteBuffer2.limit() : 0));
    }

    @Override // b.b.a.a.b
    public void setParent(b.b.a.a.d dVar) {
        this.f2479d = dVar;
    }

    private void c(ByteBuffer byteBuffer) {
        if (f()) {
            b.b.a.e.a(byteBuffer, getSize());
            byteBuffer.put(b.b.a.c.a(b()));
        } else {
            b.b.a.e.a(byteBuffer, 1L);
            byteBuffer.put(b.b.a.c.a(b()));
            b.b.a.e.b(byteBuffer, getSize());
        }
        if ("uuid".equals(b())) {
            byteBuffer.put(c());
        }
    }
}
