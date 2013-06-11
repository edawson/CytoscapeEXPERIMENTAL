/*
 * Created on May 22, 2007
 *
 */
package org.reactome.CS.design;

import java.util.List;

import org.reactome.funcInt.Interaction;

/**
 * This interface lists all API in the Functional Analysis web service server.
 * @author guanming
 *
 */
public interface FIServiceAPI {
    
    /**
     * Set the URL for the web service.
     * @param url
     */
    public void setWSURL(String url);
    
    /**
     * Query for functional interactions both proteins should be in the listed accessionQuery.
     * @param accessionQuery
     * @return
     * @throws Exception
     */
    public List<Interaction> queryForAnd(String accessionQuery) throws Exception;
    
    /**
     * Query for functional interactions either of proteins should be in the listed accessionQuery.
     * @param accessQuery
     * @return
     * @throws Exception
     */
    public List<Interaction> queryForOr(String accessQuery) throws Exception;
    
}
