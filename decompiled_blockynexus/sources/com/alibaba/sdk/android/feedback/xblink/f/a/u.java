package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import io.rong.common.LibStorageUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class u extends com.alibaba.sdk.android.feedback.xblink.f.a {
    private com.alibaba.sdk.android.feedback.xblink.view.a g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f3827d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.alibaba.sdk.android.feedback.xblink.f.b f3828e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f3829f = null;
    private String[] h = {"拍摄一张照片", "从相册选取"};
    private View.OnClickListener i = new x(this);

    public static Uri a(Context context, File file) {
        if (context == null || file == null) {
            throw new NullPointerException();
        }
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        return FileProvider.getUriForFile(context.getApplicationContext(), context.getPackageName() + ".alifb_fileprovider", file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Intent intent) {
        com.alibaba.sdk.android.feedback.windvane.d dVar;
        int i2;
        Context context;
        if (i == 0) {
            dVar = FeedbackAPI.customWebviewFragment;
            i2 = 4001;
            if (dVar == null) {
                context = this.f3802a;
                if (!(context instanceof Activity)) {
                    return;
                }
                ((Activity) context).startActivityForResult(intent, i2);
                return;
            }
            dVar.startActivityForResult(intent, i2);
        }
        if (i == 1) {
            dVar = FeedbackAPI.customWebviewFragment;
            i2 = 4002;
            if (dVar == null) {
                context = this.f3802a;
                if (!(context instanceof Activity)) {
                    return;
                }
                ((Activity) context).startActivityForResult(intent, i2);
                return;
            }
            dVar.startActivityForResult(intent, i2);
        }
    }

    private void a(String str, String str2) {
        int iA = com.alibaba.sdk.android.feedback.xblink.i.d.a(str);
        Bitmap bitmapA = com.alibaba.sdk.android.feedback.xblink.i.d.a(str, this.f3802a.getResources().getDisplayMetrics().heightPixels);
        if (bitmapA != null) {
            Bitmap bitmapA2 = com.alibaba.sdk.android.feedback.xblink.i.d.a(bitmapA, iA);
            try {
                try {
                    byte[] bArrA = com.alibaba.sdk.android.feedback.xblink.i.d.a(bitmapA2, Bitmap.CompressFormat.JPEG);
                    if (bArrA != null) {
                        com.alibaba.sdk.android.feedback.xblink.i.g.a("WXPhoto", "photo size:" + bArrA.length);
                    }
                    String strReplaceAll = new String(Base64.encode(bArrA, 0)).replaceAll("[\r|\n]", "");
                    com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
                    mVar.a("imageData", strReplaceAll);
                    if (this.f3828e != null) {
                        this.f3828e.a(mVar);
                    }
                    if (bitmapA2 != null) {
                        bitmapA2.recycle();
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    com.alibaba.sdk.android.feedback.xblink.i.g.a("WXPhoto", "write photo io error.");
                    if (bitmapA2 != null) {
                        bitmapA2.recycle();
                    }
                }
            } catch (Throwable th) {
                if (bitmapA2 != null) {
                    bitmapA2.recycle();
                }
                throw th;
            }
        }
        com.alibaba.sdk.android.feedback.xblink.f.b bVar = this.f3828e;
        if (bVar != null) {
            bVar.b("unknown error");
        }
    }

    private boolean d() {
        Context context = this.f3802a;
        return context != null && context.getPackageManager().checkPermission("android.permission.CAMERA", this.f3802a.getPackageName()) == 0;
    }

    private void e() {
        Context context = this.f3802a;
        if (context != null && (context instanceof Activity)) {
            ActivityCompat.a((Activity) context, new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 0);
        }
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public void a(int i, int i2, Intent intent) {
        com.alibaba.sdk.android.feedback.xblink.f.b bVar;
        com.alibaba.sdk.android.feedback.xblink.f.m mVar;
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a("WXPhoto", "takePhoto callback, requestCode: " + i + ";resultCode: " + i2);
        }
        String path = null;
        if (i != 4001) {
            if (i != 4002) {
                return;
            }
            if (i2 == -1 && intent != null) {
                Uri data = intent.getData();
                if (data != null) {
                    if (LibStorageUtils.FILE.equalsIgnoreCase(data.getScheme())) {
                        path = data.getPath();
                    } else {
                        String[] strArr = {"_data"};
                        Cursor cursorQuery = this.f3802a.getContentResolver().query(data, strArr, null, null, null);
                        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                            com.alibaba.sdk.android.feedback.util.n.a("AlbumFailed", "Error retrieving the album data due to empty curser");
                            com.alibaba.sdk.android.feedback.xblink.i.g.e("WXPhoto", "pick photo fail, Cursor is empty, imageUri: " + data.toString());
                        } else {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex(strArr[0]));
                            cursorQuery.close();
                            com.alibaba.sdk.android.feedback.util.n.a("AlbumSuccess", null);
                            path = string;
                        }
                    }
                }
                if (!com.alibaba.sdk.android.feedback.xblink.d.a.a(path)) {
                    com.alibaba.sdk.android.feedback.util.n.a("AlbumFailed", "Error retrieving the album data due to picture not exist");
                    com.alibaba.sdk.android.feedback.xblink.i.g.e("WXPhoto", "pick photo fail, picture not exist, picturePath: " + path);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(com.alibaba.sdk.android.feedback.util.j.f3722a);
                sb.append(File.separator);
                sb.append(com.alibaba.sdk.android.feedback.xblink.i.b.a("" + System.currentTimeMillis()));
                this.f3829f = sb.toString();
                a(path, this.f3829f);
                return;
            }
            com.alibaba.sdk.android.feedback.util.n.a("AlbumFailed", "Error retrieving the album data, result code: " + i2);
            com.alibaba.sdk.android.feedback.xblink.i.g.e("WXPhoto", "call pick photo fail. resultCode: " + i2);
            bVar = this.f3828e;
            mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
        } else if (i2 == -1) {
            String str = this.f3829f;
            a(str, str);
            com.alibaba.sdk.android.feedback.util.n.a("CameraSuccess", null);
            return;
        } else {
            com.alibaba.sdk.android.feedback.util.n.a("CameraFailed", "Error retrieving the camera data when taking picture");
            com.alibaba.sdk.android.feedback.xblink.i.g.e("WXPhoto", "call takePhoto fail. resultCode: " + i2);
            bVar = this.f3828e;
            mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
        }
        bVar.b(mVar);
    }

    public synchronized void a(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        if (this.f3804c) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - this.f3827d;
            this.f3827d = jCurrentTimeMillis;
            if (j < 1000) {
                com.alibaba.sdk.android.feedback.xblink.i.g.e("WXPhoto", "takePhoto, call this method too frequent,  " + j);
                return;
            }
            try {
                String strOptString = new JSONObject(str).optString("mode");
                this.f3828e = bVar;
                if ("album".equals(strOptString)) {
                    com.alibaba.sdk.android.feedback.xblink.i.g.a("WXPhoto", "start to pick photo from system album.");
                    a(1, new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI));
                } else if ("camera".equals(strOptString)) {
                    com.alibaba.sdk.android.feedback.xblink.i.g.a("WXPhoto", "start to open system camera.");
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    File file = new File(com.alibaba.sdk.android.feedback.util.j.f3722a);
                    if (file.exists()) {
                        if (!file.isDirectory()) {
                            file.delete();
                            file.mkdirs();
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(com.alibaba.sdk.android.feedback.util.j.f3722a);
                        sb.append(File.separator);
                        sb.append(com.alibaba.sdk.android.feedback.xblink.i.b.a("" + System.currentTimeMillis()));
                        this.f3829f = sb.toString();
                        intent.putExtra("output", a(this.f3802a, new File(this.f3829f)));
                        a(0, intent);
                    } else {
                        file.mkdirs();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(com.alibaba.sdk.android.feedback.util.j.f3722a);
                        sb2.append(File.separator);
                        sb2.append(com.alibaba.sdk.android.feedback.xblink.i.b.a("" + System.currentTimeMillis()));
                        this.f3829f = sb2.toString();
                        intent.putExtra("output", a(this.f3802a, new File(this.f3829f)));
                        a(0, intent);
                    }
                } else if ("both".equals(strOptString)) {
                    String str2 = Build.BRAND;
                    String str3 = Build.MODEL;
                    if (str2 == null || str3 == null || !str2.equalsIgnoreCase("meizu") || !str3.equalsIgnoreCase("m040")) {
                        try {
                            this.g = new com.alibaba.sdk.android.feedback.xblink.view.a(this.f3802a, this.f3803b, this.h, this.i);
                            this.g.a(new w(this));
                            this.g.a();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } else {
                        new AlertDialog.Builder(this.f3802a).setItems(this.h, new v(this)).create().show();
                    }
                }
            } catch (JSONException unused) {
                com.alibaba.sdk.android.feedback.xblink.i.g.b("WXPhoto", "takePhoto fail, params: " + str);
                com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
                mVar.a("HY_PARAM_ERR");
                bVar.b(mVar);
            }
        }
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if (!"take".equals(str)) {
            return false;
        }
        if (d()) {
            a(bVar, str2);
            return true;
        }
        e();
        return false;
    }
}
