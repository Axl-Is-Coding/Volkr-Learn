package com.sandbox.login.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sandbox.login.R;
import com.sandboxol.common.binding.adapter.EditTextBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: LoginRegisterStep1BindingImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class I extends H {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l = new SparseIntArray();
    private final ConstraintLayout m;
    private final Button n;
    private long o;

    static {
        l.put(R.id.inputAccount, 6);
        l.put(R.id.inputPassword, 7);
        l.put(R.id.inputPassword1, 8);
        l.put(R.id.bg_protocol, 9);
        l.put(R.id.cb_pro, 10);
    }

    public I(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, k, l));
    }

    @Override // com.sandbox.login.c.H
    public void a(com.sandbox.login.f.a.f.l lVar) {
        updateRegistration(1, lVar);
        this.j = lVar;
        synchronized (this) {
            this.o |= 2;
        }
        notifyPropertyChanged(com.sandbox.login.g.f15907d);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        ReplyCommand<String> replyCommand;
        ReplyCommand<String> replyCommand2;
        ReplyCommand replyCommand3;
        ReplyCommand replyCommand4;
        ReplyCommand<String> replyCommand5;
        synchronized (this) {
            j = this.o;
            this.o = 0L;
        }
        com.sandbox.login.f.a.f.l lVar = this.j;
        long j2 = 7 & j;
        if (j2 != 0) {
            if ((j & 6) == 0 || lVar == null) {
                replyCommand = null;
                replyCommand2 = null;
                replyCommand3 = null;
                replyCommand4 = null;
                replyCommand5 = null;
            } else {
                ReplyCommand<String> replyCommand6 = lVar.j;
                replyCommand3 = lVar.f15892e;
                replyCommand4 = lVar.f15893f;
                replyCommand5 = lVar.h;
                replyCommand2 = lVar.g;
                replyCommand = replyCommand6;
            }
            ObservableField<String> observableField = lVar != null ? lVar.i : null;
            updateRegistration(0, observableField);
            str = observableField != null ? observableField.get() : null;
        } else {
            str = null;
            replyCommand = null;
            replyCommand2 = null;
            replyCommand3 = null;
            replyCommand4 = null;
            replyCommand5 = null;
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.f15615c, str);
        }
        if ((j & 6) != 0) {
            EditTextBindingAdapters.editTextCommand(this.f15615c, null, null, replyCommand);
            EditTextBindingAdapters.editTextCommand(this.f15616d, null, null, replyCommand2);
            EditTextBindingAdapters.editTextCommand(this.f15617e, null, null, replyCommand5);
            ViewBindingAdapters.clickCommand(this.n, replyCommand3, false, 0);
            ViewBindingAdapters.clickCommand(this.i, replyCommand4, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((com.sandbox.login.f.a.f.l) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandbox.login.g.f15907d != i) {
            return false;
        }
        a((com.sandbox.login.f.a.f.l) obj);
        return true;
    }

    private I(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (View) objArr[9], (CheckBox) objArr[10], (TextInputEditText) objArr[1], (TextInputEditText) objArr[2], (TextInputEditText) objArr[3], (TextInputLayout) objArr[6], (TextInputLayout) objArr[7], (TextInputLayout) objArr[8], (TextView) objArr[5]);
        this.o = -1L;
        this.f15615c.setTag(null);
        this.f15616d.setTag(null);
        this.f15617e.setTag(null);
        this.m = (ConstraintLayout) objArr[0];
        this.m.setTag(null);
        this.n = (Button) objArr[4];
        this.n.setTag(null);
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.o |= 1;
        }
        return true;
    }

    private boolean a(com.sandbox.login.f.a.f.l lVar, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.o |= 2;
        }
        return true;
    }
}
