package com.myform.test.dto;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Accessors(chain = true)
public class FormDtoRequest {

    @NotNull
    @NotEmpty(message = "{username.notempty}")
    @Size(min = 5, max = 30, message = "{username.size}")
    private String username;

    @NotNull(message = "{agreement.notempty}")
    private Boolean agreement;

    @NotNull
    @NotEmpty(message = "{sectorsId.notempty}")
    private Set<Integer> sectorsId;

}
