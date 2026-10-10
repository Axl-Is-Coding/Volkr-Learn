package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.EditTextBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.df, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentResetPasswordBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0558df extends AbstractC0546cf {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8262b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8263c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final EditText f8265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EditText f8266f;
    private final Button g;
    private long h;

    public C0558df(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f8262b, f8263c));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0546cf
    public void a(com.disabngo.blockynexus.e.b.ba.h hVar) {
        updateRegistration(1, hVar);
        this.f8232a = hVar;
        synchronized (this) {
            this.h |= 2;
        }
        notifyPropertyChanged(423);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand<String> replyCommand;
        ReplyCommand replyCommand2;
        ReplyCommand<String> replyCommand3;
        boolean zSafeUnbox;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        com.disabngo.blockynexus.e.b.ba.h hVar = this.f8232a;
        long j2 = 7 & j;
        if (j2 != 0) {
            if ((j & 6) == 0 || hVar == null) {
                replyCommand = null;
                replyCommand2 = null;
                replyCommand3 = null;
            } else {
                replyCommand = hVar.j;
                replyCommand2 = hVar.l;
                replyCommand3 = hVar.k;
            }
            ObservableField<Boolean> observableField = hVar != null ? hVar.i : null;
            updateRegistration(0, observableField);
            zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
        } else {
            replyCommand = null;
            replyCommand2 = null;
            replyCommand3 = null;
            zSafeUnbox = false;
        }
        if ((j & 6) != 0) {
            EditTextBindingAdapters.editTextCommand(this.f8265e, null, null, replyCommand);
            EditTextBindingAdapters.editTextCommand(this.f8266f, null, null, replyCommand3);
            ViewBindingAdapters.clickCommand(this.g, replyCommand2, false, 0);
        }
        if (j2 != 0) {
            this.g.setEnabled(zSafeUnbox);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.ba.h) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (423 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ba.h) obj);
        return true;
    }

    private C0558df(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2);
        this.h = -1L;
        this.f8264d = (LinearLayout) objArr[0];
        this.f8264d.setTag(null);
        this.f8265e = (EditText) objArr[1];
        this.f8265e.setTag(null);
        this.f8266f = (EditText) objArr[2];
        this.f8266f.setTag(null);
        this.g = (Button) objArr[3];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.ba.h hVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 2;
        }
        return true;
    }
}
