package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.Wrappers;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
@ShowFirstParty
@KeepForSdk
public class GoogleSignatureVerifier {
    private static GoogleSignatureVerifier zza;
    private final Context zzb;
    private volatile String zzc;

    private GoogleSignatureVerifier(Context context) {
        this.zzb = context.getApplicationContext();
    }

    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzc.zza(context);
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    public static boolean zza(PackageInfo packageInfo, boolean z) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? zza(packageInfo, zzi.zza) : zza(packageInfo, zzi.zza[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (zza(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(String str) {
        zzl zzlVarZza = zza(str);
        zzlVarZza.zzc();
        return zzlVarZza.zza;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isUidGoogleSigned(int i) {
        zzl zzlVarZza;
        String[] strArrZza = Wrappers.packageManager(this.zzb).zza(i);
        if (strArrZza != null && strArrZza.length != 0) {
            zzlVarZza = null;
            int length = strArrZza.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    Preconditions.checkNotNull(zzlVarZza);
                    zzlVarZza = zzlVarZza;
                    break;
                }
                zzlVarZza = zza(strArrZza[i2], i);
                if (zzlVarZza.zza) {
                    break;
                }
                i2++;
            }
        } else {
            zzlVarZza = zzl.zza("no pkgs");
        }
        zzlVarZza.zzc();
        return zzlVarZza.zza;
    }

    private final zzl zza(String str, int i) {
        try {
            PackageInfo packageInfoZza = Wrappers.packageManager(this.zzb).zza(str, 64, i);
            boolean zHonorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb);
            if (packageInfoZza == null) {
                return zzl.zza("null pkg");
            }
            if (packageInfoZza.signatures != null && packageInfoZza.signatures.length == 1) {
                zzg zzgVar = new zzg(packageInfoZza.signatures[0].toByteArray());
                String str2 = packageInfoZza.packageName;
                zzl zzlVarZza = zzc.zza(str2, zzgVar, zHonorsDebugCertificates, false);
                return (!zzlVarZza.zza || packageInfoZza.applicationInfo == null || (packageInfoZza.applicationInfo.flags & 2) == 0 || !zzc.zza(str2, zzgVar, false, true).zza) ? zzlVarZza : zzl.zza("debuggable release cert app rejected");
            }
            return zzl.zza("single cert required");
        } catch (PackageManager.NameNotFoundException unused) {
            String strValueOf = String.valueOf(str);
            return zzl.zza(strValueOf.length() != 0 ? "no pkg ".concat(strValueOf) : new String("no pkg "));
        }
    }

    private final zzl zza(String str) {
        zzl zzlVarZza;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return zzl.zza("null pkg");
        }
        if (str.equals(this.zzc)) {
            return zzl.zza();
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(this.zzb).getPackageInfo(str, 64);
            boolean zHonorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb);
            if (packageInfo == null) {
                zzlVarZza = zzl.zza("null pkg");
            } else {
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr != null && signatureArr.length == 1) {
                    zzg zzgVar = new zzg(signatureArr[0].toByteArray());
                    String str2 = packageInfo.packageName;
                    zzl zzlVarZza2 = zzc.zza(str2, zzgVar, zHonorsDebugCertificates, false);
                    zzlVarZza = (!zzlVarZza2.zza || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !zzc.zza(str2, zzgVar, false, true).zza) ? zzlVarZza2 : zzl.zza("debuggable release cert app rejected");
                } else {
                    zzlVarZza = zzl.zza("single cert required");
                }
            }
            if (zzlVarZza.zza) {
                this.zzc = str;
            }
            return zzlVarZza;
        } catch (PackageManager.NameNotFoundException unused) {
            String strValueOf = String.valueOf(str);
            return zzl.zza(strValueOf.length() != 0 ? "no pkg ".concat(strValueOf) : new String("no pkg "));
        }
    }

    private static zzd zza(PackageInfo packageInfo, zzd... zzdVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzg zzgVar = new zzg(signatureArr[0].toByteArray());
        for (int i = 0; i < zzdVarArr.length; i++) {
            if (zzdVarArr[i].equals(zzgVar)) {
                return zzdVarArr[i];
            }
        }
        return null;
    }
}
