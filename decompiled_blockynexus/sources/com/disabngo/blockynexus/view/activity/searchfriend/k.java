package com.disabngo.blockynexus.view.activity.searchfriend;

import android.content.Context;
import android.widget.EditText;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.entity.FriendRequestAdd;
import com.disabngo.blockynexus.view.dialog.EditTextDialog;
import com.disabngo.blockynexus.web.FriendApi;

/* JADX INFO: compiled from: SearchFriendModel.java */
/* JADX INFO: loaded from: classes2.dex */
class k implements EditTextDialog.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f11075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f11076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ObservableField f11077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ObservableField f11078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f11079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ l f11080f;

    k(l lVar, long j, Context context, ObservableField observableField, ObservableField observableField2, boolean z) {
        this.f11080f = lVar;
        this.f11075a = j;
        this.f11076b = context;
        this.f11077c = observableField;
        this.f11078d = observableField2;
        this.f11079e = z;
    }

    @Override // com.disabngo.blockynexus.view.dialog.EditTextDialog.a
    public void a(EditText editText) {
    }

    @Override // com.disabngo.blockynexus.view.dialog.EditTextDialog.a
    public void a(String str) {
        FriendRequestAdd friendRequestAdd = new FriendRequestAdd();
        friendRequestAdd.setMsg(str);
        friendRequestAdd.setFriendId(this.f11075a);
        FriendApi.friendAdd(this.f11076b, friendRequestAdd, new j(this));
    }
}
