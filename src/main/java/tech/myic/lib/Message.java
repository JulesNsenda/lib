package tech.myic.lib;

import java.util.List;

class Message
{
    private Message()
    {
    }

    static void displayHelpMessage(AppParameter appParameter, String applicationName)
    {
        List<CmdOption> cmdOptions = appParameter.getOptions();
        StringBuilder sb = new StringBuilder();
        for (CmdOption cmdOption : cmdOptions){
            String key = cmdOption.getKey();
            String description = cmdOption.getDescription();
            sb.append(key.concat("<").concat(description).concat("> "));
        }

        System.out.println("Usage: " + applicationName.concat(".jar ") + sb);
    }

}
