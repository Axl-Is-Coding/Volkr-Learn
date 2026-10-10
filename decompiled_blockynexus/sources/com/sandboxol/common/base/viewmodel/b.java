package com.sandboxol.common.base.viewmodel;

import rx.functions.Action1;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Action1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ObservableItemList f16858a;

    @Override // rx.functions.Action1
    public final void call(Object obj) {
        this.f16858a.remove((ListItemViewModel) obj);
    }
}
