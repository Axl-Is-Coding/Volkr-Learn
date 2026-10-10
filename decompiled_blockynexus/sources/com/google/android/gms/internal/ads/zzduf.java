package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzduf {
    private final Context zzvr;
    private final zzdtc zzvw;

    public zzduf(Context context, zzdtc zzdtcVar) {
        this.zzvr = context;
        this.zzvw = zzdtcVar;
    }

    private final String zzawj() {
        HashSet hashSet = new HashSet(Arrays.asList("i686", "armv71"));
        String strValue = zzdwc.OS_ARCH.value();
        if (!TextUtils.isEmpty(strValue) && hashSet.contains(strValue)) {
            return strValue;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (IllegalAccessException e2) {
            zzdtc zzdtcVar = this.zzvw;
            if (zzdtcVar != null) {
                zzdtcVar.zza(2024, 0L, e2);
            }
        } catch (NoSuchFieldException e3) {
            zzdtc zzdtcVar2 = this.zzvw;
            if (zzdtcVar2 != null) {
                zzdtcVar2.zza(2024, 0L, e3);
            }
        }
        String str = Build.CPU_ABI;
        return str != null ? str : Build.CPU_ABI2;
    }

    private final zzgo zzawk() {
        FileInputStream fileInputStream;
        byte[] bArr;
        File file = new File(new File(this.zzvr.getApplicationInfo().dataDir), "lib");
        if (!file.exists()) {
            return zzgo.UNSUPPORTED;
        }
        File[] fileArrListFiles = file.listFiles(new zzdxk(Pattern.compile(".*\\.so$", 2)));
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return zzgo.UNSUPPORTED;
        }
        try {
            fileInputStream = new FileInputStream(fileArrListFiles[0]);
            try {
                bArr = new byte[20];
            } finally {
            }
        } catch (IOException unused) {
        }
        if (fileInputStream.read(bArr) != 20) {
            fileInputStream.close();
            return zzgo.UNSUPPORTED;
        }
        byte[] bArr2 = {0, 0};
        if (bArr[5] == 2) {
            zzj(bArr);
            zzgo zzgoVar = zzgo.UNSUPPORTED;
            fileInputStream.close();
            return zzgoVar;
        }
        bArr2[0] = bArr[19];
        bArr2[1] = bArr[18];
        short s = ByteBuffer.wrap(bArr2).getShort();
        if (s == 3) {
            zzgo zzgoVar2 = zzgo.X86;
            fileInputStream.close();
            return zzgoVar2;
        }
        if (s == 40) {
            zzgo zzgoVar3 = zzgo.ARM7;
            fileInputStream.close();
            return zzgoVar3;
        }
        if (s == 62) {
            zzgo zzgoVar4 = zzgo.X86_64;
            fileInputStream.close();
            return zzgoVar4;
        }
        if (s != 183) {
            zzgo zzgoVar5 = zzgo.UNSUPPORTED;
            fileInputStream.close();
            return zzgoVar5;
        }
        zzgo zzgoVar6 = zzgo.ARM64;
        fileInputStream.close();
        return zzgoVar6;
    }

    private final void zzj(byte[] bArr) {
        if (this.zzvw == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("os.arch:");
        sb.append(zzdwc.OS_ARCH.value());
        sb.append(";");
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null) {
                sb.append("supported_abis:");
                sb.append(Arrays.toString(strArr));
                sb.append(";");
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        sb.append("CPU_ABI:");
        sb.append(Build.CPU_ABI);
        sb.append(";");
        sb.append("CPU_ABI2:");
        sb.append(Build.CPU_ABI2);
        sb.append(";");
        if (bArr != null) {
            sb.append("ELF:");
            sb.append(Arrays.toString(bArr));
            sb.append(";");
        }
        this.zzvw.zzg(4007, sb.toString());
    }

    public final zzgo zzawl() {
        zzgo zzgoVarZzawk = zzawk();
        if (zzgoVarZzawk != zzgo.UNSUPPORTED) {
            return zzgoVarZzawk;
        }
        String strZzawj = zzawj();
        if (!TextUtils.isEmpty(strZzawj)) {
            if (strZzawj.equalsIgnoreCase("i686") || strZzawj.equalsIgnoreCase("x86")) {
                return zzgo.X86;
            }
            if (strZzawj.equalsIgnoreCase("x86_64")) {
                return zzgo.X86_64;
            }
            if (strZzawj.equalsIgnoreCase("arm64-v8a")) {
                return zzgo.ARM64;
            }
            if (strZzawj.equalsIgnoreCase("armeabi-v7a") || strZzawj.equalsIgnoreCase("armv71")) {
                return zzgo.ARM7;
            }
        }
        zzj(null);
        return zzgo.UNSUPPORTED;
    }
}
