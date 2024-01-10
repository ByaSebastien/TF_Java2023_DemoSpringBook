package be.bstorm.tf_java2023_demospringbook.api.validation.constraint;

import be.bstorm.tf_java2023_demospringbook.api.validation.validator.PasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordValidator.class})
public @interface Password {

    String message() default "password must be strong(1 uppercase, 1 lowercase, 1 number, 1 special char)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


    int minSize() default 6;

}
