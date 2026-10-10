package com.google.android.material.button;

import java.util.Comparator;

/* JADX INFO: compiled from: MaterialButtonToggleGroup.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements Comparator<MaterialButton> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MaterialButtonToggleGroup f13246a;

    b(MaterialButtonToggleGroup materialButtonToggleGroup) {
        this.f13246a = materialButtonToggleGroup;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
        int iCompareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
        return iCompareTo2 != 0 ? iCompareTo2 : Integer.valueOf(this.f13246a.indexOfChild(materialButton)).compareTo(Integer.valueOf(this.f13246a.indexOfChild(materialButton2)));
    }
}
