package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Collection;

/* JADX INFO: compiled from: DateSelector.java */
/* JADX INFO: loaded from: classes2.dex */
public interface e<S> extends Parcelable {
    Collection<androidx.core.f.d<Long, Long>> A();

    Collection<Long> B();

    S C();

    int a(Context context);

    View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, C2230b c2230b, y<S> yVar);

    void d(long j);
}
