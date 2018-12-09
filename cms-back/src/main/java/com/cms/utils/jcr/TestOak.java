package com.cms.utils.jcr;

import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.net.UnknownHostException;

public class TestOak {
    public static void main(String[] args) throws UnknownHostException, LoginException, RepositoryException {

        Session session = BdStructure.getSession();
//		Node parentNode = session.getRootNode();
//		Node childNode = parentNode.addNode("test-version");
//		childNode.setProperty("ville", "Argenteuil");
//		childNode.addMixin(JcrConstants.MIX_VERSIONABLE);

        Node node = session.getNode("/test-version");
//		node.checkin();
//		node.checkout();

        node.setProperty("ville", "Casablanca");

//		System.out.println(childNode.getProperty("country").getString());

//		  childNode.addMixin(JcrConstants.MIX_VERSIONABLE);
//		
//		Node dev = childNode.addNode("tata");
//		dev.addMixin(JcrConstants.MIX_VERSIONABLE);

//		childNode.addMixin(JcrConstants.MIX_VERSIONABLE);
//		VersionHistory history = session.getWorkspace().getVersionManager().getVersionHistory(childNode.getPath());
//		dev.setProperty("ville", "Casa");

//		session.getWorkspace().copy(srcAbsPath, destAbsPath);
        session.save();
        session.logout();
        System.out.println("FIN");
    }
}