package com.lsz.valueobject;

import java.util.Date;
import java.util.Objects;

/**
 * @ClassName Day
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:27
 * @Version 1.0.0
 **/
public class Day {

    private Date date;


    private Day(Date date) {
        this.date = date;
    }


    public static Day of(Date date) {
        Objects.requireNonNull(date);
        return new Day(date);
    }

    public Date getDate() {
        return date;
    }
}
