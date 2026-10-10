package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: FragmentClanRankBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Bd extends Ad {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f7305f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final ConstraintLayout h;
    private final ViewPager i;
    private long j;

    static {
        g.put(R.id.rb_global_tab, 3);
        g.put(R.id.gl_vertical_25, 4);
        g.put(R.id.gl_vertical_75, 5);
    }

    public Bd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f7305f, g));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Ad
    public void a(com.disabngo.blockynexus.e.b.W.b.p pVar) {
        updateRegistration(0, pVar);
        this.f7270e = pVar;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(352);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r24 = this;
            r1 = r24
            monitor-enter(r24)
            long r2 = r1.j     // Catch: java.lang.Throwable -> Lba
            r4 = 0
            r1.j = r4     // Catch: java.lang.Throwable -> Lba
            monitor-exit(r24)     // Catch: java.lang.Throwable -> Lba
            com.disabngo.blockynexus.e.b.W.b.p r0 = r1.f7270e
            r6 = 31
            long r6 = r6 & r2
            r10 = 1
            r11 = 17
            r13 = 19
            r15 = 21
            r17 = 0
            r8 = 0
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto L86
            long r6 = r2 & r13
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto L3b
            if (r0 == 0) goto L28
            androidx.databinding.ObservableField<java.lang.Integer> r6 = r0.f9538c
            goto L29
        L28:
            r6 = r8
        L29:
            r1.updateRegistration(r10, r6)
            if (r6 == 0) goto L35
            java.lang.Object r6 = r6.get()
            java.lang.Integer r6 = (java.lang.Integer) r6
            goto L36
        L35:
            r6 = r8
        L36:
            int r6 = androidx.databinding.ViewDataBinding.safeUnbox(r6)
            goto L3c
        L3b:
            r6 = 0
        L3c:
            long r20 = r2 & r15
            int r7 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r7 == 0) goto L50
            if (r0 == 0) goto L49
            androidx.databinding.ObservableList<com.disabngo.blockynexus.e.b.W.b.o> r7 = r0.f9539d
            me.tatarka.bindingcollectionadapter2.g<com.disabngo.blockynexus.e.b.W.b.o> r9 = r0.f9540e
            goto L4b
        L49:
            r7 = r8
            r9 = r7
        L4b:
            r10 = 2
            r1.updateRegistration(r10, r7)
            goto L52
        L50:
            r7 = r8
            r9 = r7
        L52:
            long r21 = r2 & r11
            int r10 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r10 == 0) goto L5d
            if (r0 == 0) goto L5d
            com.sandboxol.common.command.ReplyCommand<java.lang.Integer> r10 = r0.f9541f
            goto L5e
        L5d:
            r10 = r8
        L5e:
            r18 = 25
            long r21 = r2 & r18
            int r23 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r23 == 0) goto L84
            if (r0 == 0) goto L6d
            androidx.databinding.ObservableField<java.lang.Integer> r11 = r0.f9537b
            com.sandboxol.common.command.ReplyCommand<com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters$CheckedDataWrapper> r0 = r0.g
            goto L6f
        L6d:
            r0 = r8
            r11 = r0
        L6f:
            r12 = 3
            r1.updateRegistration(r12, r11)
            if (r11 == 0) goto L7c
            java.lang.Object r11 = r11.get()
            java.lang.Integer r11 = (java.lang.Integer) r11
            goto L7d
        L7c:
            r11 = r8
        L7d:
            int r17 = androidx.databinding.ViewDataBinding.safeUnbox(r11)
            r11 = r17
            goto L8c
        L84:
            r0 = r8
            goto L8b
        L86:
            r0 = r8
            r7 = r0
            r9 = r7
            r10 = r9
            r6 = 0
        L8b:
            r11 = 0
        L8c:
            long r15 = r15 & r2
            int r12 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r12 == 0) goto L96
            androidx.viewpager.widget.ViewPager r12 = r1.i
            me.tatarka.bindingcollectionadapter2.b.a(r12, r9, r7, r8, r8)
        L96:
            long r13 = r13 & r2
            int r7 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r7 == 0) goto La1
            androidx.viewpager.widget.ViewPager r7 = r1.i
            r9 = 1
            com.sandboxol.common.binding.adapter.ViewPagerBindingAdapters.setCurrentItem(r7, r6, r9)
        La1:
            r6 = 17
            long r6 = r6 & r2
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto Lad
            androidx.viewpager.widget.ViewPager r6 = r1.i
            com.sandboxol.common.binding.adapter.ViewPagerBindingAdapters.onScrollChangeCommand(r6, r8, r10, r8)
        Lad:
            r6 = 25
            long r2 = r2 & r6
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto Lb9
            android.widget.RadioGroup r2 = r1.f7269d
            com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters.onCheckedChangeListener(r2, r0, r11)
        Lb9:
            return
        Lba:
            r0 = move-exception
            monitor-exit(r24)     // Catch: java.lang.Throwable -> Lba
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Bd.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.W.b.p) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i == 2) {
            return a((ObservableList<com.disabngo.blockynexus.e.b.W.b.o>) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return a((ObservableField<Integer>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (352 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.W.b.p) obj);
        return true;
    }

    private Bd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (Guideline) objArr[4], (Guideline) objArr[5], (AppCompatRadioButton) objArr[3], (RadioGroup) objArr[1]);
        this.j = -1L;
        this.h = (ConstraintLayout) objArr[0];
        this.h.setTag(null);
        this.i = (ViewPager) objArr[2];
        this.i.setTag(null);
        this.f7269d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.W.b.p pVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    private boolean a(ObservableList<com.disabngo.blockynexus.e.b.W.b.o> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 8;
        }
        return true;
    }
}
