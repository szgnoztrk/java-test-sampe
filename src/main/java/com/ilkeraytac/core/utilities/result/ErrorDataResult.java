package com.ilkeraytac.core.utilities.result;

public class ErrorDataResult<T> extends DataResult<T> {

    public ErrorDataResult(String message) {
        super(null, false, message);
    }

    public ErrorDataResult() {
        super(null, false);
    }

    public ErrorDataResult(T data, String message) {
        super(data, false, message);
    }
}
