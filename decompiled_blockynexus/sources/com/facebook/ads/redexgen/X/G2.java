package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.MediaController;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(14)
public final class G2 extends TextureView implements TextureView.SurfaceTextureListener, PL, PZ, PN {
    public static byte[] A0N;
    public static String[] A0O;
    public static final String A0P;
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public long A05;
    public Uri A06;

    @Nullable
    public Surface A07;
    public View A08;

    @Nullable
    public MediaController A09;
    public C2026Wb A0A;
    public EnumC1834Op A0B;

    @Nullable
    public PO A0C;
    public EnumC1846Pb A0D;
    public EnumC1846Pb A0E;
    public InterfaceC1847Pc A0F;

    @Nullable
    public String A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public boolean A0L;
    public boolean A0M;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0N, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 68);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A0N = new byte[]{86, 126, 126, 118, 125, 116, 49, 112, 125, 102, 112, 104, 98, 49, 101, 121, 99, 126, 102, 49, 112, 127, 49, 116, 105, 114, 116, 97, 101, 120, 126, 127, 49, 102, 120, 101, 121, 49, 98, 116, 101, 83, 112, 114, 122, 118, 99, 126, 100, 127, 117, 85, 99, 112, 102, 112, 115, 125, 116, 49, 126, 127, 49, 95, 126, 100, 118, 112, 101, 49, 112, 115, 126, 103, 116, Utf8.REPLACEMENT_BYTE, 49, 98, 126, 49, 102, 116, 49, 98, 120, 125, 116, 127, 101, 125, 104, 49, 120, 118, 127, 126, 99, 116, 49, 120, 101, Utf8.REPLACEMENT_BYTE, 76, 100, 100, 108, 103, 110, 43, 106, 103, 124, 106, 114, 120, 43, 127, 99, 121, 100, 124, 43, 106, 101, 43, 110, 115, 104, 110, 123, 127, 98, 100, 101, 43, 124, 98, 127, 99, 43, 120, 110, 127, 77, 100, 121, 110, 108, 121, 100, 126, 101, 111, 43, 100, 101, 43, 69, 100, 126, 108, 106, 127, 43, 106, 105, 100, 125, 110, 37, 43, 120, 100, 43, 124, 110, 43, 120, 98, 103, 110, 101, 127, 103, 114, 43, 98, 108, 101, 100, 121, 110, 43, 98, 127, 37, 33, 30, 19, 18, 24, 87, 4, 3, 22, 3, 18, 87, 20, 31, 22, 25, ci.n, 18, 19, 87, 3, 24, 87, 95, 93, 86, 93, 74, 81, 91};
        String[] strArr = A0O;
        if (strArr[4].charAt(4) == strArr[6].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0O;
        strArr2[3] = "4Rjqxy3w03hT2rk3wOaPN94qCv";
        strArr2[0] = "J56YrdEaTg6GnpCj3tljjm9xxp";
    }

    public static void A08() {
        A0O = new String[]{"5i34yksohRV8hSvEB2dTOBGqhO", "V2RNkeamXobpzSRVkM4sjlG", "1HR", "8SLqGCa2wxiVkGjIaPVK9LXerY", "SSmTkZgpl4jZsKBndOsNgmbhAq5FKejN", "hgMiihLf1lx1lIiVFZ8jC", "euSTtDnbG06q2RqThlQcyR1Es6oMHQDw", "iHXqYQoKvaPWKvo"};
    }

    static {
        A08();
        A07();
        A0P = G2.class.getSimpleName();
    }

    public G2(C2026Wb c2026Wb) {
        super(c2026Wb);
        this.A0D = EnumC1846Pb.A04;
        this.A0E = EnumC1846Pb.A04;
        this.A0L = false;
        this.A0M = false;
        this.A0J = false;
        this.A03 = 0;
        this.A02 = 0;
        this.A00 = 1.0f;
        this.A01 = -1;
        this.A0I = false;
        this.A0H = false;
        this.A0B = EnumC1834Op.A04;
        this.A0K = false;
        this.A0A = c2026Wb;
    }

    public G2(C2026Wb c2026Wb, AttributeSet attributeSet) {
        super(c2026Wb, attributeSet);
        this.A0D = EnumC1846Pb.A04;
        this.A0E = EnumC1846Pb.A04;
        this.A0L = false;
        this.A0M = false;
        this.A0J = false;
        this.A03 = 0;
        this.A02 = 0;
        this.A00 = 1.0f;
        this.A01 = -1;
        this.A0I = false;
        this.A0H = false;
        this.A0B = EnumC1834Op.A04;
        this.A0K = false;
        this.A0A = c2026Wb;
    }

    public G2(C2026Wb c2026Wb, AttributeSet attributeSet, int i) {
        super(c2026Wb, attributeSet, i);
        this.A0D = EnumC1846Pb.A04;
        this.A0E = EnumC1846Pb.A04;
        this.A0L = false;
        this.A0M = false;
        this.A0J = false;
        this.A03 = 0;
        this.A02 = 0;
        this.A00 = 1.0f;
        this.A01 = -1;
        this.A0I = false;
        this.A0H = false;
        this.A0B = EnumC1834Op.A04;
        this.A0K = false;
        this.A0A = c2026Wb;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A04() {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.PO r1 = new com.facebook.ads.redexgen.X.PO
            com.facebook.ads.redexgen.X.Wb r0 = r5.A0A
            r1.<init>(r0)
            r5.A0C = r1
            com.facebook.ads.redexgen.X.PO r0 = r5.A0C
            r0.A0I(r5)
            com.facebook.ads.redexgen.X.PO r0 = r5.A0C
            r0.A0H(r5)
            com.facebook.ads.redexgen.X.PO r0 = r5.A0C
            r3 = 0
            r0.A0J(r3)
            boolean r0 = r5.A0J
            if (r0 == 0) goto L69
            boolean r0 = r5.A0I
            if (r0 != 0) goto L69
            com.facebook.ads.redexgen.X.Wb r0 = r5.A0A
            android.app.Activity r4 = r0.A09()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.G2.A0O
            r0 = 5
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 21
            if (r1 == r0) goto L3a
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L3a:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.G2.A0O
            java.lang.String r1 = "kOzpobq3cn2ENPvO1dz11rE9gYrdsM2t"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "XeC6T5eSgweGxN3AGx0qK1AhpVQau6BW"
            r0 = 6
            r2[r0] = r1
            if (r4 == 0) goto Lc3
            android.widget.MediaController r0 = new android.widget.MediaController
            r0.<init>(r4)
            r5.A09 = r0
            android.widget.MediaController r1 = r5.A09
            android.view.View r0 = r5.A08
            if (r0 != 0) goto L56
            r0 = r5
        L56:
            r1.setAnchorView(r0)
            android.widget.MediaController r1 = r5.A09
            com.facebook.ads.redexgen.X.PT r0 = new com.facebook.ads.redexgen.X.PT
            r0.<init>(r5)
            r1.setMediaPlayer(r0)
            android.widget.MediaController r1 = r5.A09
            r0 = 1
            r1.setEnabled(r0)
        L69:
            java.lang.String r4 = r5.A0G
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.G2.A0O
            r0 = 4
            r1 = r2[r0]
            r0 = 6
            r2 = r2[r0]
            r0 = 4
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto Lb4
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.G2.A0O
            java.lang.String r1 = "7OzxCvlMe7OewOex"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "7OzxCvlMe7OewOex"
            r0 = 1
            r2[r0] = r1
            if (r4 == 0) goto L96
        L8c:
            int r0 = r4.length()
            if (r0 == 0) goto L96
            boolean r0 = r5.A0K
            if (r0 == 0) goto La1
        L96:
            com.facebook.ads.redexgen.X.PO r2 = r5.A0C
            android.content.Context r1 = r5.getContext()
            android.net.Uri r0 = r5.A06
            r2.A0F(r1, r0)
        La1:
            com.facebook.ads.redexgen.X.Pb r0 = com.facebook.ads.redexgen.X.EnumC1846Pb.A08
            r5.setVideoState(r0)
            boolean r0 = r5.isAvailable()
            if (r0 == 0) goto Lb3
            android.graphics.SurfaceTexture r0 = r5.getSurfaceTexture()
            r5.onSurfaceTextureAvailable(r0, r3, r3)
        Lb3:
            return
        Lb4:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.G2.A0O
            java.lang.String r1 = "NXAVCVHzJxAz58YH1UEgH4PHy83Kp8aQ"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "f1ODdwAOeVqSGvJpvEMDUKedn4FgojKu"
            r0 = 6
            r2[r0] = r1
            if (r4 == 0) goto L96
            goto L8c
        Lc3:
            r0 = 0
            r5.A09 = r0
            goto L69
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.G2.A04():void");
    }

    private void A05() {
        PO po = this.A0C;
        if (po == null) {
            return;
        }
        PM pmA09 = po.A09();
        String[] strArr = A0O;
        if (strArr[3].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0O;
        strArr2[3] = "yniwio37QFCiL85s5GWvJngxgc";
        strArr2[0] = "95HbvmBBNGyB2bovEph22CE4vZ";
        if (pmA09 != null) {
            A09(pmA09.A01, pmA09.A00);
        }
    }

    private void A06() {
        Surface surface = this.A07;
        if (surface != null) {
            surface.release();
            this.A07 = null;
        }
        PO po = this.A0C;
        if (po != null) {
            po.A0A();
            if (A0O[5].length() != 21) {
                throw new RuntimeException();
            }
            String[] strArr = A0O;
            strArr[3] = "he0jjWxzFB8qDestWT3k7cDZmQ";
            strArr[0] = "YQusGxI3ZRGEiRLtvLIlZ3cCdg";
            this.A0C = null;
        }
        this.A09 = null;
        this.A0M = false;
        setVideoState(EnumC1846Pb.A04);
    }

    private void A09(int i, int i2) {
        if (i != this.A03 || i2 != this.A02) {
            this.A03 = i;
            this.A02 = i2;
            if (this.A03 != 0 && this.A02 != 0) {
                requestLayout();
            }
        }
    }

    public static boolean A0A() {
        return PO.A04();
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final void A7L() {
        if (!this.A0H) {
            ABq(false, 3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final boolean A7S() {
        PO po = this.A0C;
        return po != null && po.A0L();
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final boolean A7T() {
        return this.A0M;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final boolean A7v() {
        return this.A0L;
    }

    @Override // com.facebook.ads.redexgen.X.PL
    public final void AAp(String str, Exception exc) {
        this.A0A.A0A().A8p(str);
        this.A0A.A0A().A2z(1);
        setVideoState(EnumC1846Pb.A03);
        this.A0A.A04().A8H(A03(219, 7, 124), C8Y.A15, new C8Z(exc));
    }

    @Override // com.facebook.ads.redexgen.X.PL
    public final void AAq(boolean z, int i) {
        if (this.A0C == null) {
            return;
        }
        if (i == 1) {
            EnumC1846Pb enumC1846Pb = EnumC1846Pb.A04;
            String[] strArr = A0O;
            if (strArr[3].length() != strArr[0].length()) {
                setVideoState(enumC1846Pb);
                return;
            }
            String[] strArr2 = A0O;
            strArr2[5] = "bt2gfLOq6VYcjgDmYUS3R";
            strArr2[5] = "bt2gfLOq6VYcjgDmYUS3R";
            setVideoState(enumC1846Pb);
            return;
        }
        if (i == 2) {
            A05();
            int i2 = this.A01;
            if (A0O[1].length() == 30) {
                throw new RuntimeException();
            }
            String[] strArr3 = A0O;
            strArr3[2] = "9yr";
            strArr3[7] = "mKFyaVoRgsxwFz3";
            if (i2 < 0) {
                return;
            }
            int i3 = this.A01;
            this.A01 = -1;
            this.A0F.ABC(i3, getCurrentPosition());
            return;
        }
        if (i == 3) {
            A05();
            this.A04 = System.currentTimeMillis();
            setRequestedVolume(this.A00);
            long j = this.A05;
            if (j > 0 && j < this.A0C.A08()) {
                this.A0C.A0E(this.A05);
                this.A05 = 0L;
            }
            if (this.A0C.A07() != 0 && !z && this.A0M) {
                setVideoState(EnumC1846Pb.A05);
                return;
            }
            if (z || this.A0D == EnumC1846Pb.A06) {
                return;
            }
            setVideoState(EnumC1846Pb.A07);
            EnumC1846Pb enumC1846Pb2 = this.A0E;
            String[] strArr4 = A0O;
            if (strArr4[4].charAt(4) != strArr4[6].charAt(4)) {
                String[] strArr5 = A0O;
                strArr5[3] = "QOwsd8cFgtBxhwq2W5mYjt9JcX";
                strArr5[0] = "NiYGjjh9hUScPgNoOA1xOqSddN";
                if (enumC1846Pb2 != EnumC1846Pb.A0A) {
                    return;
                }
            } else if (enumC1846Pb2 != EnumC1846Pb.A0A) {
                return;
            }
            ADb(this.A0B, 8);
            EnumC1846Pb enumC1846Pb3 = EnumC1846Pb.A04;
            String[] strArr6 = A0O;
            if (strArr6[3].length() == strArr6[0].length()) {
                String[] strArr7 = A0O;
                strArr7[5] = "yetXNvPdXumqVjXfCpilY";
                strArr7[5] = "yetXNvPdXumqVjXfCpilY";
                this.A0E = enumC1846Pb3;
                return;
            }
        } else {
            if (i != 4) {
                return;
            }
            if (z) {
                setVideoState(EnumC1846Pb.A06);
            }
            PO po = this.A0C;
            if (A0O[5].length() == 21) {
                String[] strArr8 = A0O;
                strArr8[5] = "KLjUXng8f5n9djrrPXv2F";
                strArr8[5] = "KLjUXng8f5n9djrrPXv2F";
                if (po != null) {
                    po.A0J(false);
                    if (!z) {
                        this.A0C.A0B();
                    }
                }
                this.A0M = false;
                return;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.PN
    public final void ABf(int i, int i2, int i3, float f2) {
        A09(i, i2);
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final void ABq(boolean z, int i) {
        this.A0A.A0A().A2v(i);
        this.A0E = EnumC1846Pb.A05;
        this.A0L = z;
        PO po = this.A0C;
        if (po != null) {
            po.A0J(false);
        } else {
            setVideoState(EnumC1846Pb.A04);
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final void ADX(int i) {
        this.A0A.A0A().A8q(i);
        setVideoState(EnumC1846Pb.A09);
        ADh(5);
        this.A05 = 0L;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final void ADb(EnumC1834Op enumC1834Op, int i) {
        this.A0A.A0A().A36(i);
        this.A0L = false;
        this.A0E = EnumC1846Pb.A0A;
        this.A0B = enumC1834Op;
        if (this.A0C == null) {
            setup(this.A06);
        } else {
            if (this.A0D != EnumC1846Pb.A07 && this.A0D != EnumC1846Pb.A05 && this.A0D != EnumC1846Pb.A06) {
                return;
            }
            this.A0C.A0J(true);
            setVideoState(EnumC1846Pb.A0A);
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final void ADh(int i) {
        this.A0A.A0A().A38(i);
        this.A0E = EnumC1846Pb.A04;
        PO po = this.A0C;
        if (po != null) {
            po.A0C();
            this.A0C.A0A();
            this.A0C = null;
        }
        setVideoState(EnumC1846Pb.A04);
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final void destroy() {
        A06();
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public int getCurrentPosition() {
        PO po = this.A0C;
        if (po != null) {
            return (int) po.A07();
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public int getDuration() {
        PO po = this.A0C;
        if (po == null) {
            return 0;
        }
        return (int) po.A08();
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public long getInitialBufferTime() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public EnumC1834Op getStartReason() {
        return this.A0B;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public EnumC1846Pb getState() {
        return this.A0D;
    }

    public EnumC1846Pb getTargetState() {
        return this.A0E;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public int getVideoHeight() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public int getVideoWidth() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public float getVolume() {
        return this.A00;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = this.A07;
        if (surface != null) {
            surface.release();
        }
        this.A07 = new Surface(surfaceTexture);
        PO po = this.A0C;
        if (po == null) {
            return;
        }
        po.A0G(this.A07);
        if (this.A0D == EnumC1846Pb.A05 && !this.A0L) {
            ADb(this.A0B, 7);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Surface surface = this.A07;
        if (surface != null) {
            surface.release();
            this.A07 = null;
            PO po = this.A0C;
            if (po != null) {
                po.A0G(null);
            }
        }
        if (this.A0D == EnumC1846Pb.A05) {
            return true;
        }
        if (A0O[5].length() != 21) {
            throw new RuntimeException();
        }
        String[] strArr = A0O;
        strArr[5] = "TScQzo9LVHiM3saFvXTgi";
        strArr[5] = "TScQzo9LVHiM3saFvXTgi";
        ABq(false, 5);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.A0C == null) {
            return;
        }
        MediaController mediaController = this.A09;
        if (mediaController != null && mediaController.isShowing()) {
            return;
        }
        if (!z) {
            if (this.A0D != EnumC1846Pb.A05) {
                A7L();
            }
        } else {
            if (this.A0D != EnumC1846Pb.A05 || this.A0L) {
                return;
            }
            ADb(this.A0B, 9);
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final void seekTo(int i) {
        if (this.A0C != null) {
            this.A01 = getCurrentPosition();
            this.A0C.A0E(i);
            return;
        }
        long j = i;
        String[] strArr = A0O;
        if (strArr[2].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0O;
        strArr2[5] = "kfjJwAtkK1UY2s6fcoM3d";
        strArr2[5] = "kfjJwAtkK1UY2s6fcoM3d";
        this.A05 = j;
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 24) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        boolean zIsDebugBuild = AdInternalSettings.isDebugBuild();
        if (A0O[5].length() != 21) {
            throw new RuntimeException();
        }
        String[] strArr = A0O;
        strArr[1] = "HF5JdwiOlRNKOfaOH";
        strArr[1] = "HF5JdwiOlRNKOfaOH";
        if (!zIsDebugBuild) {
            return;
        }
        Log.w(A0P, A03(0, 102, 85));
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public void setBackgroundPlaybackEnabled(boolean z) {
        this.A0H = z;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public void setControlsAnchorView(View view) {
        this.A08 = view;
        view.setOnTouchListener(new PV(this));
    }

    @Override // android.view.TextureView, android.view.View
    public void setForeground(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 24) {
            super.setForeground(drawable);
            return;
        }
        if (!AdInternalSettings.isDebugBuild()) {
            return;
        }
        String str = A0P;
        String[] strArr = A0O;
        if (strArr[3].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0O;
        strArr2[4] = "adR4uJi1AjYNmamYU7fKdN8LPQzpuqJY";
        strArr2[6] = "LCKmfGi2Ka9VnYBnqFwdGZK0MZJmec2m";
        Log.w(str, A03(102, 94, 79));
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public void setFullScreen(boolean z) {
        this.A0J = z;
        if (z && !this.A0I) {
            setOnTouchListener(new PU(this));
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public void setRequestedVolume(float f2) {
        this.A00 = f2;
        if (this.A0C != null && this.A0D != EnumC1846Pb.A08 && this.A0D != EnumC1846Pb.A04) {
            this.A0C.A0D(f2);
        }
    }

    public void setTestMode(boolean z) {
        this.A0K = z;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public void setVideoMPD(@Nullable String str) {
        this.A0G = str;
    }

    private void setVideoState(EnumC1846Pb enumC1846Pb) {
        if (enumC1846Pb != this.A0D) {
            if (BuildConfigApi.isDebug()) {
                String str = A03(196, 23, 51) + enumC1846Pb;
            }
            this.A0D = enumC1846Pb;
            if (this.A0D == EnumC1846Pb.A0A) {
                this.A0M = true;
            }
            InterfaceC1847Pc interfaceC1847Pc = this.A0F;
            if (interfaceC1847Pc != null) {
                interfaceC1847Pc.ABg(enumC1846Pb);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public void setVideoStateChangeListener(InterfaceC1847Pc interfaceC1847Pc) {
        this.A0F = interfaceC1847Pc;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public void setup(Uri uri) {
        this.A0A.A0A().A2y();
        if (this.A0C != null) {
            A06();
        }
        this.A06 = uri;
        setSurfaceTextureListener(this);
        A04();
    }
}
