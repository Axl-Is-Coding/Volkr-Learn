package com.twitter.sdk.android.core;

import android.text.TextUtils;
import com.google.gson.JsonSyntaxException;
import com.twitter.sdk.android.core.models.SafeListAdapter;
import com.twitter.sdk.android.core.models.SafeMapAdapter;
import retrofit2.Response;

/* JADX INFO: loaded from: classes5.dex */
public class TwitterApiException extends TwitterException {
    public static final int DEFAULT_ERROR_CODE = 0;
    private final com.twitter.sdk.android.core.models.a apiError;
    private final int code;
    private final Response response;
    private final x twitterRateLimit;

    public TwitterApiException(Response response) {
        this(response, readApiError(response), readApiRateLimit(response), response.code());
    }

    static String createExceptionMessage(int i) {
        return "HTTP request failed, Status: " + i;
    }

    static com.twitter.sdk.android.core.models.a parseApiError(String str) {
        com.google.gson.k kVar = new com.google.gson.k();
        kVar.a(new SafeListAdapter());
        kVar.a(new SafeMapAdapter());
        try {
            com.twitter.sdk.android.core.models.b bVar = (com.twitter.sdk.android.core.models.b) kVar.a().a(str, com.twitter.sdk.android.core.models.b.class);
            if (bVar.f20223a.isEmpty()) {
                return null;
            }
            return bVar.f20223a.get(0);
        } catch (JsonSyntaxException e2) {
            n.e().e("Twitter", "Invalid json: " + str, e2);
            return null;
        }
    }

    public static com.twitter.sdk.android.core.models.a readApiError(Response response) {
        try {
            String utf8 = response.errorBody().source().buffer().clone().readUtf8();
            if (TextUtils.isEmpty(utf8)) {
                return null;
            }
            return parseApiError(utf8);
        } catch (Exception e2) {
            n.e().e("Twitter", "Unexpected response", e2);
            return null;
        }
    }

    public static x readApiRateLimit(Response response) {
        return new x(response.headers());
    }

    public int getErrorCode() {
        com.twitter.sdk.android.core.models.a aVar = this.apiError;
        if (aVar == null) {
            return 0;
        }
        return aVar.f20222b;
    }

    public String getErrorMessage() {
        com.twitter.sdk.android.core.models.a aVar = this.apiError;
        if (aVar == null) {
            return null;
        }
        return aVar.f20221a;
    }

    public Response getResponse() {
        return this.response;
    }

    public int getStatusCode() {
        return this.code;
    }

    public x getTwitterRateLimit() {
        return this.twitterRateLimit;
    }

    TwitterApiException(Response response, com.twitter.sdk.android.core.models.a aVar, x xVar, int i) {
        super(createExceptionMessage(i));
        this.apiError = aVar;
        this.twitterRateLimit = xVar;
        this.code = i;
        this.response = response;
    }
}
