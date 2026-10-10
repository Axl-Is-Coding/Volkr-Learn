package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.xb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogFirstTopUpBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0772xb extends AbstractC0761wb {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8957c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8958d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DataRecyclerView f8959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DataRecyclerView f8960f;
    private final TextView g;
    private final TextView h;
    private long i;

    public C0772xb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f8957c, f8958d));
    }

    public void a(com.disabngo.blockynexus.view.dialog.b.a aVar) {
        this.f8928b = aVar;
        synchronized (this) {
            this.i |= 2;
        }
        notifyPropertyChanged(500);
        super.requestRebind();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [com.sandboxol.common.widget.rv.datarv.DataListModel] */
    /* JADX WARN: Type inference failed for: r18v2, types: [com.sandboxol.common.widget.rv.datarv.DataListModel] */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r25v0, types: [androidx.databinding.ViewDataBinding, com.disabngo.blockynexus.databinding.wb, com.disabngo.blockynexus.databinding.xb] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r25 = this;
            r1 = r25
            monitor-enter(r25)
            long r2 = r1.i     // Catch: java.lang.Throwable -> L86
            r4 = 0
            r1.i = r4     // Catch: java.lang.Throwable -> L86
            monitor-exit(r25)     // Catch: java.lang.Throwable -> L86
            com.disabngo.blockynexus.view.dialog.b.a r0 = r1.f8928b
            r6 = 7
            long r6 = r6 & r2
            r8 = 6
            r10 = 0
            r11 = 0
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 == 0) goto L41
            if (r0 == 0) goto L1c
            androidx.databinding.ObservableField<java.lang.String> r12 = r0.f11527e
            goto L1d
        L1c:
            r12 = r11
        L1d:
            r1.updateRegistration(r10, r12)
            if (r12 == 0) goto L29
            java.lang.Object r12 = r12.get()
            java.lang.String r12 = (java.lang.String) r12
            goto L2a
        L29:
            r12 = r11
        L2a:
            long r13 = r2 & r8
            int r15 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r15 == 0) goto L3f
            if (r0 == 0) goto L3f
            com.disabngo.blockynexus.e.b.ua.i r11 = r0.f11526d
            com.sandboxol.common.command.ReplyCommand r13 = r0.g
            com.sandboxol.common.command.ReplyCommand r14 = r0.f11528f
            com.disabngo.blockynexus.view.dialog.b.c r15 = r0.f11524b
            com.disabngo.blockynexus.view.dialog.b.c r0 = r0.f11523a
            r18 = r0
            goto L47
        L3f:
            r13 = r11
            goto L43
        L41:
            r12 = r11
            r13 = r12
        L43:
            r14 = r13
            r15 = r14
            r18 = r15
        L47:
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L7c
            com.sandboxol.common.widget.rv.datarv.DataRecyclerView r0 = r1.f8959e
            r2 = 3
            me.tatarka.bindingcollectionadapter2.k$a r19 = me.tatarka.bindingcollectionadapter2.k.a(r2)
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r16 = r0
            r17 = r11
            com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters.setDataRecyclerView(r16, r17, r18, r19, r20, r21, r22, r23, r24)
            com.sandboxol.common.widget.rv.datarv.DataRecyclerView r0 = r1.f8960f
            r2 = 2
            me.tatarka.bindingcollectionadapter2.k$a r19 = me.tatarka.bindingcollectionadapter2.k.a(r2)
            r16 = r0
            r18 = r15
            com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters.setDataRecyclerView(r16, r17, r18, r19, r20, r21, r22, r23, r24)
            android.widget.TextView r0 = r1.g
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r0, r14, r10, r10)
            android.widget.TextView r0 = r1.h
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r0, r13, r10, r10)
        L7c:
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L85
            android.widget.TextView r0 = r1.h
            androidx.databinding.a.e.a(r0, r12)
        L85:
            return
        L86:
            r0 = move-exception
            monitor-exit(r25)     // Catch: java.lang.Throwable -> L86
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0772xb.executeBindings():void");
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
            this.i = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (500 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.b.a) obj);
        return true;
    }

    private C0772xb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (RelativeLayout) objArr[0]);
        this.i = -1L;
        this.f8959e = (DataRecyclerView) objArr[1];
        this.f8959e.setTag(null);
        this.f8960f = (DataRecyclerView) objArr[2];
        this.f8960f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        this.f8927a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i |= 1;
        }
        return true;
    }
}
