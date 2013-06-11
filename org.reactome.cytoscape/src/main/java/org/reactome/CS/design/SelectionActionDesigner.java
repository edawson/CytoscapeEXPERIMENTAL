package org.reactome.CS.design;

import java.util.List;

import org.cytoscape.model.CyEdge;
import org.cytoscape.model.CyIdentifiable;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.view.model.CyNetworkView;

public interface SelectionActionDesigner
{

    public abstract void selectAllNodes(CyNetwork network);
    
    public abstract void selectAllNodes(CyNetworkView view);
    
    public abstract void selectAllEdges(CyNetwork network);
    
    public abstract void selectAllEdges(CyNetworkView view);
    
    public abstract void selectNodes(List <CyNode> nodeList);
    
    public abstract void selectEdges(List <CyEdge> edgeList);
    
    public abstract void unselectAllNodes(CyNetwork network);
    
    public abstract void unselectAllNodes(CyNetworkView view);
    
    public abstract void unselectAllEdges(CyNetwork network);
    
    public abstract void unselectAllEdges(CyNetworkView view);
    
    public abstract void unselectNode(CyNode node);
    
    public abstract void unselectNodes(List <CyNode> nodeList);
    
    public abstract void unselectEdge(CyEdge edge);
    
    public abstract void unselectEdges(List <CyEdge> edgeList);
    
    public abstract void invertSelection (CyIdentifiable cyObject);
}
