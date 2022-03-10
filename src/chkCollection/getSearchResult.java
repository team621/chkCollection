package chkCollection;

import QueryAPI530.Search;

public class getSearchResult {

	public String getSearchResult(Search search, searchVO searchvo){

		String result = "";
		String[] docFieldArr = null;
		String collection = searchvo.getCollection();
		int totalCount = search.w3GetResultTotalCount(collection) >= 3 ? 3:search.w3GetResultTotalCount(collection);
		int errorCom = search.w3GetError();
		int errorCol = search.w3GetCollectionError(collection);

		if(searchvo.getDocumentField() != null){
			docFieldArr = searchvo.getDocumentField().split(",");
		}

		result += "[Collection] " + collection +"\n";
		result += "[TotalCount] " + search.w3GetResultTotalCount(collection) +"\n";
		result += "[SearchField] "+ searchvo.getSearchField() +"\n";
		result += "[DocumentField] " + searchvo.getDocumentField() +"\n";

		if(errorCom != 0)
			result += search.w3GetErrorInfo() + "\n";
		else if(errorCol != 0)
			result += "[Error] " + search.w3GetCollectionErrorInfo(collection) + "\n";

		result += "[searchResult бщ]\n";
		String tempResult = "";

		for(int i=0; i<totalCount; i++){
			for(int j=0; j<docFieldArr.length; j++){
				tempResult = search.w3GetField(collection, docFieldArr[j], i);
				result += "<"+docFieldArr[j]+"> " + (tempResult.length() > 100 ? tempResult.substring(0, 100) + "..." : tempResult) + "\n";
			}
		}
		return result;
	}
}