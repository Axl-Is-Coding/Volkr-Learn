package b.d.a.a.a.a;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: compiled from: DecoderConfigDescriptor.java */
/* JADX INFO: loaded from: classes2.dex */
@g(tags = {4})
public class e extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Logger f2506d = Logger.getLogger(e.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f2507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f2508f;
    int g;
    int h;
    long i;
    long j;
    f k;
    a l;
    List<m> m = new ArrayList();
    byte[] n;

    @Override // b.d.a.a.a.a.b
    public void a(ByteBuffer byteBuffer) throws IOException {
        int iA;
        this.f2507e = b.b.a.d.j(byteBuffer);
        int iJ = b.b.a.d.j(byteBuffer);
        this.f2508f = iJ >>> 2;
        this.g = (iJ >> 1) & 1;
        this.h = b.b.a.d.g(byteBuffer);
        this.i = b.b.a.d.h(byteBuffer);
        this.j = b.b.a.d.h(byteBuffer);
        if (byteBuffer.remaining() > 2) {
            int iPosition = byteBuffer.position();
            b bVarA = l.a(this.f2507e, byteBuffer);
            int iPosition2 = byteBuffer.position() - iPosition;
            Logger logger = f2506d;
            StringBuilder sb = new StringBuilder();
            sb.append(bVarA);
            sb.append(" - DecoderConfigDescr1 read: ");
            sb.append(iPosition2);
            sb.append(", size: ");
            sb.append(bVarA != null ? Integer.valueOf(bVarA.a()) : null);
            logger.finer(sb.toString());
            if (bVarA != null && iPosition2 < (iA = bVarA.a())) {
                this.n = new byte[iA - iPosition2];
                byteBuffer.get(this.n);
            }
            if (bVarA instanceof f) {
                this.k = (f) bVarA;
            }
            if (bVarA instanceof a) {
                this.l = (a) bVarA;
            }
        }
        while (byteBuffer.remaining() > 2) {
            long jPosition = byteBuffer.position();
            b bVarA2 = l.a(this.f2507e, byteBuffer);
            long jPosition2 = ((long) byteBuffer.position()) - jPosition;
            Logger logger2 = f2506d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(bVarA2);
            sb2.append(" - DecoderConfigDescr2 read: ");
            sb2.append(jPosition2);
            sb2.append(", size: ");
            sb2.append(bVarA2 != null ? Integer.valueOf(bVarA2.a()) : null);
            logger2.finer(sb2.toString());
            if (bVarA2 instanceof m) {
                this.m.add((m) bVarA2);
            }
        }
    }

    public void b(int i) {
        this.f2507e = i;
    }

    public void c(int i) {
        this.f2508f = i;
    }

    public ByteBuffer d() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(e());
        b.b.a.e.c(byteBufferAllocate, 4);
        b.b.a.e.c(byteBufferAllocate, e() - 2);
        b.b.a.e.c(byteBufferAllocate, this.f2507e);
        b.b.a.e.c(byteBufferAllocate, (this.f2508f << 2) | (this.g << 1) | 1);
        b.b.a.e.b(byteBufferAllocate, this.h);
        b.b.a.e.a(byteBufferAllocate, this.i);
        b.b.a.e.a(byteBufferAllocate, this.j);
        a aVar = this.l;
        if (aVar != null) {
            byteBufferAllocate.put(aVar.d().array());
        }
        return byteBufferAllocate;
    }

    public int e() {
        a aVar = this.l;
        return (aVar == null ? 0 : aVar.e()) + 15;
    }

    @Override // b.d.a.a.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecoderConfigDescriptor");
        sb.append("{objectTypeIndication=");
        sb.append(this.f2507e);
        sb.append(", streamType=");
        sb.append(this.f2508f);
        sb.append(", upStream=");
        sb.append(this.g);
        sb.append(", bufferSizeDB=");
        sb.append(this.h);
        sb.append(", maxBitRate=");
        sb.append(this.i);
        sb.append(", avgBitRate=");
        sb.append(this.j);
        sb.append(", decoderSpecificInfo=");
        sb.append(this.k);
        sb.append(", audioSpecificInfo=");
        sb.append(this.l);
        sb.append(", configDescriptorDeadBytes=");
        byte[] bArr = this.n;
        if (bArr == null) {
            bArr = new byte[0];
        }
        sb.append(b.b.a.b.a(bArr));
        sb.append(", profileLevelIndicationDescriptors=");
        List<m> list = this.m;
        sb.append(list == null ? "null" : Arrays.asList(list).toString());
        sb.append('}');
        return sb.toString();
    }

    public void b(long j) {
        this.i = j;
    }

    public void a(a aVar) {
        this.l = aVar;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(long j) {
        this.j = j;
    }
}
