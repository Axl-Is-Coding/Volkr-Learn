package com.sandboxol.common.utils;

import android.content.Context;
import android.util.Log;
import com.sandboxol.common.R;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.config.HttpCode;
import okhttp3.J;
import retrofit2.HttpException;
import retrofit2.Response;
import rx.exceptions.Exceptions;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class HttpUtils {
    public static String getHttpErrorMsg(Context context, int i) {
        if (i == -1) {
            return context.getResources().getString(R.string.error_tip_runtime);
        }
        if (i == 401) {
            return context.getResources().getString(R.string.connect_repeat_login);
        }
        if (i == 429) {
            return context.getResources().getString(R.string.service_busy);
        }
        if (i == 4) {
            return context.getResources().getString(R.string.inner_error);
        }
        if (i == 5) {
            return context.getResources().getString(R.string.time_out);
        }
        if (i == 403) {
            return context.getResources().getString(R.string.user_be_report);
        }
        if (i != 404) {
            if (i == 503) {
                return context.getResources().getString(R.string.service_cant_use);
            }
            if (i == 504) {
                return context.getResources().getString(R.string.network_connection_failed);
            }
            switch (i) {
                case 10000:
                    break;
                case 10001:
                    return context.getResources().getString(R.string.connect_server_time_out);
                case HttpCode.UN_KNOW /* 10002 */:
                    return context.getResources().getString(R.string.connect_server_connect_failed);
                default:
                    return context.getResources().getString(R.string.connect_error_code, Integer.valueOf(i));
            }
        }
        return context.getResources().getString(R.string.connect_server_no_connect);
    }

    public static ReplyCommand getRetryCommand(OnResponseListener onResponseListener, Action0 action0) {
        if (onResponseListener.needRetry()) {
            return new ReplyCommand(action0);
        }
        return null;
    }

    public static void throwException(int i) {
        if (i != 2) {
            if (i == 429) {
                throw new HttpException(Response.error(429, (J) null));
            }
            if (i == 503) {
                throw new HttpException(Response.error(503, (J) null));
            }
            return;
        }
        try {
            Log.e("web.MiniGameDispatch", "server is busy. code = " + i);
            throw new Exception("get dispatch failed");
        } catch (Throwable th) {
            Exceptions.propagate(th);
            throw null;
        }
    }
}
