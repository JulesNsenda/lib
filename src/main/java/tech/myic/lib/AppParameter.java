package tech.myic.lib;

import java.util.List;
import javafx.util.Builder;

public class AppParameter
{
    private List<CmdOption> cmdOptions;
    private int numberOfParameters;

    public List<CmdOption> getOptions()
    {
        return cmdOptions;
    }

    public void setOptions(List<CmdOption> cmdOptions)
    {
        this.cmdOptions = cmdOptions;
    }

    public int getNumberOfParameters()
    {
        return numberOfParameters;
    }

    public void setNumberOfParameters(int numberOfParameters)
    {
        this.numberOfParameters = numberOfParameters;
    }
}
