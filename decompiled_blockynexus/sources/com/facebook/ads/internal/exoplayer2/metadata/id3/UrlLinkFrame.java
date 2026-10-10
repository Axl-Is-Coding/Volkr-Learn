package com.facebook.ads.internal.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.E5;
import com.facebook.ads.redexgen.X.IW;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class UrlLinkFrame extends Id3Frame {
    public static byte[] A02;
    public static String[] A03;
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR;
    public final String A00;
    public final String A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A03;
            if (strArr[4].charAt(31) == strArr[5].charAt(31)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[4] = "Ytg7Kx5ciTxcBbuwxTwHBhNcXLsKFS2u";
            strArr2[5] = "TL4yJ8wM2eMbRk1FBnProTEIlflGc1M5";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 45);
            i4++;
        }
    }

    public static void A01() {
        A02 = new byte[]{-69, -95, -10, -13, -19, -66};
    }

    public static void A02() {
        A03 = new String[]{"K7RxnzjPeOdkr4E7awDWllYcHNZuI9c0", "lXepHslf415JArxV8sfEK4fqkdDxnDOZ", "zMpWBBAelSFSuaQHvpCFzFuKeG8cwMdZ", "r302VQJ2ie6981RfLfu9NzFVyQSaDacI", "33DyIHcKE7zPO0W2W54S0gt5PvHaUO5u", "58MEWeTNhg8nMGusT37cDOvrm2zs5Mnh", "xx8E8fg6Qtq0yUEy7uiNZyUO49Wldq56", "TSvuC"};
    }

    static {
        A02();
        A01();
        CREATOR = new E5();
    }

    public UrlLinkFrame(Parcel parcel) {
        super(parcel.readString());
        this.A00 = parcel.readString();
        this.A01 = parcel.readString();
    }

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.A00 = str2;
        this.A01 = str3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        if (super.A00.equals(((Id3Frame) urlLinkFrame).A00) && IW.A0h(this.A00, urlLinkFrame.A00) && IW.A0h(this.A01, urlLinkFrame.A01)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((17 * 31) + super.A00.hashCode()) * 31;
        String str = this.A00;
        int result = str != null ? str.hashCode() : 0;
        int i = (iHashCode + result) * 31;
        String str2 = this.A01;
        return i + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.facebook.ads.internal.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(0, 6, 84) + this.A01;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(super.A00);
        parcel.writeString(this.A00);
        parcel.writeString(this.A01);
    }
}
