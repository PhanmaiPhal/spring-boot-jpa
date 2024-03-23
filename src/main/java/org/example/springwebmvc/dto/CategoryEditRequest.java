package org.example.springwebmvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryEditRequest(
        @NotBlank
        @Size(max=40)
        String name,
        String description
) {
}
