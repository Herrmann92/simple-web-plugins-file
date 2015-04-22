package de.herrmanno.simple_web.plugins.file;

import de.herrmanno.simple_web.config.Config;
import de.herrmanno.simple_web.plugin.Plugin;
import de.herrmanno.simple_web.plugins.file.config.File_Config;

public class File_Plugin implements Plugin{

	protected File_Config c;

	public File_Plugin(File_Config c) {
		this.c = c;
	}
	
	@Override
	public void register(Config config) {
		config.getTypeConfig().register(new File_TypeHandler(c.getResourceDir()));
	}

}
