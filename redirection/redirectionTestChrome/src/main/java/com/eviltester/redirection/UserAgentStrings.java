package com.eviltester.redirection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAgentStrings {

    Map<String, UserAgentString> userAgents = new HashMap<String, UserAgentString>();

    public void addUserAgent(UserAgentString userAgent) {
        userAgents.put(userAgent.getUserAgentString(), userAgent);
    }

    public Iterable<String>getAgentStrings(){

        List<String> agents = new ArrayList();
        for(UserAgentString agent : userAgents.values()){
            agents.add(agent.getUserAgentString());
        }

        return agents;
    }
}
