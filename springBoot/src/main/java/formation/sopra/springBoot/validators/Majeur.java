package formation.sopra.springBoot.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MajeurValidator.class)
public @interface Majeur {
	String message() default "il faut etre majeur";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
