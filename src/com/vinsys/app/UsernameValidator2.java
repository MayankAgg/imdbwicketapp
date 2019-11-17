package com.vinsys.app;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

public class UsernameValidator2 implements IValidator<String> {

	@Override
	public void validate(IValidatable<String> validatable) {
		System.out.println(validatable.getValue());
		System.out.println("In validator");

		if (validatable.getValue().equalsIgnoreCase("Mayank")) {
			ValidationError validationError = new ValidationError();
			validationError.setMessage("this is ridiculous");
			validatable.error(validationError);
		}
	}
}
