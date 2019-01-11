package gutenberg;

import org.mapdb.*;
import org.mapdb.HTreeMap.KeySet;

import de.citec.scie.ner.db.mapdb.MapDBDatabase;

public class WardDB {
	public HTreeMap<Integer, Book> map;
	public DB db;
	public MapDBDatabase db1;

	WardDB(Prop prop) {

		String fast = prop.filedb;

//				DBMaker DBMaker. = DBMaker.fileDB(prop.filedb).make());
		HTreeMap<Integer, Book> map = (HTreeMap<Integer, Book>) db.hashMap("map").createOrOpen();
	}
}
