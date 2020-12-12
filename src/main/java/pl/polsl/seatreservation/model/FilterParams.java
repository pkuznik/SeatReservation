
package pl.polsl.seatreservation.model;

import java.util.*;

/**
 * Model responsible for preparing the output data. 
 * the output can come from the command line (program startup), 
 * but it can also be retrieved from the user
 * 
 * @author Piotr Kuźnik
 * @version 3.0
 */
public class FilterParams {

    /**
     * Object contains final parameters for program
     */
    private final Parameters parameters;
    
    /**
     * Construct
     * @param args Array with begin parameters of program
     */
    public FilterParams(String args[]) {
        int sizeX = 10, sizeY = 10, spaceX = 0, spaceY = 0, mode = Parameters.UI_MODE_DEFAULT;
        List<Integer> quantityOfChairsToReserve = new ArrayList<>();
        
        if (this.inArray("-sizeX", args)) {
            sizeX = this.readArgumentFromArray("-sizeX", args);
            args = this.removeArgumentFromArray("-sizeX", args);
        }
        
       
        if (this.inArray("-sizeY", args)) {
            sizeY = this.readArgumentFromArray("-sizeY", args);
            args = this.removeArgumentFromArray("-sizeY", args);
        } 
        
        if (this.inArray("-spaceX", args)) {
            spaceX = this.readArgumentFromArray("-spaceX", args);
            args = this.removeArgumentFromArray("-spaceX", args);
        }
        
        if (this.inArray("-spaceY", args)) {
            spaceY = this.readArgumentFromArray("-spaceY", args);
            args = this.removeArgumentFromArray("-spaceY", args);
        }
        
        if (this.inArray("-mode", args)) {
            mode = this.readArgumentFromArray("-mode", args);
            args = this.removeArgumentFromArray("-mode", args);
            
            if (mode != Parameters.UI_MODE_CONSOLE && mode != Parameters.UI_MODE_GRAPHIC) {
                //set deafult
                mode = Parameters.UI_MODE_DEFAULT; 
            }
        }
       
        for (String arg : args) {
            quantityOfChairsToReserve.add(Integer.parseInt(arg));
        }
            
        this.parameters = new Parameters(sizeX, sizeY, spaceX, spaceY, quantityOfChairsToReserve, mode);
    }
    
    /**
     * 
     * @return Object with final parameter for program 
     */
    public Parameters getParameters() {
        return this.parameters;
    }
    
    /**
     * check value in array
     * 
     * @param argName searching argument
     * @param args array of arguments
     * @return True if exists
     */
    private boolean inArray(String argName, String args[]) {
        return Arrays.stream(args).anyMatch(argName::equals);
    }
    
    /**
     * Return value from argument name
     * @param argName
     * @param args
     * @return value search arguments type integer
     */
    private int readArgumentFromArray(String argName, String args[]) {
        for (int i=0; i<args.length; i++) {
            if (args[i].equals(argName) && i + 1 < args.length) {
                
                return Integer.parseInt(args[i + 1]);
            }
        }
        
        return 0;
    }
    
    /**
     * Remove value and argument name from array
     * @param argRemove Name argument for remove from args
     * @param args Array of arguments
     * @return New array without argument and value for remove  (index i and i + 1)
     */
    private String[] removeArgumentFromArray(String argRemove, String args[]) {
        String[] newArgs = new String[args.length - 2];
        int j = 0;
        for (int i=0; i<args.length; i++) {
            if (args[i].equals(argRemove) || (i > 0 && args[i - 1].equals(argRemove))) {
               continue;
            }
            
            newArgs[j++] = args[i];
         
        }
        
        return newArgs;
    }
}