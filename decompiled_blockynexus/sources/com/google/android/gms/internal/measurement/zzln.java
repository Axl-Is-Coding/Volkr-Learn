package com.google.android.gms.internal.measurement;

import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public enum zzln {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(WheelView.DividerConfig.FILL)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzgp.zza),
    ENUM(null),
    MESSAGE(null);

    private final Object zzj;

    zzln(Object obj) {
        this.zzj = obj;
    }
}
