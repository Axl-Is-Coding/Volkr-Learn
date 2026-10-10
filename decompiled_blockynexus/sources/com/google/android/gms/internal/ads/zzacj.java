package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzacj<T> extends zzaci<T> {
    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;TT;Ljava/lang/Integer;)V */
    protected zzacj(String str, Object obj, int i) {
        super(str, obj, i);
    }

    public static zzaci<Boolean> zzg(String str, boolean z) {
        return new zzacj(str, true, zzack.zzczw);
    }

    @Override // com.google.android.gms.internal.ads.zzaci
    public final T get() {
        if (zzadj.zzdcx.get()) {
            return (T) super.get();
        }
        throw new IllegalStateException("Striped code is accessed: 54c42518-856a-44fb-aae0-cd6676d514e5");
    }
}
