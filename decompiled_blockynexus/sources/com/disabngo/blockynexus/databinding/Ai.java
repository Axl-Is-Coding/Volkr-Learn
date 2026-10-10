package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.view.widget.MixtureTextView;

/* JADX INFO: compiled from: ItemPreheatViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ai extends AbstractC0801zi {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7284b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7285c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f7286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MixtureTextView f7287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageView f7288f;
    private long g;

    public Ai(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f7284b, f7285c));
    }

    public void a(com.disabngo.blockynexus.e.b.U.d dVar) {
        updateRegistration(0, dVar);
        this.f9051a = dVar;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
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
            long r2 = r1.g     // Catch: java.lang.Throwable -> L43
            r4 = 0
            r1.g = r4     // Catch: java.lang.Throwable -> L43
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L43
            com.disabngo.blockynexus.e.b.U.d r0 = r1.f9051a
            r6 = 7
            long r2 = r2 & r6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 == 0) goto L28
            if (r0 == 0) goto L1b
            com.disabngo.blockynexus.entity.BannerPic r0 = r0.getItem()
            goto L1c
        L1b:
            r0 = r6
        L1c:
            if (r0 == 0) goto L28
            java.lang.String r6 = r0.getPicUrl()
            java.lang.String r0 = r0.getDescribe()
            r8 = r6
            goto L2a
        L28:
            r0 = r6
            r8 = r0
        L2a:
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L42
            com.sandboxol.center.view.widget.MixtureTextView r2 = r1.f7287e
            r2.setText(r0)
            android.widget.ImageView r6 = r1.f7288f
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            com.sandboxol.common.binding.adapter.ImageViewBindingAdapters.loadImage(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
        L42:
            return
        L43:
            r0 = move-exception
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L43
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Ai.executeBindings():void");
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
        return a((com.disabngo.blockynexus.e.b.U.d) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.U.d) obj);
        return true;
    }

    private Ai(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.g = -1L;
        this.f7286d = (LinearLayout) objArr[0];
        this.f7286d.setTag(null);
        this.f7287e = (MixtureTextView) objArr[1];
        this.f7287e.setTag(null);
        this.f7288f = (ImageView) objArr[2];
        this.f7288f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.U.d dVar, int i) {
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
