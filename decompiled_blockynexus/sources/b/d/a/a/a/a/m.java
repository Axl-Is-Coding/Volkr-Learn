package b.d.a.a.a.a;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ProfileLevelIndicationDescriptor.java */
/* JADX INFO: loaded from: classes2.dex */
@g(tags = {20})
public class m extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2518d;

    @Override // b.d.a.a.a.a.b
    public void a(ByteBuffer byteBuffer) throws IOException {
        this.f2518d = b.b.a.d.j(byteBuffer);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && m.class == obj.getClass() && this.f2518d == ((m) obj).f2518d;
    }

    public int hashCode() {
        return this.f2518d;
    }

    @Override // b.d.a.a.a.a.b
    public String toString() {
        return "ProfileLevelIndicationDescriptor{profileLevelIndicationIndex=" + Integer.toHexString(this.f2518d) + '}';
    }
}
