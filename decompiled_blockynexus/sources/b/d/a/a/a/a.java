package b.d.a.a.a;

import b.d.a.a.a.a.l;
import b.d.a.c;
import b.d.a.g;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: AbstractDescriptorBox.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends c {
    private static Logger p;
    private static final /* synthetic */ a.InterfaceC0253a q = null;
    private static final /* synthetic */ a.InterfaceC0253a r = null;
    private static final /* synthetic */ a.InterfaceC0253a s = null;
    private static final /* synthetic */ a.InterfaceC0253a t = null;
    private static final /* synthetic */ a.InterfaceC0253a u = null;
    protected b.d.a.a.a.a.b v;
    protected ByteBuffer w;

    static {
        i();
        p = Logger.getLogger(a.class.getName());
    }

    public a(String str) {
        super(str);
    }

    private static /* synthetic */ void i() {
        f.a.a.b.b bVar = new f.a.a.b.b("AbstractDescriptorBox.java", a.class);
        q = bVar.a("method-execution", bVar.a("1", "getData", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "java.nio.ByteBuffer"), 42);
        r = bVar.a("method-execution", bVar.a("1", "getDescriptor", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor"), 58);
        s = bVar.a("method-execution", bVar.a("1", "getDescriptorAsString", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "java.lang.String"), 62);
        t = bVar.a("method-execution", bVar.a("1", "setDescriptor", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor", "descriptor", "", "void"), 66);
        u = bVar.a("method-execution", bVar.a("1", "setData", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "java.nio.ByteBuffer", "data", "", "void"), 70);
    }

    @Override // b.d.a.a
    protected long a() {
        return this.w.limit() + 4;
    }

    @Override // b.d.a.a
    protected void b(ByteBuffer byteBuffer) {
        d(byteBuffer);
        this.w.rewind();
        byteBuffer.put(this.w);
    }

    public void e(ByteBuffer byteBuffer) {
        g.a().a(f.a.a.b.b.a(u, this, this, byteBuffer));
        this.w = byteBuffer;
    }

    public void a(b.d.a.a.a.a.b bVar) {
        g.a().a(f.a.a.b.b.a(t, this, this, bVar));
        this.v = bVar;
    }

    @Override // b.d.a.a
    public void a(ByteBuffer byteBuffer) {
        c(byteBuffer);
        this.w = byteBuffer.slice();
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
        try {
            this.w.rewind();
            this.v = l.a(-1, this.w);
        } catch (IOException e2) {
            p.log(Level.WARNING, "Error parsing ObjectDescriptor", (Throwable) e2);
        } catch (IndexOutOfBoundsException e3) {
            p.log(Level.WARNING, "Error parsing ObjectDescriptor", (Throwable) e3);
        }
    }
}
