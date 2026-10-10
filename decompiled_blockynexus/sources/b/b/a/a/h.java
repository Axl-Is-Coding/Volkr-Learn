package b.b.a.a;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: FileTypeBox.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends b.d.a.a {
    private static final /* synthetic */ a.InterfaceC0253a l = null;
    private static final /* synthetic */ a.InterfaceC0253a m = null;
    private static final /* synthetic */ a.InterfaceC0253a n = null;
    private static final /* synthetic */ a.InterfaceC0253a o = null;
    private static final /* synthetic */ a.InterfaceC0253a p = null;
    private static final /* synthetic */ a.InterfaceC0253a q = null;
    private String r;
    private long s;
    private List<String> t;

    static {
        h();
    }

    public h() {
        super("ftyp");
        this.t = Collections.emptyList();
    }

    private static /* synthetic */ void h() {
        f.a.a.b.b bVar = new f.a.a.b.b("FileTypeBox.java", h.class);
        l = bVar.a("method-execution", bVar.a("1", "getMajorBrand", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", "java.lang.String"), 85);
        m = bVar.a("method-execution", bVar.a("1", "setMajorBrand", "com.coremedia.iso.boxes.FileTypeBox", "java.lang.String", "majorBrand", "", "void"), 94);
        n = bVar.a("method-execution", bVar.a("1", "setMinorVersion", "com.coremedia.iso.boxes.FileTypeBox", "long", "minorVersion", "", "void"), 103);
        o = bVar.a("method-execution", bVar.a("1", "getMinorVersion", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", "long"), 113);
        p = bVar.a("method-execution", bVar.a("1", "getCompatibleBrands", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", "java.util.List"), 122);
        q = bVar.a("method-execution", bVar.a("1", "setCompatibleBrands", "com.coremedia.iso.boxes.FileTypeBox", "java.util.List", "compatibleBrands", "", "void"), 126);
    }

    @Override // b.d.a.a
    protected long a() {
        return (this.t.size() * 4) + 8;
    }

    @Override // b.d.a.a
    protected void b(ByteBuffer byteBuffer) {
        byteBuffer.put(b.b.a.c.a(this.r));
        b.b.a.e.a(byteBuffer, this.s);
        Iterator<String> it = this.t.iterator();
        while (it.hasNext()) {
            byteBuffer.put(b.b.a.c.a(it.next()));
        }
    }

    public String f() {
        b.d.a.g.a().a(f.a.a.b.b.a(l, this, this));
        return this.r;
    }

    public long g() {
        b.d.a.g.a().a(f.a.a.b.b.a(o, this, this));
        return this.s;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FileTypeBox[");
        sb.append("majorBrand=");
        sb.append(f());
        sb.append(";");
        sb.append("minorVersion=");
        sb.append(g());
        for (String str : this.t) {
            sb.append(";");
            sb.append("compatibleBrand=");
            sb.append(str);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // b.d.a.a
    public void a(ByteBuffer byteBuffer) {
        this.r = b.b.a.d.a(byteBuffer);
        this.s = b.b.a.d.h(byteBuffer);
        int iRemaining = byteBuffer.remaining() / 4;
        this.t = new LinkedList();
        for (int i = 0; i < iRemaining; i++) {
            this.t.add(b.b.a.d.a(byteBuffer));
        }
    }

    public h(String str, long j, List<String> list) {
        super("ftyp");
        this.t = Collections.emptyList();
        this.r = str;
        this.s = j;
        this.t = list;
    }
}
