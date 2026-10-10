package b.b.a.a;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: HandlerBox.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends b.d.a.c {
    public static final Map<String, String> p;
    private static final /* synthetic */ a.InterfaceC0253a q = null;
    private static final /* synthetic */ a.InterfaceC0253a r = null;
    private static final /* synthetic */ a.InterfaceC0253a s = null;
    private static final /* synthetic */ a.InterfaceC0253a t = null;
    private static final /* synthetic */ a.InterfaceC0253a u = null;
    private static final /* synthetic */ a.InterfaceC0253a v = null;
    private long A;
    private boolean B;
    private long C;
    private String w;
    private String x;
    private long y;
    private long z;

    static {
        j();
        HashMap map = new HashMap();
        map.put("odsm", "ObjectDescriptorStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("crsm", "ClockReferenceStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("sdsm", "SceneDescriptionStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("m7sm", "MPEG7Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("ocsm", "ObjectContentInfoStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("ipsm", "IPMP Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("mjsm", "MPEG-J Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("mdir", "Apple Meta Data iTunes Reader");
        map.put("mp7b", "MPEG-7 binary XML");
        map.put("mp7t", "MPEG-7 XML");
        map.put("vide", "Video Track");
        map.put("soun", "Sound Track");
        map.put(ViewHierarchyConstants.HINT_KEY, "Hint Track");
        map.put("appl", "Apple specific");
        map.put("meta", "Timed Metadata track - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        p = Collections.unmodifiableMap(map);
    }

    public j() {
        super("hdlr");
        this.x = null;
        this.B = true;
    }

    private static /* synthetic */ void j() {
        f.a.a.b.b bVar = new f.a.a.b.b("HandlerBox.java", j.class);
        q = bVar.a("method-execution", bVar.a("1", "getHandlerType", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 78);
        r = bVar.a("method-execution", bVar.a("1", "setName", "com.coremedia.iso.boxes.HandlerBox", "java.lang.String", "name", "", "void"), 87);
        s = bVar.a("method-execution", bVar.a("1", "setHandlerType", "com.coremedia.iso.boxes.HandlerBox", "java.lang.String", "handlerType", "", "void"), 91);
        t = bVar.a("method-execution", bVar.a("1", "getName", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 95);
        u = bVar.a("method-execution", bVar.a("1", "getHumanReadableTrackType", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 99);
        v = bVar.a("method-execution", bVar.a("1", "toString", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 149);
    }

    public void a(String str) {
        b.d.a.g.a().a(f.a.a.b.b.a(s, this, this, str));
        this.w = str;
    }

    public void b(String str) {
        b.d.a.g.a().a(f.a.a.b.b.a(r, this, this, str));
        this.x = str;
    }

    public String h() {
        b.d.a.g.a().a(f.a.a.b.b.a(q, this, this));
        return this.w;
    }

    public String i() {
        b.d.a.g.a().a(f.a.a.b.b.a(t, this, this));
        return this.x;
    }

    public String toString() {
        b.d.a.g.a().a(f.a.a.b.b.a(v, this, this));
        return "HandlerBox[handlerType=" + h() + ";name=" + i() + "]";
    }

    @Override // b.d.a.a
    protected long a() {
        return this.B ? b.b.a.f.b(this.x) + 25 : b.b.a.f.b(this.x) + 24;
    }

    @Override // b.d.a.a
    protected void b(ByteBuffer byteBuffer) {
        d(byteBuffer);
        b.b.a.e.a(byteBuffer, this.C);
        byteBuffer.put(b.b.a.c.a(this.w));
        b.b.a.e.a(byteBuffer, this.y);
        b.b.a.e.a(byteBuffer, this.z);
        b.b.a.e.a(byteBuffer, this.A);
        String str = this.x;
        if (str != null) {
            byteBuffer.put(b.b.a.f.a(str));
        }
        if (this.B) {
            byteBuffer.put((byte) 0);
        }
    }

    @Override // b.d.a.a
    public void a(ByteBuffer byteBuffer) {
        c(byteBuffer);
        this.C = b.b.a.d.h(byteBuffer);
        this.w = b.b.a.d.a(byteBuffer);
        this.y = b.b.a.d.h(byteBuffer);
        this.z = b.b.a.d.h(byteBuffer);
        this.A = b.b.a.d.h(byteBuffer);
        if (byteBuffer.remaining() > 0) {
            this.x = b.b.a.d.a(byteBuffer, byteBuffer.remaining());
            if (this.x.endsWith("\u0000")) {
                String str = this.x;
                this.x = str.substring(0, str.length() - 1);
                this.B = true;
                return;
            }
            this.B = false;
            return;
        }
        this.B = false;
    }
}
