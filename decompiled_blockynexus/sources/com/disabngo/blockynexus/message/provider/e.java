package com.disabngo.blockynexus.message.provider;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import androidx.fragment.app.FragmentActivity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.C0507d;
import com.disabngo.blockynexus.e.b.y.C0958i;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.RxPermissions2;
import com.sandboxol.common.utils.ToastUtils;
import com.sandboxol.imchat.message.entity.InviteTeamMessage;
import com.sandboxol.imchat.utils.DialogUtils;
import com.sandboxol.imchat.web.error.PartyOnError;
import io.reactivex.p;
import io.rong.imkit.RongContext;
import io.rong.imkit.model.UIMessage;

/* JADX INFO: compiled from: InviteTeamMessageProvider.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends OnResponseListener<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PartyAuthInfo f10452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ f f10453b;

    e(f fVar, PartyAuthInfo partyAuthInfo) {
        this.f10453b = fVar;
        this.f10452a = partyAuthInfo;
    }

    public /* synthetic */ void a(Context context, InviteTeamMessage inviteTeamMessage, UIMessage uIMessage, PartyAuthInfo partyAuthInfo, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            new C0958i().a(context, inviteTeamMessage.getGameType(), C0507d.a(inviteTeamMessage, uIMessage.getUId(), partyAuthInfo.getDispUrl(), partyAuthInfo.getRegion(), partyAuthInfo.getCountry()), (ObservableField<Boolean>) null, this.f10453b.f10457d.g);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showErrorTip(this.f10453b.f10454a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showServerError(this.f10453b.f10454a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(String str) {
        DialogUtils.newsInstant().hideLoadingDialog();
        if (TextUtils.isEmpty(this.f10453b.f10455b.getChatRoomId())) {
            Context context = this.f10453b.f10454a;
            ToastUtils.showShortToast(context, context.getString(R.string.inner_error));
            return;
        }
        if (RongContext.getInstance() == null) {
            Context context2 = this.f10453b.f10454a;
            ToastUtils.showShortToast(context2, context2.getString(R.string.inner_error));
            return;
        }
        Context context3 = this.f10453b.f10454a;
        if (context3 instanceof FragmentActivity) {
            p<Boolean> pVarRequest = new RxPermissions2((FragmentActivity) context3).request("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
            f fVar = this.f10453b;
            final Context context4 = fVar.f10454a;
            final InviteTeamMessage inviteTeamMessage = fVar.f10455b;
            final UIMessage uIMessage = fVar.f10456c;
            final PartyAuthInfo partyAuthInfo = this.f10452a;
            pVarRequest.subscribe(new io.reactivex.b.g() { // from class: com.disabngo.blockynexus.message.provider.a
                @Override // io.reactivex.b.g
                public final void accept(Object obj) throws Exception {
                    this.f10443a.a(context4, inviteTeamMessage, uIMessage, partyAuthInfo, (Boolean) obj);
                }
            }, new io.reactivex.b.g() { // from class: com.disabngo.blockynexus.message.provider.b
                @Override // io.reactivex.b.g
                public final void accept(Object obj) {
                    ((Throwable) obj).printStackTrace();
                }
            });
        }
    }
}
