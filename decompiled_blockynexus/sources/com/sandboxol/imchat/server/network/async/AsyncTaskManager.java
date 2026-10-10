package com.sandboxol.imchat.server.network.async;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.sandboxol.imchat.server.network.http.HttpException;
import io.rong.eventbus.EventBus;

/* JADX INFO: loaded from: classes4.dex */
public class AsyncTaskManager {
    public static final int HTTP_ERROR_CODE = -200;
    public static final int HTTP_NULL_CODE = -400;
    public static final int REQUEST_ERROR_CODE = -999;
    public static final int REQUEST_SUCCESS_CODE = 200;
    private static AsyncTaskManager instance;
    private Context mContext;
    private final String tag = AsyncTaskManager.class.getSimpleName();

    private AsyncTaskManager(Context context) {
        this.mContext = context;
        EventBus.getDefault().register(this);
    }

    public static AsyncTaskManager getInstance(Context context) {
        if (instance == null) {
            synchronized (AsyncTaskManager.class) {
                if (instance == null) {
                    instance = new AsyncTaskManager(context);
                }
            }
        }
        return instance;
    }

    public void cancelRequest() {
        EventBus.getDefault().unregister(this);
    }

    public boolean isNetworkConnected(Context context, boolean z) {
        if (!z || context == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public void onEventAsync(AsyncRequest asyncRequest) {
        AsyncResult asyncResult = new AsyncResult(asyncRequest.getRequestCode(), asyncRequest.isCheckNetwork(), asyncRequest.getListener());
        try {
            if (isNetworkConnected(this.mContext, asyncRequest.isCheckNetwork())) {
                asyncResult.setResult(asyncRequest.getListener().doInBackground(asyncRequest.getRequestCode(), asyncRequest.getId()));
                asyncResult.setState(200);
            } else {
                asyncResult.setState(-400);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            asyncResult.setResult(e2);
            if (e2 instanceof HttpException) {
                asyncResult.setState(HTTP_ERROR_CODE);
            } else {
                asyncResult.setState(REQUEST_ERROR_CODE);
            }
        }
        EventBus.getDefault().post(asyncResult);
    }

    public void onEventMainThread(AsyncResult asyncResult) {
        int state = asyncResult.getState();
        if (state == -999 || state == -400 || state == -200) {
            asyncResult.getListener().onFailure(asyncResult.getRequestCode(), asyncResult.getState(), asyncResult.getResult());
        } else {
            if (state != 200) {
                return;
            }
            asyncResult.getListener().onSuccess(asyncResult.getRequestCode(), asyncResult.getResult());
        }
    }

    public void request(int i, OnDataListener onDataListener) {
        request(i, true, onDataListener);
    }

    public void request(String str, int i, OnDataListener onDataListener) {
        if (i > 0) {
            EventBus.getDefault().post(new AsyncRequest(str, i, false, onDataListener));
        }
    }

    public void request(int i, boolean z, OnDataListener onDataListener) {
        if (i > 0) {
            EventBus.getDefault().post(new AsyncRequest(i, z, onDataListener));
        }
    }
}
