package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public abstract class GmsClientSupervisor {
    private static int zza = 129;
    private static final Object zzb = new Object();
    private static GmsClientSupervisor zzc;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    protected static final class zza {
        private static final Uri zzf = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
        private final String zza;
        private final String zzb;
        private final ComponentName zzc;
        private final int zzd;
        private final boolean zze;

        public zza(String str, int i) {
            this(str, "com.google.android.gms", i);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return Objects.equal(this.zza, zzaVar.zza) && Objects.equal(this.zzb, zzaVar.zzb) && Objects.equal(this.zzc, zzaVar.zzc) && this.zzd == zzaVar.zzd && this.zze == zzaVar.zze;
        }

        public final int hashCode() {
            return Objects.hashCode(this.zza, this.zzb, this.zzc, Integer.valueOf(this.zzd), Boolean.valueOf(this.zze));
        }

        public final String toString() {
            String str = this.zza;
            if (str != null) {
                return str;
            }
            Preconditions.checkNotNull(this.zzc);
            return this.zzc.flattenToString();
        }

        public final String zza() {
            return this.zzb;
        }

        public final ComponentName zzb() {
            return this.zzc;
        }

        public final int zzc() {
            return this.zzd;
        }

        private zza(String str, String str2, int i) {
            this(str, str2, i, false);
        }

        private final Intent zzb(Context context) {
            Bundle bundleCall;
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", this.zza);
            try {
                bundleCall = context.getContentResolver().call(zzf, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e2) {
                String strValueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 34);
                sb.append("Dynamic intent resolution failed: ");
                sb.append(strValueOf);
                Log.w("ConnectionStatusConfig", sb.toString());
                bundleCall = null;
            }
            Intent intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                String strValueOf2 = String.valueOf(this.zza);
                Log.w("ConnectionStatusConfig", strValueOf2.length() != 0 ? "Dynamic lookup for intent failed for action: ".concat(strValueOf2) : new String("Dynamic lookup for intent failed for action: "));
            }
            return intent;
        }

        public final Intent zza(Context context) {
            if (this.zza == null) {
                return new Intent().setComponent(this.zzc);
            }
            Intent intentZzb = this.zze ? zzb(context) : null;
            return intentZzb == null ? new Intent(this.zza).setPackage(this.zzb) : intentZzb;
        }

        public zza(String str, String str2, int i, boolean z) {
            Preconditions.checkNotEmpty(str);
            this.zza = str;
            Preconditions.checkNotEmpty(str2);
            this.zzb = str2;
            this.zzc = null;
            this.zzd = i;
            this.zze = z;
        }

        public zza(ComponentName componentName, int i) {
            this.zza = null;
            this.zzb = null;
            Preconditions.checkNotNull(componentName);
            this.zzc = componentName;
            this.zzd = i;
            this.zze = false;
        }
    }

    @KeepForSdk
    public static int getDefaultBindFlags() {
        return zza;
    }

    @KeepForSdk
    public static GmsClientSupervisor getInstance(Context context) {
        synchronized (zzb) {
            if (zzc == null) {
                zzc = new zzf(context.getApplicationContext());
            }
        }
        return zzc;
    }

    @KeepForSdk
    public boolean bindService(String str, ServiceConnection serviceConnection, String str2) {
        return zza(new zza(str, getDefaultBindFlags()), serviceConnection, str2);
    }

    @KeepForSdk
    public void unbindService(String str, ServiceConnection serviceConnection, String str2) {
        zzb(new zza(str, getDefaultBindFlags()), serviceConnection, str2);
    }

    public final void zza(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        zzb(new zza(str, str2, i, z), serviceConnection, str3);
    }

    protected abstract boolean zza(zza zzaVar, ServiceConnection serviceConnection, String str);

    protected abstract void zzb(zza zzaVar, ServiceConnection serviceConnection, String str);

    @KeepForSdk
    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName, getDefaultBindFlags()), serviceConnection, str);
    }

    @KeepForSdk
    public void unbindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName, getDefaultBindFlags()), serviceConnection, str);
    }
}
