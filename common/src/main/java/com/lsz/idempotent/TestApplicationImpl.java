package com.lsz.idempotent;


import org.springframework.validation.annotation.Validated;

/**
 * @ClassName TestApplicationImpl
 * @Description TODO
 * @Author tingkai
 * @Date 2023/12/17 13:42
 * @Version 1.0
 **/
public class TestApplicationImpl implements TestApplication {

    @Override
    public boolean execute(@Validated TestCommand command) {

        return false;
    }
}
