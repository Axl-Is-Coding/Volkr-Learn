package com.google.gson.internal.bind;

import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements com.google.gson.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.internal.p f14132a;

    public JsonAdapterAnnotationTypeAdapterFactory(com.google.gson.internal.p pVar) {
        this.f14132a = pVar;
    }

    @Override // com.google.gson.y
    public <T> com.google.gson.x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) typeToken.getRawType().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (com.google.gson.x<T>) a(this.f14132a, jVar, typeToken, bVar);
    }

    com.google.gson.x<?> a(com.google.gson.internal.p pVar, com.google.gson.j jVar, TypeToken<?> typeToken, com.google.gson.a.b bVar) {
        com.google.gson.x<?> treeTypeAdapter;
        Object objA = pVar.a(TypeToken.get((Class) bVar.value())).a();
        if (objA instanceof com.google.gson.x) {
            treeTypeAdapter = (com.google.gson.x) objA;
        } else if (objA instanceof com.google.gson.y) {
            treeTypeAdapter = ((com.google.gson.y) objA).a(jVar, typeToken);
        } else {
            boolean z = objA instanceof com.google.gson.v;
            if (!z && !(objA instanceof com.google.gson.o)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            treeTypeAdapter = new TreeTypeAdapter<>(z ? (com.google.gson.v) objA : null, objA instanceof com.google.gson.o ? (com.google.gson.o) objA : null, jVar, typeToken, null);
        }
        return (treeTypeAdapter == null || !bVar.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.a();
    }
}
