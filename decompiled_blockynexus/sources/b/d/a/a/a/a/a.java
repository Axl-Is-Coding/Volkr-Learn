package b.d.a.a.a.a;

import com.just.agentweb.WebIndicator;
import com.uc.crashsdk.export.LogType;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: AudioSpecificConfig.java */
/* JADX INFO: loaded from: classes2.dex */
@g(objectTypeIndication = 64, tags = {5})
public class a extends b.d.a.a.a.a.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Map<Integer, Integer> f2482d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Map<Integer, String> f2483e = new HashMap();
    public int A;
    public int B;
    public int C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;
    public boolean H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public boolean W;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    byte[] f2484f;
    public C0039a g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* JADX INFO: renamed from: b.d.a.a.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AudioSpecificConfig.java */
    public class C0039a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2487c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2488d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f2489e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f2490f;
        public boolean g;

        public C0039a(int i, c cVar) {
            int iA;
            this.f2485a = cVar.a();
            this.f2486b = cVar.a();
            this.f2487c = cVar.a();
            this.f2488d = cVar.a();
            this.f2489e = cVar.a();
            if (this.f2489e) {
                this.f2490f = cVar.a();
                this.g = cVar.a();
                a(i, cVar);
            }
            while (cVar.a(4) != 0) {
                int iA2 = cVar.a(4);
                if (iA2 == 15) {
                    iA = cVar.a(8);
                    iA2 += iA;
                } else {
                    iA = 0;
                }
                if (iA == 255) {
                    iA2 += cVar.a(16);
                }
                for (int i2 = 0; i2 < iA2; i2++) {
                    cVar.a(8);
                }
            }
        }

        public void a(int i, c cVar) {
            int i2;
            switch (i) {
                case 1:
                case 2:
                    i2 = 1;
                    break;
                case 3:
                    i2 = 2;
                    break;
                case 4:
                case 5:
                case 6:
                    i2 = 3;
                    break;
                case 7:
                    i2 = 4;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                a.this.new b(cVar);
            }
        }
    }

    /* JADX INFO: compiled from: AudioSpecificConfig.java */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2493c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2494d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2495e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f2496f;
        public boolean g;
        public int h;
        public boolean i;
        public int j;
        public int k;
        public int l;
        public boolean m;
        public boolean n;

        public b(c cVar) {
            this.f2491a = cVar.a();
            this.f2492b = cVar.a(4);
            this.f2493c = cVar.a(4);
            this.f2494d = cVar.a(3);
            this.f2495e = cVar.a(2);
            this.f2496f = cVar.a();
            this.g = cVar.a();
            if (this.f2496f) {
                this.h = cVar.a(2);
                this.i = cVar.a();
                this.j = cVar.a(2);
            }
            if (this.g) {
                this.k = cVar.a(2);
                this.l = cVar.a(2);
                this.m = cVar.a();
            }
            this.n = cVar.a();
        }
    }

    static {
        f2482d.put(0, 96000);
        f2482d.put(1, 88200);
        f2482d.put(2, 64000);
        f2482d.put(3, 48000);
        f2482d.put(4, 44100);
        f2482d.put(5, Integer.valueOf(LogType.UNEXP_KNOWN_REASON));
        f2482d.put(6, 24000);
        f2482d.put(7, 22050);
        f2482d.put(8, 16000);
        f2482d.put(9, 12000);
        f2482d.put(10, 11025);
        f2482d.put(11, Integer.valueOf(WebIndicator.MAX_UNIFORM_SPEED_DURATION));
        f2483e.put(1, "AAC main");
        f2483e.put(2, "AAC LC");
        f2483e.put(3, "AAC SSR");
        f2483e.put(4, "AAC LTP");
        f2483e.put(5, "SBR");
        f2483e.put(6, "AAC Scalable");
        f2483e.put(7, "TwinVQ");
        f2483e.put(8, "CELP");
        f2483e.put(9, "HVXC");
        f2483e.put(10, "(reserved)");
        f2483e.put(11, "(reserved)");
        f2483e.put(12, "TTSI");
        f2483e.put(13, "Main synthetic");
        f2483e.put(14, "Wavetable synthesis");
        f2483e.put(15, "General MIDI");
        f2483e.put(16, "Algorithmic Synthesis and Audio FX");
        f2483e.put(17, "ER AAC LC");
        f2483e.put(18, "(reserved)");
        f2483e.put(19, "ER AAC LTP");
        f2483e.put(20, "ER AAC Scalable");
        f2483e.put(21, "ER TwinVQ");
        f2483e.put(22, "ER BSAC");
        f2483e.put(23, "ER AAC LD");
        f2483e.put(24, "ER CELP");
        f2483e.put(25, "ER HVXC");
        f2483e.put(26, "ER HILN");
        f2483e.put(27, "ER Parametric");
        f2483e.put(28, "SSC");
        f2483e.put(29, "PS");
        f2483e.put(30, "MPEG Surround");
        f2483e.put(31, "(escape)");
        f2483e.put(32, "Layer-1");
        f2483e.put(33, "Layer-2");
        f2483e.put(34, "Layer-3");
        f2483e.put(35, "DST");
        f2483e.put(36, "ALS");
        f2483e.put(37, "SLS");
        f2483e.put(38, "SLS non-core");
        f2483e.put(39, "ER AAC ELD");
        f2483e.put(40, "SMR Simple");
        f2483e.put(41, "SMR Main");
    }

    private void b(int i, int i2, int i3, c cVar) throws IOException {
        this.w = cVar.a(1);
        this.x = cVar.a(1);
        if (this.x == 1) {
            this.y = cVar.a(14);
        }
        this.z = cVar.a(1);
        if (i2 == 0) {
            throw new UnsupportedOperationException("can't parse program_config_element yet");
        }
        if (i3 == 6 || i3 == 20) {
            this.A = cVar.a(3);
        }
        if (this.z == 1) {
            if (i3 == 22) {
                this.B = cVar.a(5);
                this.C = cVar.a(11);
            }
            if (i3 == 17 || i3 == 19 || i3 == 20 || i3 == 23) {
                this.D = cVar.a();
                this.E = cVar.a();
                this.F = cVar.a();
            }
            this.G = cVar.a(1);
        }
        this.H = true;
    }

    private void c(int i, int i2, int i3, c cVar) throws IOException {
        this.P = cVar.a(1);
        this.Q = cVar.a(8);
        this.R = cVar.a(4);
        this.S = cVar.a(12);
        this.T = cVar.a(2);
    }

    private int f() {
        return 0;
    }

    private void f(int i, int i2, int i3, c cVar) throws IOException {
        this.I = cVar.a(1);
        if (this.I == 1) {
            e(i, i2, i3, cVar);
        } else {
            d(i, i2, i3, cVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0125  */
    @Override // b.d.a.a.a.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.nio.ByteBuffer r10) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 570
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.a.a.a.a.a.a(java.nio.ByteBuffer):void");
    }

    public ByteBuffer d() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(e());
        b.b.a.e.c(byteBufferAllocate, 5);
        b.b.a.e.c(byteBufferAllocate, e() - 2);
        d dVar = new d(byteBufferAllocate);
        dVar.a(this.h, 5);
        dVar.a(this.i, 4);
        if (this.i == 15) {
            throw new UnsupportedOperationException("can't serialize that yet");
        }
        dVar.a(this.k, 4);
        return byteBufferAllocate;
    }

    public int e() {
        if (this.h == 2) {
            return f() + 4;
        }
        throw new UnsupportedOperationException("can't serialize that yet");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.E == aVar.E && this.D == aVar.D && this.F == aVar.F && this.h == aVar.h && this.k == aVar.k && this.y == aVar.y && this.x == aVar.x && this.u == aVar.u && this.t == aVar.t && this.N == aVar.N && this.l == aVar.l && this.q == aVar.q && this.z == aVar.z && this.G == aVar.G && this.p == aVar.p && this.o == aVar.o && this.s == aVar.s && this.w == aVar.w && this.H == aVar.H && this.T == aVar.T && this.U == aVar.U && this.V == aVar.V && this.S == aVar.S && this.Q == aVar.Q && this.P == aVar.P && this.R == aVar.R && this.M == aVar.M && this.L == aVar.L && this.I == aVar.I && this.A == aVar.A && this.C == aVar.C && this.B == aVar.B && this.K == aVar.K && this.J == aVar.J && this.W == aVar.W && this.n == aVar.n && this.r == aVar.r && this.j == aVar.j && this.i == aVar.i && this.m == aVar.m && this.v == aVar.v && this.O == aVar.O && Arrays.equals(this.f2484f, aVar.f2484f);
    }

    public int hashCode() {
        byte[] bArr = this.f2484f;
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((bArr != null ? Arrays.hashCode(bArr) : 0) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + (this.m ? 1 : 0)) * 31) + (this.n ? 1 : 0)) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31) + this.s) * 31) + this.t) * 31) + this.u) * 31) + this.v) * 31) + this.w) * 31) + this.x) * 31) + this.y) * 31) + this.z) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + (this.D ? 1 : 0)) * 31) + (this.E ? 1 : 0)) * 31) + (this.F ? 1 : 0)) * 31) + this.G) * 31) + (this.H ? 1 : 0)) * 31) + this.I) * 31) + this.J) * 31) + this.K) * 31) + this.L) * 31) + this.M) * 31) + this.N) * 31) + this.O) * 31) + this.P) * 31) + this.Q) * 31) + this.R) * 31) + this.S) * 31) + this.T) * 31) + this.U) * 31) + this.V) * 31) + (this.W ? 1 : 0);
    }

    @Override // b.d.a.a.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AudioSpecificConfig");
        sb.append("{configBytes=");
        sb.append(b.b.a.b.a(this.f2484f));
        sb.append(", audioObjectType=");
        sb.append(this.h);
        sb.append(" (");
        sb.append(f2483e.get(Integer.valueOf(this.h)));
        sb.append(")");
        sb.append(", samplingFrequencyIndex=");
        sb.append(this.i);
        sb.append(" (");
        sb.append(f2482d.get(Integer.valueOf(this.i)));
        sb.append(")");
        sb.append(", samplingFrequency=");
        sb.append(this.j);
        sb.append(", channelConfiguration=");
        sb.append(this.k);
        if (this.l > 0) {
            sb.append(", extensionAudioObjectType=");
            sb.append(this.l);
            sb.append(" (");
            sb.append(f2483e.get(Integer.valueOf(this.l)));
            sb.append(")");
            sb.append(", sbrPresentFlag=");
            sb.append(this.m);
            sb.append(", psPresentFlag=");
            sb.append(this.n);
            sb.append(", extensionSamplingFrequencyIndex=");
            sb.append(this.o);
            sb.append(" (");
            sb.append(f2482d.get(Integer.valueOf(this.o)));
            sb.append(")");
            sb.append(", extensionSamplingFrequency=");
            sb.append(this.p);
            sb.append(", extensionChannelConfiguration=");
            sb.append(this.q);
        }
        sb.append(", syncExtensionType=");
        sb.append(this.v);
        if (this.H) {
            sb.append(", frameLengthFlag=");
            sb.append(this.w);
            sb.append(", dependsOnCoreCoder=");
            sb.append(this.x);
            sb.append(", coreCoderDelay=");
            sb.append(this.y);
            sb.append(", extensionFlag=");
            sb.append(this.z);
            sb.append(", layerNr=");
            sb.append(this.A);
            sb.append(", numOfSubFrame=");
            sb.append(this.B);
            sb.append(", layer_length=");
            sb.append(this.C);
            sb.append(", aacSectionDataResilienceFlag=");
            sb.append(this.D);
            sb.append(", aacScalefactorDataResilienceFlag=");
            sb.append(this.E);
            sb.append(", aacSpectralDataResilienceFlag=");
            sb.append(this.F);
            sb.append(", extensionFlag3=");
            sb.append(this.G);
        }
        if (this.W) {
            sb.append(", isBaseLayer=");
            sb.append(this.I);
            sb.append(", paraMode=");
            sb.append(this.J);
            sb.append(", paraExtensionFlag=");
            sb.append(this.K);
            sb.append(", hvxcVarMode=");
            sb.append(this.L);
            sb.append(", hvxcRateMode=");
            sb.append(this.M);
            sb.append(", erHvxcExtensionFlag=");
            sb.append(this.N);
            sb.append(", var_ScalableFlag=");
            sb.append(this.O);
            sb.append(", hilnQuantMode=");
            sb.append(this.P);
            sb.append(", hilnMaxNumLine=");
            sb.append(this.Q);
            sb.append(", hilnSampleRateCode=");
            sb.append(this.R);
            sb.append(", hilnFrameLength=");
            sb.append(this.S);
            sb.append(", hilnContMode=");
            sb.append(this.T);
            sb.append(", hilnEnhaLayer=");
            sb.append(this.U);
            sb.append(", hilnEnhaQuantMode=");
            sb.append(this.V);
        }
        sb.append('}');
        return sb.toString();
    }

    private void e(int i, int i2, int i3, c cVar) throws IOException {
        this.J = cVar.a(2);
        if (this.J != 1) {
            a(i, i2, i3, cVar);
        }
        if (this.J != 0) {
            c(i, i2, i3, cVar);
        }
        this.K = cVar.a(1);
        this.W = true;
    }

    public void c(int i) {
        this.i = i;
    }

    private void d(int i, int i2, int i3, c cVar) throws IOException {
        this.U = cVar.a(1);
        if (this.U == 1) {
            this.V = cVar.a(2);
        }
    }

    public void b(int i) {
        this.k = i;
    }

    private int a(c cVar) throws IOException {
        int iA = cVar.a(5);
        return iA == 31 ? cVar.a(6) + 32 : iA;
    }

    private void a(int i, int i2, int i3, c cVar) throws IOException {
        this.L = cVar.a(1);
        this.M = cVar.a(2);
        this.N = cVar.a(1);
        if (this.N == 1) {
            this.O = cVar.a(1);
        }
    }

    public void a(int i) {
        this.h = i;
    }
}
