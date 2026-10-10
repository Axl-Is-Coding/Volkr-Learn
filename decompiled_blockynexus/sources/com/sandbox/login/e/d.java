package com.sandbox.login.e;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.facebook.internal.ServerProtocol;
import com.sandbox.login.R;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.utils.AppToastUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: IconHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f15747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static File f15748b = new File(Environment.getExternalStorageDirectory(), StringConstant.BLOCKY_MODS_CACHE_PATH_ICON_TEMP);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Uri f15749c = Uri.fromFile(f15748b);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f15750d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f15751e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static File f15752f;

    public static d b() {
        if (f15747a == null) {
            f15747a = new d();
        }
        return f15747a;
    }

    private void c() {
        f15751e = "temp.jpg";
        f15752f = f15748b;
    }

    public void a(Context context, BaseFragment baseFragment) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        baseFragment.startActivityForResult(Intent.createChooser(intent, context.getString(R.string.login_account_choose_photo)), 1);
    }

    public void a(Uri uri, BaseFragment baseFragment) {
        try {
            f15748b.deleteOnExit();
            File file = new File(Environment.getExternalStorageDirectory(), StringConstant.BLOCKY_MODS_CACHE_PATH_ICON_DIR);
            if (!file.exists()) {
                file.mkdirs();
            }
            Intent intent = new Intent("com.android.camera.action.CROP");
            intent.setDataAndType(uri, "image/*");
            intent.putExtra("corp", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("outputX", 300);
            intent.putExtra("outputY", 300);
            intent.putExtra("scale", true);
            intent.putExtra("return-data", false);
            intent.putExtra("output", f15749c);
            intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
            intent.putExtra("noFaceDetection", true);
            baseFragment.startActivityForResult(intent, 2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(Context context, BaseFragment baseFragment) {
        if (Build.VERSION.SDK_INT >= 23) {
            int iA = androidx.core.content.b.a(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (androidx.core.content.b.a(context, "android.permission.READ_EXTERNAL_STORAGE") == 0 && iA == 0) {
                a(context, baseFragment);
                return;
            } else {
                ActivityCompat.a((AppCompatActivity) context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 123);
                return;
            }
        }
        a(context, baseFragment);
    }

    private Bitmap b(Context context, Uri uri) {
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
            if (inputStreamOpenInputStream != null) {
                inputStreamOpenInputStream.close();
                c();
                return bitmapDecodeStream;
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        } catch (Exception unused) {
        }
        return null;
    }

    public String a(Context context, ImageView imageView, ImageView imageView2) {
        Bitmap bitmapB = b(context, f15749c);
        if (bitmapB != null) {
            imageView.setImageBitmap(bitmapB);
            imageView2.setImageBitmap(bitmapB);
            return f15751e;
        }
        AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.login_icon_select_fails));
        return null;
    }

    public Bitmap a(Context context) {
        return b(context, f15749c);
    }

    public File a() {
        File file = f15752f;
        if (file != null) {
            return file;
        }
        return null;
    }

    public Uri a(Context context, Uri uri) {
        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (cursorQuery == null) {
            return uri;
        }
        try {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
            cursorQuery.moveToFirst();
            File file = new File(cursorQuery.getString(columnIndexOrThrow));
            cursorQuery.close();
            return Uri.fromFile(file);
        } catch (Exception unused) {
            return null;
        }
    }
}
