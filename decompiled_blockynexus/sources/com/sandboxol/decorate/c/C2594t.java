package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.view.dialog.d;

/* JADX INFO: renamed from: com.sandboxol.decorate.c.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogDressShopGuideBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2594t extends AbstractC2593s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f17116e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f17117f = new SparseIntArray();
    private final LinearLayout g;
    private final ImageView h;
    private long i;

    static {
        f17117f.put(R.id.ll_dress_shop_point_container, 3);
        f17117f.put(R.id.tv_dress_shop_guide_tip, 4);
    }

    public C2594t(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f17116e, f17117f));
    }

    @Override // com.sandboxol.decorate.c.AbstractC2593s
    public void a(d.b bVar) {
        updateRegistration(1, bVar);
        this.f17115d = bVar;
        synchronized (this) {
            this.i |= 2;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.B);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r17 = this;
            r1 = r17
            monitor-enter(r17)
            long r2 = r1.i     // Catch: java.lang.Throwable -> L58
            r4 = 0
            r1.i = r4     // Catch: java.lang.Throwable -> L58
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L58
            com.sandboxol.decorate.view.dialog.d$b r0 = r1.f17115d
            r6 = 7
            long r6 = r6 & r2
            r8 = 6
            r10 = 0
            r11 = 0
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 == 0) goto L35
            if (r0 == 0) goto L1e
            me.tatarka.bindingcollectionadapter2.g<com.sandboxol.common.base.viewmodel.ListItemViewModel<com.sandboxol.common.base.viewmodel.ViewModel>> r12 = r0.f17375f
            androidx.databinding.ObservableList<com.sandboxol.common.base.viewmodel.ViewModel> r13 = r0.f17373d
            goto L20
        L1e:
            r12 = r11
            r13 = r12
        L20:
            r1.updateRegistration(r10, r13)
            long r14 = r2 & r8
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 == 0) goto L32
            if (r0 == 0) goto L32
            int r14 = r0.f17370a
            com.sandboxol.common.command.ReplyCommand r15 = r0.h
            com.sandboxol.common.command.ReplyCommand<java.lang.Integer> r0 = r0.g
            goto L3a
        L32:
            r0 = r11
            r15 = r0
            goto L39
        L35:
            r0 = r11
            r12 = r0
            r13 = r12
            r15 = r13
        L39:
            r14 = 0
        L3a:
            long r2 = r2 & r8
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 == 0) goto L4e
            android.widget.ImageView r2 = r1.h
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r2, r15, r10, r10)
            androidx.viewpager.widget.ViewPager r2 = r1.f17114c
            com.sandboxol.common.binding.adapter.ViewPagerBindingAdapters.onScrollChangeCommand(r2, r11, r0, r11)
            androidx.viewpager.widget.ViewPager r0 = r1.f17114c
            com.sandboxol.common.binding.adapter.ViewPagerBindingAdapters.setCurrentItem(r0, r14, r10)
        L4e:
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L57
            androidx.viewpager.widget.ViewPager r0 = r1.f17114c
            me.tatarka.bindingcollectionadapter2.b.a(r0, r12, r13, r11, r11)
        L57:
            return
        L58:
            r0 = move-exception
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L58
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.decorate.c.C2594t.executeBindings():void");
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
        if (i == 0) {
            return a((ObservableList<ViewModel>) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((d.b) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.B != i) {
            return false;
        }
        a((d.b) obj);
        return true;
    }

    private C2594t(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (LinearLayout) objArr[3], (TextView) objArr[4], (ViewPager) objArr[2]);
        this.i = -1L;
        this.g = (LinearLayout) objArr[0];
        this.g.setTag(null);
        this.h = (ImageView) objArr[1];
        this.h.setTag(null);
        this.f17114c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableList<ViewModel> observableList, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.i |= 1;
        }
        return true;
    }

    private boolean a(d.b bVar, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.i |= 2;
        }
        return true;
    }
}
