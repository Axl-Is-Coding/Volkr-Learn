package io.rong.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import io.rong.common.FileUtils;
import io.rong.common.RLog;
import io.rong.imlib.NativeClient;
import io.rong.imlib.model.Message;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class SightMessageHandler extends MessageHandler<SightMessage> {
    private static final String TAG = "Sight-SightMessageHandler";
    private static final int THUMB_COMPRESSED_QUALITY = 30;
    private static final String VIDEO_THUMBNAIL_PATH = "/video/thumbnail/";

    public SightMessageHandler(Context context) {
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

    @Override // io.rong.message.MessageHandler
    public void encodeMessage(Message message) throws Throwable {
        Bitmap frameAtTime;
        SightMessage sightMessage = (SightMessage) message.getContent();
        Uri uriObtainMediaFileSavedUri = NativeClient.getInstance().obtainMediaFileSavedUri();
        String str = message.getMessageId() + ".jpg";
        new BitmapFactory.Options().inJustDecodeBounds = true;
        if (sightMessage != null && FileUtils.isValidateLocalUri(sightMessage.getThumbUri())) {
            File file = new File(uriObtainMediaFileSavedUri.toString() + VIDEO_THUMBNAIL_PATH + str);
            if (file.exists()) {
                sightMessage.setThumbUri(Uri.parse("file://" + uriObtainMediaFileSavedUri.toString() + VIDEO_THUMBNAIL_PATH + str));
                byte[] bArrFile2byte = FileUtils.file2byte(file);
                if (bArrFile2byte != null) {
                    sightMessage.setBase64(Base64.encodeToString(bArrFile2byte, 2));
                    return;
                }
                return;
            }
            byte[] bArrFile2byte2 = FileUtils.file2byte(getContext(), sightMessage.getThumbUri());
            if (bArrFile2byte2 != null) {
                sightMessage.setBase64(Base64.encodeToString(bArrFile2byte2, 2));
                String str2 = uriObtainMediaFileSavedUri.toString() + VIDEO_THUMBNAIL_PATH;
                if (FileUtils.copyFileToInternal(getContext(), sightMessage.getThumbUri(), str2, str)) {
                    sightMessage.setThumbUri(Uri.parse("file://" + str2 + str));
                    return;
                }
            }
        }
        if (sightMessage != null) {
            try {
                if (sightMessage.getLocalPath() != null) {
                    String strSubstring = sightMessage.getLocalPath().toString().substring(7);
                    RLog.d(TAG, "beforeEncodeMessage Thumbnail not save yet! " + strSubstring);
                    if (FileUtils.uriStartWithFile(sightMessage.getLocalPath())) {
                        frameAtTime = ThumbnailUtils.createVideoThumbnail(strSubstring, 1);
                    } else {
                        try {
                            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                            mediaMetadataRetriever.setDataSource(getContext(), sightMessage.getLocalPath());
                            frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                        } catch (Exception e2) {
                            RLog.e(TAG, "video get thumbnail error", e2);
                            frameAtTime = null;
                        }
                    }
                    if (frameAtTime != null) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        frameAtTime.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        sightMessage.setBase64(Base64.encodeToString(byteArray, 2));
                        byteArrayOutputStream.close();
                        FileUtils.byte2File(byteArray, uriObtainMediaFileSavedUri.toString() + VIDEO_THUMBNAIL_PATH, str);
                        sightMessage.setThumbUri(Uri.parse("file://" + uriObtainMediaFileSavedUri.toString() + VIDEO_THUMBNAIL_PATH + str));
                        if (frameAtTime.isRecycled()) {
                            return;
                        }
                        frameAtTime.recycle();
                        return;
                    }
                    return;
                }
            } catch (IOException e3) {
                RLog.e(TAG, "encodeMessage beforeEncodeMessage IOException", e3);
                return;
            } catch (IllegalArgumentException e4) {
                RLog.e(TAG, "encodeMessage beforeEncodeMessage Not Base64 Content!", e4);
                return;
            } catch (Exception e5) {
                RLog.e(TAG, "encodeMessage exception", e5);
                return;
            }
        }
        RLog.d(TAG, "model or model.getLocalPath() is null ");
    }

    @Override // io.rong.message.MessageHandler
    public void decodeMessage(Message message, SightMessage sightMessage) throws Throwable {
        byte[] bArrDecode;
        Uri uriObtainMediaFileSavedUri = NativeClient.getInstance().obtainMediaFileSavedUri();
        String str = message.getMessageId() + ".jpg";
        if (message.getMessageId() == 0) {
            str = message.getSentTime() + ".jpg";
        }
        String str2 = uriObtainMediaFileSavedUri.toString() + VIDEO_THUMBNAIL_PATH;
        File file = new File(str2 + str);
        if (!TextUtils.isEmpty(sightMessage.getBase64()) && !file.exists()) {
            try {
                bArrDecode = Base64.decode(sightMessage.getBase64(), 2);
            } catch (IllegalArgumentException e2) {
                RLog.e(TAG, "decodeMessage afterDecodeMessage Not Base64 Content!", e2);
                bArrDecode = null;
            }
            if (!isImageFile(bArrDecode)) {
                RLog.e(TAG, "afterDecodeMessage Not Image File!");
                return;
            }
            FileUtils.byte2File(bArrDecode, str2, str);
        }
        sightMessage.setThumbUri(Uri.parse("file://" + str2 + str));
        sightMessage.setBase64(null);
    }
}
