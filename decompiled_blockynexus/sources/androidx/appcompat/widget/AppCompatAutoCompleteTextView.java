package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import androidx.core.widget.TextViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatAutoCompleteTextView extends AutoCompleteTextView implements androidx.core.view.v {
    private static final int[] TINT_ATTRS = {R.attr.popupBackground};
    private final C0303p mBackgroundTintHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatAutoCompleteTextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.a();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.a();
        }
    }

    @Override // androidx.core.view.v
    public ColorStateList getSupportBackgroundTintList() {
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            return c0303p.b();
        }
        return null;
    }

    @Override // androidx.core.view.v
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            return c0303p.c();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        C0306t.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    @Override // androidx.core.view.v
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.b(colorStateList);
        }
    }

    @Override // androidx.core.view.v
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.a(context, i);
        }
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.autoCompleteTextViewStyle);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(fa.a(context), attributeSet, i);
        ia iaVarA = ia.a(getContext(), attributeSet, TINT_ATTRS, i, 0);
        if (iaVarA.g(0)) {
            setDropDownBackgroundDrawable(iaVarA.b(0));
        }
        iaVarA.a();
        this.mBackgroundTintHelper = new C0303p(this);
        this.mBackgroundTintHelper.a(attributeSet, i);
        this.mTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper.a(attributeSet, i);
        this.mTextHelper.a();
    }
}
