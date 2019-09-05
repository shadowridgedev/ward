package com.myexperiments.ward;

import org.mapdb.*;
import org.mapdb.HTreeMap.KeySet;
import org.mapdb.DBMaker;
import de.citec.scie.ner.db.mapdb.MapDBDatabase;

public class WardDB {
	public HTreeMap<Integer, Book> map;
	public DB db;
	public MapDBDatabase db1;
	private DBMaker maker;

	WardDB(Prop prop) {

		DBMaker.fileDB(prop.getFiledb());

		/*
		 * 
		 * 
		 * 
		 * HTreeMap<String, Long> map = db.hashMap("name_of_map")
		 * .keySerializer(Serializer.STRING) .valueSerializer(Serializer.LONG)
		 * .create();
		 * 
		 * //or shorter form HTreeMap<String, Long> map2 = db .hashMap("some_other_map",
		 * Serializer.STRING, Serializer.LONG) .create();
		 */
//				DBMaker DBMaker. = DBMaker.fileDB(prop.filedb).make());
//		HTreeMap<Integer, Book> map = (HTreeMap<Integer, Book>) db.hashMap("map").createOrOpen();
	}
}
