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

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ac, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogPartyChooseTypeBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0519ac extends _b {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final ConstraintLayout i;
    private long j;

    static {
        h.put(R.id.constraintLayout, 3);
        h.put(R.id.textView, 4);
        h.put(R.id.textView3, 5);
    }

    public C0519ac(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, g, h));
    }

    public void a(com.disabngo.blockynexus.view.dialog.e.a aVar) {
        this.f8120f = aVar;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(249);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        com.disabngo.blockynexus.view.dialog.e.c cVar;
        synchronized (this) {
            j = this.j;
            this.j = 0L;
        }
        com.disabngo.blockynexus.view.dialog.e.a aVar = this.f8120f;
        long j2 = j & 3;
        if (j2 == 0 || aVar == null) {
            replyCommand = null;
            cVar = null;
        } else {
            com.disabngo.blockynexus.view.dialog.e.c cVar2 = aVar.f11546b;
            replyCommand = aVar.f11545a;
            cVar = cVar2;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f8116b, null, cVar, me.tatarka.bindingcollectionadapter2.k.a(2), false, null, false, 0, false);
            ViewBindingAdapters.clickCommand(this.i, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.f8118d, replyCommand, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (249 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.e.a) obj);
        return true;
    }

    private C0519ac(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ConstraintLayout) objArr[3], (DataRecyclerView) objArr[2], (TextView) objArr[4], (TextView) objArr[1], (TextView) objArr[5]);
        this.j = -1L;
        this.f8116b.setTag(null);
        this.i = (ConstraintLayout) objArr[0];
        this.i.setTag(null);
        this.f8118d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
