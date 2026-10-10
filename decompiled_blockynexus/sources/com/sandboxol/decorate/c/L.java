package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.view.activity.dress.DressExtraItemViewModel;

/* JADX INFO: compiled from: ItemDressShopClearHistoryBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class L extends K {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f17020f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final ConstraintLayout h;
    private long i;

    static {
        g.put(R.id.bgView, 2);
        g.put(R.id.ivPicClear, 3);
        g.put(R.id.tvClear, 4);
    }

    public L(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f17020f, g));
    }

    public void a(DressExtraItemViewModel dressExtraItemViewModel) {
        updateRegistration(1, dressExtraItemViewModel);
        this.f17019e = dressExtraItemViewModel;
        synchronized (this) {
            this.i |= 2;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.w);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        synchronized (this) {
            j = this.i;
            this.i = 0L;
        }
        DressExtraItemViewModel dressExtraItemViewModel = this.f17019e;
        long j2 = j & 7;
        ReplyCommand replyCommand = null;
        if (j2 != 0) {
            ObservableField<Long> observableField = dressExtraItemViewModel != null ? dressExtraItemViewModel.f17224a : null;
            updateRegistration(0, observableField);
            boolean z = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null) == -2;
            if (j2 != 0) {
                j |= z ? 16L : 8L;
            }
            i = z ? 0 : 8;
            if ((j & 6) != 0 && dressExtraItemViewModel != null) {
                replyCommand = dressExtraItemViewModel.f17225b;
            }
        } else {
            i = 0;
        }
        if ((7 & j) != 0) {
            this.f17016b.setVisibility(i);
        }
        if ((j & 6) != 0) {
            ViewBindingAdapters.clickCommand(this.h, replyCommand, false, 0);
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
            return a((ObservableField<Long>) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((DressExtraItemViewModel) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.w != i) {
            return false;
        }
        a((DressExtraItemViewModel) obj);
        return true;
    }

    private L(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (View) objArr[2], (Group) objArr[1], (ImageView) objArr[3], (TextView) objArr[4]);
        this.i = -1L;
        this.f17016b.setTag(null);
        this.h = (ConstraintLayout) objArr[0];
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Long> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.i |= 1;
        }
        return true;
    }

    private boolean a(DressExtraItemViewModel dressExtraItemViewModel, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.i |= 2;
        }
        return true;
    }
}
