package com.dais.metadata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.dais.common.app.ApplicationUtil;

@Service("metadata")
@Lazy(value=false)
public class MetadataFactory {
	private static Map<String, ClassMetadata> entities;
	private static Map<String, HashMap<String, MetaField>> entities_list=new HashMap<String, HashMap<String,MetaField>>();
	@PostConstruct
	public void initEntityFields(){
		SessionFactory sessionFactory=(SessionFactory)ApplicationUtil.getService("sessionFactory");
		entities= sessionFactory.getAllClassMetadata();
		
		for(Map.Entry<String, ClassMetadata> entry:entities.entrySet()){
			ClassMetadata classMetadata=entry.getValue();
			String [] pros=classMetadata.getPropertyNames();
			
			HashMap<String, MetaField> fields=new HashMap<String, MetaField>();
			entities_list.put(classMetadata.getMappedClass().getSimpleName(), fields);
			for(String pro:pros){
				MetaField metaField=new MetaField();
				metaField.setFieldName(pro);
				metaField.setEntityClass(classMetadata.getMappedClass());
				metaField.setType(classMetadata.getPropertyType(pro).getReturnedClass());
				
				fields.put(pro, metaField);
			//	metaField.setColumnName(classMetadata.get);
			}
		}
		
		System.out.println("");
	}
	@PreDestroy
	public void preDestroy(){
		entities.clear();
	}
	
	public static HashMap<String, MetaField> getEntityField(String name){
		return entities_list.get(name);
	}
}
