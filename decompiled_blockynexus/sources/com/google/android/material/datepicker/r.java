package com.google.android.material.datepicker;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: compiled from: MaterialTextInputPicker.java */
/* JADX INFO: loaded from: classes2.dex */
class r<S> implements y<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f13334a;

    r(s sVar) {
        this.f13334a = sVar;
    }

    @Override // com.google.android.material.datepicker.y
    public void a(S s) {
        Iterator<y<S>> it = this.f13334a.f13356a.iterator();
        while (it.hasNext()) {
            it.next().a(s);
        }
    }
}
