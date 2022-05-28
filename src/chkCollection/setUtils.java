package chkCollection;

import java.io.FileReader;
import java.util.Properties;

import QueryAPI530.Search;

public class setUtils {

	//Properties 파일을 읽어 searchVO 객체 값 세팅
	public searchVO setProperties(String propertiesFile) throws Exception{
		Properties properties = new Properties();
		properties.load(new FileReader(propertiesFile));

		searchVO searchvo = new searchVO();

		searchvo.setIP((String)properties.get("IP"));
		searchvo.setPort(Integer.parseInt(properties.get("PORT").toString()));
		searchvo.setCollection((String)properties.get("COLLECTION"));
		searchvo.setDocumentField((String)properties.get("DOCUMENTFIELD"));
		searchvo.setSearchField((String)properties.get("SEARCHFIELD"));
		searchvo.setExquery((String)properties.get("EXQUERY"));
		searchvo.setSort((String)properties.get("SORT"));

		return searchvo;
	}

	//검색엔진 세팅
	public Search setEngine(searchVO searchvo){

		Search search = new Search();
		String collection = searchvo.getCollection();

		search.w3SetCodePage("UTF-8");
		search.w3SetQueryLog(1);
		search.w3AddCollection(collection);
		search.w3SetPageInfo(collection, 0, 3);
		search.w3SetQueryAnalyzer(collection, 1, 0, 0, 1);
		search.w3SetSortField(collection, searchvo.getSort());
		search.w3SetRanking(collection, "basic", "rpfmo", 100);
		search.w3SetSearchField(collection, searchvo.getSearchField());
		search.w3SetDocumentField(collection, searchvo.getDocumentField());
		search.w3SetPrefixQuery(collection, searchvo.getExquery(), 1);
		search.w3SetDateRange(collection, "1970/01/01", "2030/12/31");
		search.w3SetCommonQuery(searchvo.getQuery(), 0);
		search.w3ConnectServer(searchvo.getIP(), searchvo.getPort(), 10000);
		search.w3ReceiveSearchQueryResult(3);

		return search;
	}
}