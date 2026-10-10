package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class VM implements C6Y {
    public static String[] A01;
    public final /* synthetic */ C2003Ve A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"Kjl9x1nXLMp", "FYT6FJfE388FncoeBbUW5LDH7Ti6Kpnc", "Yxd2XW5tX0tpbE5v80iFGWNMQ7F", "Eun4caaboMQouomEKTkKbMJy1uWMR8C3", "2B", "gVUv49X3C1I0CRHiCQrxfKc2j3pZm33W", "VtV7HGxoJcmYVE0XtMWfAnTQdxbbthfO", "Muv0aFmfDz7QlEQw1d"};
    }

    public VM(C2003Ve c2003Ve) {
        this.A00 = c2003Ve;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (this.A00.A05 != null) {
            C2003Ve c2003Ve = this.A00;
            return c2003Ve.A05(c2003Ve.A05.length);
        }
        C2003Ve c2003Ve2 = this.A00;
        String[] strArr = A01;
        if (strArr[7].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[0] = "czOc910r7ol";
        strArr2[2] = "WgsI1fVM7Yu7d9q7aeaJmksjNii";
        return c2003Ve2.A08(EnumC14006j.A07);
    }
}
