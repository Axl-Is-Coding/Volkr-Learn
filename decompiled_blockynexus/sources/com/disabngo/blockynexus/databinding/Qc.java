package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: DialogWeekSignBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Qc extends Pc {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f7798d = new ViewDataBinding.b(6);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f7799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DataRecyclerView f7800f;
    private final LinearLayout g;
    private final Ja h;
    private final ImageView i;
    private long j;

    static {
        f7798d.a(2, new String[]{"content_week_sign"}, new int[]{4}, new int[]{R.layout.content_week_sign});
        f7799e = new SparseIntArray();
        f7799e.put(R.id.ll_dialog, 5);
    }

    public Qc(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f7798d, f7799e));
    }

    @Override // com.disabngo.blockynexus.databinding.Pc
    public void a(com.disabngo.blockynexus.view.dialog.j.l lVar) {
        updateRegistration(0, lVar);
        this.f7768c = lVar;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(346);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.disabngo.blockynexus.view.dialog.j.i iVar;
        synchronized (this) {
            j = this.j;
            this.j = 0L;
        }
        com.disabngo.blockynexus.view.dialog.j.l lVar = this.f7768c;
        long j2 = j & 3;
        ReplyCommand replyCommand = null;
        if (j2 == 0 || lVar == null) {
            iVar = null;
        } else {
            iVar = lVar.f11633d;
            replyCommand = lVar.f11634e;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f7800f, null, iVar, me.tatarka.bindingcollectionadapter2.k.a(2), false, null, false, 0, false);
            this.h.a(lVar);
            ViewBindingAdapters.clickCommand(this.i, replyCommand, false, 0);
        }
        ViewDataBinding.executeBindingsOn(this.h);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.j != 0) {
                return true;
            }
            return this.h.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 2L;
        }
        this.h.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.dialog.j.l) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(androidx.lifecycle.g gVar) {
        super.setLifecycleOwner(gVar);
        this.h.setLifecycleOwner(gVar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (346 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.j.l) obj);
        return true;
    }

    private Qc(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (LinearLayout) objArr[5], (RelativeLayout) objArr[0]);
        this.j = -1L;
        this.f7800f = (DataRecyclerView) objArr[1];
        this.f7800f.setTag(null);
        this.g = (LinearLayout) objArr[2];
        this.g.setTag(null);
        this.h = (Ja) objArr[4];
        setContainedBinding(this.h);
        this.i = (ImageView) objArr[3];
        this.i.setTag(null);
        this.f7767b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.j.l lVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }
}
