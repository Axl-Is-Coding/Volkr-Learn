package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdow {
    private final Pattern zzhfo;

    @VisibleForTesting
    public zzdow() {
        Pattern patternCompile;
        try {
            patternCompile = Pattern.compile((String) zzwm.zzpx().zzd(zzabb.zzcxo));
        } catch (PatternSyntaxException unused) {
            patternCompile = null;
        }
        this.zzhfo = patternCompile;
    }

    public final String zzgu(String str) {
        Pattern pattern = this.zzhfo;
        if (pattern != null && str != null) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher.group();
            }
        }
        return null;
    }
}
