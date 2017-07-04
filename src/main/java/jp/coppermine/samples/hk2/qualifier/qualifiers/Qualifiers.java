package jp.coppermine.samples.hk2.qualifier.qualifiers;

import java.lang.annotation.Annotation;

@Japanese
@German
@France
@Italian
@Spanish
@Portuguese
@Chinese
@TraditionalChinese
@Korean
public class Qualifiers {

    public static Annotation getInstance(Class<? extends Annotation> annotationClass) {
        return Qualifiers.class.getAnnotation(annotationClass);
    }
}
