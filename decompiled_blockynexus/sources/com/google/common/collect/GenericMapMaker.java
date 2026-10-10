package com.google.common.collect;

import com.google.common.collect.MapMaker;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
abstract class GenericMapMaker<K0, V0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    MapMaker.a<K0, V0> f13825a;

    enum NullListener implements MapMaker.a<Object, Object> {
        INSTANCE;

        @Override // com.google.common.collect.MapMaker.a
        public void onRemoval(MapMaker.RemovalNotification<Object, Object> removalNotification) {
        }
    }

    GenericMapMaker() {
    }

    <K extends K0, V extends V0> MapMaker.a<K, V> a() {
        return (MapMaker.a) com.google.common.base.j.a(this.f13825a, NullListener.INSTANCE);
    }
}
