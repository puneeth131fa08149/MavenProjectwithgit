package DisplayAllLinks;

import BaseClass.Base;

public class Links extends Base{
	
	public static void AllLinks() {
		logger.info("************< display All Links > **********");
		webElements(driver, "//a");
		
	}

}
