package de.herrmanno.simple_web.plugins.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import de.herrmanno.simple_web.typehandler.TypeHandler;

public class File_TypeHandler implements TypeHandler<File> {

	protected final String dir;
	private ClassLoader cl;
	
	public File_TypeHandler(String dir) {
		this.dir = dir;
		this.cl = Thread.currentThread().getContextClassLoader();
	}
	
	@Override
	public byte[] handle(File file) throws IOException {
		try(InputStream is = cl.getResourceAsStream(dir + File.separatorChar+  file.getPath()); ByteArrayOutputStream os = new ByteArrayOutputStream();) {
			byte[] buffer = new byte[1024];
			int r;
			while (true) {
				r = is.read(buffer);
				if (r == -1) break;
				os.write(buffer, 0, r);
			}
			
			return os.toByteArray();
		}
	}

}
