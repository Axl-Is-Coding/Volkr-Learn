package io.rong.push.pushconfig;

import io.rong.push.PushErrorCode;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public interface PushNaviObserver {
    void onError(PushErrorCode pushErrorCode);

    void onSuccess(ArrayList<String> arrayList);
}
