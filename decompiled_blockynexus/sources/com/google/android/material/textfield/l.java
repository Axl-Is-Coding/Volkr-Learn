package com.google.android.material.textfield;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class l extends TextInputLayout.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ s f13672e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    l(s sVar, TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f13672e = sVar;
    }

    @Override // com.google.android.material.textfield.TextInputLayout.a, androidx.core.view.C0313a
    public void a(View view, androidx.core.view.accessibility.b bVar) {
        super.a(view, bVar);
        bVar.b((CharSequence) Spinner.class.getName());
        if (bVar.v()) {
            bVar.e((CharSequence) null);
        }
    }

    @Override // androidx.core.view.C0313a
    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        s sVar = this.f13672e;
        AutoCompleteTextView autoCompleteTextViewA = sVar.a(sVar.f13683a.getEditText());
        if (accessibilityEvent.getEventType() == 1 && this.f13672e.m.isTouchExplorationEnabled()) {
            this.f13672e.d(autoCompleteTextViewA);
        }
    }
}
