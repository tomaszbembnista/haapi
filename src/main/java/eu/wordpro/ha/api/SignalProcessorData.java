package eu.wordpro.ha.api;

/**
 * Class containing data for signal processors.
 * The data is saved as string.
 */
public class SignalProcessorData {

    private final String name;
    private final String value;

    public SignalProcessorData(String name, String value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
