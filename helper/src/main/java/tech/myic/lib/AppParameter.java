package tech.myic.lib;

import java.util.List;

public class AppParameter
{
    private final List<CmdOption> cmdOptions;
    private final int numberOfParameters;

    public AppParameter(Builder builder)
    {
        this.cmdOptions = builder.cmdOptions;
        this.numberOfParameters = builder.numberOfParameters;
    }

    public int getNumberOfParameters()
    {
        return numberOfParameters;
    }

    public List<CmdOption> getOptions()
    {
        return cmdOptions;
    }

    public static class Builder
    {
        private List<CmdOption> cmdOptions;
        private int numberOfParameters;

        public AppParameter build()
        {
            return new AppParameter(this);
        }

        public Builder CmdOptions(List<CmdOption> cmdOptions)
        {
            this.cmdOptions = cmdOptions;
            return this;
        }

        public Builder NumberOfParameters(int numberOfParameters)
        {
            this.numberOfParameters = numberOfParameters;
            return this;
        }
    }
}
