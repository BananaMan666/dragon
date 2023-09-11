package com.dragon.banana.base.response;

import lombok.Getter;

@Getter
public class ResultPair<T> {
    private boolean ok;
    private T result;

    public static <T> ResultPair<T> of(boolean ok, T result) {
        ResultPair<T> resultPair = new ResultPair<>();
        resultPair.ok = ok;
        resultPair.result = result;
        return resultPair;
    }
}
