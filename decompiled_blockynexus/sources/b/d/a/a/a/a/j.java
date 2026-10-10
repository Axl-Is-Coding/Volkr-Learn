package b.d.a.a.a.a;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ExtensionProfileLevelDescriptor.java */
/* JADX INFO: loaded from: classes2.dex */
@g(tags = {19})
public class j extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    byte[] f2515d;

    @Override // b.d.a.a.a.a.b
    public void a(ByteBuffer byteBuffer) throws IOException {
        if (a() > 0) {
            this.f2515d = new byte[a()];
            byteBuffer.get(this.f2515d);
        }
    }

    @Override // b.d.a.a.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExtensionDescriptor");
        sb.append("{bytes=");
        byte[] bArr = this.f2515d;
        sb.append(bArr == null ? "null" : b.b.a.b.a(bArr));
        sb.append('}');
        return sb.toString();
    }
}
