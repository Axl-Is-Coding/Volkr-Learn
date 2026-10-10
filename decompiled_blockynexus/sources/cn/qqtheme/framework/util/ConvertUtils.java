package cn.qqtheme.framework.util;

import android.R;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.center.config.StringConstant;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.rong.common.LibStorageUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ConvertUtils {
    public static final long GB = 1073741824;
    public static final long KB = 1024;
    public static final long MB = 1048576;

    private static String _queryPathFromMediaStore(Context context, Uri uri, String str, String[] strArr) {
        String string = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursorQuery == null) {
                return null;
            }
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
            cursorQuery.moveToFirst();
            string = cursorQuery.getString(columnIndexOrThrow);
            cursorQuery.close();
            return string;
        } catch (IllegalArgumentException e2) {
            LogUtils.error(e2);
            return string;
        }
    }

    public static <T> T[] toArray(List<T> list) {
        return (T[]) list.toArray();
    }

    public static String toBinaryString(byte... bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 8];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] < 0 ? bArr[i2] + 256 : bArr[i2];
            int i4 = i + 1;
            cArr2[i] = cArr[(i3 >>> 7) & 1];
            int i5 = i4 + 1;
            cArr2[i4] = cArr[(i3 >>> 6) & 1];
            int i6 = i5 + 1;
            cArr2[i5] = cArr[(i3 >>> 5) & 1];
            int i7 = i6 + 1;
            cArr2[i6] = cArr[(i3 >>> 4) & 1];
            int i8 = i7 + 1;
            cArr2[i7] = cArr[(i3 >>> 3) & 1];
            int i9 = i8 + 1;
            cArr2[i8] = cArr[(i3 >>> 2) & 1];
            int i10 = i9 + 1;
            cArr2[i9] = cArr[(i3 >>> 1) & 1];
            i = i10 + 1;
            cArr2[i10] = cArr[i3 & 1];
        }
        return new String(cArr2);
    }

    public static Bitmap toBitmap(byte[] bArr, int i, int i2) {
        Bitmap bitmapDecodeByteArray = null;
        if (bArr.length == 0) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDither = false;
            options.inPreferredConfig = null;
            if (i > 0 && i2 > 0) {
                options.outWidth = i;
                options.outHeight = i2;
            }
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            bitmapDecodeByteArray.setDensity(96);
            return bitmapDecodeByteArray;
        } catch (Exception e2) {
            LogUtils.error(e2);
            return bitmapDecodeByteArray;
        }
    }

    public static byte[] toByteArray(int i) {
        return ByteBuffer.allocate(4).putInt(i).array();
    }

    public static ColorStateList toColorStateList(int i, int i2, int i3, int i4) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_enabled}, new int[]{R.attr.state_enabled, R.attr.state_focused}, new int[]{R.attr.state_enabled}, new int[]{R.attr.state_focused}, new int[]{R.attr.state_window_focused}, new int[0]}, new int[]{i2, i3, i, i3, i4, i});
    }

    public static String toColorString(int i) {
        return toColorString(i, false);
    }

    public static int toDarkenColor(int i) {
        return toDarkenColor(i, 0.8f);
    }

    public static int toDp(Context context, float f2) {
        int i = (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
        LogUtils.verbose(f2 + " px == " + i + " dp");
        return i;
    }

    public static Drawable toDrawable(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDrawable(Resources.getSystem(), bitmap);
    }

    public static String toFileSizeString(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j < 1024) {
            return j + "B";
        }
        if (j < 1048576) {
            StringBuilder sb = new StringBuilder();
            double d2 = j;
            Double.isNaN(d2);
            sb.append(decimalFormat.format(d2 / 1024.0d));
            sb.append("K");
            return sb.toString();
        }
        if (j < GB) {
            StringBuilder sb2 = new StringBuilder();
            double d3 = j;
            Double.isNaN(d3);
            sb2.append(decimalFormat.format(d3 / 1048576.0d));
            sb2.append("M");
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        double d4 = j;
        Double.isNaN(d4);
        sb3.append(decimalFormat.format(d4 / 1.073741824E9d));
        sb3.append("G");
        return sb3.toString();
    }

    public static float toFloat(Object obj) {
        try {
            return Float.parseFloat(obj.toString());
        } catch (NumberFormatException unused) {
            return -1.0f;
        }
    }

    public static String toGbk(String str) {
        try {
            return new String(str.getBytes("utf-8"), "gbk");
        } catch (UnsupportedEncodingException e2) {
            LogUtils.warn(e2);
            return str;
        }
    }

    public static String toHexString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : str.getBytes()) {
            sb.append(Integer.toHexString(b2 & 255));
            sb.append(" ");
        }
        return sb.toString();
    }

    public static int toInt(Object obj) {
        try {
            return Integer.parseInt(obj.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static <T> List<T> toList(T[] tArr) {
        return Arrays.asList(tArr);
    }

    public static long toLong(Object obj) {
        try {
            return Long.parseLong(obj.toString());
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    @TargetApi(19)
    public static String toPath(Context context, Uri uri) {
        if (uri == null) {
            LogUtils.verbose("uri is null");
            return "";
        }
        LogUtils.verbose("uri: " + uri.toString());
        String path = uri.getPath();
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            String[] strArrSplit = documentId.split(":");
            String str = strArrSplit[0];
            byte b2 = -1;
            int iHashCode = authority.hashCode();
            if (iHashCode != 320699453) {
                if (iHashCode != 596745902) {
                    if (iHashCode == 1734583286 && authority.equals("com.android.providers.media.documents")) {
                        b2 = 2;
                    }
                } else if (authority.equals("com.android.externalstorage.documents")) {
                    b2 = 0;
                }
            } else if (authority.equals("com.android.providers.downloads.documents")) {
                b2 = 1;
            }
            if (b2 != 0) {
                if (b2 == 1) {
                    return _queryPathFromMediaStore(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                }
                if (b2 == 2) {
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if (LibStorageUtils.AUDIO.equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return _queryPathFromMediaStore(context, uri2, "_id=?", new String[]{strArrSplit[1]});
                }
            } else if (StringConstant.PRIMARY.equalsIgnoreCase(str)) {
                return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
            }
        } else {
            if ("content".equalsIgnoreCase(scheme)) {
                return authority.equals("com.google.android.apps.photos.content") ? uri.getLastPathSegment() : _queryPathFromMediaStore(context, uri, null, null);
            }
            if (LibStorageUtils.FILE.equalsIgnoreCase(scheme)) {
                return uri.getPath();
            }
        }
        LogUtils.verbose("uri to path: " + path);
        return path;
    }

    public static int toPx(Context context, float f2) {
        int i = (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
        LogUtils.verbose(f2 + " dp == " + i + " px");
        return i;
    }

    public static int toShort(byte b2, byte b3) {
        return (b2 << 8) + (b3 & 255);
    }

    public static String toSlashString(String str) {
        String str2 = "";
        for (char c2 : str.toCharArray()) {
            if (c2 == '\"' || c2 == '\'' || c2 == '\\') {
                str2 = str2 + "\\";
            }
            str2 = str2 + c2;
        }
        return str2;
    }

    public static int toSp(Context context, float f2) {
        int i = (int) ((f2 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
        LogUtils.verbose(f2 + " px == " + i + " sp");
        return i;
    }

    public static String toString(Object[] objArr) {
        return Arrays.deepToString(objArr);
    }

    public static byte[] toByteArray(String str, boolean z) {
        if (str == null || str.equals("")) {
            return null;
        }
        if (!z) {
            return str.getBytes();
        }
        String strReplaceAll = str.replaceAll("\\s+", "");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(strReplaceAll.length() / 2);
        for (int i = 0; i < strReplaceAll.length(); i += 2) {
            byteArrayOutputStream.write(("0123456789ABCDEF".indexOf(strReplaceAll.charAt(i)) << 4) | "0123456789ABCDEF".indexOf(strReplaceAll.charAt(i + 1)));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            LogUtils.warn(e2);
        }
        return byteArray;
    }

    public static String toColorString(int i, boolean z) {
        String hexString = Integer.toHexString(Color.alpha(i));
        String hexString2 = Integer.toHexString(Color.red(i));
        String hexString3 = Integer.toHexString(Color.green(i));
        String hexString4 = Integer.toHexString(Color.blue(i));
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        if (hexString2.length() == 1) {
            hexString2 = "0" + hexString2;
        }
        if (hexString3.length() == 1) {
            hexString3 = "0" + hexString3;
        }
        if (hexString4.length() == 1) {
            hexString4 = "0" + hexString4;
        }
        if (!z) {
            String str = hexString2 + hexString3 + hexString4;
            LogUtils.verbose(String.format(Locale.CHINA, "%d to color string is %s%s%s%s, exclude alpha is %s", Integer.valueOf(i), hexString, hexString2, hexString3, hexString4, str));
            return str;
        }
        String str2 = hexString + hexString2 + hexString3 + hexString4;
        LogUtils.verbose(String.format(Locale.CHINA, "%d to color string is %s", Integer.valueOf(i), str2));
        return str2;
    }

    public static int toDarkenColor(int i, float f2) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = fArr[2] * f2;
        return Color.HSVToColor(fArr);
    }

    public static Drawable toDrawable(byte[] bArr) {
        return toDrawable(toBitmap(bArr));
    }

    public static int toInt(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i += (bArr[i2] & 255) << (i2 * 8);
        }
        return i;
    }

    public static String toString(Object[] objArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
            sb.append(str);
        }
        return sb.toString();
    }

    public static String toString(InputStream inputStream, String str) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str));
        } catch (IOException e2) {
            LogUtils.error(e2);
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            return sb.toString();
        }
        bufferedReader.close();
        inputStream.close();
        return sb.toString();
    }

    public static String toHexString(byte... bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] < 0 ? bArr[i2] + 256 : bArr[i2];
            int i4 = i + 1;
            cArr2[i] = cArr[i3 >>> 4];
            i = i4 + 1;
            cArr2[i4] = cArr[i3 & 15];
        }
        return new String(cArr2);
    }

    public static Bitmap toBitmap(byte[] bArr) {
        return toBitmap(bArr, -1, -1);
    }

    public static ColorStateList toColorStateList(int i, int i2) {
        return toColorStateList(i, i2, i2, i);
    }

    public static Bitmap toBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof ColorDrawable) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(32, 32, Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap).drawColor(((ColorDrawable) drawable).getColor());
            return bitmapCreateBitmap;
        }
        if (!(drawable instanceof NinePatchDrawable)) {
            return null;
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap2;
    }

    public static String toBinaryString(int i) {
        String binaryString = Integer.toBinaryString(i);
        LogUtils.verbose(String.format(Locale.CHINA, "%d to binary string is %s", Integer.valueOf(i), binaryString));
        return binaryString;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[100];
            while (true) {
                int i = inputStream.read(bArr, 0, 100);
                if (i == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e2) {
            LogUtils.warn(e2);
            return null;
        }
    }

    public static String toHexString(int i) {
        String hexString = Integer.toHexString(i);
        LogUtils.verbose(String.format(Locale.CHINA, "%d to hex string is %s", Integer.valueOf(i), hexString));
        return hexString;
    }

    public static String toString(InputStream inputStream) {
        return toString(inputStream, "utf-8");
    }

    public static byte[] toByteArray(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            LogUtils.warn(e2);
        }
        return byteArray;
    }

    public static Bitmap toBitmap(View view) {
        int height;
        int width = view.getWidth();
        int height2 = view.getHeight();
        if (view instanceof ListView) {
            ListView listView = (ListView) view;
            height = 0;
            for (int i = 0; i < listView.getChildCount(); i++) {
                height += listView.getChildAt(i).getHeight();
            }
        } else if (view instanceof ScrollView) {
            ScrollView scrollView = (ScrollView) view;
            height = 0;
            for (int i2 = 0; i2 < scrollView.getChildCount(); i2++) {
                height += scrollView.getChildAt(i2).getHeight();
            }
        } else {
            height = height2;
        }
        view.setDrawingCacheEnabled(true);
        view.clearFocus();
        view.setPressed(false);
        boolean zWillNotCacheDrawing = view.willNotCacheDrawing();
        view.setWillNotCacheDrawing(false);
        int drawingCacheBackgroundColor = view.getDrawingCacheBackgroundColor();
        view.setDrawingCacheBackgroundColor(-1);
        if (drawingCacheBackgroundColor != -1) {
            view.destroyDrawingCache();
        }
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(drawingCache, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, (Paint) null);
        canvas.save(31);
        canvas.restore();
        if (!bitmapCreateBitmap.isRecycled()) {
            LogUtils.verbose("recycle bitmap: " + bitmapCreateBitmap.toString());
            bitmapCreateBitmap.recycle();
        }
        view.destroyDrawingCache();
        view.setWillNotCacheDrawing(zWillNotCacheDrawing);
        view.setDrawingCacheBackgroundColor(drawingCacheBackgroundColor);
        return bitmapCreateBitmap;
    }

    public static byte[] toByteArray(Drawable drawable) {
        return toByteArray(toBitmap(drawable));
    }
}
