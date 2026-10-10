package com.facebook.ads.redexgen.X;

import android.view.Surface;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.checkerframework.checker.nullness.qual.MonotonicNonNull;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2054Xd implements AI, InterfaceC1564Dr, B1, InterfaceC1689Iu, FM, H6, Bi {
    public static String[] A05;

    @MonotonicNonNull
    public AN A00;
    public final InterfaceC1665Hu A03;
    public final CopyOnWriteArraySet<InterfaceC1488Ae> A04 = new CopyOnWriteArraySet<>();
    public final C1485Ab A02 = new C1485Ab();
    public final AY A01 = new AY();

    static {
        A06();
    }

    public static void A06() {
        A05 = new String[]{"oWxliEG", "84CCzfJSWHAMzlT", "dVPYU5AFfnLld9", "202VfNqPV04zLFr42xUQnFXcv", "6C2OHs0d6U2aNpx0mThNdUqCMJf7H", "j36hHuSQknS9Y2BeP2DWP06EygcBzL55", "WN9koNHhTr4SbLKtJDKTY2JTPC", "f2Eog"};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 8
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // com.facebook.ads.redexgen.X.H6
    public final void A9I(int i, long j, long j2) {
        A01();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public C2054Xd(@Nullable AN an, InterfaceC1665Hu interfaceC1665Hu) {
        this.A00 = an;
        this.A03 = (InterfaceC1665Hu) C1662Hr.A01(interfaceC1665Hu);
    }

    private C1487Ad A00() {
        return A05(this.A02.A04());
    }

    private C1487Ad A01() {
        return A05(this.A02.A05());
    }

    private C1487Ad A02() {
        return A05(this.A02.A06());
    }

    private C1487Ad A03() {
        return A05(this.A02.A07());
    }

    private final C1487Ad A04(int i, @Nullable F6 f6) {
        long jA00;
        C1662Hr.A01(this.A00);
        long jA4z = this.A03.A4z();
        AZ timeline = this.A00.A62();
        if (i == this.A00.A63()) {
            if (f6 != null && f6.A02()) {
                if (this.A00.A5x() == f6.A00 && this.A00.A5y() == f6.A01) {
                    jA00 = this.A00.A60();
                } else {
                    jA00 = 0;
                }
            } else {
                jA00 = this.A00.A5v();
            }
        } else if (i >= timeline.A02() || (f6 != null && f6.A02())) {
            jA00 = 0;
        } else {
            jA00 = timeline.A0C(i, this.A01).A00();
        }
        return new C1487Ad(jA4z, timeline, i, f6, jA00, this.A00.A60(), this.A00.A5e() - this.A00.A5v());
    }

    private C1487Ad A05(@Nullable C1486Ac c1486Ac) {
        if (c1486Ac == null) {
            int iA63 = ((AN) C1662Hr.A01(this.A00)).A63();
            return A04(iA63, this.A02.A08(iA63));
        }
        return A04(c1486Ac.A00, c1486Ac.A01);
    }

    public final void A07() {
        if (!this.A02.A0G()) {
            C1487Ad c1487AdA02 = A02();
            this.A02.A0A();
            for (InterfaceC1488Ae interfaceC1488Ae : this.A04) {
                String[] strArr = A05;
                if (strArr[1].length() == strArr[4].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A05;
                strArr2[1] = "PBkwxeOlbvYzAOz";
                strArr2[4] = "zMCnce58Qhbdr93RoMzV7EOLVlkYq";
                interfaceC1488Ae.onSeekStarted(c1487AdA02);
            }
        }
    }

    public final void A08() {
        Iterator it = new ArrayList(this.A02.A05).iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String[] strArr = A05;
            if (strArr[1].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[0] = "gG2PlvUwOW39eC8R";
            strArr2[0] = "gG2PlvUwOW39eC8R";
            if (zHasNext) {
                C1486Ac mediaPeriod = (C1486Ac) it.next();
                AAU(mediaPeriod.A00, mediaPeriod.A01);
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.B1
    public final void A9B(String str, long j, long j2) {
        C1487Ad eventTime = A03();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInitialized(eventTime, 1, str, j2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.B1
    public final void A9C(BU bu) {
        C1487Ad c1487AdA00 = A00();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderDisabled(c1487AdA00, 1, bu);
        }
    }

    @Override // com.facebook.ads.redexgen.X.B1
    public final void A9D(BU bu) {
        C1487Ad c1487AdA02 = A02();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderEnabled(c1487AdA02, 1, bu);
        }
    }

    @Override // com.facebook.ads.redexgen.X.B1
    public final void A9E(Format format) {
        C1487Ad c1487AdA03 = A03();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInputFormatChanged(c1487AdA03, 1, format);
        }
    }

    @Override // com.facebook.ads.redexgen.X.B1
    public final void A9F(int i) {
        C1487Ad c1487AdA03 = A03();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onAudioSessionId(c1487AdA03, i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.B1
    public final void A9G(int i, long j, long j2) {
        C1487Ad c1487AdA03 = A03();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A05[2].length() == 13) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[1] = "uqo4gq1KBxiMktN";
            strArr[4] = "Ndm2ibG2UK8Su1apjnSt0jhcojAUZ";
            if (zHasNext) {
                it.next().onAudioUnderrun(c1487AdA03, i, j, j2);
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.FM
    public final void A9g(int i, @Nullable F6 f6, FL fl) {
        C1487Ad c1487AdA04 = A04(i, f6);
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDownstreamFormatChanged(c1487AdA04, fl);
        }
    }

    @Override // com.facebook.ads.redexgen.X.Bi
    public final void A9h() {
        C1487Ad c1487AdA03 = A03();
        for (InterfaceC1488Ae listener : this.A04) {
            listener.onDrmKeysLoaded(c1487AdA03);
        }
    }

    @Override // com.facebook.ads.redexgen.X.Bi
    public final void A9i() {
        C1487Ad c1487AdA03 = A03();
        for (InterfaceC1488Ae listener : this.A04) {
            listener.onDrmKeysRemoved(c1487AdA03);
        }
    }

    @Override // com.facebook.ads.redexgen.X.Bi
    public final void A9j() {
        C1487Ad c1487AdA03 = A03();
        for (InterfaceC1488Ae listener : this.A04) {
            listener.onDrmKeysRestored(c1487AdA03);
        }
    }

    @Override // com.facebook.ads.redexgen.X.Bi
    public final void A9k(Exception exc) {
        C1487Ad c1487AdA03 = A03();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionManagerError(c1487AdA03, exc);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1689Iu
    public final void A9l(int i, long j) {
        C1487Ad c1487AdA00 = A00();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDroppedVideoFrames(c1487AdA00, i, j);
        }
    }

    @Override // com.facebook.ads.redexgen.X.FM
    public final void AAF(int i, @Nullable F6 f6, FK fk, FL fl) {
        A04(i, f6);
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.facebook.ads.redexgen.X.FM
    public final void AAH(int i, @Nullable F6 f6, FK fk, FL fl) {
        A04(i, f6);
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.facebook.ads.redexgen.X.FM
    public final void AAK(int i, @Nullable F6 f6, FK fk, FL fl, IOException iOException, boolean z) {
        C1487Ad c1487AdA04 = A04(i, f6);
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onLoadError(c1487AdA04, fk, fl, iOException, z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.FM
    public final void AAM(int i, @Nullable F6 f6, FK fk, FL fl) {
        A04(i, f6);
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AI
    public final void AAO(boolean z) {
        C1487Ad c1487AdA02 = A02();
        for (InterfaceC1488Ae interfaceC1488Ae : this.A04) {
            if (A05[2].length() == 13) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[5] = "61iKEbH7Elk598B8IvoVeyiFcghmzjBq";
            strArr[5] = "61iKEbH7Elk598B8IvoVeyiFcghmzjBq";
            interfaceC1488Ae.onLoadingChanged(c1487AdA02, z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.FM
    public final void AAT(int i, F6 f6) {
        this.A02.A0C(i, f6);
        C1487Ad c1487AdA04 = A04(i, f6);
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onMediaPeriodCreated(c1487AdA04);
        }
    }

    @Override // com.facebook.ads.redexgen.X.FM
    public final void AAU(int i, F6 f6) {
        this.A02.A0D(i, f6);
        C1487Ad c1487AdA04 = A04(i, f6);
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String[] strArr = A05;
            if (strArr[7].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[1] = "xQuAJnMHmsnkUtn";
            strArr2[4] = "I7nuhInD03G6TyFgZN1tEp7XA66Po";
            if (zHasNext) {
                it.next().onMediaPeriodReleased(c1487AdA04);
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1564Dr
    public final void AAX(Metadata metadata) {
        C1487Ad c1487AdA02 = A02();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onMetadata(c1487AdA02, metadata);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AI
    public final void AAm(AF af) {
        C1487Ad c1487AdA02 = A02();
        for (InterfaceC1488Ae interfaceC1488Ae : this.A04) {
            if (A05[5].charAt(25) != 'g') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[5] = "6kCd761y4Sm0JC2HIy7vlDu4Zge9adCZ";
            strArr[5] = "6kCd761y4Sm0JC2HIy7vlDu4Zge9adCZ";
            interfaceC1488Ae.onPlaybackParametersChanged(c1487AdA02, af);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AI
    public final void AAo(C14789u c14789u) {
        C1487Ad c1487AdA02 = A02();
        for (InterfaceC1488Ae interfaceC1488Ae : this.A04) {
            String[] strArr = A05;
            if (strArr[7].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[3] = "4uLQlqFUz3TKu9PUP8Ua0";
            strArr2[3] = "4uLQlqFUz3TKu9PUP8Ua0";
            interfaceC1488Ae.onPlayerError(c1487AdA02, c14789u);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AI
    public final void AAq(boolean z, int i) {
        C1487Ad c1487AdA02 = A02();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onPlayerStateChanged(c1487AdA02, z, i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AI
    public final void AAs(int i) {
        this.A02.A0B(i);
        C1487Ad c1487AdA02 = A02();
        for (InterfaceC1488Ae listener : this.A04) {
            listener.onPositionDiscontinuity(c1487AdA02, i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.FM
    public final void AB0(int i, F6 f6) {
        this.A02.A0E(i, f6);
        C1487Ad c1487AdA04 = A04(i, f6);
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onReadingStarted(c1487AdA04);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1689Iu
    public final void AB3(Surface surface) {
        C1487Ad c1487AdA03 = A03();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String[] strArr = A05;
            if (strArr[1].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[0] = "zEYrHw08cBp169ZitgaAlaUGutwvX";
            strArr2[0] = "zEYrHw08cBp169ZitgaAlaUGutwvX";
            if (zHasNext) {
                it.next().onRenderedFirstFrame(c1487AdA03, surface);
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AI
    public final void ABD() {
        if (this.A02.A0G()) {
            this.A02.A09();
            C1487Ad c1487AdA02 = A02();
            for (InterfaceC1488Ae listener : this.A04) {
                listener.onSeekProcessed(c1487AdA02);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AI
    public final void ABP(AZ az, @Nullable Object obj, int i) {
        this.A02.A0F(az);
        C1487Ad c1487AdA02 = A02();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onTimelineChanged(c1487AdA02, i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AI
    public final void ABQ(TrackGroupArray trackGroupArray, C1644Gz c1644Gz) {
        C1487Ad c1487AdA02 = A02();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onTracksChanged(c1487AdA02, trackGroupArray, c1644Gz);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1689Iu
    public final void ABY(String str, long j, long j2) {
        C1487Ad eventTime = A03();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInitialized(eventTime, 2, str, j2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1689Iu
    public final void ABZ(BU bu) {
        C1487Ad c1487AdA00 = A00();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderDisabled(c1487AdA00, 2, bu);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1689Iu
    public final void ABa(BU bu) {
        C1487Ad c1487AdA02 = A02();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderEnabled(c1487AdA02, 2, bu);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1689Iu
    public final void ABc(Format format) {
        C1487Ad c1487AdA03 = A03();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInputFormatChanged(c1487AdA03, 2, format);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1689Iu
    public final void ABf(int i, int i2, int i3, float f2) {
        C1487Ad c1487AdA03 = A03();
        Iterator<InterfaceC1488Ae> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onVideoSizeChanged(c1487AdA03, i, i2, i3, f2);
        }
    }
}
