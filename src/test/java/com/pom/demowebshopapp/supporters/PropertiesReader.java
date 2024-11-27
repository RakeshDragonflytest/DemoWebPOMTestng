package com.pom.demowebshopapp.supporters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesReader {
	private String filePath;
	private Properties properties;
	private FileInputStream fileInputStream;
	private String value;
	public PropertiesReader(String filePath) throws IOException 
	{
		this.filePath=filePath;
		fileInputStream=new FileInputStream(filePath);
		properties=new Properties();
		properties.load(fileInputStream);
		
	}
	public String getValue(String key)
	{
		if(properties!=null)
		{
			value=properties.getProperty(key);
		}
		else
		{
			//throw exception
			System.out.println("Properties is pointing to null");
		}
		return value;
	}
	public String getValue(String key,String defaultValue)
	{
		if(properties!=null)
		{
			value=properties.getProperty(key);
			if(value==null)
			{
				value=defaultValue;
			}
		}
		else
		{
			//throw exception
			System.out.println("Properties is pointing to null");
		}
		return value;
	}
	public String getValue(Object key)
	{
		if(properties!=null)
		{
			value=(String) properties.get(key);
		}
		else
		{
			//throw exception
			System.out.println("Properties is pointing to null");
		}
		return value;
	}
	
	public String getValue(Object key,Object defaultValue)
	{
		if(properties!=null)
		{
			value=(String) properties.getOrDefault(key, defaultValue);
			if(value==null)
			{
				value=(String) defaultValue;
			}
		}
		else
		{
			//throw exception
			System.out.println("Properties is pointing to null");
		}
		return value;
	}
	public Set<String> getKeys()
	{
		Set<String> keys=new HashSet<String>();
		if(properties!=null)
		{
			Set setKeys=properties.keySet();
			for(Object object :setKeys)
			{
				String key=(String) object;
				keys.add(key);
			}
		}
		else
		{
			//throw exception
			System.out.println("Properties is pointing to null");
		}
		return keys;
}
	public List<String> getValues()
	{
		List<String> values=new ArrayList<String>();
		Set<String>keys=getKeys();
		if(keys.size()>=1)
		{
			for(String key:keys)
			{
				properties.getProperty(key);
				values.add(value);
			}
		}
		return values;
	}
	public Map<String,String> getKeysValues()
	{
		Map<String,String> mapKeyValues=new HashMap<String,String>();
		Set<String>keys=getKeys();
		for(String key:keys)
		{
			value=properties.getProperty(key);
			mapKeyValues.put(key, value);
			}
		return mapKeyValues;
	}


}
