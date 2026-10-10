package com.sandboxol.center.databinding;

import android.text.Spanned;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.center.BR;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.ScrapMakeSureDialog;
import com.sandboxol.center.view.widget.ScrapLevelImageView;

/* JADX INFO: loaded from: classes3.dex */
public class BaseDialogScrapMakeSureBindingImpl extends BaseDialogScrapMakeSureBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        sViewsWithIds.put(R.id.bg_content, 5);
        sViewsWithIds.put(R.id.bg_btn, 6);
    }

    public BaseDialogScrapMakeSureBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, sIncludes, sViewsWithIds));
    }

    private boolean onChangeScrapMakeSureDialogTips(ObservableField<Spanned> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
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
            long r2 = r1.mDirtyFlags     // Catch: java.lang.Throwable -> L84
            r4 = 0
            r1.mDirtyFlags = r4     // Catch: java.lang.Throwable -> L84
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L84
            com.sandboxol.center.view.dialog.ScrapMakeSureDialog r0 = r1.mScrapMakeSureDialog
            r6 = 7
            long r6 = r6 & r2
            r8 = 6
            r10 = 0
            r11 = 0
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 == 0) goto L57
            long r12 = r2 & r8
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 == 0) goto L3b
            if (r0 == 0) goto L26
            com.sandboxol.common.command.ReplyCommand r12 = r0.onSureCommand
            com.sandboxol.common.command.ReplyCommand r13 = r0.onCancelCommand
            com.sandboxol.center.entity.ScrapMakeSureInfo r14 = r0.message
            goto L29
        L26:
            r12 = r10
            r13 = r12
            r14 = r13
        L29:
            if (r14 == 0) goto L38
            int r15 = r14.getScrapLevel()
            java.lang.String r16 = r14.getScrapPic()
            int r14 = r14.getScrapNum()
            goto L41
        L38:
            r16 = r10
            goto L3f
        L3b:
            r12 = r10
            r13 = r12
            r16 = r13
        L3f:
            r14 = 0
            r15 = 0
        L41:
            if (r0 == 0) goto L46
            androidx.databinding.ObservableField<android.text.Spanned> r0 = r0.tips
            goto L47
        L46:
            r0 = r10
        L47:
            r1.updateRegistration(r11, r0)
            if (r0 == 0) goto L53
            java.lang.Object r0 = r0.get()
            r10 = r0
            android.text.Spanned r10 = (android.text.Spanned) r10
        L53:
            r0 = r10
            r10 = r16
            goto L5c
        L57:
            r0 = r10
            r12 = r0
            r13 = r12
            r14 = 0
            r15 = 0
        L5c:
            long r2 = r2 & r8
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 == 0) goto L7a
            com.sandboxol.center.view.widget.ScrapLevelImageView r2 = r1.ivScrap
            com.sandboxol.center.binding.adapter.ScrapLevelViewBindingAdapter.setScrapImageViewLevel(r2, r15)
            com.sandboxol.center.view.widget.ScrapLevelImageView r2 = r1.ivScrap
            com.sandboxol.center.binding.adapter.ScrapLevelViewBindingAdapter.setScrapImageViewUrl(r2, r10)
            com.sandboxol.center.view.widget.ScrapLevelImageView r2 = r1.ivScrap
            com.sandboxol.center.binding.adapter.ScrapLevelViewBindingAdapter.setScrapImageViewNum(r2, r14)
            android.widget.TextView r2 = r1.tvCancel
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r2, r13, r11, r11)
            android.widget.TextView r2 = r1.tvSure
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r2, r12, r11, r11)
        L7a:
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 == 0) goto L83
            android.widget.TextView r2 = r1.tvTitle
            androidx.databinding.a.e.a(r2, r0)
        L83:
            return
        L84:
            r0 = move-exception
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L84
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.center.databinding.BaseDialogScrapMakeSureBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeScrapMakeSureDialogTips((ObservableField) obj, i2);
    }

    @Override // com.sandboxol.center.databinding.BaseDialogScrapMakeSureBinding
    public void setScrapMakeSureDialog(ScrapMakeSureDialog scrapMakeSureDialog) {
        this.mScrapMakeSureDialog = scrapMakeSureDialog;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.ScrapMakeSureDialog);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.ScrapMakeSureDialog != i) {
            return false;
        }
        setScrapMakeSureDialog((ScrapMakeSureDialog) obj);
        return true;
    }

    private BaseDialogScrapMakeSureBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (View) objArr[6], (View) objArr[5], (ScrapLevelImageView) objArr[2], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.ivScrap.setTag(null);
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.tvCancel.setTag(null);
        this.tvSure.setTag(null);
        this.tvTitle.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
