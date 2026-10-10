package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.metadata.scte35.PrivateCommand;
import com.facebook.ads.internal.exoplayer2.metadata.scte35.SpliceCommand;
import com.facebook.ads.internal.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.facebook.ads.internal.exoplayer2.metadata.scte35.SpliceNullCommand;
import com.facebook.ads.internal.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.facebook.ads.internal.exoplayer2.metadata.scte35.TimeSignalCommand;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ZM implements InterfaceC1561Do {
    public static String[] A03;
    public IS A00;
    public final IG A02 = new IG();
    public final IF A01 = new IF();

    static {
        A00();
    }

    public static void A00() {
        A03 = new String[]{"TasyJMHsWGEkz863ImR0Q5Lz0Jv5KZRl", "wAvcoPGmhTOD2UdnkI7mjYYyFDdz6tY4", "tIFolEUfJcQQhLLKuuKqSvXZilOQ0d41", "wnba1Mxhk7UAzMMhJxuW", "IqdHVgHf3sWcJ9J53HVfrlZmkyidEDTw", "kUaC4Xj2GLTFGhk3U8FgQLf5h3yptWRi", "yAL9OJMifRSpz7GOwtKlA6RWbWPVLH5t", "1By3yk2Axs3IVYX9txEI"};
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1561Do
    public final Metadata A4e(C2 c2) throws C1562Dp {
        if (this.A00 == null || c2.A00 != this.A00.A06()) {
            this.A00 = new IS(((C2067Xq) c2).A00);
            this.A00.A07(((C2067Xq) c2).A00 - c2.A00);
        }
        ByteBuffer byteBuffer = c2.A01;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.A02.A0c(bArrArray, iLimit);
        this.A01.A0D(bArrArray, iLimit);
        this.A01.A09(39);
        int size = this.A01.A05(1);
        long j = ((long) size) << 32;
        long ptsAdjustment = this.A01.A05(32);
        long j2 = j | ptsAdjustment;
        this.A01.A09(20);
        int iA05 = this.A01.A05(12);
        int spliceCommandType = this.A01.A05(8);
        SpliceCommand command = null;
        this.A02.A0a(14);
        if (spliceCommandType == 0) {
            command = new SpliceNullCommand();
        } else if (spliceCommandType == 255) {
            IG ig = this.A02;
            if (A03[1].charAt(6) != 'G') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "IAVDgnOrTVyqUqMF0jCb";
            strArr[7] = "AiSzseiiVBo4zRVGAcCm";
            command = PrivateCommand.A00(ig, iA05, j2);
        } else if (spliceCommandType == 4) {
            command = SpliceScheduleCommand.A00(this.A02);
        } else if (spliceCommandType == 5) {
            command = SpliceInsertCommand.A00(this.A02, j2, this.A00);
        } else if (spliceCommandType == 6) {
            command = TimeSignalCommand.A01(this.A02, j2, this.A00);
        }
        return command == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(command);
    }
}
