package com.myexperiments.ward;

import java.net.MalformedURLException;

import jcifs.smb.SmbException;
import jcifs.smb.*;

public class NetworkDirectory {
	public SmbFile[] RemoteDirectory;
	public SmbFile RemoteFile;

	NetworkDirectory(String location) throws MalformedURLException {
		RemoteFile = new SmbFile(location);
	}

	SmbFile[] createlist() throws MalformedURLException, SmbException {
		// "smb://10.50.90.18/ITS Tool/xml/"

		RemoteDirectory = RemoteFile.listFiles();
		return RemoteDirectory;
	};
}
