package com.sandboxol.videosubmit.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.videosubmit.BR;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.view.dialog.signupinfo.SignUpInfoDialog;

/* JADX INFO: loaded from: classes4.dex */
public class VideosubmitDialogSignUpInfoBindingImpl extends VideosubmitDialogSignUpInfoBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final Button mboundView1;
    private final ScrollView mboundView5;
    private final DataRecyclerView mboundView6;

    static {
        sViewsWithIds.put(R.id.v, 7);
        sViewsWithIds.put(R.id.tv_title, 8);
        sViewsWithIds.put(R.id.tv_yt_name, 9);
        sViewsWithIds.put(R.id.tv_fb_name, 10);
    }

    public VideosubmitDialogSignUpInfoBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, sIncludes, sViewsWithIds));
    }

    private boolean onChangeViewModelCountryName(ObservableField<String> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelLinkCount(ObservableField<Integer> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelYoutubeName(ObservableField<String> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00db  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.videosubmit.databinding.VideosubmitDialogSignUpInfoBindingImpl.executeBindings():void");
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
            this.mDirtyFlags = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewModelYoutubeName((ObservableField) obj, i2);
        }
        if (i == 1) {
            return onChangeViewModelLinkCount((ObservableField) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeViewModelCountryName((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.ViewModel != i) {
            return false;
        }
        setViewModel((SignUpInfoDialog) obj);
        return true;
    }

    @Override // com.sandboxol.videosubmit.databinding.VideosubmitDialogSignUpInfoBinding
    public void setViewModel(SignUpInfoDialog signUpInfoDialog) {
        this.mViewModel = signUpInfoDialog;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    private VideosubmitDialogSignUpInfoBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[10], (TextView) objArr[4], (TextView) objArr[8], (TextView) objArr[9], (ConstraintLayout) objArr[7]);
        this.mDirtyFlags = -1L;
        this.etYtName.setTag(null);
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (Button) objArr[1];
        this.mboundView1.setTag(null);
        this.mboundView5 = (ScrollView) objArr[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (DataRecyclerView) objArr[6];
        this.mboundView6.setTag(null);
        this.tvCountryName.setTag(null);
        this.tvLink.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
