package com.cms.utils.jcr;

import java.net.UnknownHostException;

import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.version.Version;
import javax.jcr.version.VersionHistory;
import javax.jcr.version.VersionIterator;

public class VersionMain {
	public static void main(String[] args) throws UnknownHostException, LoginException, RepositoryException {
		Session session = BdStructure.getSession();
//		Node childNode = session.getNode(BdStructure.DEV_PATH_NODE);
		VersionHistory history = session.getWorkspace().getVersionManager()
				.getVersionHistory("/test-version");
		
//		Version v = session.getWorkspace().getVersionManager().getBaseVersion(BdStructure.PROD_PATH_NODE);
//		v.get()()()
//		v.getFrozenNode().getProperty("ville");
//		VersionIterator vit = history.getAllVersions();

		// while (vit.hasNext()) {
//			Version v = ((Version) vit.nextVersion());
//			System.out.println(v.getProperty("ville"));
//		}

		for (VersionIterator vIter = history.getAllVersions(); vIter.hasNext();) {
			Version v = vIter.nextVersion();
			System.out.println(v.getName());

			for (NodeIterator nodeIter = v.getNodes(); nodeIter.hasNext();) {
				Node n = nodeIter.nextNode();
				if (n.hasProperty("ville")) {
					System.out.println(n.getProperty("ville").getString());
				}
				System.out.println(n.getPath());
				for (NodeIterator nIter = n.getNodes(); nIter.hasNext();) {
					Node n1 = nIter.nextNode();
					if (n1.hasProperty("ville")) {
						System.out.println(n1.getProperty("ville").getString());
					}
					System.out.println(n1.getPath());
				}
			}
		}

		session.logout();
		System.out.println("FIN");
	}
}