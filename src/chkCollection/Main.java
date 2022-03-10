package chkCollection;

import QueryAPI530.Search;

public class Main {

	static setUtils utils = new setUtils();
	static getSearchResult sr = new getSearchResult();

	public static void main(String[] args) throws Exception{

		String searchResult = "";

		//실행 인자가 정상적으로 입력되지 않았을 경우
		if(args.length < 2){
			searchResult += "java -jar chkCollection.jar <properties-file> <query> \n\n";
			searchResult += "properties-file : \n	properties-file path";
			//실행 인자가 정상적으로 입력 되었을 경우
		}else{
			//Properties 파일을 읽어 값을 얻음
			searchVO searchvo = utils.setProperties(args[0]);
			//Query 값은 별도 인자로 받아 설정
			searchvo.setQuery(args[1]);
			//검색엔진 설정
			Search search = utils.setEngine(searchvo);
			//검색 결과 호출
			searchResult = sr.getSearchResult(search,searchvo);
		}
		System.out.println(searchResult);
	}
}


