package com.sandboxol.blockmango.webvideo;

import android.app.Activity;
import com.just.agentweb.AgentWeb;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.game.a.AbstractC2664c;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes2.dex */
public class WebVideoViewModel extends ViewModel {
    private Activity activity;
    private AgentWeb agentWeb;
    public ReplyCommand onCloseCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.blockmango.webvideo.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f16281a.onClose();
        }
    });
    private WebVideoModel model = new WebVideoModel();

    WebVideoViewModel(Activity activity, AbstractC2664c abstractC2664c, String str) {
        this.activity = activity;
        if (str == null || this.agentWeb != null) {
            return;
        }
        this.agentWeb = this.model.initAgentWebView(activity, abstractC2664c.f17666a, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClose() {
        Activity activity = this.activity;
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        AgentWeb agentWeb = this.agentWeb;
        if (agentWeb != null) {
            agentWeb.getWebLifeCycle().onDestroy();
        }
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onPause() {
        AgentWeb agentWeb = this.agentWeb;
        if (agentWeb != null) {
            agentWeb.getWebLifeCycle().onPause();
        }
        super.onPause();
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onResume() {
        AgentWeb agentWeb = this.agentWeb;
        if (agentWeb != null) {
            agentWeb.getWebLifeCycle().onResume();
        }
        super.onResume();
    }
}
