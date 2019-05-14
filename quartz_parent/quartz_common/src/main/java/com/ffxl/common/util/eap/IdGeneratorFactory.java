package com.ffxl.common.util.eap;

public class IdGeneratorFactory {

    public static IdGenerator createIdGenerator(){
    	IdGenerator idGenerator = new DefaultIdGenerator();
        return idGenerator;
    }
    
    public static IdGenerator createIdGenerator(IdGeneratorConfig config){
    	IdGenerator idGenerator = new DefaultIdGenerator(config);
        return idGenerator;
    }

}
