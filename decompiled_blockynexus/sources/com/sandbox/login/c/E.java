package com.sandbox.login.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandbox.login.R;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: LoginFragmentRegisterBindingSw600dpImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class E extends C {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final ConstraintLayout i;
    private final ImageView j;
    private final ImageView k;
    private long l;

    static {
        h.put(R.id.bg_title, 5);
        h.put(R.id.bg_step, 6);
        h.put(R.id.fl_frg, 7);
    }

    public E(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, g, h));
    }

    @Override // com.sandbox.login.c.C
    public void a(com.sandbox.login.view.fragment.register.e eVar) {
        updateRegistration(0, eVar);
        this.f15606f = eVar;
        synchronized (this) {
            this.l |= 1;
        }
        notifyPropertyChanged(com.sandbox.login.g.f15905b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        int colorFromResource;
        int colorFromResource2;
        int colorFromResource3;
        int i;
        TextView textView;
        int i2;
        TextView textView2;
        int i3;
        long j2;
        long j3;
        synchronized (this) {
            j = this.l;
            this.l = 0L;
        }
        com.sandbox.login.view.fragment.register.e eVar = this.f15606f;
        long j4 = j & 7;
        if (j4 != 0) {
            ObservableField<Boolean> observableField = eVar != null ? eVar.f16000e : null;
            updateRegistration(1, observableField);
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            if (j4 != 0) {
                if (zSafeUnbox) {
                    j2 = j | 16 | 64 | 256;
                    j3 = 1024;
                } else {
                    j2 = j | 8 | 32 | 128;
                    j3 = 512;
                }
                j = j2 | j3;
            }
            if (zSafeUnbox) {
                textView = this.f15604d;
                i2 = R.color.login_step_2_text_color;
            } else {
                textView = this.f15604d;
                i2 = R.color.login_tips_color_2;
            }
            colorFromResource = ViewDataBinding.getColorFromResource(textView, i2);
            if (zSafeUnbox) {
                textView2 = this.f15605e;
                i3 = R.color.login_tips_color_2;
            } else {
                textView2 = this.f15605e;
                i3 = R.color.login_step_2_text_color;
            }
            colorFromResource2 = ViewDataBinding.getColorFromResource(textView2, i3);
            colorFromResource3 = zSafeUnbox ? ViewDataBinding.getColorFromResource(this.f15605e, R.color.login_register_step_1) : ViewDataBinding.getColorFromResource(this.f15605e, R.color.login_bg_step);
            i = zSafeUnbox ? 8 : 0;
            replyCommand = ((j & 5) == 0 || eVar == null) ? null : eVar.f16001f;
        } else {
            replyCommand = null;
            colorFromResource = 0;
            colorFromResource2 = 0;
            colorFromResource3 = 0;
            i = 0;
        }
        if ((5 & j) != 0) {
            ViewBindingAdapters.clickCommand(this.j, replyCommand, false, 0);
        }
        if ((j & 7) != 0) {
            this.k.setVisibility(i);
            this.f15604d.setTextColor(colorFromResource);
            ViewBindingAdapters.backgroundColor(this.f15605e, colorFromResource3);
            this.f15605e.setTextColor(colorFromResource2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.l = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.sandbox.login.view.fragment.register.e) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<Boolean>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandbox.login.g.f15905b != i) {
            return false;
        }
        a((com.sandbox.login.view.fragment.register.e) obj);
        return true;
    }

    private E(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (View) objArr[6], (View) objArr[5], (FrameLayout) objArr[7], (TextView) objArr[2], (TextView) objArr[3]);
        this.l = -1L;
        this.i = (ConstraintLayout) objArr[0];
        this.i.setTag(null);
        this.j = (ImageView) objArr[1];
        this.j.setTag(null);
        this.k = (ImageView) objArr[4];
        this.k.setTag(null);
        this.f15604d.setTag(null);
        this.f15605e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandbox.login.view.fragment.register.e eVar, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }
}
