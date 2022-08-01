package com.example.app.configuration.database;

import com.example.app.common.enums.DbType;
import com.example.app.common.util.AssertUtil;
import java.util.Objects;

public class DbContextHolder {
    private static final ThreadLocal<DbType> CONTEXT_HOLDER = new ThreadLocal<>();

    public DbContextHolder() {};

    public static void setDbType(DbType dbType) {
        AssertUtil.notSupport(Objects.nonNull(dbType), String.format("지원하지 않는 데이터베이스 형식입니다.(형식 : %s)", dbType));
        CONTEXT_HOLDER.set(dbType);
    }

    public static DbType getDbType() {
        return (DbType)CONTEXT_HOLDER.get();
    }

    public static void clearDbType() {
        CONTEXT_HOLDER.remove();
    }
}
