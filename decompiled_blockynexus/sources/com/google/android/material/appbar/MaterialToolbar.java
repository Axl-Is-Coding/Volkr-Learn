package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.s;
import com.google.android.material.l.i;
import com.google.android.material.l.j;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialToolbar extends Toolbar {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_Toolbar;

    public MaterialToolbar(Context context) {
        this(context, null);
    }

    private void initBackground(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            i iVar = new i();
            iVar.a(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            iVar.a(context);
            iVar.b(ViewCompat.i(this));
            ViewCompat.a(this, iVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.a(this);
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        j.a(this, f2);
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet, int i) {
        super(s.a(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        initBackground(getContext());
    }
}
