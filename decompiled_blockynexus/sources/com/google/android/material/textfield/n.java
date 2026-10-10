package com.google.android.material.textfield;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class n implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AutoCompleteTextView f13674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ s f13675b;

    n(s sVar, AutoCompleteTextView autoCompleteTextView) {
        this.f13675b = sVar;
        this.f13674a = autoCompleteTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f13675b.d()) {
                this.f13675b.h = false;
            }
            this.f13675b.d(this.f13674a);
            view.performClick();
        }
        return false;
    }
}
