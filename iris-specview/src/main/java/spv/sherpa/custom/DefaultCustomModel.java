/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package spv.sherpa.custom;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author olaurino
 */
public class DefaultCustomModel implements CustomModel {

    public DefaultCustomModel() {
        
    }

    public DefaultCustomModel(String name, String path) throws MalformedURLException {
        this.name = name;
        this.url = new URL("file:"+path);
    }

    private URL url;
    public static final String PROP_URL = "url";

    /**
     * Get the value of url
     *
     * @return the value of url
     */
    @Override
    public URL getUrl() {
        return url;
    }

    /**
     * Set the value of url
     *
     * @param url new value of url
     */
    @Override
    public void setUrl(URL url) {
        URL oldUrl = this.url;
        this.url = url;
        propertyChangeSupport.firePropertyChange(PROP_URL, oldUrl, url);
    }

    private String name;
    public static final String PROP_NAME = "name";

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    @Override
    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        propertyChangeSupport.firePropertyChange(PROP_NAME, oldName, name);
    }

    private String parnames;
    public static final String PROP_PARNAMES = "parnames";

    /**
     * Get the value of parnames
     *
     * @return the value of parnames
     */
    @Override
    public String getParnames() {
        return parnames;
    }

    /**
     * Set the value of parnames
     *
     * @param parnames new value of parnames
     */
    @Override
    public void setParnames(String parnames) {
        String oldParnames = this.parnames;
        this.parnames = parnames;
        propertyChangeSupport.firePropertyChange(PROP_PARNAMES, oldParnames, parnames);
    }

    private String parvals;
    public static final String PROP_PARVALS = "parvals";

    /**
     * Get the value of parvals
     *
     * @return the value of parvals
     */
    @Override
    public String getParvals() {
        return parvals;
    }

    /**
     * Set the value of parvals
     *
     * @param parvals new value of parvals
     */
    @Override
    public void setParvals(String parvals) {
        String oldParvals = this.parvals;
        this.parvals = parvals;
        propertyChangeSupport.firePropertyChange(PROP_PARVALS, oldParvals, parvals);
    }

    private String parmins;
    public static final String PROP_PARMINS = "parmins";

    /**
     * Get the value of parmins
     *
     * @return the value of parmins
     */
    @Override
    public String getParmins() {
        return parmins;
    }

    /**
     * Set the value of parmins
     *
     * @param parmins new value of parmins
     */
    @Override
    public void setParmins(String parmins) {
        String oldParmins = this.parmins;
        this.parmins = parmins;
        propertyChangeSupport.firePropertyChange(PROP_PARMINS, oldParmins, parmins);
    }

    private String parmaxs;
    public static final String PROP_PARMAXS = "parmaxs";

    /**
     * Get the value of parmaxs
     *
     * @return the value of parmaxs
     */
    @Override
    public String getParmaxs() {
        return parmaxs;
    }

    /**
     * Set the value of parmaxs
     *
     * @param parmaxs new value of parmaxs
     */
    @Override
    public void setParmaxs(String parmaxs) {
        String oldParmaxs = this.parmaxs;
        this.parmaxs = parmaxs;
        propertyChangeSupport.firePropertyChange(PROP_PARMAXS, oldParmaxs, parmaxs);
    }

    private String parfrozen;
    public static final String PROP_PARFROZEN = "parfrozen";

    /**
     * Get the value of parfrozen
     *
     * @return the value of parfrozen
     */
    @Override
    public String getParfrozen() {
        return parfrozen;
    }

    /**
     * Set the value of parfrozen
     *
     * @param parfrozen new value of parfrozen
     */
    @Override
    public void setParfrozen(String parfrozen) {
        String oldParfrozen = this.parfrozen;
        this.parfrozen = parfrozen;
        propertyChangeSupport.firePropertyChange(PROP_PARFROZEN, oldParfrozen, parfrozen);
    }


    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }


    @Override
    public String toString() {
        return name;
    }

}
