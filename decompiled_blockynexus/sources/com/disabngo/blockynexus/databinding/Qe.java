package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.widget.ItemView;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: FragmentPhoneBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Qe extends Pe {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7806b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7807c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f7808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ItemView f7809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Button f7810f;
    private long g;

    public Qe(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f7806b, f7807c));
    }

    @Override // com.disabngo.blockynexus.databinding.Pe
    public void a(com.disabngo.blockynexus.e.b.T.h hVar) {
        updateRegistration(0, hVar);
        this.f7770a = hVar;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(474);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        com.disabngo.blockynexus.e.b.T.h hVar = this.f7770a;
        long j2 = 9 & j;
        String str = null;
        ReplyCommand replyCommand = (j2 == 0 || hVar == null) ? null : hVar.f9456c;
        long j3 = j & 10;
        if (j3 != 0) {
            ObservableField<String> observableField = AccountCenter.newInstance().telephone;
            updateRegistration(1, observableField);
            if (observableField != null) {
                str = observableField.get();
            }
        }
        if (j3 != 0) {
            com.disabngo.blockynexus.binding.adapter.j.a(this.f7809e, str);
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f7810f, replyCommand, false, 0);
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
            this.g = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.T.h) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((AccountCenter) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (474 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.T.h) obj);
        return true;
    }

    private Qe(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3);
        this.g = -1L;
        this.f7808d = (LinearLayout) objArr[0];
        this.f7808d.setTag(null);
        this.f7809e = (ItemView) objArr[1];
        this.f7809e.setTag(null);
        this.f7810f = (Button) objArr[2];
        this.f7810f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.T.h hVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 4;
        }
        return true;
    }
}
