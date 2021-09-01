package eshop.validators;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MajeurValidator implements ConstraintValidator<Majeur, LocalDate> {

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		long annee = ChronoUnit.YEARS.between(LocalDate.now(), value);
		return (annee > 18);
	}

}
