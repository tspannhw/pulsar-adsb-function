package dev.pulsarfunction.adsb;

import org.apache.pulsar.client.impl.schema.JSONSchema;
import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;

import java.util.List;
import java.util.UUID;

/**
 * ADSB Function
**/
public class ADSBFunction implements Function<byte[], Void> {

    public static final String JAVA = "Java";
    public static final String LANGUAGE = "language";
    public static final String MESSAGE_JSON = "Receive message JSON:";
    public static final String ERROR = "ERROR:";
    public static final String PERSISTENT_PUBLIC_DEFAULT = "persistent://public/default/aircraft";


    /** PROCESS */
    @Override
    public Void process(byte[] input, Context context) {
        if ( input == null || context == null ) {
            return null;
        }

        if ( context.getLogger() != null && context.getLogger().isDebugEnabled() ) {
            context.getLogger().debug("LOG:" + input.toString());

            System.setProperty("org.slf4j.simpleLogger.logFile", "System.out");

            context.getLogger().debug("Available processors (cores): " +
                    Runtime.getRuntime().availableProcessors());

            /* Total amount of free memory available to the JVM */
            context.getLogger().debug("Free memory (bytes): " +
                    Runtime.getRuntime().freeMemory());

            /* This will return Long.MAX_VALUE if there is no preset limit */
            long maxMemory = Runtime.getRuntime().maxMemory();

            /* Maximum amount of memory the JVM will attempt to use */
            context.getLogger().debug("Maximum memory (bytes): " +
                    (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

            /* Total memory currently available to the JVM */
            context.getLogger().debug("Total memory available to JVM (bytes): " +
                    Runtime.getRuntime().totalMemory());
        }

        try {
            AirCraftParserService service = new AirCraftParserService();
            List<Aircraft> aircraftList = service.deserialize(input);

            if ( aircraftList != null ) {
                if ( context.getLogger() != null  && context.getLogger().isDebugEnabled() ) {
                    context.getLogger().debug(MESSAGE_JSON + aircraftList.size());
                }
                for (Aircraft aircraft: aircraftList) {
                    if (aircraft != null && aircraft.getAlt_baro() != null) {
                        if ( aircraft.getAlt_baro() > 0 ) {

//                            System.out.println(aircraft.toString());
//                            System.out.println("schema: " +  JSONSchema.of(Aircraft.class).getSchemaInfo().getSchemaDefinition() );

                            context.newOutputMessage(PERSISTENT_PUBLIC_DEFAULT, JSONSchema.of(Aircraft.class))
                                    .key(UUID.randomUUID().toString())
                                    .property(LANGUAGE, JAVA)
                                    .value(aircraft)
                                    .send();
                        }
                    }
                    if ( context.getLogger() != null  && context.getLogger().isDebugEnabled() ) {
                        context.getLogger().debug(MESSAGE_JSON + aircraft.toString());
                    }
                }

                // Cleanup, routing and schema to 3 topics
                // Add enrichment, extra fields
            }
        } catch (Throwable e) {
            if ( context.getLogger() != null) {
                context.getLogger().error(ERROR + e.getLocalizedMessage());
            }
        }
        return null;
    }
}