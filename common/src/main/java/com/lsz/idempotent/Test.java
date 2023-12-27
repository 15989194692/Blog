package com.lsz.idempotent;

/**
 * @ClassName Test
 * @Description TODO
 * @Author tingkai
 * @Date 2023/12/17 13:39
 * @Version 1.0
 **/
public class Test {



    public static void main(String[] args) {
        TestApplication testApplication = new TestApplicationImpl();
        boolean execute = testApplication.execute(new TestCommand());
        System.out.println("execute = " + execute);

    }
}
