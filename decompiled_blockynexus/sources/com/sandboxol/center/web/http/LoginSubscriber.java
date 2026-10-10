package com.sandboxol.center.web.http;

import com.google.gson.j;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: loaded from: classes3.dex */
public class LoginSubscriber<T, R extends HttpResponse<T>> extends AuthTokenHttpSubscriber<T, R> {
    public LoginSubscriber(OnResponseListener<T> onResponseListener) {
        super(onResponseListener, null);
    }

    @Override // com.sandboxol.center.web.http.AuthTokenHttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
    public boolean isCheckNetwork() {
        return false;
    }

    @Override // com.sandboxol.common.base.web.BaseSubscriber, rx.Observer
    public void onNext(R r) {
        if (((AuthTokenHttpSubscriber) this).listener != null) {
            if (r.getCode() == 1) {
                ((AuthTokenHttpSubscriber) this).listener.onSuccess((T) r.getData());
            } else if (r.getCode() == 1002) {
                ((AuthTokenHttpSubscriber) this).listener.onError(r.getCode(), new j().a(r.getData()));
            } else {
                ((AuthTokenHttpSubscriber) this).listener.onError(r.getCode(), r.getMessage());
            }
        }
    }
}
