package com.squareup.okhttp;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface Callback {
    void onFailure(Request request, IOException iOException);

    void onResponse(Response response) throws IOException;
}
