package ${packageName};  
import java.io.Serializable;  
public class ${className} implements Serializable {  
      
     private static final long serialVersionUID = 1L;      
      
    <#list columns as column>  
        private ${column.type.javaType} ${column.fieldName};  
          
        public void set${column.methodName}(${column.type.javaType} ${column.fieldName}){  
            this.${column.fieldName}=${column.fieldName};  
        }  
          
        public ${column.type.javaType} get${column.methodName}(){  
            return ${column.fieldName};  
        }  
          
    </#list>  
  
}  