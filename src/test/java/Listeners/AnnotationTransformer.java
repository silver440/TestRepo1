package Listeners;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;


import org.testng.IAnnotationTransformer;
import org.testng.annotations.IAnnotation;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer {
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstrucotor,
			Method tesMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);

	
	}
}
