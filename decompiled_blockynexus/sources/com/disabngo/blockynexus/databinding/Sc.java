package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.FollowFriendBottomDialog;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.FriendFollowResponse;

/* JADX INFO: compiled from: FollowDialogFollowFriendBottomBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Sc extends Rc {
    private static final ViewDataBinding.b h = null;
    private static final SparseIntArray i = new SparseIntArray();
    private final RelativeLayout j;
    private final View k;
    private final ImageView l;
    private final TextView m;
    private final Button n;
    private long o;

    static {
        i.put(R.id.llGameName, 9);
        i.put(R.id.ll_dialog, 10);
    }

    public Sc(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, h, i));
    }

    @Override // com.disabngo.blockynexus.databinding.Rc
    public void a(FollowFriendBottomDialog followFriendBottomDialog) {
        this.g = followFriendBottomDialog;
        synchronized (this) {
            this.o |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        int i2;
        int i3;
        ReplyCommand replyCommand;
        String str;
        ReplyCommand replyCommand2;
        ReplyCommand replyCommand3;
        String str2;
        String str3;
        String gameName;
        ReplyCommand replyCommand4;
        FriendFollowResponse friendFollowResponse;
        int status;
        String gamePic;
        synchronized (this) {
            j = this.o;
            this.o = 0L;
        }
        FollowFriendBottomDialog followFriendBottomDialog = this.g;
        if ((j & 7) != 0) {
            long j3 = j & 6;
            if (j3 != 0) {
                if (followFriendBottomDialog != null) {
                    replyCommand3 = followFriendBottomDialog.f11298e;
                    replyCommand4 = followFriendBottomDialog.f11296c;
                    friendFollowResponse = followFriendBottomDialog.f11295b;
                    replyCommand2 = followFriendBottomDialog.f11297d;
                } else {
                    replyCommand2 = null;
                    replyCommand4 = null;
                    friendFollowResponse = null;
                    replyCommand3 = null;
                }
                if (friendFollowResponse != null) {
                    status = friendFollowResponse.getStatus();
                    gameName = friendFollowResponse.getGameName();
                    gamePic = friendFollowResponse.getGamePic();
                } else {
                    status = 0;
                    gamePic = null;
                    gameName = null;
                }
                boolean z = status == 15;
                if (j3 != 0) {
                    j |= z ? 16L : 8L;
                }
                i3 = z ? 0 : 8;
                replyCommand = replyCommand4;
                str3 = gamePic;
            } else {
                i3 = 0;
                replyCommand = null;
                replyCommand2 = null;
                str3 = null;
                replyCommand3 = null;
                gameName = null;
            }
            ObservableField<Boolean> observableField = followFriendBottomDialog != null ? followFriendBottomDialog.f11299f : null;
            updateRegistration(0, observableField);
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            if ((j & 7) != 0) {
                j |= zSafeUnbox ? 64L : 32L;
            }
            str2 = str3;
            i2 = zSafeUnbox ? 0 : 8;
            str = gameName;
            j2 = 7;
        } else {
            j2 = 7;
            i2 = 0;
            i3 = 0;
            replyCommand = null;
            str = null;
            replyCommand2 = null;
            replyCommand3 = null;
            str2 = null;
        }
        if ((j2 & j) != 0) {
            this.j.setVisibility(i2);
        }
        if ((j & 6) != 0) {
            ViewBindingAdapters.clickCommand(this.k, replyCommand, false, 0);
            ImageViewBindingAdapters.loadImage(this.l, 0, str2, 0, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            ViewBindingAdapters.clickCommand(this.l, replyCommand3, false, 0);
            this.m.setVisibility(i3);
            ViewBindingAdapters.clickCommand(this.n, replyCommand2, false, 0);
            androidx.databinding.a.e.a(this.f7830d, str);
            ViewBindingAdapters.clickCommand(this.f7831e, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.f7832f, replyCommand3, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a((ObservableField) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        if (2 != i2) {
            return false;
        }
        a((FollowFriendBottomDialog) obj);
        return true;
    }

    private Sc(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (LinearLayout) objArr[0], (LinearLayout) objArr[10], (LinearLayout) objArr[9], (TextView) objArr[6], (View) objArr[1], (View) objArr[5]);
        this.o = -1L;
        this.f7827a.setTag(null);
        this.j = (RelativeLayout) objArr[2];
        this.j.setTag(null);
        this.k = (View) objArr[3];
        this.k.setTag(null);
        this.l = (ImageView) objArr[4];
        this.l.setTag(null);
        this.m = (TextView) objArr[7];
        this.m.setTag(null);
        this.n = (Button) objArr[8];
        this.n.setTag(null);
        this.f7830d.setTag(null);
        this.f7831e.setTag(null);
        this.f7832f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 1;
        }
        return true;
    }
}
