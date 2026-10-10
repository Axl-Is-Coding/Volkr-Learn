package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2059Xi implements B6 {
    public static boolean A0p;
    public static boolean A0q;
    public static byte[] A0r;
    public static String[] A0s;
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public long A0E;
    public long A0F;
    public long A0G;
    public long A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public AudioTrack A0M;

    @Nullable
    public AudioTrack A0N;

    @Nullable
    public AF A0O;
    public AF A0P;
    public C1495Al A0Q;

    @Nullable
    public B4 A0R;

    @Nullable
    public ByteBuffer A0S;

    @Nullable
    public ByteBuffer A0T;

    @Nullable
    public ByteBuffer A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public byte[] A0c;
    public InterfaceC1502At[] A0d;
    public ByteBuffer[] A0e;
    public final ConditionVariable A0f;

    @Nullable
    public final C1496Am A0g;
    public final BC A0h;
    public final C2056Xf A0i;
    public final BF A0j;
    public final C2066Xp A0k;
    public final ArrayDeque<BH> A0l;
    public final boolean A0m;
    public final InterfaceC1502At[] A0n;
    public final InterfaceC1502At[] A0o;

    public static String A0I(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0r, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0O() {
        A0r = new byte[]{68, 72, ci.m, 7, 28, 72, 94, 106, 123, 118, 112, 75, 109, 126, 124, 116, 78, 99, 121, 105, 101, 100, 126, 99, 100, 127, 99, 126, 115, 42, 110, 111, 126, 111, 105, 126, 111, 110, 42, 81, 111, 114, 122, 111, 105, 126, 111, 110, 42, ci.l, 22, 9, 4, 9, 1, 8, Utf8.REPLACEMENT_BYTE, 41, Utf8.REPLACEMENT_BYTE, 46, 46, 51, 52, 61, 122, 41, 46, 59, 54, 54, Utf8.REPLACEMENT_BYTE, 62, 122, 59, 47, 62, 51, 53, 122, 46, 40, 59, 57, 49, 102, 93, 86, 75, 67, 86, 80, 71, 86, 87, 19, 82, 70, 87, 90, 92, 19, 86, 93, 80, 92, 87, 90, 93, 84, 9, 19, 96, 91, 70, 64, 69, 69, 90, 71, 65, 80, 81, 21, 86, 93, 84, 91, 91, 80, 89, 21, 86, 90, 64, 91, 65, ci.m, 21, 101, 10, 3, 31, 24, 9, 30, 59, 40, 58, 40};
    }

    public static void A0P() {
        A0s = new String[]{"5Nyv0guRYVcKSAuezGPcUxg9vJAOBGI4", "vvUbbcGamjazB6O7sNKlV2Due1EGN4h1", "bCdq7Y65nqLa7O1PpyZ9UmfFfim1tIKH", "XSMaSGyqY735xp0uf5mX1ioiT5AfU73", "LbuXdG3g6wlkS0wgubrQcd1EFcxL1vaW", "BfdFnDj7fdcaZnnCNK5XWBslzsEwyMTC", "82TROEAjyC6M053XP3PwF3IgkAnZSWb8", "TH4S9e3rxD8emXavfeipeAwkF3kWLOvQ"};
    }

    static {
        A0P();
        A0O();
        A0p = false;
        A0q = false;
    }

    public C2059Xi(@Nullable C1496Am c1496Am, BF bf, boolean z) {
        this.A0g = c1496Am;
        this.A0j = (BF) C1662Hr.A01(bf);
        this.A0m = z;
        this.A0f = new ConditionVariable(true);
        this.A0h = new BC(new C2058Xh(this, null));
        this.A0i = new C2056Xf();
        this.A0k = new C2066Xp();
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new C2062Xl(), this.A0i, this.A0k);
        Collections.addAll(arrayList, bf.A5X());
        this.A0o = (InterfaceC1502At[]) arrayList.toArray(new InterfaceC1502At[arrayList.size()]);
        this.A0n = new InterfaceC1502At[]{new C2060Xj()};
        this.A00 = 1.0f;
        this.A0D = 0;
        this.A0Q = C1495Al.A04;
        this.A01 = 0;
        this.A0P = AF.A04;
        this.A04 = -1;
        this.A0d = new InterfaceC1502At[0];
        this.A0e = new ByteBuffer[0];
        this.A0l = new ArrayDeque<>();
    }

    public C2059Xi(@Nullable C1496Am c1496Am, InterfaceC1502At[] interfaceC1502AtArr) {
        this(c1496Am, interfaceC1502AtArr, false);
    }

    public C2059Xi(@Nullable C1496Am c1496Am, InterfaceC1502At[] interfaceC1502AtArr, boolean z) {
        this(c1496Am, new C2057Xg(interfaceC1502AtArr), z);
    }

    public static int A00(int i, ByteBuffer byteBuffer) {
        if (i == 7 || i == 8) {
            return BJ.A00(byteBuffer);
        }
        if (i == 5) {
            return C1492Ai.A00();
        }
        if (i == 6) {
            return C1492Ai.A03(byteBuffer);
        }
        if (i == 14) {
            int iA02 = C1492Ai.A02(byteBuffer);
            if (iA02 == -1) {
                return 0;
            }
            int iA04 = C1492Ai.A04(byteBuffer, iA02);
            String[] strArr = A0s;
            if (strArr[5].charAt(2) != strArr[2].charAt(2)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[3] = "Dqt88CMr8vwwAc3fZIJcRVt2XyhD8Cl";
            strArr2[3] = "Dqt88CMr8vwwAc3fZIJcRVt2XyhD8Cl";
            return iA04 * 16;
        }
        throw new IllegalStateException(A0I(84, 27, 120) + i);
    }

    @TargetApi(21)
    public static int A01(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    @TargetApi(21)
    private int A02(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j) {
        if (this.A0S == null) {
            this.A0S = ByteBuffer.allocate(16);
            this.A0S.order(ByteOrder.BIG_ENDIAN);
            this.A0S.putInt(1431633921);
        }
        if (this.A03 == 0) {
            this.A0S.putInt(4, i);
            this.A0S.putLong(8, 1000 * j);
            this.A0S.position(0);
            this.A03 = i;
        }
        int iRemaining = this.A0S.remaining();
        if (iRemaining > 0) {
            int iWrite = audioTrack.write(this.A0S, iRemaining, 1);
            if (iWrite < 0) {
                this.A03 = 0;
                return iWrite;
            }
            if (iWrite < iRemaining) {
                return 0;
            }
        }
        int iA01 = A01(audioTrack, byteBuffer, i);
        String[] strArr = A0s;
        if (strArr[4].charAt(9) == strArr[1].charAt(9)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0s;
        strArr2[5] = "EGdI4VK4aN1uiBzzsuaeFo7lQ03tB7Gh";
        strArr2[2] = "vodoofn0TiYpLi76FRuwTlDh379TFVaK";
        if (iA01 < 0) {
            this.A03 = 0;
            return iA01;
        }
        this.A03 -= iA01;
        return iA01;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A03() {
        return this.A0X ? this.A0J / ((long) this.A0B) : this.A0I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A04() {
        return this.A0X ? this.A0L / ((long) this.A09) : this.A0K;
    }

    private long A05(long j) {
        return A08(this.A0j.A76()) + j;
    }

    private long A06(long j) {
        BH bhRemove = null;
        while (!this.A0l.isEmpty() && j >= this.A0l.getFirst().A01) {
            bhRemove = this.A0l.remove();
        }
        if (bhRemove != null) {
            this.A0P = bhRemove.A02;
            this.A0G = bhRemove.A01;
            this.A0F = bhRemove.A00 - this.A0H;
        }
        if (this.A0P.A01 == 1.0f) {
            return (this.A0F + j) - this.A0G;
        }
        if (this.A0l.isEmpty()) {
            return this.A0F + this.A0j.A6e(j - this.A0G);
        }
        return this.A0F + IW.A0C(j - this.A0G, this.A0P.A01);
    }

    private long A07(long j) {
        return (((long) this.A0A) * j) / 1000000;
    }

    private long A08(long j) {
        return (1000000 * j) / ((long) this.A0A);
    }

    private long A09(long j) {
        return (1000000 * j) / ((long) this.A06);
    }

    @TargetApi(21)
    private AudioTrack A0D() {
        AudioAttributes audioAttributesA00;
        if (this.A0b) {
            audioAttributesA00 = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            audioAttributesA00 = this.A0Q.A00();
        }
        AudioFormat audioFormatBuild = new AudioFormat.Builder().setChannelMask(this.A07).setEncoding(this.A08).setSampleRate(this.A0A).build();
        int i = this.A01;
        if (i == 0) {
            i = 0;
        }
        return new AudioTrack(audioAttributesA00, audioFormatBuild, this.A02, 1, i);
    }

    private AudioTrack A0E() throws B3 {
        AudioTrack audioTrack;
        if (IW.A02 >= 21) {
            audioTrack = A0D();
        } else {
            int iA03 = IW.A03(this.A0Q.A03);
            int i = this.A01;
            String[] strArr = A0s;
            String str = strArr[4];
            String str2 = strArr[1];
            int state = str.charAt(9);
            if (state == str2.charAt(9)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[4] = "uEqtixTroQ47jvhgXsjygxp317gkhCVZ";
            strArr2[1] = "MeWTB72qJhBmjPGmSmxXQDSK14yx53vJ";
            if (i == 0) {
                audioTrack = new AudioTrack(iA03, this.A0A, this.A07, this.A08, this.A02, 1);
            } else {
                audioTrack = new AudioTrack(iA03, this.A0A, this.A07, this.A08, this.A02, 1, i);
            }
        }
        int state2 = audioTrack.getState();
        if (state2 == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (Exception unused) {
        }
        throw new B3(state2, this.A0A, this.A07, this.A02);
    }

    private AudioTrack A0F(int i) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i);
    }

    private void A0J() {
        int i = 0;
        while (true) {
            InterfaceC1502At[] interfaceC1502AtArr = this.A0d;
            if (i < interfaceC1502AtArr.length) {
                InterfaceC1502At interfaceC1502At = interfaceC1502AtArr[i];
                interfaceC1502At.flush();
                this.A0e[i] = interfaceC1502At.A6h();
                i++;
            } else {
                return;
            }
        }
    }

    private void A0K() throws B3 {
        AF afA3R;
        this.A0f.block();
        this.A0M = A0E();
        int audioSessionId = this.A0M.getAudioSessionId();
        if (A0p && IW.A02 < 21) {
            AudioTrack audioTrack = this.A0N;
            if (audioTrack != null) {
                int audioSessionId2 = audioTrack.getAudioSessionId();
                String[] strArr = A0s;
                if (strArr[4].charAt(9) == strArr[1].charAt(9)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0s;
                strArr2[7] = "BXErtyYgJXamt9yde7CeLqS26Q9j6Dt3";
                strArr2[7] = "BXErtyYgJXamt9yde7CeLqS26Q9j6Dt3";
                if (audioSessionId != audioSessionId2) {
                    A0L();
                }
            }
            if (this.A0N == null) {
                this.A0N = A0F(audioSessionId);
            }
        }
        if (this.A01 != audioSessionId) {
            this.A01 = audioSessionId;
            B4 b4 = this.A0R;
            if (b4 != null) {
                b4.A9F(audioSessionId);
            }
        }
        if (this.A0V) {
            afA3R = this.A0j.A3R(this.A0P);
        } else {
            afA3R = AF.A04;
        }
        this.A0P = afA3R;
        A0N();
        this.A0h.A0H(this.A0M, this.A08, this.A09, this.A02);
        A0M();
    }

    private void A0L() {
        if (this.A0N == null) {
            return;
        }
        AudioTrack audioTrack = this.A0N;
        this.A0N = null;
        new BE(this, audioTrack).start();
    }

    private void A0M() {
        if (!A0V()) {
            return;
        }
        if (IW.A02 >= 21) {
            AudioTrack audioTrack = this.A0M;
            float f2 = this.A00;
            if (A0s[3].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0s;
            strArr[7] = "8NL9PZoDB9Ch1WQJQaXfXaVAIVHPoweZ";
            strArr[7] = "8NL9PZoDB9Ch1WQJQaXfXaVAIVHPoweZ";
            A0R(audioTrack, f2);
            return;
        }
        A0S(this.A0M, this.A00);
    }

    private void A0N() {
        ArrayList arrayList = new ArrayList();
        for (InterfaceC1502At interfaceC1502At : A0W()) {
            if (interfaceC1502At.A7j()) {
                arrayList.add(interfaceC1502At);
            } else {
                interfaceC1502At.flush();
            }
        }
        int size = arrayList.size();
        InterfaceC1502At[] interfaceC1502AtArr = new InterfaceC1502At[size];
        if (A0s[3].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr = A0s;
        strArr[5] = "YRdEguSYP1wOqJMzR8T0sEbN9ru3F1GF";
        strArr[2] = "jCd7Ib2fALhdhS4xedSLoMHgXMVbMQ2Z";
        this.A0d = (InterfaceC1502At[]) arrayList.toArray(interfaceC1502AtArr);
        this.A0e = new ByteBuffer[size];
        A0J();
    }

    private void A0Q(long j) throws B5 {
        ByteBuffer input;
        int length = this.A0d.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                input = this.A0e[i - 1];
            } else {
                input = this.A0T;
                if (input == null) {
                    input = InterfaceC1502At.A00;
                }
            }
            if (i == length) {
                A0T(input, j);
            } else {
                InterfaceC1502At audioProcessor = this.A0d[i];
                audioProcessor.ACE(input);
                ByteBuffer byteBufferA6h = audioProcessor.A6h();
                this.A0e[i] = byteBufferA6h;
                if (byteBufferA6h.hasRemaining()) {
                    i++;
                }
            }
            if (input.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    @TargetApi(21)
    public static void A0R(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    public static void A0S(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0T(java.nio.ByteBuffer r12, long r13) throws com.facebook.ads.redexgen.X.B5 {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2059Xi.A0T(java.nio.ByteBuffer, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0U() throws com.facebook.ads.redexgen.X.B5 {
        /*
            r9 = this;
            r5 = 0
            int r0 = r9.A04
            r6 = -1
            r8 = 0
            if (r0 != r6) goto Lf
            boolean r0 = r9.A0Z
            if (r0 == 0) goto L54
            r0 = 0
        Lc:
            r9.A04 = r0
            r5 = 1
        Lf:
            int r4 = r9.A04
            com.facebook.ads.redexgen.X.At[] r1 = r9.A0d
            int r0 = r1.length
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 1
            if (r4 >= r0) goto L5e
            r0 = r1[r4]
            if (r5 == 0) goto L23
            r0.ACD()
        L23:
            r9.A0Q(r2)
            boolean r3 = r0.A7n()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C2059Xi.A0s
            r0 = 4
            r1 = r2[r0]
            r0 = 1
            r2 = r2[r0]
            r0 = 9
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L58
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C2059Xi.A0s
            java.lang.String r1 = "2xZTToEoCwsl8MeSQ9EIUdCBiuq4j6Lb"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "WXli42TSAlQlgSv7suJf6xw7W0hHNYE8"
            r0 = 1
            r2[r0] = r1
            if (r3 != 0) goto L4d
            return r8
        L4d:
            r5 = 1
            int r0 = r9.A04
            int r0 = r0 + r7
            r9.A04 = r0
            goto Lf
        L54:
            com.facebook.ads.redexgen.X.At[] r0 = r9.A0d
            int r0 = r0.length
            goto Lc
        L58:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L5e:
            java.nio.ByteBuffer r5 = r9.A0U
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C2059Xi.A0s
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 31
            if (r1 == r0) goto L77
            if (r5 == 0) goto L86
        L6f:
            r9.A0T(r5, r2)
            java.nio.ByteBuffer r0 = r9.A0U
            if (r0 == 0) goto L86
            return r8
        L77:
            java.lang.String[] r4 = com.facebook.ads.redexgen.X.C2059Xi.A0s
            java.lang.String r1 = "9QdkqYSTFHb7WYiPiRp7Y6nS2TP2i0It"
            r0 = 5
            r4[r0] = r1
            java.lang.String r1 = "gIdgEUZyaZheDXAdPlxJ5YfvFSsVsGnk"
            r0 = 2
            r4[r0] = r1
            if (r5 == 0) goto L86
            goto L6f
        L86:
            r9.A04 = r6
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2059Xi.A0U():boolean");
    }

    private boolean A0V() {
        return this.A0M != null;
    }

    private InterfaceC1502At[] A0W() {
        if (this.A0a) {
            return this.A0n;
        }
        return this.A0o;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f0 A[PHI: r2
      0x00f0: PHI (r2v6 'channelCount' int) = (r2v3 'channelCount' int), (r2v7 'channelCount' int) binds: [B:76:0x0162, B:53:0x00ee] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0176  */
    @Override // com.facebook.ads.redexgen.X.B6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A46(int r11, int r12, int r13, int r14, @androidx.annotation.Nullable int[] r15, int r16, int r17) throws com.facebook.ads.redexgen.X.B2 {
        /*
            Method dump skipped, instruction units count: 566
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2059Xi.A46(int, int, int, int, int[], int, int):void");
    }

    @Override // com.facebook.ads.redexgen.X.B6
    public final void A4l() {
        if (this.A0b) {
            this.A0b = false;
            this.A01 = 0;
            reset();
        }
    }

    @Override // com.facebook.ads.redexgen.X.B6
    public final void A52(int i) {
        C1662Hr.A04(IW.A02 >= 21);
        if (!this.A0b || this.A01 != i) {
            this.A0b = true;
            this.A01 = i;
            reset();
        }
    }

    @Override // com.facebook.ads.redexgen.X.B6
    public final long A61(boolean z) {
        if (!A0V() || this.A0D == 0) {
            return Long.MIN_VALUE;
        }
        return this.A0H + A05(A06(Math.min(this.A0h.A0D(z), A08(A04()))));
    }

    @Override // com.facebook.ads.redexgen.X.B6
    public final AF A6s() {
        return this.A0P;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0182  */
    @Override // com.facebook.ads.redexgen.X.B6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A7M(java.nio.ByteBuffer r20, long r21) throws com.facebook.ads.redexgen.X.B5, com.facebook.ads.redexgen.X.B3 {
        /*
            Method dump skipped, instruction units count: 555
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2059Xi.A7M(java.nio.ByteBuffer, long):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.B6
    public final void A7N() {
        if (this.A0D == 1) {
            this.A0D = 2;
        }
    }

    @Override // com.facebook.ads.redexgen.X.B6
    public final boolean A7Q() {
        return A0V() && this.A0h.A0K(A04());
    }

    @Override // com.facebook.ads.redexgen.X.B6
    public final boolean A7m(int i) {
        if (IW.A0d(i)) {
            return i != 4 || IW.A02 >= 21;
        }
        C1496Am c1496Am = this.A0g;
        return c1496Am != null && c1496Am.A04(i);
    }

    @Override // com.facebook.ads.redexgen.X.B6
    public final boolean A7n() {
        return !A0V() || (this.A0W && !A7Q());
    }

    @Override // com.facebook.ads.redexgen.X.B6
    public final void ABz() {
        this.A0Y = true;
        if (A0V()) {
            this.A0h.A0F();
            AudioTrack audioTrack = this.A0M;
            if (A0s[3].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0s;
            strArr[3] = "NrYH7da7InJYZ7DcifiCDIWgHy9XttZ";
            strArr[3] = "NrYH7da7InJYZ7DcifiCDIWgHy9XttZ";
            audioTrack.play();
        }
    }

    @Override // com.facebook.ads.redexgen.X.B6
    public final void AC0() throws B5 {
        if (this.A0W) {
            return;
        }
        boolean zA0V = A0V();
        String[] strArr = A0s;
        if (strArr[6].charAt(18) != strArr[0].charAt(18)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0s;
        strArr2[6] = "potoNIjJr8c5PhhOHWP3V8xbrUltb98O";
        strArr2[0] = "s7h49TBBG9Upv5zOzLPi805BwVxtpEdY";
        if (zA0V && A0U()) {
            this.A0h.A0G(A04());
            this.A0M.stop();
            this.A03 = 0;
            this.A0W = true;
        }
    }

    @Override // com.facebook.ads.redexgen.X.B6
    public final void ACW() {
        reset();
        A0L();
        for (InterfaceC1502At interfaceC1502At : this.A0o) {
            interfaceC1502At.reset();
            if (A0s[3].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0s;
            strArr[5] = "qwdTDv5zTd3QZESqVqPfOIKdJj7Lz8kg";
            strArr[2] = "LbdTDWALSGuogzF76GUONHDiI7JL2ED4";
        }
        for (InterfaceC1502At interfaceC1502At2 : this.A0n) {
            interfaceC1502At2.reset();
        }
        this.A01 = 0;
        this.A0Y = false;
        if (A0s[7].charAt(5) != 'v') {
            String[] strArr2 = A0s;
            strArr2[3] = "7yJp0zMcRreZgWUPzTirOlbpECU1qPL";
            strArr2[3] = "7yJp0zMcRreZgWUPzTirOlbpECU1qPL";
        } else {
            String[] strArr3 = A0s;
            strArr3[5] = "IJdzF7l1OUCqcHSZRNfx63TpictB3CeC";
            strArr3[2] = "IidC6PogfV1YW6p29FProDWayU60rDbu";
        }
    }

    @Override // com.facebook.ads.redexgen.X.B6
    public final void ADB(C1495Al c1495Al) {
        if (this.A0Q.equals(c1495Al)) {
            return;
        }
        this.A0Q = c1495Al;
        if (this.A0b) {
            return;
        }
        reset();
        this.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.B6
    public final void ADI(B4 b4) {
        this.A0R = b4;
    }

    @Override // com.facebook.ads.redexgen.X.B6
    public final AF ADM(AF af) {
        if (A0V() && !this.A0V) {
            this.A0P = AF.A04;
            return this.A0P;
        }
        AF af2 = this.A0O;
        if (af2 == null) {
            if (!this.A0l.isEmpty()) {
                af2 = this.A0l.getLast().A02;
            } else {
                af2 = this.A0P;
            }
        }
        if (!af.equals(af2)) {
            if (A0V()) {
                this.A0O = af;
            } else {
                this.A0P = this.A0j.A3R(af);
            }
        }
        return this.A0P;
    }

    @Override // com.facebook.ads.redexgen.X.B6
    public final void pause() {
        this.A0Y = false;
        if (A0V() && this.A0h.A0J()) {
            this.A0M.pause();
        }
    }

    @Override // com.facebook.ads.redexgen.X.B6
    public final void reset() {
        if (A0V()) {
            this.A0J = 0L;
            this.A0I = 0L;
            this.A0L = 0L;
            this.A0K = 0L;
            this.A05 = 0;
            AF af = this.A0O;
            if (af != null) {
                this.A0P = af;
                this.A0O = null;
            } else if (!this.A0l.isEmpty()) {
                ArrayDeque<BH> arrayDeque = this.A0l;
                if (A0s[7].charAt(5) == 'v') {
                    throw new RuntimeException();
                }
                String[] strArr = A0s;
                strArr[7] = "7Zd0LJuJ8v1AsDIGeh9Ten8e10sO09Lx";
                strArr[7] = "7Zd0LJuJ8v1AsDIGeh9Ten8e10sO09Lx";
                this.A0P = arrayDeque.getLast().A02;
            }
            this.A0l.clear();
            this.A0F = 0L;
            this.A0G = 0L;
            this.A0T = null;
            this.A0U = null;
            A0J();
            this.A0W = false;
            this.A04 = -1;
            this.A0S = null;
            this.A03 = 0;
            this.A0D = 0;
            if (this.A0h.A0I()) {
                this.A0M.pause();
            }
            AudioTrack audioTrack = this.A0M;
            this.A0M = null;
            this.A0h.A0E();
            this.A0f.close();
            new BD(this, audioTrack).start();
        }
    }

    @Override // com.facebook.ads.redexgen.X.B6
    public final void setVolume(float f2) {
        if (this.A00 != f2) {
            this.A00 = f2;
            A0M();
        }
    }
}
