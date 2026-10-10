package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.PageRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.oc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogScrapHistoryBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0675oc extends AbstractC0664nc {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f8653e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f8654f = new SparseIntArray();
    private final ConstraintLayout g;
    private final PageRecyclerView h;
    private long i;

    static {
        f8654f.put(R.id.v, 3);
        f8654f.put(R.id.tv_title, 4);
    }

    public C0675oc(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f8653e, f8654f));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0664nc
    public void a(com.disabngo.blockynexus.view.dialog.f.b bVar) {
        this.f8615d = bVar;
        synchronized (this) {
            this.i |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.disabngo.blockynexus.view.dialog.f.d dVar;
        com.disabngo.blockynexus.view.dialog.f.f fVar;
        synchronized (this) {
            j = this.i;
            this.i = 0L;
        }
        com.disabngo.blockynexus.view.dialog.f.b bVar = this.f8615d;
        long j2 = j & 3;
        ReplyCommand replyCommand = null;
        if (j2 == 0 || bVar == null) {
            dVar = null;
            fVar = null;
        } else {
            com.disabngo.blockynexus.view.dialog.f.f fVar2 = bVar.f11556b;
            ReplyCommand replyCommand2 = bVar.f11557c;
            dVar = bVar.f11555a;
            fVar = fVar2;
            replyCommand = replyCommand2;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f8612a, replyCommand, false, 0);
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.h, dVar, fVar, null, false, false, false, 0, 0, false, null);
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
        a((com.disabngo.blockynexus.view.dialog.f.b) obj);
        return true;
    }

    private C0675oc(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ImageView) objArr[2], (TextView) objArr[4], (View) objArr[3]);
        this.i = -1L;
        this.f8612a.setTag(null);
        this.g = (ConstraintLayout) objArr[0];
        this.g.setTag(null);
        this.h = (PageRecyclerView) objArr[1];
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
