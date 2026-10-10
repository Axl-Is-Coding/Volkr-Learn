package com.sandboxol.blockmango;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.sandboxol.common.base.app.BaseApplication;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
public class ShotScreenUtils {
    public static GL10 gl;
    private static int height;
    private static int width;

    public static Bitmap albumUrl2Bitmap(String str) {
        try {
            return MediaStore.Images.Media.getBitmap(BaseApplication.getContext().getContentResolver(), Uri.parse(str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bitmap filePath2Bitmap(String str) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStream);
            bufferedInputStream.close();
            return bitmapDecodeStream;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bitmap getShotScreenBitmap(GL10 gl10, int i, int i2) {
        gl = gl10;
        width = i;
        height = i2;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(width * height * 4);
        gl.glReadPixels(0, 0, width, height, 6408, 5121, byteBufferAllocateDirect);
        int i3 = width;
        byte[] bArr = new byte[i3 * 4];
        byte[] bArr2 = new byte[i3 * 4];
        int i4 = height / 2;
        for (int i5 = 0; i5 < i4; i5++) {
            byteBufferAllocateDirect.position(width * i5 * 4);
            byteBufferAllocateDirect.get(bArr, 0, bArr.length);
            byteBufferAllocateDirect.position(((height - 1) - i5) * width * 4);
            byteBufferAllocateDirect.get(bArr2, 0, bArr2.length);
            byteBufferAllocateDirect.position(((height - 1) - i5) * width * 4);
            byteBufferAllocateDirect.put(bArr);
            byteBufferAllocateDirect.position(width * i5 * 4);
            byteBufferAllocateDirect.put(bArr2);
        }
        byteBufferAllocateDirect.position(0);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferAllocateDirect);
        System.gc();
        return bitmapCreateBitmap;
    }

    public static Bitmap res2bitmap(String str) {
        return str.contains("http") ? webUrl2Bitmap(str) : str.contains("content") ? albumUrl2Bitmap(str) : filePath2Bitmap(str);
    }

    public static void setGl(GL10 gl10) {
        gl = gl10;
    }

    public static void setHeight(int i) {
        height = i;
    }

    public static void setWidth(int i) {
        width = i;
    }

    public static Bitmap webUrl2Bitmap(String str) {
        try {
            URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
            int contentLength = ((HttpURLConnection) uRLConnectionOpenConnection).getContentLength();
            uRLConnectionOpenConnection.connect();
            InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, contentLength);
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStream);
            bufferedInputStream.close();
            inputStream.close();
            return bitmapDecodeStream;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
