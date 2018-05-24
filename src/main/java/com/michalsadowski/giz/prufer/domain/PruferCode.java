package com.michalsadowski.giz.prufer.domain;

import java.util.Arrays;

/**
 * Created by sadowsm3 on 21.05.2018
 */
public class PruferCode {
    public String rootNode;
    public String[] nodeList;
    public String[] identifierList;

    public PruferCode() {
    }

    public String getRootNode() {
        return rootNode;
    }

    public void setRootNode(String rootNode) {
        this.rootNode = rootNode;
    }

    public String[] getNodeList() {
        return nodeList;
    }

    public void setNodeList(String[] nodeList) {
        this.nodeList = nodeList;
    }

    public String[] getIdentifierList() {
        return identifierList;
    }

    public void setIdentifierList(String[] identifierList) {
        this.identifierList = identifierList;
    }

    @Override
    public String toString() {
        return "PruferCode{" +
                "rootNode='" + rootNode + '\'' +
                ", nodeList=" + (nodeList == null ? null : Arrays.asList(nodeList)) +
                ", identifierList=" + (identifierList == null ? null : Arrays.asList(identifierList)) +
                '}';
    }
}
