package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.we, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentHelpDetailBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0764we extends AbstractC0753ve {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8930c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8931d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f8932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DataRecyclerView f8933f;
    private long g;

    public C0764we(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f8930c, f8931d));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0753ve
    public void a(com.disabngo.blockynexus.e.b.K.g gVar) {
        updateRegistration(0, gVar);
        this.f8907b = gVar;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(305);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.disabngo.blockynexus.e.b.K.f fVar;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        com.disabngo.blockynexus.e.b.K.g gVar = this.f8907b;
        long j2 = j & 3;
        ReplyCommand replyCommand = null;
        if (j2 == 0 || gVar == null) {
            fVar = null;
        } else {
            replyCommand = gVar.f9332c;
            fVar = gVar.f9331b;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f8933f, null, fVar, null, false, null, false, 0, false);
            ViewBindingAdapters.clickCommand(this.f8906a, replyCommand, false, 0);
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
            this.g = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.K.g) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (305 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.K.g) obj);
        return true;
    }

    private C0764we(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (TextView) objArr[2]);
        this.g = -1L;
        this.f8932e = (ConstraintLayout) objArr[0];
        this.f8932e.setTag(null);
        this.f8933f = (DataRecyclerView) objArr[1];
        this.f8933f.setTag(null);
        this.f8906a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.K.g gVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 1;
        }
        return true;
    }
}
