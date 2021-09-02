package eshop.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class DateTest {

	@Test
	public void test() {
		long l = ChronoUnit.YEARS.between(LocalDate.of(2000, Month.JANUARY, 01),LocalDate.of(2021, Month.AUGUST, 31));
		System.out.println(l);
	}

}
