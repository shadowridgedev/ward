package com.myexperiments.ward;

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
	public Properties prop;
	public File initialFile;
	public String GutenbergFileBase;
	public Properties theProp;

	public Prop(String thepropfilepath) throws IOException {
		propfilepath = thepropfilepath;
		theProp = new Properties();
		File initialFile = new File(propfilepath);
		InputStream in = new FileInputStream(initialFile);
		theProp.load(in);

	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public Properties getTheProp() {
		return theProp;
	}

	public void setTheProp(Properties theProp) {
		this.theProp = theProp;
	}

	public String getPropfilepath() {
		return propfilepath;
	}

	public void setPropfilepath(String propfilepath) {
		this.propfilepath = propfilepath;
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
