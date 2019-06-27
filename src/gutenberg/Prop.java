package gutenberg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Prop {

	public String propfilepath;
	public String filedb;
	public int numfiles;
	public String dbname;
	public Properties wardprop;
	public File initialFile;
	public String GutenbergFileBase;

	Prop(String thepropfilepath) throws IOException {
		propfilepath = thepropfilepath;
		wardprop = new Properties();
		File initialFile = new File(propfilepath);
		InputStream in = new FileInputStream(initialFile);
		wardprop.load(in);

	}

	public String getPropfilepath() {
		return propfilepath;
	}

	public void setPropfilepath(String propfilepath) {
		this.propfilepath = propfilepath;
	}

	public String getFiledb() {
		return wardprop.getProperty(filedb);
	}

	public void setFiledb(String filedb) {
		this.filedb = filedb;
	}

	public int getNumfiles() {
		return numfiles;
	}

	public void setNumfiles(int numfiles) {
		this.numfiles = numfiles;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public Properties getWardprop() {
		return wardprop;
	}

	public void setWardprop(Properties wardprop) {
		this.wardprop = wardprop;
	}

	public File getInitialFile() {
		return initialFile;
	}

	public void setInitialFile(File initialFile) {
		this.initialFile = initialFile;
	}

	public String getGutenbergFileBase() {
		return GutenbergFileBase;
	}

	public void setGutenbergFileBase(String gutenbergFileBase) {
		GutenbergFileBase = gutenbergFileBase;
	}

	boolean close() {
		return false;

	}
}
