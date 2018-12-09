package com.cms.utils.jcr;

import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.net.UnknownHostException;

public class CNDMain {
    public static void main(String[] args) throws UnknownHostException, LoginException, RepositoryException {

        Session session = BdStructure.getSession();
        Node parentNode = session.getRootNode();
//		Node childNode = parentNode.addNode("test-version");
//		childNode.setProperty("ville", "Argenteuil");
//		childNode.addMixin(JcrConstants.MIX_VERSIONABLE);

        Node node = parentNode.addNode("test-version", "cnt:article");
//		node.checkin();
//		node.checkout();
        node.setProperty("ville", "Casablanca");

        session.save();
        session.logout();
        System.out.println("FIN");
    }
}