package com.sandboxol.center.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.center.BR;
import com.sandboxol.center.view.dialog.CheckAppVersionDialog;

/* JADX INFO: loaded from: classes3.dex */
public class BaseDialogAppCheckAppVersionBindingImpl extends BaseDialogAppCheckAppVersionBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ImageView mboundView1;
    private final TextView mboundView2;
    private final Button mboundView3;
    private final Button mboundView4;

    public BaseDialogAppCheckAppVersionBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, sIncludes, sViewsWithIds));
    }

    private boolean onChangeCheckAppVersionDialogViewModel(CheckAppVersionDialog.CheckAppVersionDialogViewModel checkAppVersionDialogViewModel, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeCheckAppVersionDialogViewModelIsMandatory(ObservableField<Boolean> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeCheckAppVersionDialogViewModelIsShowPic(ObservableField<Boolean> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeCheckAppVersionDialogViewModelPicUrl(ObservableField<String> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeCheckAppVersionDialogViewModelUpdateText(ObservableField<String> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004c A[PHI: r2
      0x004c: PHI (r2v4 long) = (r2v0 long), (r2v9 long) binds: [B:9:0x0022, B:23:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ca  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.center.databinding.BaseDialogAppCheckAppVersionBindingImpl.executeBindings():void");
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
            this.mDirtyFlags = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeCheckAppVersionDialogViewModelIsMandatory((ObservableField) obj, i2);
        }
        if (i == 1) {
            return onChangeCheckAppVersionDialogViewModelIsShowPic((ObservableField) obj, i2);
        }
        if (i == 2) {
            return onChangeCheckAppVersionDialogViewModelPicUrl((ObservableField) obj, i2);
        }
        if (i == 3) {
            return onChangeCheckAppVersionDialogViewModel((CheckAppVersionDialog.CheckAppVersionDialogViewModel) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return onChangeCheckAppVersionDialogViewModelUpdateText((ObservableField) obj, i2);
    }

    @Override // com.sandboxol.center.databinding.BaseDialogAppCheckAppVersionBinding
    public void setCheckAppVersionDialogViewModel(CheckAppVersionDialog.CheckAppVersionDialogViewModel checkAppVersionDialogViewModel) {
        updateRegistration(3, checkAppVersionDialogViewModel);
        this.mCheckAppVersionDialogViewModel = checkAppVersionDialogViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.CheckAppVersionDialogViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.CheckAppVersionDialogViewModel != i) {
            return false;
        }
        setCheckAppVersionDialogViewModel((CheckAppVersionDialog.CheckAppVersionDialogViewModel) obj);
        return true;
    }

    private BaseDialogAppCheckAppVersionBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 5);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (LinearLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (ImageView) objArr[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (TextView) objArr[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (Button) objArr[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (Button) objArr[4];
        this.mboundView4.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
