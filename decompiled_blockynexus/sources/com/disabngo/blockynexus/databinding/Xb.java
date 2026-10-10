package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: DialogPartyChooseGameBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Xb extends Wb {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f8024f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final ConstraintLayout h;
    private long i;

    static {
        g.put(R.id.constraintLayout, 3);
        g.put(R.id.textView, 4);
    }

    public Xb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f8024f, g));
    }

    public void a(com.disabngo.blockynexus.view.dialog.c.a aVar) {
        this.f7993e = aVar;
        synchronized (this) {
            this.i |= 1;
        }
        notifyPropertyChanged(456);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.disabngo.blockynexus.view.dialog.c.c cVar;
        synchronized (this) {
            j = this.i;
            this.i = 0L;
        }
        com.disabngo.blockynexus.view.dialog.c.a aVar = this.f7993e;
        long j2 = j & 3;
        ReplyCommand replyCommand = null;
        if (j2 == 0 || aVar == null) {
            cVar = null;
        } else {
            replyCommand = aVar.f11532a;
            cVar = aVar.f11533b;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f7990b, null, cVar, null, false, null, false, 0, false);
            ViewBindingAdapters.clickCommand(this.h, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.f7992d, replyCommand, false, 0);
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
        if (456 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.c.a) obj);
        return true;
    }

    private Xb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ConstraintLayout) objArr[3], (DataRecyclerView) objArr[2], (TextView) objArr[4], (TextView) objArr[1]);
        this.i = -1L;
        this.f7990b.setTag(null);
        this.h = (ConstraintLayout) objArr[0];
        this.h.setTag(null);
        this.f7992d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
