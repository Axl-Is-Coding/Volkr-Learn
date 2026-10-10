package com.alibaba.sdk.android.feedback.util;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.alibaba.sdk.android.feedback.R;
import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f3724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f3725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f3726c = new Handler(Looper.getMainLooper());

    public static int a() {
        return f3724a;
    }

    public static void a(int i) {
        f3724a = i;
    }

    public static void a(Context context) {
        TextView textView = (TextView) ((Activity) context).findViewById(R.id.title_button);
        if (textView != null) {
            textView.setVisibility(4);
        }
        f(context);
    }

    public static void a(Context context, int i) {
        f3725b = i;
        Activity activity = (Activity) context;
        activity.findViewById(R.id.title).setBackgroundColor(i);
        activity.findViewById(R.id.activityRoot).setBackgroundColor(i);
    }

    public static void a(Context context, String str) {
        TextView textView = (TextView) ((Activity) context).findViewById(R.id.title_button);
        if (textView != null) {
            textView.setTextColor(a());
            textView.setText(str);
            textView.setVisibility(0);
        }
        FeedbackAPI.getFeedbackUnreadCount(new l(context));
    }

    public static void a(boolean z, Context context) {
        f3726c.post(new m(z, context));
    }

    public static void b(int i) {
        f3725b = i;
    }

    public static void b(Context context) {
        ((Activity) context).findViewById(R.id.title).setBackgroundColor(f3725b);
    }

    public static void b(Context context, String str) {
        TextView textView = (TextView) ((Activity) context).findViewById(R.id.title_text);
        if (textView != null) {
            textView.setTextColor(a());
            textView.setText(str);
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Context context) {
        View viewFindViewById = ((Activity) context).findViewById(R.id.red_point);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context) {
        View viewFindViewById = ((Activity) context).findViewById(R.id.red_point);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(4);
        }
    }
}
