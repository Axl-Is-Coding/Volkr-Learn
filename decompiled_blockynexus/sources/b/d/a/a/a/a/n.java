package b.d.a.a.a.a;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SLConfigDescriptor.java */
/* JADX INFO: loaded from: classes2.dex */
@g(tags = {6})
public class n extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2519d;

    public void a(int i) {
        this.f2519d = i;
    }

    public ByteBuffer d() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(3);
        b.b.a.e.c(byteBufferAllocate, 6);
        b.b.a.e.c(byteBufferAllocate, 1);
        b.b.a.e.c(byteBufferAllocate, this.f2519d);
        return byteBufferAllocate;
    }

    public int e() {
        return 3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && n.class == obj.getClass() && this.f2519d == ((n) obj).f2519d;
    }

    public int hashCode() {
        return this.f2519d;
    }

    @Override // b.d.a.a.a.a.b
    public String toString() {
        return "SLConfigDescriptor{predefined=" + this.f2519d + '}';
    }

    @Override // b.d.a.a.a.a.b
    public void a(ByteBuffer byteBuffer) throws IOException {
        this.f2519d = b.b.a.d.j(byteBuffer);
    }
}
