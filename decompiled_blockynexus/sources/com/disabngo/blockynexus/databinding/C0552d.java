package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.h.C0850a;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityContentTempWeekendBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0552d extends AbstractC0540c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f8247d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f8248e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CoordinatorLayout f8249f;
    private final ImageView g;
    private final DataRecyclerView h;
    private long i;

    static {
        f8248e.put(R.id.relativeLayout3, 3);
        f8248e.put(R.id.ivTop, 4);
    }

    public C0552d(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f8247d, f8248e));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0540c
    public void a(com.disabngo.blockynexus.view.dialog.activity.m mVar) {
        this.f8214c = mVar;
        synchronized (this) {
            this.i |= 1;
        }
        notifyPropertyChanged(337);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        C0850a c0850a;
        com.disabngo.blockynexus.view.dialog.activity.q qVar;
        synchronized (this) {
            j = this.i;
            this.i = 0L;
        }
        com.disabngo.blockynexus.view.dialog.activity.m mVar = this.f8214c;
        long j2 = j & 3;
        if (j2 == 0 || mVar == null) {
            replyCommand = null;
            c0850a = null;
            qVar = null;
        } else {
            com.disabngo.blockynexus.view.dialog.activity.q qVar2 = mVar.f11491a;
            c0850a = mVar.f11492b;
            replyCommand = mVar.f11493c;
            qVar = qVar2;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.g, replyCommand, false, 0);
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.h, c0850a, qVar, null, false, null, false, 0, false);
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
        if (337 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.activity.m) obj);
        return true;
    }

    private C0552d(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ImageView) objArr[4], (RelativeLayout) objArr[3]);
        this.i = -1L;
        this.f8249f = (CoordinatorLayout) objArr[0];
        this.f8249f.setTag(null);
        this.g = (ImageView) objArr[1];
        this.g.setTag(null);
        this.h = (DataRecyclerView) objArr[2];
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
