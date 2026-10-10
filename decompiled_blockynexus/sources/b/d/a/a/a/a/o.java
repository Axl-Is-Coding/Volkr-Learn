package b.d.a.a.a.a;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

/* JADX INFO: compiled from: UnknownDescriptor.java */
/* JADX INFO: loaded from: classes2.dex */
public class o extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Logger f2520d = Logger.getLogger(o.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ByteBuffer f2521e;

    @Override // b.d.a.a.a.a.b
    public void a(ByteBuffer byteBuffer) throws IOException {
        this.f2521e = (ByteBuffer) byteBuffer.slice().limit(c());
    }

    @Override // b.d.a.a.a.a.b
    public String toString() {
        return "UnknownDescriptor{tag=" + this.f2497a + ", sizeOfInstance=" + this.f2498b + ", data=" + this.f2521e + '}';
    }
}
