package com.sandboxol.imchat.server.network.async;

import com.sandboxol.imchat.server.network.http.HttpException;

/* JADX INFO: loaded from: classes4.dex */
public interface OnDataListener {
    Object doInBackground(int i, String str) throws HttpException;

    void onFailure(int i, int i2, Object obj);

    void onSuccess(int i, Object obj);
}
