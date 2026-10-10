package io.rong.message;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import io.rong.common.FileUtils;
import io.rong.common.RLog;
import io.rong.imlib.NativeClient;
import io.rong.imlib.model.Message;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class ImageMessageHandler extends MessageHandler<ImageMessage> {
    private static final int COMPRESSED_FULL_QUALITY = 100;
    private static int COMPRESSED_QUALITY = 70;
    private static int COMPRESSED_SIZE = 1080;
    private static final String IMAGE_LOCAL_PATH = "/image/local/";
    private static final String IMAGE_THUMBNAIL_PATH = "/image/thumbnail/";
    private static final int MAX_FILE_LENGTH = 20480;
    private static int MAX_ORIGINAL_IMAGE_SIZE = 500;
    private static final String TAG = "ImageMessageHandler";
    private static final int THUMB_COMPRESSED_MIN_SIZE = 100;
    private static final int THUMB_COMPRESSED_QUALITY = 30;
    private static final int THUMB_COMPRESSED_SIZE = 240;

    public ImageMessageHandler(Context context) {
        super(context);
    }

    private static boolean isImageFile(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        return options.outWidth != -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0232 A[Catch: Exception -> 0x0327, TryCatch #2 {Exception -> 0x0327, blocks: (B:20:0x00f2, B:22:0x0101, B:24:0x0106, B:26:0x0122, B:29:0x0128, B:43:0x0151, B:45:0x015f, B:49:0x016f, B:51:0x0175, B:53:0x017a, B:55:0x0188, B:57:0x01dc, B:52:0x0178, B:58:0x01e1, B:60:0x01ef, B:62:0x0217, B:46:0x0164, B:63:0x0232, B:65:0x025f, B:67:0x0272, B:68:0x02af, B:70:0x02b5, B:34:0x0138, B:37:0x0142, B:71:0x02b9, B:73:0x02c7, B:75:0x02d4, B:76:0x02d9, B:78:0x0323), top: B:120:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x025f A[Catch: Exception -> 0x0327, TryCatch #2 {Exception -> 0x0327, blocks: (B:20:0x00f2, B:22:0x0101, B:24:0x0106, B:26:0x0122, B:29:0x0128, B:43:0x0151, B:45:0x015f, B:49:0x016f, B:51:0x0175, B:53:0x017a, B:55:0x0188, B:57:0x01dc, B:52:0x0178, B:58:0x01e1, B:60:0x01ef, B:62:0x0217, B:46:0x0164, B:63:0x0232, B:65:0x025f, B:67:0x0272, B:68:0x02af, B:70:0x02b5, B:34:0x0138, B:37:0x0142, B:71:0x02b9, B:73:0x02c7, B:75:0x02d4, B:76:0x02d9, B:78:0x0323), top: B:120:0x00f2 }] */
    @Override // io.rong.message.MessageHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void encodeMessage(io.rong.imlib.model.Message r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1166
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.message.ImageMessageHandler.encodeMessage(io.rong.imlib.model.Message):void");
    }

    @Override // io.rong.message.MessageHandler
    public void decodeMessage(Message message, ImageMessage imageMessage) throws Throwable {
        byte[] bArrDecode;
        Uri uriObtainMediaFileSavedUri = NativeClient.getInstance().obtainMediaFileSavedUri();
        String str = message.getUId() + ".jpg";
        if (TextUtils.isEmpty(message.getUId())) {
            str = message.getMessageId() + ".jpg";
        }
        String str2 = uriObtainMediaFileSavedUri.toString() + IMAGE_THUMBNAIL_PATH;
        String str3 = uriObtainMediaFileSavedUri.toString() + IMAGE_LOCAL_PATH;
        if (!FileUtils.isFileExistsWithUri(getContext(), imageMessage.getLocalUri())) {
            imageMessage.setLocalUri(null);
        } else if (imageMessage.getLocalUri() != null) {
            String string = imageMessage.getLocalUri().toString();
            if (!FileUtils.uriStartWithFile(imageMessage.getLocalUri()) && !FileUtils.uriStartWithContent(imageMessage.getLocalUri())) {
                imageMessage.setLocalUri(Uri.parse("file://" + string));
            }
        }
        File file = new File(str2 + str);
        if (!TextUtils.isEmpty(imageMessage.getBase64()) && !file.exists()) {
            try {
                bArrDecode = Base64.decode(imageMessage.getBase64(), 2);
            } catch (IllegalArgumentException e2) {
                RLog.e(TAG, "afterDecodeMessage Not Base64 Content!");
                RLog.e(TAG, "IllegalArgumentException ", e2);
                bArrDecode = null;
            }
            if (!isImageFile(bArrDecode)) {
                RLog.e(TAG, "afterDecodeMessage Not Image File!");
                return;
            }
            FileUtils.byte2File(bArrDecode, str2, str);
        }
        imageMessage.setThumUri(Uri.parse("file://" + str2 + str));
        imageMessage.setBase64(null);
    }
}
