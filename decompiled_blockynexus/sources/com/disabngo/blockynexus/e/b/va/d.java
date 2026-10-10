package com.disabngo.blockynexus.e.b.va;

import android.content.Context;
import androidx.databinding.ObservableField;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.F;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.H.e;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.imchat.config.ChatMessageToken;
import rx.functions.Action1;

/* JADX INFO: compiled from: VerificationViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f10251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.disabngo.blockynexus.e.b.Q.d f10252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f10253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BaseFragment f10254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Integer> f10255f = new ObservableField<>(Integer.valueOf(R.id.rbFriend));
    public ObservableField<Boolean> g = new ObservableField<>(false);
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> h = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.va.b
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f10248a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
        }
    });

    public d(Context context, c cVar, int i) {
        this.f10250a = context;
        this.f10251b = cVar;
        f();
        b(R.id.rbFriend);
        initMessenger();
        this.g.set(Boolean.valueOf(i == 1));
    }

    private void b(int i) {
        switch (i) {
            case R.id.rbFriend /* 2131297300 */:
                a(this.f10252c);
                break;
            case R.id.rbGroup /* 2131297301 */:
                a(this.f10253d);
                Messenger.getDefault().send(false, ChatMessageToken.TOKEN_GET_GROUP_INVITE_APPLY_MESSAGE);
                break;
        }
    }

    private void f() {
        AbstractC0336n fragmentManager = this.f10251b.getFragmentManager();
        if (fragmentManager != null) {
            F fA = fragmentManager.a();
            if (this.f10253d == null) {
                this.f10253d = new e();
                if (fragmentManager.a("GroupVerificationFragment") == null) {
                    fA.a(R.id.flContent, this.f10253d, "GroupVerificationFragment");
                    fA.c(this.f10253d);
                }
            }
            if (this.f10252c == null) {
                this.f10252c = new com.disabngo.blockynexus.e.b.Q.d();
                if (fragmentManager.a("NewFriendFragment") == null) {
                    fA.a(R.id.flContent, this.f10252c, "NewFriendFragment");
                    fA.e(this.f10252c);
                }
            }
            fA.b();
        }
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_GET_GROUP_INVITE_APPLY_MESSAGE, Boolean.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.va.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10247a.a((Boolean) obj);
            }
        });
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        b(checkedDataWrapper.getCheckedId());
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        Messenger.getDefault().unregister(this);
        super.onDestroy();
    }

    private void a(BaseFragment baseFragment) {
        AbstractC0336n fragmentManager = this.f10251b.getFragmentManager();
        if (fragmentManager != null) {
            F fA = fragmentManager.a();
            fA.a(0);
            BaseFragment baseFragment2 = this.f10254e;
            if (baseFragment2 != null) {
                fA.c(baseFragment2);
            }
            fA.e(baseFragment);
            fA.b();
            this.f10254e = baseFragment;
        }
    }

    public /* synthetic */ void a(Boolean bool) {
        this.g.set(bool);
    }
}
