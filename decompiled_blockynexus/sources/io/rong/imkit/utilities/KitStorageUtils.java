package io.rong.imkit.utilities;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imlib.common.SavePathUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class KitStorageUtils {
    private static final String IMAGE_PREFIX = "Rong_Image_";
    private static final String TAG = "LibStorageUtils";
    private static final String VIDEO_PREFIX = "Rong_Video_";
    private static final String VIDEO_SUFFIX = ".mp4";

    public static class MediaType {
        public static final String IMAGE = "image";
        public static final String VIDEO = "video";
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x005b A[Catch: IOException -> 0x0067, TryCatch #0 {IOException -> 0x0067, blocks: (B:36:0x0056, B:38:0x005b, B:39:0x005e, B:41:0x0063), top: B:47:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0063 A[Catch: IOException -> 0x0067, TRY_LEAVE, TryCatch #0 {IOException -> 0x0067, blocks: (B:36:0x0056, B:38:0x005b, B:39:0x005e, B:41:0x0063), top: B:47:0x0056 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void copy(java.io.FileInputStream r10, java.io.FileOutputStream r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "copy method error"
            java.lang.String r1 = "LibStorageUtils"
            if (r10 == 0) goto L6c
            if (r11 != 0) goto La
            goto L6c
        La:
            r2 = 0
            java.nio.channels.FileChannel r9 = r10.getChannel()     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d
            java.nio.channels.FileChannel r2 = r11.getChannel()     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            r4 = 0
            long r6 = r9.size()     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            r3 = r9
            r8 = r2
            r3.transferTo(r4, r6, r8)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            r10.close()     // Catch: java.io.IOException -> L2f
            if (r9 == 0) goto L26
            r9.close()     // Catch: java.io.IOException -> L2f
        L26:
            r11.close()     // Catch: java.io.IOException -> L2f
            if (r2 == 0) goto L52
            r2.close()     // Catch: java.io.IOException -> L2f
            goto L52
        L2f:
            r10 = move-exception
            io.rong.common.RLog.e(r1, r0, r10)
            goto L52
        L34:
            r3 = move-exception
            goto L56
        L36:
            r3 = move-exception
            r4 = r2
            r2 = r9
            goto L3f
        L3a:
            r3 = move-exception
            r9 = r2
            goto L56
        L3d:
            r3 = move-exception
            r4 = r2
        L3f:
            io.rong.common.RLog.e(r1, r0, r3)     // Catch: java.lang.Throwable -> L53
            r10.close()     // Catch: java.io.IOException -> L2f
            if (r2 == 0) goto L4a
            r2.close()     // Catch: java.io.IOException -> L2f
        L4a:
            r11.close()     // Catch: java.io.IOException -> L2f
            if (r4 == 0) goto L52
            r4.close()     // Catch: java.io.IOException -> L2f
        L52:
            return
        L53:
            r3 = move-exception
            r9 = r2
            r2 = r4
        L56:
            r10.close()     // Catch: java.io.IOException -> L67
            if (r9 == 0) goto L5e
            r9.close()     // Catch: java.io.IOException -> L67
        L5e:
            r11.close()     // Catch: java.io.IOException -> L67
            if (r2 == 0) goto L6b
            r2.close()     // Catch: java.io.IOException -> L67
            goto L6b
        L67:
            r10 = move-exception
            io.rong.common.RLog.e(r1, r0, r10)
        L6b:
            throw r3
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.utilities.KitStorageUtils.copy(java.io.FileInputStream, java.io.FileOutputStream):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:112:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0104 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean copyImageToPublicDir(android.content.Context r13, java.io.File r14, java.lang.String r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.utilities.KitStorageUtils.copyImageToPublicDir(android.content.Context, java.io.File, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean copyVideoToPublicDir(android.content.Context r8, java.io.File r9, java.lang.String r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.utilities.KitStorageUtils.copyVideoToPublicDir(android.content.Context, java.io.File, java.lang.String):boolean");
    }

    private static boolean copyVideoToPublicDirForQ(Context context, File file, String str) throws Throwable {
        boolean z = false;
        if (file.exists() && file.isFile() && context != null) {
            if (TextUtils.isEmpty(str)) {
                str = file.getName();
            }
            Uri uriInsertVideoIntoMediaStore = insertVideoIntoMediaStore(context, str);
            String path = uriInsertVideoIntoMediaStore != null ? uriInsertVideoIntoMediaStore.getPath() : "";
            try {
                writeToPublicDir(file, context.getContentResolver().openFileDescriptor(uriInsertVideoIntoMediaStore, "w"));
                z = true;
            } catch (FileNotFoundException unused) {
                RLog.e(TAG, "copyVideoToPublicDir uri is not Found, uri is" + uriInsertVideoIntoMediaStore.toString());
            }
            updatePhotoMedia(new File(path), context);
        } else {
            RLog.e(TAG, "file is not Found or context is null ");
        }
        return z;
    }

    public static String getFileSavePath(Context context) {
        return getSavePath(context, LibStorageUtils.FILE, R.string.rc_file_default_saved_path);
    }

    public static String getImageSavePath(Context context) {
        return getSavePath(context, "image", R.string.rc_image_default_saved_path);
    }

    public static String getImgMimeType(File file) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getPath(), options);
        return options.outMimeType;
    }

    public static String getSavePath(Context context, String str, int i) {
        if (!SavePathUtils.isSavePathEmpty()) {
            File file = new File(SavePathUtils.getSavePath(), str);
            if (!file.exists() && !file.mkdirs()) {
                RLog.e(TAG, "getSavePath mkdirs error path is  " + file.getAbsolutePath());
            }
            return file.getAbsolutePath();
        }
        boolean zEquals = Environment.getExternalStorageState().equals("mounted");
        String path = context.getCacheDir().getPath();
        if (!zEquals) {
            RLog.d(TAG, "getSavePath error, sdcard does not exist.");
            return path;
        }
        if (isQMode(context)) {
            File externalFilesDir = context.getExternalFilesDir(LibStorageUtils.DIR);
            File file2 = new File(externalFilesDir, str);
            return (file2.exists() || file2.mkdirs()) ? file2.getPath() : externalFilesDir.getPath();
        }
        String path2 = Environment.getExternalStorageDirectory().getPath();
        StringBuilder sb = new StringBuilder(context.getString(i));
        String appName = LibStorageUtils.getAppName(context);
        if (!TextUtils.isEmpty(appName)) {
            sb.append(appName);
            sb.append(File.separator);
        }
        String str2 = path2 + sb.toString();
        File file3 = new File(str2);
        if (file3.exists() || file3.mkdirs()) {
            return str2;
        }
        RLog.e(TAG, "mkdirs error path is  " + str2);
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
    }

    public static String getVideoSavePath(Context context) {
        return getSavePath(context, "video", R.string.rc_video_default_saved_path);
    }

    public static Uri insertImageIntoMediaStore(Context context, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("mime_type", str2);
        return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    public static Uri insertVideoIntoMediaStore(Context context, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("mime_type", "video/mp4");
        return context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    public static boolean isBuildAndTargetForQ(Context context) {
        return LibStorageUtils.isBuildAndTargetForQ(context);
    }

    public static boolean isQMode(Context context) {
        return LibStorageUtils.isQMode(context);
    }

    public static void read(ParcelFileDescriptor parcelFileDescriptor, File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                copy(fileInputStream, fileOutputStream);
            } finally {
                fileOutputStream.close();
            }
        } finally {
            fileInputStream.close();
        }
    }

    public static boolean saveMediaToPublicDir(Context context, File file, String str) {
        return saveMediaToPublicDir(context, file, null, str);
    }

    public static void updatePhotoMedia(File file, Context context) {
        if (file == null || !file.exists()) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        context.sendBroadcast(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0023 -> B:52:0x005b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void writeToPublicDir(java.io.File r5, android.os.ParcelFileDescriptor r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "writeToPublicDir: "
            java.lang.String r1 = "LibStorageUtils"
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L30 java.io.FileNotFoundException -> L33
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L30 java.io.FileNotFoundException -> L33
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L29 java.io.FileNotFoundException -> L2d
            java.io.FileDescriptor r6 = r6.getFileDescriptor()     // Catch: java.lang.Throwable -> L29 java.io.FileNotFoundException -> L2d
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L29 java.io.FileNotFoundException -> L2d
            copy(r3, r4)     // Catch: java.lang.Throwable -> L27 java.io.FileNotFoundException -> L2e
            r3.close()     // Catch: java.io.IOException -> L1a
            goto L1e
        L1a:
            r5 = move-exception
            io.rong.common.RLog.e(r1, r0, r5)
        L1e:
            r4.close()     // Catch: java.io.IOException -> L22
            goto L5b
        L22:
            r5 = move-exception
            io.rong.common.RLog.e(r1, r0, r5)
            goto L5b
        L27:
            r5 = move-exception
            goto L2b
        L29:
            r5 = move-exception
            r4 = r2
        L2b:
            r2 = r3
            goto L5d
        L2d:
            r4 = r2
        L2e:
            r2 = r3
            goto L34
        L30:
            r5 = move-exception
            r4 = r2
            goto L5d
        L33:
            r4 = r2
        L34:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
            r6.<init>()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r3 = "writeToPublicDir file is not found file path is "
            r6.append(r3)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r5 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L5c
            r6.append(r5)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L5c
            io.rong.common.RLog.e(r1, r5)     // Catch: java.lang.Throwable -> L5c
            if (r2 == 0) goto L56
            r2.close()     // Catch: java.io.IOException -> L52
            goto L56
        L52:
            r5 = move-exception
            io.rong.common.RLog.e(r1, r0, r5)
        L56:
            if (r4 == 0) goto L5b
            r4.close()     // Catch: java.io.IOException -> L22
        L5b:
            return
        L5c:
            r5 = move-exception
        L5d:
            if (r2 == 0) goto L67
            r2.close()     // Catch: java.io.IOException -> L63
            goto L67
        L63:
            r6 = move-exception
            io.rong.common.RLog.e(r1, r0, r6)
        L67:
            if (r4 == 0) goto L71
            r4.close()     // Catch: java.io.IOException -> L6d
            goto L71
        L6d:
            r6 = move-exception
            io.rong.common.RLog.e(r1, r0, r6)
        L71:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.utilities.KitStorageUtils.writeToPublicDir(java.io.File, android.os.ParcelFileDescriptor):void");
    }

    public Uri getContentUri(int i, String str) {
        if (i == 0) {
            return MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon().appendPath(String.valueOf(str)).build();
        }
        if (i == 1) {
            return MediaStore.Video.Media.EXTERNAL_CONTENT_URI.buildUpon().appendPath(String.valueOf(str)).build();
        }
        if (i != 2) {
            return null;
        }
        return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI.buildUpon().appendPath(String.valueOf(str)).build();
    }

    public InputStream getFileInputStreamWithUri(Context context, Uri uri) {
        try {
            ParcelFileDescriptor parcelFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r").getParcelFileDescriptor();
            if (parcelFileDescriptor != null) {
                return new FileInputStream(parcelFileDescriptor.getFileDescriptor());
            }
            return null;
        } catch (FileNotFoundException e2) {
            RLog.e(TAG, "getFileInputStreamWithUri: ", e2);
            return null;
        }
    }

    public static boolean saveMediaToPublicDir(Context context, File file, String str, String str2) {
        if ("image".equals(str2)) {
            return copyImageToPublicDir(context, file, str);
        }
        if ("video".equals(str2)) {
            return copyVideoToPublicDir(context, file, str);
        }
        RLog.i(TAG, "type is error");
        return false;
    }
}
