package com.facebook.ads.internal.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.EA;
import com.facebook.ads.redexgen.X.EC;
import com.facebook.ads.redexgen.X.IG;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static String[] A01;
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR;
    public final List<EC> A00;

    public static void A01() {
        A01 = new String[]{"it7lS", "DDMagQqfA6bdQNmcbGVHnHFBEyEyV1CV", "yj1Kd0vDyL1u2mFRENQtUt5M23mLahBX", "Jtl9O", "DzPPQsDVYOU8bWKOfUnj4CDUSnJ2WnBZ", "jfx4iKnVrCrKgyd9K0RyokJ5bMLL728G", "aEdAaZwrqc10hFo35SyTbuIH90C1HKve", "av2CnTBgmmUyqozc6FxJU9F0Qf7BUN36"};
    }

    static {
        A01();
        CREATOR = new EA();
    }

    public SpliceScheduleCommand(Parcel parcel) {
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(EC.A00(parcel));
        }
        this.A00 = Collections.unmodifiableList(arrayList);
    }

    public /* synthetic */ SpliceScheduleCommand(Parcel parcel, EA ea) {
        this(parcel);
    }

    public SpliceScheduleCommand(List<EC> list) {
        this.A00 = Collections.unmodifiableList(list);
    }

    public static SpliceScheduleCommand A00(IG ig) {
        int iA0F = ig.A0F();
        ArrayList arrayList = new ArrayList(iA0F);
        for (int i = 0; i < iA0F; i++) {
            arrayList.add(EC.A02(ig));
            if (A01[1].charAt(15) == 'W') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[6] = "d2FIwqylvh7iXAJnxNkaidieKhP3pOaB";
            strArr[4] = "dE1dCXJBgr8GZeSYP1l3R34BwUsmGXNG";
        }
        return new SpliceScheduleCommand(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int size = this.A00.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.A00.get(i2).A05(parcel);
        }
    }
}
