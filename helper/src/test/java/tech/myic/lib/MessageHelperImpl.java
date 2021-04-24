package tech.myic.lib;

import java.util.LinkedList;
import java.util.List;

class MessageHelperImpl
        implements Helper
{
    private int numberOfParameters;
    private String applicationDescription;
    private String applicationName;

    public MessageHelperImpl()
    {
    }

    public MessageHelperImpl(Builder builder)
    {
        this.applicationDescription = builder.applicationDescription;
        this.applicationName = builder.applicationName;
        this.numberOfParameters = builder.numberOfParameters;
    }

    public static void main(String[] args)
    {
        MessageHelperImpl messageHelperImpl = new MessageHelperImpl();
        messageHelperImpl.setNumberOfParameters(2);
        messageHelperImpl.setApplicationName("Test");
        messageHelperImpl.setApplicationDescription("This is a test application to see how the helper library works.");

        messageHelperImpl.showHelpMessage();
    }

    public void showHelpMessage()
    {
        Helper.displayHelpMessage(getApplicationParameter(), getApplicationName(), getApplicationDescription());
    }

    @Override
    public String getApplicationDescription()
    {
        return this.applicationDescription;
    }

    public void setApplicationDescription(String applicationDescription)
    {
        this.applicationDescription = applicationDescription;
    }

    @Override
    public AppParameter getApplicationParameter()
    {
        return new AppParameter.Builder()
                .CmdOptions(getCmdOptions())
                .NumberOfParameters(getNumberOfParameters())
                .build();
    }

    @Override
    public String getApplicationName()
    {
        return this.applicationName;
    }

    public void setApplicationName(String applicationName)
    {
        this.applicationName = applicationName;
    }

    @Override
    public List<CmdOption> getCmdOptions()
    {
        List<CmdOption> cmdOptions = new LinkedList<>();
        CmdOption op1 = CmdOption.createCmdOption("-in=", "Input file", "Make sure this input option is provided");
        cmdOptions.add(op1);
        CmdOption op2 = CmdOption.createCmdOption("-out=", "Output file", "Make sure this output option is provided");
        cmdOptions.add(op2);

        return cmdOptions;
    }

    @Override
    public int getNumberOfParameters()
    {
        return this.numberOfParameters;
    }

    public void setNumberOfParameters(int numberOfParameters)
    {
        this.numberOfParameters = numberOfParameters;
    }

    public static class Builder
    {
        private int numberOfParameters;
        private String applicationDescription;
        private String applicationName;

        public Builder numberOfParameters(int numberOfParameters)
        {
            this.numberOfParameters = numberOfParameters;
            return this;
        }

        public Builder applicationDescription(String applicationDescription)
        {
            this.applicationDescription = applicationDescription;
            return this;
        }

        public Builder applicationName(String applicationName)
        {
            this.applicationName = applicationName;
            return this;
        }

        public MessageHelperImpl build()
        {
            return new MessageHelperImpl(this);
        }
    }

}
