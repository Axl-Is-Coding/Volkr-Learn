package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TApplicationException.java */
/* JADX INFO: loaded from: classes5.dex */
public class bb extends bi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f20699a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f20700b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f20701c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f20702d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f20703e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f20704f = 5;
    public static final int g = 6;
    public static final int h = 7;
    private static final cg j = new cg("TApplicationException");
    private static final bw k = new bw("message", (byte) 11, 1);
    private static final bw l = new bw("type", (byte) 8, 2);
    private static final long m = 1;
    protected int i;

    public bb() {
        this.i = 0;
    }

    public int a() {
        return this.i;
    }

    public void b(cb cbVar) throws bi {
        cbVar.a(j);
        if (getMessage() != null) {
            cbVar.a(k);
            cbVar.a(getMessage());
            cbVar.c();
        }
        cbVar.a(l);
        cbVar.a(this.i);
        cbVar.c();
        cbVar.d();
        cbVar.b();
    }

    public static bb a(cb cbVar) throws bi {
        cbVar.j();
        String strZ = null;
        int iW = 0;
        while (true) {
            bw bwVarL = cbVar.l();
            byte b2 = bwVarL.f20755b;
            if (b2 == 0) {
                cbVar.k();
                return new bb(iW, strZ);
            }
            short s = bwVarL.f20756c;
            if (s != 1) {
                if (s != 2) {
                    ce.a(cbVar, b2);
                } else if (b2 == 8) {
                    iW = cbVar.w();
                } else {
                    ce.a(cbVar, b2);
                }
            } else if (b2 == 11) {
                strZ = cbVar.z();
            } else {
                ce.a(cbVar, b2);
            }
            cbVar.m();
        }
    }

    public bb(int i) {
        this.i = 0;
        this.i = i;
    }

    public bb(int i, String str) {
        super(str);
        this.i = 0;
        this.i = i;
    }

    public bb(String str) {
        super(str);
        this.i = 0;
    }
}
