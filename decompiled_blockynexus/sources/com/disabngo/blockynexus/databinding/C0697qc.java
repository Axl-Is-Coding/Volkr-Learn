package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.view.widget.ScrapLevelImageView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.qc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogScrapReceiveBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0697qc extends AbstractC0686pc {
    private static final ViewDataBinding.b h = null;
    private static final SparseIntArray i = new SparseIntArray();
    private final ConstraintLayout j;
    private long k;

    static {
        i.put(R.id.ivFlash, 5);
        i.put(R.id.tv_tks_tips, 6);
    }

    public C0697qc(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, h, i));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0686pc
    public void a(com.disabngo.blockynexus.view.dialog.Fa fa) {
        this.g = fa;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(470);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r14 = this;
            monitor-enter(r14)
            long r0 = r14.k     // Catch: java.lang.Throwable -> L6b
            r2 = 0
            r14.k = r2     // Catch: java.lang.Throwable -> L6b
            monitor-exit(r14)     // Catch: java.lang.Throwable -> L6b
            com.disabngo.blockynexus.view.dialog.Fa r4 = r14.g
            r5 = 3
            long r0 = r0 & r5
            r5 = 0
            r6 = 0
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 == 0) goto L3d
            if (r4 == 0) goto L1e
            com.sandboxol.common.command.ReplyCommand r7 = r4.f11291d
            com.sandboxol.imchat.message.entity.ScrapHelpMessage r8 = r4.f11290c
            com.sandboxol.common.command.ReplyCommand r9 = r4.f11292e
            com.sandboxol.common.command.ReplyCommand r4 = r4.f11293f
            goto L22
        L1e:
            r4 = r5
            r7 = r4
            r8 = r7
            r9 = r8
        L22:
            if (r8 == 0) goto L3a
            int r5 = r8.getScrapNum()
            java.lang.String r10 = r8.getScrapName()
            java.lang.String r11 = r8.getScrapUrl()
            int r8 = r8.getScrapLevel()
            r13 = r10
            r10 = r4
            r4 = r5
            r5 = r11
            r11 = r13
            goto L43
        L3a:
            r10 = r4
            r11 = r5
            goto L41
        L3d:
            r7 = r5
            r9 = r7
            r10 = r9
            r11 = r10
        L41:
            r4 = 0
            r8 = 0
        L43:
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 == 0) goto L6a
            android.view.View r0 = r14.f8680a
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r0, r9, r6, r6)
            android.view.View r0 = r14.f8681b
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r0, r7, r6, r6)
            com.sandboxol.center.view.widget.ScrapLevelImageView r0 = r14.f8683d
            com.sandboxol.center.binding.adapter.ScrapLevelViewBindingAdapter.setScrapImageViewLevel(r0, r8)
            com.sandboxol.center.view.widget.ScrapLevelImageView r0 = r14.f8683d
            com.sandboxol.center.binding.adapter.ScrapLevelViewBindingAdapter.setScrapImageViewUrl(r0, r5)
            com.sandboxol.center.view.widget.ScrapLevelImageView r0 = r14.f8683d
            com.sandboxol.center.binding.adapter.ScrapLevelViewBindingAdapter.setScrapImageViewNum(r0, r4)
            com.sandboxol.center.view.widget.ScrapLevelImageView r0 = r14.f8683d
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r0, r10, r6, r6)
            android.widget.TextView r0 = r14.f8684e
            androidx.databinding.a.e.a(r0, r11)
        L6a:
            return
        L6b:
            r0 = move-exception
            monitor-exit(r14)     // Catch: java.lang.Throwable -> L6b
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0697qc.executeBindings():void");
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
            this.k = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        if (470 != i2) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.Fa) obj);
        return true;
    }

    private C0697qc(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (View) objArr[3], (View) objArr[4], (ImageView) objArr[5], (ScrapLevelImageView) objArr[1], (TextView) objArr[2], (TextView) objArr[6]);
        this.k = -1L;
        this.f8680a.setTag(null);
        this.f8681b.setTag(null);
        this.f8683d.setTag(null);
        this.j = (ConstraintLayout) objArr[0];
        this.j.setTag(null);
        this.f8684e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
