package eu.wordpro.ha.api;

public interface StateListener {

    void onConfigurationChanged(String configuration);

    void onStateChanged(String state);

}
