import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

import java.lang.reflect.Field;

public class MichalResourceLoader implements TypeListener{

    public <I> void hear(TypeLiteral<I> typeLiteral, TypeEncounter<I> typeEncounter) {
        Class<?> clazz = typeLiteral.getRawType();
        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(PropertyLoader.class)) {
                    PropertyLoader annotation = field.getAnnotation(PropertyLoader.class);
                    String fileName = annotation.fileName();
                    String propertyName = annotation.propertyName();
                    typeEncounter.register(new ResourceInjector<I>(field, fileName, propertyName));
                }
            }
            clazz = clazz.getSuperclass();
        }
    }
}

