package eshop.validators;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MajeurValidator implements ConstraintValidator<Majeur, LocalDate> {

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		long annee = ChronoUnit.YEARS.between(value, LocalDate.now());
		return (annee > 18);
	}

}
