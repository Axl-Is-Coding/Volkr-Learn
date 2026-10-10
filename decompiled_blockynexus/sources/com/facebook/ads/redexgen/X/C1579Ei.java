package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ei, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1579Ei extends AbstractC1898Rb {
    public static byte[] A00;
    public static String[] A01;

    static {
        A04();
        A03();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{77, 72, 12, 69, 95, 12, 66, 67, 88, 12, 94, 73, 77, 72, 85, 12, 67, 94, 12, 77, 64, 94, 73, 77, 72, 85, 12, 72, 69, 95, 92, 64, 77, 85, 73, 72, 56, 57, 48, 61, 37};
    }

    public static void A04() {
        A01 = new String[]{"d7tLiGkqyLa7cKOkED7RtvmpIXZH8d0b", "LmA4T64r6T9e", "1EBtOKlPck0twYp3ElEJQmg3d", "uhXcdOUibAChEZNBNQuPqKRIQ2", "Z", "LV0o53GlcsqgEYK9Pr4EwymnJShooL9b", "NLZosIPt4DzrQXhRsvqwWEHVFOTX5bDJ", "MQasnwh7q"};
    }

    public C1579Ei(C2026Wb c2026Wb, C12741j c12741j) {
        super(c2026Wb, c12741j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A01(long j) {
        HashMap map = new HashMap();
        map.put(A00(36, 5, 104), String.valueOf(System.currentTimeMillis() - j));
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06(List<String> list, Map<String, String> map) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String[] strArr = A01;
            if (strArr[2].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[0] = "jDIZMq7wlAdnEmkEGDRuOyHBIh8qxobs";
            strArr2[0] = "jDIZMq7wlAdnEmkEGDRuOyHBIh8qxobs";
            if (zHasNext) {
                new Q3(this.A0C, map).execute(it.next());
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1898Rb
    public final void A0N() {
        RD rd = (RD) this.A02;
        if (rd.A0g()) {
            this.A07.A0A(rd);
            return;
        }
        throw new IllegalStateException(A00(0, 36, 24));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1898Rb
    public final void A0Q(InterfaceC12510m interfaceC12510m, C14498q c14498q, C14478o c14478o, Map<String, Object> map) {
        RD rd = (RD) interfaceC12510m;
        long jCurrentTimeMillis = System.currentTimeMillis();
        C1901Re c1901Re = new C1901Re(this, map, rd, jCurrentTimeMillis, c14478o);
        A0G().postDelayed(c1901Re, c14498q.A05().A05());
        rd.A0Y(this.A0C, new C1902Rf(this, c1901Re, jCurrentTimeMillis, c14478o), this.A09, map, C2213bT.A0I());
    }
}
