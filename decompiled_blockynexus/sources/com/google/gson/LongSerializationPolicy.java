package com.google.gson;

/* JADX INFO: loaded from: classes2.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public p serialize(Long l) {
            return new t((Number) l);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public p serialize(Long l) {
            return new t(String.valueOf(l));
        }
    };

    public abstract p serialize(Long l);
}
