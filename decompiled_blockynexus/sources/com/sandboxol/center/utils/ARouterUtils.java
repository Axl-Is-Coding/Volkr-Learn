package com.sandboxol.center.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sandboxol.center.view.activity.TemplateActivity;
import com.sandboxol.common.base.app.SingleTemplateActivity;

/* JADX INFO: loaded from: classes3.dex */
public class ARouterUtils {
    public static void startSingleTemplate(Context context, String str, String str2, Bundle bundle) {
        startSingleTemplate(context, str, str2, -1, bundle);
    }

    public static void startTemplate(Context context, String str, String str2) {
        startTemplate(context, str, str2, -1);
    }

    public static void startTemplateForResult(Activity activity, String str, String str2, int i) {
        startTemplateForResult(activity, str, str2, -1, i);
    }

    public static void startTemplateWithFlags(Context context, String str, String str2, int i) {
        context.startActivity(new Intent(context, (Class<?>) TemplateActivity.class).putExtra(TemplateActivity.NAME, str).putExtra(TemplateActivity.TITLE, str2).putExtra(TemplateActivity.LEFT_RESOURCE_ID, -1).putExtra(TemplateActivity.RIGHT_RESOURCE_ID, -1).putExtra(TemplateActivity.IS_FROM_AROUTER, true).addFlags(i));
    }

    public static void startSingleTemplate(Context context, String str, String str2, int i, Bundle bundle) {
        startSingleTemplate(context, str, str2, -1, i, bundle);
    }

    public static void startTemplate(Context context, String str, String str2, int i) {
        startTemplate(context, str, str2, -1, i);
    }

    public static void startTemplateForResult(Activity activity, String str, String str2, int i, int i2) {
        startTemplateForResult(activity, str, str2, -1, i, i2);
    }

    public static void startSingleTemplate(Context context, String str, String str2, int i, int i2, Bundle bundle) {
        context.startActivity(new Intent(context, (Class<?>) SingleTemplateActivity.class).putExtra(TemplateActivity.NAME, str).putExtra(TemplateActivity.TITLE, str2).putExtra(TemplateActivity.PARAMS, bundle).putExtra(TemplateActivity.LEFT_RESOURCE_ID, i).putExtra(TemplateActivity.RIGHT_RESOURCE_ID, i2).putExtra(TemplateActivity.IS_FROM_AROUTER, true));
    }

    public static void startTemplate(Context context, String str, String str2, int i, int i2) {
        startTemplate(context, str, str2, i, i2, (Bundle) null);
    }

    public static void startTemplateForResult(Activity activity, String str, String str2, int i, int i2, int i3) {
        startTemplateForResult(activity, str, str2, i, i2, (Bundle) null, i3);
    }

    public static void startTemplate(Context context, String str, String str2, String str3) {
        startTemplate(context, str, str2, -1, str3);
    }

    public static void startTemplateForResult(Activity activity, String str, String str2, String str3, int i) {
        startTemplateForResult(activity, str, str2, -1, str3, i);
    }

    public static void startTemplate(Context context, String str, String str2, int i, String str3) {
        startTemplate(context, str, str2, i, str3, (Bundle) null);
    }

    public static void startTemplateForResult(Activity activity, String str, String str2, int i, String str3, int i2) {
        startTemplateForResult(activity, str, str2, i, str3, (Bundle) null, i2);
    }

    public static void startTemplate(Context context, String str, String str2, Bundle bundle) {
        startTemplate(context, str, str2, -1, bundle);
    }

    public static void startTemplateForResult(Activity activity, String str, String str2, Bundle bundle, int i) {
        startTemplateForResult(activity, str, str2, -1, bundle, i);
    }

    public static void startTemplate(Context context, String str, String str2, int i, Bundle bundle) {
        startTemplate(context, str, str2, -1, i, bundle);
    }

    public static void startTemplateForResult(Activity activity, String str, String str2, int i, Bundle bundle, int i2) {
        startTemplateForResult(activity, str, str2, -1, i, bundle, i2);
    }

    public static void startTemplate(Context context, String str, String str2, String str3, Bundle bundle) {
        startTemplate(context, str, str2, -1, str3, bundle);
    }

    public static void startTemplateForResult(Activity activity, String str, String str2, int i, int i2, Bundle bundle, int i3) {
        activity.startActivityForResult(new Intent(activity, (Class<?>) TemplateActivity.class).putExtra(TemplateActivity.NAME, str).putExtra(TemplateActivity.TITLE, str2).putExtra(TemplateActivity.PARAMS, bundle).putExtra(TemplateActivity.LEFT_RESOURCE_ID, i).putExtra(TemplateActivity.RIGHT_RESOURCE_ID, i2).putExtra(TemplateActivity.IS_FROM_AROUTER, true), i3);
    }

    public static void startTemplate(Context context, String str, String str2, int i, int i2, Bundle bundle) {
        context.startActivity(new Intent(context, (Class<?>) TemplateActivity.class).putExtra(TemplateActivity.NAME, str).putExtra(TemplateActivity.TITLE, str2).putExtra(TemplateActivity.PARAMS, bundle).putExtra(TemplateActivity.LEFT_RESOURCE_ID, i).putExtra(TemplateActivity.RIGHT_RESOURCE_ID, i2).putExtra(TemplateActivity.IS_FROM_AROUTER, true));
    }

    public static void startTemplateForResult(Activity activity, String str, String str2, int i, String str3, Bundle bundle, int i2) {
        activity.startActivityForResult(new Intent(activity, (Class<?>) TemplateActivity.class).putExtra(TemplateActivity.NAME, str).putExtra(TemplateActivity.TITLE, str2).putExtra(TemplateActivity.PARAMS, bundle).putExtra(TemplateActivity.LEFT_RESOURCE_ID, i).putExtra(TemplateActivity.RIGHT_RESOURCE_ID, -1).putExtra(TemplateActivity.RIGHT_TEXT, str3).putExtra(TemplateActivity.IS_FROM_AROUTER, true), i2);
    }

    public static void startTemplate(Context context, String str, String str2, int i, String str3, Bundle bundle) {
        context.startActivity(new Intent(context, (Class<?>) TemplateActivity.class).putExtra(TemplateActivity.NAME, str).putExtra(TemplateActivity.TITLE, str2).putExtra(TemplateActivity.PARAMS, bundle).putExtra(TemplateActivity.LEFT_RESOURCE_ID, i).putExtra(TemplateActivity.RIGHT_RESOURCE_ID, -1).putExtra(TemplateActivity.RIGHT_TEXT, str3).putExtra(TemplateActivity.IS_FROM_AROUTER, true));
    }
}
