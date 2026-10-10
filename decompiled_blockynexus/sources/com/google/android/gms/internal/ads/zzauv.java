package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "RewardItemParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzauv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzauv> CREATOR = new zzauu();

    @SafeParcelable.Field(id = 2)
    public final String type;

    @SafeParcelable.Field(id = 3)
    public final int zzdvs;

    public zzauv(RewardItem rewardItem) {
        this(rewardItem.getType(), rewardItem.getAmount());
    }

    public static zzauv zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzauv(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzauv)) {
            zzauv zzauvVar = (zzauv) obj;
            if (Objects.equal(this.type, zzauvVar.type) && Objects.equal(Integer.valueOf(this.zzdvs), Integer.valueOf(zzauvVar.zzdvs))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.type, Integer.valueOf(this.zzdvs));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.type, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdvs);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzauv(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i) {
        this.type = str;
        this.zzdvs = i;
    }
}
