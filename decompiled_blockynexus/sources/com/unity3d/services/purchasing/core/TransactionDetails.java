package com.unity3d.services.purchasing.core;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class TransactionDetails {
    private String currency;
    private Map<String, Object> extras;
    private BigDecimal price;
    private String productId;
    private String receipt;
    private String transactionId;

    public static final class Builder {
        private String currency;
        private Map<String, Object> extras;
        private BigDecimal price;
        private String productId;
        private String receipt;
        private String transactionId;

        public TransactionDetails build() {
            return new TransactionDetails(this);
        }

        public Builder putExtra(String str, Object obj) {
            this.extras.put(str, obj);
            return this;
        }

        public Builder withCurrency(String str) {
            this.currency = str;
            return this;
        }

        public Builder withPrice(BigDecimal bigDecimal) {
            this.price = bigDecimal;
            return this;
        }

        public Builder withProductId(String str) {
            this.productId = str;
            return this;
        }

        public Builder withReceipt(String str) {
            this.receipt = str;
            return this;
        }

        public Builder withTransactionId(String str) {
            this.transactionId = str;
            return this;
        }

        private Builder() {
            this.extras = new HashMap();
        }

        public Builder withPrice(double d2) {
            this.price = new BigDecimal(d2);
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCurrency() {
        return this.currency;
    }

    public Map<String, Object> getExtras() {
        return this.extras;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getReceipt() {
        return this.receipt;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    private TransactionDetails(Builder builder) {
        this.productId = builder.productId;
        this.transactionId = builder.transactionId;
        this.receipt = builder.receipt;
        this.extras = builder.extras;
        this.price = builder.price;
        this.currency = builder.currency;
    }
}
