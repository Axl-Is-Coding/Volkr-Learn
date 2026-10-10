package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: DialogScrapRuleBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ac extends AbstractC0795zc {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f7264e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f7265f = new SparseIntArray();
    private final ConstraintLayout g;
    private final DataRecyclerView h;
    private long i;

    static {
        f7265f.put(R.id.v, 3);
        f7265f.put(R.id.tv_title, 4);
    }

    public Ac(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f7264e, f7265f));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0795zc
    public void a(com.disabngo.blockynexus.view.dialog.h.b bVar) {
        this.f9039d = bVar;
        synchronized (this) {
            this.i |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        com.disabngo.blockynexus.view.dialog.h.e eVar;
        synchronized (this) {
            j = this.i;
            this.i = 0L;
        }
        com.disabngo.blockynexus.view.dialog.h.b bVar = this.f9039d;
        long j2 = j & 3;
        if (j2 == 0 || bVar == null) {
            replyCommand = null;
            eVar = null;
        } else {
            com.disabngo.blockynexus.view.dialog.h.e eVar2 = bVar.f11590a;
            replyCommand = bVar.f11591b;
            eVar = eVar2;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f9036a, replyCommand, false, 0);
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.h, null, eVar, null, false, null, false, 0, false);
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
            this.i = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.h.b) obj);
        return true;
    }

    private Ac(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ImageView) objArr[2], (TextView) objArr[4], (View) objArr[3]);
        this.i = -1L;
        this.f9036a.setTag(null);
        this.g = (ConstraintLayout) objArr[0];
        this.g.setTag(null);
        this.h = (DataRecyclerView) objArr[1];
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
