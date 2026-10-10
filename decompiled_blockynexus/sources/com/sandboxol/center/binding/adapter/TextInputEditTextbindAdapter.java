package com.sandboxol.center.binding.adapter;

import android.graphics.drawable.Drawable;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.textfield.TextInputEditText;

/* JADX INFO: loaded from: classes3.dex */
public class TextInputEditTextbindAdapter {
    public static void setTabLayout(TextInputEditText textInputEditText, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, float f2) {
        int height;
        if (f2 == WheelView.DividerConfig.FILL) {
            double height2 = textInputEditText.getHeight();
            Double.isNaN(height2);
            height = (int) (height2 * 0.65d);
        } else {
            height = (int) (textInputEditText.getHeight() * f2);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, height, height);
        }
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, height, height);
        }
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, height, height);
        }
        if (drawable4 != null) {
            drawable4.setBounds(0, 0, height, height);
        }
        textInputEditText.setCompoundDrawables(drawable, drawable3, drawable2, drawable4);
    }
}
