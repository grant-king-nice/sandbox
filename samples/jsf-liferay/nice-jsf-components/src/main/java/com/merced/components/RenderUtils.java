package com.merced.components;



public class RenderUtils {

    
    /**
     * Return a valid html id by removing all invalid characters
     * @param id
     * @return
     */
    public static String getCleanComponentId(String id){
        return id.replaceAll("[\\.\\[\\]\"]", "_");
    }
    
    
    /**
     * Escape so is suitable for use in a jQuery selector
     * @param clientId
     * @return
     */
    public static String escapeClientId(String clientId) {
    	return clientId.replace(":", "\\\\:");
    }
    

}
