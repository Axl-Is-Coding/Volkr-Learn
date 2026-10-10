package com.sandboxol.common.listener;

import android.util.Log;
import com.facebook.share.internal.ShareConstants;

/* JADX INFO: loaded from: classes3.dex */
public class RequestProxy {
    private long lastClick;
    private IRequest mIRequest;
    private long times = 1000;

    public interface IRequest {
        void onRepeatRequest();
    }

    public RequestProxy(IRequest iRequest) {
        this.mIRequest = iRequest;
        repeatRequest();
    }

    private void repeatRequest() {
        Log.e("clickPay", "click");
        if (System.currentTimeMillis() - this.lastClick >= this.times) {
            this.lastClick = System.currentTimeMillis();
            IRequest iRequest = this.mIRequest;
            if (iRequest != null) {
                iRequest.onRepeatRequest();
                Log.e("clickPay", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            }
        }
    }
}
