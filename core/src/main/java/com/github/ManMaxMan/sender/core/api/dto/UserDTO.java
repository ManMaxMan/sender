package com.github.ManMaxMan.sender.core.api.dto;

import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserDTO {
    private String login;
    private String password;
    private LocalDateTime birthday;
    private String fio;
}
