package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "SafeBrowsingConfigParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzawg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzawg> CREATOR = new zzawj();

    @SafeParcelable.Field(id = 2)
    public final String zzdxc;

    @SafeParcelable.Field(id = 3)
    public final String zzdxd;

    @SafeParcelable.Field(id = 4)
    public final boolean zzdxe;

    @SafeParcelable.Field(id = 5)
    public final boolean zzdxf;

    @SafeParcelable.Field(id = 6)
    public final List<String> zzdxg;

    @SafeParcelable.Field(id = 7)
    public final boolean zzdxh;

    @SafeParcelable.Field(id = 8)
    public final boolean zzdxi;

    @SafeParcelable.Field(id = 9)
    public final List<String> zzdxj;

    @SafeParcelable.Constructor
    public zzawg(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) List<String> list, @SafeParcelable.Param(id = 7) boolean z3, @SafeParcelable.Param(id = 8) boolean z4, @SafeParcelable.Param(id = 9) List<String> list2) {
        this.zzdxc = str;
        this.zzdxd = str2;
        this.zzdxe = z;
        this.zzdxf = z2;
        this.zzdxg = list;
        this.zzdxh = z3;
        this.zzdxi = z4;
        this.zzdxj = list2 == null ? new ArrayList<>() : list2;
    }

    public static zzawg zzg(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        return new zzawg(jSONObject.optString("click_string", ""), jSONObject.optString("report_url", ""), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), zzbao.zza(jSONObject.optJSONArray("allowed_headers"), (List<String>) null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), zzbao.zza(jSONObject.optJSONArray("webview_permissions"), (List<String>) null));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdxc, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdxd, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzdxe);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzdxf);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzdxg, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzdxh);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdxi);
        SafeParcelWriter.writeStringList(parcel, 9, this.zzdxj, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
