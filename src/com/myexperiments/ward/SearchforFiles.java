package com.myexperiments.ward;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

public class SearchforFiles {

	public void SearchFiles(File root, String[] type, SQLInterface db) throws Exception {

		searchForFilesExt(root, type, db);
	}

	public void searchForFilesExt(File root, String[] type, SQLInterface db) throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("File " + root.toString());
		File root1 = root;
//		if (count > string)
//			return null;

		if (root1 == null)
			return; // just for safety || !root.getPath().toString().contains("old"))

		if (root1.isDirectory()) {
			// System.out.println(root.toString());

			for (File file : root1.listFiles()) {
				if (file != null) {
					searchForFilesExt(file, type, db);
				}
			}
		} else if (root1.isFile()) {
			HashFile Hasher = new HashFile();

			String ext = getExt(root1);

			if (isType(type, ext)) {
				String name1 = root1.getName();

				String name2 = needsfix(root1.getName());
				if (!name1.equals(name2)) {
					Path source = root1.toPath();
					Files.move(source, source.resolveSibling(name2));

				}
				if (!Files.notExists((root1.toPath()))) {
					if (!name1.equals(name2)) {
						Path source = root1.toPath();
						Files.move(source, source.resolveSibling(name2));

					}
					FileData Item = new FileData();
					Item.Path = root1.getAbsolutePath();

					Item.Ext = ext;
					Item.FileName = root1.getName();
					Item.Size = root1.length();
					Item.Path = root1.getPath();
					Item.Source = "ASROCK";
					Item.Host = "ASROCK";
					Item.Language = "English";
					Item.Verified = false;

					Item.ParsedUIMA = false;
					Item.TooBig = false;
					Item.UIMAref = 0;
					Item.Neo4Jref = 0;
					Item.parsed = false;
					Item.audio = false;
					Item.text = false;
					Item.image = false;
					Item.video = false;

//				long heapFreeSize = Runtime.getRuntime().freeMemory() / (1024 * 1024);
//				long heapMaxSize = Runtime.getRuntime().maxMemory() / (1024 * 1024);

					Item.TooBig = false;
					if (Item.Size != 0) {
						if (Item.Size > Integer.MAX_VALUE - 1) {
							// String data = new String(Files.readAllBytes(Paths.get(FileData.Path)));
							Item.TooBig = true;
							System.out.println(Item.Path + " " + Item.FileName + " " + Item.Size + " " + Item.Ext
									+ "     " + Item.CRC);
							System.out.println("TOO BIG!!!");
						} else {
							Item.CRC = Hasher.verifyChecksum(Item.Path);// calc.fromBytes(data.getBytes()).getValue();
							System.out.println(Item.Path + " " + Item.FileName + " " + Item.Size + " " + Item.Ext
									+ "     " + Item.CRC);
						}
					}
					if (!name1.equals(name2)) {
						Path source = root1.toPath();
						Files.move(source, source.resolveSibling(name2));
						Item.FileName = name2;
					}
					Item.InsertFileData(Item, SQLInterface.Queryconnection, "files");
					Item = null;
					Hasher = null;
				}

			}
		}
	}

	String needsfix(String name) {
		name = name.replace("'", "");
		return name;

	}

	String getExt(File current) {
		int end = current.toString().lastIndexOf(".");
		if (end < 0) {
			return "bad";
		}

		String currentString = current.toString();
		String endstring = currentString.substring(end);
		String result = endstring.replace(".", "");
		return result;
	}

	boolean isType(String[] type, String ext) {
		for (String example : type) {

			if (ext.compareTo(example) == 0)
				return true;
		}
		return false;
	}

}
