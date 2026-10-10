package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1959Tm implements C6Y {
    public static String[] A01;
    public final /* synthetic */ U1 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"hvm87xlnXDULJgpudJIAxjipYcLfVpPe", "aPn41y0iNcbQ3vA5A69njqeDstAsTpsV", "WXmwgMFdLW61FUxTxJC7XlBGpuRVL7Wu", "ePkGYIfh56SCQIxOGTOw2FZrMqM6oOvD", "H4G3VitdwZHOwCvFNAwNX1rKXwUNte3T", "QqBVensdyxYwCHnIBjshd9TsYmlVQcVc", "Npnx1Hqps9YG5SIKMksWN5UpsP86zlug", "K4PmfDIjqE3AfePNsovy4"};
    }

    public C1959Tm(U1 u1) {
        this.A00 = u1;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() throws Exception {
        String strA07 = this.A00.A03.A07(10005);
        if (strA07 != null) {
            U1 u1 = this.A00;
            if (A01[7].length() != 21) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[7] = "XG8OcIRWX82QEKbSmFw2M";
            strArr[7] = "XG8OcIRWX82QEKbSmFw2M";
            return u1.A09(strA07);
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
