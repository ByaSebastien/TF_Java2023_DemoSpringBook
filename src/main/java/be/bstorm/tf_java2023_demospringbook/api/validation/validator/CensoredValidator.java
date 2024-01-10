package be.bstorm.tf_java2023_demospringbook.api.validation.validator;

import be.bstorm.tf_java2023_demospringbook.api.validation.constraint.Censored;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class CensoredValidator implements ConstraintValidator<Censored, String> {

    private String[] censoredWords;

    @Override
    public void initialize(Censored constraintAnnotation) {
        this.censoredWords = constraintAnnotation.words();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Arrays.stream(censoredWords)
                .noneMatch(value::contains);
    }
}
