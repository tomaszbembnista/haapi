package eu.wordpro.ha.api;

import eu.wordpro.ha.api.model.OperationExecutionResult;
import eu.wordpro.ha.api.model.ProcessorOperationArgument;
import eu.wordpro.ha.api.model.ProcessorOperationDesc;

import java.util.LinkedList;
import java.util.List;

public interface SignalProcessor
{
    /**
     * Sets configuration needed to process a signal. Format of the configuration depends on implementation of the processor
     * @param configuration configuration to set
     * @throws InvalidConfigurationException if configuration can not be interpreted correctly
     */
    void setConfiguration(String configuration) throws InvalidConfigurationException;

    /**
     * Allows the home automation to listen to changes in the configuration and state of the processor.
     *
     */
    void setListener(StateListener listener);

    /**
     * Sets last known state of the processors. It is the state Sent the method {@link #getState() getState}
     * @param state state to set
     * @throws InvalidStateException if the state can not be interpreted correctly
     */
    void setState(String state) throws InvalidStateException;

    /**
     * Delivers state of the processors. The method can return null if the processor is stateless. Method used in
     * home automation framework to persist state of the processor.
     * @return current state of the processor
     */
    String getState();

    /**
     * Processes signal which occurred in home automation. Signal can be sent from device registered in the system or by the system itself
     * @param inputs list of signals, where first element in the list is a raw input to home automation framework. Next elements are outputs of processors in a processing chain. Most probably element used in the processor is the last one in the list but it depends on implementation and configuration of the processor.
     * @return Result of the processing. Can be used in next processor(s) in the chain or sent to device registered in the system
     * @throws InvalidSignalException if the input can not be interpreted correctly
     * @throws SignalProcessingException if the processing can not be done
     */
    SignalProcessorData processInput(LinkedList<SignalProcessorData> inputs) throws InvalidSignalException, SignalProcessingException;

    /**
     * Lists possible operations which can be done on the processor with their parameters. The list is thought for clients of the home automation.
     * Basing on the list GUI can be built dynamically.
     * @return possible operations which can be applied on the processor
     */
    List<ProcessorOperationDesc> listPossibleOperations();

    /**
     * Executes operation, which can change configuration or state of the processor
     * @param arguments arguments of the operation
     * @param name name of the operation
     * @return result of the operation
     */
    OperationExecutionResult executeOperation(List<ProcessorOperationArgument> arguments, String name);



}
