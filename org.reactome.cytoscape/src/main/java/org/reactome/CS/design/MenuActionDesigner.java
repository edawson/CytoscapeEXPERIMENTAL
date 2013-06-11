package org.reactome.CS.design;

public interface MenuActionDesigner
{
    public abstract boolean createNewSession();
    
    public abstract boolean validateFile();
    
    public abstract void chooseFile();
    
    public abstract void browseDataFile();
    
}
