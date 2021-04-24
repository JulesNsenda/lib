package tech.myic.lib;

import java.util.List;

public interface Helper
{
    static void displayHelpMessage(AppParameter appParameter, String applicationName, String applicationDescription)
    {
        List<CmdOption> cmdOptions = appParameter.getOptions();
        StringBuilder sb = new StringBuilder();
        for (CmdOption cmdOption : cmdOptions){
            String key = cmdOption.getKey();
            String description = cmdOption.getDescription();
            sb.append(key.concat("<").concat(description).concat("> "));
        }

        StringBuilder optionComments = new StringBuilder();
        for (CmdOption co : cmdOptions){
            optionComments.append(("\t" + co.getKey()).concat("\n")
                    .concat("\t\t").concat(co.getComments()).concat("\n"));
        }

        System.out.println("NAME \n"
                + "\t " + applicationName + "\n"
                + "SYNOPSIS \n"
                + "\t " + applicationName + ".jar " + sb + "\n"
                + "DESCRIPTION \n"
                + "\t" + applicationDescription + " \n"
                + "\t ?, --help, -h \n"
                + "\t\tDisplays usage of the " + applicationName + " program \n"
                + optionComments);
    }

    String getApplicationDescription();

    AppParameter getApplicationParameter();

    String getApplicationName();

    List<CmdOption> getCmdOptions();

    int getNumberOfParameters();

}
