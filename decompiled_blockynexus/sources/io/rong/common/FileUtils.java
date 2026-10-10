package io.rong.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import io.rong.imlib.NativeClient;
import io.rong.imlib.common.DeviceUtils;
import io.rong.imlib.common.SavePathUtils;
import io.rong.imlib.common.SharedPreferencesUtils;
import io.rong.imlib.filetransfer.FtConst;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes5.dex */
public class FileUtils {
    public static final int FILE_SCHEME_LENGTH = 7;
    private static String TAG = "FileUtils";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.io.File] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005b -> B:53:0x008a). Please report as a decompilation issue!!! */
    public static File byte2File(byte[] bArr, String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                try {
                    File file = new File((String) str);
                    if (!file.exists()) {
                        RLog.d(TAG, "byte2File: dir does not exist!");
                        if (!file.mkdirs()) {
                            RLog.e(TAG, "Created folders unSuccessfully");
                        }
                    }
                    str = new File(file.getPath() + File.separator + str2);
                    try {
                        fileOutputStream = new FileOutputStream((File) str);
                        try {
                            try {
                                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                            } catch (Exception e2) {
                                e = e2;
                            }
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream = null;
                    }
                } catch (IOException e4) {
                    RLog.e(TAG, "byte2File: IOException!", e4);
                    str = str;
                }
            } catch (Exception e5) {
                e = e5;
                str = 0;
                fileOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            bufferedOutputStream.write(bArr);
            try {
                bufferedOutputStream.close();
            } catch (IOException e6) {
                RLog.e(TAG, "byte2File: IOException!", e6);
            }
            fileOutputStream.close();
            str = str;
        } catch (Exception e7) {
            e = e7;
            bufferedOutputStream2 = bufferedOutputStream;
            RLog.e(TAG, "byte2File: Exception!", e);
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e8) {
                    RLog.e(TAG, "byte2File: IOException!", e8);
                }
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
                str = str;
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e9) {
                    RLog.e(TAG, "byte2File: IOException!", e9);
                }
            }
            if (fileOutputStream == null) {
                throw th;
            }
            try {
                fileOutputStream.close();
                throw th;
            } catch (IOException e10) {
                RLog.e(TAG, "byte2File: IOException!", e10);
                throw th;
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] contentFile2byte(android.content.Context r5, android.net.Uri r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "file2byte fis close"
            r1 = 0
            if (r5 == 0) goto L86
            if (r6 == 0) goto L86
            boolean r2 = uriStartWithContent(r6)
            if (r2 != 0) goto Lf
            goto L86
        Lf:
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.io.FileNotFoundException -> L6b
            java.lang.String r2 = "r"
            android.os.ParcelFileDescriptor r5 = r5.openFileDescriptor(r6, r2)     // Catch: java.io.FileNotFoundException -> L6b
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            java.io.FileDescriptor r5 = r5.getFileDescriptor()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L5d
            r5.<init>()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L5d
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L5d
        L2b:
            int r3 = r6.read(r2)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L5d
            r4 = -1
            if (r3 == r4) goto L37
            r4 = 0
            r5.write(r2, r4, r3)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L5d
            goto L2b
        L37:
            r5.close()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L5d
            byte[] r1 = r5.toByteArray()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L5d
            r6.close()     // Catch: java.io.IOException -> L42
            goto L5c
        L42:
            r5 = move-exception
            java.lang.String r6 = io.rong.common.FileUtils.TAG
            io.rong.common.RLog.e(r6, r0, r5)
            goto L5c
        L49:
            r5 = move-exception
            goto L50
        L4b:
            r5 = move-exception
            r6 = r1
            goto L5e
        L4e:
            r5 = move-exception
            r6 = r1
        L50:
            java.lang.String r2 = io.rong.common.FileUtils.TAG     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = "file2byte: Exception!"
            io.rong.common.RLog.e(r2, r3, r5)     // Catch: java.lang.Throwable -> L5d
            if (r6 == 0) goto L5c
            r6.close()     // Catch: java.io.IOException -> L42
        L5c:
            return r1
        L5d:
            r5 = move-exception
        L5e:
            if (r6 == 0) goto L6a
            r6.close()     // Catch: java.io.IOException -> L64
            goto L6a
        L64:
            r6 = move-exception
            java.lang.String r1 = io.rong.common.FileUtils.TAG
            io.rong.common.RLog.e(r1, r0, r6)
        L6a:
            throw r5
        L6b:
            java.lang.String r5 = io.rong.common.FileUtils.TAG
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "contentFile2byte file not found uri is "
            r0.append(r2)
            java.lang.String r6 = r6.toString()
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            io.rong.common.RLog.e(r5, r6)
            return r1
        L86:
            java.lang.String r5 = io.rong.common.FileUtils.TAG
            java.lang.String r6 = "contentFile2byte params error"
            io.rong.common.RLog.e(r5, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.common.FileUtils.contentFile2byte(android.content.Context, android.net.Uri):byte[]");
    }

    public static File convertBitmap2File(Bitmap bitmap, String str, String str2) {
        if (bitmap == null || TextUtils.isEmpty(str)) {
            RLog.e(TAG, "convertBitmap2File bm or dir should not be null!");
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            RLog.e(TAG, "convertBitmap2File: dir does not exist! -" + file.getAbsolutePath());
            if (!file.mkdirs()) {
                RLog.e(TAG, "Created folders unSuccessfully");
            }
        }
        File file2 = new File(file.getPath() + File.separator + str2);
        if (file2.exists()) {
            boolean zDelete = file2.delete();
            RLog.e(TAG, "convertBitmap2File targetFile isDelete:" + zDelete);
        }
        File file3 = new File(file.getPath() + File.separator + str2 + ".tmp");
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e2) {
            RLog.e(TAG, "convertBitmap2File: Exception!", e2);
        }
        File file4 = new File(file.getPath() + File.separator + str2);
        return file3.renameTo(file4) ? file4 : file3;
    }

    public static File copyFile(File file, String str, String str2) {
        if (file == null) {
            RLog.e(TAG, "copyFile src should not be null!");
            return null;
        }
        if (!file.exists()) {
            RLog.e(TAG, "copyFile: src file does not exist! -" + file.getAbsolutePath());
            return null;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            RLog.d(TAG, "copyFile: dir does not exist!");
            if (!file2.mkdirs()) {
                RLog.e(TAG, "Created folders unSuccessfully");
            }
        }
        File file3 = new File(str + str2);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    fileInputStream.close();
                    return file3;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e2) {
            RLog.e(TAG, "copyFile: Exception!", e2);
            return file3;
        }
    }

    public static boolean copyFileToInternal(Context context, Uri uri, String str, String str2) {
        if (uriStartWithFile(uri)) {
            return copyFile(uri.toString(), str, str2);
        }
        if (uriStartWithContent(uri)) {
            return copyFile(context, uri, new File(str, str2).getAbsolutePath());
        }
        return false;
    }

    public static byte[] file2byte(File file) {
        if (file == null) {
            RLog.e(TAG, "file2byte file should not be null!");
            return null;
        }
        if (!file.exists()) {
            RLog.e(TAG, "file2byte: src file does not exist! -" + file.getAbsolutePath());
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e2) {
            RLog.e(TAG, "file2byte: Exception!", e2);
            return null;
        }
    }

    public static byte[] getByteFromUri(Uri uri) {
        if (uri == null) {
            RLog.e(TAG, "getByteFromUri uri should not be null!");
            return null;
        }
        InputStream fileInputStream = getFileInputStream(uri.getPath());
        int iAvailable = 0;
        while (iAvailable == 0) {
            try {
                iAvailable = fileInputStream.available();
                if (iAvailable == 0) {
                    break;
                }
            } catch (Exception unused) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        RLog.e(TAG, "getByteFromUri", e2);
                    }
                }
                return null;
            } catch (Throwable th) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        RLog.e(TAG, "getByteFromUri", e3);
                    }
                }
                throw th;
            }
        }
        byte[] bArr = new byte[iAvailable];
        int i = fileInputStream.read(bArr);
        RLog.i(TAG, "byteCount = " + i);
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e4) {
                RLog.e(TAG, "getByteFromUri", e4);
            }
        }
        return bArr;
    }

    public static String getCacheDirsPath(Context context, String str) {
        File externalCacheDir;
        if (!SavePathUtils.isSavePathEmpty()) {
            return SavePathUtils.getSavePath();
        }
        boolean zEquals = false;
        try {
            zEquals = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e2) {
            RLog.e(TAG, "getCacheDirsPath ", e2);
        }
        if (Build.VERSION.SDK_INT >= 19 || hasFilePermission(context)) {
            try {
                externalCacheDir = context.getExternalCacheDir();
            } catch (ArrayIndexOutOfBoundsException e3) {
                RLog.e(TAG, "getCacheDirsPath ArrayIndexOutOfBoundsException", e3);
                externalCacheDir = null;
            }
        } else {
            externalCacheDir = context.getCacheDir();
        }
        if (!zEquals || externalCacheDir == null || (!externalCacheDir.exists() && !externalCacheDir.mkdirs())) {
            externalCacheDir = context.getCacheDir();
        }
        File file = new File(externalCacheDir.getPath() + File.separator + str);
        if (file.exists()) {
            if (file.isFile()) {
                boolean zDelete = file.delete();
                RLog.e(TAG, "getCacheDirsPath isDelete:" + zDelete);
            }
        } else if (!file.mkdirs()) {
            RLog.e(TAG, "getCacheDirsPath created folders unSuccessfully");
        }
        if (!file.exists()) {
            boolean zMkdir = file.mkdir();
            RLog.w(TAG, "getCachePath = " + file.getPath() + ", result = " + zMkdir);
            if (!zMkdir) {
                if (Build.VERSION.SDK_INT < 23 || !hasFilePermission(context)) {
                    file = new File(context.getFilesDir(), str);
                    if (!file.exists()) {
                        zMkdir = file.mkdirs();
                    }
                } else {
                    File file2 = new File("/sdcard/cache/" + str);
                    if (!file2.exists()) {
                        zMkdir = file2.mkdirs();
                    }
                    file = file2;
                }
                RLog.e(TAG, "change path = " + file.getPath() + ", result = " + zMkdir);
            }
        }
        return file.getPath();
    }

    public static String getCachePath(Context context) {
        return getCachePath(context, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00af  */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static io.rong.common.FileInfo getFileInfoByContent(android.content.Context r10, android.net.Uri r11) throws java.lang.Throwable {
        /*
            boolean r0 = uriStartWithContent(r11)
            r1 = 0
            if (r0 == 0) goto Lb3
            r0 = 3
            java.lang.String[] r4 = new java.lang.String[r0]
            r0 = 0
            java.lang.String r2 = "_display_name"
            r4[r0] = r2
            r8 = 1
            java.lang.String r2 = "_size"
            r4[r8] = r2
            r2 = 2
            java.lang.String r3 = "mime_type"
            r4[r2] = r3
            io.rong.common.FileInfo r9 = new io.rong.common.FileInfo     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9d
            r9.<init>()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9d
            android.content.ContentResolver r2 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9d
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r11
            android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9d
            if (r10 != 0) goto L39
            java.lang.String r11 = io.rong.common.FileUtils.TAG     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            java.lang.String r0 = "getFileInfoByContent cursor is null"
            io.rong.common.RLog.e(r11, r0)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            if (r10 == 0) goto L38
            r10.close()
        L38:
            return r1
        L39:
            boolean r2 = r10.moveToFirst()     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            if (r2 == 0) goto L92
            java.lang.String r0 = r10.getString(r0)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            long r2 = r10.getLong(r8)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            r9.setName(r0)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            r9.setSize(r2)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            if (r2 != 0) goto L85
            java.lang.String r2 = "."
            int r2 = r0.lastIndexOf(r2)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            if (r2 <= 0) goto L63
            int r2 = r2 + r8
            java.lang.String r0 = r0.substring(r2)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            r9.setType(r0)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
        L63:
            boolean r0 = r10.moveToNext()     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            if (r0 == 0) goto L7f
            java.lang.String r0 = io.rong.common.FileUtils.TAG     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            r2.<init>()     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            java.lang.String r3 = "uri is error,cursor has second value,uri is"
            r2.append(r3)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            r2.append(r11)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            java.lang.String r11 = r2.toString()     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            io.rong.common.RLog.e(r0, r11)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
        L7f:
            if (r10 == 0) goto L84
            r10.close()
        L84:
            return r9
        L85:
            java.lang.String r11 = io.rong.common.FileUtils.TAG     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            java.lang.String r0 = "getFileInfoByContent getName is empty"
            io.rong.common.RLog.e(r11, r0)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> Lac
            if (r10 == 0) goto L91
            r10.close()
        L91:
            return r1
        L92:
            if (r10 == 0) goto L97
            r10.close()
        L97:
            return r1
        L98:
            r11 = move-exception
            goto L9f
        L9a:
            r11 = move-exception
            r10 = r1
            goto Lad
        L9d:
            r11 = move-exception
            r10 = r1
        L9f:
            java.lang.String r0 = io.rong.common.FileUtils.TAG     // Catch: java.lang.Throwable -> Lac
            java.lang.String r2 = "getDocumentByContent is error"
            io.rong.common.RLog.e(r0, r2, r11)     // Catch: java.lang.Throwable -> Lac
            if (r10 == 0) goto Lab
            r10.close()
        Lab:
            return r1
        Lac:
            r11 = move-exception
        Lad:
            if (r10 == 0) goto Lb2
            r10.close()
        Lb2:
            throw r11
        Lb3:
            java.lang.String r10 = io.rong.common.FileUtils.TAG
            java.lang.String r11 = "getDocumentByContent uri is not content"
            io.rong.common.RLog.e(r10, r11)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.common.FileUtils.getFileInfoByContent(android.content.Context, android.net.Uri):io.rong.common.FileInfo");
    }

    private static FileInfo getFileInfoByFile(Uri uri) {
        if (!uriStartWithFile(uri)) {
            RLog.e(TAG, "getDocumentByFile uri is not file");
            return null;
        }
        File file = new File(uri.toString().substring(7));
        if (!file.exists()) {
            return null;
        }
        FileInfo fileInfo = new FileInfo();
        String name = file.getName();
        fileInfo.setSize(file.length());
        fileInfo.setName(name);
        int iLastIndexOf = name.lastIndexOf(Consts.DOT);
        if (iLastIndexOf > 0) {
            fileInfo.setType(file.getName().substring(iLastIndexOf + 1));
        }
        return fileInfo;
    }

    public static FileInfo getFileInfoByUri(Context context, Uri uri) {
        if (uriStartWithContent(uri)) {
            return getFileInfoByContent(context, uri);
        }
        if (uriStartWithFile(uri)) {
            return getFileInfoByFile(uri);
        }
        return null;
    }

    public static InputStream getFileInputStream(String str) {
        try {
            return new FileInputStream(new File(str));
        } catch (FileNotFoundException e2) {
            RLog.e(TAG, "getFileInputStream", e2);
            return null;
        }
    }

    public static String getFileNameWithPath(String str) {
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "getFileNameWithPath path should not be null!");
            return null;
        }
        int iLastIndexOf = str.lastIndexOf("/");
        if (iLastIndexOf != -1) {
            return str.substring(iLastIndexOf + 1);
        }
        return null;
    }

    public static long getFileSize(File file) {
        long jAvailable = 0;
        try {
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                jAvailable = fileInputStream.available();
                fileInputStream.close();
            } else {
                RLog.d(TAG, "file doesn't exist");
            }
        } catch (Exception e2) {
            RLog.e(TAG, "getFileSize", e2);
        }
        return jAvailable;
    }

    public static String getInternalCachePath(Context context, String str) {
        if (!SavePathUtils.isSavePathEmpty()) {
            return SavePathUtils.getSavePath();
        }
        File file = new File(context.getCacheDir().getPath() + File.separator + str);
        if (!file.exists()) {
            boolean zMkdir = file.mkdir();
            RLog.w(TAG, "getInternalCachePath = " + file.getPath() + ", result = " + zMkdir);
        }
        return file.getPath();
    }

    @Deprecated
    public static String getMediaDownloadDir(Context context) {
        return LibStorageUtils.getMediaDownloadDir(context);
    }

    public static String getStringFromFile(String str) throws Throwable {
        BufferedReader bufferedReader = null;
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "getStringFromFile path should not be null!");
            return null;
        }
        if (!new File(str).exists()) {
            RLog.e(TAG, "getStringFromFile file is not exists,path:" + str);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
        } catch (IOException e2) {
            RLog.e(TAG, "getStringFromFile IOException", e2);
        }
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    } catch (IOException e3) {
                        bufferedReader = bufferedReader2;
                        e = e3;
                        RLog.e(TAG, "getStringFromFile IOException", e);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return sb.toString();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                RLog.e(TAG, "getStringFromFile IOException", e4);
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
            } catch (IOException e5) {
                e = e5;
            }
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String getSuffix(Uri uri) {
        if (uri == null) {
            return null;
        }
        return getSuffix(uri.toString());
    }

    public static String getTempFileMD5(Context context, int i) {
        return getTempFileMD5(context, i + "");
    }

    public static String getTempFilePath(Context context, int i) {
        return getTempFilePath(context, i + "");
    }

    private static boolean hasFilePermission(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static boolean isFileExistsWithUri(Context context, Uri uri) {
        if (uri == null) {
            return false;
        }
        if (uriStartWithFile(uri)) {
            return new File(uri.toString().substring(7)).exists();
        }
        if (uriStartWithContent(uri)) {
            try {
                return context.getContentResolver().openFileDescriptor(uri, "r") != null;
            } catch (FileNotFoundException unused) {
                return false;
            }
        }
        if (uri.toString().startsWith("/")) {
            return new File(uri.toString()).exists();
        }
        return false;
    }

    public static boolean isValidateLocalUri(Uri uri) {
        return uriStartWithFile(uri) || uriStartWithContent(uri);
    }

    public static int readPictureDegree(Context context, String str) {
        ExifInterface exifInterface = null;
        try {
            if (LibStorageUtils.isBuildAndTargetForQ(context) && uriStartWithContent(Uri.parse(str))) {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(Uri.parse(str), "r");
                if (parcelFileDescriptorOpenFileDescriptor != null && Build.VERSION.SDK_INT >= 24) {
                    exifInterface = new ExifInterface(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                }
            } else {
                exifInterface = new ExifInterface(str);
            }
            if (exifInterface == null) {
                return 0;
            }
            int attributeInt = exifInterface.getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (Exception unused) {
            RLog.e(TAG, "readPictureDegree error");
            return 0;
        }
    }

    public static void removeFile(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                boolean zDelete = file.delete();
                RLog.e(TAG, "removeFile isDelete:" + zDelete);
            }
        } catch (Exception e2) {
            RLog.e(TAG, "removeFile Exception", e2);
        }
    }

    public static void saveFile(String str, String str2) {
        try {
            File file = new File(str2);
            if (!file.exists()) {
                if (!new File(file.getParent()).mkdirs()) {
                    RLog.e(TAG, "Created folders unSuccessfully");
                }
                boolean zCreateNewFile = file.createNewFile();
                RLog.e(TAG, "saveFile isCreateNewFile" + zCreateNewFile);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
        } catch (Exception e2) {
            RLog.e(TAG, "saveFile", e2);
        }
    }

    public static boolean uriStartWithContent(Uri uri) {
        return uri != null && "content".equals(uri.getScheme());
    }

    public static boolean uriStartWithFile(Uri uri) {
        return uri != null && LibStorageUtils.FILE.equals(uri.getScheme()) && uri.toString().length() > 7;
    }

    public static void writeByte(Uri uri, byte[] bArr) {
        if (uri == null || uri.getPath() == null || uri.getPath().lastIndexOf("/") == -1) {
            return;
        }
        if (!new File(uri.getPath().substring(0, uri.getPath().lastIndexOf("/"))).mkdirs()) {
            RLog.e(TAG, "Created folders unSuccessfully");
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(uri.getPath())));
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.close();
        } catch (IOException e2) {
            RLog.e(TAG, "writeByte", e2);
        }
    }

    public static String getCachePath(Context context, String str) {
        File externalCacheDir;
        if (!SavePathUtils.isSavePathEmpty()) {
            return SavePathUtils.getSavePath();
        }
        boolean zEquals = false;
        try {
            zEquals = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e2) {
            RLog.e(TAG, "getCachePath", e2);
        }
        if (Build.VERSION.SDK_INT >= 19 || hasFilePermission(context)) {
            try {
                externalCacheDir = context.getExternalCacheDir();
            } catch (ArrayIndexOutOfBoundsException e3) {
                RLog.e(TAG, "getCachePath ArrayIndexOutOfBoundsException", e3);
                externalCacheDir = null;
            }
        } else {
            externalCacheDir = context.getCacheDir();
        }
        if (!zEquals || externalCacheDir == null || (!externalCacheDir.exists() && !externalCacheDir.mkdirs())) {
            externalCacheDir = context.getCacheDir();
        }
        File file = new File(externalCacheDir.getPath() + File.separator + str);
        if (file.exists() && file.isFile()) {
            boolean zDelete = file.delete();
            RLog.e(TAG, "getCachePath isDelete:" + zDelete);
        }
        if (!file.exists()) {
            boolean zMkdir = file.mkdir();
            RLog.w(TAG, "getCachePath = " + file.getPath() + ", result = " + zMkdir);
            if (!zMkdir) {
                if (Build.VERSION.SDK_INT < 23 || !hasFilePermission(context)) {
                    file = new File(context.getFilesDir(), str);
                    if (!file.exists()) {
                        zMkdir = file.mkdirs();
                    }
                } else {
                    File file2 = new File("/sdcard/cache/" + str);
                    if (!file2.exists()) {
                        zMkdir = file2.mkdirs();
                    }
                    file = file2;
                }
                RLog.e(TAG, "change path = " + file.getPath() + ", result = " + zMkdir);
            }
        }
        return file.getPath();
    }

    @Deprecated
    public static String getMediaDownloadDir(Context context, String str) {
        return LibStorageUtils.getMediaDownloadDir(context, str);
    }

    public static String getSuffix(String str) {
        int iLastIndexOf;
        if (!TextUtils.isEmpty(str) && (iLastIndexOf = str.lastIndexOf(Consts.DOT)) >= 0) {
            return str.substring(iLastIndexOf + 1);
        }
        return null;
    }

    public static String getTempFileMD5(Context context, String str) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = SharedPreferencesUtils.get(context, "Statistics", 0);
        return DeviceUtils.ShortMD5(0, sharedPreferences.getString("appKey", "Null"), SystemUtils.getCurrentProcessName(context).equals(context.getPackageName()) ? sharedPreferences.getString("userId", "Null") : NativeClient.getInstance().getCurrentUserId(), str);
    }

    public static String getTempFilePath(Context context, String str) {
        SharedPreferences sharedPreferences = SharedPreferencesUtils.get(context, "Statistics", 0);
        return getCacheDirsPath(context, FtConst.TEMP_TRANSFER_FILE_DIR + File.separator + sharedPreferences.getString("appKey", "Null") + File.separator + (SystemUtils.getCurrentProcessName(context).equals(context.getPackageName()) ? sharedPreferences.getString("userId", "Null") : NativeClient.getInstance().getCurrentUserId())) + File.separator + str + ".txt";
    }

    public static byte[] file2byte(Context context, Uri uri) {
        if (uriStartWithFile(uri)) {
            return file2byte(new File(uri.toString().substring(7)));
        }
        if (uriStartWithContent(uri)) {
            return contentFile2byte(context, uri);
        }
        return null;
    }

    public static FileInfo getFileInfoByFile(File file) {
        if (file != null) {
            if (file.exists()) {
                FileInfo fileInfo = new FileInfo();
                String name = file.getName();
                fileInfo.setSize(file.length());
                fileInfo.setName(name);
                int iLastIndexOf = name.lastIndexOf(Consts.DOT);
                if (iLastIndexOf > 0) {
                    fileInfo.setType(file.getName().substring(iLastIndexOf + 1));
                }
                return fileInfo;
            }
            RLog.e(TAG, "getFileInfoByFile file is not exist");
            return null;
        }
        RLog.e(TAG, "getFileInfoByFile file is null");
        return null;
    }

    public static boolean copyFile(String str, String str2, String str3) throws Throwable {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "copyFile src should not be null!");
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            RLog.e(TAG, "copyFile: src file does not exist! -" + file.getAbsolutePath());
            return false;
        }
        File file2 = new File(str2);
        if (!file2.exists()) {
            RLog.d(TAG, "copyFile: dir does not exist!");
            if (!file2.mkdirs()) {
                RLog.e(TAG, "Created folders unSuccessfully");
            }
        }
        File file3 = new File(str2, str3);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    fileOutputStream = new FileOutputStream(file3);
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    RLog.e(TAG, "copyFile fos close", e3);
                }
                try {
                    fileInputStream.close();
                    return true;
                } catch (IOException e4) {
                    RLog.e(TAG, "copyFile fis close", e4);
                    return true;
                }
            } catch (IOException e5) {
                e = e5;
                fileOutputStream2 = fileOutputStream;
                RLog.e(TAG, "copyFile: Exception!", e);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e6) {
                        RLog.e(TAG, "copyFile fos close", e6);
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e7) {
                        RLog.e(TAG, "copyFile fis close", e7);
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e8) {
                        RLog.e(TAG, "copyFile fos close", e8);
                    }
                }
                if (fileInputStream == null) {
                    throw th;
                }
                try {
                    fileInputStream.close();
                    throw th;
                } catch (IOException e9) {
                    RLog.e(TAG, "copyFile fis close", e9);
                    throw th;
                }
            }
        } catch (IOException e10) {
            e = e10;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean copyFile(android.content.Context r5, android.net.Uri r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "copyFile: Exception!"
            boolean r1 = uriStartWithContent(r6)
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.io.FileNotFoundException -> L9d
            java.lang.String r1 = "r"
            android.os.ParcelFileDescriptor r5 = r5.openFileDescriptor(r6, r1)     // Catch: java.io.FileNotFoundException -> L9d
            if (r5 == 0) goto L9b
            r6 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5f
            java.io.FileDescriptor r5 = r5.getFileDescriptor()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5f
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5f
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L52
        L29:
            int r7 = r1.read(r6)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L52
            r3 = -1
            if (r7 == r3) goto L34
            r5.write(r6, r2, r7)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L52
            goto L29
        L34:
            r5.flush()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L52
            r1.close()     // Catch: java.io.IOException -> L3b
            goto L41
        L3b:
            r6 = move-exception
            java.lang.String r7 = io.rong.common.FileUtils.TAG
            io.rong.common.RLog.e(r7, r0, r6)
        L41:
            r5.close()     // Catch: java.io.IOException -> L46
            goto L9b
        L46:
            r5 = move-exception
            java.lang.String r6 = io.rong.common.FileUtils.TAG
            io.rong.common.RLog.e(r6, r0, r5)
            goto L9b
        L4d:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
            goto L82
        L52:
            r6 = move-exception
            r7 = r5
            r5 = r6
            goto L5a
        L56:
            r5 = move-exception
            goto L82
        L58:
            r5 = move-exception
            r7 = r6
        L5a:
            r6 = r1
            goto L61
        L5c:
            r5 = move-exception
            r1 = r6
            goto L82
        L5f:
            r5 = move-exception
            r7 = r6
        L61:
            java.lang.String r1 = io.rong.common.FileUtils.TAG     // Catch: java.lang.Throwable -> L7f
            io.rong.common.RLog.e(r1, r0, r5)     // Catch: java.lang.Throwable -> L7f
            if (r6 == 0) goto L72
            r6.close()     // Catch: java.io.IOException -> L6c
            goto L72
        L6c:
            r5 = move-exception
            java.lang.String r6 = io.rong.common.FileUtils.TAG
            io.rong.common.RLog.e(r6, r0, r5)
        L72:
            if (r7 == 0) goto L7e
            r7.close()     // Catch: java.io.IOException -> L78
            goto L7e
        L78:
            r5 = move-exception
            java.lang.String r6 = io.rong.common.FileUtils.TAG
            io.rong.common.RLog.e(r6, r0, r5)
        L7e:
            return r2
        L7f:
            r5 = move-exception
            r1 = r6
            r6 = r7
        L82:
            if (r1 == 0) goto L8e
            r1.close()     // Catch: java.io.IOException -> L88
            goto L8e
        L88:
            r7 = move-exception
            java.lang.String r1 = io.rong.common.FileUtils.TAG
            io.rong.common.RLog.e(r1, r0, r7)
        L8e:
            if (r6 == 0) goto L9a
            r6.close()     // Catch: java.io.IOException -> L94
            goto L9a
        L94:
            r6 = move-exception
            java.lang.String r7 = io.rong.common.FileUtils.TAG
            io.rong.common.RLog.e(r7, r0, r6)
        L9a:
            throw r5
        L9b:
            r5 = 1
            return r5
        L9d:
            java.lang.String r5 = io.rong.common.FileUtils.TAG
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "copyFile srcUri is error uri is "
            r7.append(r0)
            java.lang.String r6 = r6.toString()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            io.rong.common.RLog.e(r5, r6)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.common.FileUtils.copyFile(android.content.Context, android.net.Uri, java.lang.String):boolean");
    }
}
