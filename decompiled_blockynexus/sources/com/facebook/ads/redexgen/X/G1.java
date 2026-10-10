package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
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
public final class G1 extends TextureView implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnSeekCompleteListener, TextureView.SurfaceTextureListener, PZ {
    public static byte[] A0N;
    public static String[] A0O;
    public static final String A0P;
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;

    @Nullable
    public MediaPlayer A06;
    public Uri A07;
    public Surface A08;
    public View A09;

    @Nullable
    public MediaController A0A;
    public EnumC1834Op A0B;
    public EnumC1846Pb A0C;
    public EnumC1846Pb A0D;
    public InterfaceC1847Pc A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public final long A0K;
    public final MediaController.MediaPlayerControl A0L;
    public final C2026Wb A0M;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0N, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 114);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0N = new byte[]{89, 87, 91, 89, 30, 3, ci.m, 9, 26, 89, 91, 65, 91, 89, 57, 102, 105, 75, 68, 68, 69, 94, 10, 90, 88, 79, 90, 75, 88, 79, 10, 71, 79, 78, 67, 75, 10, 90, 70, 75, 83, 79, 88, 10, 93, 67, 94, 66, 10, 121, 95, 88, 76, 75, 73, 79, 126, 79, 82, 94, 95, 88, 79, ci.n, 10, 45, 1, 27, 2, 10, 0, 73, 26, 78, 28, 11, 26, 28, 7, 11, 24, 11, 78, 24, 7, 10, 11, 1, 78, 7, 0, 8, 1, 28, 3, ci.m, 26, 7, 1, 0, 93, 122, 114, 119, 126, 127, 59, 111, 116, 59, 116, 107, 126, 117, 59, 122, 104, 104, 126, 111, 104, 59, ci.m, 39, 39, 47, 36, 45, 104, 41, 36, Utf8.REPLACEMENT_BYTE, 41, 49, 59, 104, 60, 32, 58, 39, Utf8.REPLACEMENT_BYTE, 104, 41, 38, 104, 45, 48, 43, 45, 56, 60, 33, 39, 38, 104, Utf8.REPLACEMENT_BYTE, 33, 60, 32, 104, 59, 45, 60, 10, 41, 43, 35, 47, 58, 39, 61, 38, 44, 12, 58, 41, Utf8.REPLACEMENT_BYTE, 41, 42, 36, 45, 104, 39, 38, 104, 6, 39, 61, 47, 41, 60, 104, 41, 42, 39, 62, 45, 102, 104, 59, 39, 104, Utf8.REPLACEMENT_BYTE, 45, 104, 59, 33, 36, 45, 38, 60, 36, 49, 104, 33, 47, 38, 39, 58, 45, 104, 33, 60, 102, 50, 26, 26, 18, 25, ci.n, 85, 20, 25, 2, 20, 12, 6, 85, 1, 29, 7, 26, 2, 85, 20, 27, 85, ci.n, ci.k, 22, ci.n, 5, 1, 28, 26, 27, 85, 2, 28, 1, 29, 85, 6, ci.n, 1, 51, 26, 7, ci.n, 18, 7, 26, 0, 27, 17, 85, 26, 27, 85, 59, 26, 0, 18, 20, 1, 85, 20, 23, 26, 3, ci.n, 91, 85, 6, 26, 85, 2, ci.n, 85, 6, 28, 25, ci.n, 27, 1, 25, 12, 85, 28, 18, 27, 26, 7, ci.n, 85, 28, 1, 91, 31, 54, 37, 51, 32, 54, 37, 50, 119, 54, 52, 52, 50, 59, 50, 37, 54, 35, 62, 56, 57, 119, 34, 57, 54, 33, 54, 62, 59, 54, 53, 59, 50, 22, 45, 34, 33, 47, 38, 99, 55, 44, 99, 32, 47, 44, 48, 38, 53, 10, 7, 6, 12, 67, ci.n, 23, 2, 23, 6, 67, 0, 11, 2, ci.k, 4, 6, 7, 67, 23, 12, 67, 97, 115, 115, 101, 116, 83, 79, 66, 90, 70, 81, 115, 108, 97, 96, 106, 94, 7, 82, 77, 68, 81, 7, 5, 31, 5, 7};
    }

    public static void A05() {
        A0O = new String[]{"w6W1Pn4pGSy1veXw7fNic4Q20vJelJ2", "acNB2lhq8cVPZLtYghlcj8euurSBcqdx", "I2BPPFoGG3lXsTKKPy2FKKasdsM", "uMMu8699SI696vicAGdUyhB1Kjcnsg5D", "S7aPtd9QGtmzyQ9VrNW20IwmaDF5p1Ml", "zS648UlhjTBJXulz7NmFsyAIwaw2iCpI", "ZyXsHo9oibpczWLkt42IpHWLTZevRgPI", "euMEykkwaXnS"};
    }

    static {
        A05();
        A04();
        A0P = G1.class.getSimpleName();
    }

    public G1(C2026Wb c2026Wb) {
        super(c2026Wb);
        this.A0C = EnumC1846Pb.A04;
        this.A0D = EnumC1846Pb.A04;
        this.A0I = false;
        this.A03 = 0;
        this.A05 = 0;
        this.A04 = 0;
        this.A00 = 1.0f;
        this.A0H = false;
        this.A01 = 3;
        this.A0F = false;
        this.A0J = false;
        this.A02 = 0;
        this.A0G = false;
        this.A0B = EnumC1834Op.A04;
        this.A0L = new PW(this);
        this.A0M = c2026Wb;
    }

    public G1(C2026Wb c2026Wb, AttributeSet attributeSet) {
        super(c2026Wb, attributeSet);
        this.A0C = EnumC1846Pb.A04;
        this.A0D = EnumC1846Pb.A04;
        this.A0I = false;
        this.A03 = 0;
        this.A05 = 0;
        this.A04 = 0;
        this.A00 = 1.0f;
        this.A0H = false;
        this.A01 = 3;
        this.A0F = false;
        this.A0J = false;
        this.A02 = 0;
        this.A0G = false;
        this.A0B = EnumC1834Op.A04;
        this.A0L = new PW(this);
        this.A0M = c2026Wb;
    }

    public G1(C2026Wb c2026Wb, AttributeSet attributeSet, int i) {
        super(c2026Wb, attributeSet, i);
        this.A0C = EnumC1846Pb.A04;
        this.A0D = EnumC1846Pb.A04;
        this.A0I = false;
        this.A03 = 0;
        this.A05 = 0;
        this.A04 = 0;
        this.A00 = 1.0f;
        this.A0H = false;
        this.A01 = 3;
        this.A0F = false;
        this.A0J = false;
        this.A02 = 0;
        this.A0G = false;
        this.A0B = EnumC1834Op.A04;
        this.A0L = new PW(this);
        this.A0M = c2026Wb;
    }

    private boolean A06() {
        return (this.A0C == EnumC1846Pb.A08 || this.A0C == EnumC1846Pb.A07) ? false : true;
    }

    private boolean A07() {
        return this.A0C == EnumC1846Pb.A07 || this.A0C == EnumC1846Pb.A0A || this.A0C == EnumC1846Pb.A05 || this.A0C == EnumC1846Pb.A06;
    }

    private boolean A08() {
        return (this.A0C == EnumC1846Pb.A08 || this.A0C == EnumC1846Pb.A07) ? false : true;
    }

    private boolean A09() {
        MediaPlayer mediaPlayer = this.A06;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            mediaPlayer.reset();
            return true;
        } catch (IllegalStateException e2) {
            this.A0M.A04().A8H(A03(394, 6, 81), C8Y.A1u, new C8Z(e2));
            return false;
        }
    }

    private boolean A0A(@Nullable Surface surface) {
        MediaPlayer mediaPlayer = this.A06;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            mediaPlayer.setSurface(surface);
            return true;
        } catch (IllegalStateException e2) {
            this.A0M.A04().A8H(A03(394, 6, 81), C8Y.A1v, new C8Z(e2));
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final void A7L() {
        if (!this.A0F) {
            ABq(false, 3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    @SuppressLint({"NewApi"})
    public final boolean A7S() {
        if (this.A06 == null || Build.VERSION.SDK_INT < 16) {
            return false;
        }
        try {
            for (MediaPlayer.TrackInfo trackInfo : this.A06.getTrackInfo()) {
                int trackType = trackInfo.getTrackType();
                String[] strArr = A0O;
                if (strArr[3].charAt(29) != strArr[6].charAt(29)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0O;
                strArr2[5] = "iSqF26gJBktCMb0RObgKl91oEThpz7Z0";
                strArr2[5] = "iSqF26gJBktCMb0RObgKl91oEThpz7Z0";
                if (trackType == 2) {
                    return true;
                }
            }
            return false;
        } catch (RuntimeException e2) {
            Log.e(A0P, A03(65, 35, 28), e2);
            return true;
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final boolean A7T() {
        return this.A0J;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final boolean A7v() {
        return this.A0I;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final void ABq(boolean z, int i) {
        this.A0M.A0A().A2v(i);
        this.A0D = EnumC1846Pb.A05;
        if (this.A06 != null) {
            if (!A06()) {
                return;
            }
            this.A0I = z;
            this.A06.pause();
            if (this.A0C != EnumC1846Pb.A06) {
                setVideoState(EnumC1846Pb.A05);
                return;
            }
            return;
        }
        setVideoState(EnumC1846Pb.A04);
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final void ADX(int i) {
        this.A0M.A0A().A8q(i);
        setVideoState(EnumC1846Pb.A09);
        ADh(5);
        this.A03 = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    @Override // com.facebook.ads.redexgen.X.PZ
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void ADb(com.facebook.ads.redexgen.X.EnumC1834Op r6, int r7) throws java.lang.Throwable {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.Wb r0 = r5.A0M
            com.facebook.ads.redexgen.X.0R r0 = r0.A0A()
            r0.A36(r7)
            r3 = 0
            r5.A0I = r3
            com.facebook.ads.redexgen.X.Pb r0 = com.facebook.ads.redexgen.X.EnumC1846Pb.A0A
            r5.A0D = r0
            r5.A0B = r6
            com.facebook.ads.redexgen.X.Pb r1 = r5.A0C
            com.facebook.ads.redexgen.X.Pb r0 = com.facebook.ads.redexgen.X.EnumC1846Pb.A0A
            if (r1 == r0) goto L48
            com.facebook.ads.redexgen.X.Pb r1 = r5.A0C
            com.facebook.ads.redexgen.X.Pb r0 = com.facebook.ads.redexgen.X.EnumC1846Pb.A07
            if (r1 == r0) goto L48
            com.facebook.ads.redexgen.X.Pb r4 = r5.A0C
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.G1.A0O
            r0 = 7
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 4
            if (r1 == r0) goto La5
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.G1.A0O
            java.lang.String r1 = "NTKGPTGyq7PSuZ6pDxSrkOD3BAS3oRMw"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "NTKGPTGyq7PSuZ6pDxSrkOD3BAS3oRMw"
            r0 = 4
            r2[r0] = r1
            com.facebook.ads.redexgen.X.Pb r0 = com.facebook.ads.redexgen.X.EnumC1846Pb.A04
            if (r4 == r0) goto L48
            com.facebook.ads.redexgen.X.Pb r1 = r5.A0C
            com.facebook.ads.redexgen.X.Pb r0 = com.facebook.ads.redexgen.X.EnumC1846Pb.A05
            if (r1 == r0) goto L48
            com.facebook.ads.redexgen.X.Pb r1 = r5.A0C
            com.facebook.ads.redexgen.X.Pb r0 = com.facebook.ads.redexgen.X.EnumC1846Pb.A06
            if (r1 != r0) goto L51
        L48:
            android.media.MediaPlayer r1 = r5.A06
            if (r1 != 0) goto L89
            android.net.Uri r0 = r5.A07
            r5.setup(r0)
        L51:
            boolean r0 = r5.isAvailable()
            if (r0 == 0) goto L78
            android.graphics.SurfaceTexture r4 = r5.getSurfaceTexture()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.G1.A0O
            r0 = 1
            r1 = r1[r0]
            r0 = 7
            char r1 = r1.charAt(r0)
            r0 = 113(0x71, float:1.58E-43)
            if (r1 == r0) goto L79
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.G1.A0O
            java.lang.String r1 = "Wn6W9Nu3dNfA4pP49CdphRQGwehyl3Rd"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "Wn6W9Nu3dNfA4pP49CdphRQGwehyl3Rd"
            r0 = 4
            r2[r0] = r1
            r5.onSurfaceTextureAvailable(r4, r3, r3)
        L78:
            return
        L79:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.G1.A0O
            java.lang.String r1 = "pXleF17jKjib"
            r0 = 7
            r2[r0] = r1
            java.lang.String r1 = "pXleF17jKjib"
            r0 = 7
            r2[r0] = r1
            r5.onSurfaceTextureAvailable(r4, r3, r3)
            goto L78
        L89:
            int r0 = r5.A03
            if (r0 <= 0) goto L90
            r1.seekTo(r0)
        L90:
            android.media.MediaPlayer r0 = r5.A06
            r0.start()
            com.facebook.ads.redexgen.X.Pb r1 = r5.A0C
            com.facebook.ads.redexgen.X.Pb r0 = com.facebook.ads.redexgen.X.EnumC1846Pb.A07
            if (r1 != r0) goto L9f
            boolean r0 = r5.A0J
            if (r0 == 0) goto L51
        L9f:
            com.facebook.ads.redexgen.X.Pb r0 = com.facebook.ads.redexgen.X.EnumC1846Pb.A0A
            r5.setVideoState(r0)
            goto L51
        La5:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.G1.ADb(com.facebook.ads.redexgen.X.Op, int):void");
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final void ADh(int i) {
        this.A0M.A0A().A38(i);
        this.A0D = EnumC1846Pb.A04;
        MediaPlayer mediaPlayer = this.A06;
        if (mediaPlayer != null) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            if (currentPosition > 0) {
                this.A03 = currentPosition;
            }
            this.A06.stop();
            if (A0O[4].charAt(14) == '3') {
                throw new RuntimeException();
            }
            String[] strArr = A0O;
            strArr[5] = "KulxFUFqA4xnUTvaQLfyg7cstmOjzycv";
            strArr[5] = "KulxFUFqA4xnUTvaQLfyg7cstmOjzycv";
            A09();
            this.A06.release();
            this.A06 = null;
            MediaController mediaController = this.A0A;
            if (mediaController != null) {
                mediaController.hide();
                this.A0A.setEnabled(false);
            }
        }
        setVideoState(EnumC1846Pb.A04);
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final void destroy() {
        if (this.A06 != null) {
            A0A(null);
            this.A06.setOnBufferingUpdateListener(null);
            this.A06.setOnCompletionListener(null);
            this.A06.setOnErrorListener(null);
            this.A06.setOnInfoListener(null);
            this.A06.setOnPreparedListener(null);
            this.A06.setOnVideoSizeChangedListener(null);
            this.A06.setOnSeekCompleteListener(null);
            A09();
            this.A06 = null;
            setVideoState(EnumC1846Pb.A04);
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public int getCurrentPosition() {
        if (this.A06 == null || !A07()) {
            return 0;
        }
        return this.A06.getCurrentPosition();
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public int getDuration() {
        if (this.A06 == null) {
            return 0;
        }
        boolean zA07 = A07();
        String[] strArr = A0O;
        if (strArr[3].charAt(29) != strArr[6].charAt(29)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0O;
        strArr2[1] = "tqb6wmVqQGZxPylUtz2fkCIx7Bf2WilJ";
        strArr2[1] = "tqb6wmVqQGZxPylUtz2fkCIx7Bf2WilJ";
        if (!zA07) {
            return 0;
        }
        return this.A06.getDuration();
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public long getInitialBufferTime() {
        return this.A0K;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public EnumC1834Op getStartReason() {
        return this.A0B;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public EnumC1846Pb getState() {
        return this.A0C;
    }

    public EnumC1846Pb getTargetState() {
        return this.A0D;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public int getVideoHeight() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public int getVideoWidth() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public float getVolume() {
        return this.A00;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isHardwareAccelerated()) {
            setVideoState(EnumC1846Pb.A03);
            this.A0M.A0A().A2z(5);
            ADh(8);
            this.A0M.A04().A8H(A03(400, 5, 119), C8Y.A2C, new C8Z(A03(318, 33, 37)));
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2 = this.A06;
        if (mediaPlayer2 != null) {
            mediaPlayer2.pause();
        }
        setVideoState(EnumC1846Pb.A06);
        seekTo(0);
        this.A03 = 0;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) throws Throwable {
        this.A0M.A0A().A8p(A03(405, 11, 87) + i + A03(0, 14, 9) + i2 + A03(14, 2, 105));
        if (this.A01 > 0 && getState() == EnumC1846Pb.A0A) {
            this.A01--;
            ADh(6);
            ADb(this.A0B, 10);
        } else {
            setVideoState(EnumC1846Pb.A03);
            this.A0M.A0A().A2z(1);
            ADh(7);
        }
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 3) {
            this.A0J = true;
            if (this.A0D == EnumC1846Pb.A0A) {
                setVideoState(EnumC1846Pb.A0A);
            }
            return true;
        }
        if (i != 701) {
            if (i == 702 && A08()) {
                setVideoState(EnumC1846Pb.A0A);
            }
        } else {
            EnumC1846Pb enumC1846Pb = EnumC1846Pb.A02;
            if (A0O[4].charAt(14) != '3') {
                String[] strArr = A0O;
                strArr[3] = "iL0L5EQxu2M5tvy2sZDjl5tOkB9wsg4Q";
                strArr[6] = "qEr4cYtmjtQdjlZthk5xBRgssZbq5gW6";
                setVideoState(enumC1846Pb);
            } else {
                setVideoState(enumC1846Pb);
            }
        }
        String[] strArr2 = A0O;
        if (strArr2[3].charAt(29) != strArr2[6].charAt(29)) {
            throw new RuntimeException();
        }
        String[] strArr3 = A0O;
        strArr3[3] = "BctcOQJYgBcKf8RdBMRoW9O8jkER1gO3";
        strArr3[6] = "NFF5b4NOHp1wMQpQtAU8ibXMpYWuxgZg";
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) throws Throwable {
        setVideoState(EnumC1846Pb.A07);
        if (this.A0H && !this.A0G) {
            Activity activityA09 = this.A0M.A09();
            if (activityA09 != null) {
                this.A0A = new MediaController(activityA09);
                MediaController mediaController = this.A0A;
                View view = this.A09;
                if (view == null) {
                    view = this;
                }
                mediaController.setAnchorView(view);
                MediaController mediaController2 = this.A0A;
                MediaController.MediaPlayerControl mediaPlayerControl = this.A0L;
                if (A0O[1].charAt(7) != 'q') {
                    throw new RuntimeException();
                }
                String[] strArr = A0O;
                strArr[3] = "fPjFRSSzuUrY85KdwEQXHAUI7gq3zgJX";
                strArr[6] = "QlnNj2Zi0n3XZkktRetea07zoE6PUgNL";
                mediaController2.setMediaPlayer(mediaPlayerControl);
                this.A0A.setEnabled(true);
            } else {
                this.A0A = null;
            }
        }
        setRequestedVolume(this.A00);
        this.A05 = mediaPlayer.getVideoWidth();
        this.A04 = mediaPlayer.getVideoHeight();
        int i = this.A03;
        if (i > 0) {
            if (i >= this.A06.getDuration()) {
                this.A03 = 0;
            }
            this.A06.seekTo(this.A03);
            this.A03 = 0;
        }
        EnumC1846Pb enumC1846Pb = this.A0D;
        EnumC1846Pb enumC1846Pb2 = EnumC1846Pb.A0A;
        String[] strArr2 = A0O;
        if (strArr2[2].length() == strArr2[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr3 = A0O;
        strArr3[3] = "i4HMjCzdRtS7Zf5jyUfqsJgJBFC3Hgk3";
        strArr3[6] = "nPyigXhxANl12gOwrMulZJ84NGYQcgH1";
        if (enumC1846Pb == enumC1846Pb2) {
            ADb(this.A0B, 8);
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        InterfaceC1847Pc interfaceC1847Pc = this.A0E;
        if (interfaceC1847Pc == null) {
            return;
        }
        interfaceC1847Pc.ABC(this.A02, this.A03);
        this.A03 = 0;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.A08 == null) {
            this.A08 = new Surface(surfaceTexture);
        }
        if (!A0A(this.A08)) {
            setVideoState(EnumC1846Pb.A03);
            this.A0M.A0A().A2z(4);
            destroy();
        } else if (this.A0C == EnumC1846Pb.A05 && !this.A0I) {
            ADb(this.A0B, 7);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        A0A(null);
        Surface surface = this.A08;
        if (surface != null) {
            surface.release();
            this.A08 = null;
        }
        if (this.A0C != EnumC1846Pb.A05) {
            ABq(false, 5);
        }
        if (A0O[1].charAt(7) != 'q') {
            throw new RuntimeException();
        }
        String[] strArr = A0O;
        strArr[5] = "wJEag4Up5dB02EoPbWjrYUJlPYnnpJPt";
        strArr[5] = "wJEag4Up5dB02EoPbWjrYUJlPYnnpJPt";
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.A05 = mediaPlayer.getVideoWidth();
        this.A04 = mediaPlayer.getVideoHeight();
        if (this.A05 != 0 && this.A04 != 0) {
            requestLayout();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) throws Throwable {
        super.onWindowFocusChanged(z);
        if (this.A06 == null) {
            return;
        }
        MediaController mediaController = this.A0A;
        if (mediaController != null && mediaController.isShowing()) {
            return;
        }
        if (!z) {
            if (this.A0C != EnumC1846Pb.A05) {
                A7L();
            }
        } else {
            if (this.A0C != EnumC1846Pb.A05 || this.A0I) {
                return;
            }
            ADb(this.A0B, 9);
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final void seekTo(int i) {
        if (this.A06 != null && A07()) {
            if (i < getDuration() && i > 0) {
                this.A02 = getCurrentPosition();
                this.A03 = i;
                this.A06.seekTo(i);
                return;
            }
            return;
        }
        this.A03 = i;
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 24) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (!AdInternalSettings.isDebugBuild()) {
                return;
            }
            Log.w(A0P, A03(122, 102, 58));
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public void setBackgroundPlaybackEnabled(boolean z) {
        this.A0F = z;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public void setControlsAnchorView(View view) {
        this.A09 = view;
        view.setOnTouchListener(new PY(this));
    }

    @Override // android.view.TextureView, android.view.View
    public void setForeground(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 24) {
            super.setForeground(drawable);
        } else {
            if (!AdInternalSettings.isDebugBuild()) {
                return;
            }
            Log.w(A0P, A03(224, 94, 7));
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public void setFullScreen(boolean z) {
        this.A0H = z;
        if (this.A0H && !this.A0G) {
            setOnTouchListener(new PX(this));
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public void setRequestedVolume(float f2) {
        this.A00 = f2;
        if (this.A06 != null && this.A0C != EnumC1846Pb.A08 && this.A0C != EnumC1846Pb.A04) {
            this.A06.setVolume(f2, f2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public void setVideoMPD(@Nullable String str) {
    }

    private void setVideoState(EnumC1846Pb enumC1846Pb) {
        if (enumC1846Pb != this.A0C) {
            if (BuildConfigApi.isDebug()) {
                String str = A03(366, 23, 17) + enumC1846Pb;
            }
            this.A0C = enumC1846Pb;
            InterfaceC1847Pc interfaceC1847Pc = this.A0E;
            if (interfaceC1847Pc != null) {
                interfaceC1847Pc.ABg(enumC1846Pb);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public void setVideoStateChangeListener(InterfaceC1847Pc interfaceC1847Pc) {
        this.A0E = interfaceC1847Pc;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b7  */
    @Override // com.facebook.ads.redexgen.X.PZ
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setup(android.net.Uri r16) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.G1.setup(android.net.Uri):void");
    }
}
