package com.facebook.ads.internal.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.C1570Dx;
import com.facebook.ads.redexgen.X.IW;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ChapterTocFrame extends Id3Frame {
    public static byte[] A05;
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR;
    public final String A00;
    public final boolean A01;
    public final boolean A02;
    public final String[] A03;
    public final Id3Frame[] A04;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 25);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{33, 54, 45, 33};
    }

    static {
        A01();
        CREATOR = new C1570Dx();
    }

    public ChapterTocFrame(Parcel parcel) {
        super(A00(0, 4, 123));
        this.A00 = parcel.readString();
        this.A02 = parcel.readByte() != 0;
        this.A01 = parcel.readByte() != 0;
        this.A03 = parcel.createStringArray();
        int i = parcel.readInt();
        this.A04 = new Id3Frame[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.A04[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public ChapterTocFrame(String str, boolean z, boolean z2, String[] strArr, Id3Frame[] id3FrameArr) {
        super(A00(0, 4, 123));
        this.A00 = str;
        this.A02 = z;
        this.A01 = z2;
        this.A03 = strArr;
        this.A04 = id3FrameArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        if (this.A02 == chapterTocFrame.A02 && this.A01 == chapterTocFrame.A01 && IW.A0h(this.A00, chapterTocFrame.A00) && Arrays.equals(this.A03, chapterTocFrame.A03) && Arrays.equals(this.A04, chapterTocFrame.A04)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = ((((17 * 31) + (this.A02 ? 1 : 0)) * 31) + (this.A01 ? 1 : 0)) * 31;
        String str = this.A00;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.A00);
        parcel.writeByte(this.A02 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A01 ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.A03);
        parcel.writeInt(this.A04.length);
        for (Id3Frame id3Frame : this.A04) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }
}
