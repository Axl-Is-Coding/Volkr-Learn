package b.g.a.a;

import b.b.a.e;
import b.d.a.a.a.a.c;
import b.d.a.a.a.a.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AvcDecoderConfigurationRecord.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<byte[]> f2764f;
    public List<byte[]> g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public List<byte[]> l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;

    public b() {
        this.f2764f = new ArrayList();
        this.g = new ArrayList();
        this.h = true;
        this.i = 1;
        this.j = 0;
        this.k = 0;
        this.l = new ArrayList();
        this.m = 63;
        this.n = 7;
        this.o = 31;
        this.p = 31;
        this.q = 31;
    }

    public void a(ByteBuffer byteBuffer) {
        e.c(byteBuffer, this.f2759a);
        e.c(byteBuffer, this.f2760b);
        e.c(byteBuffer, this.f2761c);
        e.c(byteBuffer, this.f2762d);
        d dVar = new d(byteBuffer);
        dVar.a(this.m, 6);
        dVar.a(this.f2763e, 2);
        dVar.a(this.n, 3);
        dVar.a(this.g.size(), 5);
        for (byte[] bArr : this.f2764f) {
            e.a(byteBuffer, bArr.length);
            byteBuffer.put(bArr);
        }
        e.c(byteBuffer, this.g.size());
        for (byte[] bArr2 : this.g) {
            e.a(byteBuffer, bArr2.length);
            byteBuffer.put(bArr2);
        }
        if (this.h) {
            int i = this.f2760b;
            if (i == 100 || i == 110 || i == 122 || i == 144) {
                d dVar2 = new d(byteBuffer);
                dVar2.a(this.o, 6);
                dVar2.a(this.i, 2);
                dVar2.a(this.p, 5);
                dVar2.a(this.j, 3);
                dVar2.a(this.q, 5);
                dVar2.a(this.k, 3);
                for (byte[] bArr3 : this.l) {
                    e.a(byteBuffer, bArr3.length);
                    byteBuffer.put(bArr3);
                }
            }
        }
    }

    public String toString() {
        return "AvcDecoderConfigurationRecord{configurationVersion=" + this.f2759a + ", avcProfileIndication=" + this.f2760b + ", profileCompatibility=" + this.f2761c + ", avcLevelIndication=" + this.f2762d + ", lengthSizeMinusOne=" + this.f2763e + ", hasExts=" + this.h + ", chromaFormat=" + this.i + ", bitDepthLumaMinus8=" + this.j + ", bitDepthChromaMinus8=" + this.k + ", lengthSizeMinusOnePaddingBits=" + this.m + ", numberOfSequenceParameterSetsPaddingBits=" + this.n + ", chromaFormatPaddingBits=" + this.o + ", bitDepthLumaMinus8PaddingBits=" + this.p + ", bitDepthChromaMinus8PaddingBits=" + this.q + '}';
    }

    public b(ByteBuffer byteBuffer) {
        int i;
        this.f2764f = new ArrayList();
        this.g = new ArrayList();
        this.h = true;
        this.i = 1;
        this.j = 0;
        this.k = 0;
        this.l = new ArrayList();
        this.m = 63;
        this.n = 7;
        this.o = 31;
        this.p = 31;
        this.q = 31;
        this.f2759a = b.b.a.d.j(byteBuffer);
        this.f2760b = b.b.a.d.j(byteBuffer);
        this.f2761c = b.b.a.d.j(byteBuffer);
        this.f2762d = b.b.a.d.j(byteBuffer);
        c cVar = new c(byteBuffer);
        this.m = cVar.a(6);
        this.f2763e = cVar.a(2);
        this.n = cVar.a(3);
        int iA = cVar.a(5);
        for (int i2 = 0; i2 < iA; i2++) {
            byte[] bArr = new byte[b.b.a.d.f(byteBuffer)];
            byteBuffer.get(bArr);
            this.f2764f.add(bArr);
        }
        long j = b.b.a.d.j(byteBuffer);
        for (int i3 = 0; i3 < j; i3++) {
            byte[] bArr2 = new byte[b.b.a.d.f(byteBuffer)];
            byteBuffer.get(bArr2);
            this.g.add(bArr2);
        }
        if (byteBuffer.remaining() < 4) {
            this.h = false;
        }
        if (this.h && ((i = this.f2760b) == 100 || i == 110 || i == 122 || i == 144)) {
            c cVar2 = new c(byteBuffer);
            this.o = cVar2.a(6);
            this.i = cVar2.a(2);
            this.p = cVar2.a(5);
            this.j = cVar2.a(3);
            this.q = cVar2.a(5);
            this.k = cVar2.a(3);
            long j2 = b.b.a.d.j(byteBuffer);
            for (int i4 = 0; i4 < j2; i4++) {
                byte[] bArr3 = new byte[b.b.a.d.f(byteBuffer)];
                byteBuffer.get(bArr3);
                this.l.add(bArr3);
            }
            return;
        }
        this.i = -1;
        this.j = -1;
        this.k = -1;
    }

    public long a() {
        int i;
        Iterator<byte[]> it = this.f2764f.iterator();
        long length = 6;
        while (it.hasNext()) {
            length = length + 2 + ((long) it.next().length);
        }
        long length2 = length + 1;
        Iterator<byte[]> it2 = this.g.iterator();
        while (it2.hasNext()) {
            length2 = length2 + 2 + ((long) it2.next().length);
        }
        if (this.h && ((i = this.f2760b) == 100 || i == 110 || i == 122 || i == 144)) {
            length2 += 4;
            Iterator<byte[]> it3 = this.l.iterator();
            while (it3.hasNext()) {
                length2 = length2 + 2 + ((long) it3.next().length);
            }
        }
        return length2;
    }
}
