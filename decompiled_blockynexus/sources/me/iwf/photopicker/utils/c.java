package me.iwf.photopicker.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: ImageCaptureManager.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f22946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f22947b;

    public c(Context context) {
        this.f22947b = context;
    }

    private File d() throws IOException {
        String str = "JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ENGLISH).format(new Date()) + ".jpg";
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (!externalStoragePublicDirectory.exists() && !externalStoragePublicDirectory.mkdir()) {
            Log.e("TAG", "Throwing Errors....");
            throw new IOException();
        }
        File file = new File(externalStoragePublicDirectory, str);
        this.f22946a = file.getAbsolutePath();
        return file;
    }

    public Intent a() throws IOException {
        Uri uriFromFile;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(this.f22947b.getPackageManager()) != null) {
            File fileD = d();
            if (Build.VERSION.SDK_INT >= 24) {
                uriFromFile = FileProvider.getUriForFile(this.f22947b.getApplicationContext(), this.f22947b.getApplicationInfo().packageName + ".provider", fileD);
            } else {
                uriFromFile = Uri.fromFile(fileD);
            }
            if (uriFromFile != null) {
                intent.putExtra("output", uriFromFile);
            }
        }
        return intent;
    }

    public void b() {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        if (TextUtils.isEmpty(this.f22946a)) {
            return;
        }
        intent.setData(Uri.fromFile(new File(this.f22946a)));
        this.f22947b.sendBroadcast(intent);
    }

    public String c() {
        return this.f22946a;
    }

    public void b(Bundle bundle) {
        String str;
        if (bundle == null || (str = this.f22946a) == null) {
            return;
        }
        bundle.putString("mCurrentPhotoPath", str);
    }

    public void a(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("mCurrentPhotoPath")) {
            return;
        }
        this.f22946a = bundle.getString("mCurrentPhotoPath");
    }
}
