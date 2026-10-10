package io.rong.message.utils;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.Base64;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.common.FileUtils;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class BitmapUtil {
    private static final int ASPECT_RATIO = 2;
    private static final String TAG = "Util";

    private static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        int iRound = Math.round(i3 / i2);
        int iRound2 = Math.round(i4 / i);
        return iRound < iRound2 ? iRound : iRound2;
    }

    public static String getBase64FromBitmap(Bitmap bitmap) throws Throwable {
        String str;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        String strEncodeToString = null;
        byteArrayOutputStream2 = null;
        try {
            if (bitmap != null) {
                try {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (IOException e2) {
                        e = e2;
                        str = null;
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                }
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
                    strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    RLog.d("base64Str", "" + strEncodeToString.length());
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    str = strEncodeToString;
                    byteArrayOutputStream3 = byteArrayOutputStream;
                } catch (IOException e3) {
                    e = e3;
                    str = strEncodeToString;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    RLog.e(TAG, "IOException ", e);
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.flush();
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                            RLog.e(TAG, "IOException ", e4);
                        }
                    }
                    throw th;
                }
            } else {
                str = null;
            }
            if (byteArrayOutputStream3 != null) {
                byteArrayOutputStream3.flush();
                byteArrayOutputStream3.close();
            }
        } catch (IOException e5) {
            RLog.e(TAG, "IOException ", e5);
        }
        return str;
    }

    public static Bitmap getBitmapFromBase64(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bArrDecode = Base64.decode(str, 2);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    public static Bitmap getBlurryBitmap(Context context, Bitmap bitmap, float f2, float f3) {
        RenderScript renderScriptCreate = RenderScript.create(context);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * f3), (int) (f3 * bitmap.getHeight()), false);
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
        Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.setRadius(f2);
        scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
        allocationCreateTyped.copyTo(bitmapCreateScaledBitmap);
        renderScriptCreate.destroy();
        return bitmapCreateScaledBitmap;
    }

    private static ExifInterface getExifInterfaceFromUri(Context context, Uri uri) throws IOException {
        if (FileUtils.uriStartWithFile(uri)) {
            return new ExifInterface(uri.toString().substring(7));
        }
        if (!FileUtils.uriStartWithContent(uri)) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return new ExifInterface(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
        }
        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (cursorQuery == null) {
            RLog.e(TAG, "cursor is null");
            return null;
        }
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(0);
        cursorQuery.close();
        return new ExifInterface(string);
    }

    public static Bitmap getFactoryBitmap(Context context, Uri uri, BitmapFactory.Options options) {
        if (FileUtils.uriStartWithFile(uri)) {
            return BitmapFactory.decodeFile(uri.toString().substring(7), options);
        }
        if (FileUtils.uriStartWithContent(uri)) {
            try {
                return BitmapFactory.decodeFileDescriptor(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor(), null, options);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap getNewResizedBitmap(android.content.Context r18, android.net.Uri r19, int r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.message.utils.BitmapUtil.getNewResizedBitmap(android.content.Context, android.net.Uri, int):android.graphics.Bitmap");
    }

    public static Bitmap getResizedBitmap(Context context, Uri uri, int i, int i2) throws IOException {
        String string;
        int i3;
        int i4;
        Bitmap bitmapDecodeFile;
        if (!LibStorageUtils.FILE.equals(uri.getScheme())) {
            if ("content".equals(uri.getScheme())) {
                Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                if (cursorQuery == null) {
                    RLog.e(TAG, "cursor is null");
                    return null;
                }
                cursorQuery.moveToFirst();
                string = cursorQuery.getString(0);
                cursorQuery.close();
            }
            return null;
        }
        string = uri.toString().substring(5);
        ExifInterface exifInterface = new ExifInterface(string);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(string, options);
        int attributeInt = exifInterface.getAttributeInt("Orientation", 0);
        if (attributeInt == 6 || attributeInt == 8 || attributeInt == 5 || attributeInt == 7) {
            i3 = i;
            i4 = i2;
        } else {
            i4 = i;
            i3 = i2;
        }
        int i5 = options.outWidth;
        int i6 = options.outHeight;
        int i7 = 1;
        while (true) {
            i5 /= 2;
            if (i5 <= i4) {
                break;
            }
            i7 <<= 1;
        }
        int i8 = 1;
        while (true) {
            i6 /= 2;
            if (i6 <= i3) {
                break;
            }
            i8 <<= 1;
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = (i4 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE) ? Math.max(i7, i8) : Math.max(i7, i8);
        try {
            bitmapDecodeFile = BitmapFactory.decodeFile(string, options2);
        } catch (OutOfMemoryError e2) {
            RLog.e(TAG, "OutOfMemoryError ", e2);
            options2.inSampleSize <<= 1;
            bitmapDecodeFile = BitmapFactory.decodeFile(string, options2);
        }
        Bitmap bitmap = bitmapDecodeFile;
        Matrix matrix = new Matrix();
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (attributeInt == 6 || attributeInt == 8 || attributeInt == 5 || attributeInt == 7) {
            height = width;
            width = height;
        }
        switch (attributeInt) {
            case 2:
                matrix.preScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f, width / 2.0f, height / 2.0f);
                break;
            case 4:
                matrix.preScale(1.0f, -1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f, width / 2.0f, height / 2.0f);
                matrix.preScale(1.0f, -1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f, width / 2.0f, height / 2.0f);
                break;
            case 7:
                matrix.setRotate(270.0f, width / 2.0f, height / 2.0f);
                matrix.preScale(1.0f, -1.0f);
                break;
            case 8:
                matrix.setRotate(270.0f, width / 2.0f, height / 2.0f);
                break;
        }
        float width2 = i4 / bitmap.getWidth();
        float height2 = i3 / bitmap.getHeight();
        matrix.postScale(Math.min(width2, height2), Math.min(width2, height2));
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e3) {
            RLog.e(TAG, "OutOfMemoryError ", e3);
            RLog.d("ResourceCompressHandler", "OOMHeight:" + bitmap.getHeight() + "Width:" + bitmap.getHeight() + "matrix:" + width2 + " " + height2);
        }
    }

    public static Bitmap getThumbBitmap(Context context, Uri uri, int i, int i2) throws IOException {
        BitmapFactory.Options options;
        Bitmap factoryBitmap;
        float f2;
        float height;
        int width;
        int height2;
        int width2;
        int height3;
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        ExifInterface exifInterfaceFromUri = getExifInterfaceFromUri(context, uri);
        if (exifInterfaceFromUri == null) {
            RLog.e(TAG, "getThumbBitmap exifInterface is null");
            return null;
        }
        getFactoryBitmap(context, uri, options2);
        int attributeInt = exifInterfaceFromUri.getAttributeInt("Orientation", 0);
        int i3 = options2.outWidth;
        int i4 = options2.outHeight;
        int i5 = i3 > i4 ? i3 : i4;
        int i6 = i3 > i4 ? i4 : i3;
        float f3 = i5 / i6;
        float f4 = i;
        float f5 = i2;
        float f6 = f4 / f5;
        if (f3 > f6) {
            int i7 = 1;
            while (true) {
                i6 /= 2;
                if (i6 <= i2) {
                    break;
                }
                i7 <<= 1;
            }
            options = new BitmapFactory.Options();
            options.inSampleSize = i7;
        } else {
            int i8 = 1;
            while (true) {
                i3 /= 2;
                if (i3 <= i) {
                    break;
                }
                i8 <<= 1;
            }
            int i9 = 1;
            while (true) {
                i4 /= 2;
                if (i4 <= i) {
                    break;
                }
                i9 <<= 1;
            }
            BitmapFactory.Options options3 = new BitmapFactory.Options();
            options3.inSampleSize = Math.max(i8, i9);
            options = options3;
        }
        try {
            factoryBitmap = getFactoryBitmap(context, uri, options);
        } catch (OutOfMemoryError e2) {
            RLog.e(TAG, "OutOfMemoryError ", e2);
            options.inSampleSize <<= 1;
            factoryBitmap = getFactoryBitmap(context, uri, options);
        }
        Bitmap bitmap = factoryBitmap;
        Matrix matrix = new Matrix();
        if (bitmap == null) {
            return null;
        }
        int width3 = bitmap.getWidth();
        int height4 = bitmap.getHeight();
        if (attributeInt == 6 || attributeInt == 8 || attributeInt == 5 || attributeInt == 7) {
            height4 = width3;
            width3 = height4;
        }
        switch (attributeInt) {
            case 2:
                matrix.preScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f, width3 / 2.0f, height4 / 2.0f);
                break;
            case 4:
                matrix.preScale(1.0f, -1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f, width3 / 2.0f, height4 / 2.0f);
                matrix.preScale(1.0f, -1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f, width3 / 2.0f, height4 / 2.0f);
                break;
            case 7:
                matrix.setRotate(270.0f, width3 / 2.0f, height4 / 2.0f);
                matrix.preScale(1.0f, -1.0f);
                break;
            case 8:
                matrix.setRotate(270.0f, width3 / 2.0f, height4 / 2.0f);
                break;
        }
        float f7 = WheelView.DividerConfig.FILL;
        if (f3 > f6) {
            height = f5 / (bitmap.getWidth() > bitmap.getHeight() ? bitmap.getHeight() : bitmap.getWidth());
            matrix.postScale(height, height);
            f2 = WheelView.DividerConfig.FILL;
        } else {
            float width4 = f4 / bitmap.getWidth();
            float height5 = f4 / bitmap.getHeight();
            matrix.postScale(Math.min(width4, height5), Math.min(width4, height5));
            f7 = height5;
            f2 = width4;
            height = WheelView.DividerConfig.FILL;
        }
        try {
            if (f3 <= f6) {
                width = bitmap.getWidth();
                height2 = bitmap.getHeight();
                width2 = 0;
            } else {
                if (bitmap.getWidth() <= bitmap.getHeight()) {
                    int width5 = bitmap.getWidth();
                    int i10 = (i * width5) / i2;
                    height2 = i10;
                    width = width5;
                    height3 = (bitmap.getHeight() - i10) / 2;
                    width2 = 0;
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, width2, height3, width, height2, matrix, true);
                    if (!bitmap.isRecycled() && !bitmap.equals(bitmapCreateBitmap)) {
                        bitmap.recycle();
                    }
                    return bitmapCreateBitmap;
                }
                int height6 = bitmap.getHeight();
                int i11 = (i * height6) / i2;
                width = i11;
                height2 = height6;
                width2 = (bitmap.getWidth() - i11) / 2;
            }
            height3 = 0;
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap, width2, height3, width, height2, matrix, true);
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return bitmapCreateBitmap2;
        } catch (OutOfMemoryError e3) {
            RLog.e(TAG, "OutOfMemoryError ", e3);
            RLog.d("ResourceCompressHandler", "OOMHeight:" + bitmap.getHeight() + "Width:" + bitmap.getHeight() + "matrix:" + height + " " + f2 + " " + f7);
            if (bitmap.isRecycled()) {
                return null;
            }
            bitmap.recycle();
            return null;
        }
    }

    public static Bitmap interceptBitmap(String str, int i, int i2) {
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        int width = bitmapDecodeFile.getWidth();
        int height = bitmapDecodeFile.getHeight();
        int i3 = (width - i) / 2;
        int i4 = (height - i2) / 2;
        if (i3 > 0 && i4 > 0) {
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, i3, i4, i, i2);
                if (!bitmapDecodeFile.isRecycled()) {
                    bitmapDecodeFile.recycle();
                }
                return bitmapCreateBitmap;
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }
        RLog.w(TAG, "ignore intercept [" + width + ", " + height + ":" + i + ", " + i2 + "]");
        return bitmapDecodeFile;
    }

    public static Bitmap getFactoryBitmap(Context context, Uri uri) {
        return getFactoryBitmap(context, uri, null);
    }
}
