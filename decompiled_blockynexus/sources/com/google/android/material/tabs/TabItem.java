package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ia;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ia iaVarA = ia.a(context, attributeSet, R.styleable.TabItem);
        this.text = iaVarA.e(R.styleable.TabItem_android_text);
        this.icon = iaVarA.b(R.styleable.TabItem_android_icon);
        this.customLayout = iaVarA.g(R.styleable.TabItem_android_layout, 0);
        iaVarA.a();
    }
}
