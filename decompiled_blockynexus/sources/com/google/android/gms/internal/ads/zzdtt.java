package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
final class zzdtt implements zzdtv {
    private static final zzcf.zza zzhmx = zzcf.zza.zzar();

    zzdtt() {
    }

    @Override // com.google.android.gms.internal.ads.zzdtv
    public final zzcf.zza zzawe() {
        return zzhmx;
    }

    @Override // com.google.android.gms.internal.ads.zzdtv
    public final zzcf.zza zzck(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException, IOException {
        zzcf.zza.C0108zza c0108zzaZzaq = zzcf.zza.zzaq();
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context);
        advertisingIdClient.start();
        AdvertisingIdClient.Info info = advertisingIdClient.getInfo();
        String id = info.getId();
        if (id != null && id.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID uuidFromString = UUID.fromString(id);
            byte[] bArr = new byte[16];
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.putLong(uuidFromString.getMostSignificantBits());
            byteBufferWrap.putLong(uuidFromString.getLeastSignificantBits());
            id = Base64.encodeToString(bArr, 11);
        }
        if (id != null) {
            c0108zzaZzaq.zzac(id);
            c0108zzaZzaq.zza(info.isLimitAdTrackingEnabled());
            c0108zzaZzaq.zza(zzcf.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
        }
        return (zzcf.zza) c0108zzaZzaq.zzbgt();
    }
}
