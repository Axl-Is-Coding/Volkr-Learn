package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.PageRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.fd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentAppVideoTotalBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0578fd extends AbstractC0567ed {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f8330e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f8331f = new SparseIntArray();
    private final ConstraintLayout g;
    private final PageRecyclerView h;
    private long i;

    static {
        f8331f.put(R.id.tvSelect, 4);
    }

    public C0578fd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f8330e, f8331f));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0567ed
    public void a(com.disabngo.blockynexus.e.b.ya.g gVar) {
        updateRegistration(0, gVar);
        this.f8297d = gVar;
        synchronized (this) {
            this.i |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        com.disabngo.blockynexus.e.b.ya.d dVar;
        com.disabngo.blockynexus.e.b.xa.n nVar;
        com.disabngo.blockynexus.e.b.ya.d dVar2;
        com.disabngo.blockynexus.e.b.xa.n nVar2;
        synchronized (this) {
            j = this.i;
            this.i = 0L;
        }
        com.disabngo.blockynexus.e.b.ya.g gVar = this.f8297d;
        long j2 = 7 & j;
        if (j2 != 0) {
            if ((j & 5) == 0 || gVar == null) {
                dVar2 = null;
                nVar2 = null;
                replyCommand = null;
            } else {
                dVar2 = gVar.f10396c;
                nVar2 = gVar.f10395b;
                replyCommand = gVar.f10398e;
            }
            ObservableField<String> observableField = gVar != null ? gVar.f10397d : null;
            updateRegistration(1, observableField);
            str = observableField != null ? observableField.get() : null;
            dVar = dVar2;
            nVar = nVar2;
        } else {
            replyCommand = null;
            dVar = null;
            nVar = null;
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.f8294a, replyCommand, false, 0);
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.h, dVar, nVar, me.tatarka.bindingcollectionadapter2.k.a(2), false, false, false, 0, 0, false, null);
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.f8296c, str);
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
            this.i = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.ya.g) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (1 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ya.g) obj);
        return true;
    }

    private C0578fd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ConstraintLayout) objArr[1], (AppCompatTextView) objArr[4], (AppCompatTextView) objArr[2]);
        this.i = -1L;
        this.f8294a.setTag(null);
        this.g = (ConstraintLayout) objArr[0];
        this.g.setTag(null);
        this.h = (PageRecyclerView) objArr[3];
        this.h.setTag(null);
        this.f8296c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.ya.g gVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i |= 2;
        }
        return true;
    }
}
