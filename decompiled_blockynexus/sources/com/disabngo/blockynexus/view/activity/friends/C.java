package com.disabngo.blockynexus.view.activity.friends;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.entity.FriendRequestAdd;
import com.disabngo.blockynexus.view.dialog.EditTextDialog;
import com.disabngo.blockynexus.web.FriendApi;

/* JADX INFO: compiled from: FriendActivityModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C implements EditTextDialog.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ FriendActivityIntentInfo f10629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f10630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f10631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ F f10632d;

    C(F f2, FriendActivityIntentInfo friendActivityIntentInfo, Activity activity, int i) {
        this.f10632d = f2;
        this.f10629a = friendActivityIntentInfo;
        this.f10630b = activity;
        this.f10631c = i;
    }

    @Override // com.disabngo.blockynexus.view.dialog.EditTextDialog.a
    public void a(EditText editText) {
    }

    @Override // com.disabngo.blockynexus.view.dialog.EditTextDialog.a
    public void a(String str) {
        FriendRequestAdd friendRequestAdd = new FriendRequestAdd();
        friendRequestAdd.setMsg(str);
        friendRequestAdd.setFriendId(this.f10629a.getFriendId());
        this.f10632d.a((Context) this.f10630b, this.f10631c);
        FriendApi.friendAdd(this.f10630b, friendRequestAdd, new B(this));
    }
}
