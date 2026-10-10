package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.x.C0935C;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ag, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentTribeShopCarBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0523ag extends _f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f8172d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f8173e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RelativeLayout f8174f;
    private final TextView g;
    private final Button h;
    private final DataRecyclerView i;
    private final TextView j;
    private final Button k;
    private long l;

    static {
        f8173e.put(R.id.rlTitle, 6);
        f8173e.put(R.id.tvBill, 7);
    }

    public C0523ag(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, f8172d, f8173e));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 8;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding._f
    public void a(com.disabngo.blockynexus.e.b.ta.h hVar) {
        updateRegistration(0, hVar);
        this.f8130c = hVar;
        synchronized (this) {
            this.l |= 1;
        }
        notifyPropertyChanged(269);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        C0935C c0935c;
        com.disabngo.blockynexus.e.b.ta.i iVar;
        String strValueOf;
        String strValueOf2;
        String str;
        com.disabngo.blockynexus.e.b.ta.i iVar2;
        ReplyCommand replyCommand3;
        synchronized (this) {
            j = this.l;
            this.l = 0L;
        }
        com.disabngo.blockynexus.e.b.ta.h hVar = this.f8130c;
        long j2 = 25 & j;
        if (j2 != 0) {
            if ((j & 17) == 0 || hVar == null) {
                replyCommand2 = null;
                iVar2 = null;
                c0935c = null;
                replyCommand3 = null;
            } else {
                replyCommand2 = hVar.f10195f;
                iVar2 = hVar.f10194e;
                c0935c = hVar.f10193d;
                replyCommand3 = hVar.g;
            }
            ObservableField<Integer> observableField = hVar != null ? hVar.f10192c : null;
            updateRegistration(3, observableField);
            strValueOf = String.valueOf(ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null));
            replyCommand = replyCommand3;
            iVar = iVar2;
        } else {
            replyCommand = null;
            replyCommand2 = null;
            c0935c = null;
            iVar = null;
            strValueOf = null;
        }
        long j3 = j & 18;
        if (j3 != 0) {
            ObservableField<Long> observableField2 = TribeCenter.newInstance().tribeGolds;
            updateRegistration(1, observableField2);
            strValueOf2 = String.valueOf(ViewDataBinding.safeUnbox(observableField2 != null ? observableField2.get() : null));
        } else {
            strValueOf2 = null;
        }
        if (j3 != 0) {
            androidx.databinding.a.e.a(this.g, strValueOf2);
        }
        if ((j & 17) != 0) {
            ViewBindingAdapters.clickCommand(this.h, replyCommand2, false, 0);
            str = strValueOf;
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.i, c0935c, iVar, null, false, null, false, 0, false);
            ViewBindingAdapters.clickCommand(this.k, replyCommand, false, 0);
        } else {
            str = strValueOf;
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.j, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.l = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.ta.h) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<Long>) obj, i2);
        }
        if (i == 2) {
            return a((TribeCenter) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (269 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ta.h) obj);
        return true;
    }

    private C0523ag(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (RelativeLayout) objArr[6], (TextView) objArr[7]);
        this.l = -1L;
        this.f8174f = (RelativeLayout) objArr[0];
        this.f8174f.setTag(null);
        this.g = (TextView) objArr[1];
        this.g.setTag(null);
        this.h = (Button) objArr[2];
        this.h.setTag(null);
        this.i = (DataRecyclerView) objArr[3];
        this.i.setTag(null);
        this.j = (TextView) objArr[4];
        this.j.setTag(null);
        this.k = (Button) objArr[5];
        this.k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.ta.h hVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }

    private boolean a(TribeCenter tribeCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 4;
        }
        return true;
    }
}
