package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3H, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3H extends CT implements Handler.Callback {
    public static String[] A0B;
    public int A00;
    public int A01;
    public InterfaceC1561Do A02;
    public boolean A03;
    public final Handler A04;
    public final A7 A05;
    public final InterfaceC1563Dq A06;
    public final C2 A07;
    public final InterfaceC1564Dr A08;
    public final long[] A09;
    public final Metadata[] A0A;

    static {
        A01();
    }

    public static void A01() {
        A0B = new String[]{"03Bqi0KbTszfVpZRuJU3ds8C", "k1GP5ixeRS7AgIgDUeTgx", "4NCpljRKbMpI7nrSCbEL8iNDtCMdRKX", "14neR4MzrfGB8mqjKcaUOPf9qenZk", "2yEqk33zpOnAOPOYE0N2JJzqUjZjGZ3w", "pyvhSQAAYlr5mafzJ0Hik2RvaYh4S", "eoJA2AjfdFBVMgfGYGogvo8ECKzj9gDa", "xUrUxSkwRZIOD3qEvYK8t45D"};
    }

    public C3H(InterfaceC1564Dr interfaceC1564Dr, Looper looper) {
        this(interfaceC1564Dr, looper, InterfaceC1563Dq.A00);
    }

    public C3H(InterfaceC1564Dr interfaceC1564Dr, Looper looper, InterfaceC1563Dq interfaceC1563Dq) {
        super(4);
        this.A08 = (InterfaceC1564Dr) C1662Hr.A01(interfaceC1564Dr);
        this.A04 = looper == null ? null : new Handler(looper, this);
        this.A06 = (InterfaceC1563Dq) C1662Hr.A01(interfaceC1563Dq);
        this.A05 = new A7();
        this.A07 = new C2();
        this.A0A = new Metadata[5];
        this.A09 = new long[5];
    }

    private void A00() {
        Arrays.fill(this.A0A, (Object) null);
        this.A01 = 0;
        this.A00 = 0;
    }

    private void A02(Metadata metadata) {
        Handler handler = this.A04;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            A03(metadata);
        }
    }

    private void A03(Metadata metadata) {
        this.A08.AAX(metadata);
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final void A14() {
        A00();
        this.A02 = null;
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final void A17(long j, boolean z) {
        A00();
        this.A03 = false;
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final void A19(Format[] formatArr, long j) throws C14789u {
        this.A02 = this.A06.A4E(formatArr[0]);
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final boolean A7n() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final boolean A7w() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final void ACj(long j, long j2) throws C14789u {
        if (!this.A03 && this.A00 < 5) {
            this.A07.A07();
            if (A12(this.A05, this.A07, false) == -4) {
                if (this.A07.A04()) {
                    this.A03 = true;
                } else if (!this.A07.A03()) {
                    C2 c2 = this.A07;
                    String[] strArr = A0B;
                    if (strArr[0].length() != strArr[7].length()) {
                        String[] strArr2 = A0B;
                        strArr2[6] = "oJNy7wvRq4TsnN4Ik7JOHneCelTjV3TM";
                        strArr2[4] = "4f5lGS7X1G5JYf6Usji5tJWLoKljCGYJ";
                        c2.A00 = this.A05.A00.A0G;
                        this.A07.A08();
                    } else {
                        String[] strArr3 = A0B;
                        strArr3[0] = "JrbxqibW71vJtGIxmKNzu0gc";
                        strArr3[7] = "aBslXCcOqyoFcXReLJb0k0eg";
                        c2.A00 = this.A05.A00.A0G;
                        this.A07.A08();
                    }
                    try {
                        int i = (this.A01 + this.A00) % 5;
                        this.A0A[i] = this.A02.A4e(this.A07);
                        this.A09[i] = ((C2067Xq) this.A07).A00;
                        this.A00++;
                    } catch (C1562Dp e2) {
                        throw C14789u.A01(e2, A10());
                    }
                }
            }
        }
        int i2 = this.A00;
        String[] strArr4 = A0B;
        if (strArr4[0].length() != strArr4[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr5 = A0B;
        strArr5[2] = "FI5ou6JhGKfNQASG6lr2Dh53KdKmMJ1";
        strArr5[1] = "8nK6Ac79BLzTFAHCrRK9v";
        if (i2 > 0) {
            long[] jArr = this.A09;
            int i3 = this.A01;
            if (jArr[i3] <= j) {
                A02(this.A0A[i3]);
                Metadata[] metadataArr = this.A0A;
                int i4 = this.A01;
                metadataArr[i4] = null;
                this.A01 = (i4 + 1) % 5;
                this.A00--;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AS
    public final int ADl(Format format) {
        if (this.A06.ADm(format)) {
            return CT.A0z(null, format.A0H) ? 4 : 2;
        }
        return 0;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            A03((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }
}
