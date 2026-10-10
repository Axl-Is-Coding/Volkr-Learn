package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.PartyHallHeaderView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.yi, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemPartyHallBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0790yi extends AbstractC0779xi {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final ConstraintLayout i;
    private final PartyHallHeaderView j;
    private long k;

    static {
        h.put(R.id.cl_bottom, 6);
    }

    public C0790yi(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, g, h));
    }

    public void a(com.disabngo.blockynexus.view.fragment.partyhall.u uVar) {
        updateRegistration(0, uVar);
        this.f8989f = uVar;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r19 = this;
            r1 = r19
            monitor-enter(r19)
            long r2 = r1.k     // Catch: java.lang.Throwable -> L92
            r4 = 0
            r1.k = r4     // Catch: java.lang.Throwable -> L92
            monitor-exit(r19)     // Catch: java.lang.Throwable -> L92
            com.disabngo.blockynexus.view.fragment.partyhall.u r0 = r1.f8989f
            r6 = 15
            long r6 = r6 & r2
            r8 = 11
            r10 = 13
            r12 = 9
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 == 0) goto L5d
            long r6 = r2 & r12
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 == 0) goto L26
            if (r0 == 0) goto L26
            com.disabngo.blockynexus.view.fragment.partyhall.q r6 = r0.f11944a
            com.sandboxol.common.command.ReplyCommand r7 = r0.f11946c
            goto L28
        L26:
            r6 = 0
            r7 = 0
        L28:
            long r15 = r2 & r8
            int r17 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r17 == 0) goto L41
            if (r0 == 0) goto L33
            androidx.databinding.ObservableField<java.lang.String> r15 = r0.f11945b
            goto L34
        L33:
            r15 = 0
        L34:
            r14 = 1
            r1.updateRegistration(r14, r15)
            if (r15 == 0) goto L41
            java.lang.Object r14 = r15.get()
            java.lang.String r14 = (java.lang.String) r14
            goto L42
        L41:
            r14 = 0
        L42:
            long r17 = r2 & r10
            int r15 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r15 == 0) goto L5b
            if (r0 == 0) goto L4f
            com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItem r0 = r0.getItem()
            goto L50
        L4f:
            r0 = 0
        L50:
            if (r0 == 0) goto L5b
            java.lang.String r15 = r0.getGameName()
            java.lang.String r0 = r0.getTitle()
            goto L62
        L5b:
            r0 = 0
            goto L61
        L5d:
            r0 = 0
            r6 = 0
            r7 = 0
            r14 = 0
        L61:
            r15 = 0
        L62:
            long r12 = r12 & r2
            int r16 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r16 == 0) goto L77
            androidx.constraintlayout.widget.ConstraintLayout r12 = r1.f8985b
            r13 = 0
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r12, r7, r13, r13)
            androidx.constraintlayout.widget.ConstraintLayout r12 = r1.i
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r12, r7, r13, r13)
            com.disabngo.blockynexus.view.widget.PartyHallHeaderView r7 = r1.j
            com.disabngo.blockynexus.adapter.f.a(r7, r6)
        L77:
            long r6 = r2 & r10
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 == 0) goto L87
            android.widget.TextView r6 = r1.f8986c
            androidx.databinding.a.e.a(r6, r15)
            android.widget.TextView r6 = r1.f8988e
            androidx.databinding.a.e.a(r6, r0)
        L87:
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L91
            android.widget.TextView r0 = r1.f8987d
            androidx.databinding.a.e.a(r0, r14)
        L91:
            return
        L92:
            r0 = move-exception
            monitor-exit(r19)     // Catch: java.lang.Throwable -> L92
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0790yi.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.fragment.partyhall.u) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.fragment.partyhall.u) obj);
        return true;
    }

    private C0790yi(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ConstraintLayout) objArr[6], (ConstraintLayout) objArr[1], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[2]);
        this.k = -1L;
        this.f8985b.setTag(null);
        this.i = (ConstraintLayout) objArr[0];
        this.i.setTag(null);
        this.j = (PartyHallHeaderView) objArr[3];
        this.j.setTag(null);
        this.f8986c.setTag(null);
        this.f8987d.setTag(null);
        this.f8988e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.fragment.partyhall.u uVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.k |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.k |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }
}
