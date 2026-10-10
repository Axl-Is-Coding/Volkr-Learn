package com.facebook.ads.redexgen.X;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SurfaceHolderCallbackC2051Xa implements InterfaceC1689Iu, B1, G9, InterfaceC1564Dr, SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
    public static String[] A01;
    public final /* synthetic */ C8 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"tENgV7sVRmCggStQb7ahqyncu3McMlqx", "EBCLDe86SI67l2WgLGk", "Xc2z6PWfFp", "ZjGJvfPpi7mMWyj8ThC73X2hXIQsvVeY", "O", "wm4K2NOZzdg8zteNHm", "uxR1U8t68FFaIgGW", "ZP1sAESULwb937k6ya35I8qp57tsUFN9"};
    }

    public SurfaceHolderCallbackC2051Xa(C8 c8) {
        this.A00 = c8;
    }

    @Override // com.facebook.ads.redexgen.X.B1
    public final void A9B(String str, long j, long j2) {
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            ((B1) it.next()).A9B(str, j, j2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.B1
    public final void A9C(BU bu) {
        Iterator it = this.A00.A0I.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String[] strArr = A01;
            if (strArr[0].charAt(30) == strArr[7].charAt(30)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "r";
            strArr2[1] = "Pw7sEp82k0vieihjeRw";
            if (!zHasNext) {
                C8 c8 = this.A00;
                String[] strArr3 = A01;
                if (strArr3[0].charAt(30) == strArr3[7].charAt(30)) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A01;
                strArr4[5] = "AJXnTxM8Cjr";
                strArr4[5] = "AJXnTxM8Cjr";
                c8.A06 = null;
                this.A00.A09 = null;
                this.A00.A01 = 0;
                return;
            }
            B1 b1 = (B1) it.next();
            if (A01[3].charAt(20) != '3') {
                throw new RuntimeException();
            }
            String[] strArr5 = A01;
            strArr5[5] = "rZ";
            strArr5[5] = "rZ";
            b1.A9C(bu);
        }
    }

    @Override // com.facebook.ads.redexgen.X.B1
    public final void A9D(BU bu) {
        this.A00.A09 = bu;
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            ((B1) it.next()).A9D(bu);
        }
    }

    @Override // com.facebook.ads.redexgen.X.B1
    public final void A9E(Format format) {
        this.A00.A06 = format;
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            ((B1) it.next()).A9E(format);
        }
    }

    @Override // com.facebook.ads.redexgen.X.B1
    public final void A9F(int i) {
        this.A00.A01 = i;
        for (B1 b1 : this.A00.A0I) {
            if (A01[2].length() == 11) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "0C";
            strArr[2] = "0C";
            b1.A9F(i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.B1
    public final void A9G(int i, long j, long j2) {
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            ((B1) it.next()).A9G(i, j, j2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.G9
    public final void A9a(List<G5> list) {
        this.A00.A0C = list;
        Iterator it = this.A00.A0K.iterator();
        while (it.hasNext()) {
            ((G9) it.next()).A9a(list);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1689Iu
    public final void A9l(int i, long j) {
        Iterator it = this.A00.A0L.iterator();
        while (it.hasNext()) {
            ((InterfaceC1689Iu) it.next()).A9l(i, j);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1564Dr
    public final void AAX(Metadata metadata) {
        Iterator it = this.A00.A0J.iterator();
        while (it.hasNext()) {
            ((InterfaceC1564Dr) it.next()).AAX(metadata);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1689Iu
    public final void AB3(Surface surface) {
        if (this.A00.A03 == surface) {
            Iterator it = this.A00.A0M.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        Iterator it2 = this.A00.A0L.iterator();
        while (it2.hasNext()) {
            ((InterfaceC1689Iu) it2.next()).AB3(surface);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1689Iu
    public final void ABY(String str, long j, long j2) {
        Iterator it = this.A00.A0L.iterator();
        while (it.hasNext()) {
            ((InterfaceC1689Iu) it.next()).ABY(str, j, j2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1689Iu
    public final void ABZ(BU bu) {
        Iterator it = this.A00.A0L.iterator();
        while (it.hasNext()) {
            ((InterfaceC1689Iu) it.next()).ABZ(bu);
        }
        this.A00.A07 = null;
        this.A00.A0A = null;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1689Iu
    public final void ABa(BU bu) {
        this.A00.A0A = bu;
        for (InterfaceC1689Iu interfaceC1689Iu : this.A00.A0L) {
            if (A01[3].charAt(20) != '3') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[5] = "6iGRC7";
            strArr[5] = "6iGRC7";
            interfaceC1689Iu.ABa(bu);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1689Iu
    public final void ABc(Format format) {
        this.A00.A07 = format;
        for (InterfaceC1689Iu interfaceC1689Iu : this.A00.A0L) {
            String[] strArr = A01;
            if (strArr[0].charAt(30) == strArr[7].charAt(30)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[5] = "M1lNqMtLlEQhDRLPZV8vitTN6y5pnm";
            strArr2[5] = "M1lNqMtLlEQhDRLPZV8vitTN6y5pnm";
            interfaceC1689Iu.ABc(format);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1689Iu
    public final void ABf(int i, int i2, int i3, float f2) {
        Iterator it = this.A00.A0M.iterator();
        while (it.hasNext()) {
            ((InterfaceC1680Il) it.next()).ABf(i, i2, i3, f2);
        }
        Iterator it2 = this.A00.A0L.iterator();
        while (it2.hasNext()) {
            ((InterfaceC1689Iu) it2.next()).ABf(i, i2, i3, f2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.A00.A0H(new Surface(surfaceTexture), true);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.A00.A0H(null, true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.A00.A0H(surfaceHolder.getSurface(), false);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.A00.A0H(null, false);
    }
}
