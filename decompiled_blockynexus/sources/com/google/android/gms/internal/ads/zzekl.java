package com.google.android.gms.internal.ads;

import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public enum zzekl {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(WheelView.DividerConfig.FILL)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzeip.class, zzeip.class, zzeip.zzier),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);

    private final Class<?> zzikn;
    private final Class<?> zziko;
    private final Object zzikp;

    zzekl(Class cls, Class cls2, Object obj) {
        this.zzikn = cls;
        this.zziko = cls2;
        this.zzikp = obj;
    }

    public final Class<?> zzbhg() {
        return this.zziko;
    }
}
