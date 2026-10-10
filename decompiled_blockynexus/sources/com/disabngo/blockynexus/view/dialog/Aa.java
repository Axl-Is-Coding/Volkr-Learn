package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Cb;
import com.disabngo.blockynexus.entity.UserMapInfo;
import com.disabngo.blockynexus.interfaces.OnViewClickListener;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.messenger.Messenger;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: FriendMatchGuideDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class Aa extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OnViewClickListener f11255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OnDataListener<UserMapInfo> f11256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private UserMapInfo f11257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f11258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f11259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f11260f;
    public ReplyCommand g;

    public Aa(Context context) {
        super(context);
        this.f11258d = new ObservableField<>(true);
        this.f11259e = new ObservableField<>(false);
        this.f11260f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.u
            @Override // rx.functions.Action0
            public final void call() {
                this.f11687a.a();
            }
        });
        this.g = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.s
            @Override // rx.functions.Action0
            public final void call() {
                this.f11680a.b();
            }
        });
        initView();
        initMessenger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        UserMapInfo userMapInfo;
        this.f11259e.set(false);
        OnDataListener<UserMapInfo> onDataListener = this.f11256b;
        if (onDataListener != null && (userMapInfo = this.f11257c) != null) {
            onDataListener.onSuccess(userMapInfo);
        }
        dismiss();
    }

    public /* synthetic */ void a(UserMapInfo userMapInfo) {
        this.f11259e.set(true);
        this.f11257c = userMapInfo;
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Messenger.getDefault().unregister(this);
    }

    public void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_MAP_FRIEND_USER_INFO, UserMapInfo.class, new Action1() { // from class: com.disabngo.blockynexus.view.dialog.t
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f11685a.a((UserMapInfo) obj);
            }
        });
    }

    public void initView() {
        Cb cb = (Cb) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_friend_match_guide, (ViewGroup) null, false);
        cb.a(this);
        setContentView(cb.getRoot());
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == keyEvent.getKeyCode()) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public Aa a(OnViewClickListener onViewClickListener, OnDataListener<UserMapInfo> onDataListener) {
        this.f11255a = onViewClickListener;
        this.f11256b = onDataListener;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f11258d.set(false);
        OnViewClickListener onViewClickListener = this.f11255a;
        if (onViewClickListener != null) {
            onViewClickListener.onClick();
        }
    }
}
