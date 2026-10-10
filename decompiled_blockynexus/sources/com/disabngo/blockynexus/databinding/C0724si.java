package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.entity.PartyCreateMemberNum;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.si, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemPartyChooseMemberNumBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0724si extends AbstractC0713ri {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8805b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8806c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f8807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextView f8808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f8809f;
    private long g;

    public C0724si(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f8805b, f8806c));
    }

    public void a(com.disabngo.blockynexus.view.dialog.d.b bVar) {
        updateRegistration(0, bVar);
        this.f8770a = bVar;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String partyMemberNum;
        int i;
        boolean zIsVip;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        com.disabngo.blockynexus.view.dialog.d.b bVar = this.f8770a;
        long j2 = j & 7;
        ReplyCommand replyCommand = null;
        if (j2 != 0) {
            ReplyCommand replyCommand2 = ((j & 5) == 0 || bVar == null) ? null : bVar.f11540a;
            PartyCreateMemberNum item = bVar != null ? bVar.getItem() : null;
            if (item != null) {
                zIsVip = item.isVip();
                partyMemberNum = item.getPartyMemberNum();
            } else {
                partyMemberNum = null;
                zIsVip = false;
            }
            if (j2 != 0) {
                j |= zIsVip ? 16L : 8L;
            }
            i = zIsVip ? 0 : 8;
            replyCommand = replyCommand2;
        } else {
            partyMemberNum = null;
            i = 0;
        }
        if ((7 & j) != 0) {
            androidx.databinding.a.e.a(this.f8808e, partyMemberNum);
            this.f8809f.setVisibility(i);
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.f8808e, replyCommand, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.g = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.dialog.d.b) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.d.b) obj);
        return true;
    }

    private C0724si(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.g = -1L;
        this.f8807d = (ConstraintLayout) objArr[0];
        this.f8807d.setTag(null);
        this.f8808e = (TextView) objArr[1];
        this.f8808e.setTag(null);
        this.f8809f = (TextView) objArr[2];
        this.f8809f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.d.b bVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.g |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }
}
