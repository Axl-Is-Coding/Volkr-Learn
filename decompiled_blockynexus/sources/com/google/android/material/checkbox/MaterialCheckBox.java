package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.c;
import com.google.android.material.R;
import com.google.android.material.d.a;
import com.google.android.material.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_CompoundButton_CheckBox;
    private static final int[][] ENABLED_CHECKED_STATES = {new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    private ColorStateList materialThemeColorsTintList;
    private boolean useMaterialThemeColors;

    public MaterialCheckBox(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList == null) {
            int[] iArr = new int[ENABLED_CHECKED_STATES.length];
            int iA = a.a(this, R.attr.colorControlActivated);
            int iA2 = a.a(this, R.attr.colorSurface);
            int iA3 = a.a(this, R.attr.colorOnSurface);
            iArr[0] = a.a(iA2, iA, 1.0f);
            iArr[1] = a.a(iA2, iA3, 0.54f);
            iArr[2] = a.a(iA2, iA3, 0.38f);
            iArr[3] = a.a(iA2, iA3, 0.38f);
            this.materialThemeColorsTintList = new ColorStateList(ENABLED_CHECKED_STATES, iArr);
        }
        return this.materialThemeColorsTintList;
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.useMaterialThemeColors = z;
        if (z) {
            c.a(this, getMaterialThemeColorsTintList());
        } else {
            c.a(this, (ColorStateList) null);
        }
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(s.a(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        Context context2 = getContext();
        TypedArray typedArrayA = s.a(context2, attributeSet, R.styleable.MaterialCheckBox, i, DEF_STYLE_RES, new int[0]);
        if (typedArrayA.hasValue(R.styleable.MaterialCheckBox_buttonTint)) {
            c.a(this, com.google.android.material.i.c.a(context2, typedArrayA, R.styleable.MaterialCheckBox_buttonTint));
        }
        this.useMaterialThemeColors = typedArrayA.getBoolean(R.styleable.MaterialCheckBox_useMaterialThemeColors, false);
        typedArrayA.recycle();
    }
}
