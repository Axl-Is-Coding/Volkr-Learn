package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.v.C0929a;
import com.sandboxol.common.binding.adapter.EditTextBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: FragmentForgetPasswordByEmailBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Qd extends Pd {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7801b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7802c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f7803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final EditText f7804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Button f7805f;
    private long g;

    public Qd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f7801b, f7802c));
    }

    public void a(C0929a c0929a) {
        updateRegistration(0, c0929a);
        this.f7769a = c0929a;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(276);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand<String> replyCommand;
        ReplyCommand replyCommand2;
        boolean zSafeUnbox;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        C0929a c0929a = this.f7769a;
        long j2 = 7 & j;
        if (j2 != 0) {
            if ((j & 5) == 0 || c0929a == null) {
                replyCommand = null;
                replyCommand2 = null;
            } else {
                replyCommand = c0929a.f10246c;
                replyCommand2 = c0929a.f10245b;
            }
            ObservableField<Boolean> observableField = c0929a != null ? c0929a.f10244a : null;
            updateRegistration(1, observableField);
            zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
        } else {
            replyCommand = null;
            replyCommand2 = null;
            zSafeUnbox = false;
        }
        if ((j & 5) != 0) {
            EditTextBindingAdapters.editTextCommand(this.f7804e, null, null, replyCommand);
            ViewBindingAdapters.clickCommand(this.f7805f, replyCommand2, false, 0);
        }
        if (j2 != 0) {
            this.f7805f.setEnabled(zSafeUnbox);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.g = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((C0929a) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<Boolean>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (276 != i) {
            return false;
        }
        a((C0929a) obj);
        return true;
    }

    private Qd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2);
        this.g = -1L;
        this.f7803d = (LinearLayout) objArr[0];
        this.f7803d.setTag(null);
        this.f7804e = (EditText) objArr[1];
        this.f7804e.setTag(null);
        this.f7805f = (Button) objArr[2];
        this.f7805f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(C0929a c0929a, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }
}
