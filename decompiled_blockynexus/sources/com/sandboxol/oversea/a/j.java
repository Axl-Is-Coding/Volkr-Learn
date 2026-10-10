package com.sandboxol.oversea.a;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.facebook.CallbackManager;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.plus.PlusShare;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.IntConstant;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.messager.MessagerClient;
import com.sandboxol.oversea.R;
import fi.iki.elonen.NanoHTTPD;

/* JADX INFO: compiled from: ShareUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public class j {
    public static void a(Activity activity, String str, String str2, Uri uri, CallbackManager callbackManager) {
        try {
            if (!CommonHelper.checkApkExist(activity, "com.facebook.katana")) {
                AppToastUtils.showShortNegativeTipToast(activity, R.string.not_installed_face_book);
                return;
            }
            String string = str2 == null ? activity.getString(R.string.facebook_share_room_text) : str2;
            ShareContent shareContentBuild = str == null ? new SharePhotoContent.Builder().addPhoto(new SharePhoto.Builder().setBitmap(MediaStore.Images.Media.getBitmap(activity.getContentResolver(), uri)).setCaption(str2).build()).build() : new ShareLinkContent.Builder().setContentUrl(Uri.parse(str)).setQuote(string).setContentTitle(string).build();
            ShareDialog shareDialog = new ShareDialog(activity);
            shareDialog.registerCallback(callbackManager, new i());
            shareDialog.show(shareContentBuild, ShareDialog.Mode.AUTOMATIC);
        } catch (Exception unused) {
            Log.e("facebookCallback", "error");
            MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        }
    }

    public static void a(Context context, String str, String str2, Uri uri) {
        if (str2 == null) {
            try {
                str2 = context.getString(R.string.twitter_share_text);
            } catch (Exception e2) {
                Log.e("twitterShare", "error");
                ReportDataAdapter.onEvent(context, EventConstant.SHARE_TWITTER_FAILED, e2.getMessage());
                return;
            }
        }
        com.twitter.sdk.android.tweetcomposer.i iVar = new com.twitter.sdk.android.tweetcomposer.i(context);
        iVar.a(str2);
        iVar.a(uri);
        ((Activity) context).startActivityForResult(iVar.a(), IntConstant.REQUEST_CODE_TWITTER);
    }

    public static void a(Activity activity, String str, String str2, Uri uri) {
        Intent intent;
        if (str2 == null) {
            try {
                str2 = activity.getString(R.string.gplus_share_room_text);
            } catch (ActivityNotFoundException unused) {
                AppToastUtils.showShortNegativeTipToast(activity, R.string.install_google_plus);
                return;
            } catch (Exception unused2) {
                return;
            }
        }
        int iIsGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (iIsGooglePlayServicesAvailable != 0) {
            GooglePlayServicesUtil.showErrorDialogFragment(iIsGooglePlayServicesAvailable, activity, 0);
            return;
        }
        if (str == null) {
            intent = new PlusShare.Builder(activity).setType(NanoHTTPD.MIME_PLAINTEXT).setText(str2).addStream(uri).getIntent();
        } else {
            intent = new PlusShare.Builder(activity).setType(NanoHTTPD.MIME_PLAINTEXT).setText(str2).setContentUrl(uri).getIntent();
        }
        activity.startActivityForResult(intent, IntConstant.REQUEST_CODE_GOOGLE_PLUS);
    }
}
