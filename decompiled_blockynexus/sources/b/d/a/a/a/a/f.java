package b.d.a.a.a.a;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: DecoderSpecificInfo.java */
/* JADX INFO: loaded from: classes2.dex */
@g(tags = {5})
public class f extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    byte[] f2509d;

    @Override // b.d.a.a.a.a.b
    public void a(ByteBuffer byteBuffer) throws IOException {
        int i = this.f2498b;
        if (i > 0) {
            this.f2509d = new byte[i];
            byteBuffer.get(this.f2509d);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && f.class == obj.getClass() && Arrays.equals(this.f2509d, ((f) obj).f2509d);
    }

    public int hashCode() {
        byte[] bArr = this.f2509d;
        if (bArr != null) {
            return Arrays.hashCode(bArr);
        }
        return 0;
    }

    @Override // b.d.a.a.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecoderSpecificInfo");
        sb.append("{bytes=");
        byte[] bArr = this.f2509d;
        sb.append(bArr == null ? "null" : b.b.a.b.a(bArr));
        sb.append('}');
        return sb.toString();
    }
}
