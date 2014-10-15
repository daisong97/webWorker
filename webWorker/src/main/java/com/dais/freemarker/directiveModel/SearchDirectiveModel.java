package com.dais.freemarker.directiveModel;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.dais.metadata.MetaField;
import com.dais.metadata.MetadataFactory;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class SearchDirectiveModel implements TemplateDirectiveModel {

	
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		Writer out = env.getOut();
	    Object entityClass_= params.get("entityClass");
	    String entityClass = (entityClass_==null)?"":entityClass_.toString();
		
		if(isBlank(entityClass)){
			throw new TemplateModelException("entityClass 不能为空！");
		}
		
		/*HashMap<String, MetaField> fields=MetadataFactory.getEntityField(entityClass);
		for(Map.Entry<String, MetaField> entry:fields.entrySet()){
			out.write(entry.getKey());
		}*/
	}

}
