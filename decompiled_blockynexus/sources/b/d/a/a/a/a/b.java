package b.d.a.a.a.a;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: BaseDescriptor.java */
/* JADX INFO: loaded from: classes2.dex */
@g(tags = {0})
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f2497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2499c;

    public int a() {
        return this.f2498b + 1 + this.f2499c;
    }

    public abstract void a(ByteBuffer byteBuffer) throws IOException;

    public int b() {
        return this.f2499c;
    }

    public int c() {
        return this.f2498b;
    }

    public String toString() {
        return "BaseDescriptor{tag=" + this.f2497a + ", sizeOfInstance=" + this.f2498b + '}';
    }

    public final void a(int i, ByteBuffer byteBuffer) throws IOException {
        this.f2497a = i;
        int iJ = b.b.a.d.j(byteBuffer);
        this.f2498b = iJ & 127;
        int i2 = 1;
        while ((iJ >>> 7) == 1) {
            iJ = b.b.a.d.j(byteBuffer);
            i2++;
            this.f2498b = (this.f2498b << 7) | (iJ & 127);
        }
        this.f2499c = i2;
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        byteBufferSlice.limit(this.f2498b);
        a(byteBufferSlice);
        byteBuffer.position(byteBuffer.position() + this.f2498b);
    }
}
