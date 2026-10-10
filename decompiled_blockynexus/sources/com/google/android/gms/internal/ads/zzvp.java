package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "AdValueParcelCreator")
public final class zzvp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvp> CREATOR = new zzvo();

    @SafeParcelable.Field(id = 1)
    public final int type;

    @SafeParcelable.Field(id = 2)
    public final int zzadc;

    @SafeParcelable.Field(id = 3)
    public final String zzadd;

    @SafeParcelable.Field(id = 4)
    public final long zzade;

    @SafeParcelable.Constructor
    public zzvp(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) long j) {
        this.type = i;
        this.zzadc = i2;
        this.zzadd = str;
        this.zzade = j;
    }

    public static zzvp zza(JSONObject jSONObject) throws JSONException {
        return new zzvp(jSONObject.getInt("type_num"), jSONObject.getInt("precision_num"), jSONObject.getString("currency"), jSONObject.getLong("value"));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.type);
        SafeParcelWriter.writeInt(parcel, 2, this.zzadc);
        SafeParcelWriter.writeString(parcel, 3, this.zzadd, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzade);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
