package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bv;

/* JADX INFO: compiled from: TProtocolUtil.java */
/* JADX INFO: loaded from: classes5.dex */
public class ce {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f20830a = Integer.MAX_VALUE;

    public static void a(int i) {
        f20830a = i;
    }

    public static void a(cb cbVar, byte b2) throws bi {
        a(cbVar, b2, f20830a);
    }

    public static void a(cb cbVar, byte b2, int i) throws bi {
        if (i > 0) {
            int i2 = 0;
            switch (b2) {
                case 2:
                    cbVar.t();
                    return;
                case 3:
                    cbVar.u();
                    return;
                case 4:
                    cbVar.y();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    cbVar.v();
                    return;
                case 8:
                    cbVar.w();
                    return;
                case 10:
                    cbVar.x();
                    return;
                case 11:
                    cbVar.A();
                    return;
                case 12:
                    cbVar.j();
                    while (true) {
                        byte b3 = cbVar.l().f20755b;
                        if (b3 == 0) {
                            cbVar.k();
                            return;
                        } else {
                            a(cbVar, b3, i - 1);
                            cbVar.m();
                        }
                    }
                    break;
                case 13:
                    by byVarN = cbVar.n();
                    while (i2 < byVarN.f20761c) {
                        int i3 = i - 1;
                        a(cbVar, byVarN.f20759a, i3);
                        a(cbVar, byVarN.f20760b, i3);
                        i2++;
                    }
                    cbVar.o();
                    return;
                case 14:
                    cf cfVarR = cbVar.r();
                    while (i2 < cfVarR.f20832b) {
                        a(cbVar, cfVarR.f20831a, i - 1);
                        i2++;
                    }
                    cbVar.s();
                    return;
                case 15:
                    bx bxVarP = cbVar.p();
                    while (i2 < bxVarP.f20758b) {
                        a(cbVar, bxVarP.f20757a, i - 1);
                        i2++;
                    }
                    cbVar.q();
                    return;
            }
        } else {
            throw new bi("Maximum skip depth exceeded");
        }
    }

    public static cd a(byte[] bArr, cd cdVar) {
        if (bArr[0] > 16) {
            return new bv.a();
        }
        return (bArr.length <= 1 || (bArr[1] & 128) == 0) ? cdVar : new bv.a();
    }
}
