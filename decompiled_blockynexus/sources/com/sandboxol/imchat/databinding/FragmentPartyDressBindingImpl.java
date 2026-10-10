package com.sandboxol.imchat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.imchat.BR;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.ui.fragment.partydress.PartyDressViewModel;

/* JADX INFO: loaded from: classes4.dex */
public class FragmentPartyDressBindingImpl extends FragmentPartyDressBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView2;
    private final LinearLayout mboundView3;

    static {
        sViewsWithIds.put(R.id.tv_top, 4);
        sViewsWithIds.put(R.id.ivLoading, 5);
    }

    public FragmentPartyDressBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, sIncludes, sViewsWithIds));
    }

    private boolean onChangeViewModel(PartyDressViewModel partyDressViewModel, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelIsHideBgImage(ObservableField<Boolean> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelIsShowLoading(ObservableField<Boolean> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004a A[PHI: r2
      0x004a: PHI (r2v4 long) = (r2v0 long), (r2v11 long) binds: [B:9:0x001e, B:23:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r16 = this;
            r1 = r16
            monitor-enter(r16)
            long r2 = r1.mDirtyFlags     // Catch: java.lang.Throwable -> La4
            r4 = 0
            r1.mDirtyFlags = r4     // Catch: java.lang.Throwable -> La4
            monitor-exit(r16)     // Catch: java.lang.Throwable -> La4
            com.sandboxol.imchat.ui.fragment.partydress.PartyDressViewModel r0 = r1.mViewModel
            r6 = 15
            long r6 = r6 & r2
            r8 = 11
            r10 = 13
            int r13 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r13 == 0) goto L86
            long r6 = r2 & r8
            r13 = 8
            r14 = 0
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 == 0) goto L4a
            if (r0 == 0) goto L25
            androidx.databinding.ObservableField<java.lang.Boolean> r15 = r0.isShowLoading
            goto L26
        L25:
            r15 = r14
        L26:
            r12 = 1
            r1.updateRegistration(r12, r15)
            if (r15 == 0) goto L33
            java.lang.Object r12 = r15.get()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            goto L34
        L33:
            r12 = r14
        L34:
            boolean r12 = androidx.databinding.ViewDataBinding.safeUnbox(r12)
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 == 0) goto L44
            if (r12 == 0) goto L41
            r6 = 128(0x80, double:6.3E-322)
            goto L43
        L41:
            r6 = 64
        L43:
            long r2 = r2 | r6
        L44:
            if (r12 == 0) goto L47
            goto L4a
        L47:
            r12 = 8
            goto L4b
        L4a:
            r12 = 0
        L4b:
            long r6 = r2 & r10
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 == 0) goto L84
            if (r0 == 0) goto L56
            androidx.databinding.ObservableField<java.lang.Boolean> r0 = r0.isHideBgImage
            goto L57
        L56:
            r0 = r14
        L57:
            r15 = 2
            r1.updateRegistration(r15, r0)
            if (r0 == 0) goto L64
            java.lang.Object r0 = r0.get()
            r14 = r0
            java.lang.Boolean r14 = (java.lang.Boolean) r14
        L64:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox(r14)
            int r14 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r14 == 0) goto L7a
            if (r0 == 0) goto L74
            r6 = 32
            long r2 = r2 | r6
            r6 = 512(0x200, double:2.53E-321)
            goto L79
        L74:
            r6 = 16
            long r2 = r2 | r6
            r6 = 256(0x100, double:1.265E-321)
        L79:
            long r2 = r2 | r6
        L7a:
            if (r0 == 0) goto L7d
            goto L7e
        L7d:
            r13 = 0
        L7e:
            if (r0 == 0) goto L82
            r0 = 0
            goto L89
        L82:
            r0 = 4
            goto L89
        L84:
            r0 = 0
            goto L88
        L86:
            r0 = 0
            r12 = 0
        L88:
            r13 = 0
        L89:
            long r6 = r2 & r10
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 == 0) goto L99
            android.widget.FrameLayout r6 = r1.dressViewGroup
            r6.setVisibility(r0)
            android.widget.ImageView r0 = r1.mboundView2
            r0.setVisibility(r13)
        L99:
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto La3
            android.widget.LinearLayout r0 = r1.mboundView3
            r0.setVisibility(r12)
        La3:
            return
        La4:
            r0 = move-exception
            monitor-exit(r16)     // Catch: java.lang.Throwable -> La4
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.imchat.databinding.FragmentPartyDressBindingImpl.executeBindings():void");
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
            this.mDirtyFlags = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewModel((PartyDressViewModel) obj, i2);
        }
        if (i == 1) {
            return onChangeViewModelIsShowLoading((ObservableField) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeViewModelIsHideBgImage((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.ViewModel != i) {
            return false;
        }
        setViewModel((PartyDressViewModel) obj);
        return true;
    }

    @Override // com.sandboxol.imchat.databinding.FragmentPartyDressBinding
    public void setViewModel(PartyDressViewModel partyDressViewModel) {
        updateRegistration(0, partyDressViewModel);
        this.mViewModel = partyDressViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    private FragmentPartyDressBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (FrameLayout) objArr[1], (ImageView) objArr[5], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.dressViewGroup.setTag(null);
        this.mboundView0 = (RelativeLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (ImageView) objArr[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (LinearLayout) objArr[3];
        this.mboundView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
