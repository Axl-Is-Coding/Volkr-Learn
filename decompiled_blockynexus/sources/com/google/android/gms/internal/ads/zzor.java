package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzor extends zzos {
    private final int responseCode;
    private final Map<String, List<String>> zzbjd;

    public zzor(int i, Map<String, List<String>> map, zzon zzonVar) {
        StringBuilder sb = new StringBuilder(26);
        sb.append("Response code: ");
        sb.append(i);
        super(sb.toString(), zzonVar, 1);
        this.responseCode = i;
        this.zzbjd = map;
    }
}
