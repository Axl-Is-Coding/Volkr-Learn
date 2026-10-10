package com.facebook.ads.internal.exoplayer2.metadata.id3;

import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import com.facebook.ads.redexgen.X.C1662Hr;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class Id3Frame implements Metadata.Entry {
    public final String A00;

    public Id3Frame(String str) {
        this.A00 = (String) C1662Hr.A01(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.A00;
    }
}
