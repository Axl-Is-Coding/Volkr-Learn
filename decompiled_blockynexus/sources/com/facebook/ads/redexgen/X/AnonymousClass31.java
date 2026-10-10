package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.31, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass31 extends CT implements Handler.Callback {
    public static String[] A0D;
    public int A00;
    public int A01;
    public Format A02;
    public InterfaceC2129a4 A03;
    public C1490Ag A04;
    public AR A05;
    public AR A06;
    public boolean A07;
    public boolean A08;
    public final Handler A09;
    public final A7 A0A;
    public final G8 A0B;
    public final G9 A0C;

    static {
        A05();
    }

    public static void A05() {
        A0D = new String[]{"fagSsoac43UJSJG", "PL0Df5XObPsMjoFT3sU6Lp83XbviyP8R", "k75ap2fxOZvkqr2FjEQ9d3Y", "qEZm9kPptvCV49j1bDgJYwonF92a", "8QH8MqTnW7KMzd9bL", "CjrIcpNXno9M2QOeMZvTD2WdktHrPs5P", "AfT76Pf2kDJi2th", "sZbuEqgSWLt9Albo4x4yfDH"};
    }

    public AnonymousClass31(G9 g9, Looper looper) {
        this(g9, looper, G8.A00);
    }

    public AnonymousClass31(G9 g9, Looper looper, G8 g8) {
        super(3);
        this.A0C = (G9) C1662Hr.A01(g9);
        this.A09 = looper == null ? null : new Handler(looper, this);
        this.A0B = g8;
        this.A0A = new A7();
    }

    private long A00() {
        int i = this.A01;
        if (i == -1 || i >= this.A06.A6M()) {
            return Long.MAX_VALUE;
        }
        return this.A06.A6L(this.A01);
    }

    private void A01() {
        A07(Collections.emptyList());
    }

    private void A02() {
        this.A04 = null;
        this.A01 = -1;
        AR ar = this.A06;
        if (ar != null) {
            ar.A08();
            this.A06 = null;
        }
        AR ar2 = this.A05;
        if (ar2 != null) {
            ar2.A08();
            this.A05 = null;
        }
    }

    private void A03() {
        A02();
        this.A03.ACW();
        this.A03 = null;
        this.A00 = 0;
    }

    private void A04() {
        A03();
        this.A03 = this.A0B.A4F(this.A02);
    }

    private void A06(List<G5> list) {
        this.A0C.A9a(list);
    }

    private void A07(List<G5> list) {
        Handler handler = this.A09;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            A06(list);
        }
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final void A14() {
        this.A02 = null;
        A01();
        A03();
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final void A17(long j, boolean z) {
        A01();
        this.A07 = false;
        this.A08 = false;
        if (this.A00 != 0) {
            A04();
            return;
        }
        A02();
        InterfaceC2129a4 interfaceC2129a4 = this.A03;
        String[] strArr = A0D;
        if (strArr[2].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[1] = "SIdEizz9oP1X0InrrFd2Zym6xF4ie8Hi";
        strArr2[1] = "SIdEizz9oP1X0InrrFd2Zym6xF4ie8Hi";
        interfaceC2129a4.flush();
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final void A19(Format[] formatArr, long j) throws C14789u {
        this.A02 = formatArr[0];
        if (this.A03 != null) {
            this.A00 = 1;
        } else {
            this.A03 = this.A0B.A4F(this.A02);
        }
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final boolean A7n() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final boolean A7w() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0  */
    @Override // com.facebook.ads.redexgen.X.XZ
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void ACj(long r10, long r12) throws com.facebook.ads.redexgen.X.C14789u {
        /*
            Method dump skipped, instruction units count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass31.ACj(long, long):void");
    }

    @Override // com.facebook.ads.redexgen.X.AS
    public final int ADl(Format format) {
        if (this.A0B.ADm(format)) {
            return CT.A0z(null, format.A0H) ? 4 : 2;
        }
        if (I9.A0B(format.A0O)) {
            return 1;
        }
        return 0;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            A06((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }
}
