package com.google.android.gms.internal.measurement;

import a.a.b;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzct implements zzcx {
    private static final Map<Uri, zzct> zza = new b();
    private static final String[] zzh = {"key", "value"};
    private final ContentResolver zzb;
    private final Uri zzc;
    private volatile Map<String, String> zzf;
    private final ContentObserver zzd = new zzcv(this, null);
    private final Object zze = new Object();
    private final List<zzcu> zzg = new ArrayList();

    private zzct(ContentResolver contentResolver, Uri uri) {
        zzeb.zza(contentResolver);
        zzeb.zza(uri);
        this.zzb = contentResolver;
        this.zzc = uri;
        contentResolver.registerContentObserver(uri, false, this.zzd);
    }

    public static zzct zza(ContentResolver contentResolver, Uri uri) {
        zzct zzctVar;
        synchronized (zzct.class) {
            zzctVar = zza.get(uri);
            if (zzctVar == null) {
                try {
                    zzct zzctVar2 = new zzct(contentResolver, uri);
                    try {
                        zza.put(uri, zzctVar2);
                    } catch (SecurityException unused) {
                    }
                    zzctVar = zzctVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzctVar;
    }

    static synchronized void zzc() {
        for (zzct zzctVar : zza.values()) {
            zzctVar.zzb.unregisterContentObserver(zzctVar.zzd);
        }
        zza.clear();
    }

    private final Map<String, String> zze() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                return (Map) zzcw.zza(new zzcz(this) { // from class: com.google.android.gms.internal.measurement.zzcs
                    private final zzct zza;

                    {
                        this.zza = this;
                    }

                    @Override // com.google.android.gms.internal.measurement.zzcz
                    public final Object zza() {
                        return this.zza.zzd();
                    }
                });
            } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return null;
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public final void zzb() {
        synchronized (this.zze) {
            this.zzf = null;
            zzdh.zza();
        }
        synchronized (this) {
            Iterator<zzcu> it = this.zzg.iterator();
            while (it.hasNext()) {
                it.next().zza();
            }
        }
    }

    final /* synthetic */ Map zzd() {
        Cursor cursorQuery = this.zzb.query(this.zzc, zzh, null, null, null);
        if (cursorQuery == null) {
            return Collections.emptyMap();
        }
        try {
            int count = cursorQuery.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            Map bVar = count <= 256 ? new b(count) : new HashMap(count, 1.0f);
            while (cursorQuery.moveToNext()) {
                bVar.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            return bVar;
        } finally {
            cursorQuery.close();
        }
    }

    public final Map<String, String> zza() {
        Map<String, String> mapZze = this.zzf;
        if (mapZze == null) {
            synchronized (this.zze) {
                mapZze = this.zzf;
                if (mapZze == null) {
                    mapZze = zze();
                    this.zzf = mapZze;
                }
            }
        }
        return mapZze != null ? mapZze : Collections.emptyMap();
    }

    @Override // com.google.android.gms.internal.measurement.zzcx
    public final /* synthetic */ Object zza(String str) {
        return zza().get(str);
    }
}
