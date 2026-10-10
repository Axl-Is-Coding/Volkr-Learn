package com.google.gson.internal.bind;

import com.google.gson.stream.JsonToken;

/* JADX INFO: renamed from: com.google.gson.internal.bind.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObjectTypeAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class C2279g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f14194a = new int[JsonToken.values().length];

    static {
        try {
            f14194a[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f14194a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f14194a[JsonToken.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f14194a[JsonToken.NUMBER.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f14194a[JsonToken.BOOLEAN.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f14194a[JsonToken.NULL.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
