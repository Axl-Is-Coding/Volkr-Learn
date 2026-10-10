package com.sandboxol.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sandboxol.common.base.app.MTTemplateActivity;

/* JADX INFO: loaded from: classes3.dex */
public class TemplateHelper {
    public static void startSingleTemplate(Context context, Class cls, String str, Bundle bundle) {
        startSingleTemplate(context, cls, str, -1, bundle);
    }

    public static void startTemplate(Context context, Class cls, String str) {
        startTemplate(context, cls, str, -1);
    }

    public static void startTemplateForResult(Activity activity, Class cls, String str, int i) {
        startTemplateForResult(activity, cls, str, -1, i);
    }

    public static void startTemplateWithFlags(Context context, Class cls, String str, int i) {
        context.startActivity(new Intent(context, (Class<?>) MTTemplateActivity.class).putExtra(MTTemplateActivity.NAME, cls).putExtra(MTTemplateActivity.TITLE, str).putExtra(MTTemplateActivity.LEFT_RESOURCE_ID, -1).putExtra(MTTemplateActivity.RIGHT_RESOURCE_ID, -1).addFlags(i));
    }

    public static void startSingleTemplate(Context context, Class cls, String str, int i, Bundle bundle) {
        startSingleTemplate(context, cls, str, -1, i, bundle);
    }

    public static void startTemplate(Context context, Class cls, String str, int i) {
        startTemplate(context, cls, str, -1, i);
    }

    public static void startTemplateForResult(Activity activity, Class cls, String str, int i, int i2) {
        startTemplateForResult(activity, cls, str, -1, i, i2);
    }

    public static void startSingleTemplate(Context context, Class cls, String str, int i, int i2, Bundle bundle) {
        context.startActivity(new Intent(context, (Class<?>) MTTemplateActivity.class).addFlags(603979776).putExtra(MTTemplateActivity.NAME, cls).putExtra(MTTemplateActivity.TITLE, str).putExtra(MTTemplateActivity.PARAMS, bundle).putExtra(MTTemplateActivity.LEFT_RESOURCE_ID, i).putExtra(MTTemplateActivity.RIGHT_RESOURCE_ID, i2));
    }

    public static void startTemplate(Context context, Class cls, String str, int i, int i2) {
        startTemplate(context, cls, str, i, i2, (Bundle) null);
    }

    public static void startTemplateForResult(Activity activity, Class cls, String str, int i, int i2, int i3) {
        startTemplateForResult(activity, cls, str, i, i2, (Bundle) null, i3);
    }

    public static void startTemplate(Context context, Class cls, String str, String str2) {
        startTemplate(context, cls, str, -1, str2);
    }

    public static void startTemplateForResult(Activity activity, Class cls, String str, String str2, int i) {
        startTemplateForResult(activity, cls, str, -1, str2, i);
    }

    public static void startTemplate(Context context, Class cls, String str, int i, String str2) {
        startTemplate(context, cls, str, i, str2, (Bundle) null);
    }

    public static void startTemplateForResult(Activity activity, Class cls, String str, int i, String str2, int i2) {
        startTemplateForResult(activity, cls, str, i, str2, (Bundle) null, i2);
    }

    public static void startTemplate(Context context, Class cls, String str, Bundle bundle) {
        startTemplate(context, cls, str, -1, bundle);
    }

    public static void startTemplateForResult(Activity activity, Class cls, String str, Bundle bundle, int i) {
        startTemplateForResult(activity, cls, str, -1, bundle, i);
    }

    public static void startTemplate(Context context, Class cls, String str, int i, Bundle bundle) {
        startTemplate(context, cls, str, -1, i, bundle);
    }

    public static void startTemplateForResult(Activity activity, Class cls, String str, int i, Bundle bundle, int i2) {
        startTemplateForResult(activity, cls, str, -1, i, bundle, i2);
    }

    public static void startTemplate(Context context, Class cls, String str, String str2, Bundle bundle) {
        startTemplate(context, cls, str, -1, str2, bundle);
    }

    public static void startTemplateForResult(Activity activity, Class cls, String str, int i, int i2, Bundle bundle, int i3) {
        activity.startActivityForResult(new Intent(activity, (Class<?>) MTTemplateActivity.class).putExtra(MTTemplateActivity.NAME, cls).putExtra(MTTemplateActivity.TITLE, str).putExtra(MTTemplateActivity.PARAMS, bundle).putExtra(MTTemplateActivity.LEFT_RESOURCE_ID, i).putExtra(MTTemplateActivity.RIGHT_RESOURCE_ID, i2), i3);
    }

    public static void startTemplate(Context context, Class cls, String str, int i, int i2, Bundle bundle) {
        context.startActivity(new Intent(context, (Class<?>) MTTemplateActivity.class).putExtra(MTTemplateActivity.NAME, cls).putExtra(MTTemplateActivity.TITLE, str).putExtra(MTTemplateActivity.PARAMS, bundle).putExtra(MTTemplateActivity.LEFT_RESOURCE_ID, i).putExtra(MTTemplateActivity.RIGHT_RESOURCE_ID, i2));
    }

    public static void startTemplateForResult(Activity activity, Class cls, String str, int i, String str2, Bundle bundle, int i2) {
        activity.startActivityForResult(new Intent(activity, (Class<?>) MTTemplateActivity.class).putExtra(MTTemplateActivity.NAME, cls).putExtra(MTTemplateActivity.TITLE, str).putExtra(MTTemplateActivity.PARAMS, bundle).putExtra(MTTemplateActivity.LEFT_RESOURCE_ID, i).putExtra(MTTemplateActivity.RIGHT_RESOURCE_ID, -1).putExtra(MTTemplateActivity.RIGHT_TEXT, str2), i2);
    }

    public static void startTemplate(Context context, Class cls, String str, int i, String str2, Bundle bundle) {
        context.startActivity(new Intent(context, (Class<?>) MTTemplateActivity.class).putExtra(MTTemplateActivity.NAME, cls).putExtra(MTTemplateActivity.TITLE, str).putExtra(MTTemplateActivity.PARAMS, bundle).putExtra(MTTemplateActivity.LEFT_RESOURCE_ID, i).putExtra(MTTemplateActivity.RIGHT_RESOURCE_ID, -1).putExtra(MTTemplateActivity.RIGHT_TEXT, str2));
    }
}
