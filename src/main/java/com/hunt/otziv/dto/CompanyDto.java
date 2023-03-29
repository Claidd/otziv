package com.hunt.otziv.dto;

import com.hunt.otziv.model.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDto {

    private Long id;
    @NotEmpty(message = "Пустое поле")
    private String name;

    @Email(message = "Указана не верная почта")
    private String email;
    @NotEmpty(message = "Пустое поле")
    @Size(min = 10, max = 12)
    private String numberPhone;
    @NotEmpty(message = "Пустое поле")
    private String link;

    private Category categorys;
    @ColumnDefault("true")
    private boolean isActive;


}
