package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class A extends t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextWatcher f13647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextInputLayout.b f13648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextInputLayout.c f13649f;

    A(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f13647d = new x(this);
        this.f13648e = new y(this);
        this.f13649f = new z(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        EditText editText = this.f13683a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // com.google.android.material.textfield.t
    void a() {
        this.f13683a.setEndIconDrawable(androidx.appcompat.a.a.a.b(this.f13684b, R.drawable.design_password_eye));
        TextInputLayout textInputLayout = this.f13683a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.password_toggle_content_description));
        this.f13683a.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate$4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditText editText = this.f13656a.f13683a.getEditText();
                if (editText == null) {
                    return;
                }
                int selectionEnd = editText.getSelectionEnd();
                if (this.f13656a.c()) {
                    editText.setTransformationMethod(null);
                } else {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                if (selectionEnd >= 0) {
                    editText.setSelection(selectionEnd);
                }
            }
        });
        this.f13683a.addOnEditTextAttachedListener(this.f13648e);
        this.f13683a.addOnEndIconChangedListener(this.f13649f);
    }
}
