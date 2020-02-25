package com.artemmensk.next4free.adapter.rest.collectingprocess;

import com.artemmensk.next4free.domain.Stamp;

public class StampMapper {
    public StampDto map(Stamp stamp) {
        return StampDto.builder()
                .stampId(stamp.getStampId().getValue())
                .createdOn(stamp.getCreatedOn())
                .build();
    }
}
