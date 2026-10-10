package b.d.a.a.a.a;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: compiled from: ESDescriptor.java */
/* JADX INFO: loaded from: classes2.dex */
@g(tags = {3})
public class h extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Logger f2510d = Logger.getLogger(h.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f2511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f2512f;
    int g;
    int h;
    int i;
    String k;
    int l;
    int m;
    int n;
    e o;
    n p;
    int j = 0;
    List<b> q = new ArrayList();

    @Override // b.d.a.a.a.a.b
    public void a(ByteBuffer byteBuffer) throws IOException {
        this.f2511e = b.b.a.d.f(byteBuffer);
        int iJ = b.b.a.d.j(byteBuffer);
        this.f2512f = iJ >>> 7;
        this.g = (iJ >>> 6) & 1;
        this.h = (iJ >>> 5) & 1;
        this.i = iJ & 31;
        if (this.f2512f == 1) {
            this.m = b.b.a.d.f(byteBuffer);
        }
        if (this.g == 1) {
            this.j = b.b.a.d.j(byteBuffer);
            this.k = b.b.a.d.a(byteBuffer, this.j);
        }
        if (this.h == 1) {
            this.n = b.b.a.d.f(byteBuffer);
        }
        int iB = b() + 1 + 2 + 1 + (this.f2512f == 1 ? 2 : 0) + (this.g == 1 ? this.j + 1 : 0) + (this.h == 1 ? 2 : 0);
        int iPosition = byteBuffer.position();
        if (a() > iB + 2) {
            b bVarA = l.a(-1, byteBuffer);
            long jPosition = byteBuffer.position() - iPosition;
            Logger logger = f2510d;
            StringBuilder sb = new StringBuilder();
            sb.append(bVarA);
            sb.append(" - ESDescriptor1 read: ");
            sb.append(jPosition);
            sb.append(", size: ");
            sb.append(bVarA != null ? Integer.valueOf(bVarA.a()) : null);
            logger.finer(sb.toString());
            if (bVarA != null) {
                int iA = bVarA.a();
                byteBuffer.position(iPosition + iA);
                iB += iA;
            } else {
                iB = (int) (((long) iB) + jPosition);
            }
            if (bVarA instanceof e) {
                this.o = (e) bVarA;
            }
        }
        int iPosition2 = byteBuffer.position();
        if (a() > iB + 2) {
            b bVarA2 = l.a(-1, byteBuffer);
            long jPosition2 = byteBuffer.position() - iPosition2;
            Logger logger2 = f2510d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(bVarA2);
            sb2.append(" - ESDescriptor2 read: ");
            sb2.append(jPosition2);
            sb2.append(", size: ");
            sb2.append(bVarA2 != null ? Integer.valueOf(bVarA2.a()) : null);
            logger2.finer(sb2.toString());
            if (bVarA2 != null) {
                int iA2 = bVarA2.a();
                byteBuffer.position(iPosition2 + iA2);
                iB += iA2;
            } else {
                iB = (int) (((long) iB) + jPosition2);
            }
            if (bVarA2 instanceof n) {
                this.p = (n) bVarA2;
            }
        } else {
            f2510d.warning("SLConfigDescriptor is missing!");
        }
        while (a() - iB > 2) {
            int iPosition3 = byteBuffer.position();
            b bVarA3 = l.a(-1, byteBuffer);
            long jPosition3 = byteBuffer.position() - iPosition3;
            Logger logger3 = f2510d;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(bVarA3);
            sb3.append(" - ESDescriptor3 read: ");
            sb3.append(jPosition3);
            sb3.append(", size: ");
            sb3.append(bVarA3 != null ? Integer.valueOf(bVarA3.a()) : null);
            logger3.finer(sb3.toString());
            if (bVarA3 != null) {
                int iA3 = bVarA3.a();
                byteBuffer.position(iPosition3 + iA3);
                iB += iA3;
            } else {
                iB = (int) (((long) iB) + jPosition3);
            }
            this.q.add(bVarA3);
        }
    }

    public ByteBuffer d() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(e());
        b.b.a.e.c(byteBufferAllocate, 3);
        b.b.a.e.c(byteBufferAllocate, e() - 2);
        b.b.a.e.a(byteBufferAllocate, this.f2511e);
        b.b.a.e.c(byteBufferAllocate, (this.f2512f << 7) | (this.g << 6) | (this.h << 5) | (this.i & 31));
        if (this.f2512f > 0) {
            b.b.a.e.a(byteBufferAllocate, this.m);
        }
        if (this.g > 0) {
            b.b.a.e.c(byteBufferAllocate, this.j);
            b.b.a.e.b(byteBufferAllocate, this.k);
        }
        if (this.h > 0) {
            b.b.a.e.a(byteBufferAllocate, this.n);
        }
        ByteBuffer byteBufferD = this.o.d();
        ByteBuffer byteBufferD2 = this.p.d();
        byteBufferAllocate.put(byteBufferD.array());
        byteBufferAllocate.put(byteBufferD2.array());
        return byteBufferAllocate;
    }

    public int e() {
        int i = this.f2512f > 0 ? 7 : 5;
        if (this.g > 0) {
            i += this.j + 1;
        }
        if (this.h > 0) {
            i += 2;
        }
        return i + this.o.e() + this.p.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.g != hVar.g || this.j != hVar.j || this.m != hVar.m || this.f2511e != hVar.f2511e || this.n != hVar.n || this.h != hVar.h || this.l != hVar.l || this.f2512f != hVar.f2512f || this.i != hVar.i) {
            return false;
        }
        String str = this.k;
        if (str == null ? hVar.k != null : !str.equals(hVar.k)) {
            return false;
        }
        e eVar = this.o;
        if (eVar == null ? hVar.o != null : !eVar.equals(hVar.o)) {
            return false;
        }
        List<b> list = this.q;
        if (list == null ? hVar.q != null : !list.equals(hVar.q)) {
            return false;
        }
        n nVar = this.p;
        return nVar == null ? hVar.p == null : nVar.equals(hVar.p);
    }

    public int hashCode() {
        int i = ((((((((((this.f2511e * 31) + this.f2512f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31;
        String str = this.k;
        int iHashCode = (((((((i + (str != null ? str.hashCode() : 0)) * 31) + this.l) * 31) + this.m) * 31) + this.n) * 31;
        e eVar = this.o;
        int iHashCode2 = (iHashCode + (eVar != null ? eVar.hashCode() : 0)) * 31;
        n nVar = this.p;
        int iHashCode3 = (iHashCode2 + (nVar != null ? nVar.hashCode() : 0)) * 31;
        List<b> list = this.q;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    @Override // b.d.a.a.a.a.b
    public String toString() {
        return "ESDescriptor{esId=" + this.f2511e + ", streamDependenceFlag=" + this.f2512f + ", URLFlag=" + this.g + ", oCRstreamFlag=" + this.h + ", streamPriority=" + this.i + ", URLLength=" + this.j + ", URLString='" + this.k + "', remoteODFlag=" + this.l + ", dependsOnEsId=" + this.m + ", oCREsId=" + this.n + ", decoderConfigDescriptor=" + this.o + ", slConfigDescriptor=" + this.p + '}';
    }

    public void a(e eVar) {
        this.o = eVar;
    }

    public void a(n nVar) {
        this.p = nVar;
    }

    public void a(int i) {
        this.f2511e = i;
    }
}
