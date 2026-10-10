package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import cn.qqtheme.framework.widget.WheelView;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaaq<T> {
    private final int zzclf;
    private final T zzclg;
    private final String zzcn;

    private zzaaq(int i, String str, T t) {
        this.zzclf = i;
        this.zzcn = str;
        this.zzclg = t;
        zzwm.zzpw().zza(this);
    }

    public static zzaaq<Boolean> zza(int i, String str, Boolean bool) {
        return new zzaap(i, str, bool);
    }

    public static zzaaq<Long> zzb(int i, String str, long j) {
        return new zzaar(1, str, Long.valueOf(j));
    }

    public final String getKey() {
        return this.zzcn;
    }

    public final int getSource() {
        return this.zzclf;
    }

    protected abstract T zza(SharedPreferences sharedPreferences);

    public abstract T zza(Bundle bundle);

    public abstract void zza(SharedPreferences.Editor editor, T t);

    protected abstract T zzb(JSONObject jSONObject);

    public final T zzrf() {
        return this.zzclg;
    }

    public static zzaaq<Integer> zza(int i, String str, int i2) {
        return new zzaas(1, str, Integer.valueOf(i2));
    }

    public static zzaaq<String> zzb(int i, String str) {
        zzaaq<String> zzaaqVarZza = zza(1, str, (String) null);
        zzwm.zzpw().zzc(zzaaqVarZza);
        return zzaaqVarZza;
    }

    public static zzaaq<Float> zza(int i, String str, float f2) {
        return new zzaau(1, str, Float.valueOf(WheelView.DividerConfig.FILL));
    }

    public static zzaaq<String> zza(int i, String str, String str2) {
        return new zzaat(1, str, str2);
    }

    /* synthetic */ zzaaq(int i, String str, Object obj, zzaap zzaapVar) {
        this(i, str, obj);
    }
}
