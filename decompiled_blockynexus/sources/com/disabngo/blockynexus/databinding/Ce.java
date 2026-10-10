package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.binding.adapter.PageRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: compiled from: FragmentIncomeBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ce extends Be {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = new SparseIntArray();
    private final ConstraintLayout l;
    private final PageRecyclerView m;
    private long n;

    static {
        k.put(R.id.v_detail, 5);
        k.put(R.id.v_detail_divide, 6);
        k.put(R.id.tv_diamond_tip, 7);
        k.put(R.id.tv_cash_tip, 8);
        k.put(R.id.v_divide, 9);
    }

    public Ce(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, j, k));
    }

    private boolean b(ObservableField<Double> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 8;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Be
    public void a(com.disabngo.blockynexus.e.b.M.g gVar) {
        updateRegistration(2, gVar);
        this.i = gVar;
        synchronized (this) {
            this.n |= 4;
        }
        notifyPropertyChanged(396);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j2;
        String strValueOf;
        String strValueOf2;
        ReplyCommand replyCommand;
        com.disabngo.blockynexus.e.b.M.f fVar;
        com.disabngo.blockynexus.e.b.M.f fVar2;
        synchronized (this) {
            j2 = this.n;
            this.n = 0L;
        }
        com.disabngo.blockynexus.e.b.M.g gVar = this.i;
        long j3 = 18 & j2;
        if (j3 != 0) {
            ObservableField<Long> observableField = AccountCenter.newInstance().gDiamondsProfit;
            updateRegistration(1, observableField);
            strValueOf = String.valueOf(ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null));
        } else {
            strValueOf = null;
        }
        long j4 = 28 & j2;
        if (j4 != 0) {
            if ((j2 & 20) == 0 || gVar == null) {
                fVar2 = null;
                replyCommand = null;
            } else {
                fVar2 = gVar.f9355c;
                replyCommand = gVar.g;
            }
            ObservableField<Double> observableField2 = gVar != null ? gVar.f9358f : null;
            updateRegistration(3, observableField2);
            strValueOf2 = String.valueOf(ViewDataBinding.safeUnbox(observableField2 != null ? observableField2.get() : null));
            fVar = fVar2;
        } else {
            strValueOf2 = null;
            replyCommand = null;
            fVar = null;
        }
        if ((j2 & 20) != 0) {
            ViewBindingAdapters.clickCommand(this.f7306a, replyCommand, false, 0);
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.m, null, fVar, null, false, false, false, 0, 0, false, null);
        }
        if (j4 != 0) {
            androidx.databinding.a.e.a(this.f7307b, strValueOf2);
        }
        if (j3 != 0) {
            androidx.databinding.a.e.a(this.f7309d, strValueOf);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((AccountCenter) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<Long>) obj, i2);
        }
        if (i == 2) {
            return a((com.disabngo.blockynexus.e.b.M.g) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (396 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.M.g) obj);
        return true;
    }

    private Ce(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (Button) objArr[3], (TextView) objArr[2], (TextView) objArr[8], (TextView) objArr[1], (TextView) objArr[7], (View) objArr[5], (View) objArr[6], (View) objArr[9]);
        this.n = -1L;
        this.f7306a.setTag(null);
        this.l = (ConstraintLayout) objArr[0];
        this.l.setTag(null);
        this.m = (PageRecyclerView) objArr[4];
        this.m.setTag(null);
        this.f7307b.setTag(null);
        this.f7309d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 2;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.M.g gVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 4;
        }
        return true;
    }
}
