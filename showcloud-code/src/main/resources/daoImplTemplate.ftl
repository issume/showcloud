package ${packageName};  
  
import org.springframework.stereotype.Repository;  
  
import ${basePath}.dao.${className}Dao;  
import ${basePath}.entity.${className};  
import com.showcloud.dao.impl.BaseDaoImpl;  
  
@Repository  
public class ${className}DaoImpl extends BaseDaoImpl<${className}, String> implements ${className}Dao{  
  
  
}  