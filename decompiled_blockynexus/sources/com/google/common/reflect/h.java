package com.google.common.reflect;

import com.google.common.reflect.g;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: compiled from: TypeResolver.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends g.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TypeVariable f14003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ g.b f14004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ g.b f14005d;

    h(g.b bVar, TypeVariable typeVariable, g.b bVar2) {
        this.f14005d = bVar;
        this.f14003b = typeVariable;
        this.f14004c = bVar2;
    }

    @Override // com.google.common.reflect.g.b
    public Type a(TypeVariable<?> typeVariable, g.b bVar) {
        return typeVariable.getGenericDeclaration().equals(this.f14003b.getGenericDeclaration()) ? typeVariable : this.f14004c.a(typeVariable, bVar);
    }
}
