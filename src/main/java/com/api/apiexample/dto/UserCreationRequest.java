package com.api.apiexample.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationRequest {
    private String name;
}
