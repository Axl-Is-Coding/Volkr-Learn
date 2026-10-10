package io.rong.push.pushconfig;

import io.rong.push.PushErrorCode;
import io.rong.push.PushType;

/* JADX INFO: loaded from: classes5.dex */
public interface IPushConfigObserver {
    void onError(PushErrorCode pushErrorCode);

    void onFail(PushType pushType, PushErrorCode pushErrorCode);

    void onGetPushType(PushType pushType);

    void onSuccess(PushType pushType);
}
