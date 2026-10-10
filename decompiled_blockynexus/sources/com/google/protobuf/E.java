package com.google.protobuf;

import com.google.protobuf.C2308n;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* JADX INFO: compiled from: SmallSortedMap.java */
/* JADX INFO: loaded from: classes2.dex */
class E<FieldDescriptorType> extends H<FieldDescriptorType, Object> {
    E(int i) {
        super(i, null);
    }

    @Override // com.google.protobuf.H
    public void e() {
        if (!d()) {
            for (int i = 0; i < a(); i++) {
                Map.Entry<FieldDescriptorType, Object> entryA = a(i);
                if (((C2308n.a) entryA.getKey()).j()) {
                    entryA.setValue(Collections.unmodifiableList((List) entryA.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : c()) {
                if (((C2308n.a) entry.getKey()).j()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.e();
    }

    @Override // com.google.protobuf.H, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return super.put((C2308n.a) obj, obj2);
    }
}
