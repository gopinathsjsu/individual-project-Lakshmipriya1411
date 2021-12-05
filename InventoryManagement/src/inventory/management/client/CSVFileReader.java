package inventory.management.client;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class CSVFileReader {	

	public static Map<String,Map<String,String>> loadInputDataFromCSV(String csvFilePath) throws Exception {
		File file =new File(csvFilePath);
		byte[] bytes=FileUtils.readFileToByteArray(file);		
		String data=new String(bytes);
		
		data=StringUtils.replaceAll(data,"\r", "");
		String[] dataArray=data.split("\n");
		
		String keys=dataArray[0];
		List<String> keysFromFile=new ArrayList<>();
		String keysA=keys.split("/")[0];
		String[] keyArr=keysA.split(",");
		
		keysFromFile.addAll(Arrays.asList(keyArr));
		//System.out.println(dataArray[0]);
		
		Map<String,Map<String,String>> outerMap=new HashMap<>();
		for(int d=1;d<dataArray.length;d++)
		{
			Map<String,String> mp=new HashMap<>();
			List<String> row=new ArrayList<>();
			
			String[] rowArr=dataArray[d].split(",");
			row.addAll(Arrays.asList(rowArr));
			String key=row.get(0);			
			
			for(int i=0;i<keysFromFile.size();i++)
			{
				mp.put(keysFromFile.get(i).trim(), row.get(i).trim());				
			}
			outerMap.put(key,mp);
		}
		return outerMap;
	}

}
