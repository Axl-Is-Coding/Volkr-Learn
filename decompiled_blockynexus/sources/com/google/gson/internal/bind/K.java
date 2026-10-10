package com.google.gson.internal.bind;

import com.google.gson.stream.JsonToken;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f14133a = new int[JsonToken.values().length];

    static {
        try {
            f14133a[JsonToken.NUMBER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f14133a[JsonToken.BOOLEAN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f14133a[JsonToken.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f14133a[JsonToken.NULL.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f14133a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f14133a[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f14133a[JsonToken.END_DOCUMENT.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f14133a[JsonToken.NAME.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f14133a[JsonToken.END_OBJECT.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f14133a[JsonToken.END_ARRAY.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
