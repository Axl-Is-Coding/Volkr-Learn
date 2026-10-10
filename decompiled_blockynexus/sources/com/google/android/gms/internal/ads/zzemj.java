package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzemj<FieldDescriptorType> extends zzemk<FieldDescriptorType, Object> {
    zzemj(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.ads.zzemk
    public final void zzbec() {
        if (!isImmutable()) {
            for (int i = 0; i < zzbim(); i++) {
                Map.Entry<FieldDescriptorType, Object> entryZzhp = zzhp(i);
                if (((zzeju) entryZzhp.getKey()).zzbgc()) {
                    entryZzhp.setValue(Collections.unmodifiableList((List) entryZzhp.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : zzbin()) {
                if (((zzeju) entry.getKey()).zzbgc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzbec();
    }
}
