package chkCollection;

public class searchVO {

	String IP;
	int port;
	String collection;
	String searchField;
	String documentField;
	String sort;
	String exquery;
	String query;

	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
	public String getSearchField() {
		return searchField;
	}
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	public String getDocumentField() {
		return documentField;
	}
	public void setDocumentField(String documentField) {
		this.documentField = documentField;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getExquery() {
		return exquery;
	}
	public void setExquery(String exquery) {
		this.exquery = exquery;
	}
}