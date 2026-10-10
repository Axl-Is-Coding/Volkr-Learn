package com.google.firebase.components;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class Component$$Lambda$3 implements ComponentFactory {
    private final Object arg$1;

    private Component$$Lambda$3(Object obj) {
        this.arg$1 = obj;
    }

    public static ComponentFactory lambdaFactory$(Object obj) {
        return new Component$$Lambda$3(obj);
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        Object obj = this.arg$1;
        Component.lambda$intoSet$2(obj, componentContainer);
        return obj;
    }
}
