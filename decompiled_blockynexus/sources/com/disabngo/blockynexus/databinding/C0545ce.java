package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ce, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentGroupBanTimeBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0545ce extends AbstractC0533be {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8228c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8229d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f8230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DataRecyclerView f8231f;
    private final Button g;
    private long h;

    static {
        f8229d.put(R.id.textView24, 3);
    }

    public C0545ce(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f8228c, f8229d));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0533be
    public void a(com.disabngo.blockynexus.view.fragment.groupbannedtimelist.h hVar) {
        updateRegistration(0, hVar);
        this.f8195b = hVar;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(530);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        com.disabngo.blockynexus.view.fragment.groupbannedtimelist.d dVar;
        com.disabngo.blockynexus.view.fragment.groupbannedtimelist.e eVar;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        com.disabngo.blockynexus.view.fragment.groupbannedtimelist.h hVar = this.f8195b;
        long j2 = j & 3;
        if (j2 == 0 || hVar == null) {
            replyCommand = null;
            dVar = null;
            eVar = null;
        } else {
            com.disabngo.blockynexus.view.fragment.groupbannedtimelist.d dVar2 = hVar.f11734e;
            com.disabngo.blockynexus.view.fragment.groupbannedtimelist.e eVar2 = hVar.f11735f;
            replyCommand = hVar.h;
            dVar = dVar2;
            eVar = eVar2;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f8231f, dVar, eVar, null, false, null, false, 0, false);
            ViewBindingAdapters.clickCommand(this.g, replyCommand, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.fragment.groupbannedtimelist.h) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (530 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.fragment.groupbannedtimelist.h) obj);
        return true;
    }

    private C0545ce(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (TextView) objArr[3]);
        this.h = -1L;
        this.f8230e = (ConstraintLayout) objArr[0];
        this.f8230e.setTag(null);
        this.f8231f = (DataRecyclerView) objArr[1];
        this.f8231f.setTag(null);
        this.g = (Button) objArr[2];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.fragment.groupbannedtimelist.h hVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 1;
        }
        return true;
    }
}
