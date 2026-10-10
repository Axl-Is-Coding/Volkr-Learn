package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.C0507d;
import com.disabngo.blockynexus.e.b.y.C0958i;
import com.disabngo.blockynexus.view.dialog.PartyTipDialog;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.RxPermissions2;
import com.sandboxol.greendao.entity.InviteMessage;
import com.sandboxol.imchat.web.error.PartyOnError;
import io.rong.imkit.RongContext;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Cb extends OnResponseListener<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PartyAuthInfo f10755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Db f10756b;

    Cb(Db db, PartyAuthInfo partyAuthInfo) {
        this.f10756b = db;
        this.f10755a = partyAuthInfo;
    }

    public /* synthetic */ void a(Context context, InviteMessage inviteMessage, PartyAuthInfo partyAuthInfo, int i, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            new C0958i().a(context, inviteMessage.getGameType(), C0507d.a(inviteMessage, partyAuthInfo.getDispUrl(), partyAuthInfo.getRegion(), i, partyAuthInfo.getCountry()), (ObservableField<Boolean>) null, this.f10756b.f10764d.f10883d);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showErrorTip(this.f10756b.f10761a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showServerError(this.f10756b.f10761a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(String str) {
        DialogUtils.newsInstant().hideLoadingDialog();
        if (TextUtils.isEmpty(this.f10756b.f10762b.getChatRoomId())) {
            Context context = this.f10756b.f10761a;
            AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.party_chat_room_id_null));
            return;
        }
        if (RongContext.getInstance() == null) {
            Context context2 = this.f10756b.f10761a;
            AppToastUtils.showShortNegativeTipToast(context2, context2.getString(R.string.party_chat_room_init_fail));
            return;
        }
        Context context3 = this.f10756b.f10761a;
        if (!(context3 instanceof MainActivity)) {
            if (context3 instanceof PartyTipDialog) {
                C0958i c0958i = new C0958i();
                Db db = this.f10756b;
                c0958i.a(db.f10761a, db.f10762b.getGameType(), C0507d.a(this.f10756b.f10762b, this.f10755a.getDispUrl(), this.f10755a.getRegion(), this.f10756b.f10763c, this.f10755a.getCountry()), (ObservableField<Boolean>) null, this.f10756b.f10764d.f10883d);
                return;
            }
            return;
        }
        io.reactivex.p<Boolean> pVarRequest = new RxPermissions2((MainActivity) context3).request("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
        Db db2 = this.f10756b;
        final Context context4 = db2.f10761a;
        final InviteMessage inviteMessage = db2.f10762b;
        final PartyAuthInfo partyAuthInfo = this.f10755a;
        final int i = db2.f10763c;
        pVarRequest.subscribe(new io.reactivex.b.g() { // from class: com.disabngo.blockynexus.view.activity.main.s
            @Override // io.reactivex.b.g
            public final void accept(Object obj) throws Exception {
                this.f10961a.a(context4, inviteMessage, partyAuthInfo, i, (Boolean) obj);
            }
        }, new Bb(this));
    }
}
