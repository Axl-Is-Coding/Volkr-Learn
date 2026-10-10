package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentTribeNoBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Tf extends Sf {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7903c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7904d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f7905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RelativeLayout f7906f;
    private final ImageButton g;
    private final Button h;
    private final ImageButton i;
    private final DataRecyclerView j;
    private long k;

    static {
        f7904d.put(R.id.tbMainBar, 6);
    }

    public Tf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f7903c, f7904d));
    }

    @Override // com.disabngo.blockynexus.databinding.Sf
    public void a(com.disabngo.blockynexus.view.fragment.tribeno.m mVar) {
        updateRegistration(2, mVar);
        this.f7876b = mVar;
        synchronized (this) {
            this.k |= 4;
        }
        notifyPropertyChanged(273);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0040 A[PHI: r2
      0x0040: PHI (r2v1 long) = (r2v0 long), (r2v4 long) binds: [B:7:0x0014, B:18:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r23 = this;
            r1 = r23
            monitor-enter(r23)
            long r2 = r1.k     // Catch: java.lang.Throwable -> L8d
            r4 = 0
            r1.k = r4     // Catch: java.lang.Throwable -> L8d
            monitor-exit(r23)     // Catch: java.lang.Throwable -> L8d
            com.disabngo.blockynexus.view.fragment.tribeno.m r0 = r1.f7876b
            r6 = 10
            long r8 = r2 & r6
            r10 = 0
            r11 = 0
            int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r12 == 0) goto L40
            com.sandboxol.center.entity.AccountCenter r12 = com.sandboxol.center.entity.AccountCenter.newInstance()
            androidx.databinding.ObservableField<java.lang.Boolean> r12 = r12.login
            r13 = 1
            r1.updateRegistration(r13, r12)
            if (r12 == 0) goto L29
            java.lang.Object r12 = r12.get()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            goto L2a
        L29:
            r12 = r10
        L2a:
            boolean r12 = androidx.databinding.ViewDataBinding.safeUnbox(r12)
            int r13 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r13 == 0) goto L3a
            if (r12 == 0) goto L37
            r8 = 32
            goto L39
        L37:
            r8 = 16
        L39:
            long r2 = r2 | r8
        L3a:
            if (r12 == 0) goto L3d
            goto L40
        L3d:
            r8 = 8
            goto L41
        L40:
            r8 = 0
        L41:
            r12 = 12
            long r12 = r12 & r2
            int r9 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r9 == 0) goto L59
            if (r0 == 0) goto L59
            com.sandboxol.common.command.ReplyCommand r10 = r0.f12046e
            com.disabngo.blockynexus.view.fragment.tribeno.l r9 = r0.f12044c
            com.sandboxol.common.command.ReplyCommand r14 = r0.f12047f
            com.disabngo.blockynexus.view.fragment.tribeno.j r15 = r0.f12043b
            com.sandboxol.common.command.ReplyCommand r0 = r0.f12045d
            r16 = r9
            r9 = r10
            r10 = r14
            goto L5e
        L59:
            r0 = r10
            r9 = r0
            r15 = r9
            r16 = r15
        L5e:
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 == 0) goto L82
            android.widget.RelativeLayout r12 = r1.f7906f
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r12, r0, r11, r11)
            android.widget.Button r0 = r1.h
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r0, r10, r11, r11)
            android.widget.ImageButton r0 = r1.i
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r0, r9, r11, r11)
            com.sandboxol.common.widget.rv.datarv.DataRecyclerView r14 = r1.j
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters.setDataRecyclerView(r14, r15, r16, r17, r18, r19, r20, r21, r22)
        L82:
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L8c
            android.widget.ImageButton r0 = r1.g
            r0.setVisibility(r8)
        L8c:
            return
        L8d:
            r0 = move-exception
            monitor-exit(r23)     // Catch: java.lang.Throwable -> L8d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Tf.executeBindings():void");
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
            return a((AccountCenter) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.fragment.tribeno.m) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (273 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.fragment.tribeno.m) obj);
        return true;
    }

    private Tf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (Toolbar) objArr[6]);
        this.k = -1L;
        this.f7905e = (LinearLayout) objArr[0];
        this.f7905e.setTag(null);
        this.f7906f = (RelativeLayout) objArr[1];
        this.f7906f.setTag(null);
        this.g = (ImageButton) objArr[2];
        this.g.setTag(null);
        this.h = (Button) objArr[3];
        this.h.setTag(null);
        this.i = (ImageButton) objArr[4];
        this.i.setTag(null);
        this.j = (DataRecyclerView) objArr[5];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.fragment.tribeno.m mVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 4;
        }
        return true;
    }
}
