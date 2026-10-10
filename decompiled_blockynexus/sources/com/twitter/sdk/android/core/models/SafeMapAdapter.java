package com.twitter.sdk.android.core.models;

import com.google.gson.reflect.TypeToken;
import com.google.gson.x;
import com.google.gson.y;

/* JADX INFO: loaded from: classes5.dex */
public class SafeMapAdapter implements y {
    @Override // com.google.gson.y
    public <T> x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken) {
        return new l(this, jVar.a(this, typeToken), typeToken);
    }
}
