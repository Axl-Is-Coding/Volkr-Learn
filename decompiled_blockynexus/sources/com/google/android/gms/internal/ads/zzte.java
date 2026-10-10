package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "CacheOfferingCreator")
@SafeParcelable.Reserved({1})
public final class zzte extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzte> CREATOR = new zztd();

    @SafeParcelable.Field(id = 2)
    public final String url;

    @SafeParcelable.Field(id = 3)
    private final long zzbve;

    @SafeParcelable.Field(id = 4)
    private final String zzbvf;

    @SafeParcelable.Field(id = 5)
    private final String zzbvg;

    @SafeParcelable.Field(id = 6)
    private final String zzbvh;

    @SafeParcelable.Field(id = 7)
    private final Bundle zzbvi;

    @SafeParcelable.Field(id = 8)
    public final boolean zzbvj;

    @SafeParcelable.Field(id = 9)
    public long zzbvk;

    @SafeParcelable.Constructor
    zzte(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) Bundle bundle, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) long j2) {
        this.url = str;
        this.zzbve = j;
        this.zzbvf = str2 == null ? "" : str2;
        this.zzbvg = str3 == null ? "" : str3;
        this.zzbvh = str4 != null ? str4 : "";
        this.zzbvi = bundle == null ? new Bundle() : bundle;
        this.zzbvj = z;
        this.zzbvk = j2;
    }

    public static zzte zzbw(String str) {
        return zzd(Uri.parse(str));
    }

    public static zzte zzd(Uri uri) {
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                zzbbq.zzfe(sb.toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean zEquals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long j = queryParameter2 == null ? 0L : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            com.google.android.gms.ads.internal.zzp.zzkt();
            for (String str3 : uri.getQueryParameterNames()) {
                if (str3.startsWith("tag.")) {
                    bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                }
            }
            return new zzte(queryParameter, j, host, str, str2, bundle, zEquals, 0L);
        } catch (NullPointerException | NumberFormatException e2) {
            zzbbq.zzd("Unable to parse Uri into cache offering.", e2);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.url, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzbve);
        SafeParcelWriter.writeString(parcel, 4, this.zzbvf, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbvg, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzbvh, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzbvi, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbvj);
        SafeParcelWriter.writeLong(parcel, 9, this.zzbvk);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
