package com.myexperiments.ward;

public class SQLSelectCode {
	/*
	 * DELETE FROM ward.files WHERE id NOT IN (SELECT * FROM (SELECT MAX(n.id) FROM
	 * ward.files n GROUP BY CRC64) x)
	 * 
	 */
}
