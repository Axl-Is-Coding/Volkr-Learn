package com.sandbox.login.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sandbox.login.R;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.binding.adapter.EditTextBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: LoginFragmentSetAccountBindingImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class G extends F {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f15610d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f15611e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f15612f;
    private final TextView g;
    private final Button h;
    private long i;

    static {
        f15611e.put(R.id.til_name, 4);
    }

    public G(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f15610d, f15611e));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.i |= 2;
        }
        return true;
    }

    @Override // com.sandbox.login.c.F
    public void a(com.sandbox.login.f.a.a.i iVar) {
        updateRegistration(2, iVar);
        this.f15609c = iVar;
        synchronized (this) {
            this.i |= 4;
        }
        notifyPropertyChanged(com.sandbox.login.g.f15905b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean zSafeUnbox;
        ReplyCommand<String> replyCommand;
        ReplyCommand replyCommand2;
        String strA;
        synchronized (this) {
            j = this.i;
            this.i = 0L;
        }
        com.sandbox.login.f.a.a.i iVar = this.f15609c;
        long j2 = 22 & j;
        if (j2 != 0) {
            if ((j & 20) == 0 || iVar == null) {
                replyCommand = null;
                replyCommand2 = null;
            } else {
                replyCommand = iVar.f15769d;
                replyCommand2 = iVar.f15770e;
            }
            ObservableField<Boolean> observableField = iVar != null ? iVar.f15768c : null;
            updateRegistration(1, observableField);
            zSafeUnbox = ViewDataBinding.safeUnbox(Boolean.valueOf(!ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null)));
        } else {
            zSafeUnbox = false;
            replyCommand = null;
            replyCommand2 = null;
        }
        long j3 = 24 & j;
        if (j3 != 0) {
            ObservableField<Long> observableField2 = AccountCenter.newInstance().userId;
            updateRegistration(3, observableField2);
            strA = com.sandbox.login.e.i.a(ViewDataBinding.safeUnbox(observableField2 != null ? observableField2.get() : null));
        } else {
            strA = null;
        }
        if (j3 != 0) {
            androidx.databinding.a.e.a(this.g, strA);
        }
        if (j2 != 0) {
            this.h.setClickable(zSafeUnbox);
            this.h.setEnabled(zSafeUnbox);
            ViewBindingAdapters.isEnable(this.h, zSafeUnbox);
        }
        if ((j & 20) != 0) {
            ViewBindingAdapters.clickCommand(this.h, replyCommand2, false, 0);
            EditTextBindingAdapters.editTextCommand(this.f15608b, null, null, replyCommand);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.i = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((AccountCenter) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i == 2) {
            return a((com.sandbox.login.f.a.a.i) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return a((ObservableField<Long>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandbox.login.g.f15905b != i) {
            return false;
        }
        a((com.sandbox.login.f.a.a.i) obj);
        return true;
    }

    private G(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (TextInputLayout) objArr[4], (TextInputEditText) objArr[2]);
        this.i = -1L;
        this.f15612f = (LinearLayout) objArr[0];
        this.f15612f.setTag(null);
        this.g = (TextView) objArr[1];
        this.g.setTag(null);
        this.h = (Button) objArr[3];
        this.h.setTag(null);
        this.f15608b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.i |= 1;
        }
        return true;
    }

    private boolean a(com.sandbox.login.f.a.a.i iVar, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.i |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<Long> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.i |= 8;
        }
        return true;
    }
}
