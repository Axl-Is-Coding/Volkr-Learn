package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.gg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentVerificationBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0592gg extends AbstractC0581fg {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f8376e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f8377f = new SparseIntArray();
    private final LinearLayout g;
    private final RadioGroup h;
    private final ImageView i;
    private long j;

    static {
        f8377f.put(R.id.rbFriend, 3);
        f8377f.put(R.id.rbGroup, 4);
        f8377f.put(R.id.flContent, 5);
    }

    public C0592gg(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f8376e, f8377f));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0581fg
    public void a(com.disabngo.blockynexus.e.b.va.d dVar) {
        updateRegistration(1, dVar);
        this.f8341d = dVar;
        synchronized (this) {
            this.j |= 2;
        }
        notifyPropertyChanged(303);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0045 A[PHI: r0
      0x0045: PHI (r0v5 long) = (r0v1 long), (r0v7 long) binds: [B:8:0x001b, B:22:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r15 = this;
            monitor-enter(r15)
            long r0 = r15.j     // Catch: java.lang.Throwable -> L7e
            r2 = 0
            r15.j = r2     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r15)     // Catch: java.lang.Throwable -> L7e
            com.disabngo.blockynexus.e.b.va.d r4 = r15.f8341d
            r5 = 15
            long r5 = r5 & r0
            r7 = 11
            r9 = 14
            r11 = 0
            r12 = 0
            int r13 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r13 == 0) goto L68
            long r5 = r0 & r7
            int r13 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r13 == 0) goto L45
            if (r4 == 0) goto L22
            androidx.databinding.ObservableField<java.lang.Boolean> r13 = r4.g
            goto L23
        L22:
            r13 = r12
        L23:
            r15.updateRegistration(r11, r13)
            if (r13 == 0) goto L2f
            java.lang.Object r13 = r13.get()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            goto L30
        L2f:
            r13 = r12
        L30:
            boolean r13 = androidx.databinding.ViewDataBinding.safeUnbox(r13)
            int r14 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r14 == 0) goto L40
            if (r13 == 0) goto L3d
            r5 = 32
            goto L3f
        L3d:
            r5 = 16
        L3f:
            long r0 = r0 | r5
        L40:
            if (r13 == 0) goto L43
            goto L45
        L43:
            r5 = 4
            goto L46
        L45:
            r5 = 0
        L46:
            long r13 = r0 & r9
            int r6 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r6 == 0) goto L69
            if (r4 == 0) goto L53
            com.sandboxol.common.command.ReplyCommand<com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters$CheckedDataWrapper> r6 = r4.h
            androidx.databinding.ObservableField<java.lang.Integer> r4 = r4.f10255f
            goto L55
        L53:
            r4 = r12
            r6 = r4
        L55:
            r11 = 2
            r15.updateRegistration(r11, r4)
            if (r4 == 0) goto L62
            java.lang.Object r4 = r4.get()
            r12 = r4
            java.lang.Integer r12 = (java.lang.Integer) r12
        L62:
            int r11 = androidx.databinding.ViewDataBinding.safeUnbox(r12)
            r12 = r6
            goto L69
        L68:
            r5 = 0
        L69:
            long r9 = r9 & r0
            int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r4 == 0) goto L73
            android.widget.RadioGroup r4 = r15.h
            com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters.onCheckedChangeListener(r4, r12, r11)
        L73:
            long r0 = r0 & r7
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L7d
            android.widget.ImageView r0 = r15.i
            r0.setVisibility(r5)
        L7d:
            return
        L7e:
            r0 = move-exception
            monitor-exit(r15)     // Catch: java.lang.Throwable -> L7e
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0592gg.executeBindings():void");
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
            this.j = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return b((ObservableField) obj, i2);
        }
        if (i == 1) {
            return a((com.disabngo.blockynexus.e.b.va.d) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((ObservableField<Integer>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (303 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.va.d) obj);
        return true;
    }

    private C0592gg(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (FrameLayout) objArr[5], (AppCompatRadioButton) objArr[3], (AppCompatRadioButton) objArr[4]);
        this.j = -1L;
        this.g = (LinearLayout) objArr[0];
        this.g.setTag(null);
        this.h = (RadioGroup) objArr[1];
        this.h.setTag(null);
        this.i = (ImageView) objArr[2];
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.va.d dVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 4;
        }
        return true;
    }
}
