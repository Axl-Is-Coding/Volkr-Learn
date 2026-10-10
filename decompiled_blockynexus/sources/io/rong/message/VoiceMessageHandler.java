package io.rong.message;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import io.rong.common.FileUtils;
import io.rong.common.RLog;
import io.rong.imlib.NativeClient;
import io.rong.imlib.model.Message;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class VoiceMessageHandler extends MessageHandler<VoiceMessage> {
    private static final String TAG = "VoiceMessageHandler";
    private static final String VOICE_PATH = "/voice/";

    public VoiceMessageHandler(Context context) {
        super(context);
    }

    private static File saveFile(byte[] bArr, String str, String str2) throws IOException {
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            RLog.e(TAG, "Created folders unSuccessfully");
        }
        File file2 = new File(str + str2);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        return file2;
    }

    @Override // io.rong.message.MessageHandler
    public void encodeMessage(Message message) {
        File fileSaveFile;
        VoiceMessage voiceMessage = (VoiceMessage) message.getContent();
        Uri uriObtainMediaFileSavedUri = NativeClient.getInstance().obtainMediaFileSavedUri();
        byte[] byteFromUri = FileUtils.getByteFromUri(voiceMessage.getUri());
        try {
            voiceMessage.setBase64(Base64.encodeToString(byteFromUri, 2));
            fileSaveFile = saveFile(byteFromUri, uriObtainMediaFileSavedUri.toString() + VOICE_PATH, message.getMessageId() + ".amr");
        } catch (IOException e2) {
            RLog.e(TAG, "IOException ", e2);
            fileSaveFile = null;
        } catch (IllegalArgumentException e3) {
            RLog.e(TAG, "beforeEncodeMessage Not Base64 Content!");
            RLog.e(TAG, "IllegalArgumentException ", e3);
            fileSaveFile = null;
        }
        if (fileSaveFile == null || !fileSaveFile.exists()) {
            return;
        }
        voiceMessage.setUri(Uri.fromFile(fileSaveFile));
    }

    @Override // io.rong.message.MessageHandler
    public void decodeMessage(Message message, VoiceMessage voiceMessage) {
        Uri uriObtainMediaFileSavedUri = NativeClient.getInstance().obtainMediaFileSavedUri();
        String str = message.getMessageId() + ".amr";
        if (message.getMessageId() == 0) {
            str = message.getSentTime() + ".amr";
        }
        File file = new File(uriObtainMediaFileSavedUri.toString() + VOICE_PATH + str);
        if (!TextUtils.isEmpty(voiceMessage.getBase64()) && !file.exists()) {
            try {
                file = saveFile(Base64.decode(voiceMessage.getBase64(), 2), uriObtainMediaFileSavedUri.toString() + VOICE_PATH, str);
            } catch (IOException e2) {
                RLog.e(TAG, "IOException ", e2);
            } catch (IllegalArgumentException e3) {
                RLog.e(TAG, "afterDecodeMessage Not Base64 Content!");
                RLog.e(TAG, "IllegalArgumentException ", e3);
            }
        }
        voiceMessage.setUri(Uri.fromFile(file));
        voiceMessage.setBase64(null);
    }
}
