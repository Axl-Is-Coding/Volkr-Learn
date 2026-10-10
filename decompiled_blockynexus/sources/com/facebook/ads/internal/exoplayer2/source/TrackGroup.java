package com.facebook.ads.internal.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.redexgen.X.C1598Fb;
import com.facebook.ads.redexgen.X.C1662Hr;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TrackGroup implements Parcelable {
    public static String[] A03;
    public static final Parcelable.Creator<TrackGroup> CREATOR;
    public int A00;
    public final int A01;
    public final Format[] A02;

    public static void A00() {
        A03 = new String[]{"uF1MaBjHqfaou024Qot33eYqIFU5JpvL", "e11WN2XHHVFyFb3tGbHyOnuTBXVrxID3", "sRFhiACxeNyk2ofGCUEzfsyXhtnOr6n1", "WOmDa", "B4eB5pbJ0Ea0X4wV3enRun3SeiDmty6A", "wkOrnjHBm7RpnZhD1xCNjmxcOEtiASyA", "Mmr4xD9J4DRMn7KtjO4WF7k", "AppkpJNXRVMekBVT0dKI7wy"};
    }

    static {
        A00();
        CREATOR = new C1598Fb();
    }

    public TrackGroup(Parcel parcel) {
        this.A01 = parcel.readInt();
        this.A02 = new Format[this.A01];
        for (int i = 0; i < this.A01; i++) {
            this.A02[i] = (Format) parcel.readParcelable(Format.class.getClassLoader());
        }
    }

    public TrackGroup(Format... formatArr) {
        C1662Hr.A04(formatArr.length > 0);
        this.A02 = formatArr;
        this.A01 = formatArr.length;
    }

    public final int A01(Format format) {
        int i = 0;
        while (true) {
            Format[] formatArr = this.A02;
            if (i < formatArr.length) {
                Format format2 = formatArr[i];
                String[] strArr = A03;
                if (strArr[7].length() != strArr[6].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A03;
                strArr2[3] = "gOIjn";
                strArr2[3] = "gOIjn";
                if (format == format2) {
                    return i;
                }
                i++;
            } else {
                return -1;
            }
        }
    }

    public final Format A02(int i) {
        return this.A02[i];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        return this.A01 == trackGroup.A01 && Arrays.equals(this.A02, trackGroup.A02);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            this.A00 = (17 * 31) + Arrays.hashCode(this.A02);
        }
        int result = this.A00;
        return result;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.A01);
        for (int i2 = 0; i2 < this.A01; i2++) {
            parcel.writeParcelable(this.A02[i2], 0);
        }
    }
}
