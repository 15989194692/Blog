package com.lsz.idempotent.template;

/**
 * @ClassName LockContext
 * @Description TODO
 * @Author tingkai
 * @Date 2023/12/13 11:15
 * @Version 1.0
 **/
public class IdempotentContext {

    private static final Integer DEFAULT_EXPIRE_SECONDS = 60 * 5;

    private final Boolean useIdempotentCheck;

    private final String idempotentKey;

    private final String userId;

    private final String siteId;

    private final String lockKey;

    private final String lockValue;

    private final Integer expireSeconds;

    private final Boolean useLock;


    private IdempotentContext(Boolean useIdempotentCheck, String idempotentKey, String userId, String siteId, String lockKey, String lockValue, Integer expireSeconds, Boolean useLock) {
        this.useIdempotentCheck = useIdempotentCheck;
        this.idempotentKey = idempotentKey;
        this.userId = userId;
        this.siteId = siteId;
        this.lockKey = lockKey;
        this.lockValue = lockValue;
        this.expireSeconds = expireSeconds;
        this.useLock = useLock;
    }

    public String getLockKey() {
        return lockKey;
    }

    public String getLockValue() {
        return lockValue;
    }

    public Integer getExpireSeconds() {
        return expireSeconds;
    }

    public Boolean isUseLock() {
        return useLock;
    }

    public String getIdempotentKey() {
        return idempotentKey;
    }

    public String getUserId() {
        return userId;
    }

    public String getSiteId() {
        return siteId;
    }

    public Boolean isUseIdempotentCheck() {
        return useIdempotentCheck;
    }

    public static class Builder {

        private Boolean useIdempotentCheck = true;

        private String idempotentKey;

        private String userId;

        private String siteId;

        private String lockKey;

        private String lockValue;

        private Integer expireSeconds = DEFAULT_EXPIRE_SECONDS;

        private Boolean useLock = true;

        public Builder idempotentKey(String idempotentKey) {
            this.idempotentKey = idempotentKey;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder siteId(String siteId) {
            this.siteId = siteId;
            return this;
        }

        public Builder lockKey(String lockKey) {
            this.lockKey = lockKey;
            return this;
        }

        public Builder lockValue(String lockValue) {
            this.lockValue = lockValue;
            return this;
        }

        public Builder expireSeconds(Integer expireSeconds) {
            this.expireSeconds = expireSeconds;
            return this;
        }

        public Builder useLock(Boolean useLock) {
            this.useLock = useLock;
            return this;
        }

        public Builder useIdempotentCheck(Boolean useIdempotentCheck) {
            this.useIdempotentCheck = useIdempotentCheck;
            return this;
        }

        public IdempotentContext build() {
            check();
            return new IdempotentContext(useIdempotentCheck, idempotentKey, userId, siteId, lockKey, lockValue, expireSeconds, useLock);
        }

        private void check() {
        }

    }
}
