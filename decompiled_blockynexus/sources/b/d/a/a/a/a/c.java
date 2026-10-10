package b.d.a.a.a.a;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: BitReaderBuffer.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ByteBuffer f2500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2502c;

    public c(ByteBuffer byteBuffer) {
        this.f2500a = byteBuffer;
        this.f2501b = byteBuffer.position();
    }

    public boolean a() {
        return a(1) == 1;
    }

    public int b() {
        return (this.f2500a.limit() * 8) - this.f2502c;
    }

    public int a(int i) {
        int iA;
        int i2 = this.f2500a.get(this.f2501b + (this.f2502c / 8));
        if (i2 < 0) {
            i2 += 256;
        }
        int i3 = this.f2502c;
        int i4 = 8 - (i3 % 8);
        if (i <= i4) {
            iA = ((i2 << (i3 % 8)) & 255) >> ((i3 % 8) + (i4 - i));
            this.f2502c = i3 + i;
        } else {
            int i5 = i - i4;
            iA = (a(i4) << i5) + a(i5);
        }
        ByteBuffer byteBuffer = this.f2500a;
        int i6 = this.f2501b;
        double d2 = this.f2502c;
        Double.isNaN(d2);
        byteBuffer.position(i6 + ((int) Math.ceil(d2 / 8.0d)));
        return iA;
    }
}
