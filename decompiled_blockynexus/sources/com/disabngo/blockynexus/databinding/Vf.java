package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.EditTextBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: FragmentTribeNoticeBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Vf extends Uf {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7967b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7968c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EditText f7969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7970e;

    public Vf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f7967b, f7968c));
    }

    @Override // com.disabngo.blockynexus.databinding.Uf
    public void a(com.disabngo.blockynexus.e.b.qa.d dVar) {
        updateRegistration(1, dVar);
        this.f7939a = dVar;
        synchronized (this) {
            this.f7970e |= 2;
        }
        notifyPropertyChanged(393);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        ReplyCommand<String> replyCommand;
        synchronized (this) {
            j = this.f7970e;
            this.f7970e = 0L;
        }
        com.disabngo.blockynexus.e.b.qa.d dVar = this.f7939a;
        long j2 = 7 & j;
        if (j2 != 0) {
            replyCommand = ((j & 6) == 0 || dVar == null) ? null : dVar.f10099c;
            ObservableField<String> observableField = dVar != null ? dVar.f10098b : null;
            updateRegistration(0, observableField);
            str = observableField != null ? observableField.get() : null;
        } else {
            str = null;
            replyCommand = null;
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.f7969d, str);
        }
        if ((j & 6) != 0) {
            EditTextBindingAdapters.editTextCommand(this.f7969d, null, null, replyCommand);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7970e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7970e = 4L;
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
        return a((com.disabngo.blockynexus.e.b.qa.d) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (393 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.qa.d) obj);
        return true;
    }

    private Vf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2);
        this.f7970e = -1L;
        this.f7969d = (EditText) objArr[0];
        this.f7969d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7970e |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.qa.d dVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7970e |= 2;
        }
        return true;
    }
}
