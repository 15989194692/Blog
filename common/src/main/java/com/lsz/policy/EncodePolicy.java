package com.lsz.policy;

/**
 * @ClassName EncodePolicy
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:50
 * @Version 1.0.0
 **/
public interface EncodePolicy<L, R> {

    L decode(R r);

    R encode(L l);
}
