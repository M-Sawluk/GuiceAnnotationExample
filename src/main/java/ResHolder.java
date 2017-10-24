import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ResHolder {

    @PropertyLoader(fileName = "test.properties", propertyName = "jestmistrzem")
    private boolean czyMichalJestMistrzem;

    @PropertyLoader(fileName = "test.properties", propertyName = "michal")
    private String property;

    @PropertyLoader(fileName = "test.properties", propertyName = "michal")
    private char charproperty;

    @PropertyLoader(fileName = "test.properties", propertyName = "num")
    private int number;

    public String getProperty() {
        return property;
    }

    public boolean getCzyMichalJestMistrzem() {
        return czyMichalJestMistrzem;
    }
    public char getCharproperty() {
        return charproperty;
    }

    public int getNumber() {
        return number;
    }

    @Inject
    public ResHolder() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ResHolder)) return false;

        ResHolder resHolder = (ResHolder) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(getCzyMichalJestMistrzem(), resHolder.getCzyMichalJestMistrzem())
                .append(getCharproperty(), resHolder.getCharproperty())
                .append(getNumber(), resHolder.getNumber())
                .append(getProperty(), resHolder.getProperty())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(getCzyMichalJestMistrzem())
                .append(getProperty())
                .append(getCharproperty())
                .append(getNumber())
                .toHashCode();
    }
}
