package io.rong.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import io.rong.common.FileUtils;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;
import io.rong.imlib.NativeClient;
import io.rong.imlib.model.Message;
import io.rong.message.utils.BitmapUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class LocationMessageHandler extends MessageHandler<LocationMessage> {
    private static final String TAG = "LocationMessageHandler";
    private static final int THUMB_COMPRESSED_QUALITY = 30;
    private static final int THUMB_HEIGHT = 240;
    private static final int THUMB_WIDTH = 408;

    public LocationMessageHandler(Context context) {
        super(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File loadLocationThumbnail(io.rong.message.LocationMessage r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.message.LocationMessageHandler.loadLocationThumbnail(io.rong.message.LocationMessage, java.lang.String):java.io.File");
    }

    @Override // io.rong.message.MessageHandler
    public void encodeMessage(Message message) throws Throwable {
        String path;
        LocationMessage locationMessage = (LocationMessage) message.getContent();
        if (locationMessage.getImgUri() == null) {
            RLog.w(TAG, "No thumbnail uri.");
            IHandleMessageListener iHandleMessageListener = this.mHandleMessageListener;
            if (iHandleMessageListener != null) {
                iHandleMessageListener.onHandleResult(message, 0);
                return;
            }
            return;
        }
        Uri uriObtainMediaFileSavedUri = NativeClient.getInstance().obtainMediaFileSavedUri();
        String scheme = locationMessage.getImgUri().getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.toLowerCase().equals(LibStorageUtils.FILE)) {
            File fileLoadLocationThumbnail = loadLocationThumbnail(locationMessage, message.getSentTime() + "");
            path = fileLoadLocationThumbnail != null ? fileLoadLocationThumbnail.getPath() : null;
        } else {
            path = locationMessage.getImgUri().getPath();
        }
        if (path == null) {
            RLog.e(TAG, "load thumbnailPath null!");
            IHandleMessageListener iHandleMessageListener2 = this.mHandleMessageListener;
            if (iHandleMessageListener2 != null) {
                iHandleMessageListener2.onHandleResult(message, -1);
                return;
            }
            return;
        }
        try {
            Bitmap bitmapInterceptBitmap = BitmapUtil.interceptBitmap(path, 408, 240);
            if (bitmapInterceptBitmap == null) {
                RLog.e(TAG, "get null bitmap!");
                if (this.mHandleMessageListener != null) {
                    this.mHandleMessageListener.onHandleResult(message, -1);
                    return;
                }
                return;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapInterceptBitmap.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            locationMessage.setBase64(Base64.encodeToString(byteArray, 2));
            File fileByte2File = FileUtils.byte2File(byteArray, uriObtainMediaFileSavedUri.toString(), message.getMessageId() + "");
            if (fileByte2File != null && fileByte2File.exists()) {
                locationMessage.setImgUri(Uri.fromFile(fileByte2File));
            }
            if (!bitmapInterceptBitmap.isRecycled()) {
                bitmapInterceptBitmap.recycle();
            }
            if (this.mHandleMessageListener != null) {
                this.mHandleMessageListener.onHandleResult(message, 0);
            }
        } catch (Exception e2) {
            RLog.e(TAG, "Not Base64 Content!");
            RLog.e(TAG, "Exception ", e2);
            IHandleMessageListener iHandleMessageListener3 = this.mHandleMessageListener;
            if (iHandleMessageListener3 != null) {
                iHandleMessageListener3.onHandleResult(message, -1);
            }
        }
    }

    @Override // io.rong.message.MessageHandler
    public void decodeMessage(Message message, LocationMessage locationMessage) throws Throwable {
        String str = message.getMessageId() + "";
        if (message.getMessageId() == 0) {
            str = message.getSentTime() + "";
        }
        Uri uriObtainMediaFileSavedUri = NativeClient.getInstance().obtainMediaFileSavedUri();
        File file = new File(uriObtainMediaFileSavedUri.toString() + str);
        if (file.exists()) {
            locationMessage.setImgUri(Uri.fromFile(file));
            return;
        }
        if (locationMessage != null) {
            String base64 = locationMessage.getBase64();
            if (TextUtils.isEmpty(base64)) {
                return;
            }
            if (base64.startsWith("http")) {
                locationMessage.setImgUri(Uri.parse(base64));
                locationMessage.setBase64(null);
                return;
            }
            try {
                File fileByte2File = FileUtils.byte2File(Base64.decode(locationMessage.getBase64(), 2), uriObtainMediaFileSavedUri.toString(), str + "");
                if (locationMessage.getImgUri() == null) {
                    if (fileByte2File == null || !fileByte2File.exists()) {
                        RLog.e(TAG, "getImgUri is null");
                    } else {
                        locationMessage.setImgUri(Uri.fromFile(fileByte2File));
                    }
                }
            } catch (IllegalArgumentException e2) {
                RLog.e(TAG, "Not Base64 Content!");
                RLog.e(TAG, "IllegalArgumentException", e2);
            }
            message.setContent(locationMessage);
            locationMessage.setBase64(null);
        }
    }
}
