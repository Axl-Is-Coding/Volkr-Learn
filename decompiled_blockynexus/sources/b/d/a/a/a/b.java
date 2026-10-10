package b.d.a.a.a;

import b.d.a.a.a.a.h;
import b.d.a.g;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: ESDescriptorBox.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends a {
    private static final /* synthetic */ a.InterfaceC0253a A = null;
    private static final /* synthetic */ a.InterfaceC0253a x = null;
    private static final /* synthetic */ a.InterfaceC0253a y = null;
    private static final /* synthetic */ a.InterfaceC0253a z = null;

    static {
        j();
    }

    public b() {
        super("esds");
    }

    private static /* synthetic */ void j() {
        f.a.a.b.b bVar = new f.a.a.b.b("ESDescriptorBox.java", b.class);
        x = bVar.a("method-execution", bVar.a("1", "getEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor"), 33);
        y = bVar.a("method-execution", bVar.a("1", "setEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor", "esDescriptor", "", "void"), 37);
        z = bVar.a("method-execution", bVar.a("1", "equals", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "java.lang.Object", "o", "", "boolean"), 42);
        A = bVar.a("method-execution", bVar.a("1", "hashCode", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "int"), 53);
    }

    public void a(h hVar) {
        g.a().a(f.a.a.b.b.a(y, this, this, hVar));
        super.a((b.d.a.a.a.a.b) hVar);
    }

    public boolean equals(Object obj) {
        g.a().a(f.a.a.b.b.a(z, this, this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        ByteBuffer byteBuffer = this.w;
        return byteBuffer == null ? bVar.w == null : byteBuffer.equals(bVar.w);
    }

    public int hashCode() {
        g.a().a(f.a.a.b.b.a(A, this, this));
        ByteBuffer byteBuffer = this.w;
        if (byteBuffer != null) {
            return byteBuffer.hashCode();
        }
        return 0;
    }
}
