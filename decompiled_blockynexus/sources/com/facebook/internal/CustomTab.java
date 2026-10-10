package com.facebook.internal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.f;
import com.facebook.FacebookSdk;
import io.rong.imkit.utils.FileTypeUtils;

/* JADX INFO: loaded from: classes.dex */
public class CustomTab {
    private Uri uri;

    public CustomTab(String str, Bundle bundle) {
        bundle = bundle == null ? new Bundle() : bundle;
        this.uri = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/" + ServerProtocol.DIALOG_PATH + str, bundle);
    }

    public void openCustomTab(Activity activity, String str) {
        f fVarA = new f.a().a();
        fVarA.f773a.setPackage(str);
        fVarA.f773a.addFlags(FileTypeUtils.GIGABYTE);
        fVarA.a(activity, this.uri);
    }
}
