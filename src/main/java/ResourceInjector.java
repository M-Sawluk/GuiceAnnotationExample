import com.google.inject.MembersInjector;



import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceInjector<T> implements MembersInjector<T> {
    private Field field;
    private String fileName;
    private String propertyName;

    public ResourceInjector(Field field, String fileName, String propertyName) {
        this.field = field;
        this.fileName = fileName;
        this.propertyName = propertyName;
        field.setAccessible(true);
        System.out.println("Initialized");
    }

    public void injectMembers(T t) {
        InputStream stream = this.getClass().getResourceAsStream(fileName);
        Properties properties = new Properties();

        try {
            properties.load(stream);
            String property = properties.getProperty(propertyName);
            Class<?> type = field.getType();
            if(property.trim().equals(""))
                throw new IllegalArgumentException("Your property is empty");
            if(type == Character.TYPE || type == char.class)
                field.set(t, property.charAt(0));
            else if(type == Boolean.class || type == boolean.class)
                field.set(t, Boolean.parseBoolean(property));
            else if(type == Integer.TYPE || type == int.class)
                field.set(t,Integer.parseInt(property));
            else if(type == String.class)
                field.set(t, property);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

}
