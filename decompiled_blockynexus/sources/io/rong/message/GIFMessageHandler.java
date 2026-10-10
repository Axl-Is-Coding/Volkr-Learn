package io.rong.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import io.rong.common.FileInfo;
import io.rong.common.FileUtils;
import io.rong.common.RLog;
import io.rong.imlib.NativeClient;
import io.rong.imlib.model.Message;
import io.rong.message.utils.BitmapUtil;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class GIFMessageHandler extends MessageHandler<GIFMessage> {
    private static final String IMAGE_LOCAL_PATH = "/image/local/";
    private static final String TAG = "GIFMessageHandler";

    public GIFMessageHandler(Context context) {
        super(context);
    }

    @Override // io.rong.message.MessageHandler
    public void decodeMessage(Message message, GIFMessage gIFMessage) {
    }

    @Override // io.rong.message.MessageHandler
    public void encodeMessage(Message message) {
        GIFMessage gIFMessage = (GIFMessage) message.getContent();
        Uri uriObtainMediaFileSavedUri = NativeClient.getInstance().obtainMediaFileSavedUri();
        String str = message.getMessageId() + ".gif";
        if (gIFMessage == null || !FileUtils.isValidateLocalUri(gIFMessage.getLocalUri())) {
            return;
        }
        if (new File(uriObtainMediaFileSavedUri.toString() + IMAGE_LOCAL_PATH + str).exists()) {
            gIFMessage.setLocalUri(Uri.parse("file://" + uriObtainMediaFileSavedUri.toString() + IMAGE_LOCAL_PATH + str));
        } else {
            if (FileUtils.copyFileToInternal(getContext(), gIFMessage.getLocalUri(), uriObtainMediaFileSavedUri.toString() + IMAGE_LOCAL_PATH, str)) {
                gIFMessage.setLocalUri(Uri.parse("file://" + uriObtainMediaFileSavedUri.toString() + IMAGE_LOCAL_PATH + str));
            }
        }
        Bitmap factoryBitmap = BitmapUtil.getFactoryBitmap(getContext(), gIFMessage.getLocalUri());
        if (factoryBitmap != null) {
            int width = factoryBitmap.getWidth();
            int height = factoryBitmap.getHeight();
            gIFMessage.setWidth(width);
            gIFMessage.setHeight(height);
            FileInfo fileInfoByUri = FileUtils.getFileInfoByUri(getContext(), gIFMessage.getLocalUri());
            if (fileInfoByUri == null) {
                RLog.e(TAG, "Document is null");
            } else {
                gIFMessage.setGifDataSize(fileInfoByUri.getSize());
                gIFMessage.setName(fileInfoByUri.getName());
            }
        }
    }
}
