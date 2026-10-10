package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzmc;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjz {
    private static final zzmk zzaox = new zzkc();
    private static final Pattern zzaoy = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zzahp = -1;
    public int zzahq = -1;

    public final boolean zzb(zzmc zzmcVar) {
        for (int i = 0; i < zzmcVar.length(); i++) {
            zzmc.zza zzaVarZzba = zzmcVar.zzba(i);
            if (zzaVarZzba instanceof zzmi) {
                zzmi zzmiVar = (zzmi) zzaVarZzba;
                if (zzb(zzmiVar.description, zzmiVar.text)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean zzgs() {
        return (this.zzahp == -1 || this.zzahq == -1) ? false : true;
    }

    private final boolean zzb(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = zzaoy.matcher(str2);
        if (matcher.find()) {
            try {
                int i = Integer.parseInt(matcher.group(1), 16);
                int i2 = Integer.parseInt(matcher.group(2), 16);
                if (i > 0 || i2 > 0) {
                    this.zzahp = i;
                    this.zzahq = i2;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }
}
