package org.bit.conn;
//数据字典的建立，垃圾邮件和正常邮件
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
* CREATE TABLE Spam_Dictionary(
* 		Dict_word TEXT UNIQUE NOT NULL,
* 		Dict_frequency INTEGER UNSIGNED NOT NULL;
* );
* 
* CREATE TABLE Normal_Dictionary(
* 		Dict_word TEXT UNIQUE NOT NULL,
* 		Dict_frequency INTEGER UNSIGNED NOT NULL;
* );
* */
public interface DictAccess extends DatabaseAccess{
	
	enum DictDataIndex{BLANK, INDEX_WORD, INDEX_FREQUENCY };
	
	public HashMap<String,Integer> query(boolean tag, boolean isInsert, List<String> wordlist) throws SQLException;
	public int delete(boolean tag,List<String> word) throws SQLException;//minus 1 of frequency
	public int insert(boolean tag,List<String> word) throws SQLException;
	public int createTableDict() throws SQLException;

}
/**
*CREATE TABLE Spam_Dictionary(
*	Dict_ID INTEGER NOT NULL AUTO_INCREMENT,
*	Dict_word TEXT NOT NULL,
*	Dict_frequency INTEGER UNSIGNED NOT NULL,
*	primary key(Dict_ID),
*	index idx_dict(Dict_word(255))
*);
**/
/**
*CREATE TABLE Normal_Dictionary(
*	Dict_ID INTEGER NOT NULL AUTO_INCREMENT,
*	Dict_word TEXT NOT NULL,
*	Dict_frequency INTEGER UNSIGNED NOT NULL,
*	primary key(Dict_ID),
*	index idx_dict(Dict_word(255))
*);
**/
