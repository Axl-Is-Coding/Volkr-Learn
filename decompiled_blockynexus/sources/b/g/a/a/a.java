package b.g.a.a;

import b.d.a.g;
import java.nio.ByteBuffer;
import java.util.List;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: AvcConfigurationBox.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends b.d.a.a {
    private static final /* synthetic */ a.InterfaceC0253a A = null;
    private static final /* synthetic */ a.InterfaceC0253a B = null;
    private static final /* synthetic */ a.InterfaceC0253a C = null;
    private static final /* synthetic */ a.InterfaceC0253a D = null;
    private static final /* synthetic */ a.InterfaceC0253a E = null;
    private static final /* synthetic */ a.InterfaceC0253a F = null;
    private static final /* synthetic */ a.InterfaceC0253a G = null;
    private static final /* synthetic */ a.InterfaceC0253a H = null;
    private static final /* synthetic */ a.InterfaceC0253a I = null;
    private static final /* synthetic */ a.InterfaceC0253a J = null;
    private static final /* synthetic */ a.InterfaceC0253a K = null;
    private static final /* synthetic */ a.InterfaceC0253a L = null;
    private static final /* synthetic */ a.InterfaceC0253a M = null;
    private static final /* synthetic */ a.InterfaceC0253a N = null;
    private static final /* synthetic */ a.InterfaceC0253a O = null;
    private static final /* synthetic */ a.InterfaceC0253a l = null;
    private static final /* synthetic */ a.InterfaceC0253a m = null;
    private static final /* synthetic */ a.InterfaceC0253a n = null;
    private static final /* synthetic */ a.InterfaceC0253a o = null;
    private static final /* synthetic */ a.InterfaceC0253a p = null;
    private static final /* synthetic */ a.InterfaceC0253a q = null;
    private static final /* synthetic */ a.InterfaceC0253a r = null;
    private static final /* synthetic */ a.InterfaceC0253a s = null;
    private static final /* synthetic */ a.InterfaceC0253a t = null;
    private static final /* synthetic */ a.InterfaceC0253a u = null;
    private static final /* synthetic */ a.InterfaceC0253a v = null;
    private static final /* synthetic */ a.InterfaceC0253a w = null;
    private static final /* synthetic */ a.InterfaceC0253a x = null;
    private static final /* synthetic */ a.InterfaceC0253a y = null;
    private static final /* synthetic */ a.InterfaceC0253a z = null;
    public b P;

    static {
        h();
    }

    public a() {
        super("avcC");
        this.P = new b();
    }

    private static /* synthetic */ void h() {
        f.a.a.b.b bVar = new f.a.a.b.b("AvcConfigurationBox.java", a.class);
        l = bVar.a("method-execution", bVar.a("1", "getConfigurationVersion", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 44);
        m = bVar.a("method-execution", bVar.a("1", "getAvcProfileIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 48);
        v = bVar.a("method-execution", bVar.a("1", "setAvcLevelIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "avcLevelIndication", "", "void"), 84);
        w = bVar.a("method-execution", bVar.a("1", "setLengthSizeMinusOne", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "lengthSizeMinusOne", "", "void"), 88);
        x = bVar.a("method-execution", bVar.a("1", "setSequenceParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSets", "", "void"), 92);
        y = bVar.a("method-execution", bVar.a("1", "setPictureParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "pictureParameterSets", "", "void"), 96);
        z = bVar.a("method-execution", bVar.a("1", "getChromaFormat", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 100);
        A = bVar.a("method-execution", bVar.a("1", "setChromaFormat", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "chromaFormat", "", "void"), 104);
        B = bVar.a("method-execution", bVar.a("1", "getBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 108);
        C = bVar.a("method-execution", bVar.a("1", "setBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "bitDepthLumaMinus8", "", "void"), 112);
        D = bVar.a("method-execution", bVar.a("1", "getBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 116);
        E = bVar.a("method-execution", bVar.a("1", "setBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "bitDepthChromaMinus8", "", "void"), 120);
        n = bVar.a("method-execution", bVar.a("1", "getProfileCompatibility", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 52);
        F = bVar.a("method-execution", bVar.a("1", "getSequenceParameterSetExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 124);
        G = bVar.a("method-execution", bVar.a("1", "setSequenceParameterSetExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSetExts", "", "void"), 128);
        H = bVar.a("method-execution", bVar.a("1", "hasExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "boolean"), 132);
        I = bVar.a("method-execution", bVar.a("1", "setHasExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "boolean", "hasExts", "", "void"), 136);
        J = bVar.a("method-execution", bVar.a("1", "getContentSize", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "long"), 147);
        K = bVar.a("method-execution", bVar.a("1", "getContent", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 153);
        L = bVar.a("method-execution", bVar.a("1", "getSPS", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 158);
        M = bVar.a("method-execution", bVar.a("1", "getPPS", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 162);
        N = bVar.a("method-execution", bVar.a("1", "getavcDecoderConfigurationRecord", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "com.mp4parser.iso14496.part15.AvcDecoderConfigurationRecord"), 167);
        O = bVar.a("method-execution", bVar.a("1", "toString", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.lang.String"), 172);
        o = bVar.a("method-execution", bVar.a("1", "getAvcLevelIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 56);
        p = bVar.a("method-execution", bVar.a("1", "getLengthSizeMinusOne", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 60);
        q = bVar.a("method-execution", bVar.a("1", "getSequenceParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 64);
        r = bVar.a("method-execution", bVar.a("1", "getPictureParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 68);
        s = bVar.a("method-execution", bVar.a("1", "setConfigurationVersion", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "configurationVersion", "", "void"), 72);
        t = bVar.a("method-execution", bVar.a("1", "setAvcProfileIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "avcProfileIndication", "", "void"), 76);
        u = bVar.a("method-execution", bVar.a("1", "setProfileCompatibility", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "profileCompatibility", "", "void"), 80);
    }

    public void a(int i) {
        g.a().a(f.a.a.b.b.a(v, this, this, f.a.a.a.a.a(i)));
        this.P.f2762d = i;
    }

    public void b(int i) {
        g.a().a(f.a.a.b.b.a(t, this, this, f.a.a.a.a.a(i)));
        this.P.f2760b = i;
    }

    public void c(int i) {
        g.a().a(f.a.a.b.b.a(E, this, this, f.a.a.a.a.a(i)));
        this.P.k = i;
    }

    public void d(int i) {
        g.a().a(f.a.a.b.b.a(C, this, this, f.a.a.a.a.a(i)));
        this.P.j = i;
    }

    public void e(int i) {
        g.a().a(f.a.a.b.b.a(A, this, this, f.a.a.a.a.a(i)));
        this.P.i = i;
    }

    public void f(int i) {
        g.a().a(f.a.a.b.b.a(s, this, this, f.a.a.a.a.a(i)));
        this.P.f2759a = i;
    }

    public void g(int i) {
        g.a().a(f.a.a.b.b.a(w, this, this, f.a.a.a.a.a(i)));
        this.P.f2763e = i;
    }

    public String toString() {
        g.a().a(f.a.a.b.b.a(O, this, this));
        return "AvcConfigurationBox{avcDecoderConfigurationRecord=" + this.P + '}';
    }

    public void a(List<byte[]> list) {
        g.a().a(f.a.a.b.b.a(y, this, this, list));
        this.P.g = list;
    }

    public void b(List<byte[]> list) {
        g.a().a(f.a.a.b.b.a(x, this, this, list));
        this.P.f2764f = list;
    }

    public void h(int i) {
        g.a().a(f.a.a.b.b.a(u, this, this, f.a.a.a.a.a(i)));
        this.P.f2761c = i;
    }

    @Override // b.d.a.a
    public void a(ByteBuffer byteBuffer) {
        this.P = new b(byteBuffer);
    }

    @Override // b.d.a.a
    public void b(ByteBuffer byteBuffer) {
        g.a().a(f.a.a.b.b.a(K, this, this, byteBuffer));
        this.P.a(byteBuffer);
    }

    @Override // b.d.a.a
    public long a() {
        g.a().a(f.a.a.b.b.a(J, this, this));
        return this.P.a();
    }
}
