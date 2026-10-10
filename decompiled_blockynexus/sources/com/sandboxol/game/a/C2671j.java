package com.sandboxol.game.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.StrokeTextView;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.game.R;

/* JADX INFO: renamed from: com.sandboxol.game.a.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogRechargeShopBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2671j extends AbstractC2670i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f17687d = new ViewDataBinding.b(6);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f17688e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RelativeLayout f17689f;
    private final ImageView g;
    private final LinearLayout h;
    private final DataRecyclerView i;
    private long j;

    static {
        f17687d.a(2, new String[]{"dialog_recharge_star_code_view"}, new int[]{4}, new int[]{R.layout.dialog_recharge_star_code_view});
        f17688e = new SparseIntArray();
        f17688e.put(R.id.tvShop, 5);
    }

    public C2671j(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f17687d, f17688e));
    }

    @Override // com.sandboxol.game.a.AbstractC2670i
    public void a(com.sandboxol.recharge.dialog.rechargeshop.k kVar) {
        this.f17686c = kVar;
        synchronized (this) {
            this.j |= 2;
        }
        notifyPropertyChanged(com.sandboxol.game.a.l);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.sandboxol.recharge.dialog.rechargeshop.o oVar;
        synchronized (this) {
            j = this.j;
            this.j = 0L;
        }
        com.sandboxol.recharge.dialog.rechargeshop.k kVar = this.f17686c;
        long j2 = j & 6;
        ReplyCommand replyCommand = null;
        if (j2 == 0 || kVar == null) {
            oVar = null;
        } else {
            replyCommand = kVar.f18871a;
            oVar = kVar.f18872b;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.g, replyCommand, false, 0);
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.i, null, oVar, me.tatarka.bindingcollectionadapter2.k.a(2), false, null, false, 0, false);
            this.f17684a.a(kVar);
        }
        ViewDataBinding.executeBindingsOn(this.f17684a);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.j != 0) {
                return true;
            }
            return this.f17684a.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 4L;
        }
        this.f17684a.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((k) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(androidx.lifecycle.g gVar) {
        super.setLifecycleOwner(gVar);
        this.f17684a.setLifecycleOwner(gVar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.game.a.l != i) {
            return false;
        }
        a((com.sandboxol.recharge.dialog.rechargeshop.k) obj);
        return true;
    }

    private C2671j(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (k) objArr[4], (StrokeTextView) objArr[5]);
        this.j = -1L;
        this.f17689f = (RelativeLayout) objArr[0];
        this.f17689f.setTag(null);
        this.g = (ImageView) objArr[1];
        this.g.setTag(null);
        this.h = (LinearLayout) objArr[2];
        this.h.setTag(null);
        this.i = (DataRecyclerView) objArr[3];
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(k kVar, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }
}
