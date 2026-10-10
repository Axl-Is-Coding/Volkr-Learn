package com.sandboxol.center.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import androidx.databinding.d;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.center.BR;
import com.sandboxol.center.R;
import com.sandboxol.center.utils.ViewReturnTextUtils;
import com.sandboxol.center.view.dialog.teaminvite.TeamInviteItemViewModel;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: loaded from: classes3.dex */
public class BaseItemTeamInviteBindingImpl extends BaseItemTeamInviteBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        sViewsWithIds.put(R.id.line, 5);
    }

    public BaseItemTeamInviteBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, sIncludes, sViewsWithIds));
    }

    private boolean onChangeViewModel(TeamInviteItemViewModel teamInviteItemViewModel, int i) {
        if (i == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        if (i != BR.item) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelCountDownTimeText(ObservableField<String> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelItem(Friend friend, int i) {
        if (i == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        if (i != BR.nickName) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        ReplyCommand replyCommand;
        String strFriendListStatus;
        String str2;
        String str3;
        boolean zIsEmpty;
        int i;
        int i2;
        long j2;
        int i3;
        String nickName;
        String picUrl;
        long j3;
        int i4;
        int iFriendListStatusTextColor;
        String str4;
        int i5;
        int i6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        TeamInviteItemViewModel teamInviteItemViewModel = this.mViewModel;
        if ((31 & j) != 0) {
            ReplyCommand replyCommand2 = ((j & 17) == 0 || teamInviteItemViewModel == null) ? null : teamInviteItemViewModel.onInviteClick;
            if ((j & 27) != 0) {
                Friend item = teamInviteItemViewModel != null ? teamInviteItemViewModel.getItem() : null;
                updateRegistration(1, item);
                long j4 = j & 19;
                if (j4 != 0) {
                    if (item != null) {
                        String gameName = item.getGameName();
                        int status = item.getStatus();
                        int totalStatus = item.getTotalStatus();
                        picUrl = item.getPicUrl();
                        str4 = gameName;
                        i6 = status;
                        i5 = totalStatus;
                    } else {
                        str4 = null;
                        picUrl = null;
                        i5 = 0;
                        i6 = 0;
                    }
                    boolean z = i6 == 30;
                    strFriendListStatus = ViewReturnTextUtils.friendListStatus(i5, str4);
                    iFriendListStatusTextColor = ViewReturnTextUtils.friendListStatusTextColor(i5);
                    if (j4 != 0) {
                        j |= z ? 64L : 32L;
                    }
                    i4 = z ? 8 : 0;
                } else {
                    strFriendListStatus = null;
                    picUrl = null;
                    i4 = 0;
                    iFriendListStatusTextColor = 0;
                }
                nickName = item != null ? item.getNickName() : null;
                j3 = 21;
                int i7 = iFriendListStatusTextColor;
                i2 = i4;
                i = i7;
            } else {
                nickName = null;
                strFriendListStatus = null;
                picUrl = null;
                i = 0;
                i2 = 0;
                j3 = 21;
            }
            if ((j & j3) != 0) {
                ObservableField<String> observableField = teamInviteItemViewModel != null ? teamInviteItemViewModel.countDownTimeText : null;
                updateRegistration(2, observableField);
                str = observableField != null ? observableField.get() : null;
                zIsEmpty = TextUtils.isEmpty(str);
                str2 = nickName;
                str3 = picUrl;
            } else {
                str2 = nickName;
                str3 = picUrl;
                zIsEmpty = false;
            }
            replyCommand = replyCommand2;
            str = str;
        } else {
            str = null;
            replyCommand = null;
            strFriendListStatus = null;
            str2 = null;
            str3 = null;
            zIsEmpty = false;
            i = 0;
            i2 = 0;
        }
        long j5 = 19 & j;
        if (j5 != 0) {
            i3 = R.mipmap.ic_head_default;
            j2 = 21;
        } else {
            j2 = 21;
            i3 = 0;
        }
        if ((j & j2) != 0) {
            this.btnJoin.setEnabled(zIsEmpty);
            e.a(this.btnJoin, str);
        }
        if (j5 != 0) {
            this.btnJoin.setVisibility(i2);
            ImageViewBindingAdapters.loadImage(this.icHead, 0, str3, i3, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            e.a(this.tvStatus, strFriendListStatus);
            this.tvStatus.setTextColor(i);
        }
        if ((17 & j) != 0) {
            ViewBindingAdapters.clickCommand(this.btnJoin, replyCommand, false, 0);
        }
        if ((j & 27) != 0) {
            e.a(this.tvNickName, str2);
        }
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
            return onChangeViewModel((TeamInviteItemViewModel) obj, i2);
        }
        if (i == 1) {
            return onChangeViewModelItem((Friend) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeViewModelCountDownTimeText((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.ViewModel != i) {
            return false;
        }
        setViewModel((TeamInviteItemViewModel) obj);
        return true;
    }

    @Override // com.sandboxol.center.databinding.BaseItemTeamInviteBinding
    public void setViewModel(TeamInviteItemViewModel teamInviteItemViewModel) {
        updateRegistration(0, teamInviteItemViewModel);
        this.mViewModel = teamInviteItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    private BaseItemTeamInviteBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (Button) objArr[4], (ImageView) objArr[1], (View) objArr[5], (TextView) objArr[2], (TextView) objArr[3]);
        this.mDirtyFlags = -1L;
        this.btnJoin.setTag(null);
        this.icHead.setTag(null);
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.tvNickName.setTag(null);
        this.tvStatus.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
