package com.github.ManMaxMan.sender.core.api.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MessageDTO {

    private String recipient;
    private String subject;
    private String body;

}
