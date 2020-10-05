package eu.wordpro.ha.api.model;

import com.google.gson.Gson;
import eu.wordpro.ha.api.InvalidSignalException;
import eu.wordpro.ha.api.SignalProcessorData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessingData {

    private List<SignalProcessorData> data = new ArrayList<>();
    private Gson gson = new Gson();

    /**
     * Stores data
     *
     * @param toAdd data to add
     */
    public void add(SignalProcessorData toAdd) {
        data.add(toAdd);
    }

    public String getLast() {
        if (data.size() == 0) {
            return null;
        }
        return data.get(data.size() - 1).getValue();
    }

    public <T> T getLast(Class<T> clazz) throws InvalidSignalException {
        String last = getLast();
        if (last == null) {
            return null;
        }
        try {
            return gson.fromJson(last, clazz);
        } catch (Exception e) {
            throw new InvalidSignalException(e.getMessage());
        }

    }

    public String getByName(String name) {
        if (name == null) {
            return null;
        }
        SignalProcessorData signalProcessorData = data.stream().filter(elem -> name.equals(elem.getName()))
                .findFirst().orElse(null);
        if (signalProcessorData == null) {
            return null;
        }
        return signalProcessorData.getValue();
    }

    public <T> T getByName(String name, Class<T> clazz) throws InvalidSignalException {
        String byName = getByName(name);
        if (byName == null) {
            return null;
        }
        try {
            return gson.fromJson(byName, clazz);
        } catch (Exception e) {
            throw new InvalidSignalException(e.getMessage());
        }
    }

    public List<SignalProcessorData> getAll() {
        return data.stream().collect(Collectors.toList());
    }

    public ProcessingData copy() {
        ProcessingData result = new ProcessingData();
        result.data = this.getAll();
        return result;
    }


}
