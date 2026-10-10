package b.d.a.a.a.a;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: BitWriterBuffer.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ByteBuffer f2503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2505c = 0;

    public d(ByteBuffer byteBuffer) {
        this.f2503a = byteBuffer;
        this.f2504b = byteBuffer.position();
    }

    public void a(int i, int i2) {
        int i3 = this.f2505c;
        int i4 = 8 - (i3 % 8);
        if (i2 <= i4) {
            int i5 = this.f2503a.get(this.f2504b + (i3 / 8));
            if (i5 < 0) {
                i5 += 256;
            }
            int i6 = i5 + (i << (i4 - i2));
            ByteBuffer byteBuffer = this.f2503a;
            int i7 = this.f2504b + (this.f2505c / 8);
            if (i6 > 127) {
                i6 -= 256;
            }
            byteBuffer.put(i7, (byte) i6);
            this.f2505c += i2;
        } else {
            int i8 = i2 - i4;
            a(i >> i8, i4);
            a(i & ((1 << i8) - 1), i8);
        }
        ByteBuffer byteBuffer2 = this.f2503a;
        int i9 = this.f2504b;
        int i10 = this.f2505c;
        byteBuffer2.position(i9 + (i10 / 8) + (i10 % 8 <= 0 ? 0 : 1));
    }
}
