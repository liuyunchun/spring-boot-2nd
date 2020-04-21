package com.yunchun.domain;

public enum Type {
    ARTICLE("文章"),COMMENT("留言");

    private String value;

    private Type(String value) {
        this.value = value;
    }
}
