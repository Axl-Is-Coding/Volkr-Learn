package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: MaterialTextInputPicker.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s<S> extends z<S> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e<S> f13335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C2230b f13336c;

    static <T> s<T> a(e<T> eVar, C2230b c2230b) {
        s<T> sVar = new s<>();
        Bundle bundle = new Bundle();
        bundle.putParcelable("DATE_SELECTOR_KEY", eVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", c2230b);
        sVar.setArguments(bundle);
        return sVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f13335b = (e) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f13336c = (C2230b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f13335b.a(layoutInflater, viewGroup, bundle, this.f13336c, new r(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f13335b);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f13336c);
    }
}
