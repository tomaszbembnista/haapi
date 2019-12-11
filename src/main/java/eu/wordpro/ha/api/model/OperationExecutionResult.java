package eu.wordpro.ha.api.model;

import eu.wordpro.ha.api.SignalProcessorData;

public class OperationExecutionResult {
    private SignalProcessorData signalProcessorData;
    private String dataForClient;

    public SignalProcessorData getSignalProcessorData() {
        return signalProcessorData;
    }

    public void setSignalProcessorData(SignalProcessorData signalProcessorData) {
        this.signalProcessorData = signalProcessorData;
    }

    public String getDataForClient() {
        return dataForClient;
    }

    public void setDataForClient(String dataForClient) {
        this.dataForClient = dataForClient;
    }


}
