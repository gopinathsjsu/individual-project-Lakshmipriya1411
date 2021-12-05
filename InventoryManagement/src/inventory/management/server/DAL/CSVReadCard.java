package inventory.management.server.DAL;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class CSVReadCard {

	public static Map<String,String> loadCSVForCreditCard(String csvFilePath) throws Exception {		
		File file =new File(csvFilePath);
		byte[] bytes=FileUtils.readFileToByteArray(file);		
		String data=new String(bytes);
		
		data=StringUtils.replaceAll(data,"\r", "");
		String[] dataArray=data.split("\n");
		
		String keys=dataArray[0];
		List<String> keysFromFile=new ArrayList<>();
		String[] keyArr=keys.split(",");
		
		keysFromFile.addAll(Arrays.asList(keyArr));
		keysFromFile.remove(0);
		//System.out.println(dataArray[0]);
		Map<String,String> mp=new HashMap<>();
		for(int d=1;d<dataArray.length;d++)
		{		
			List<String> row=new ArrayList<>();			
			String[] rowArr=dataArray[d].split(",");
			row.addAll(Arrays.asList(rowArr));
			String key=row.get(0);						
			mp.put(key.trim(),key.trim());
		}
		return mp;
	}
}
