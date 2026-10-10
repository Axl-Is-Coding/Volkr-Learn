package com.disabngo.blockynexus.view.activity.newsearch;

import android.content.Context;
import android.widget.EditText;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.entity.FriendRequestAdd;
import com.disabngo.blockynexus.view.dialog.EditTextDialog;
import com.disabngo.blockynexus.web.FriendApi;

/* JADX INFO: compiled from: SearchFriendModel.java */
/* JADX INFO: loaded from: classes2.dex */
class m implements EditTextDialog.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f11013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f11014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f11015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ObservableField f11016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ObservableField f11017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f11018f;
    final /* synthetic */ n g;

    m(n nVar, long j, Context context, int i, ObservableField observableField, ObservableField observableField2, boolean z) {
        this.g = nVar;
        this.f11013a = j;
        this.f11014b = context;
        this.f11015c = i;
        this.f11016d = observableField;
        this.f11017e = observableField2;
        this.f11018f = z;
    }

    @Override // com.disabngo.blockynexus.view.dialog.EditTextDialog.a
    public void a(EditText editText) {
    }

    @Override // com.disabngo.blockynexus.view.dialog.EditTextDialog.a
    public void a(String str) {
        FriendRequestAdd friendRequestAdd = new FriendRequestAdd();
        friendRequestAdd.setMsg(str);
        friendRequestAdd.setFriendId(this.f11013a);
        this.g.a(this.f11014b, this.f11015c);
        FriendApi.friendAdd(this.f11014b, friendRequestAdd, new l(this));
    }
}
