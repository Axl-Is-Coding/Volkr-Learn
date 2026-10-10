package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.dialog.DialogC1114ra;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.kb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogApplyFriendBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0630kb extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f8508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f8509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EditText f8510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected DialogC1114ra f8511d;

    protected AbstractC0630kb(Object obj, View view, int i, Button button, Button button2, EditText editText) {
        super(obj, view, i);
        this.f8508a = button;
        this.f8509b = button2;
        this.f8510c = editText;
    }

    public abstract void a(DialogC1114ra dialogC1114ra);
}
