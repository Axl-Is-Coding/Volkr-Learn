package com.sandboxol.imchat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.imchat.BR;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.ui.fragment.team.TeamViewModel;

/* JADX INFO: loaded from: classes4.dex */
public class FragmentTeamBindingImpl extends FragmentTeamBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final TextView mboundView1;
    private final Button mboundView2;
    private final LinearLayout mboundView5;

    static {
        sViewsWithIds.put(R.id.rlGroup, 6);
        sViewsWithIds.put(R.id.llGroup, 7);
        sViewsWithIds.put(R.id.rvTeam, 8);
        sViewsWithIds.put(R.id.ivLoading, 9);
    }

    public FragmentTeamBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, sIncludes, sViewsWithIds));
    }

    private boolean onChangeTeamViewModel(TeamViewModel teamViewModel, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeTeamViewModelIsCaptain(ObservableField<Boolean> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeTeamViewModelIsShowLoading(ObservableField<Boolean> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeTeamViewModelTeamNumText(ObservableField<String> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0060 A[PHI: r2
      0x0060: PHI (r2v3 long) = (r2v0 long), (r2v9 long) binds: [B:14:0x0034, B:28:0x005a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d A[PHI: r2
      0x008d: PHI (r2v5 long) = (r2v4 long), (r2v7 long) binds: [B:33:0x0065, B:47:0x008b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.imchat.databinding.FragmentTeamBindingImpl.executeBindings():void");
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
            return onChangeTeamViewModelIsCaptain((ObservableField) obj, i2);
        }
        if (i == 1) {
            return onChangeTeamViewModelIsShowLoading((ObservableField) obj, i2);
        }
        if (i == 2) {
            return onChangeTeamViewModelTeamNumText((ObservableField) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return onChangeTeamViewModel((TeamViewModel) obj, i2);
    }

    @Override // com.sandboxol.imchat.databinding.FragmentTeamBinding
    public void setTeamViewModel(TeamViewModel teamViewModel) {
        updateRegistration(3, teamViewModel);
        this.mTeamViewModel = teamViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.TeamViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.TeamViewModel != i) {
            return false;
        }
        setTeamViewModel((TeamViewModel) obj);
        return true;
    }

    private FragmentTeamBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (CheckBox) objArr[3], (CheckBox) objArr[4], (ImageView) objArr[9], (LinearLayout) objArr[7], (RelativeLayout) objArr[6], (RecyclerView) objArr[8]);
        this.mDirtyFlags = -1L;
        this.cbPartyMember.setTag(null);
        this.cbPartyMember2.setTag(null);
        this.mboundView0 = (RelativeLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (TextView) objArr[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (Button) objArr[2];
        this.mboundView2.setTag(null);
        this.mboundView5 = (LinearLayout) objArr[5];
        this.mboundView5.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
