package be.bstorm.tf_java2023_demospringbook.api.validation.constraint;

import be.bstorm.tf_java2023_demospringbook.api.validation.validator.CensoredValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CensoredValidator.class})
public @interface Censored {

    String message() default "contains a censored word";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String[] words() default { "mauvais", "fade", "nul" };


}
