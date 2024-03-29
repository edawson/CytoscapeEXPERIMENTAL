package org.reactome.CS.internal;

import java.util.List;

import org.cytoscape.model.CyEdge;
import org.cytoscape.model.CyIdentifiable;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.view.model.CyNetworkView;
import org.reactome.CS.design.SelectionActionDesigner;

public class SelectionActionImpl implements SelectionActionDesigner
{

    public SelectionActionImpl()
    {
    }

    public void selectAllNodes(CyNetwork network)
    {
	List <CyNode> nodeList = network.getNodeList();
	for (CyNode node : nodeList)
	{
	    network.getRow(node).set(CyNetwork.SELECTED, true);
	}

    }

    public void selectAllNodes(CyNetworkView view)
    {
	CyNetwork network = view .getModel();
	List <CyNode> nodeList = network.getNodeList();
	for (CyNode node : nodeList)
	{
	    network.getRow(node).set(CyNetwork.SELECTED, true);
	}

    }

    public void selectAllEdges(CyNetwork network)
    {
	List <CyEdge> edgeList = network.getEdgeList();
	for (CyEdge edge : edgeList)
	{
	    network.getRow(edge).set(CyNetwork.SELECTED, true);
	}

    }

    public void selectAllEdges(CyNetworkView view)
    {
	CyNetwork network = view.getModel();
	List <CyEdge> edgeList = network.getEdgeList();
	for (CyEdge edge : edgeList)
	{
	    network.getRow(edge).set(CyNetwork.SELECTED, true);
	}
    }

    public void selectNodes(List<CyNode> nodeList)
    {
	for (CyNode node : nodeList)
	{
	    node.getNetworkPointer().getRow(node).set(CyNetwork.SELECTED, true);
	}

    }

    public void selectEdges(List<CyEdge> edgeList)
    {
	for (CyEdge edge : edgeList)
	{
	    edge.getSource().getNetworkPointer().getRow(edge).set(CyNetwork.SELECTED, true);
	}
    }

    public void unselectAllNodes(CyNetwork network)
    {
	List <CyNode> nodeList = network.getNodeList();
	for (CyNode node : nodeList)
	{
	    network.getRow(node).set(CyNetwork.SELECTED, false);
	}
    }

    public void unselectAllNodes(CyNetworkView view)
    {
	CyNetwork network = view .getModel();
	List <CyNode> nodeList = network.getNodeList();
	for (CyNode node : nodeList)
	{
	    network.getRow(node).set(CyNetwork.SELECTED, false);
	}

    }

    public void unselectAllEdges(CyNetwork network)
    {
	List <CyEdge> edgeList = network.getEdgeList();
	for (CyEdge edge : edgeList)
	{
	    CyNode node = edge.getSource();
	    node.getNetworkPointer().getRow(edge).set(CyNetwork.SELECTED, false);
	}
    }

    public void unselectAllEdges(CyNetworkView view)
    {
	CyNetwork network = view.getModel();
	List <CyEdge> edgeList = network.getEdgeList();
	for (CyEdge edge : edgeList)
	{
	    CyNode node = edge.getSource();
	    node.getNetworkPointer().getRow(edge).set(CyNetwork.SELECTED, false);
	}
    }

    public void unselectNode(CyNode node)
    {
	node.getNetworkPointer().getRow(node).set(CyNetwork.SELECTED, false);
    }

    public void unselectNodes(List<CyNode> nodeList)
    {
	for (CyNode node : nodeList)
	{
	    node.getNetworkPointer().getRow(node).set(CyNetwork.SELECTED, false);
	}

    }

    public void unselectEdge(CyEdge edge)
    {
	CyNode node = edge.getSource();
	node.getNetworkPointer().getRow(edge).set(CyNetwork.SELECTED, false);

    }

    public void unselectEdges(List<CyEdge> edgeList)
    {
	for (CyEdge edge : edgeList)
	{
	    CyNode node = edge.getSource();
	    node.getNetworkPointer().getRow(edge).set(CyNetwork.SELECTED, false);
	}

    }

    public void invertSelection(CyIdentifiable cyObject)
    {
	if (cyObject instanceof CyNode)
	{
	    CyNode node = (CyNode) cyObject;
	    if (node.getNetworkPointer().getRow(cyObject).get(CyNetwork.SELECTED, Boolean.class) == true)
		node.getNetworkPointer().getRow(node).set(CyNetwork.SELECTED, false);
	    else
		node.getNetworkPointer().getRow(node).set(CyNetwork.SELECTED, true);
	}
	else if (cyObject instanceof CyEdge)
	{
	    CyEdge edge = (CyEdge) cyObject;
	    if (edge.getSource().getNetworkPointer().getRow(edge).get(CyNetwork.SELECTED, Boolean.class) == true)
		edge.getSource().getNetworkPointer().getRow(edge).set(CyNetwork.SELECTED, false);
	    else
		edge.getSource().getNetworkPointer().getRow(edge).set(CyNetwork.SELECTED, true);
	}
	else if (cyObject instanceof CyNetwork)
	{
	    CyNetwork network = (CyNetwork) cyObject;
	    List <CyNode> nodeList = network.getNodeList();
	    for (CyNode node : nodeList)
	    {
		if ( network.getRow(node).get(CyNetwork.SELECTED, Boolean.class) == false)
			network.getRow(node).set(CyNetwork.SELECTED, true);
		else if ( network.getRow(node).get(CyNetwork.SELECTED, Boolean.class) == true)
			network.getRow(node).set(CyNetwork.SELECTED, false);
	    }
	    List < CyEdge > edgeList = network.getEdgeList();
	    for (CyEdge edge : edgeList)
	    {
		if ( network.getRow(edge).get(CyNetwork.SELECTED, Boolean.class) == false)
			network.getRow(edge).set(CyNetwork.SELECTED, true);
		else if ( network.getRow(edge).get(CyNetwork.SELECTED, Boolean.class) == true)
			network.getRow(edge).set(CyNetwork.SELECTED, false);
	    }
	}

    }

}
