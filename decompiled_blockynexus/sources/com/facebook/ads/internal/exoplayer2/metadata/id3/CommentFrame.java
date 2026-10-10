package com.facebook.ads.internal.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.C1571Dy;
import com.facebook.ads.redexgen.X.IW;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CommentFrame extends Id3Frame {
    public static byte[] A03;
    public static final Parcelable.Creator<CommentFrame> CREATOR;
    public final String A00;
    public final String A01;
    public final String A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 18);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{30, 18, 86, 87, 65, 81, 64, 91, 66, 70, 91, 93, 92, ci.m, ci.m, 21, 89, 84, 91, 82, 64, 84, 82, 80, 8, 118, 122, 120, 120};
    }

    static {
        A01();
        CREATOR = new C1571Dy();
    }

    public CommentFrame(Parcel parcel) {
        super(A00(25, 4, 39));
        this.A01 = parcel.readString();
        this.A00 = parcel.readString();
        this.A02 = parcel.readString();
    }

    public CommentFrame(String str, String str2, String str3) {
        super(A00(25, 4, 39));
        this.A01 = str;
        this.A00 = str2;
        this.A02 = str3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        if (IW.A0h(this.A00, commentFrame.A00) && IW.A0h(this.A01, commentFrame.A01) && IW.A0h(this.A02, commentFrame.A02)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 17 * 31;
        String str = this.A01;
        int result = str != null ? str.hashCode() : 0;
        int i2 = (i + result) * 31;
        String str2 = this.A00;
        int result2 = str2 != null ? str2.hashCode() : 0;
        int i3 = (i2 + result2) * 31;
        String str3 = this.A02;
        return i3 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.facebook.ads.internal.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(14, 11, 39) + this.A01 + A00(0, 14, 32) + this.A00;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(super.A00);
        parcel.writeString(this.A01);
        parcel.writeString(this.A02);
    }
}
