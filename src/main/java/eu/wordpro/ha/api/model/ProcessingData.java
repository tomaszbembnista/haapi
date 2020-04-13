package eu.wordpro.ha.api.model;

import eu.wordpro.ha.api.SignalProcessorData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessingData {

    private List<SignalProcessorData> data = new ArrayList<>();

    /**
     * Stores data
     * @param toAdd data to add
     */
    public void add(SignalProcessorData toAdd){
        data.add(toAdd);
    }

    public SignalProcessorData getLast(){
        if (data.size() == 0) {
            return null;
        }
        return data.get(data.size() - 1);
    }

    public SignalProcessorData getByName(String name){
        if (name == null){
            return null;
        }
        return data.stream().filter(elem -> name.equals(elem.getName()))
                .findFirst().orElse(null);
    }

    public List<SignalProcessorData> getAll(){
        return data.stream().collect(Collectors.toList());
    }



}
