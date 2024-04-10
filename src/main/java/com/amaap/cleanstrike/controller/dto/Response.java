package com.amaap.cleanstrike.controller.dto;

import com.amaap.cleanstrike.Http;

import java.util.Objects;

public class  Response {
    private  final Http httpStatus;
    public Response(Http httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Response response)) return false;
        return httpStatus == response.httpStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(httpStatus);
    }
}
