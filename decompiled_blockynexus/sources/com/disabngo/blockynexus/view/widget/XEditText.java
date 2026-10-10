package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.disabngo.blockynexus.R;

/* JADX INFO: loaded from: classes.dex */
public class XEditText extends AppCompatEditText implements TextWatcher, View.OnFocusChangeListener {
    private Drawable clearDrawable;
    private boolean hasFocus;

    public XEditText(Context context) {
        this(context, null);
    }

    private void init() {
        this.clearDrawable = getCompoundDrawables()[2];
        if (this.clearDrawable == null) {
            this.clearDrawable = androidx.appcompat.a.a.a.b(getContext(), R.mipmap.ic_clear);
        }
        Drawable drawable = this.clearDrawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.clearDrawable.getIntrinsicHeight());
        }
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
        setDrawableVisible(false);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        this.hasFocus = z;
        if (!z || getText().length() <= 0) {
            setDrawableVisible(false);
        } else {
            setDrawableVisible(true);
        }
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.hasFocus) {
            setDrawableVisible(charSequence.length() > 0);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && getCompoundDrawables()[2] != null) {
            if (motionEvent.getX() > ((float) ((getWidth() - getTotalPaddingRight()) + getPaddingRight())) && motionEvent.getX() < ((float) getWidth())) {
                setText("");
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void setDrawableVisible(boolean z) {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], z ? this.clearDrawable : null, getCompoundDrawables()[3]);
    }

    public XEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public XEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
