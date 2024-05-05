package com.github.ManMaxMan.sender.service.api;

public interface IConverter<FROM, TO> {
    TO convert(FROM item);
}
