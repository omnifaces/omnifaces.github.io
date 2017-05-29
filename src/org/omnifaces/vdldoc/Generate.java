package org.omnifaces.vdldoc;

import java.io.File;


/**
 * Helper class to generate VDL documentation.
 *
 * @author Bauke Scholtz
 */
public class Generate {

	private static final String VDLDOC_TITLE = "OmniFaces VDL Documentation - Generated Documentation";

	public static void main(String[] args) throws Exception {
		File omniFacesHomepageProject = new File("").getAbsoluteFile();
		File omniFacesProject = new File(omniFacesHomepageProject.getParentFile(), "/omnifaces");

		if (!omniFacesProject.exists()) {
			throw new IllegalArgumentException("OmniFaces project missing in workspace");
		}

		VdldocGenerator generator = new VdldocGenerator();
		generator.setWindowTitle(VDLDOC_TITLE);
		generator.setDocTitle(VDLDOC_TITLE);
		generator.setOutputDirectory(new File(omniFacesHomepageProject, "/docs/vdldoc/1.14"));
		generator.setFacesConfig(new File(omniFacesProject, "/src/main/resources/META-INF/faces-config.xml"));
		generator.addTaglib(new File(omniFacesProject, "/src/main/resources/META-INF/omnifaces-ui.taglib.xml"));
		generator.addTaglib(new File(omniFacesProject, "/src/main/resources/META-INF/omnifaces-functions.taglib.xml"));
		generator.generate();
	}

}