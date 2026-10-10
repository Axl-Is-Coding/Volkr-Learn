package io.rong.imlib.filetransfer.upload;

/* JADX INFO: loaded from: classes5.dex */
public class MediaUploadAuthorInfo {
    private String alternative;
    private String bucketName;
    private String date;
    private String ossAccessKeyId;
    private String path;
    private String policy;
    private String signature;
    private String token;

    public static class Builder {
        private String alternative;
        private String bucketName;
        private String date;
        private String ossAccessKeyId;
        private String ossPolicy;
        private String ossSignature;
        private String path;
        private String token;

        public Builder alternative(String str) {
            this.alternative = str;
            return this;
        }

        public Builder bucket(String str) {
            this.bucketName = str;
            return this;
        }

        public MediaUploadAuthorInfo build() {
            return new MediaUploadAuthorInfo(this);
        }

        public Builder date(String str) {
            this.date = str;
            return this;
        }

        public Builder ossAccessKeyId(String str) {
            this.ossAccessKeyId = str;
            return this;
        }

        public Builder ossPolicy(String str) {
            this.ossPolicy = str;
            return this;
        }

        public Builder ossSignature(String str) {
            this.ossSignature = str;
            return this;
        }

        public Builder path(String str) {
            this.path = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }
    }

    public MediaUploadAuthorInfo(Builder builder) {
        this.token = builder.token;
        this.alternative = builder.alternative;
        this.date = builder.date;
        this.path = builder.path;
        this.bucketName = builder.bucketName;
        this.ossAccessKeyId = builder.ossAccessKeyId;
        this.policy = builder.ossPolicy;
        this.signature = builder.ossSignature;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getAlternative() {
        return this.alternative;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getDate() {
        return this.date;
    }

    public String getOssAccessKeyId() {
        return this.ossAccessKeyId;
    }

    public String getPath() {
        return this.path;
    }

    public String getPolicy() {
        return this.policy;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getToken() {
        return this.token;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setOssAccessKeyId(String str) {
        this.ossAccessKeyId = str;
    }

    public void setPolicy(String str) {
        this.policy = str;
    }

    public void setSignature(String str) {
        this.signature = str;
    }
}
