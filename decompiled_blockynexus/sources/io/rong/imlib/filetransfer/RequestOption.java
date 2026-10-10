package io.rong.imlib.filetransfer;

import android.net.Uri;
import io.rong.imlib.filetransfer.FtConst;
import io.rong.imlib.filetransfer.upload.MediaUploadAuthorInfo;

/* JADX INFO: loaded from: classes5.dex */
public class RequestOption {
    private String fileName;
    private int messageId;
    private FtConst.MimeType mimeType;
    private RequestCallBack requestCallBack;
    private String serverIp;

    public static class Upload extends RequestOption {
        public MediaUploadAuthorInfo authorInfo;
        private int end;
        public Uri fileUri;
        private int start;

        public static final class Builder {
            private MediaUploadAuthorInfo authorInfo;
            private Uri fileUri;
            private String key;
            private int messageId;
            private FtConst.MimeType mimeType;
            private RequestCallBack requestCallback;
            private String url;

            public Upload build() {
                return new Upload(this);
            }

            public Builder requestCallback(RequestCallBack requestCallBack) {
                this.requestCallback = requestCallBack;
                return this;
            }

            private Builder(Uri uri, String str, FtConst.MimeType mimeType, int i, MediaUploadAuthorInfo mediaUploadAuthorInfo, String str2) {
                this.fileUri = uri;
                this.key = str;
                this.mimeType = mimeType;
                this.authorInfo = mediaUploadAuthorInfo;
                this.messageId = i;
                this.url = str2;
            }
        }

        public Upload(Builder builder) {
            super(builder.key, builder.mimeType, builder.url, builder.messageId, builder.requestCallback);
            this.fileUri = builder.fileUri;
            this.authorInfo = builder.authorInfo;
        }

        public static Builder newBuilder(Uri uri, String str, FtConst.MimeType mimeType, int i, MediaUploadAuthorInfo mediaUploadAuthorInfo, String str2) {
            return new Builder(uri, str, mimeType, i, mediaUploadAuthorInfo, str2);
        }

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }
    }

    public RequestOption(String str, FtConst.MimeType mimeType, RequestCallBack requestCallBack) {
        this.fileName = str;
        this.mimeType = mimeType;
        this.requestCallBack = requestCallBack;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getMessageId() {
        return this.messageId;
    }

    public FtConst.MimeType getMimeType() {
        return this.mimeType;
    }

    public RequestCallBack getRequestCallBack() {
        return this.requestCallBack;
    }

    public String getServerIp() {
        return this.serverIp;
    }

    public RequestOption(String str, FtConst.MimeType mimeType, int i, RequestCallBack requestCallBack) {
        this.fileName = str;
        this.mimeType = mimeType;
        this.requestCallBack = requestCallBack;
        this.messageId = i;
    }

    public RequestOption(String str, FtConst.MimeType mimeType, String str2, RequestCallBack requestCallBack) {
        this.fileName = str;
        this.mimeType = mimeType;
        this.serverIp = str2;
        this.requestCallBack = requestCallBack;
    }

    public RequestOption(String str, FtConst.MimeType mimeType, String str2, int i, RequestCallBack requestCallBack) {
        this.fileName = str;
        this.mimeType = mimeType;
        this.serverIp = str2;
        this.messageId = i;
        this.requestCallBack = requestCallBack;
    }
}
